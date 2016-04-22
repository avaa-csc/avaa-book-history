package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Puute}.
 * </p>
 *
 * @author CSC
 * @see Puute
 * @generated
 */
public class PuuteWrapper implements Puute, ModelWrapper<Puute> {
    private Puute _puute;

    public PuuteWrapper(Puute puute) {
        _puute = puute;
    }

    @Override
    public Class<?> getModelClass() {
        return Puute.class;
    }

    @Override
    public String getModelClassName() {
        return Puute.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("puuteid", getPuuteid());
        attributes.put("puutenimi", getPuutenimi());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer puuteid = (Integer) attributes.get("puuteid");

        if (puuteid != null) {
            setPuuteid(puuteid);
        }

        String puutenimi = (String) attributes.get("puutenimi");

        if (puutenimi != null) {
            setPuutenimi(puutenimi);
        }
    }

    /**
    * Returns the primary key of this puute.
    *
    * @return the primary key of this puute
    */
    @Override
    public int getPrimaryKey() {
        return _puute.getPrimaryKey();
    }

    /**
    * Sets the primary key of this puute.
    *
    * @param primaryKey the primary key of this puute
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _puute.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the puuteid of this puute.
    *
    * @return the puuteid of this puute
    */
    @Override
    public int getPuuteid() {
        return _puute.getPuuteid();
    }

    /**
    * Sets the puuteid of this puute.
    *
    * @param puuteid the puuteid of this puute
    */
    @Override
    public void setPuuteid(int puuteid) {
        _puute.setPuuteid(puuteid);
    }

    /**
    * Returns the puutenimi of this puute.
    *
    * @return the puutenimi of this puute
    */
    @Override
    public java.lang.String getPuutenimi() {
        return _puute.getPuutenimi();
    }

    /**
    * Sets the puutenimi of this puute.
    *
    * @param puutenimi the puutenimi of this puute
    */
    @Override
    public void setPuutenimi(java.lang.String puutenimi) {
        _puute.setPuutenimi(puutenimi);
    }

    @Override
    public boolean isNew() {
        return _puute.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _puute.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _puute.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _puute.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _puute.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _puute.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _puute.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _puute.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _puute.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _puute.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _puute.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PuuteWrapper((Puute) _puute.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Puute puute) {
        return _puute.compareTo(puute);
    }

    @Override
    public int hashCode() {
        return _puute.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Puute> toCacheModel() {
        return _puute.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Puute toEscapedModel() {
        return new PuuteWrapper(_puute.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Puute toUnescapedModel() {
        return new PuuteWrapper(_puute.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _puute.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _puute.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _puute.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PuuteWrapper)) {
            return false;
        }

        PuuteWrapper puuteWrapper = (PuuteWrapper) obj;

        if (Validator.equals(_puute, puuteWrapper._puute)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Puute getWrappedPuute() {
        return _puute;
    }

    @Override
    public Puute getWrappedModel() {
        return _puute;
    }

    @Override
    public void resetOriginalValues() {
        _puute.resetOriginalValues();
    }
}
