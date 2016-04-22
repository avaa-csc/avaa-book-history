package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Julkaisulajiinfo}.
 * </p>
 *
 * @author CSC
 * @see Julkaisulajiinfo
 * @generated
 */
public class JulkaisulajiinfoWrapper implements Julkaisulajiinfo,
    ModelWrapper<Julkaisulajiinfo> {
    private Julkaisulajiinfo _julkaisulajiinfo;

    public JulkaisulajiinfoWrapper(Julkaisulajiinfo julkaisulajiinfo) {
        _julkaisulajiinfo = julkaisulajiinfo;
    }

    @Override
    public Class<?> getModelClass() {
        return Julkaisulajiinfo.class;
    }

    @Override
    public String getModelClassName() {
        return Julkaisulajiinfo.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("julklajiid", getJulklajiid());
        attributes.put("julklaji", getJulklaji());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer julklajiid = (Integer) attributes.get("julklajiid");

        if (julklajiid != null) {
            setJulklajiid(julklajiid);
        }

        String julklaji = (String) attributes.get("julklaji");

        if (julklaji != null) {
            setJulklaji(julklaji);
        }
    }

    /**
    * Returns the primary key of this julkaisulajiinfo.
    *
    * @return the primary key of this julkaisulajiinfo
    */
    @Override
    public int getPrimaryKey() {
        return _julkaisulajiinfo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this julkaisulajiinfo.
    *
    * @param primaryKey the primary key of this julkaisulajiinfo
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _julkaisulajiinfo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the julklajiid of this julkaisulajiinfo.
    *
    * @return the julklajiid of this julkaisulajiinfo
    */
    @Override
    public int getJulklajiid() {
        return _julkaisulajiinfo.getJulklajiid();
    }

    /**
    * Sets the julklajiid of this julkaisulajiinfo.
    *
    * @param julklajiid the julklajiid of this julkaisulajiinfo
    */
    @Override
    public void setJulklajiid(int julklajiid) {
        _julkaisulajiinfo.setJulklajiid(julklajiid);
    }

    /**
    * Returns the julklaji of this julkaisulajiinfo.
    *
    * @return the julklaji of this julkaisulajiinfo
    */
    @Override
    public java.lang.String getJulklaji() {
        return _julkaisulajiinfo.getJulklaji();
    }

    /**
    * Sets the julklaji of this julkaisulajiinfo.
    *
    * @param julklaji the julklaji of this julkaisulajiinfo
    */
    @Override
    public void setJulklaji(java.lang.String julklaji) {
        _julkaisulajiinfo.setJulklaji(julklaji);
    }

    @Override
    public boolean isNew() {
        return _julkaisulajiinfo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _julkaisulajiinfo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _julkaisulajiinfo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _julkaisulajiinfo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _julkaisulajiinfo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _julkaisulajiinfo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _julkaisulajiinfo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _julkaisulajiinfo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _julkaisulajiinfo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _julkaisulajiinfo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _julkaisulajiinfo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new JulkaisulajiinfoWrapper((Julkaisulajiinfo) _julkaisulajiinfo.clone());
    }

    @Override
    public int compareTo(
        fi.csc.avaa.khl.db.model.Julkaisulajiinfo julkaisulajiinfo) {
        return _julkaisulajiinfo.compareTo(julkaisulajiinfo);
    }

    @Override
    public int hashCode() {
        return _julkaisulajiinfo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Julkaisulajiinfo> toCacheModel() {
        return _julkaisulajiinfo.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo toEscapedModel() {
        return new JulkaisulajiinfoWrapper(_julkaisulajiinfo.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo toUnescapedModel() {
        return new JulkaisulajiinfoWrapper(_julkaisulajiinfo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _julkaisulajiinfo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _julkaisulajiinfo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _julkaisulajiinfo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof JulkaisulajiinfoWrapper)) {
            return false;
        }

        JulkaisulajiinfoWrapper julkaisulajiinfoWrapper = (JulkaisulajiinfoWrapper) obj;

        if (Validator.equals(_julkaisulajiinfo,
                    julkaisulajiinfoWrapper._julkaisulajiinfo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Julkaisulajiinfo getWrappedJulkaisulajiinfo() {
        return _julkaisulajiinfo;
    }

    @Override
    public Julkaisulajiinfo getWrappedModel() {
        return _julkaisulajiinfo;
    }

    @Override
    public void resetOriginalValues() {
        _julkaisulajiinfo.resetOriginalValues();
    }
}
