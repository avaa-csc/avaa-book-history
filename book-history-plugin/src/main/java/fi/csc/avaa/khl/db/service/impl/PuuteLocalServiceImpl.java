package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchPuuteException;
import fi.csc.avaa.khl.db.service.base.PuuteLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.PuuteUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the puute local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.PuuteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.PuuteLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.PuuteLocalServiceUtil
 */
public class PuuteLocalServiceImpl extends PuuteLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.PuuteLocalServiceUtil} to access the puute local service.
     */
	
	public fi.csc.avaa.khl.db.model.Puute findByPuute(String puute) throws com.liferay.portal.kernel.exception.SystemException, NoSuchPuuteException {
		if(StringTools.isEmptyOrNull(puute)) {
			return null;
		}
		return PuuteUtil.findByPuutenimi(puute);
	}
}
