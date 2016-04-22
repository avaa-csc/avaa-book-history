package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Teospk}.
 * </p>
 *
 * @author CSC
 * @see Teospk
 * @generated
 */
public class TeospkWrapper implements Teospk, ModelWrapper<Teospk> {
    private Teospk _teospk;

    public TeospkWrapper(Teospk teospk) {
        _teospk = teospk;
    }

    @Override
    public Class<?> getModelClass() {
        return Teospk.class;
    }

    @Override
    public String getModelClassName() {
        return Teospk.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("teospkid", getTeospkid());
        attributes.put("teospknimi", getTeospknimi());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer teospkid = (Integer) attributes.get("teospkid");

        if (teospkid != null) {
            setTeospkid(teospkid);
        }

        String teospknimi = (String) attributes.get("teospknimi");

        if (teospknimi != null) {
            setTeospknimi(teospknimi);
        }
    }

    /**
    * Returns the primary key of this teospk.
    *
    * @return the primary key of this teospk
    */
    @Override
    public int getPrimaryKey() {
        return _teospk.getPrimaryKey();
    }

    /**
    * Sets the primary key of this teospk.
    *
    * @param primaryKey the primary key of this teospk
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _teospk.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the teospkid of this teospk.
    *
    * @return the teospkid of this teospk
    */
    @Override
    public int getTeospkid() {
        return _teospk.getTeospkid();
    }

    /**
    * Sets the teospkid of this teospk.
    *
    * @param teospkid the teospkid of this teospk
    */
    @Override
    public void setTeospkid(int teospkid) {
        _teospk.setTeospkid(teospkid);
    }

    /**
    * Returns the teospknimi of this teospk.
    *
    * @return the teospknimi of this teospk
    */
    @Override
    public java.lang.String getTeospknimi() {
        return _teospk.getTeospknimi();
    }

    /**
    * Sets the teospknimi of this teospk.
    *
    * @param teospknimi the teospknimi of this teospk
    */
    @Override
    public void setTeospknimi(java.lang.String teospknimi) {
        _teospk.setTeospknimi(teospknimi);
    }

    @Override
    public boolean isNew() {
        return _teospk.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _teospk.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _teospk.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _teospk.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _teospk.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _teospk.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _teospk.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _teospk.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _teospk.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _teospk.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _teospk.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TeospkWrapper((Teospk) _teospk.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Teospk teospk) {
        return _teospk.compareTo(teospk);
    }

    @Override
    public int hashCode() {
        return _teospk.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Teospk> toCacheModel() {
        return _teospk.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Teospk toEscapedModel() {
        return new TeospkWrapper(_teospk.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Teospk toUnescapedModel() {
        return new TeospkWrapper(_teospk.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _teospk.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _teospk.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _teospk.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TeospkWrapper)) {
            return false;
        }

        TeospkWrapper teospkWrapper = (TeospkWrapper) obj;

        if (Validator.equals(_teospk, teospkWrapper._teospk)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Teospk getWrappedTeospk() {
        return _teospk;
    }

    @Override
    public Teospk getWrappedModel() {
        return _teospk;
    }

    @Override
    public void resetOriginalValues() {
        _teospk.resetOriginalValues();
    }
}
