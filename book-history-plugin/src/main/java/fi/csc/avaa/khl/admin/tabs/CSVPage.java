/**
 * 
 */
package fi.csc.avaa.khl.admin.tabs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.csv.CSVTools;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.logging.AvaaLogger;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class CSVPage extends CustomComponent implements Reconstructible {
	
	private static final long serialVersionUID = 1L;
	private static AvaaLogger log = new AvaaLogger(CSVPage.class.getName());
	private VerticalLayout baseLayout;
	private Translator translator;
	private CSVTools csvTools;
	private ByteArrayOutputStream baos;
	
	public CSVPage(Translator translator) {
		baseLayout = new VerticalLayout();
		baseLayout.setMargin(true);
		baseLayout.setSpacing(true);
		this.translator = translator;
		this.csvTools = new CSVTools(this.translator, true);
		baos = new ByteArrayOutputStream();
		
		Label importLabel = new Label(translator.localize("Csv.Import"));
		Upload csvUpload = new Upload(this.translator.localize("Csv.ChooseFile"), new Upload.Receiver() {
			private static final long serialVersionUID = 1L;

			@Override
			public OutputStream receiveUpload(String filename, String mimeType) {
				baos = new ByteArrayOutputStream();
				return baos;
			}
		});
		csvUpload.setButtonCaption(this.translator.localize("Csv.Send"));
		csvUpload.setImmediate(false);
		csvUpload.addSucceededListener(e -> {
			if(!StringTools.isEmptyOrNull(e.getFilename()) && e.getFilename().toLowerCase().endsWith(".csv")) {
				ConfirmDialog.show(UI.getCurrent(), translator.localize("Csv.DeleteAll"), translator.localize("Csv.DeleteAll.Warning"), translator.localize("Csv.Yes"), translator.localize("Csv.No"), new ConfirmDialog.Listener() {
					private static final long serialVersionUID = 1L;
	
					public void onClose(ConfirmDialog dialog) {
		                if (dialog.isConfirmed()) {
		                	handleUploadedCSV(true);
		                }
		                if(dialog.isCanceled()) {
		                	handleUploadedCSV(false);
		                }
		            }
		        });
			}
		});
		csvUpload.addFailedListener(e -> {
			VaadinTools.showError(this.translator.localize("Csv.Error.File"), null);
		});
		
		Label exportLabel = new Label(translator.localize("Csv.Export"));
		Button makeCsvBtn = VaadinTools.createButton(translator.localize("Csv.MakeCsv"), null, null, null);
		
		FileDownloader downloader = new FileDownloader(new StreamResource(null, "")) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean handleConnectorRequest(VaadinRequest request,
					VaadinResponse response, String path) throws IOException {
				setFileDownloadResource(csvTools.getVanhatkirjatCSVStream(CompleteVanhatkirjatCache.getAdminBooksCacheValues(), null));
				return super.handleConnectorRequest(request, response, path);
			}
		};
		downloader.extend(makeCsvBtn);
		baseLayout.addComponents(importLabel, csvUpload, exportLabel, makeCsvBtn);
		
		GridLayout idInfoLayout = new GridLayout(9, 1);
		idInfoLayout.setMargin(true);
		idInfoLayout.setSpacing(true);
		idInfoLayout.setCaption(translator.localize("Application.IdMapping"));
		
		String mappingTargetIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.mappingTargetsId.entrySet()) {
			mappingTargetIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label mappingTargetIdList = new Label(mappingTargetIds);
		mappingTargetIdList.setContentMode(ContentMode.HTML);
		mappingTargetIdList.setCaption(translator.localize("Field.MappingTarget"));
		
		String languageIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.languagesId.entrySet()) {
			languageIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label languageIdList = new Label(languageIds);
		languageIdList.setContentMode(ContentMode.HTML);
		languageIdList.setCaption(translator.localize("Field.Language"));
		
		String fromLanguageIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.fromLanguagesId.entrySet()) {
			fromLanguageIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label fromLanguageIdList = new Label(fromLanguageIds);
		fromLanguageIdList.setContentMode(ContentMode.HTML);
		fromLanguageIdList.setCaption(translator.localize("Field.FromLanguage"));
		
		String pubTypeIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.publicationTypesId.entrySet()) {
			pubTypeIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label pubTypesIdList = new Label(pubTypeIds);
		pubTypesIdList.setContentMode(ContentMode.HTML);
		pubTypesIdList.setCaption(translator.localize("Field.PublicationType"));
		
		String ligatureIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.ligatureTypesId.entrySet()) {
			ligatureIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label ligatureIdList = new Label(ligatureIds);
		ligatureIdList.setContentMode(ContentMode.HTML);
		ligatureIdList.setCaption(translator.localize("Field.Ligature"));
		
		String conditionIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.conditionTypesId.entrySet()) {
			conditionIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label conditionIdList = new Label(conditionIds);
		conditionIdList.setContentMode(ContentMode.HTML);
		conditionIdList.setCaption(translator.localize("Field.Condition"));
		
		String deficiencyIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.deficiencyTypesId.entrySet()) {
			deficiencyIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label deficiencyIdList = new Label(deficiencyIds);
		deficiencyIdList.setContentMode(ContentMode.HTML);
		deficiencyIdList.setCaption(translator.localize("Field.Deficiencies"));
		
		String woliIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.titleFromMunicipalityTypesId.entrySet()) {
			woliIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label woliIdList = new Label(woliIds);
		woliIdList.setContentMode(ContentMode.HTML);
		woliIdList.setCaption(translator.localize("Field.WorksOfLocalInhabitant"));
		
		String municipalityIds = Const.STRING_EMPTY;
		for(Map.Entry<String, Integer> item : CompleteVanhatkirjatCache.municipalitiesId.entrySet()) {
			municipalityIds += item.getKey() + ": " + item.getValue() + "<br>";
		}
		Label municipalityIdList = new Label(municipalityIds);
		municipalityIdList.setContentMode(ContentMode.HTML);
		municipalityIdList.setCaption(translator.localize("Field.Municipality"));

		idInfoLayout.addComponents(mappingTargetIdList, languageIdList, fromLanguageIdList, pubTypesIdList, ligatureIdList, conditionIdList, deficiencyIdList, woliIdList, municipalityIdList);
		baseLayout.addComponent(idInfoLayout);
		setCompositionRoot(baseLayout);
	}
	
	private void handleUploadedCSV(boolean isDeleteAll) {
		List<Integer> addedVkids = csvTools.addVanhatkirjatFromCsvString(baos, isDeleteAll);
		if(addedVkids != null) {
			if(isDeleteAll) {
				if(!CompleteVanhatkirjatCache.syncAllBooksInDatabaseToCaches()) {
					log.error("Unable to sync caches");
				}
			} else {
				for(Integer vkid : addedVkids) {
					if(!CompleteVanhatkirjatCache.syncBookInDatabaseToCaches(vkid, false, false)) {
						log.error("Unable to sync caches with vkid " + vkid);
					}
				}
			}
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean hasPendingModifications() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}
}
