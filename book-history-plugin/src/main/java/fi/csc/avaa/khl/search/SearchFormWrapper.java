/**
 * 
 */
package fi.csc.avaa.khl.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.admin.tabs.Reconstructible;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.CompleteVanhatkirjatUtils;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.tools.NumberTools;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.vaadin.customcomponent.HorizontalKeyValueComponent;
import fi.csc.avaa.tools.vaadin.language.LanguageConst;
import fi.csc.avaa.tools.vaadin.language.LanguageTools;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class SearchFormWrapper extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private Translator translator;
	private Translator fiTranslator = new Translator(LanguageConst.LOCALE_FI);
	private LiferayIPC ipc;
	private SearchTools search;
	private Collection<CompleteVanhatkirjat> books;

	private TextField firstSearchInput;
	private NativeSelect firstWildcardFilterInput;
	private NativeSelect firstFieldFilterInput;
	private NativeButton moreSearchButton;
	private OptionGroup booleanInput;
	private TextField secondSearchInput;
	private NativeSelect secondWildcardFilterInput;
	private NativeSelect secondFieldFilterInput;
	private ComboBox municipalityInput;
	private NativeSelect provenceInput;
	private TextField fromYearInput;
	private TextField toYearInput;
	private NativeSelect mappingTargetInput;
	private NativeSelect languageInput;
	private NativeSelect fromLanguageInput;
	private NativeSelect publicationTypeInput;

	private NativeButton clearFormBtn;
	private NativeButton searchBtn;

	private HorizontalKeyValueComponent firstSearchRow;
	private HorizontalKeyValueComponent booleanRow;
	private HorizontalKeyValueComponent secondSearchRow;
	private HorizontalKeyValueComponent municipalityRow;
	private HorizontalKeyValueComponent provenceRow;
	private HorizontalKeyValueComponent yearRow;
	private HorizontalKeyValueComponent mappingTargetRow;
	private HorizontalKeyValueComponent languageRow;
	private HorizontalKeyValueComponent fromLanguageRow;
	private HorizontalKeyValueComponent publicationTypeRow;
	private HorizontalKeyValueComponent collectionRow;

	private String searchCompleteIPCEvent;
	private HorizontalKeyValueComponent buttonRow;
	private Reconstructible reconstructibleContainer;
	private ComboBox collectionInput;
	private boolean isAdmin;

	public SearchFormWrapper(Translator translator, ResultStats stats, LiferayIPC ipc, SearchTools search, Collection<CompleteVanhatkirjat> books, String searchCompleteIPCEvent, Reconstructible reconstructibleContainer, boolean isAdmin) {
		super();
		this.reconstructibleContainer = reconstructibleContainer;
		this.isAdmin = isAdmin;
		setSizeFull();
		setSpacing(true);
		this.translator = translator;
		this.ipc = ipc;
		this.search = search;
		this.books = books;
		this.searchCompleteIPCEvent = searchCompleteIPCEvent;
		buildNewSearchForm();
	}

	@SuppressWarnings("serial")
	private void buildNewSearchForm() {
		removeAllComponents();
		List<String> wildcardFilterIds = Arrays.asList(Const.astWordAstKey, Const.astWordKey, Const.wordAstKey, Const.wordKey, Const.anyWordKey, Const.allWordsKey, Const.hasValueKey);
		List<String> wildcardFilterCaptions = LanguageTools.getTranslatedFieldValueList(translator, Const.astWordAstKey, Const.astWordKey, Const.wordAstKey, Const.wordKey, Const.anyWordKey, Const.allWordsKey, Const.hasValueKey);
		List<String> fieldFilterIds = new ArrayList<String>() {{add(Const.allFieldsKey); add(Const.authorKey); add(Const.titleKey); add(Const.placeOfPrintingKey); add(Const.printingOfficeKey); add(Const.additionalInfoKey); add(Const.signatureKey); add(Const.omisteKey); add(Const.edgeSubscriptionKey);}};
		if(isAdmin) {
			fieldFilterIds.add(Const.emailKey);
		}
		List<String> fieldFilterCaptions = (isAdmin) ?
				LanguageTools.getTranslatedFieldValueList(translator, Const.allFieldsKey, Const.authorKey, Const.titleKey, Const.placeOfPrintingKey, Const.printingOfficeKey, Const.additionalInfoKey, Const.signatureKey, Const.omisteKey, Const.edgeSubscriptionKey, Const.emailKey) :
				LanguageTools.getTranslatedFieldValueList(translator, Const.allFieldsKey, Const.authorKey, Const.titleKey, Const.placeOfPrintingKey, Const.printingOfficeKey, Const.additionalInfoKey, Const.signatureKey, Const.omisteKey, Const.edgeSubscriptionKey);
		HorizontalLayout firstSearchLayout = getHorizontalLayout();
		firstSearchInput = VaadinTools.createTextField(200, null, 0, true, null);
		moreSearchButton = getMoreSearchButton();
		firstWildcardFilterInput = VaadinTools.createNativeSelect(wildcardFilterIds, wildcardFilterCaptions, null, 150);
		firstWildcardFilterInput.setValue(fiTranslator.localize(Const.astWordAstKey));
		firstWildcardFilterInput.setVisible(false);
		firstWildcardFilterInput.addValueChangeListener(e-> {
			if(e.getProperty().getValue().equals(Const.hasValueKey)) {
				firstSearchInput.setEnabled(false);
			}
			else {
				firstSearchInput.setEnabled(true);
			}
		});
		firstFieldFilterInput = VaadinTools.createNativeSelect(fieldFilterIds, fieldFilterCaptions, null, 150);
		firstFieldFilterInput.setValue(fiTranslator.localize(Const.allFieldsKey));
		firstFieldFilterInput.setVisible(false);
		firstSearchLayout.addComponents(firstSearchInput, moreSearchButton, firstWildcardFilterInput, firstFieldFilterInput);

		HorizontalLayout booleanInputLayout = getHorizontalLayout();
		booleanInput = new OptionGroup();
		booleanInput.addStyleName("horizontal-radio-input horizontal");
		booleanInput.addItems(Const.AND, Const.OR, Const.NOT);
		booleanInput.setItemCaption(Const.AND, translator.localize(Const.andKey));
		booleanInput.setItemCaption(Const.OR, translator.localize(Const.orKey));
		booleanInput.setItemCaption(Const.NOT, translator.localize(Const.notKey));
		booleanInput.setNullSelectionAllowed(false);
		booleanInputLayout.addComponent(booleanInput);

		HorizontalLayout secondSearchLayout = getHorizontalLayout();
		secondSearchInput = VaadinTools.createTextField(200, null, 0, true, null);
		secondWildcardFilterInput = VaadinTools.createNativeSelect(wildcardFilterIds, wildcardFilterCaptions, null, 150);
		secondWildcardFilterInput.setValue(fiTranslator.localize(Const.astWordAstKey));
		secondWildcardFilterInput.addValueChangeListener(e-> {
			if(e.getProperty().getValue().equals(Const.hasValueKey)) {
				secondSearchInput.setEnabled(false);
			}
			else {
				secondSearchInput.setEnabled(true);
			}
		});
		secondFieldFilterInput = VaadinTools.createNativeSelect(fieldFilterIds, fieldFilterCaptions, null, 150);
		secondFieldFilterInput.setValue(fiTranslator.localize(Const.allFieldsKey));
		secondSearchLayout.addComponents(secondSearchInput, secondWildcardFilterInput, secondFieldFilterInput);

		HorizontalLayout municipalityInputLayout = getHorizontalLayout();
		municipalityInput = VaadinTools.createComboBox(CompleteVanhatkirjatCache.municipalities, CompleteVanhatkirjatCache.municipalities, translator.localize(Const.allMunicipalitiesKey), translator.localize(Const.allMunicipalitiesKey));
		municipalityInputLayout.addComponent(municipalityInput);

		HorizontalLayout provenceInputLayout = getHorizontalLayout();
		provenceInput = VaadinTools.createNativeSelect(CompleteVanhatkirjatCache.provences, CompleteVanhatkirjatCache.provences, translator.localize(Const.allProvencesKey), 0);
		provenceInputLayout.addComponent(provenceInput);

		municipalityInput.addValueChangeListener(e -> {
			if (e.getProperty().getValue() == null) {
				provenceInput.setEnabled(true);
			} else {
				provenceInput.setEnabled(false);
			}
		});

		provenceInput.addValueChangeListener(e -> {
			if (e.getProperty().getValue() == null) {
				municipalityInput.setEnabled(true);
			} else {
				municipalityInput.setEnabled(false);
			}
		});

		HorizontalLayout yearLayout = getHorizontalLayout();
		fromYearInput = VaadinTools.createTextField(50, null, 4, true, null);
		toYearInput = VaadinTools.createTextField(50, null, 4, true, null);
		yearLayout.addComponents(fromYearInput, new Label("-"), toYearInput);

		HorizontalLayout mappingTargetInputLayout = getHorizontalLayout();
		TreeSet<String> mappingTargets = CompleteVanhatkirjatCache.mappingTargets;
		mappingTargets.add(Const.UNKNOWN_KEY);
		String[] mappingTargetDBValues = mappingTargets.toArray(new String[mappingTargets.size()]);
		mappingTargetInput = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(mappingTargetDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_MAPPINGTARGET, mappingTargetDBValues), translator.localize(Const.allMappingTargetsKey), 0);
		mappingTargetInputLayout.addComponent(mappingTargetInput);

		HorizontalLayout languageInputLayout = getHorizontalLayout();
		TreeSet<String> languages = CompleteVanhatkirjatCache.languages;
		languages.add(Const.UNKNOWN_KEY);
		String[] langDBValues = languages.toArray(new String[languages.size()]);
		languageInput = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(langDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_LANGUAGE, langDBValues), translator.localize(Const.allLanguagesKey), 0);
		languageInputLayout.addComponent(languageInput);

		HorizontalLayout fromLanguageInputLayout = getHorizontalLayout();
		TreeSet<String> fromLanguages = CompleteVanhatkirjatCache.fromLanguages;
		String[] fromLanguageDBValues = fromLanguages.toArray(new String[fromLanguages.size()]);
		fromLanguageInput = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(fromLanguageDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_FROMLANGUAGE, fromLanguageDBValues), translator.localize(Const.allFromLanguagesKey), 0);
		fromLanguageInputLayout.addComponent(fromLanguageInput);

		HorizontalLayout publicationTypeInputLayout = getHorizontalLayout();
		TreeSet<String> publicationTypes = CompleteVanhatkirjatCache.publicationTypes;
		publicationTypes.add(Const.UNKNOWN_KEY);
		String[] publicationTypeDBValues = publicationTypes.toArray(new String[publicationTypes.size()]);
		publicationTypeInput = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(publicationTypeDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_PUBLICATIONTYPE, publicationTypeDBValues), translator.localize(Const.allPublicationTypesKey), 0);
		publicationTypeInputLayout.addComponent(publicationTypeInput);

		HorizontalLayout collectionInputLayout = getHorizontalLayout();
		if (isAdmin) {
			collectionInput = VaadinTools.createComboBox(CompleteVanhatkirjatCache.adminCollections, CompleteVanhatkirjatCache.adminCollections, translator.localize(Const.allCollectionsKey), translator.localize(Const.allCollectionsKey));
		} else {
			collectionInput = VaadinTools.createComboBox(CompleteVanhatkirjatCache.publicCollections, CompleteVanhatkirjatCache.publicCollections, translator.localize(Const.allCollectionsKey), translator.localize(Const.allCollectionsKey));
		}
		collectionInputLayout.addComponent(collectionInput);

		HorizontalLayout formButtonRow = getHorizontalLayout();
		formButtonRow.addStyleName("form-buttons");
		clearFormBtn = getCleanFormButton();
		searchBtn = getSearchButton();
		formButtonRow.addComponents(clearFormBtn, searchBtn);

		firstSearchRow = new HorizontalKeyValueComponent(translator.localize("Search.WordSearch"), 1.0f, firstSearchLayout, 4.0f, true, "", "", null);
		booleanRow = new HorizontalKeyValueComponent("", 1.0f, booleanInputLayout, 4.0f, false, "", "", null);
		secondSearchRow = new HorizontalKeyValueComponent(translator.localize("Search.WordSearch"), 1.0f, secondSearchLayout, 4.0f, true, "", "", null);
		municipalityRow = new HorizontalKeyValueComponent(translator.localize("Search.FromMunicipality"), 1.0f, municipalityInputLayout, 4.0f, true, "", "", null);
		provenceRow = new HorizontalKeyValueComponent(translator.localize("Search.FromProvence"), 1.0f, provenceInputLayout, 4.0f, true, "", "", null);
		yearRow = new HorizontalKeyValueComponent(translator.localize("Search.PublicationYear"), 1.0f, yearLayout, 4.0f, true, "year-search-label", "", FontAwesome.QUESTION_CIRCLE);
		yearRow.getKey().setDescription(translator.localize("Search.PublicationYear.Tooltip"));
		mappingTargetRow = new HorizontalKeyValueComponent(translator.localize("Search.MappingTarget"), 1.0f, mappingTargetInputLayout, 4.0f, true, "", "", null);
		languageRow = new HorizontalKeyValueComponent(translator.localize("Search.Language"), 1.0f, languageInputLayout, 4.0f, true, "", "", null);
		fromLanguageRow = new HorizontalKeyValueComponent(translator.localize("Search.FromLanguage"), 1.0f, fromLanguageInputLayout, 4.0f, true, "", "", null);
		publicationTypeRow = new HorizontalKeyValueComponent(translator.localize("Search.PublicationType"), 1.0f, publicationTypeInputLayout, 4.0f, true, "", "", null);
		collectionRow = new HorizontalKeyValueComponent(translator.localize("Search.FromCollection"), 1.0f, collectionInputLayout, 4.0f, true, "", "", null);
		buttonRow = new HorizontalKeyValueComponent("", 1.0f, formButtonRow, 4.0f, true, "", "", null);

		addComponents(firstSearchRow, municipalityRow, provenceRow, yearRow, mappingTargetRow, languageRow, fromLanguageRow, publicationTypeRow, collectionRow, buttonRow);
	}

	private HorizontalLayout getHorizontalLayout() {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSpacing(true);
		layout.setSizeUndefined();
		layout.setResponsive(true);
		return layout;
	}

	private NativeButton getMoreSearchButton() {
		NativeButton btn = VaadinTools.createNativeButton(translator.localize("Search.More"), FontAwesome.PLUS, null, null);
		btn.addClickListener(e -> {
			expandWordSearchFields();
		});
		return btn;
	}

	private void expandWordSearchFields() {
		firstWildcardFilterInput.setVisible(true);
		firstFieldFilterInput.setVisible(true);
		booleanInput.setValue(Const.AND);
		addComponent(booleanRow, 1);
		addComponent(secondSearchRow, 2);
		moreSearchButton.setVisible(false);
	}

	private NativeButton getCleanFormButton() {
		NativeButton btn = VaadinTools.createNativeButton(translator.localize("Search.Clear"), FontAwesome.TRASH_O, null, null);
		btn.addClickListener(e -> {
			cleanForm();
		});
		return btn;
	}

	private void cleanForm() {
		buildNewSearchForm();
		reconstructibleContainer.clean();
	}

	private NativeButton getSearchButton() {
		NativeButton btn = VaadinTools.createNativeButton(translator.localize("Search.Search"), FontAwesome.SEARCH, null, null);
		btn.setClickShortcut(KeyCode.ENTER);
		btn.addClickListener(e -> {
			reconstructibleContainer.clean();
			int fromYearVal = -1;
			int toYearVal = -1;
			boolean fromYearIsEmpty = true;
			boolean toYearIsEmpty = true;
			if (!StringTools.isEmptyOrNull(fromYearInput.getValue())) {
				fromYearIsEmpty = false;
				if (NumberTools.isInteger(fromYearInput.getValue())) {
					fromYearVal = Integer.parseInt(fromYearInput.getValue());
				}
			}
			if (!StringTools.isEmptyOrNull(toYearInput.getValue())) {
				toYearIsEmpty = false;
				if (NumberTools.isInteger(toYearInput.getValue())) {
					toYearVal = Integer.parseInt(toYearInput.getValue());
				}
			}

			if (fromYearIsEmpty && toYearIsEmpty) {
				search();
			} else if (!fromYearIsEmpty && !toYearIsEmpty) {
				if (fromYearVal == -1 || toYearVal == -1) {
					VaadinTools.showWarning(translator.localize("YearSearch.Error.Format"), null);
				} else {
					search();
				}
			} else if (!fromYearIsEmpty) {
				if (fromYearVal == -1) {
					VaadinTools.showWarning(translator.localize("YearSearch.Error.Format"), null);
				} else {
					search();
				}
			} else if (!toYearIsEmpty) {
				if (toYearVal == -1) {
					VaadinTools.showWarning(translator.localize("YearSearch.Error.Format"), null);
				} else {
					search();
				}
			}
		});
		return btn;
	}

	private void search() {
		QueryBean bean = new QueryBean(false);
		bean.setSearchStr1(firstSearchInput.getValue() == null ? null : firstSearchInput.getValue());
		bean.setSearchStr1WildcardFilter(firstWildcardFilterInput.getValue() == null ? null : firstWildcardFilterInput.getValue().toString());
		bean.setSearchStr1FieldFilter(firstFieldFilterInput.getValue() == null ? null : firstFieldFilterInput.getValue().toString());
		bean.setBooleanOperator(booleanInput.getValue() == null ? null : getBooleanKey(booleanInput.getValue().toString()));
		bean.setSearchStr2(secondSearchInput.getValue() == null ? null : secondSearchInput.getValue());
		bean.setSearchStr2WildcardFilter(secondWildcardFilterInput.getValue() == null ? null : secondWildcardFilterInput.getValue().toString());
		bean.setSearchStr2FieldFilter(secondFieldFilterInput.getValue() == null ? null : secondFieldFilterInput.getValue().toString());
		bean.setMunicipality(municipalityInput.getValue() == null ? null : normalizeMunicipality(municipalityInput.getValue().toString()));
		bean.setProvence(provenceInput.getValue() == null ? null : provenceInput.getValue().toString());
		bean.setFromYear(NumberTools.isInteger(fromYearInput.getValue()) ? Integer.parseInt(fromYearInput.getValue()) : Const.YEAR_NOT_SET);
		bean.setToYear(NumberTools.isInteger(toYearInput.getValue()) ? Integer.parseInt(toYearInput.getValue()) : Const.YEAR_NOT_SET);
		bean.setMappingTarget(mappingTargetInput.getValue() == null ? null : mappingTargetInput.getValue().equals(Const.UNKNOWN_KEY) ? Const.STRING_EMPTY : mappingTargetInput.getValue().toString());
		bean.setLanguage(languageInput.getValue() == null ? null : languageInput.getValue().equals(Const.UNKNOWN_KEY) ? Const.STRING_EMPTY : languageInput.getValue().toString());
		bean.setFromLanguage(fromLanguageInput.getValue() == null ? null : fromLanguageInput.getValue().equals(Const.UNKNOWN_KEY) ? Const.STRING_EMPTY : fromLanguageInput.getValue().toString());
		bean.setPublicationType(publicationTypeInput.getValue() == null ? null : publicationTypeInput.getValue().equals(Const.UNKNOWN_KEY) ? Const.STRING_EMPTY : publicationTypeInput.getValue().toString());
		bean.setCollection(collectionInput.getValue() == null ? null : collectionInput.getValue().toString());

		search.queryData(books, bean, useNewMuncipality());
		ipc.sendEvent(searchCompleteIPCEvent, bean.getFieldsAsString());
	}

	private boolean useNewMuncipality() {
		boolean useNewMunicipality = true;
		if (municipalityInput.getValue() != null) {
			String municipality = municipalityInput.getValue().toString();
			if (municipality.toLowerCase().trim().endsWith(Const.STRING_OLD_MUNICIPALITY_SUFFIX) || !CompleteVanhatkirjatCache.municipalities2014.contains(municipality)) {
				useNewMunicipality = false;
			}
		}
		return useNewMunicipality;
	}

	private String normalizeMunicipality(String municipality) {
		if (municipalityInput != null) {
			if(municipality.toLowerCase().trim().endsWith(Const.STRING_OLD_MUNICIPALITY_SUFFIX)) {
				return municipality.substring(0, municipality.toLowerCase().indexOf(Const.STRING_OLD_MUNICIPALITY_SUFFIX)).trim();
			}
		}
		return municipality;
	}

	private String getBooleanKey(String value) {
		String ret = null;
		switch (value) {
		case (Const.AND):
			ret = Const.andKey;
			break;
		case (Const.OR):
			ret = Const.orKey;
			break;
		case (Const.NOT):
			ret = Const.notKey;
			break;
		}
		return ret;
	}

	public void searchRefresh() {
		search();
	}

	public void populateFields(QueryBean queryBean) {
		if (queryBean.populateSearchFields()) {
			cleanForm();
			boolean setMoreSearch = false;
			if (!Const.STRING_NULL.equals(queryBean.getSearchStr1())) {
				firstSearchInput.setValue(queryBean.getSearchStr1());
			}
			if (!Const.STRING_NULL.equals(queryBean.getSearchStr1WildcardFilter())) {
				firstWildcardFilterInput.select(queryBean.getSearchStr1WildcardFilter());
				setMoreSearch = true;
			}
			if (!Const.STRING_NULL.equals(queryBean.getSearchStr1FieldFilter())) {
				firstFieldFilterInput.setValue(queryBean.getSearchStr1FieldFilter());
				setMoreSearch = true;
			}
			if (!Const.STRING_NULL.equals(queryBean.getSearchStr2())) {
				secondSearchInput.setValue(queryBean.getSearchStr2());
				setMoreSearch = true;
			}
			if (!Const.STRING_NULL.equals(queryBean.getSearchStr2WildcardFilter())) {
				secondWildcardFilterInput.select(queryBean.getSearchStr2WildcardFilter());
				setMoreSearch = true;
			}
			if (!Const.STRING_NULL.equals(queryBean.getSearchStr2FieldFilter())) {
				secondFieldFilterInput.setValue(queryBean.getSearchStr2FieldFilter());
				setMoreSearch = true;
			}
			if (!Const.STRING_NULL.equals(queryBean.getMunicipality())) {
				if (Const.STRING_EMPTY.equals(queryBean.getLanguage())) {
					municipalityInput.select(translator.localize(Const.allMunicipalitiesKey));
				} else {
					municipalityInput.select(queryBean.getMunicipality());
				}
			}
			if (!Const.STRING_NULL.equals(queryBean.getLanguage())) {
				if (Const.STRING_EMPTY.equals(queryBean.getLanguage())) {
					languageInput.select(Const.UNKNOWN_KEY);
				} else {
					languageInput.select(queryBean.getLanguage());
				}
			}
			if (!Const.STRING_NULL.equals(queryBean.getPublicationType())) {
				if (Const.STRING_EMPTY.equals(queryBean.getPublicationType())) {
					publicationTypeInput.select(Const.UNKNOWN_KEY);
				} else {
					publicationTypeInput.select(queryBean.getPublicationType());
				}
			}
			if (!Const.STRING_NULL.equals(queryBean.getMappingTarget())) {
				if (Const.STRING_EMPTY.equals(queryBean.getMappingTarget())) {
					mappingTargetInput.select(Const.UNKNOWN_KEY);
				} else {
					mappingTargetInput.select(queryBean.getMappingTarget());
				}
			}
			if (!Const.STRING_NULL.equals(queryBean.getFromLanguage())) {
				if (Const.STRING_EMPTY.equals(queryBean.getFromLanguage())) {
					fromLanguageInput.select(Const.UNKNOWN_KEY);
				} else {
					fromLanguageInput.select(queryBean.getFromLanguage());
				}
			}
			if (queryBean.getFromYear() != Const.YEAR_NOT_SET) {
				fromYearInput.setValue("" + queryBean.getFromYear());
			}
			if (queryBean.getToYear() != Const.YEAR_NOT_SET) {
				toYearInput.setValue("" + queryBean.getToYear());
			}
			if (setMoreSearch) {
				expandWordSearchFields();
			}
		}
	}
}
