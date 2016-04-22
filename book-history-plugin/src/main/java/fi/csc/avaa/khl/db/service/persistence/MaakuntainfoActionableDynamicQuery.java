package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Maakuntainfo;
import fi.csc.avaa.khl.db.service.MaakuntainfoLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class MaakuntainfoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MaakuntainfoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MaakuntainfoLocalServiceUtil.getService());
        setClass(Maakuntainfo.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("maakuntaid");
    }
}
