package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Puute;
import fi.csc.avaa.khl.db.service.PuuteLocalServiceUtil;

/**
 * The extended model base implementation for the Puute service. Represents a row in the &quot;puute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PuuteImpl}.
 * </p>
 *
 * @author CSC
 * @see PuuteImpl
 * @see fi.csc.avaa.khl.db.model.Puute
 * @generated
 */
public abstract class PuuteBaseImpl extends PuuteModelImpl implements Puute {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a puute model instance should use the {@link Puute} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PuuteLocalServiceUtil.addPuute(this);
        } else {
            PuuteLocalServiceUtil.updatePuute(this);
        }
    }
}
