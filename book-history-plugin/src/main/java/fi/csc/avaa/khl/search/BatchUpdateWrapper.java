package fi.csc.avaa.khl.search;

import java.util.Arrays;
import java.util.List;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.admin.tabs.Reconstructible;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.vaadin.customcomponent.HorizontalKeyValueComponent;
import fi.csc.avaa.tools.vaadin.language.LanguageTools;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

public class BatchUpdateWrapper extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	private Translator translator;
	private SearchTools searchTools;
	private NativeSelect firstFieldSelect;
	private TextField firstFieldCurrentContent;
	private TextField newContent;
	private NativeSelect secondFieldSelect;
	private TextField secondCurrentContentIs;
	private NativeButton searchButton;
	private VerticalLayout resultLayout;
	private NativeButton clearFormButton;
	private LiferayIPC ipc;
	private Reconstructible reconstructibleContainer;

	public BatchUpdateWrapper(LiferayIPC ipc, Translator translator, SearchTools searchTools, Reconstructible reconstructibleContainer) {
		super();
		this.ipc = ipc;
		this.translator = translator;
		this.searchTools = searchTools;
		this.reconstructibleContainer = reconstructibleContainer;
		setSizeFull();
		setSpacing(true);
		buildForm();
		setResponsive(true);
	}

	public void runSearch() {
		search();
	}

	private void buildForm() {
		resultLayout = new VerticalLayout();
		resultLayout.setSpacing(true);
		resultLayout.setSizeFull();

		List<String> fieldFilterIds = Arrays.asList(Const.authorKey, Const.titleKey, Const.publicationYearKey, Const.placeOfPrintingKey, Const.printingOfficeKey, Const.additionalInfoKey, Const.emailKey);
		List<String> fieldFilterCaptions = LanguageTools.getTranslatedFieldValueList(translator, Const.authorKey, Const.titleKey, Const.publicationYearKey, Const.placeOfPrintingKey, Const.printingOfficeKey, Const.additionalInfoKey, Const.emailKey);

		HorizontalLayout firstFieldNameLayout = getHorizontalLayout();
		firstFieldSelect = VaadinTools.createNativeSelect(fieldFilterIds, fieldFilterCaptions, translator.localize(Const.FIELD_CHOOSE_KEY), 150);
		firstFieldNameLayout.addComponent(firstFieldSelect);

		HorizontalLayout firstFieldCurrentContentLayout = getHorizontalLayout();
		firstFieldCurrentContent = VaadinTools.createTextField(200, null, 0, true, null);
		firstFieldCurrentContentLayout.addComponent(firstFieldCurrentContent);

		HorizontalLayout firstFieldNewContentLayout = getHorizontalLayout();
		newContent = VaadinTools.createTextField(200, null, 0, true, null);
		firstFieldNewContentLayout.addComponent(newContent);

		HorizontalLayout secondFieldNameLayout = getHorizontalLayout();
		secondFieldSelect = VaadinTools.createNativeSelect(fieldFilterIds, fieldFilterCaptions, translator.localize(Const.FIELD_CHOOSE_KEY), 150);
		secondFieldNameLayout.addComponent(secondFieldSelect);

		HorizontalLayout secondFieldCurrentContentIs = getHorizontalLayout();
		secondCurrentContentIs = VaadinTools.createTextField(200, null, 0, true, null);
		secondFieldCurrentContentIs.addComponent(secondCurrentContentIs);

		HorizontalLayout formButtonRow = getHorizontalLayout();
		formButtonRow.setSpacing(true);
		formButtonRow.addStyleName("form-buttons");
		clearFormButton = getCleanFormButton();
		searchButton = getSearchButton();
		formButtonRow.addComponents(clearFormButton, searchButton);

		HorizontalKeyValueComponent firstRow = new HorizontalKeyValueComponent(translator.localize("BatchUpdate.FieldName"), 1.0f, firstFieldNameLayout, 4.0f, true, "", "", null);
		HorizontalKeyValueComponent secondRow = new HorizontalKeyValueComponent(translator.localize("BatchUpdate.FieldCurrentContent"), 1.0f, firstFieldCurrentContentLayout, 4.0f, true, "", "", null);
		HorizontalKeyValueComponent thirdRow = new HorizontalKeyValueComponent(translator.localize("BatchUpdate.FieldNewContent"), 1.0f, firstFieldNewContentLayout, 4.0f, true, "", "", null);
		HorizontalKeyValueComponent andRow = new HorizontalKeyValueComponent(translator.localize("BatchUpdate.And"), 1.0f, getHorizontalLayout(), 4.0f, true, "", "", null);
		HorizontalKeyValueComponent fourthRow = new HorizontalKeyValueComponent(translator.localize("BatchUpdate.FieldName"), 1.0f, secondFieldNameLayout, 4.0f, true, "", "", null);
		HorizontalKeyValueComponent fifthRow = new HorizontalKeyValueComponent(translator.localize("BatchUpdate.FieldCurrentContentIs"), 1.0f, secondFieldCurrentContentIs, 4.0f, true, "", "", null);
		HorizontalKeyValueComponent buttonRow = new HorizontalKeyValueComponent("", 1.0f, formButtonRow, 4.0f, true, "", "", null);

		addComponents(firstRow, secondRow, thirdRow, andRow, fourthRow, fifthRow, buttonRow, resultLayout);
	}

	private NativeButton getCleanFormButton() {
		NativeButton btn = VaadinTools.createNativeButton(translator.localize("Search.Clear"), FontAwesome.TRASH_O, null, null);
		btn.addClickListener(e -> {
			removeAllComponents();
			resultLayout.removeAllComponents();
			buildForm();
			reconstructibleContainer.clean();
		});
		return btn;
	}

	private NativeButton getSearchButton() {
		NativeButton createNativeButton = VaadinTools.createNativeButton(translator.localize("Search.Search"), FontAwesome.SEARCH, null, null);
		createNativeButton.addClickListener(e -> {
			search();
		});
		return createNativeButton;
	}

	private void search() {
		if (firstFieldSelect.getValue() == null || StringTools.isEmptyOrNull(newContent.getValue())) {
			VaadinTools.showWarning(translator.localize("BatchUpdate.Error.MissingFields"), null);
		} else {
			String fieldNameId = firstFieldSelect.getValue() == null ? null : firstFieldSelect.getValue().toString();
			String whereFieldNameId = secondFieldSelect.getValue() == null ? null : secondFieldSelect.getValue().toString();
			String fieldNewValue = newContent.getValue();
			searchTools.queryField(CompleteVanhatkirjatCache.getAdminBooksCacheValues(), fieldNameId, firstFieldCurrentContent.getValue(), fieldNewValue, whereFieldNameId, secondCurrentContentIs.getValue());
			ipc.sendEvent(Const.IPC_EVENT_ADMIN_BATCH_UPDATE_SEARCH_COMPLETED, fieldNameId + ",,," + fieldNewValue);
		}
	}

	private HorizontalLayout getHorizontalLayout() {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSpacing(true);
		layout.setSizeUndefined();
		layout.setResponsive(true);
		return layout;
	}
}
