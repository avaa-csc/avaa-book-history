/**
 * 
 */
package fi.csc.avaa.khl.common;

/**
 * @author jmlehtin
 *
 */
public final class Const {

	public static final String BOOLEAN_STRING_FALSE = "FALSE";
	public static final String BOOLEAN_STRING_TRUE = "TRUE";
	
	public static final String addressKey = "Field.Address";
	public static final String emailKey = "Field.Email";
	public static final String municipalityInputPrompt = "Search.MunicipalityInputPrompt";
	public static final String allMunicipalitiesKey = "Search.AllMunicipalities";
	public static final String allProvencesKey = "Search.AllProvences";
	public static final String allMappingTargetsKey = "Search.AllMappingTargets";
	public static final String allLanguagesKey = "Search.AllLanguages";
	public static final String allFromLanguagesKey = "Search.AllFromLanguages";
	public static final String allPublicationTypesKey = "Search.AllPublicationTypes";
	public static final String allCollectionsKey = "Search.AllCollections";
	public static final String astWordAstKey = "Search.AstWordAst";
	public static final String astWordKey = "Search.AstWord";
	public static final String wordAstKey = "Search.WordAst";
	public static final String wordKey = "Search.Word";
	public static final String anyWordKey = "Search.Any";
	public static final String allWordsKey = "Search.All";
	public static final String hasValueKey = "Search.HasValue";
	public static final String allFieldsKey = "Search.AllFields";
	public static final String authorKey = "Field.Author";
	public static final String titleKey = "Field.Title";
	public static final String placeOfPrintingKey = "Field.PlaceOfPrinting";
	public static final String printingOfficeKey = "Field.PrintingOffice";
	public static final String additionalInfoKey = "Field.AdditionalInformation";
	public static final String signatureKey = "Field.Signature";
	public static final String omisteKey = "Field.Omiste";
	public static final String edgeSubscriptionKey = "Field.EdgeSubscription";
	public static final String municipalityKey = "Field.Municipality";
	public static final String municipalityNumberKey = "Field.MunicipalityNumber";
	public static final String municipalityIdKey = "Field.MunicipalityID";
	public static final String publicationYearKey = "Field.PublicationYear";
	public static final String notKnownKey = "Field.NotKnown";
	public static final String notExistKey = "Field.NotExist";
	public static final String publicationTypeKey = "Field.PublicationType";
	public static final String languageKey = "Field.Language";
	public static final String fromLanguageKey = "Field.FromLanguage";
	public static final String bookplateKey = "Field.Bookplate";
	public static final String priceMarkKey = "Field.PriceMark";
	public static final String imprimaturKey = "Field.Imprimatur";
	public static final String mapsKey = "Field.Maps";
	public static final String conditionKey = "Field.Condition";
	public static final String illustrationKey = "Field.Illustration";
	public static final String stampKey = "Field.Stamp";
	public static final String attachmentsKey = "Field.Attachments";
	public static final String editionSubscriptionKey = "Field.EditionSubscription";
	public static final String deficienciesKey = "Field.Deficiencies";
	public static final String ligatureKey = "Field.Ligature";
	public static final String sealKey = "Field.Seal";
	public static final String worksOfLocalInhabitantKey = "Field.WorksOfLocalInhabitant";
	public static final String dateKey = "Field.Date";
	public static final String modifyDateKey = "Field.ModifyDate";
	public static final String deleteDateKey = "Field.DeleteDate";
	public static final String formNumberKey = "Field.FormNumber";
	public static final String mappingTargetKey = "Field.MappingTarget";
	public static final String maakuntaKey = "Field.Maakunta";
	public static final String statusKey = "Field.Status";
	public static final String collectionKey = "Field.Collection";
	public static final String andKey = "Search.And";
	public static final String orKey = "Search.Or";
	public static final String notKey = "Search.Not";
	public static final String notSetStrKey = "Search.NotSetStr";

	public static final char[] ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"
			.toCharArray();
	public static final Character EMPTY_STAT_CHAR = '-';
	public static final Integer EMPTY_STAT_INT = 0;

	public static final String UNKNOWN_KEY = "Unknown";
	public static final String PREFIX_LANGUAGE = "Language.";
	public static final String PREFIX_PUBLICATIONTYPE = "PublicationType.";
	public static final String PREFIX_MAPPINGTARGET = "MappingTarget.";
	public static final String PREFIX_FROMLANGUAGE = "FromLanguage.";
	public static final String PREFIX_CONDITION = "Condition.";
	public static final String PREFIX_DEFICIENCIES = "Deficiencies.";
	public static final String PREFIX_LIGATURE = "Ligature.";
	public static final String PREFIX_WORKS_OF_LOCAL_INHABITANT = "WorksOfLocalInhabitant.";
	
	public static final String AND = "AND", OR = "OR", NOT = "NOT";

	public static final String IPC_EVENT_PUBLIC_SEARCH_COMPLETED = "PublicSearchCompleted";
	public static final String IPC_EVENT_ADMIN_MODIFY_SEARCH_COMPLETED = "AdminModifySearchCompleted";
	public static final String IPC_EVENT_ADMIN_BATCH_UPDATE_SEARCH_COMPLETED = "BatchUpdateSearchCompleted";
	public static final String IPC_EVENT_CHANGE_MAP_FILL_TYPE = "changeMapFillType";
	public static final String IPC_EVENT_SEARCH_MUNICIPALITY_MAPPING_TARGETS = "searchMunicipalityMappingTargets";
	public static final String IPC_EVENT_SEARCH_MUNICIPALITY = "searchMunicipality";
	public static final String IPC_EVENT_FILTER_MUNICIPALITY_MAPPING_TARGETS = "filterMunicipalityMappingTargets";
	public static final String IPC_EVENT_FILTER_MUNICIPALITY = "filterMunicipality";
	public static final String IPC_EVENT_RESET_MAP_FILTER = "resetMapFilter";
	
	public static final String IPC_DATA_MUNICIPALITY = "municipality";
	public static final String IPC_DATA_MAPPING_TARGET = "mappingTarget";
	public static final String IPC_DATA_USE_NEW_MUNICIPALITY = "useNewMunicipality";
	
	public static final String STRING_EMPTY = "";
	public static final String STRING_NULL = "null";
	public static final String STRING_OLD_MUNICIPALITY_SUFFIX = "(vanha)";
	public static final int YEAR_THRESHOLD = 500;
	public static final int YEAR_NOT_SET = -1;

	public static final String CSV_FILENAME =  "kirjakartoitus.csv";
	
	public static final String FIELD_CHOOSE_KEY = "Application.AddBook.Choose";
	public static final String FIELD_REQUIRED_KEY = "Application.Field.Required";
	
	public static final int STATUS_NOT_WWW_AND_PUBLISHED = 1;
	public static final int STATUS_NOT_WWW_AND_MODIFIED = 2;
	public static final int STATUS_NOT_WWW_AND_DELETED = 3;
	public static final int STATUS_WWW_AND_UNPUBLISHED = 4;
	public static final int STATUS_WWW_AND_PUBLISHED = 5;
	public static final int STATUS_WWW_AND_MODIFIED = 6;
	public static final int STATUS_WWW_AND_DELETED = 7;
	
	public static final String YES_KEY = "Application.Yes";
	public static final String NO_KEY = "Application.No";
	
	public static final String STR_TRUE = "TRUE";
	public static final String STR_FALSE = "FALSE";
	
	public static final String MAP_DATA_VARIABLE_FRONT_PAGE_MUNICIPALITIES = "frontPageMunicipalities";
	public static final String MAP_DATA_VARIABLE_SEARCH_PAGE_MUNICIPALITIES = "searchPageMunicipalities";
	public static final String MAP_DATA_VARIABLE_FRONT_PAGE_BOOKS = "frontPageBooks";
	public static final String MAP_DATA_VARIABLE_SEARCH_PAGE_BOOKS = "searchPageBooks";
}
