package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Teospk;
import fi.csc.avaa.khl.db.service.TeospkLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class TeospkActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TeospkActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TeospkLocalServiceUtil.getService());
        setClass(Teospk.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("teospkid");
    }
}
