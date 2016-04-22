package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Kieliinfo}.
 * </p>
 *
 * @author CSC
 * @see Kieliinfo
 * @generated
 */
public class KieliinfoWrapper implements Kieliinfo, ModelWrapper<Kieliinfo> {
    private Kieliinfo _kieliinfo;

    public KieliinfoWrapper(Kieliinfo kieliinfo) {
        _kieliinfo = kieliinfo;
    }

    @Override
    public Class<?> getModelClass() {
        return Kieliinfo.class;
    }

    @Override
    public String getModelClassName() {
        return Kieliinfo.class.getName();
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
    * Returns the primary key of this kieliinfo.
    *
    * @return the primary key of this kieliinfo
    */
    @Override
    public int getPrimaryKey() {
        return _kieliinfo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this kieliinfo.
    *
    * @param primaryKey the primary key of this kieliinfo
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _kieliinfo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the kieliid of this kieliinfo.
    *
    * @return the kieliid of this kieliinfo
    */
    @Override
    public int getKieliid() {
        return _kieliinfo.getKieliid();
    }

    /**
    * Sets the kieliid of this kieliinfo.
    *
    * @param kieliid the kieliid of this kieliinfo
    */
    @Override
    public void setKieliid(int kieliid) {
        _kieliinfo.setKieliid(kieliid);
    }

    /**
    * Returns the kieli of this kieliinfo.
    *
    * @return the kieli of this kieliinfo
    */
    @Override
    public java.lang.String getKieli() {
        return _kieliinfo.getKieli();
    }

    /**
    * Sets the kieli of this kieliinfo.
    *
    * @param kieli the kieli of this kieliinfo
    */
    @Override
    public void setKieli(java.lang.String kieli) {
        _kieliinfo.setKieli(kieli);
    }

    @Override
    public boolean isNew() {
        return _kieliinfo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _kieliinfo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _kieliinfo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _kieliinfo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _kieliinfo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _kieliinfo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _kieliinfo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _kieliinfo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _kieliinfo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _kieliinfo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _kieliinfo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new KieliinfoWrapper((Kieliinfo) _kieliinfo.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo) {
        return _kieliinfo.compareTo(kieliinfo);
    }

    @Override
    public int hashCode() {
        return _kieliinfo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Kieliinfo> toCacheModel() {
        return _kieliinfo.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo toEscapedModel() {
        return new KieliinfoWrapper(_kieliinfo.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo toUnescapedModel() {
        return new KieliinfoWrapper(_kieliinfo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _kieliinfo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _kieliinfo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _kieliinfo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof KieliinfoWrapper)) {
            return false;
        }

        KieliinfoWrapper kieliinfoWrapper = (KieliinfoWrapper) obj;

        if (Validator.equals(_kieliinfo, kieliinfoWrapper._kieliinfo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Kieliinfo getWrappedKieliinfo() {
        return _kieliinfo;
    }

    @Override
    public Kieliinfo getWrappedModel() {
        return _kieliinfo;
    }

    @Override
    public void resetOriginalValues() {
        _kieliinfo.resetOriginalValues();
    }
}
