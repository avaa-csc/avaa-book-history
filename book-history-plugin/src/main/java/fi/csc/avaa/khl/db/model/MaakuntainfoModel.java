package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Maakuntainfo service. Represents a row in the &quot;maakuntainfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoImpl}.
 * </p>
 *
 * @author CSC
 * @see Maakuntainfo
 * @see fi.csc.avaa.khl.db.model.impl.MaakuntainfoImpl
 * @see fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl
 * @generated
 */
public interface MaakuntainfoModel extends BaseModel<Maakuntainfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a maakuntainfo model instance should use the {@link Maakuntainfo} interface instead.
     */

    /**
     * Returns the primary key of this maakuntainfo.
     *
     * @return the primary key of this maakuntainfo
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this maakuntainfo.
     *
     * @param primaryKey the primary key of this maakuntainfo
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the maakuntaid of this maakuntainfo.
     *
     * @return the maakuntaid of this maakuntainfo
     */
    public int getMaakuntaid();

    /**
     * Sets the maakuntaid of this maakuntainfo.
     *
     * @param maakuntaid the maakuntaid of this maakuntainfo
     */
    public void setMaakuntaid(int maakuntaid);

    /**
     * Returns the maakunta of this maakuntainfo.
     *
     * @return the maakunta of this maakuntainfo
     */
    @AutoEscape
    public String getMaakunta();

    /**
     * Sets the maakunta of this maakuntainfo.
     *
     * @param maakunta the maakunta of this maakuntainfo
     */
    public void setMaakunta(String maakunta);

    /**
     * Returns the kpl of this maakuntainfo.
     *
     * @return the kpl of this maakuntainfo
     */
    public int getKpl();

    /**
     * Sets the kpl of this maakuntainfo.
     *
     * @param kpl the kpl of this maakuntainfo
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
    public int compareTo(fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo);

    @Override
    public int hashCode();

    @Override
    public CacheModel<fi.csc.avaa.khl.db.model.Maakuntainfo> toCacheModel();

    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo toEscapedModel();

    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
