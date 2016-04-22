package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Kartoituskohde}.
 * </p>
 *
 * @author CSC
 * @see Kartoituskohde
 * @generated
 */
public class KartoituskohdeWrapper implements Kartoituskohde,
    ModelWrapper<Kartoituskohde> {
    private Kartoituskohde _kartoituskohde;

    public KartoituskohdeWrapper(Kartoituskohde kartoituskohde) {
        _kartoituskohde = kartoituskohde;
    }

    @Override
    public Class<?> getModelClass() {
        return Kartoituskohde.class;
    }

    @Override
    public String getModelClassName() {
        return Kartoituskohde.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("kohdeid", getKohdeid());
        attributes.put("kartkohde", getKartkohde());
        attributes.put("kpl", getKpl());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer kohdeid = (Integer) attributes.get("kohdeid");

        if (kohdeid != null) {
            setKohdeid(kohdeid);
        }

        String kartkohde = (String) attributes.get("kartkohde");

        if (kartkohde != null) {
            setKartkohde(kartkohde);
        }

        Integer kpl = (Integer) attributes.get("kpl");

        if (kpl != null) {
            setKpl(kpl);
        }
    }

    /**
    * Returns the primary key of this kartoituskohde.
    *
    * @return the primary key of this kartoituskohde
    */
    @Override
    public int getPrimaryKey() {
        return _kartoituskohde.getPrimaryKey();
    }

    /**
    * Sets the primary key of this kartoituskohde.
    *
    * @param primaryKey the primary key of this kartoituskohde
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _kartoituskohde.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the kohdeid of this kartoituskohde.
    *
    * @return the kohdeid of this kartoituskohde
    */
    @Override
    public int getKohdeid() {
        return _kartoituskohde.getKohdeid();
    }

    /**
    * Sets the kohdeid of this kartoituskohde.
    *
    * @param kohdeid the kohdeid of this kartoituskohde
    */
    @Override
    public void setKohdeid(int kohdeid) {
        _kartoituskohde.setKohdeid(kohdeid);
    }

    /**
    * Returns the kartkohde of this kartoituskohde.
    *
    * @return the kartkohde of this kartoituskohde
    */
    @Override
    public java.lang.String getKartkohde() {
        return _kartoituskohde.getKartkohde();
    }

    /**
    * Sets the kartkohde of this kartoituskohde.
    *
    * @param kartkohde the kartkohde of this kartoituskohde
    */
    @Override
    public void setKartkohde(java.lang.String kartkohde) {
        _kartoituskohde.setKartkohde(kartkohde);
    }

    /**
    * Returns the kpl of this kartoituskohde.
    *
    * @return the kpl of this kartoituskohde
    */
    @Override
    public int getKpl() {
        return _kartoituskohde.getKpl();
    }

    /**
    * Sets the kpl of this kartoituskohde.
    *
    * @param kpl the kpl of this kartoituskohde
    */
    @Override
    public void setKpl(int kpl) {
        _kartoituskohde.setKpl(kpl);
    }

    @Override
    public boolean isNew() {
        return _kartoituskohde.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _kartoituskohde.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _kartoituskohde.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _kartoituskohde.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _kartoituskohde.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _kartoituskohde.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _kartoituskohde.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _kartoituskohde.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _kartoituskohde.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _kartoituskohde.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _kartoituskohde.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new KartoituskohdeWrapper((Kartoituskohde) _kartoituskohde.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde) {
        return _kartoituskohde.compareTo(kartoituskohde);
    }

    @Override
    public int hashCode() {
        return _kartoituskohde.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Kartoituskohde> toCacheModel() {
        return _kartoituskohde.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde toEscapedModel() {
        return new KartoituskohdeWrapper(_kartoituskohde.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde toUnescapedModel() {
        return new KartoituskohdeWrapper(_kartoituskohde.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _kartoituskohde.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _kartoituskohde.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _kartoituskohde.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof KartoituskohdeWrapper)) {
            return false;
        }

        KartoituskohdeWrapper kartoituskohdeWrapper = (KartoituskohdeWrapper) obj;

        if (Validator.equals(_kartoituskohde,
                    kartoituskohdeWrapper._kartoituskohde)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Kartoituskohde getWrappedKartoituskohde() {
        return _kartoituskohde;
    }

    @Override
    public Kartoituskohde getWrappedModel() {
        return _kartoituskohde;
    }

    @Override
    public void resetOriginalValues() {
        _kartoituskohde.resetOriginalValues();
    }
}
