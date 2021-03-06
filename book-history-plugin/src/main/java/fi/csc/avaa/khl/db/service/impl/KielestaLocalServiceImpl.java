package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchKielestaException;
import fi.csc.avaa.khl.db.service.base.KielestaLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.KielestaUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the kielesta local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.KielestaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.KielestaLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.KielestaLocalServiceUtil
 */
public class KielestaLocalServiceImpl extends KielestaLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.KielestaLocalServiceUtil} to access the kielesta local service.
     */
	
	public fi.csc.avaa.khl.db.model.Kielesta findByKieli(String kieli) throws com.liferay.portal.kernel.exception.SystemException, NoSuchKielestaException {
		if(StringTools.isEmptyOrNull(kieli)) {
			return null;
		}
		return KielestaUtil.findByKieli(kieli);
	}
}
