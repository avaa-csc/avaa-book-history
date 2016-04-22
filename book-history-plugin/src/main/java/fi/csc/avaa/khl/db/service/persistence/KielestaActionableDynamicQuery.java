package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Kielesta;
import fi.csc.avaa.khl.db.service.KielestaLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class KielestaActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public KielestaActionableDynamicQuery() throws SystemException {
        setBaseLocalService(KielestaLocalServiceUtil.getService());
        setClass(Kielesta.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("kieliid");
    }
}
