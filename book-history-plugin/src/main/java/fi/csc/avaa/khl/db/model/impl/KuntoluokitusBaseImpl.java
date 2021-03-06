package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Kuntoluokitus;
import fi.csc.avaa.khl.db.service.KuntoluokitusLocalServiceUtil;

/**
 * The extended model base implementation for the Kuntoluokitus service. Represents a row in the &quot;kuntoluokitus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KuntoluokitusImpl}.
 * </p>
 *
 * @author CSC
 * @see KuntoluokitusImpl
 * @see fi.csc.avaa.khl.db.model.Kuntoluokitus
 * @generated
 */
public abstract class KuntoluokitusBaseImpl extends KuntoluokitusModelImpl
    implements Kuntoluokitus {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a kuntoluokitus model instance should use the {@link Kuntoluokitus} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            KuntoluokitusLocalServiceUtil.addKuntoluokitus(this);
        } else {
            KuntoluokitusLocalServiceUtil.updateKuntoluokitus(this);
        }
    }
}
