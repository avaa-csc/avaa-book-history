package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import fi.csc.avaa.khl.db.model.Julkaisulajiinfo;
import fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalServiceUtil;

/**
 * The extended model base implementation for the Julkaisulajiinfo service. Represents a row in the &quot;julklajiinfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JulkaisulajiinfoImpl}.
 * </p>
 *
 * @author CSC
 * @see JulkaisulajiinfoImpl
 * @see fi.csc.avaa.khl.db.model.Julkaisulajiinfo
 * @generated
 */
public abstract class JulkaisulajiinfoBaseImpl extends JulkaisulajiinfoModelImpl
    implements Julkaisulajiinfo {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a julkaisulajiinfo model instance should use the {@link Julkaisulajiinfo} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            JulkaisulajiinfoLocalServiceUtil.addJulkaisulajiinfo(this);
        } else {
            JulkaisulajiinfoLocalServiceUtil.updateJulkaisulajiinfo(this);
        }
    }
}