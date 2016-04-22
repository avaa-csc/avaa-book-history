package fi.csc.avaa.khl.csv;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.server.Resource;
import com.vaadin.server.StreamResource;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.CompleteVanhatkirjatUtils;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.DBTools;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.tools.NumberTools;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.csv.SuperCSVDataReader;
import fi.csc.avaa.tools.csv.SuperCSVDataReader.Separator;
import fi.csc.avaa.tools.csv.SuperCSVDataWriter;
import fi.csc.avaa.tools.logging.AvaaLogger;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

public final class CSVTools {

	private static AvaaLogger log = new AvaaLogger(CSVTools.class.getName());
	private Translator translator;
	private boolean isAdmin;
	
	public CSVTools(Translator translator, boolean isAdmin) {
		this.translator = translator;
		this.isAdmin = isAdmin;
	}

	public Resource getVanhatkirjatCSVStream(Collection<CompleteVanhatkirjat> data, List<String> headers) {
		if (data != null && data.size() > 0) {
			return new StreamResource(() -> {
				String output = getCsvContents(data, headers);
				if(output != null) {
					return new ByteArrayInputStream(output.getBytes());
				}
				return new ByteArrayInputStream(Const.STRING_EMPTY.getBytes());
			}, Const.CSV_FILENAME);
		} else {
			log.warn("Nothing to write to csv file");
			return new StreamResource(null, Const.STRING_EMPTY);
		}
	}

	private String getCsvContents(Collection<CompleteVanhatkirjat> data, List<String> headers) {
		if(headers == null) {
			if(isAdmin) {
				headers = getAllAdminInfoFieldIds();
			} else {
				headers = getAllPublicInfoFieldIds();
			}
		}

		List<Map<String, Object>> dataToWrite = new ArrayList<>();
		for (CompleteVanhatkirjat cvk : data) {
			Vanhatkirjat vk = cvk.getVanhatkirjat();
	        final Map<String, Object> rowData = new HashMap<String, Object>();
	        
			rowData.put(Const.authorKey, getValueIfInHeaders(headers, Const.authorKey, StringTools.getStringOrEmptyValue(vk.getTekija())));
			rowData.put(Const.titleKey, getValueIfInHeaders(headers, Const.titleKey, StringTools.getStringOrEmptyValue(vk.getTeoknimi())));
			rowData.put(Const.publicationYearKey, getValueIfInHeaders(headers, Const.publicationYearKey, String.valueOf(vk.getPainovuosi())));
			rowData.put(Const.placeOfPrintingKey, getValueIfInHeaders(headers, Const.placeOfPrintingKey, StringTools.getStringOrEmptyValue(vk.getPainopaikka())));
			rowData.put(Const.printingOfficeKey, getValueIfInHeaders(headers, Const.printingOfficeKey, StringTools.getStringOrEmptyValue(vk.getKirjapaino())));
			if(isAdmin) {
				rowData.put(Const.publicationTypeKey, cvk.getJulkaisulajiinfo() == null ? null : getValueIfInHeaders(headers, Const.publicationTypeKey, StringTools.getIntStringOrEmptyValue(cvk.getJulkaisulajiinfo().getJulklajiid())));
			} else {
				rowData.put(Const.publicationTypeKey, cvk.getJulkaisulajiinfo() == null ? null : getValueIfInHeaders(headers, Const.publicationTypeKey, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromString(StringTools.getStringOrEmptyValue(cvk.getJulkaisulajiinfo().getJulklaji()), Const.PREFIX_PUBLICATIONTYPE, translator)));
			}
			if(isAdmin) {
				rowData.put(Const.languageKey, cvk.getKieliinfo() == null ? null : getValueIfInHeaders(headers, Const.languageKey, StringTools.getIntStringOrEmptyValue(cvk.getKieliinfo().getKieliid())));
			} else {
				rowData.put(Const.languageKey, cvk.getKieliinfo() == null ? null : getValueIfInHeaders(headers, Const.languageKey, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromString(StringTools.getStringOrEmptyValue(cvk.getKieliinfo().getKieli()), Const.PREFIX_LANGUAGE, translator)));
			}
			if(isAdmin) {
				rowData.put(Const.fromLanguageKey, cvk.getKielesta() == null ? null : getValueIfInHeaders(headers, Const.fromLanguageKey, StringTools.getIntStringOrEmptyValue(cvk.getKielesta().getKieliid())));
			} else {
				rowData.put(Const.fromLanguageKey, cvk.getKielesta() == null ? null : getValueIfInHeaders(headers, Const.fromLanguageKey, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromString(StringTools.getStringOrEmptyValue(cvk.getKielesta().getKieli()), Const.PREFIX_FROMLANGUAGE, translator)));
			}
			rowData.put(Const.bookplateKey, getValueIfInHeaders(headers, Const.bookplateKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getExlibris(), translator)));
			rowData.put(Const.priceMarkKey, getValueIfInHeaders(headers, Const.priceMarkKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getHintamerk(), translator)));
			rowData.put(Const.imprimaturKey, getValueIfInHeaders(headers, Const.imprimaturKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getImprimatur(), translator)));
			rowData.put(Const.mapsKey, getValueIfInHeaders(headers, Const.mapsKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getKartat(), translator)));
			if(isAdmin) {
				rowData.put(Const.conditionKey, cvk.getKuntoluokitus() == null ? null : getValueIfInHeaders(headers, Const.conditionKey, StringTools.getIntStringOrEmptyValue(cvk.getKuntoluokitus().getKuntoid())));
			} else {
				rowData.put(Const.conditionKey, cvk.getKuntoluokitus() == null ? null : getValueIfInHeaders(headers, Const.conditionKey, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromString(StringTools.getStringOrEmptyValue(cvk.getKuntoluokitus().getKunto()), Const.PREFIX_CONDITION, translator)));
			}
			rowData.put(Const.illustrationKey, getValueIfInHeaders(headers, Const.illustrationKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getKuvitus(), translator)));
			rowData.put(Const.stampKey, getValueIfInHeaders(headers, Const.stampKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getLeima(), translator)));
			rowData.put(Const.attachmentsKey, getValueIfInHeaders(headers, Const.attachmentsKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getLiitteita(), translator)));
			rowData.put(Const.editionSubscriptionKey, getValueIfInHeaders(headers, Const.editionSubscriptionKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getPainosmerk(), translator)));
			if(isAdmin) {
				rowData.put(Const.deficienciesKey, cvk.getPuute() == null ? null : getValueIfInHeaders(headers, Const.deficienciesKey, StringTools.getIntStringOrEmptyValue(cvk.getPuute().getPuuteid())));
			} else {
				rowData.put(Const.deficienciesKey, cvk.getPuute() == null ? null : getValueIfInHeaders(headers, Const.deficienciesKey, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromString(StringTools.getStringOrEmptyValue(cvk.getPuute().getPuutenimi()), Const.PREFIX_DEFICIENCIES, translator)));
			}
			if(isAdmin) {
				rowData.put(Const.ligatureKey, cvk.getSidottu() == null ? null : getValueIfInHeaders(headers, Const.ligatureKey, StringTools.getIntStringOrEmptyValue(cvk.getSidottu().getSidontaid())));
			} else {
				rowData.put(Const.ligatureKey, cvk.getSidottu() == null ? null : getValueIfInHeaders(headers, Const.ligatureKey, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromString(StringTools.getStringOrEmptyValue(cvk.getSidottu().getSidonta()), Const.PREFIX_LIGATURE, translator)));
			}
			rowData.put(Const.sealKey, getValueIfInHeaders(headers, Const.sealKey, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(vk.getSinetti(), translator)));
			if(isAdmin) {
				rowData.put(Const.worksOfLocalInhabitantKey, cvk.getTeospk() == null ? null : getValueIfInHeaders(headers, Const.worksOfLocalInhabitantKey, StringTools.getIntStringOrEmptyValue(cvk.getTeospk().getTeospkid())));
			} else {
				rowData.put(Const.worksOfLocalInhabitantKey, cvk.getTeospk() == null ? null : getValueIfInHeaders(headers, Const.worksOfLocalInhabitantKey, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromString(StringTools.getStringOrEmptyValue(cvk.getTeospk().getTeospknimi()), Const.PREFIX_WORKS_OF_LOCAL_INHABITANT, translator)));
			}
			rowData.put(Const.signatureKey, getValueIfInHeaders(headers, Const.signatureKey, StringTools.getStringOrEmptyValue(vk.getNimikirj())));
			rowData.put(Const.omisteKey, getValueIfInHeaders(headers, Const.omisteKey, StringTools.getStringOrEmptyValue(vk.getOmiste())));
			rowData.put(Const.edgeSubscriptionKey, getValueIfInHeaders(headers, Const.edgeSubscriptionKey, StringTools.getStringOrEmptyValue(vk.getReunamerk())));
			rowData.put(Const.additionalInfoKey, getValueIfInHeaders(headers, Const.additionalInfoKey, StringTools.getStringOrEmptyValue(vk.getLisatieto())));
			if(isAdmin) {
				rowData.put(Const.mappingTargetKey, cvk.getKartoituskohde() == null ? null : getValueIfInHeaders(headers, Const.mappingTargetKey, StringTools.getIntStringOrEmptyValue(cvk.getKartoituskohde().getKohdeid())));
			} else {
				rowData.put(Const.mappingTargetKey, cvk.getKartoituskohde() == null ? null : getValueIfInHeaders(headers, Const.mappingTargetKey,  CompleteVanhatkirjatUtils.getLocalizedFieldValueFromString(StringTools.getStringOrEmptyValue(cvk.getKartoituskohde().getKartkohde()), Const.PREFIX_MAPPINGTARGET, translator)));
			}
			
			rowData.put(Const.dateKey, getValueIfInHeaders(headers, Const.dateKey, StringTools.getStringOrEmptyFromDate(vk.getPaivays())));
			rowData.put(Const.collectionKey, getValueIfInHeaders(headers, Const.collectionKey, StringTools.getStringOrEmptyValue(vk.getKokoelma())));
			rowData.put(Const.maakuntaKey, cvk.getMaakuntainfo() == null ? null : getValueIfInHeaders(headers, Const.maakuntaKey, StringTools.getStringOrEmptyValue(cvk.getMaakuntainfo().getMaakunta())));
			rowData.put(Const.municipalityKey, cvk.getKuntainfo() == null ? null : getValueIfInHeaders(headers, Const.municipalityKey, StringTools.getStringOrEmptyValue(cvk.getKuntainfo().getCapitalkuntanimi())));
//			rowData.put(Const.municipalityNumberKey, cvk.getKuntainfo() == null ? null : getValueIfInHeaders(headers, Const.municipalityNumberKey, StringTools.getIntStringOrEmptyValue(cvk.getKuntainfo().getKuntano())));
		if(isAdmin) {
			rowData.put(Const.municipalityIdKey, cvk.getKuntainfo() == null ? null : getValueIfInHeaders(headers, Const.municipalityIdKey, StringTools.getIntStringOrEmptyValue(cvk.getKuntainfo().getKuntaid())));
			rowData.put(Const.formNumberKey, getValueIfInHeaders(headers, Const.formNumberKey, StringTools.getIntStringOrEmptyValue(vk.getLomakenum())));
			rowData.put(Const.modifyDateKey, getValueIfInHeaders(headers, Const.modifyDateKey, StringTools.getStringOrEmptyFromDate(vk.getMuokattu())));
			rowData.put(Const.deleteDateKey, getValueIfInHeaders(headers, Const.deleteDateKey, StringTools.getStringOrEmptyFromDate(vk.getPoistettu())));
			rowData.put(Const.emailKey, getValueIfInHeaders(headers, Const.emailKey, StringTools.getStringOrEmptyValue(vk.getLahemail())));
			rowData.put(Const.statusKey, getValueIfInHeaders(headers, Const.statusKey, StringTools.getIntStringOrEmptyValue(vk.getStatus())));
		}
			dataToWrite.add(rowData);
		}
	        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		SuperCSVDataWriter dataWriter = new SuperCSVDataWriter(Separator.SEMICOLON);
		OutputStreamWriter writer = new OutputStreamWriter(baos, StandardCharsets.UTF_8);
		try {
			writer.write('\uFEFF');
		} catch (IOException e) {
			log.error("Unable to write BOM to CSV file");
		}
		if(dataWriter.writeCSVData(new BufferedWriter(writer), dataToWrite, headers, translator)) {
			return new String(baos.toByteArray(), StandardCharsets.UTF_8);
		}
		VaadinTools.showError(translator.localize("Application.Error.ContactAvaa"), null);
		return null;
	}
	
	private String getValueIfInHeaders(List<String> headers, String checkForExistence, String value) {
		if(headers.contains(checkForExistence)) {
			return value;
		}
		return null;
	}
	
	public List<Integer> addVanhatkirjatFromCsvString(ByteArrayOutputStream baos, boolean isDeleteAll) {
		List<Integer> addSuccessVkids = new ArrayList<>();
		List<String> failedCsvRowsAsString = new ArrayList<>();
		List<String> addFailedCsvRowsAsString = new ArrayList<>();
		List<String> headers;
		
		if(isAdmin) {
			headers = getAllAdminInfoFieldIds();
		} else {
			headers = getAllPublicInfoFieldIds();
		}
		
		SuperCSVDataReader dataReader = new SuperCSVDataReader(Separator.SEMICOLON);
		List<Map<String, Object>> newVkRows = dataReader.readCSVData(new ByteArrayInputStream(baos.toByteArray()), headers);
		if(newVkRows == null) {
			VaadinTools.showError(translator.localize("Csv.Error.Save.Csv"), translator.localize("Application.Error.ContactAvaa"));
			return null;
		}
		
		int nextAvailableVkid = isDeleteAll ? 1 : DBTools.getNextAvailableVkidInDatabase();
		log.info("Starting to convert CSV rows to objects and save them to database...");
		boolean isFirstValidVk = true;
		for(Map<String, Object> newVkRow : newVkRows) {
			if(headers.size() != newVkRow.size()) {
				String failMsg = getCsvRowAsString(newVkRow);
				log.error("Wrong amount of items in CSV row. Item amount should be " + headers.size() + ". Skipping the row.");
				log.error(failMsg);
				failedCsvRowsAsString.add(failMsg);
				break;
			}
			
			int status = Const.STATUS_WWW_AND_PUBLISHED;
			if(newVkRow.containsKey(Const.statusKey)) {
				try {
					status = Integer.parseInt(newVkRow.get(Const.statusKey) == null ? null : newVkRow.get(Const.statusKey).toString());
					if(status < 1 || status > 7) {
						String failMsg = getCsvRowAsString(newVkRow);
						log.error("Unable to determine status code in CSV row. Status code must be between 1 and 7 (inclusive). Skipping the row.");
						log.error(failMsg);
						failedCsvRowsAsString.add(failMsg);
						continue;
					}
				} catch (NumberFormatException e) {
					log.error("Status key unavailable in CSV row. Using status code " + status);
				}
			}
			
			Vanhatkirjat newVk = null;
			try {
				newVk = DBTools.getNewVanhatkirjatWithMappedFields(
						nextAvailableVkid,
						newVkRow.get(Const.authorKey) == null ? null : newVkRow.get(Const.authorKey).toString(),
						newVkRow.get(Const.titleKey) == null ? null : newVkRow.get(Const.titleKey).toString(),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.publicationYearKey) == null ? null : newVkRow.get(Const.publicationYearKey).toString()),
						newVkRow.get(Const.placeOfPrintingKey) == null ? null : newVkRow.get(Const.placeOfPrintingKey).toString(),
						newVkRow.get(Const.printingOfficeKey) == null ? null : newVkRow.get(Const.printingOfficeKey).toString(),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.publicationTypeKey) == null ? null : newVkRow.get(Const.publicationTypeKey).toString()),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.languageKey) == null ? null : newVkRow.get(Const.languageKey).toString()),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.fromLanguageKey) == null ? null : newVkRow.get(Const.fromLanguageKey).toString()),
						
						newVkRow.get(Const.bookplateKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.bookplateKey).toString()),
						newVkRow.get(Const.priceMarkKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.priceMarkKey).toString()),
						newVkRow.get(Const.imprimaturKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.imprimaturKey).toString()),
						newVkRow.get(Const.mapsKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.mapsKey).toString()),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.conditionKey) == null ? null : newVkRow.get(Const.conditionKey).toString()),
						newVkRow.get(Const.illustrationKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.illustrationKey).toString()),
						newVkRow.get(Const.stampKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.stampKey).toString()),
						newVkRow.get(Const.attachmentsKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.attachmentsKey).toString()),
						newVkRow.get(Const.editionSubscriptionKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.editionSubscriptionKey).toString()),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.deficienciesKey) == null ? null : newVkRow.get(Const.deficienciesKey).toString()),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.ligatureKey) == null ? null : newVkRow.get(Const.ligatureKey).toString()),
						newVkRow.get(Const.sealKey) == null ? -1 : CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromCSVString(newVkRow.get(Const.sealKey).toString()),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.worksOfLocalInhabitantKey) == null ? null : newVkRow.get(Const.worksOfLocalInhabitantKey).toString()),
						newVkRow.get(Const.signatureKey) == null ? null : newVkRow.get(Const.signatureKey).toString(),
						newVkRow.get(Const.omisteKey) == null ? null : newVkRow.get(Const.omisteKey).toString(),
						newVkRow.get(Const.edgeSubscriptionKey) == null ? null : newVkRow.get(Const.edgeSubscriptionKey).toString(),
						newVkRow.get(Const.additionalInfoKey) == null ? null : newVkRow.get(Const.additionalInfoKey).toString(),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.municipalityIdKey) == null ? null : newVkRow.get(Const.municipalityIdKey).toString()),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.mappingTargetKey) == null ? null : newVkRow.get(Const.mappingTargetKey).toString()),
						NumberTools.getIntOrZeroValue(newVkRow.get(Const.formNumberKey) == null ? null : newVkRow.get(Const.formNumberKey).toString()),
						newVkRow.get(Const.emailKey) == null ? null : newVkRow.get(Const.emailKey).toString(),
						newVkRow.get(Const.collectionKey) == null ? null : newVkRow.get(Const.collectionKey).toString(),
						newVkRow.get(Const.dateKey) == null ? null : CompleteVanhatkirjatUtils.getDateFromString(newVkRow.get(Const.dateKey).toString()),
						newVkRow.get(Const.modifyDateKey) == null ? null : CompleteVanhatkirjatUtils.getDateFromString(newVkRow.get(Const.modifyDateKey).toString()),
						newVkRow.get(Const.deleteDateKey) == null ? null : CompleteVanhatkirjatUtils.getDateFromString(newVkRow.get(Const.deleteDateKey).toString()));
				if(newVk == null) {
					String failMsg = getCsvRowAsString(newVkRow);
					log.error("Unable to create Vanhatkirjat object from CSV row");
					log.error(failMsg);
					failedCsvRowsAsString.add(failMsg);
					break;
				}
				newVk.setStatus(status);
			} catch(NumberFormatException ex) {
				String failMsg = getCsvRowAsString(newVkRow);
				log.error("NumberFormatException in reading the CSV row. Skipping the row.");
				log.error(failMsg);
				failedCsvRowsAsString.add(failMsg);
				break;
			}
			
			if(newVk != null) {
				if(isFirstValidVk && isDeleteAll) {
					isFirstValidVk = false;
					DBTools.deleteAllVanhatkirjatFromDatabase();
				}
				if(DBTools.addVanhatkirjatToDatabase(newVk)) {
					addSuccessVkids.add(newVk.getVkid());
					nextAvailableVkid++;
				} else {
					String failMsg = getCsvRowAsString(newVkRow);
					log.error("Adding vanhatkirjat item to database failed.");
					log.error(failMsg);
					addFailedCsvRowsAsString.add(failMsg);
				}
			}
		}
		log.info("Done!");
		
		if(failedCsvRowsAsString.size() > 0 && failedCsvRowsAsString.size() <= 10) {
			for(String failedCsvRow : failedCsvRowsAsString) {	
				VaadinTools.showError(translator.localize("Csv.Error.SaveItem.Csv"), failedCsvRow);
			}
		} else if(failedCsvRowsAsString.size() > 10) {
			VaadinTools.showError(translator.localize("Csv.Error.Save.Csv"), translator.localize("Application.Error.ContactAvaa"));
		}
		
		if(addFailedCsvRowsAsString.size() > 0 && addFailedCsvRowsAsString.size() <= 10) {
			for(String addFailedCsvRow : addFailedCsvRowsAsString) {	
				VaadinTools.showError(translator.localize("Csv.Error.SaveItem.Db"), addFailedCsvRow);
			}
		} else if(addFailedCsvRowsAsString.size() > 10) {
			VaadinTools.showError(translator.localize("Csv.Error.Save.Db"), translator.localize("Application.Error.ContactAvaa"));
		}
		
		log.info("Successfully added " + addSuccessVkids.size() + " vanhatkirjat entries to database out of " + newVkRows.size() + " CSV rows.");
		VaadinTools.showNotification(translator.localize("Csv.Import"), translator.localize("Csv.Success").replaceFirst("\\?", String.valueOf(addSuccessVkids.size())).replaceFirst("\\?", String.valueOf(newVkRows.size())));
		return addSuccessVkids;
	}
	
	private String getCsvRowAsString(Map<String, Object> csvRow) {
		StringBuilder sb = new StringBuilder();
		sb.append("ROW CONTENTS:\n");
		for(Map.Entry<String, Object> rowEntry : csvRow.entrySet()) {
			sb.append(rowEntry.getKey() + ": " + rowEntry.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}

	public static List<String> getBasicInfoFieldIds() {
		return Arrays.asList(Const.authorKey, Const.titleKey,
				Const.publicationYearKey, Const.placeOfPrintingKey,
				Const.printingOfficeKey);
	}

	public static List<String> getPublicDetailedInfoFieldIds() {
		return Arrays.asList(Const.publicationTypeKey, Const.languageKey,
				Const.fromLanguageKey, Const.bookplateKey, Const.priceMarkKey,
				Const.imprimaturKey, Const.mapsKey, Const.conditionKey,
				Const.illustrationKey, Const.stampKey, Const.attachmentsKey,
				Const.editionSubscriptionKey, Const.deficienciesKey,
				Const.ligatureKey, Const.sealKey,
				Const.worksOfLocalInhabitantKey, Const.signatureKey,
				Const.omisteKey, Const.edgeSubscriptionKey,
				Const.additionalInfoKey, Const.mappingTargetKey,
				Const.dateKey, Const.collectionKey,
				Const.maakuntaKey, Const.municipalityKey); // , Const.municipalityNumberKey
	}
	
	public static List<String> getAdditionalDetailedInfoFieldIdsForAdmin() {
		return Arrays.asList(Const.municipalityIdKey, Const.formNumberKey, Const.modifyDateKey, Const.deleteDateKey, Const.emailKey, Const.statusKey);
	}
	
	public static List<String> getAdminDetailedInfoFieldIds() {
		List<String> headers = new ArrayList<>(getPublicDetailedInfoFieldIds());
		headers.addAll(getAdditionalDetailedInfoFieldIdsForAdmin());
		return headers;
	}

	public static List<String> getAllPublicInfoFieldIds() {
		List<String> headers = new ArrayList<>(getBasicInfoFieldIds());
		headers.addAll(getPublicDetailedInfoFieldIds());
		return headers;
	}
	
	public static List<String> getAllAdminInfoFieldIds() {
		List<String> headers = new ArrayList<>(getBasicInfoFieldIds());
		headers.addAll(getAdminDetailedInfoFieldIds());
		return headers;
	}
}
