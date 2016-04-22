/**
 * 
 */
package fi.csc.avaa.khl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.CompleteVanhatkirjatUtils;
import fi.csc.avaa.khl.common.DBTools;
import fi.csc.avaa.khl.db.model.Julkaisulajiinfo;
import fi.csc.avaa.khl.db.model.Kartoituskohde;
import fi.csc.avaa.khl.db.model.Kielesta;
import fi.csc.avaa.khl.db.model.Kieliinfo;
import fi.csc.avaa.khl.db.model.Kuntainfo;
import fi.csc.avaa.khl.db.model.Kuntoluokitus;
import fi.csc.avaa.khl.db.model.Maakuntainfo;
import fi.csc.avaa.khl.db.model.Puute;
import fi.csc.avaa.khl.db.model.Sidottu;
import fi.csc.avaa.khl.db.model.Teospk;
import fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KartoituskohdeLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KielestaLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KieliinfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KuntainfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KuntoluokitusLocalServiceUtil;
import fi.csc.avaa.khl.db.service.MaakuntainfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.PuuteLocalServiceUtil;
import fi.csc.avaa.khl.db.service.SidottuLocalServiceUtil;
import fi.csc.avaa.khl.db.service.TeospkLocalServiceUtil;
import fi.csc.avaa.tools.cache.DataCache;

/**
 * @author jmlehtin
 *
 */
public final class CompleteVanhatkirjatCache extends DataCache {

	private static Map<Integer, CompleteVanhatkirjat> publicBooksCache = new HashMap<>();
	private static Map<Integer, CompleteVanhatkirjat> adminBooksCache = new HashMap<>();
	
	public static TreeSet<String> publicAuthors = new TreeSet<>();
	public static TreeSet<String> adminAuthors = new TreeSet<>();
	
	public static TreeSet<String> municipalities = new TreeSet<>();
	public static Map<String, Integer> municipalitiesId = new HashMap<>();
	public static TreeSet<String> municipalities2014 = new TreeSet<>();
	
	public static TreeSet<String> provences = new TreeSet<>();
	public static Map<String, Integer> provencesId = new HashMap<>();
	
	public static TreeSet<String> mappingTargets = new TreeSet<>();
	public static Map<String, Integer> mappingTargetsId = new HashMap<>();
	
	public static TreeSet<String> languages = new TreeSet<>();
	public static Map<String, Integer> languagesId = new HashMap<>();
	
	public static TreeSet<String> fromLanguages = new TreeSet<>();
	public static Map<String, Integer> fromLanguagesId = new HashMap<>();
	
	public static TreeSet<String> publicationTypes = new TreeSet<>();
	public static Map<String, Integer> publicationTypesId = new HashMap<>();
	
	public static TreeSet<String> ligatureTypes = new TreeSet<>();
	public static Map<String, Integer> ligatureTypesId = new HashMap<>();
	
	public static TreeSet<String> conditionTypes = new TreeSet<>();
	public static Map<String, Integer> conditionTypesId = new HashMap<>();
	
	public static TreeSet<String> deficiencyTypes = new TreeSet<>();
	public static Map<String, Integer> deficiencyTypesId = new HashMap<>();
	
	public static TreeSet<String> titleFromMunicipalityTypes = new TreeSet<>();
	public static Map<String, Integer> titleFromMunicipalityTypesId = new HashMap<>();

	public static TreeSet<String> publicCollections = new TreeSet<>();
	public static TreeSet<String> adminCollections = new TreeSet<>();
	public static TreeSet<String> placeOfPrintings = new TreeSet<>();

	public static boolean initCache() {
		return getPublicBooksCacheValues() != null && getAdminBooksCacheValues() != null && populateTypes() && populateAuthors() && populateCollections();
	}
	
	/**
	 * Use this to perform complete sync from database to cache(s)
	 * 
	 * @return
	 */
	public static boolean syncAllBooksInDatabaseToCaches() {
		return updatePublicBooksCacheFromDatabase() && updateAdminBooksCacheFromDatabase() && populateTypes() && populateAuthors() && populateCollections();
	}
	
	/**
	 * Use this to sync only one book in cache(s)
	 * 
	 * @param vkid
	 * @param onlyRemoveFromPublicCache
	 * @param onlyRemoveFromAdminCache
	 * @return
	 */
	public static boolean syncBookInDatabaseToCaches(int vkid, boolean onlyRemoveFromPublicCache, boolean onlyRemoveFromAdminCache) {
		return syncBookInDatabaseToBooksCache(vkid, getPublicBooksCache(), onlyRemoveFromPublicCache) && syncBookInDatabaseToBooksCache(vkid, getAdminBooksCache(), onlyRemoveFromAdminCache) && populateTypes() && populateAuthors() && populateCollections();
	}
	
	public static Map<Integer, CompleteVanhatkirjat> getPublicBooksCache() {
		if(publicBooksCache == null || publicBooksCache.size() == 0) {
			if(!updatePublicBooksCacheFromDatabase()) {
				return null;
			}
		}
		return publicBooksCache;
	}
	
	public static Map<Integer, CompleteVanhatkirjat> getAdminBooksCache() {
		if(adminBooksCache == null || adminBooksCache.size() == 0) {
			if(!updateAdminBooksCacheFromDatabase()) {
				return null;
			}
		}
		return adminBooksCache;
	}
	
	public static Collection<CompleteVanhatkirjat> getPublicBooksCacheValues() {
		if(publicBooksCache == null || publicBooksCache.size() == 0) {
			if(!updatePublicBooksCacheFromDatabase()) {
				return null;
			}
		}
		return publicBooksCache.values();
	}

	public static Collection<CompleteVanhatkirjat> getAdminBooksCacheValues() {
		if(adminBooksCache == null || adminBooksCache.size() == 0) {
			if(!updateAdminBooksCacheFromDatabase()) {
				return null;
			}
		}
		return adminBooksCache.values();
	}
	
	private static boolean updatePublicBooksCacheFromDatabase() {
		publicBooksCache = CompleteVanhatkirjatUtils.getListOfPubliclyVisibleCompleteVanhatkirjat();
		return publicBooksCache != null && publicBooksCache.size() > 0;
	}
	
	private static boolean updateAdminBooksCacheFromDatabase() {
		adminBooksCache = CompleteVanhatkirjatUtils.getListOfAdminVisibleCompleteVanhatkirjat();
		return adminBooksCache != null && adminBooksCache.size() > 0;
	}
	
	private static boolean populateAuthors() {
		publicAuthors = new TreeSet<>(getPublicBooksCacheValues().stream().map(cvk -> cvk.getVanhatkirjat().getTekija()).collect(Collectors.toSet()));
		adminAuthors = new TreeSet<>(getAdminBooksCacheValues().stream().map(cvk -> cvk.getVanhatkirjat().getTekija()).collect(Collectors.toSet()));
		return true;
	}
	
	private static boolean populateCollections() {
		publicCollections = new TreeSet<>(getPublicBooksCacheValues().stream().map(cvk -> cvk.getVanhatkirjat().getKokoelma()).collect(Collectors.toSet()));
		adminCollections = new TreeSet<>(getAdminBooksCacheValues().stream().map(cvk -> cvk.getVanhatkirjat().getKokoelma()).collect(Collectors.toSet()));
		placeOfPrintings = new TreeSet<>(getPublicBooksCacheValues().stream().map(cvk -> cvk.getVanhatkirjat().getPainopaikka()).collect(Collectors.toSet()));
		publicCollections.remove("");
		adminCollections.remove("");
		placeOfPrintings.remove("");
		return true;
	}
	
	private static boolean populateTypes() {
		try {
			List<Kuntainfo> kInfos = KuntainfoLocalServiceUtil.getKuntainfos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			municipalities = new TreeSet<>(kInfos.stream().map(kInfo -> kInfo.getCapitalkuntanimi()).collect(Collectors.toSet()));
			municipalitiesId = kInfos.stream().collect(Collectors.toMap(Kuntainfo::getCapitalkuntanimi, Kuntainfo::getKuntaid));
			municipalities2014 = new TreeSet<>(kInfos.stream().map(kInfo -> kInfo.getKuntanimi_2014()).collect(Collectors.toSet()));
			
			List<Maakuntainfo> mkInfos = MaakuntainfoLocalServiceUtil.getMaakuntainfos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			provences = new TreeSet<>(mkInfos.stream().map(mkInfo -> mkInfo.getMaakunta()).collect(Collectors.toSet()));
			provencesId = mkInfos.stream().collect(Collectors.toMap(Maakuntainfo::getMaakunta, Maakuntainfo::getMaakuntaid));
			
			List<Kartoituskohde> kks = KartoituskohdeLocalServiceUtil.getKartoituskohdes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			mappingTargets = new TreeSet<>(kks.stream().map(kk -> kk.getKartkohde()).collect(Collectors.toSet()));
			mappingTargetsId = kks.stream().collect(Collectors.toMap(Kartoituskohde::getKartkohde, Kartoituskohde::getKohdeid));
			
			List<Kieliinfo> kieliInfos = KieliinfoLocalServiceUtil.getKieliinfos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			languages = new TreeSet<>(kieliInfos.stream().map(kInfo -> kInfo.getKieli()).collect(Collectors.toSet()));
			languagesId = kieliInfos.stream().collect(Collectors.toMap(Kieliinfo::getKieli, Kieliinfo::getKieliid));
			
			List<Kielesta> kielestaItems = KielestaLocalServiceUtil.getKielestas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			fromLanguages = new TreeSet<>(kielestaItems.stream().map(kielesta -> kielesta.getKieli()).collect(Collectors.toSet()));
			fromLanguagesId = kielestaItems.stream().collect(Collectors.toMap(Kielesta::getKieli, Kielesta::getKieliid));
			
			List<Julkaisulajiinfo> jlis = JulkaisulajiinfoLocalServiceUtil.getJulkaisulajiinfos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			publicationTypes = new TreeSet<>(jlis.stream().map(jli -> jli.getJulklaji()).collect(Collectors.toSet()));
			publicationTypesId = jlis.stream().collect(Collectors.toMap(Julkaisulajiinfo::getJulklaji, Julkaisulajiinfo::getJulklajiid));
			
			List<Sidottu> sidottuItems = SidottuLocalServiceUtil.getSidottus(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			ligatureTypes = new TreeSet<>(sidottuItems.stream().map(sidottu -> sidottu.getSidonta()).collect(Collectors.toSet()));
			ligatureTypesId = sidottuItems.stream().collect(Collectors.toMap(Sidottu::getSidonta, Sidottu::getSidontaid));
			
			List<Kuntoluokitus> kuntoluokItems = KuntoluokitusLocalServiceUtil.getKuntoluokituses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			conditionTypes = new TreeSet<>(kuntoluokItems.stream().map(kunto -> kunto.getKunto()).collect(Collectors.toSet()));
			conditionTypesId = kuntoluokItems.stream().collect(Collectors.toMap(Kuntoluokitus::getKunto, Kuntoluokitus::getKuntoid));
			
			List<Puute> puuteItems = PuuteLocalServiceUtil.getPuutes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			deficiencyTypes = new TreeSet<>(puuteItems.stream().map(puute -> puute.getPuutenimi()).collect(Collectors.toSet()));
			deficiencyTypesId = puuteItems.stream().collect(Collectors.toMap(Puute::getPuutenimi, Puute::getPuuteid));
			
			List<Teospk> teospkItems = TeospkLocalServiceUtil.getTeospks(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			titleFromMunicipalityTypes = new TreeSet<>(teospkItems.stream().map(teosPk -> teosPk.getTeospknimi()).collect(Collectors.toSet()));
			titleFromMunicipalityTypesId = teospkItems.stream().collect(Collectors.toMap(Teospk::getTeospknimi, Teospk::getTeospkid));
		} catch (SystemException e) {
			e.printStackTrace();
			log.error("Error when enumerating all available types");
			return false;
		}
		return true;
	}
	
	private static boolean syncBookInDatabaseToBooksCache(int vkid, Map<Integer, CompleteVanhatkirjat> cache, boolean onlyRemoveFromCache) {
		try {
			if(cache == null) {
				return true;
			}
			CompleteVanhatkirjat cvkInCache = cache.get(vkid);
			if(onlyRemoveFromCache) {
				cache.remove(vkid);
			} else {
				CompleteVanhatkirjat cvkInDb = new CompleteVanhatkirjat();
				try {
					cvkInDb.extend(DBTools.getVanhatkirjat(vkid));
					if(cvkInCache != null) {
						cache.remove(cvkInCache);
					}
					cache.put(cvkInDb.getVanhatkirjat().getVkid(), cvkInDb);
				} catch (Exception e1) {
					log.error("Unable to extend vanhatkirjat or Unable to find book with vkid " + vkid + " from database");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
