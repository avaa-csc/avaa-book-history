package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchKartoituskohdeException;
import fi.csc.avaa.khl.db.service.base.KartoituskohdeLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.KartoituskohdeUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the kartoituskohde local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.KartoituskohdeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.KartoituskohdeLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.KartoituskohdeLocalServiceUtil
 */
public class KartoituskohdeLocalServiceImpl
    extends KartoituskohdeLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.KartoituskohdeLocalServiceUtil} to access the kartoituskohde local service.
     */
	
	public fi.csc.avaa.khl.db.model.Kartoituskohde findByKartkohde(String kartkohde) throws com.liferay.portal.kernel.exception.SystemException, NoSuchKartoituskohdeException {
		if(StringTools.isEmptyOrNull(kartkohde)) {
			return null;
		}
		return KartoituskohdeUtil.findByKartkohde(kartkohde);
	}
}
