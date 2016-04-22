package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Kuntainfo;
import fi.csc.avaa.khl.db.service.KuntainfoLocalServiceUtil;

/**
 * The extended model base implementation for the Kuntainfo service. Represents a row in the &quot;kuntainfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KuntainfoImpl}.
 * </p>
 *
 * @author CSC
 * @see KuntainfoImpl
 * @see fi.csc.avaa.khl.db.model.Kuntainfo
 * @generated
 */
public abstract class KuntainfoBaseImpl extends KuntainfoModelImpl
    implements Kuntainfo {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a kuntainfo model instance should use the {@link Kuntainfo} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            KuntainfoLocalServiceUtil.addKuntainfo(this);
        } else {
            KuntainfoLocalServiceUtil.updateKuntainfo(this);
        }
    }
}