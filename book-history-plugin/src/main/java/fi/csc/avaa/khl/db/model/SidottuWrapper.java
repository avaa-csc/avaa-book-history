package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Sidottu}.
 * </p>
 *
 * @author CSC
 * @see Sidottu
 * @generated
 */
public class SidottuWrapper implements Sidottu, ModelWrapper<Sidottu> {
    private Sidottu _sidottu;

    public SidottuWrapper(Sidottu sidottu) {
        _sidottu = sidottu;
    }

    @Override
    public Class<?> getModelClass() {
        return Sidottu.class;
    }

    @Override
    public String getModelClassName() {
        return Sidottu.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("sidontaid", getSidontaid());
        attributes.put("sidonta", getSidonta());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer sidontaid = (Integer) attributes.get("sidontaid");

        if (sidontaid != null) {
            setSidontaid(sidontaid);
        }

        String sidonta = (String) attributes.get("sidonta");

        if (sidonta != null) {
            setSidonta(sidonta);
        }
    }

    /**
    * Returns the primary key of this sidottu.
    *
    * @return the primary key of this sidottu
    */
    @Override
    public int getPrimaryKey() {
        return _sidottu.getPrimaryKey();
    }

    /**
    * Sets the primary key of this sidottu.
    *
    * @param primaryKey the primary key of this sidottu
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _sidottu.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the sidontaid of this sidottu.
    *
    * @return the sidontaid of this sidottu
    */
    @Override
    public int getSidontaid() {
        return _sidottu.getSidontaid();
    }

    /**
    * Sets the sidontaid of this sidottu.
    *
    * @param sidontaid the sidontaid of this sidottu
    */
    @Override
    public void setSidontaid(int sidontaid) {
        _sidottu.setSidontaid(sidontaid);
    }

    /**
    * Returns the sidonta of this sidottu.
    *
    * @return the sidonta of this sidottu
    */
    @Override
    public java.lang.String getSidonta() {
        return _sidottu.getSidonta();
    }

    /**
    * Sets the sidonta of this sidottu.
    *
    * @param sidonta the sidonta of this sidottu
    */
    @Override
    public void setSidonta(java.lang.String sidonta) {
        _sidottu.setSidonta(sidonta);
    }

    @Override
    public boolean isNew() {
        return _sidottu.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _sidottu.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _sidottu.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _sidottu.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _sidottu.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _sidottu.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _sidottu.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _sidottu.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _sidottu.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _sidottu.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _sidottu.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SidottuWrapper((Sidottu) _sidottu.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Sidottu sidottu) {
        return _sidottu.compareTo(sidottu);
    }

    @Override
    public int hashCode() {
        return _sidottu.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Sidottu> toCacheModel() {
        return _sidottu.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Sidottu toEscapedModel() {
        return new SidottuWrapper(_sidottu.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Sidottu toUnescapedModel() {
        return new SidottuWrapper(_sidottu.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _sidottu.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _sidottu.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _sidottu.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SidottuWrapper)) {
            return false;
        }

        SidottuWrapper sidottuWrapper = (SidottuWrapper) obj;

        if (Validator.equals(_sidottu, sidottuWrapper._sidottu)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Sidottu getWrappedSidottu() {
        return _sidottu;
    }

    @Override
    public Sidottu getWrappedModel() {
        return _sidottu;
    }

    @Override
    public void resetOriginalValues() {
        _sidottu.resetOriginalValues();
    }
}
