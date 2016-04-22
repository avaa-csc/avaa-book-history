package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException;
import fi.csc.avaa.khl.db.service.base.JulkaisulajiinfoLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.JulkaisulajiinfoUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the julkaisulajiinfo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.JulkaisulajiinfoLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalServiceUtil
 */
public class JulkaisulajiinfoLocalServiceImpl
    extends JulkaisulajiinfoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalServiceUtil} to access the julkaisulajiinfo local service.
     */
	
	public fi.csc.avaa.khl.db.model.Julkaisulajiinfo findByJulkaisulaji(String julkaisulaji) throws com.liferay.portal.kernel.exception.SystemException, NoSuchJulkaisulajiinfoException {
		if(StringTools.isEmptyOrNull(julkaisulaji)) {
			return null;
		}
		return JulkaisulajiinfoUtil.findByJulklaji(julkaisulaji);
	}
}
