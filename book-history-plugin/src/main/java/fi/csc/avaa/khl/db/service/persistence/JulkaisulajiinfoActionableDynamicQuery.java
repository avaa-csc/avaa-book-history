package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Julkaisulajiinfo;
import fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class JulkaisulajiinfoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public JulkaisulajiinfoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(JulkaisulajiinfoLocalServiceUtil.getService());
        setClass(Julkaisulajiinfo.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("julklajiid");
    }
}
