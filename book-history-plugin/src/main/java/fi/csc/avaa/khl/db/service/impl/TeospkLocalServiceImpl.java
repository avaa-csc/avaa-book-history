package fi.csc.avaa.khl.db.service.impl;

import fi.csc.avaa.khl.db.NoSuchTeospkException;
import fi.csc.avaa.khl.db.service.base.TeospkLocalServiceBaseImpl;
import fi.csc.avaa.khl.db.service.persistence.TeospkUtil;
import fi.csc.avaa.tools.StringTools;

/**
 * The implementation of the teospk local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.TeospkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.TeospkLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.TeospkLocalServiceUtil
 */
public class TeospkLocalServiceImpl extends TeospkLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.TeospkLocalServiceUtil} to access the teospk local service.
     */
	
	public fi.csc.avaa.khl.db.model.Teospk findByTeospk(String teospk) throws com.liferay.portal.kernel.exception.SystemException, NoSuchTeospkException {
		if(StringTools.isEmptyOrNull(teospk)) {
			return null;
		}
		return TeospkUtil.findByTeospknimi(teospk);
	}
}
