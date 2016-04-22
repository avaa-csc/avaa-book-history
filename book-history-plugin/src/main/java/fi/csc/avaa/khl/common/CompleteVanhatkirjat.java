/**
 * 
 */
package fi.csc.avaa.khl.common;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

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
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
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
import fi.csc.avaa.liferay.service.model.ExtendableModel;
import fi.csc.avaa.liferay.service.model.ModelExtendError;
import fi.csc.avaa.tools.logging.AvaaLogger;

/**
 * @author jmlehtin
 *
 */
public class CompleteVanhatkirjat implements ExtendableModel<Vanhatkirjat> {

	private static AvaaLogger log = new AvaaLogger(CompleteVanhatkirjat.class.getName());
	private Vanhatkirjat vanhatkirjat;
	private Kuntainfo kuntainfo;
	private Maakuntainfo maakuntainfo;
	private Kartoituskohde kartoituskohde;
	private Julkaisulajiinfo julkaisulajiinfo;
	private Kieliinfo kieliinfo;
	private Kielesta kielesta;
	private Kuntoluokitus kuntoluokitus;
	private Puute puute;
	private Sidottu sidottu;
	private Teospk teospk;
	
	public CompleteVanhatkirjat() {
	}
	
	public CompleteVanhatkirjat(Vanhatkirjat vanhatkirjat, Kuntainfo kuntainfo, Maakuntainfo maakuntainfo, Kartoituskohde kartoituskohde, Julkaisulajiinfo julkaisulajiinfo, Kieliinfo kieliinfo, Kielesta kielesta, Kuntoluokitus kuntoluokitus, Puute puute, Sidottu sidottu, Teospk teospk) {
		this.vanhatkirjat = vanhatkirjat;
		this.kuntainfo = kuntainfo;
		this.maakuntainfo = maakuntainfo;
		this.kartoituskohde = kartoituskohde;
		this.julkaisulajiinfo = julkaisulajiinfo;
		this.kieliinfo = kieliinfo;
		this.kielesta = kielesta;
		this.kuntoluokitus = kuntoluokitus;
		this.puute = puute;
		this.sidottu = sidottu;
		this.teospk = teospk;
	}
	
	public Vanhatkirjat getVanhatkirjat() {
		return vanhatkirjat;
	}
	public void setVanhatkirjat(Vanhatkirjat vanhatkirjat) {
		this.vanhatkirjat = vanhatkirjat;
	}
	public Kuntainfo getKuntainfo() {
		return kuntainfo;
	}
	public void setKuntainfo(Kuntainfo kuntainfo) {
		this.kuntainfo = kuntainfo;
	}
	public Maakuntainfo getMaakuntainfo() {
		return maakuntainfo;
	}
	public void setMaakuntainfo(Maakuntainfo maakuntainfo) {
		this.maakuntainfo = maakuntainfo;
	}
	public Kartoituskohde getKartoituskohde() {
		return kartoituskohde;
	}
	public void setKartoituskohde(Kartoituskohde kartoituskohde) {
		this.kartoituskohde = kartoituskohde;
	}

	public Julkaisulajiinfo getJulkaisulajiinfo() {
		return julkaisulajiinfo;
	}

	public Kieliinfo getKieliinfo() {
		return kieliinfo;
	}

	public Kielesta getKielesta() {
		return kielesta;
	}

	public Kuntoluokitus getKuntoluokitus() {
		return kuntoluokitus;
	}

	public Puute getPuute() {
		return puute;
	}

	public Sidottu getSidottu() {
		return sidottu;
	}

	public Teospk getTeospk() {
		return teospk;
	}

	public void setJulkaisulajiinfo(Julkaisulajiinfo julkaisulajiinfo) {
		this.julkaisulajiinfo = julkaisulajiinfo;
	}

	public void setKieliinfo(Kieliinfo kieliinfo) {
		this.kieliinfo = kieliinfo;
	}

	public void setKielesta(Kielesta kielesta) {
		this.kielesta = kielesta;
	}

	public void setKuntoluokitus(Kuntoluokitus kuntoluokitus) {
		this.kuntoluokitus = kuntoluokitus;
	}

	public void setPuute(Puute puute) {
		this.puute = puute;
	}

	public void setSidottu(Sidottu sidottu) {
		this.sidottu = sidottu;
	}

	public void setTeospk(Teospk teospk) {
		this.teospk = teospk;
	}
	
	public static Map<Integer, CompleteVanhatkirjat> convertToCompleteVanhatkirjats(List<Vanhatkirjat> vks) {
		Map<Integer, CompleteVanhatkirjat> retVal = new HashMap<>();
		if(vks != null) {
			for(Vanhatkirjat vk : vks) {
				CompleteVanhatkirjat newCvk = new CompleteVanhatkirjat();
				try {
					newCvk.extend(vk);
					retVal.put(newCvk.getVanhatkirjat().getVkid(), newCvk);
				} catch (Exception e1) {
					log.error("Unable to extend vanhatkirjat");
				}
			}
			return retVal;
		}
		return null;
	}

	public static int getNewModifiedStatus(int status) {
		switch (status) {
		case Const.STATUS_NOT_WWW_AND_PUBLISHED:
		case Const.STATUS_NOT_WWW_AND_MODIFIED:
			return Const.STATUS_NOT_WWW_AND_MODIFIED;
		case Const.STATUS_WWW_AND_PUBLISHED:
		case Const.STATUS_WWW_AND_MODIFIED:
			return Const.STATUS_WWW_AND_MODIFIED;
		default:
			return -1;
		}
	}
	
	public static int getNewDeletedStatus(int status) {
		switch (status) {
		case Const.STATUS_NOT_WWW_AND_PUBLISHED:
		case Const.STATUS_NOT_WWW_AND_MODIFIED:
			return Const.STATUS_NOT_WWW_AND_DELETED;
		case Const.STATUS_WWW_AND_UNPUBLISHED:
		case Const.STATUS_WWW_AND_PUBLISHED:
		case Const.STATUS_WWW_AND_MODIFIED:
			return Const.STATUS_WWW_AND_DELETED;
		default:
			return -1;
		}
	}
	
	public static int getNewUndeletedStatus(int status, Date modifiedDate) {
		switch (status) {
		case Const.STATUS_NOT_WWW_AND_DELETED:
			if(modifiedDate == null) {
				return Const.STATUS_NOT_WWW_AND_PUBLISHED;
			} else {
				return Const.STATUS_NOT_WWW_AND_MODIFIED;
			}
		case Const.STATUS_WWW_AND_DELETED:
			if(modifiedDate == null) {
				return Const.STATUS_WWW_AND_PUBLISHED;
			} else {
				return Const.STATUS_WWW_AND_MODIFIED;
			}
		default:
			return -1;
		}
	}
	
	public static int getNewPublishedStatus(int status) {
		switch (status) {
		case Const.STATUS_WWW_AND_UNPUBLISHED:
			return Const.STATUS_WWW_AND_PUBLISHED;
		default:
			return -1;
		}
	}

	@Override
	public void extend(Vanhatkirjat vk) throws ModelExtendError {
		if(vk != null) {
			setVanhatkirjat(vk);
			try {
				setKuntainfo(vk.getKuntaid() == 0 ? null : KuntainfoLocalServiceUtil.getKuntainfo(vk.getKuntaid()));
				setMaakuntainfo(vk.getMaakuntaid() == 0 ? null : MaakuntainfoLocalServiceUtil.getMaakuntainfo(vk.getMaakuntaid()));
				setKartoituskohde(vk.getKartkohde() == 0 ? null : KartoituskohdeLocalServiceUtil.getKartoituskohde(vk.getKartkohde()));
				setJulkaisulajiinfo(vk.getJulklajiid() == 0 ? null : JulkaisulajiinfoLocalServiceUtil.getJulkaisulajiinfo(vk.getJulklajiid()));
				setKielesta(vk.getKielestaid() == 0 ? null : KielestaLocalServiceUtil.getKielesta(vk.getKielestaid()));
				setKieliinfo(vk.getKieliid() == 0 ? null : KieliinfoLocalServiceUtil.getKieliinfo(vk.getKieliid()));
				setKuntoluokitus(vk.getKuntoid() == 0 ? null : KuntoluokitusLocalServiceUtil.getKuntoluokitus(vk.getKuntoid()));
				setPuute(vk.getPuuteid() == 0 ? null : PuuteLocalServiceUtil.getPuute(vk.getPuuteid()));
				setSidottu(vk.getSidonta() == 0 ? null : SidottuLocalServiceUtil.getSidottu(vk.getSidonta()));
				setTeospk(vk.getTeospkid() == 0 ? null : TeospkLocalServiceUtil.getTeospk(vk.getTeospkid()));
			} catch (PortalException | SystemException e) {
				log.error("Error converting vanhatkirjat DB model to CompleteVanhatkirjat object. Most likely vanhatkirjat model has erroneous foreign key id");
				e.printStackTrace();
				throw new ModelExtendError();
			}
		}
	}
}
