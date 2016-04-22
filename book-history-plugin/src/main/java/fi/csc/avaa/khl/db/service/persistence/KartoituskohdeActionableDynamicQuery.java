package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Kartoituskohde;
import fi.csc.avaa.khl.db.service.KartoituskohdeLocalServiceUtil;

/**
 * @author CSC
 * @generated
 */
public abstract class KartoituskohdeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public KartoituskohdeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(KartoituskohdeLocalServiceUtil.getService());
        setClass(Kartoituskohde.class);

        setClassLoader(fi.csc.avaa.khl.db.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("kohdeid");
    }
}
