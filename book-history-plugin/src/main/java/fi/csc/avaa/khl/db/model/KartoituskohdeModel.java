package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Kartoituskohde service. Represents a row in the &quot;kartoituskohde&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link fi.csc.avaa.khl.db.model.impl.KartoituskohdeImpl}.
 * </p>
 *
 * @author CSC
 * @see Kartoituskohde
 * @see fi.csc.avaa.khl.db.model.impl.KartoituskohdeImpl
 * @see fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl
 * @generated
 */
public interface KartoituskohdeModel extends BaseModel<Kartoituskohde> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a kartoituskohde model instance should use the {@link Kartoituskohde} interface instead.
     */

    /**
     * Returns the primary key of this kartoituskohde.
     *
     * @return the primary key of this kartoituskohde
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this kartoituskohde.
     *
     * @param primaryKey the primary key of this kartoituskohde
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the kohdeid of this kartoituskohde.
     *
     * @return the kohdeid of this kartoituskohde
     */
    public int getKohdeid();

    /**
     * Sets the kohdeid of this kartoituskohde.
     *
     * @param kohdeid the kohdeid of this kartoituskohde
     */
    public void setKohdeid(int kohdeid);

    /**
     * Returns the kartkohde of this kartoituskohde.
     *
     * @return the kartkohde of this kartoituskohde
     */
    @AutoEscape
    public String getKartkohde();

    /**
     * Sets the kartkohde of this kartoituskohde.
     *
     * @param kartkohde the kartkohde of this kartoituskohde
     */
    public void setKartkohde(String kartkohde);

    /**
     * Returns the kpl of this kartoituskohde.
     *
     * @return the kpl of this kartoituskohde
     */
    public int getKpl();

    /**
     * Sets the kpl of this kartoituskohde.
     *
     * @param kpl the kpl of this kartoituskohde
     */
    public void setKpl(int kpl);

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
    public int compareTo(Kartoituskohde kartoituskohde);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Kartoituskohde> toCacheModel();

    @Override
    public Kartoituskohde toEscapedModel();

    @Override
    public Kartoituskohde toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}