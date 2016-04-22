/**
 * 
 */
package fi.csc.avaa.khl.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.tools.csv.ChooseCSVFieldsWindow;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class VanhatkirjatCSVFieldsWindow extends ChooseCSVFieldsWindow<CompleteVanhatkirjat> {

	private static final long serialVersionUID = 1L;
	private OptionGroup basicInfoOptions;
	private OptionGroup detailedInfoOptions;
	
	/**
	 * @param caption
	 */
	public VanhatkirjatCSVFieldsWindow(Translator translator, Collection<CompleteVanhatkirjat> cvkList) {
		super(translator, cvkList);
	}
	
	@Override
	public void init() {
		VerticalLayout baseLayout = new VerticalLayout();
		baseLayout.addStyleName("modal-layout");
		baseLayout.setWidth(100, Unit.PERCENTAGE);
		baseLayout.setMargin(true);
		
		Label chooseFieldsText = new Label(translator.localize("Application.Csv.ChooseFields"));
		chooseFieldsText.addStyleName("vk-details-header");
		
		basicInfoOptions = new OptionGroup(translator.localize("Application.BookInfo"));
		basicInfoOptions.setMultiSelect(true);
		basicInfoOptions.setImmediate(true);
		basicInfoOptions.setStyleName("vk-field-optiongroup");
		List<String> basicInfoIds = CSVTools.getBasicInfoFieldIds();
		basicInfoOptions.addItems(basicInfoIds);
		basicInfoIds.forEach(id -> basicInfoOptions.setItemCaption(id, translator.localize(id)));
		basicInfoOptions.setValue(basicInfoIds);
		
		detailedInfoOptions = new OptionGroup(translator.localize("Application.BookInfo.Details"));
		detailedInfoOptions.setMultiSelect(true);
		detailedInfoOptions.setImmediate(true);
		detailedInfoOptions.setStyleName("vk-field-optiongroup");
		List<String> detailedInfoIds = CSVTools.getPublicDetailedInfoFieldIds();
		detailedInfoOptions.addItems(detailedInfoIds);
		detailedInfoIds.forEach(id -> detailedInfoOptions.setItemCaption(id, translator.localize(id)));
		detailedInfoOptions.setValue(detailedInfoIds);
		
		CheckBox chooseAllSelection = new CheckBox(translator.localize("Application.Csv.ChooseAllNone"), true);
		chooseAllSelection.setStyleName("choose-all-selection");
		chooseAllSelection.addValueChangeListener(e -> {
			if(e.getProperty().getValue() == Boolean.TRUE) {
				basicInfoOptions.setValue(basicInfoIds);
				detailedInfoOptions.setValue(detailedInfoIds);
			} else {
				basicInfoOptions.setValue(null);
				detailedInfoOptions.setValue(null);
			}
		});
		
		CSVTools csvTools = new CSVTools(translator, false);
		Button downloadCsvBtn = VaadinTools.createButton(translator.localize("Application.Csv"), FontAwesome.DOWNLOAD, null, null);
		FileDownloader downloader = new FileDownloader(new StreamResource(null, "")) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean handleConnectorRequest(VaadinRequest request,
					VaadinResponse response, String path) throws IOException {
				List<String> selectedIds = getSelectedIds();
				setFileDownloadResource(null);
				if(selectedIds.size() > 0) {
					setFileDownloadResource(csvTools.getVanhatkirjatCSVStream(data, selectedIds));
				}
				return super.handleConnectorRequest(request, response, path);
			}
			
		};
		downloader.extend(downloadCsvBtn);
		
		baseLayout.addComponent(chooseFieldsText);
		baseLayout.setComponentAlignment(chooseFieldsText, Alignment.MIDDLE_CENTER);
		baseLayout.addComponent(chooseAllSelection);
		baseLayout.addComponent(basicInfoOptions);
		baseLayout.addComponent(detailedInfoOptions);
		baseLayout.addComponent(downloadCsvBtn);
		baseLayout.setComponentAlignment(downloadCsvBtn, Alignment.MIDDLE_CENTER);
		
		setContent(baseLayout);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getSelectedIds() {
		List<String> allSelectedValues = new ArrayList<>((Set<String>) basicInfoOptions.getValue());
		allSelectedValues.addAll((Set<String>) detailedInfoOptions.getValue());
		return allSelectedValues;
	}
	
}
