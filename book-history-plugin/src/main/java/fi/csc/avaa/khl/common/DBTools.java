/**
 * 
 */
package fi.csc.avaa.khl.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.db.model.Kuntainfo;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.khl.db.service.KuntainfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.logging.AvaaLogger;

/**
 * @author jmlehtin
 *
 */
public final class DBTools {

	static final AvaaLogger log = new AvaaLogger(DBTools.class.getName());
	
	public static List<Vanhatkirjat> getAllVanhatkirjat() {
		try {
			return VanhatkirjatLocalServiceUtil.getVanhatkirjats(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			log.error("Error fetching all Vanhatkirjat objects");
			e.printStackTrace();
		}
		return null;
	}
	
	public static synchronized boolean modifyFieldsOfAllVanhatkirjat(List<Vanhatkirjat> vksToModify, String fieldToModify, String newFieldValue) {
		for(Vanhatkirjat vk : vksToModify) {
			switch (fieldToModify) {
			case Const.authorKey:
				vk.setTekija(newFieldValue);
				break;
			case Const.titleKey:
				vk.setTeoknimi(newFieldValue);
				break;
			case Const.publicationYearKey:
				int year = 0;
				try {
					year = Integer.parseInt(newFieldValue);
				} catch(NumberFormatException e) {
					log.error("Unable to interpret " + newFieldValue + " as a number");
					return false;
				}
				vk.setPainovuosi(year);
				break;
			case Const.placeOfPrintingKey:
				vk.setPainopaikka(newFieldValue);
				break;
			case Const.printingOfficeKey:
				vk.setKirjapaino(newFieldValue);
				break;
			case Const.additionalInfoKey:
				vk.setLisatieto(newFieldValue);
				break;
			case Const.emailKey:
				vk.setLahemail(newFieldValue);
				break;
			default:
				log.error("This kind of field cannot be modified: " + fieldToModify);
				return false;
			}
			if(!updateVanhatkirjatToDatabaseWithStatus(vk, CompleteVanhatkirjat.getNewModifiedStatus(vk.getStatus()), true, false)) {
				return false; // return if something goes wrong
			}
			else {
				// Jos muokattavien kirjojen määrä nousee useisiin tuhansiin (4000?) olisi nopeampaa synkata koko cache
				CompleteVanhatkirjatCache.syncBookInDatabaseToCaches(vk.getVkid(), false, false);
			}
		}
		return true; //TODO: Pitäisikö tämän olla true vai false jos ei ole yhtään hakutuloksia?
	}

	public static synchronized boolean updateVanhatkirjatToDatabaseWithStatus(Vanhatkirjat vk, int status, boolean setModifiedField, boolean setDeletedField) {
		if(status != -1) {
			vk.setStatus(status);
			if(setModifiedField) {
				vk.setMuokattu(new Date());
			}
			if(setDeletedField) {
				vk.setPoistettu(new Date());
			} else {
				vk.setPoistettu(null);
			}
			try {
				VanhatkirjatLocalServiceUtil.updateVanhatkirjat(vk);
			} catch (SystemException e) {
				log.error("Unable to update Vanhatkirjat entry with vkid " + vk.getVkid());
				e.printStackTrace();
				return false;
			}
			log.info("Successfully updated Vanhatkirjat entry with vkid " + vk.getVkid());
			return true;
		}
		log.error("Status code cannot be -1.. and if it is, it indicates a false state transition has occurred at some point");
		return false;
	}
	
	public static synchronized boolean deleteVanhatkirjatFromDatabase(int vkid) {
		try {
			VanhatkirjatLocalServiceUtil.deleteVanhatkirjat(vkid);
		} catch (PortalException | SystemException e) {
			log.error("Unable to delete vanhatkirjat entry with vkid " + vkid);
			e.printStackTrace();
			return false;
		}
		return true;
	}

/*
	public static synchronized boolean deleteAllNonUnpublishedVanhatkirjatFromDatabase() {
		List<Vanhatkirjat> allVks = getAllVanhatkirjat();
		List<Vanhatkirjat> allUnpublishedVks = allVks.stream().filter(vk -> vk.getStatus() == Const.STATUS_WWW_AND_UNPUBLISHED).collect(Collectors.toList());
		
		if(deleteAllVanhatkirjatFromDatabase()) {
			addBackUnpublishedVanhatkirjatToDatabase(allUnpublishedVks);
			return true;
		}
		return false;
	}
	
	public static synchronized void addBackUnpublishedVanhatkirjatToDatabase(List<Vanhatkirjat> unpublishedVks) {
		log.info("Adding back the unpublished vanhatkirjat entries in to database...");
		int newVkid = 1;
		int addedAmt = 0;
		for(Vanhatkirjat vk : unpublishedVks) {
			vk.setVkid(newVkid);
			if(addVanhatkirjatToDatabase(vk)) {
				addedAmt++;
			} else {
				log.error("Unable to add vanhatkirjat entry to database. title: " + vk.getTeoknimi() + " and author: " + vk.getTekija() + " and publication year: " + vk.getPainovuosi());
			}
			newVkid++;
		}
		log.info("Successfully added " + addedAmt + " unpublished vanhatkirjat entries back to database");
	}

*/
	
	public static synchronized boolean deleteAllVanhatkirjatFromDatabase() {
		log.info("Starting to delete all vanhatkirjat entries from database...");
		try {
			return VanhatkirjatLocalServiceUtil.deleteAllVanhatkirjat();
		} catch (SystemException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Vanhatkirjat getExistingVanhatkirjatWithNewFields(
			int vkid,
			String author,
			String title,
			int publicationYear,
			String placeOfPrinting,
			String printingOffice,
			String publicationType,
			String language,
			String fromLanguage,
			int bookplate,
			int priceMark,
			int imprimatur,
			int maps,
			String condition,
			int illustration,
			int stamp,
			int attachments,
			int editionSubscription,
			String deficiencies,
			String ligature,
			int seal,
			String worksOfLocalInhabitant,
			String signature,
			String ownerOfSubscription,
			String edgeSubscription,
			String additionalInfo,
			String municipality,
			String mappingTarget,
			int formNumber,
			String email,
			String collection,
			Date paivays) {
		
		int kuntaId = 0;
		int maakuntaId = 0;
		try {
			Kuntainfo kInfo = KuntainfoLocalServiceUtil.findByCapitalkuntanimi(municipality);
			kuntaId = kInfo == null ? 0 : kInfo.getKuntaid();
			maakuntaId = kInfo == null ? 0 : kInfo.getMaakuntaid();
		} catch (Exception e1) {
			log.error("Error fetching related objects when starting to build new Vanhatkirjat object");
			return null;
		}
		
		int kartkohdeId = CompleteVanhatkirjatCache.mappingTargetsId.get(mappingTarget) == null ? 0 : CompleteVanhatkirjatCache.mappingTargetsId.get(mappingTarget);
		int julklajiId = CompleteVanhatkirjatCache.publicationTypesId.get(publicationType) == null ? 0 : CompleteVanhatkirjatCache.publicationTypesId.get(publicationType);
		int kielestaId = CompleteVanhatkirjatCache.fromLanguagesId.get(fromLanguage) == null ? 0 : CompleteVanhatkirjatCache.fromLanguagesId.get(fromLanguage);
		int kieliId = CompleteVanhatkirjatCache.languagesId.get(language) == null ? 0 : CompleteVanhatkirjatCache.languagesId.get(language);
		int kuntoId = CompleteVanhatkirjatCache.conditionTypesId.get(condition) == null ? 0 : CompleteVanhatkirjatCache.conditionTypesId.get(condition);
		int puuteId = CompleteVanhatkirjatCache.deficiencyTypesId.get(deficiencies) == null ? 0 : CompleteVanhatkirjatCache.deficiencyTypesId.get(deficiencies);
		int sidontaId = CompleteVanhatkirjatCache.ligatureTypesId.get(ligature) == null ? 0 : CompleteVanhatkirjatCache.ligatureTypesId.get(ligature);
		int teospkId = CompleteVanhatkirjatCache.titleFromMunicipalityTypesId.get(worksOfLocalInhabitant) == null ? 0 : CompleteVanhatkirjatCache.titleFromMunicipalityTypesId.get(worksOfLocalInhabitant);
		
		try {
			Vanhatkirjat vkToModify = VanhatkirjatLocalServiceUtil.getVanhatkirjat(vkid);
			if(vkToModify != null) {
				vkToModify.setExlibris(bookplate);
				vkToModify.setHintamerk(priceMark);
				vkToModify.setImprimatur(imprimatur);
				vkToModify.setJulklajiid(julklajiId);
				vkToModify.setKartat(maps);
				vkToModify.setKartkohde(kartkohdeId);
				vkToModify.setKielestaid(kielestaId);
				vkToModify.setKieliid(kieliId);
				vkToModify.setKirjapaino(printingOffice);
				vkToModify.setKuntaid(kuntaId);
				vkToModify.setKuntoid(kuntoId);
				vkToModify.setKuvitus(illustration);
				vkToModify.setLahemail(email);
				vkToModify.setLeima(stamp);
				vkToModify.setLiitteita(attachments);
				vkToModify.setLisatieto(additionalInfo);
				vkToModify.setLomakenum(formNumber);
				vkToModify.setMaakuntaid(maakuntaId);
				vkToModify.setNimikirj(signature);
				vkToModify.setOmiste(ownerOfSubscription);
				vkToModify.setPainopaikka(placeOfPrinting);
				vkToModify.setPainosmerk(editionSubscription);
				vkToModify.setPainovuosi(publicationYear);
				vkToModify.setPuuteid(puuteId);
				vkToModify.setReunamerk(edgeSubscription);
				vkToModify.setSidonta(sidontaId);
				vkToModify.setSinetti(seal);
				vkToModify.setTekija(author);
				vkToModify.setTeoknimi(title);
				vkToModify.setTeospkid(teospkId);
				vkToModify.setKokoelma(collection);
				vkToModify.setPaivays(paivays == null ? vkToModify.getPaivays() : paivays);
				return vkToModify;
			}
		} catch (SystemException | PortalException ex) {
			log.error("Unable to update vanhatkirjat with id " + vkid + " to database");
			ex.printStackTrace();
		}
		return null;
	}
	
	public static synchronized Vanhatkirjat getNewVanhatkirjatWithFields(
			int vkid,
			String author,
			String title,
			int publicationYear,
			String placeOfPrinting,
			String printingOffice,
			String publicationType,
			String language,
			String fromLanguage,
			int bookplate,
			int priceMark,
			int imprimatur,
			int maps,
			String condition,
			int illustration,
			int stamp,
			int attachments,
			int editionSubscription,
			String deficiencies,
			String ligature,
			int seal,
			String worksOfLocalInhabitant,
			String signature,
			String ownerOfSubscription,
			String edgeSubscription,
			String additionalInfo,
			String municipality,
			String mappingTarget,
			int formNumber,
			String email,
			String collection,
			Date paivays,
			Date modifiedDate,
			Date deletedDate) {
		
		int municipalityId = CompleteVanhatkirjatCache.municipalitiesId.get(municipality) == null ? 0 : CompleteVanhatkirjatCache.municipalitiesId.get(municipality);
		int mappingTargetId = CompleteVanhatkirjatCache.mappingTargetsId.get(mappingTarget) == null ? 0 : CompleteVanhatkirjatCache.mappingTargetsId.get(mappingTarget);
		int publicationTypeId = CompleteVanhatkirjatCache.publicationTypesId.get(publicationType) == null ? 0 : CompleteVanhatkirjatCache.publicationTypesId.get(publicationType);
		int fromLanguageId = CompleteVanhatkirjatCache.fromLanguagesId.get(fromLanguage) == null ? 0 : CompleteVanhatkirjatCache.fromLanguagesId.get(fromLanguage);
		int languageId = CompleteVanhatkirjatCache.languagesId.get(language) == null ? 0 : CompleteVanhatkirjatCache.languagesId.get(language);
		int conditionId = CompleteVanhatkirjatCache.conditionTypesId.get(condition) == null ? 0 : CompleteVanhatkirjatCache.conditionTypesId.get(condition);
		int deficienciesId = CompleteVanhatkirjatCache.deficiencyTypesId.get(deficiencies) == null ? 0 : CompleteVanhatkirjatCache.deficiencyTypesId.get(deficiencies);
		int ligatureId = CompleteVanhatkirjatCache.ligatureTypesId.get(ligature) == null ? 0 : CompleteVanhatkirjatCache.ligatureTypesId.get(ligature);
		int worksOfLocalInhabitantId = CompleteVanhatkirjatCache.titleFromMunicipalityTypesId.get(worksOfLocalInhabitant) == null ? 0 : CompleteVanhatkirjatCache.titleFromMunicipalityTypesId.get(worksOfLocalInhabitant);
		
		if(!StringTools.isEmptyOrNull(email)) {
			return getNewVanhatkirjatWithMappedFields(
					vkid,
					author,
					title,
					publicationYear,
					placeOfPrinting,
					printingOffice,
					publicationTypeId,
					languageId,
					fromLanguageId,
					bookplate,
					priceMark,
					imprimatur,
					maps,
					conditionId,
					illustration,
					stamp,
					attachments,
					editionSubscription,
					deficienciesId,
					ligatureId,
					seal,
					worksOfLocalInhabitantId,
					signature,
					ownerOfSubscription,
					edgeSubscription,
					additionalInfo,
					municipalityId,
					mappingTargetId,
					formNumber,
					email,
					collection,
					paivays,
					modifiedDate,
					deletedDate);
		}
		return null;
	}
	
	public static synchronized Vanhatkirjat getNewVanhatkirjatWithMappedFields(
			int vkid,
			String author,
			String title,
			int publicationYear,
			String placeOfPrinting,
			String printingOffice,
			int publicationTypeId,
			int languageId,
			int fromLanguageId,
			int bookplate,
			int priceMark,
			int imprimatur,
			int maps,
			int conditionId,
			int illustration,
			int stamp,
			int attachments,
			int editionSubscription,
			int deficienciesId,
			int ligatureId,
			int seal,
			int worksOfLocalInhabitantId,
			String signature,
			String ownerOfSubscription,
			String edgeSubscription,
			String additionalInfo,
			int municipalityId,
			int mappingTargetId,
			int formNumber,
			String email,
			String collection,
			Date paivays,
			Date modifiedDate,
			Date deletedDate) {
		
		int maakuntaId = 0;
		try {
			Kuntainfo kInfo = KuntainfoLocalServiceUtil.getKuntainfo(municipalityId);
			maakuntaId = kInfo == null ? 0 : kInfo.getMaakuntaid();
		} catch (Exception e1) {
			log.error("Error fetching related objects when starting to build new Vanhatkirjat object");
			return null;
		}
		
		if(municipalityId > 0) {
			Vanhatkirjat newVk = VanhatkirjatLocalServiceUtil.createVanhatkirjat(vkid);
			if(newVk != null) {
				newVk.setExlibris(bookplate);
				newVk.setHintamerk(priceMark);
				newVk.setImprimatur(imprimatur);
				newVk.setJulklajiid(publicationTypeId);
				newVk.setKartat(maps);
				newVk.setKartkohde(mappingTargetId);
				newVk.setKielestaid(fromLanguageId);
				newVk.setKieliid(languageId);
				newVk.setKirjapaino(printingOffice);
				newVk.setKuntaid(municipalityId);
				newVk.setKuntoid(conditionId);
				newVk.setKuvitus(illustration);
				newVk.setLahemail(email);
				newVk.setLeima(stamp);
				newVk.setLiitteita(attachments);
				newVk.setLisatieto(additionalInfo);
				newVk.setLomakenum(formNumber);
				newVk.setMaakuntaid(maakuntaId);
				newVk.setNimikirj(signature);
				newVk.setOmiste(ownerOfSubscription);
				newVk.setPainopaikka(placeOfPrinting);
				newVk.setPainosmerk(editionSubscription);
				newVk.setPainovuosi(publicationYear);
				newVk.setPuuteid(deficienciesId);
				newVk.setReunamerk(edgeSubscription);
				newVk.setSidonta(ligatureId);
				newVk.setSinetti(seal);
				newVk.setTekija(author);
				newVk.setTeoknimi(title);
				newVk.setTeospkid(worksOfLocalInhabitantId);
				newVk.setKokoelma(collection);
				newVk.setPaivays(paivays);
				newVk.setMuokattu(modifiedDate);
				newVk.setPoistettu(deletedDate);
				return newVk;
			}
		}
		return null;
	}
	
	public static boolean addNewVanhatkirjatToDatabase(Vanhatkirjat vk, int status) {
		vk.setPaivays(new Date());
		vk.setStatus(status);
		try {
			return VanhatkirjatLocalServiceUtil.addVanhatkirjat(vk) != null;
		} catch (SystemException e) {
			log.error("Unable to store vanhatkirjat model to database");
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean addVanhatkirjatToDatabase(Vanhatkirjat vk) {
		try {
			return VanhatkirjatLocalServiceUtil.addVanhatkirjat(vk) != null;
		} catch (SystemException e) {
			log.error("Unable to store vanhatkirjat model to database");
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static synchronized int getNextAvailableVkidInDatabase() {
		DynamicQuery maxVkidQuery = DynamicQueryFactoryUtil.forClass(Vanhatkirjat.class);
		maxVkidQuery.setProjection(ProjectionFactoryUtil.max("vkid"));
		List<Integer> results = null;
		try {
			results = VanhatkirjatLocalServiceUtil.dynamicQuery(maxVkidQuery);
			if(results != null && results.size() == 1) {
				if(results.get(0) == null) {
					throw new SystemException();
				}
				return ((int) results.get(0)) + 1;
			}
		} catch (SystemException e) {
			log.warn("Unable to determine max vkid. Using 1 as vkid");
		}
		return 1;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Vanhatkirjat> getVanhatkirjatByStatuses(int...statuses) {
		List<Vanhatkirjat> retVal = new ArrayList<>();
		if(statuses.length == 0) {
			return retVal;
		}
		DynamicQuery dQuery = DynamicQueryFactoryUtil.forClass(Vanhatkirjat.class);
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		for(int status : statuses) {
			disjunction.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		dQuery.add(disjunction);
		try {
			retVal = VanhatkirjatLocalServiceUtil.dynamicQuery(dQuery);
		} catch (SystemException e) {
			log.error("Unable to fetch Vanhatkirjat objects using multiple status codes");
			e.printStackTrace();
		}
		return retVal;
	}
	
	public static Vanhatkirjat getVanhatkirjat(int vkid) {
		try {
			return VanhatkirjatLocalServiceUtil.getVanhatkirjat(vkid);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
			log.error("Unable to fetch vanhatkirjat entry from database with vkid: " + vkid);
			return null;
		}
	}
	
}
