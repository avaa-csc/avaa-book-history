package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchKieliinfoException;
import fi.csc.avaa.khl.db.service.base.KieliinfoLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.KieliinfoUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the kieliinfo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.KieliinfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.KieliinfoLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.KieliinfoLocalServiceUtil
 */
public class KieliinfoLocalServiceImpl extends KieliinfoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.KieliinfoLocalServiceUtil} to access the kieliinfo local service.
     */
	
	public fi.csc.avaa.khl.db.model.Kieliinfo findByKieli(String kieli) throws com.liferay.portal.kernel.exception.SystemException, NoSuchKieliinfoException {
		if(StringTools.isEmptyOrNull(kieli)) {
			return null;
		}
		return KieliinfoUtil.findByKieli(kieli);
	}
}
