package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Kuntainfo service. Represents a row in the &quot;kuntainfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link fi.csc.avaa.khl.db.model.impl.KuntainfoImpl}.
 * </p>
 *
 * @author CSC
 * @see Kuntainfo
 * @see fi.csc.avaa.khl.db.model.impl.KuntainfoImpl
 * @see fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl
 * @generated
 */
public interface KuntainfoModel extends BaseModel<Kuntainfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a kuntainfo model instance should use the {@link Kuntainfo} interface instead.
     */

    /**
     * Returns the primary key of this kuntainfo.
     *
     * @return the primary key of this kuntainfo
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this kuntainfo.
     *
     * @param primaryKey the primary key of this kuntainfo
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the kuntaid of this kuntainfo.
     *
     * @return the kuntaid of this kuntainfo
     */
    public int getKuntaid();

    /**
     * Sets the kuntaid of this kuntainfo.
     *
     * @param kuntaid the kuntaid of this kuntainfo
     */
    public void setKuntaid(int kuntaid);

    /**
     * Returns the capitalkuntanimi of this kuntainfo.
     *
     * @return the capitalkuntanimi of this kuntainfo
     */
    @AutoEscape
    public String getCapitalkuntanimi();

    /**
     * Sets the capitalkuntanimi of this kuntainfo.
     *
     * @param capitalkuntanimi the capitalkuntanimi of this kuntainfo
     */
    public void setCapitalkuntanimi(String capitalkuntanimi);

    /**
     * Returns the kpl of this kuntainfo.
     *
     * @return the kpl of this kuntainfo
     */
    public int getKpl();

    /**
     * Sets the kpl of this kuntainfo.
     *
     * @param kpl the kpl of this kuntainfo
     */
    public void setKpl(int kpl);

    /**
     * Returns the kuntanimi of this kuntainfo.
     *
     * @return the kuntanimi of this kuntainfo
     */
    @AutoEscape
    public String getKuntanimi();

    /**
     * Sets the kuntanimi of this kuntainfo.
     *
     * @param kuntanimi the kuntanimi of this kuntainfo
     */
    public void setKuntanimi(String kuntanimi);

    /**
     * Returns the maakuntaid of this kuntainfo.
     *
     * @return the maakuntaid of this kuntainfo
     */
    public int getMaakuntaid();

    /**
     * Sets the maakuntaid of this kuntainfo.
     *
     * @param maakuntaid the maakuntaid of this kuntainfo
     */
    public void setMaakuntaid(int maakuntaid);

    /**
     * Returns the kuntano of this kuntainfo.
     *
     * @return the kuntano of this kuntainfo
     */
    public int getKuntano();

    /**
     * Sets the kuntano of this kuntainfo.
     *
     * @param kuntano the kuntano of this kuntainfo
     */
    public void setKuntano(int kuntano);

    /**
     * Returns the kuntanimi_2014 of this kuntainfo.
     *
     * @return the kuntanimi_2014 of this kuntainfo
     */
    @AutoEscape
    public String getKuntanimi_2014();

    /**
     * Sets the kuntanimi_2014 of this kuntainfo.
     *
     * @param kuntanimi_2014 the kuntanimi_2014 of this kuntainfo
     */
    public void setKuntanimi_2014(String kuntanimi_2014);

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
    public int compareTo(fi.csc.avaa.khl.db.model.Kuntainfo kuntainfo);

    @Override
    public int hashCode();

    @Override
    public CacheModel<fi.csc.avaa.khl.db.model.Kuntainfo> toCacheModel();

    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo toEscapedModel();

    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
