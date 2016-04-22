package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchKuntainfoException;
import fi.csc.avaa.khl.db.service.base.KuntainfoLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.KuntainfoUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the kuntainfo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.KuntainfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.KuntainfoLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.KuntainfoLocalServiceUtil
 */
public class KuntainfoLocalServiceImpl extends KuntainfoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.KuntainfoLocalServiceUtil} to access the kuntainfo local service.
     */
	
	public fi.csc.avaa.khl.db.model.Kuntainfo findByCapitalkuntanimi(String capitalKuntanimi) throws com.liferay.portal.kernel.exception.SystemException, NoSuchKuntainfoException {
		if(StringTools.isEmptyOrNull(capitalKuntanimi)) {
			return null;
		}
		return KuntainfoUtil.findByCapitalkuntanimi(capitalKuntanimi);
	}
}
