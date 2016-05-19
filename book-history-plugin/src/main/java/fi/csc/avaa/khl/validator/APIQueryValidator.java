package fi.csc.avaa.khl.validator;

public class APIQueryValidator extends BaseValidator {

	public static boolean validateTitleAuthorFromYearPublisedToYearPublished(String title, String author, int from, int to) {
		return (validateStringForSQLQuery(title) && validateStringForSQLQuery(author) && validateIntAsYearForSQLQuery(from) && validateIntAsYearForSQLQuery(to));
	}
	
	public static boolean validateFromYearPublisedToYearPublished(int from, int to){
		return (validateIntAsYearForSQLQuery(from) && validateIntAsYearForSQLQuery(to));
	}
}
