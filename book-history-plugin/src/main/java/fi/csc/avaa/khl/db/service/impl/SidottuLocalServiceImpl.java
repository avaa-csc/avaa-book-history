package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchSidottuException;
import fi.csc.avaa.khl.db.service.base.SidottuLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.SidottuUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the sidottu local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.SidottuLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.SidottuLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.SidottuLocalServiceUtil
 */
public class SidottuLocalServiceImpl extends SidottuLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.SidottuLocalServiceUtil} to access the sidottu local service.
     */
	
	public fi.csc.avaa.khl.db.model.Sidottu findBySidonta(String sidonta) throws com.liferay.portal.kernel.exception.SystemException, NoSuchSidottuException {
		if(StringTools.isEmptyOrNull(sidonta)) {
			return null;
		}
		return SidottuUtil.findBySidonta(sidonta);
	}
}
