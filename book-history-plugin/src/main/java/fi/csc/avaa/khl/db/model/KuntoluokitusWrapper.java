package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Kuntoluokitus}.
 * </p>
 *
 * @author CSC
 * @see Kuntoluokitus
 * @generated
 */
public class KuntoluokitusWrapper implements Kuntoluokitus,
    ModelWrapper<Kuntoluokitus> {
    private Kuntoluokitus _kuntoluokitus;

    public KuntoluokitusWrapper(Kuntoluokitus kuntoluokitus) {
        _kuntoluokitus = kuntoluokitus;
    }

    @Override
    public Class<?> getModelClass() {
        return Kuntoluokitus.class;
    }

    @Override
    public String getModelClassName() {
        return Kuntoluokitus.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("kuntoid", getKuntoid());
        attributes.put("kunto", getKunto());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer kuntoid = (Integer) attributes.get("kuntoid");

        if (kuntoid != null) {
            setKuntoid(kuntoid);
        }

        String kunto = (String) attributes.get("kunto");

        if (kunto != null) {
            setKunto(kunto);
        }
    }

    /**
    * Returns the primary key of this kuntoluokitus.
    *
    * @return the primary key of this kuntoluokitus
    */
    @Override
    public int getPrimaryKey() {
        return _kuntoluokitus.getPrimaryKey();
    }

    /**
    * Sets the primary key of this kuntoluokitus.
    *
    * @param primaryKey the primary key of this kuntoluokitus
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _kuntoluokitus.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the kuntoid of this kuntoluokitus.
    *
    * @return the kuntoid of this kuntoluokitus
    */
    @Override
    public int getKuntoid() {
        return _kuntoluokitus.getKuntoid();
    }

    /**
    * Sets the kuntoid of this kuntoluokitus.
    *
    * @param kuntoid the kuntoid of this kuntoluokitus
    */
    @Override
    public void setKuntoid(int kuntoid) {
        _kuntoluokitus.setKuntoid(kuntoid);
    }

    /**
    * Returns the kunto of this kuntoluokitus.
    *
    * @return the kunto of this kuntoluokitus
    */
    @Override
    public java.lang.String getKunto() {
        return _kuntoluokitus.getKunto();
    }

    /**
    * Sets the kunto of this kuntoluokitus.
    *
    * @param kunto the kunto of this kuntoluokitus
    */
    @Override
    public void setKunto(java.lang.String kunto) {
        _kuntoluokitus.setKunto(kunto);
    }

    @Override
    public boolean isNew() {
        return _kuntoluokitus.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _kuntoluokitus.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _kuntoluokitus.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _kuntoluokitus.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _kuntoluokitus.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _kuntoluokitus.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _kuntoluokitus.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _kuntoluokitus.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _kuntoluokitus.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _kuntoluokitus.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _kuntoluokitus.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new KuntoluokitusWrapper((Kuntoluokitus) _kuntoluokitus.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus) {
        return _kuntoluokitus.compareTo(kuntoluokitus);
    }

    @Override
    public int hashCode() {
        return _kuntoluokitus.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Kuntoluokitus> toCacheModel() {
        return _kuntoluokitus.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus toEscapedModel() {
        return new KuntoluokitusWrapper(_kuntoluokitus.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus toUnescapedModel() {
        return new KuntoluokitusWrapper(_kuntoluokitus.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _kuntoluokitus.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _kuntoluokitus.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _kuntoluokitus.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof KuntoluokitusWrapper)) {
            return false;
        }

        KuntoluokitusWrapper kuntoluokitusWrapper = (KuntoluokitusWrapper) obj;

        if (Validator.equals(_kuntoluokitus, kuntoluokitusWrapper._kuntoluokitus)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Kuntoluokitus getWrappedKuntoluokitus() {
        return _kuntoluokitus;
    }

    @Override
    public Kuntoluokitus getWrappedModel() {
        return _kuntoluokitus;
    }

    @Override
    public void resetOriginalValues() {
        _kuntoluokitus.resetOriginalValues();
    }
}
