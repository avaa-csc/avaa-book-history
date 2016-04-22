package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchKuntoluokitusException;
import fi.csc.avaa.khl.db.service.base.KuntoluokitusLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.KuntoluokitusUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the kuntoluokitus local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.KuntoluokitusLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.KuntoluokitusLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.KuntoluokitusLocalServiceUtil
 */
public class KuntoluokitusLocalServiceImpl
    extends KuntoluokitusLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.KuntoluokitusLocalServiceUtil} to access the kuntoluokitus local service.
     */
	
	public fi.csc.avaa.khl.db.model.Kuntoluokitus findByKunto(String kunto) throws com.liferay.portal.kernel.exception.SystemException, NoSuchKuntoluokitusException {
		if(StringTools.isEmptyOrNull(kunto)) {
			return null;
		}
		return KuntoluokitusUtil.findByKunto(kunto);
	}
}
