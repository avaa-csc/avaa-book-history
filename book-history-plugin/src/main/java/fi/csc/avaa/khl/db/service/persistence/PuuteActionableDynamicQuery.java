package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Puute;
import fi.csc.avaa.khl.db.service.PuuteLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class PuuteActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PuuteActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PuuteLocalServiceUtil.getService());
        setClass(Puute.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("puuteid");
    }
}
