/**
 * 
 */
package fi.csc.avaa.khl.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.search.Searcher;

/**
 * @author jmlehtin
 *
 */
public final class SearchTools extends Searcher<CompleteVanhatkirjat, QueryBean> {
	private boolean isAdmin;
	boolean useNewMunicipality;

	public SearchTools(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public void queryData(Collection<CompleteVanhatkirjat> searchDataset, QueryBean queryParams, boolean useNewMunicipality) {
		this.useNewMunicipality = useNewMunicipality;
		queryData(searchDataset, queryParams);
	}
	
	public void queryData(Collection<CompleteVanhatkirjat> searchDataset, QueryBean queryParams) {
		if(queryParams != null && searchDataset != null) {
			String searchStr1 = queryParams.getSearchStr1();
			String searchStr1Filter1 = queryParams.getSearchStr1WildcardFilter();
			String searchStr1Filter2 = queryParams.getSearchStr1FieldFilter();
			String booleanOperator = queryParams.getBooleanOperator();
			String searchStr2 = queryParams.getSearchStr2();
			String searchStr2Filter1 = queryParams.getSearchStr2WildcardFilter();
			String searchStr2Filter2 = queryParams.getSearchStr2FieldFilter();
			String municipality = queryParams.getMunicipality();
			String provence = queryParams.getProvence();
			int fromYear = queryParams.getFromYear();
			int toYear = queryParams.getToYear();
			String mappingTarget = queryParams.getMappingTarget();
			String language = queryParams.getLanguage();
			String fromLanguage = queryParams.getFromLanguage();
			String publicationType = queryParams.getPublicationType();
			String collection = queryParams.getCollection();
			
			Predicate<CompleteVanhatkirjat> vkFilter = new Predicate<CompleteVanhatkirjat>() {

				@Override
				public boolean test(CompleteVanhatkirjat t) {
					if (!StringTools.isNull(collection) && !collection.equals(t.getVanhatkirjat().getKokoelma())) {
						return false;
					}
					if (!StringTools.isNull(publicationType) && !publicationType.equals(t.getJulkaisulajiinfo() == null ? Const.STRING_EMPTY : t.getJulkaisulajiinfo().getJulklaji())) {
						return false;
					}
					if (!StringTools.isNull(fromLanguage)) {
						if(fromLanguage.equals("Ei-tiedossa")) {
							if(t.getKielesta() != null && !t.getKielesta().getKieli().equals(fromLanguage)) {
								return false;
							}
						} else {
							if(t.getKielesta() != null) {
								if(!t.getKielesta().getKieli().equals(fromLanguage)) {
									return false;
								}
							} else {
								if(!fromLanguage.equals(Const.STRING_EMPTY)) {
									return false;
								}
							}
						}
					}
					if (!StringTools.isNull(language) && !language.equals(t.getKieliinfo() == null ? Const.STRING_EMPTY : t.getKieliinfo().getKieli())) {
						return false;
					}
					if (!StringTools.isNull(mappingTarget) && !mappingTarget.equals(t.getKartoituskohde() == null ? Const.STRING_EMPTY : t.getKartoituskohde().getKartkohde())) {
						return false;
					}
					if (toYear >= 0 && t.getVanhatkirjat().getPainovuosi() > toYear) {
						return false;
					}
					if (fromYear >= 0 && t.getVanhatkirjat().getPainovuosi() < fromYear) {
						return false;
					}
					if (!StringTools.isNull(provence) && !provence.equals(t.getMaakuntainfo() == null ? Const.STRING_EMPTY : t.getMaakuntainfo().getMaakunta())) {
						return false;
					}
					if (!StringTools.isNull(municipality)) {
						if (useNewMunicipality) {
							if (!municipality.equals(t.getKuntainfo() == null ? Const.STRING_EMPTY : t.getKuntainfo().getKuntanimi_2014())) {
								return false;
							}
						} else {
							if (!municipality.equals(t.getKuntainfo() == null ? Const.STRING_EMPTY : t.getKuntainfo().getCapitalkuntanimi())) {
								return false;
							}
						}
					}

					boolean searchStr1Bool = getStrSearchFieldBoolean(searchStr1, searchStr1Filter1, searchStr1Filter2, t);
					boolean searchStr2Bool = getStrSearchFieldBoolean(searchStr2, searchStr2Filter1, searchStr2Filter2, t);

					if (booleanOperator != null) {
						switch (booleanOperator) {
						case Const.andKey:
							if (!searchStr1Bool || !searchStr2Bool) {
								return false;
							}
							break;
						case Const.orKey:
							if (!searchStr1Bool && !searchStr2Bool) {
								return false;
							}
							break;
						case Const.notKey:
							if (!searchStr1Bool || searchStr2Bool) {
								return false;
							}
							break;
						default:
							log.error("Unknown boolean operator");
							return false;
						}
					} else {
						return searchStr1Bool;
					}
					return true;
				}
			};
			searchResults = searchDataset.stream().filter(vkFilter).collect(Collectors.toList());
		} else {
			searchResults = new ArrayList<>();
		}
	}
		
	public void queryField(Collection<CompleteVanhatkirjat> searchDataset, String fieldToModifyId, String currentFieldValue, String newFieldValue, String whereFieldId, String whereFieldValue) {
		if(searchDataset != null && !StringTools.isEmptyOrNull(fieldToModifyId) && !StringTools.isEmptyOrNull(newFieldValue)) {
			Predicate<CompleteVanhatkirjat> vkFilter = new Predicate<CompleteVanhatkirjat>() {
				
				@Override
				public boolean test(CompleteVanhatkirjat t) {
					if(StringTools.isEmptyOrNull(fieldToModifyId)) {
						return false;
					} else {
						if(StringTools.isEmptyOrNull(newFieldValue)) {
							return false;
						} else {
							if(StringTools.isEmptyOrNull(currentFieldValue)) {
								if(!getStrSearchFieldBoolean(currentFieldValue, Const.astWordAstKey, fieldToModifyId, t)) {
									return false;
								}
							} else {
								String wildcardFilter = getWildcardFilterFromSearchStr(currentFieldValue);
								if(!getStrSearchFieldBoolean(currentFieldValue, wildcardFilter, fieldToModifyId, t)) {
									return false;
								}
							}
							if(!StringTools.isEmptyOrNull(whereFieldId) && !StringTools.isEmptyOrNull(whereFieldValue)) {
								String wildcardFilter = getWildcardFilterFromSearchStr(whereFieldValue);
								if(!getStrSearchFieldBoolean(whereFieldValue, wildcardFilter, whereFieldId, t)) {
									return false;
								}
							}
						}
					}
					return true;
				}
			};
			searchResults = searchDataset.stream().filter(vkFilter).collect(Collectors.toList());
		} else {
			searchResults = new ArrayList<>();
		}
	}
	
	private boolean getStrSearchFieldBoolean(String searchStr, String searchStrWildcardFilter, String searchStrFieldFilter, CompleteVanhatkirjat cvk) {
		
		if(StringTools.isNull(searchStr)) {
			return true;
		}
		
		if(! searchStrWildcardFilter.equals(Const.wordKey)) {
			if(searchStr.contains("*")) {
				searchStr = searchStr.replaceAll("\\*", Const.STRING_EMPTY);
			}
		}
		
		if(StringTools.isNull(searchStrWildcardFilter)) {
			searchStrWildcardFilter = Const.astWordAstKey;
		}
		if(StringTools.isNull(searchStrFieldFilter)) {
			searchStrFieldFilter = Const.allFieldsKey;
		}
		
		return isInField(searchStrFieldFilter, searchStr, searchStrWildcardFilter, cvk);
	}
	
	private boolean isInField(String searchStrFieldFilter, String searchStr, String searchStrWildcardFilter, CompleteVanhatkirjat cvk) {
		Vanhatkirjat vk = cvk.getVanhatkirjat();
		switch (searchStrFieldFilter) {
		case Const.allFieldsKey:
			if(searchFromAllFields(searchStr, searchStrWildcardFilter, cvk)) {
				return true;
			}
			break;
		case Const.authorKey:
 			if(fieldContainsValue(vk.getTekija(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.titleKey:
			if(fieldContainsValue(vk.getTeoknimi(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.publicationYearKey:
			if(fieldContainsIntValue(vk.getPainovuosi(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.placeOfPrintingKey:
			if(fieldContainsValue(vk.getPainopaikka(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.printingOfficeKey:
			if(fieldContainsValue(vk.getKirjapaino(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.additionalInfoKey:
			if(fieldContainsValue(vk.getLisatieto(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.signatureKey:
			if(fieldContainsValue(vk.getNimikirj(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.omisteKey:
			if(fieldContainsValue(vk.getOmiste(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.edgeSubscriptionKey:
			if(fieldContainsValue(vk.getReunamerk(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		case Const.emailKey:
			if(isAdmin && fieldContainsValue(vk.getLahemail(), searchStr, searchStrWildcardFilter)) {
				return true;
			}
			break;
		default:
			log.error("Unknown field filter value: " + searchStrFieldFilter);
			break;
		}
		return false;
	}

	private boolean searchFromAllFields(String searchStr, String searchStrWildcardFilter, CompleteVanhatkirjat cvk) {
		if (kirjaContainsValue(searchStr, searchStrWildcardFilter, cvk)) {
			return true;
		} else {
			int hitCount = 0;
			String[] searchWords = searchStr.split(" ");
			for (int i = 0; i < searchWords.length; i++) {
				if (kirjaContainsValue(searchWords[i], searchStrWildcardFilter, cvk)) {
					if (searchStrWildcardFilter == Const.anyWordKey) {
						return true;
					} else if (searchStrWildcardFilter == Const.allWordsKey) {
						hitCount++;
					}
				}
			}
			if (hitCount == searchWords.length) {
				return true;
			}
		}
		return false;
	}

	private boolean kirjaContainsValue(String searchStr, String searchStrWildcardFilter, CompleteVanhatkirjat cvk) {
		Vanhatkirjat vk = cvk.getVanhatkirjat();
		return fieldContainsValue(vk.getKirjapaino() == null ? Const.STRING_EMPTY : vk.getKirjapaino(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(cvk.getKuntoluokitus() == null ? Const.STRING_EMPTY : cvk.getKuntoluokitus().getKunto(), searchStr, searchStrWildcardFilter) || 
			(isAdmin && (fieldContainsValue(vk.getLahemail() == null ? Const.STRING_EMPTY : vk.getLahemail(), searchStr, searchStrWildcardFilter))) || 
			(isAdmin && (fieldContainsValue(vk.getLahosoite() == null ? Const.STRING_EMPTY : vk.getLahosoite(), searchStr, searchStrWildcardFilter))) || 
			fieldContainsValue(vk.getLisatieto() == null ? Const.STRING_EMPTY : vk.getLisatieto(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(vk.getNimikirj() == null ? Const.STRING_EMPTY : vk.getNimikirj(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(vk.getOmiste() == null ? Const.STRING_EMPTY : vk.getOmiste(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(vk.getPainopaikka() == null ? Const.STRING_EMPTY : vk.getPainopaikka(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(cvk.getPuute() == null ? Const.STRING_EMPTY : cvk.getPuute().getPuutenimi(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(vk.getReunamerk() == null ? Const.STRING_EMPTY : vk.getReunamerk(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(cvk.getSidottu() == null ? Const.STRING_EMPTY : cvk.getSidottu().getSidonta(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(vk.getTekija() == null ? Const.STRING_EMPTY : vk.getTekija(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(vk.getTeoknimi() == null ? Const.STRING_EMPTY : vk.getTeoknimi(), searchStr, searchStrWildcardFilter) || 
			fieldContainsValue(cvk.getTeospk() == null ? Const.STRING_EMPTY : cvk.getTeospk().getTeospknimi(), searchStr, searchStrWildcardFilter);
	}
	
	private boolean fieldContainsIntValue(int fieldValue, String givenValue,
			String searchStrWildcardFilter) {
		int givenValueInt = -1;
		try {
			givenValueInt = Integer.parseInt(givenValue);
		} catch(NumberFormatException e) {
			return false;
		}
		return fieldValue == givenValueInt;
	}

	private boolean fieldContainsValue(String dbValue, String searchStr, String searchStrWildcardFilter) {
		switch (searchStrWildcardFilter) {
		case Const.astWordAstKey:
			return dbValue.toLowerCase().contains(searchStr.toLowerCase());
		case Const.astWordKey:
			return dbValue.toLowerCase().endsWith(searchStr.toLowerCase());
		case Const.wordKey:
	        String regex = searchStr.toLowerCase().replaceAll("\\.", "\\\\.").replaceAll("\\*", "\\.*").replaceAll("\\s+", "\\\\s+");
	        return Pattern.compile(regex).matcher(dbValue.toLowerCase()).matches(); 
	    case Const.wordAstKey:
			return dbValue.toLowerCase().startsWith(searchStr.toLowerCase());
		case Const.anyWordKey:
			return Stream.of(searchStr.split(" ")).anyMatch(word -> dbValue.toLowerCase().contains(word.toLowerCase()));
		case Const.allWordsKey:
			return Stream.of(searchStr.split(" ")).allMatch(word -> dbValue.toLowerCase().contains(word.toLowerCase()));
		case Const.hasValueKey:
			return dbValue.length() > 0 && !dbValue.toLowerCase().equals("false");
		default:
			log.error("Unknown wildcard filter: " + searchStrWildcardFilter);
			break;
		}
		return false;
	}
	
	private String getWildcardFilterFromSearchStr(String searchStr) {
		if(searchStr.startsWith("*") && searchStr.endsWith("*")) {
			return Const.astWordAstKey;
		} else if(searchStr.startsWith("*")) {
			return Const.astWordKey;
		} else if(searchStr.endsWith("*")) {
			return Const.wordAstKey;
		} else {
			return Const.wordKey;
		}
	}
}
