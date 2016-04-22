/**
 * 
 */
package fi.csc.avaa.khl.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.logging.AvaaLogger;
import fi.csc.avaa.tools.search.result.BaseResultStats;

/**
 * @author jmlehtin
 *
 */
public class ResultStats extends BaseResultStats<CompleteVanhatkirjat> {
	
	private AvaaLogger log = new AvaaLogger(ResultStats.class.getName());

	private int totalAuthorAmount = 0;
	private int totalPlaceOfPrintingAmount = 0;
	private Map<String, Integer> originalMunicipalityAmounts = new TreeMap<>();
	private Map<String, Integer> languageAmounts = new TreeMap<>();
	private Map<String, Integer> publicationTypeAmounts = new TreeMap<>();
	private Map<String, Integer> mappingTargetAmounts = new TreeMap<>();
	private Map<Integer, Integer> yearlyAmounts = new TreeMap<>();
	private Map<Character, Map<String, Integer>> authorBookAmountsByLetter = new HashMap<>();
	private Map<String, Map<String, Integer>> mappingTargetAmountsByMunicipality = new HashMap<>();
	private Map<String, Set<String>> newToOriginalMunicipalityMapping = new HashMap<>();
	private Map<Character, Map<String, Integer>> placeOfPrintingBookAmountsByLetter = new HashMap<>();

	private int minRecordedYear = 3000;
	private int maxRecordedYear = 0;
	
	public ResultStats(Collection<CompleteVanhatkirjat> resultList) {
		super(resultList);
		init();
	}
	
	private void populatePlaceOfPrintingStats(CompleteVanhatkirjat cvk) {
		String placeOfPrinting = cvk.getVanhatkirjat().getPainopaikka();
		if(!StringTools.isEmptyOrNull(placeOfPrinting)) {
			Character placeOfPrintingFirstLetter = placeOfPrinting.charAt(0);
			Map<String, Integer> placeOfPrintingAmt = placeOfPrintingBookAmountsByLetter.get(placeOfPrintingFirstLetter);
			if(placeOfPrintingAmt == null) {
				placeOfPrintingAmt = new HashMap<String, Integer>();
			}
			Integer amt = placeOfPrintingAmt.get(placeOfPrinting);
			if (amt == null) {
				totalPlaceOfPrintingAmount++;
				amt = 0;
			}
			placeOfPrintingAmt.put(placeOfPrinting, ++amt);
			placeOfPrintingBookAmountsByLetter.put(placeOfPrintingFirstLetter, placeOfPrintingAmt);
		} else {
			Map<String, Integer> a = placeOfPrintingBookAmountsByLetter.get(Const.EMPTY_STAT_CHAR);
			Integer i = a.get(Const.UNKNOWN_KEY);
			a.put(Const.UNKNOWN_KEY, ++i);
			placeOfPrintingBookAmountsByLetter.put(Const.EMPTY_STAT_CHAR, a);
		}
	}

	private void populateMunicipalityStats(CompleteVanhatkirjat cvk) {
		String originalMunicipality = cvk.getKuntainfo() == null ? null : cvk.getKuntainfo().getCapitalkuntanimi();
		String newMunicipality = cvk.getKuntainfo() == null ? null : cvk.getKuntainfo().getKuntanimi_2014();
		if(!StringTools.isEmptyOrNull(originalMunicipality)) {
			Integer municipalityAmt = originalMunicipalityAmounts.get(originalMunicipality);
			if (municipalityAmt == null) {
				municipalityAmt = 0;
			}
			originalMunicipalityAmounts.put(originalMunicipality, ++municipalityAmt);
			
			Set<String> oldMunicipalitiesList = newToOriginalMunicipalityMapping.get(newMunicipality);
			if (oldMunicipalitiesList == null) {
				oldMunicipalitiesList = new TreeSet<>();
			}
			
			oldMunicipalitiesList.add(originalMunicipality);
			newToOriginalMunicipalityMapping.put(newMunicipality, oldMunicipalitiesList);
		} else {
			Integer i = originalMunicipalityAmounts.get(Const.UNKNOWN_KEY);
			originalMunicipalityAmounts.put(Const.UNKNOWN_KEY, ++i);
		}
	}
	
	private void populateLanguageStats(CompleteVanhatkirjat cvk) {
		String kieli = cvk.getKieliinfo() == null ? null : cvk.getKieliinfo().getKieli();
		if(!StringTools.isEmptyOrNull(kieli)) {
			Integer kieliAmt = languageAmounts.get(kieli);
			if (kieliAmt == null) {
				kieliAmt = 0;
			}
			languageAmounts.put(kieli, ++kieliAmt);
		} else {
			Integer i = languageAmounts.get(Const.UNKNOWN_KEY);
			languageAmounts.put(Const.UNKNOWN_KEY, ++i);
		}
	}
	
	private void populatePublicationTypeStats(CompleteVanhatkirjat cvk) {
		String julkaisulaji = cvk.getJulkaisulajiinfo() == null ? null : cvk.getJulkaisulajiinfo().getJulklaji();
		if(!StringTools.isEmptyOrNull(julkaisulaji)) {
			Integer julklajiAmt = publicationTypeAmounts.get(julkaisulaji);
			if (julklajiAmt == null) {
				julklajiAmt = 0;
			}
			publicationTypeAmounts.put(julkaisulaji, ++julklajiAmt);
		} else {
			Integer i = publicationTypeAmounts.get(Const.UNKNOWN_KEY);
			publicationTypeAmounts.put(Const.UNKNOWN_KEY, ++i);
		}
	}
	
	private void populateMappingTargetStats(CompleteVanhatkirjat cvk) {
		String kartoituskohde = cvk.getKartoituskohde() == null ? null : cvk.getKartoituskohde().getKartkohde();
		String kunta = cvk.getKuntainfo() == null ? null : cvk.getKuntainfo().getCapitalkuntanimi();
		
		if(!StringTools.isEmptyOrNull(kartoituskohde)) {
			Integer kartkohdAmt = mappingTargetAmounts.get(kartoituskohde);
			if (kartkohdAmt == null) {
				kartkohdAmt = 0;
			}
			mappingTargetAmounts.put(kartoituskohde, ++kartkohdAmt);
			
			if(!StringTools.isEmptyOrNull(kunta)) {
				Map<String, Integer> kuntaMappingTargets = mappingTargetAmountsByMunicipality.get(kunta);
				if(kuntaMappingTargets == null) {
					kuntaMappingTargets = new HashMap<String, Integer>();
				}
				Integer amt = kuntaMappingTargets.get(kartoituskohde);
				if (amt == null) {
					amt = 0;
				}
				kuntaMappingTargets.put(kartoituskohde, ++amt);
				mappingTargetAmountsByMunicipality.put(kunta, kuntaMappingTargets);
			}
		} else {
			Integer i = mappingTargetAmounts.get(Const.UNKNOWN_KEY);
			mappingTargetAmounts.put(Const.UNKNOWN_KEY, ++i);
			
			if(!StringTools.isEmptyOrNull(kunta)) {
				Map<String, Integer> kuntaMappingTargets = mappingTargetAmountsByMunicipality.get(kunta);
				if(kuntaMappingTargets == null) {
					kuntaMappingTargets = new HashMap<String, Integer>();
				}
				Integer amt = kuntaMappingTargets.get(Const.UNKNOWN_KEY);
				if (amt == null) {
					amt = 0;
				}
				kuntaMappingTargets.put(Const.UNKNOWN_KEY, ++amt);
				mappingTargetAmountsByMunicipality.put(kunta, kuntaMappingTargets);
			}
		}
	}
	
	private void populateYearlyStats(CompleteVanhatkirjat cvk) {
		Integer year = cvk.getVanhatkirjat().getPainovuosi();
		if(year > 0) {
			Integer yearlyAmt = yearlyAmounts.get(year);
			if (yearlyAmt == null) {
				yearlyAmt = 0;
			}
			yearlyAmounts.put(year, ++yearlyAmt);
		} else {
			Integer i = yearlyAmounts.get(Const.EMPTY_STAT_INT);
			yearlyAmounts.put(Const.EMPTY_STAT_INT, ++i);
		}
		
		if(year > Const.YEAR_THRESHOLD) {
			if(minRecordedYear > year) {
				minRecordedYear = year;
			}
			if(maxRecordedYear < year) {
				maxRecordedYear = year;
			}
		}
	}
	
	private void populateAuthorStats(CompleteVanhatkirjat cvk) {
		String author = cvk.getVanhatkirjat().getTekija();
		if(!StringTools.isEmptyOrNull(author)) {
			Character authorFirstLetter = author.charAt(0);
			Map<String, Integer> authorAmt = authorBookAmountsByLetter.get(authorFirstLetter);
			if(authorAmt == null) {
				authorAmt = new HashMap<String, Integer>();
			}
			Integer amt = authorAmt.get(author);
			if (amt == null) {
				totalAuthorAmount++;
				amt = 0;
			}
			authorAmt.put(author, ++amt);
			authorBookAmountsByLetter.put(authorFirstLetter, authorAmt);
		} else {
			Map<String, Integer> a = authorBookAmountsByLetter.get(Const.EMPTY_STAT_CHAR);
			Integer i = a.get(Const.UNKNOWN_KEY);
			a.put(Const.UNKNOWN_KEY, ++i);
			authorBookAmountsByLetter.put(Const.EMPTY_STAT_CHAR, a);
		}
	}

	public int getTotalAuthorAmount() {
		return totalAuthorAmount;
	}
	
	public int getTotalPlaceOfPrintingAmount() {
		return totalPlaceOfPrintingAmount;
	}
	
	public Map<String, Integer> getLanguageAmounts() {
		return languageAmounts;
	}

	public Map<String, Integer> getPublicationTypeAmounts() {
		return publicationTypeAmounts;
	}

	public Map<String, Integer> getMappingTargetAmounts() {
		return mappingTargetAmounts;
	}

	public Map<Integer, Integer> getYearlyAmounts() {
		return yearlyAmounts;
	}

	public Map<Character, Map<String, Integer>> getAuthorBookAmountsByLetter() {
		return authorBookAmountsByLetter;
	}

	public int getMinRecordedYear() {
		return minRecordedYear;
	}

	public int getMaxRecordedYear() {
		return maxRecordedYear;
	}

	public Map<String, Integer> getMunicipalityAmounts() {
		return originalMunicipalityAmounts;
	}

	public Map<String, Map<String, Integer>> getMappingTargetAmountsByMunicipality() {
		return mappingTargetAmountsByMunicipality;
	}

	public Map<String, Set<String>> getNewToOriginalMunicipalityMapping() {
		return newToOriginalMunicipalityMapping;
	}

	public Map<Character, Map<String, Integer>> getPlaceOfPrintingBookAmountsByLetter() {
		return placeOfPrintingBookAmountsByLetter;
	} 

	@Override
	protected void init() {
		languageAmounts.put(Const.UNKNOWN_KEY, 0);
		publicationTypeAmounts.put(Const.UNKNOWN_KEY, 0);
		mappingTargetAmounts.put(Const.UNKNOWN_KEY, 0);
		yearlyAmounts.put(Const.EMPTY_STAT_INT, 0);
		originalMunicipalityAmounts.put(Const.UNKNOWN_KEY, 0);
		
		for(Character alphabet : Const.ALPHABETS) {
			Map<String, Integer> authorAmt = new TreeMap<>();
			authorBookAmountsByLetter.put(alphabet, authorAmt);
		}
		Map<String, Integer> emptyAuthor = new HashMap<String, Integer>();
		emptyAuthor.put(Const.UNKNOWN_KEY, 0);
		authorBookAmountsByLetter.put(Const.EMPTY_STAT_CHAR, emptyAuthor);
		Map<String, Integer> emptyPlaceOfPrinting = new HashMap<String, Integer>();
		emptyPlaceOfPrinting.put(Const.UNKNOWN_KEY, 0);
		placeOfPrintingBookAmountsByLetter.put(Const.EMPTY_STAT_CHAR, emptyPlaceOfPrinting);
	}

	@Override
	public void populateStats(boolean... whatToPopulate) {
		if(whatToPopulate.length == 7) {
			if(resultList != null) {
				for(CompleteVanhatkirjat cvk : resultList) {
					if(whatToPopulate[0])
						populateLanguageStats(cvk);
					if(whatToPopulate[1])
						populatePublicationTypeStats(cvk);
					if(whatToPopulate[2])
						populateMappingTargetStats(cvk);
					if(whatToPopulate[3])
						populateYearlyStats(cvk);
					if(whatToPopulate[4])
						populateAuthorStats(cvk);
					if(whatToPopulate[5])
						populateMunicipalityStats(cvk);
					if(whatToPopulate[6])
						populatePlaceOfPrintingStats(cvk);				}
			} else {
				log.error("No statistics to be created since there are no objects");
			}
		} else {
			log.error("Wrong amount of booleans when calling populateStats method");
		}
		
	} 
	
	
}
