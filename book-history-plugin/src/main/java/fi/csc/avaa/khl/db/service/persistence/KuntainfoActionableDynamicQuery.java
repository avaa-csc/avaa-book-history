package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Kuntainfo;
import fi.csc.avaa.khl.db.service.KuntainfoLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class KuntainfoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public KuntainfoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(KuntainfoLocalServiceUtil.getService());
        setClass(Kuntainfo.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("kuntaid");
    }
}
