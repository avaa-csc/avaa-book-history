package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Kielesta}.
 * </p>
 *
 * @author CSC
 * @see Kielesta
 * @generated
 */
public class KielestaWrapper implements Kielesta, ModelWrapper<Kielesta> {
    private Kielesta _kielesta;

    public KielestaWrapper(Kielesta kielesta) {
        _kielesta = kielesta;
    }

    @Override
    public Class<?> getModelClass() {
        return Kielesta.class;
    }

    @Override
    public String getModelClassName() {
        return Kielesta.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("kieliid", getKieliid());
        attributes.put("kieli", getKieli());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer kieliid = (Integer) attributes.get("kieliid");

        if (kieliid != null) {
            setKieliid(kieliid);
        }

        String kieli = (String) attributes.get("kieli");

        if (kieli != null) {
            setKieli(kieli);
        }
    }

    /**
    * Returns the primary key of this kielesta.
    *
    * @return the primary key of this kielesta
    */
    @Override
    public int getPrimaryKey() {
        return _kielesta.getPrimaryKey();
    }

    /**
    * Sets the primary key of this kielesta.
    *
    * @param primaryKey the primary key of this kielesta
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _kielesta.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the kieliid of this kielesta.
    *
    * @return the kieliid of this kielesta
    */
    @Override
    public int getKieliid() {
        return _kielesta.getKieliid();
    }

    /**
    * Sets the kieliid of this kielesta.
    *
    * @param kieliid the kieliid of this kielesta
    */
    @Override
    public void setKieliid(int kieliid) {
        _kielesta.setKieliid(kieliid);
    }

    /**
    * Returns the kieli of this kielesta.
    *
    * @return the kieli of this kielesta
    */
    @Override
    public java.lang.String getKieli() {
        return _kielesta.getKieli();
    }

    /**
    * Sets the kieli of this kielesta.
    *
    * @param kieli the kieli of this kielesta
    */
    @Override
    public void setKieli(java.lang.String kieli) {
        _kielesta.setKieli(kieli);
    }

    @Override
    public boolean isNew() {
        return _kielesta.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _kielesta.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _kielesta.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _kielesta.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _kielesta.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _kielesta.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _kielesta.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _kielesta.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _kielesta.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _kielesta.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _kielesta.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new KielestaWrapper((Kielesta) _kielesta.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Kielesta kielesta) {
        return _kielesta.compareTo(kielesta);
    }

    @Override
    public int hashCode() {
        return _kielesta.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Kielesta> toCacheModel() {
        return _kielesta.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kielesta toEscapedModel() {
        return new KielestaWrapper(_kielesta.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kielesta toUnescapedModel() {
        return new KielestaWrapper(_kielesta.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _kielesta.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _kielesta.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _kielesta.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof KielestaWrapper)) {
            return false;
        }

        KielestaWrapper kielestaWrapper = (KielestaWrapper) obj;

        if (Validator.equals(_kielesta, kielestaWrapper._kielesta)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Kielesta getWrappedKielesta() {
        return _kielesta;
    }

    @Override
    public Kielesta getWrappedModel() {
        return _kielesta;
    }

    @Override
    public void resetOriginalValues() {
        _kielesta.resetOriginalValues();
    }
}
