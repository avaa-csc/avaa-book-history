/**
 * 
 */
package fi.csc.avaa.khl.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public final class CompleteVanhatkirjatUtils {

	public static String getLocalizedFieldValueFromYearValue(int publicationYearValue, Translator translator) {
//		if(publicationYearValue < Const.YEAR_THRESHOLD) {
//			return translator.localize(Const.notKnownKey);
//		}
		return String.valueOf(publicationYearValue);
	}
	
	public static String getLocalizedFieldValueFromString(String value, String localizationPrefix, Translator translator) {
		if(StringTools.isEmptyOrNull(value)) {
			return translator.localize(Const.notKnownKey);
		}
		return translator.localize(localizationPrefix + value);
	}
	
	public static String getLocalizedBooleanFieldValueForUIFromString(String fieldValue, Translator translator) {
		if(StringTools.isEmptyOrNull(fieldValue)) {
			return translator.localize(Const.notExistKey);
		} else if(Const.BOOLEAN_STRING_TRUE.equals(fieldValue)) {
			return translator.localize(Const.YES_KEY);
		} else if(Const.BOOLEAN_STRING_FALSE.equals(fieldValue)) {
			return translator.localize(Const.NO_KEY);
		}
		return fieldValue;
	}

	public static String getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(int fieldValue, Translator translator) {
		if(fieldValue == 0) {
			return translator.localize(Const.NO_KEY);
		} else if(fieldValue == 1) {
			return translator.localize(Const.YES_KEY);
		} else {
			return translator.localize(Const.notKnownKey);
		}
	}
	
	public static String getLocalizedBooleanFieldValueForCSVFromBooleanLikeIntValue(int fieldValue, Translator translator) {
		if(fieldValue == 0) {
			return Const.BOOLEAN_STRING_FALSE;
		} else if(fieldValue == 1) {
			return Const.BOOLEAN_STRING_TRUE;
		} else {
			return Const.STRING_EMPTY;
		}
	}
	
	public static int getBooleanLikeIntValueFromUIString(String value) {
		int retValue = -1;
		if (value != null) {
			switch (value) {
			case Const.NO_KEY:
				retValue = 0;
				break;
			case Const.YES_KEY:
				retValue = 1;
				break;
			default:
			}
		}
		return retValue;
	}
	
	public static int getBooleanLikeIntValueFromCSVString(String value) {
		int retValue = -1;
		if (value != null) {
			switch (value) {
			case Const.BOOLEAN_STRING_FALSE:
				retValue = 0;
				break;
			case Const.BOOLEAN_STRING_TRUE:
				retValue = 1;
				break;
			default:
			}
		}
		return retValue;
	}

	public static String getStringFromDate(Date date, Translator translator) {
		if(date == null) {
			return translator.localize(Const.notKnownKey);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate lDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return formatter.format(lDate);
	}
	
	public static Date getDateFromString(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		formatter.setLenient(true);
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static TreeSet<String> getAlphabeticallyOrderedStringSet(Translator translator, String localizationPrefix, String...stringKeys) {
		TreeSet<String> set = new TreeSet<>();
		for(String stringKey : stringKeys) {
			set.add(translator.localize(localizationPrefix + stringKey));
		}
		return set;
	}
	
	public static List<String> getTranslations(Translator translator, String localizationPrefix, String...stringKeys) {
		List<String> list = new ArrayList<>();
		for(String stringKey : stringKeys) {
			list.add(translator.localize(localizationPrefix + stringKey));
		}
		return list;
	}
	
	public static Map<Integer, CompleteVanhatkirjat> getListOfPubliclyVisibleCompleteVanhatkirjat() {
		List<Vanhatkirjat> vanhatkirjat = DBTools.getVanhatkirjatByStatuses(Const.STATUS_NOT_WWW_AND_PUBLISHED, Const.STATUS_NOT_WWW_AND_MODIFIED, Const.STATUS_WWW_AND_PUBLISHED, Const.STATUS_WWW_AND_MODIFIED);
		return CompleteVanhatkirjat.convertToCompleteVanhatkirjats(vanhatkirjat);
	}
	
	public static Map<Integer, CompleteVanhatkirjat> getListOfAdminVisibleCompleteVanhatkirjat() {
		List<Vanhatkirjat> vanhatkirjat = DBTools.getAllVanhatkirjat();
		return CompleteVanhatkirjat.convertToCompleteVanhatkirjats(vanhatkirjat);
	}
}
