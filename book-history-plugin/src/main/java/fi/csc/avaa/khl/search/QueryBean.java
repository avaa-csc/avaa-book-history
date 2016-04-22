/**
 * 
 */
package fi.csc.avaa.khl.search;

import java.util.Properties;

import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.search.SearchBean;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public class QueryBean extends SearchBean {

	private String searchStr1;
	private String searchStr1WildcardFilter;
	private String searchStr1FieldFilter;
	private String booleanOperator;
	private String searchStr2;
	private String searchStr2WildcardFilter;
	private String searchStr2FieldFilter;
	private String municipality;
	private String provence;
	private int fromYear;
	private int toYear;
	private String mappingTarget;
	private String language;
	private String fromLanguage;
	private String publicationType;
	private String collection;
	private boolean populateSearchFields;
	
	public QueryBean(boolean populateSearchFields) {
		this.populateSearchFields = populateSearchFields;
		this.fromYear = Const.YEAR_NOT_SET;
		this.toYear = Const.YEAR_NOT_SET;
	}

	public QueryBean(String searchStr1, String searchStr1WildcardFilter,
			String searchStr1FieldFilter, String booleanOperator,
			String searchStr2, String searchStr2WildcardFilter,
			String searchStr2FieldFilter, String municipality, String provence,
			int fromYear, int toYear, String mappingTarget, String language,
			String fromLanguage, String publicationType, String collection, boolean populateSerachFields) {
		this.searchStr1 = searchStr1;
		this.searchStr1WildcardFilter = searchStr1WildcardFilter;
		this.searchStr1FieldFilter = searchStr1FieldFilter;
		this.booleanOperator = booleanOperator;
		this.searchStr2 = searchStr2;
		this.searchStr2WildcardFilter = searchStr2WildcardFilter;
		this.searchStr2FieldFilter = searchStr2FieldFilter;
		this.municipality = municipality;
		this.provence = provence;
		this.fromYear = fromYear;
		this.toYear = toYear;
		this.mappingTarget = mappingTarget;
		this.language = language;
		this.fromLanguage = fromLanguage;
		this.publicationType = publicationType;
		this.collection = collection;
		populateSearchFields = populateSerachFields;
	}
	
	public QueryBean(String filterAsString) {
		Properties properties = StringTools.getStringAsProperties(filterAsString, SEPARATOR, "=");
		this.searchStr1 = properties.getProperty("searchStr1");
		this.searchStr1WildcardFilter = properties.getProperty("searchStr1WildcardFilter");
		this.searchStr1FieldFilter = properties.getProperty("searchStr1FieldFilter");
		this.booleanOperator = properties.getProperty("booleanOperator");
		this.searchStr2 = properties.getProperty("searchStr2");
		this.searchStr2WildcardFilter = properties.getProperty("searchStr2WildcardFilter");
		this.searchStr2FieldFilter = properties.getProperty("searchStr2FieldFilter");
		this.municipality = properties.getProperty("municipality");
		this.provence = properties.getProperty("provence");
		this.fromYear = Integer.parseInt(properties.getProperty("fromYear"));
		this.toYear = Integer.parseInt(properties.getProperty("toYear"));
		this.mappingTarget = properties.getProperty("mappingTarget");
		this.language = properties.getProperty("language");
		this.fromLanguage = properties.getProperty("fromLanguage");
		this.publicationType = properties.getProperty("publicationType");
		this.collection = properties.getProperty("collection");
		this.populateSearchFields = properties.getProperty("populateSearchField").equals("true") ? true: false;
	}

	public String getSearchStr1() {
		return searchStr1;
	}

	public void setSearchStr1(String searchStr1) {
		this.searchStr1 = searchStr1;
	}

	public String getSearchStr1WildcardFilter() {
		return searchStr1WildcardFilter;
	}

	public void setSearchStr1WildcardFilter(String searchStr1WildcardFilter) {
		this.searchStr1WildcardFilter = searchStr1WildcardFilter;
	}

	public String getSearchStr1FieldFilter() {
		return searchStr1FieldFilter;
	}

	public void setSearchStr1FieldFilter(String searchStr1FieldFilter) {
		this.searchStr1FieldFilter = searchStr1FieldFilter;
	}

	public String getBooleanOperator() {
		return booleanOperator;
	}

	public void setBooleanOperator(String booleanOperator) {
		this.booleanOperator = booleanOperator;
	}

	public String getSearchStr2() {
		return searchStr2;
	}

	public void setSearchStr2(String searchStr2) {
		this.searchStr2 = searchStr2;
	}

	public String getSearchStr2WildcardFilter() {
		return searchStr2WildcardFilter;
	}

	public void setSearchStr2WildcardFilter(String searchStr2WildcardFilter) {
		this.searchStr2WildcardFilter = searchStr2WildcardFilter;
	}

	public String getSearchStr2FieldFilter() {
		return searchStr2FieldFilter;
	}

	public void setSearchStr2FieldFilter(String searchStr2FieldFilter) {
		this.searchStr2FieldFilter = searchStr2FieldFilter;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getProvence() {
		return provence;
	}

	public void setProvence(String provence) {
		this.provence = provence;
	}

	public int getFromYear() {
		return fromYear;
	}

	public void setFromYear(int fromYear) {
		this.fromYear = fromYear;
	}

	public int getToYear() {
		return toYear;
	}

	public void setToYear(int toYear) {
		this.toYear = toYear;
	}

	public String getMappingTarget() {
		return mappingTarget;
	}

	public void setMappingTarget(String mappingTarget) {
		this.mappingTarget = mappingTarget;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFromLanguage() {
		return fromLanguage;
	}

	public void setFromLanguage(String fromLanguage) {
		this.fromLanguage = fromLanguage;
	}

	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}
	
	public String getCollection() {
		return collection;
	}
	
	public void setCollection(String collection) {
		this.collection = collection;
	}

	@Override
	public String getFieldsAsString() {
		return "searchStr1=" + searchStr1 + SEPARATOR + "searchStr1WildcardFilter=" + searchStr1WildcardFilter + SEPARATOR + "searchStr1FieldFilter=" + searchStr1FieldFilter + SEPARATOR +
		"booleanOperator=" + booleanOperator + SEPARATOR + "searchStr2=" + searchStr2 + SEPARATOR + "searchStr2WildcardFilter=" + searchStr2WildcardFilter + SEPARATOR +
		"searchStr2FieldFilter=" + searchStr2FieldFilter + SEPARATOR + "municipality=" + municipality + SEPARATOR + "provence=" + provence + SEPARATOR + "fromYear=" + fromYear + SEPARATOR +
		"toYear=" + toYear + SEPARATOR + "mappingTarget=" + mappingTarget + SEPARATOR + "language=" + language + SEPARATOR + "fromLanguage=" + fromLanguage + SEPARATOR +
		"publicationType=" + publicationType + SEPARATOR + "collection=" + collection + SEPARATOR + "populateSearchField=" + populateSearchFields;
	}
	
	public String getFieldsAsTranslatedString(Translator translator) {
		boolean hasEmptySearchStr1 = false, hasEmptySearchStr2 = false;
		if(searchStr1 == null || Const.STRING_EMPTY.equals(searchStr1) || Const.STRING_NULL.equals(searchStr1)) {
			hasEmptySearchStr1 = true;
		}
		if(searchStr2 == null || Const.STRING_EMPTY.equals(searchStr2) || Const.STRING_NULL.equals(searchStr2)) {
			hasEmptySearchStr2 = true;
		}
		return "searchStr1=" + (hasEmptySearchStr1 ? Const.STRING_NULL : searchStr1) + SEPARATOR + "searchStr1WildcardFilter=" + (hasEmptySearchStr1 ? Const.STRING_NULL : translator.localize(searchStr1WildcardFilter)) + SEPARATOR + "searchStr1FieldFilter=" + (searchStr1 == null ? Const.STRING_NULL : translator.localize(searchStr1FieldFilter)) + SEPARATOR +
		"booleanOperator=" + booleanOperator + SEPARATOR + "searchStr2=" + (hasEmptySearchStr2 ? Const.STRING_NULL : searchStr2) + SEPARATOR + "searchStr2WildcardFilter=" + (hasEmptySearchStr2 ? Const.STRING_NULL : translator.localize(searchStr2WildcardFilter)) + SEPARATOR +
		"searchStr2FieldFilter=" + (hasEmptySearchStr2 ? Const.STRING_NULL : translator.localize(searchStr2FieldFilter)) + SEPARATOR + "municipality=" + municipality + SEPARATOR + "provence=" + provence + SEPARATOR + "fromYear=" + fromYear + SEPARATOR +
		"toYear=" + toYear + SEPARATOR + "mappingTarget=" + (Const.STRING_NULL.equals(mappingTarget) || Const.STRING_EMPTY.equals(mappingTarget) ? Const.STRING_NULL : translateIfSet("MappingTarget." + mappingTarget, translator)) + SEPARATOR + "language=" + (Const.STRING_NULL.equals(language) || Const.STRING_EMPTY.equals(language) ? Const.STRING_NULL : translateIfSet("Language." + language, translator)) + SEPARATOR + "fromLanguage=" +  (Const.STRING_NULL.equals(fromLanguage) || Const.STRING_EMPTY.equals(fromLanguage) ? Const.STRING_NULL : translateIfSet("FromLanguage." + fromLanguage, translator)) + SEPARATOR +
		"publicationType=" +  (Const.STRING_NULL.equals(publicationType) || Const.STRING_EMPTY.equals(publicationType) ? Const.STRING_NULL : translateIfSet("PublicationType." + publicationType, translator)) + SEPARATOR + "collection=" + collection + SEPARATOR + "populateSearchField=" + populateSearchFields;
	}

	@Override
	public String getFieldsAsHtml(Translator translator) {
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		String searchString =  (searchStr1 != null && !searchStr1.equals(Const.STRING_NULL)) ? searchStr1: StringTools.escapeForHtml(translator.localize(Const.notSetStrKey));
		sb.append("<tr><td><b>" + translator.localize("Search.WordSearch") + ":</b></td><td>" + searchString + "</td><td>" + translateIfSet(searchStr1WildcardFilter, translator) + "</td><td>" + translateIfSet(searchStr1FieldFilter, translator) + "</td></tr>");
		if (searchStr2 != null && !searchStr2.equals(Const.STRING_NULL) && booleanOperator != null && !booleanOperator.equals(Const.STRING_NULL)) {
			sb.append("<tr><td></td><td>" + translator.localize(booleanOperator) + "</td></tr>");
			sb.append("<tr><td><b>" + translator.localize("Search.WordSearch") + ":</b></td><td>" + searchStr2 + "</td><td>" + translateIfSet(searchStr2WildcardFilter, translator) + "</td><td>" + translateIfSet(searchStr2FieldFilter, translator) + "</td></tr>");
		}
		sb.append("<tr><td><b>" + translator.localize("Search.FromMunicipality") + ":</b></td><td>" + (isProvenceSet() ? "" : translateDefault(municipality, Const.allMunicipalitiesKey, translator)) + "</td></tr>");
		sb.append("<tr><td><b>" + translator.localize("Search.FromProvence") + ":</b></td><td>" + (isMunicipalitySet() ? "" : translateDefault(provence, Const.allProvencesKey, translator)) + "</td></tr>");
		sb.append("<tr><td><b>" + translator.localize("Search.PublicationYear") + ":</b></td><td>" + (fromYear >= 0 ? fromYear : "") + " - " + (toYear >= 0 ? toYear : "") + "</td></tr>");
		sb.append("<tr><td><b>" + translator.localize("Search.MappingTarget") + ":</b></td><td>" + translateIfSetWithPrefix(mappingTarget, "MappingTarget", Const.allMappingTargetsKey, translator) + "</td></tr>");
		sb.append("<tr><td><b>" + translator.localize("Search.Language") + ":</b></td><td>" + translateIfSetWithPrefix(language, "Language", Const.allLanguagesKey, translator) + "</td></tr>");
		sb.append("<tr><td><b>" + translator.localize("Search.FromLanguage") + ":</b></td><td>" + translateIfSetWithPrefix(fromLanguage, "FromLanguage", Const.allFromLanguagesKey, translator) + "</td></tr>");
		sb.append("<tr><td><b>" + translator.localize("Search.PublicationType") + ":</b></td><td>" + translateIfSetWithPrefix(publicationType, "PublicationType", Const.allPublicationTypesKey, translator) + "</td></tr>");
		sb.append("<tr><td><b>" + translator.localize("Search.FromCollection") + ":</b></td><td>" + translateDefault(collection, Const.allCollectionsKey, translator) + "</td></tr>");
		return sb.toString();
	}

	private boolean isMunicipalitySet() {
		return (municipality != null && ! municipality.equals(Const.STRING_NULL));
	}

	private boolean isProvenceSet() {
		return (provence != null && !provence.equals(Const.STRING_NULL));
	}

	private String translateIfSet(String str, Translator translator) {
		return (str != null && !str.equals(Const.STRING_NULL)) ? translator.localize(str) : "";
	}

	private String translateDefault(String str, String defaultStr, Translator translator) {
		return (str != null && !str.equals(Const.STRING_NULL)) ? str : translator.localize(defaultStr);
	}

	private String translateIfSetWithPrefix(String str, String prefix, String defaultStr, Translator translator) {
		return (str != null && !str.equals(Const.STRING_NULL)) ? translator.localize(prefix + "." + str) : translator.localize(defaultStr);
	}

	public boolean populateSearchFields() {
		return populateSearchFields;
	}
}
