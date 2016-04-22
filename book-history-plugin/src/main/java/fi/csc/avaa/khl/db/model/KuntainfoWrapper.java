package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Kuntainfo}.
 * </p>
 *
 * @author CSC
 * @see Kuntainfo
 * @generated
 */
public class KuntainfoWrapper implements Kuntainfo, ModelWrapper<Kuntainfo> {
    private Kuntainfo _kuntainfo;

    public KuntainfoWrapper(Kuntainfo kuntainfo) {
        _kuntainfo = kuntainfo;
    }

    @Override
    public Class<?> getModelClass() {
        return Kuntainfo.class;
    }

    @Override
    public String getModelClassName() {
        return Kuntainfo.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("kuntaid", getKuntaid());
        attributes.put("capitalkuntanimi", getCapitalkuntanimi());
        attributes.put("kpl", getKpl());
        attributes.put("kuntanimi", getKuntanimi());
        attributes.put("maakuntaid", getMaakuntaid());
        attributes.put("kuntano", getKuntano());
        attributes.put("kuntanimi_2014", getKuntanimi_2014());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer kuntaid = (Integer) attributes.get("kuntaid");

        if (kuntaid != null) {
            setKuntaid(kuntaid);
        }

        String capitalkuntanimi = (String) attributes.get("capitalkuntanimi");

        if (capitalkuntanimi != null) {
            setCapitalkuntanimi(capitalkuntanimi);
        }

        Integer kpl = (Integer) attributes.get("kpl");

        if (kpl != null) {
            setKpl(kpl);
        }

        String kuntanimi = (String) attributes.get("kuntanimi");

        if (kuntanimi != null) {
            setKuntanimi(kuntanimi);
        }

        Integer maakuntaid = (Integer) attributes.get("maakuntaid");

        if (maakuntaid != null) {
            setMaakuntaid(maakuntaid);
        }

        Integer kuntano = (Integer) attributes.get("kuntano");

        if (kuntano != null) {
            setKuntano(kuntano);
        }

        String kuntanimi_2014 = (String) attributes.get("kuntanimi_2014");

        if (kuntanimi_2014 != null) {
            setKuntanimi_2014(kuntanimi_2014);
        }
    }

    /**
    * Returns the primary key of this kuntainfo.
    *
    * @return the primary key of this kuntainfo
    */
    @Override
    public int getPrimaryKey() {
        return _kuntainfo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this kuntainfo.
    *
    * @param primaryKey the primary key of this kuntainfo
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _kuntainfo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the kuntaid of this kuntainfo.
    *
    * @return the kuntaid of this kuntainfo
    */
    @Override
    public int getKuntaid() {
        return _kuntainfo.getKuntaid();
    }

    /**
    * Sets the kuntaid of this kuntainfo.
    *
    * @param kuntaid the kuntaid of this kuntainfo
    */
    @Override
    public void setKuntaid(int kuntaid) {
        _kuntainfo.setKuntaid(kuntaid);
    }

    /**
    * Returns the capitalkuntanimi of this kuntainfo.
    *
    * @return the capitalkuntanimi of this kuntainfo
    */
    @Override
    public java.lang.String getCapitalkuntanimi() {
        return _kuntainfo.getCapitalkuntanimi();
    }

    /**
    * Sets the capitalkuntanimi of this kuntainfo.
    *
    * @param capitalkuntanimi the capitalkuntanimi of this kuntainfo
    */
    @Override
    public void setCapitalkuntanimi(java.lang.String capitalkuntanimi) {
        _kuntainfo.setCapitalkuntanimi(capitalkuntanimi);
    }

    /**
    * Returns the kpl of this kuntainfo.
    *
    * @return the kpl of this kuntainfo
    */
    @Override
    public int getKpl() {
        return _kuntainfo.getKpl();
    }

    /**
    * Sets the kpl of this kuntainfo.
    *
    * @param kpl the kpl of this kuntainfo
    */
    @Override
    public void setKpl(int kpl) {
        _kuntainfo.setKpl(kpl);
    }

    /**
    * Returns the kuntanimi of this kuntainfo.
    *
    * @return the kuntanimi of this kuntainfo
    */
    @Override
    public java.lang.String getKuntanimi() {
        return _kuntainfo.getKuntanimi();
    }

    /**
    * Sets the kuntanimi of this kuntainfo.
    *
    * @param kuntanimi the kuntanimi of this kuntainfo
    */
    @Override
    public void setKuntanimi(java.lang.String kuntanimi) {
        _kuntainfo.setKuntanimi(kuntanimi);
    }

    /**
    * Returns the maakuntaid of this kuntainfo.
    *
    * @return the maakuntaid of this kuntainfo
    */
    @Override
    public int getMaakuntaid() {
        return _kuntainfo.getMaakuntaid();
    }

    /**
    * Sets the maakuntaid of this kuntainfo.
    *
    * @param maakuntaid the maakuntaid of this kuntainfo
    */
    @Override
    public void setMaakuntaid(int maakuntaid) {
        _kuntainfo.setMaakuntaid(maakuntaid);
    }

    /**
    * Returns the kuntano of this kuntainfo.
    *
    * @return the kuntano of this kuntainfo
    */
    @Override
    public int getKuntano() {
        return _kuntainfo.getKuntano();
    }

    /**
    * Sets the kuntano of this kuntainfo.
    *
    * @param kuntano the kuntano of this kuntainfo
    */
    @Override
    public void setKuntano(int kuntano) {
        _kuntainfo.setKuntano(kuntano);
    }

    /**
    * Returns the kuntanimi_2014 of this kuntainfo.
    *
    * @return the kuntanimi_2014 of this kuntainfo
    */
    @Override
    public java.lang.String getKuntanimi_2014() {
        return _kuntainfo.getKuntanimi_2014();
    }

    /**
    * Sets the kuntanimi_2014 of this kuntainfo.
    *
    * @param kuntanimi_2014 the kuntanimi_2014 of this kuntainfo
    */
    @Override
    public void setKuntanimi_2014(java.lang.String kuntanimi_2014) {
        _kuntainfo.setKuntanimi_2014(kuntanimi_2014);
    }

    @Override
    public boolean isNew() {
        return _kuntainfo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _kuntainfo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _kuntainfo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _kuntainfo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _kuntainfo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _kuntainfo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _kuntainfo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _kuntainfo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _kuntainfo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _kuntainfo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _kuntainfo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new KuntainfoWrapper((Kuntainfo) _kuntainfo.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Kuntainfo kuntainfo) {
        return _kuntainfo.compareTo(kuntainfo);
    }

    @Override
    public int hashCode() {
        return _kuntainfo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Kuntainfo> toCacheModel() {
        return _kuntainfo.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo toEscapedModel() {
        return new KuntainfoWrapper(_kuntainfo.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo toUnescapedModel() {
        return new KuntainfoWrapper(_kuntainfo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _kuntainfo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _kuntainfo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _kuntainfo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof KuntainfoWrapper)) {
            return false;
        }

        KuntainfoWrapper kuntainfoWrapper = (KuntainfoWrapper) obj;

        if (Validator.equals(_kuntainfo, kuntainfoWrapper._kuntainfo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Kuntainfo getWrappedKuntainfo() {
        return _kuntainfo;
    }

    @Override
    public Kuntainfo getWrappedModel() {
        return _kuntainfo;
    }

    @Override
    public void resetOriginalValues() {
        _kuntainfo.resetOriginalValues();
    }
}
