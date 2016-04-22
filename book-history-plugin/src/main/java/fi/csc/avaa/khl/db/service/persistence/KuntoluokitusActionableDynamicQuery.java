package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Kuntoluokitus;
import fi.csc.avaa.khl.db.service.KuntoluokitusLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class KuntoluokitusActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public KuntoluokitusActionableDynamicQuery() throws SystemException {
        setBaseLocalService(KuntoluokitusLocalServiceUtil.getService());
        setClass(Kuntoluokitus.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("kuntoid");
    }
}
