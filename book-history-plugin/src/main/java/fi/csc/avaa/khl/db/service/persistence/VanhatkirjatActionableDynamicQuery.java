package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class VanhatkirjatActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public VanhatkirjatActionableDynamicQuery() throws SystemException {
        setBaseLocalService(VanhatkirjatLocalServiceUtil.getService());
        setClass(Vanhatkirjat.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("vkid");
    }
}
