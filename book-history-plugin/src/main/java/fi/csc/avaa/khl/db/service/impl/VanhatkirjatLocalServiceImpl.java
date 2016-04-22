package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.service.base.VanhatkirjatLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.VanhatkirjatFinderUtil;
import fi.csc.avaa.khl.db.service.persistence.VanhatkirjatUtil;

/**
 * The implementation of the vanhatkirjat local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.VanhatkirjatLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.VanhatkirjatLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil
 */
public class VanhatkirjatLocalServiceImpl
    extends VanhatkirjatLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil} to access the vanhatkirjat local service.
     */
	
	public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAllByPublishStatus(int status) throws com.liferay.portal.kernel.exception.SystemException {
		return VanhatkirjatUtil.findByPublishStatus(status);
	}
	
	public boolean deleteAllVanhatkirjat() throws com.liferay.portal.kernel.exception.SystemException {
		return VanhatkirjatFinderUtil.deleteAllVanhatkirjat();
	}
}
