package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Kieliinfo;
import fi.csc.avaa.khl.db.service.KieliinfoLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class KieliinfoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public KieliinfoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(KieliinfoLocalServiceUtil.getService());
        setClass(Kieliinfo.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("kieliid");
    }
}
