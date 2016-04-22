package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Sidottu;
import fi.csc.avaa.khl.db.service.SidottuLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class SidottuActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SidottuActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SidottuLocalServiceUtil.getService());
        setClass(Sidottu.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("sidontaid");
    }
}
