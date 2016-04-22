package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Kuntoluokitus service. Represents a row in the &quot;kuntoluokitus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusImpl}.
 * </p>
 *
 * @author CSC
 * @see Kuntoluokitus
 * @see fi.csc.avaa.khl.db.model.impl.KuntoluokitusImpl
 * @see fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl
 * @generated
 */
public interface KuntoluokitusModel extends BaseModel<Kuntoluokitus> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a kuntoluokitus model instance should use the {@link Kuntoluokitus} interface instead.
     */

    /**
     * Returns the primary key of this kuntoluokitus.
     *
     * @return the primary key of this kuntoluokitus
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this kuntoluokitus.
     *
     * @param primaryKey the primary key of this kuntoluokitus
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the kuntoid of this kuntoluokitus.
     *
     * @return the kuntoid of this kuntoluokitus
     */
    public int getKuntoid();

    /**
     * Sets the kuntoid of this kuntoluokitus.
     *
     * @param kuntoid the kuntoid of this kuntoluokitus
     */
    public void setKuntoid(int kuntoid);

    /**
     * Returns the kunto of this kuntoluokitus.
     *
     * @return the kunto of this kuntoluokitus
     */
    @AutoEscape
    public String getKunto();

    /**
     * Sets the kunto of this kuntoluokitus.
     *
     * @param kunto the kunto of this kuntoluokitus
     */
    public void setKunto(String kunto);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(Kuntoluokitus kuntoluokitus);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Kuntoluokitus> toCacheModel();

    @Override
    public Kuntoluokitus toEscapedModel();

    @Override
    public Kuntoluokitus toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}