package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Maakuntainfo}.
 * </p>
 *
 * @author CSC
 * @see Maakuntainfo
 * @generated
 */
public class MaakuntainfoWrapper implements Maakuntainfo,
    ModelWrapper<Maakuntainfo> {
    private Maakuntainfo _maakuntainfo;

    public MaakuntainfoWrapper(Maakuntainfo maakuntainfo) {
        _maakuntainfo = maakuntainfo;
    }

    @Override
    public Class<?> getModelClass() {
        return Maakuntainfo.class;
    }

    @Override
    public String getModelClassName() {
        return Maakuntainfo.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("maakuntaid", getMaakuntaid());
        attributes.put("maakunta", getMaakunta());
        attributes.put("kpl", getKpl());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer maakuntaid = (Integer) attributes.get("maakuntaid");

        if (maakuntaid != null) {
            setMaakuntaid(maakuntaid);
        }

        String maakunta = (String) attributes.get("maakunta");

        if (maakunta != null) {
            setMaakunta(maakunta);
        }

        Integer kpl = (Integer) attributes.get("kpl");

        if (kpl != null) {
            setKpl(kpl);
        }
    }

    /**
    * Returns the primary key of this maakuntainfo.
    *
    * @return the primary key of this maakuntainfo
    */
    @Override
    public int getPrimaryKey() {
        return _maakuntainfo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this maakuntainfo.
    *
    * @param primaryKey the primary key of this maakuntainfo
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _maakuntainfo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the maakuntaid of this maakuntainfo.
    *
    * @return the maakuntaid of this maakuntainfo
    */
    @Override
    public int getMaakuntaid() {
        return _maakuntainfo.getMaakuntaid();
    }

    /**
    * Sets the maakuntaid of this maakuntainfo.
    *
    * @param maakuntaid the maakuntaid of this maakuntainfo
    */
    @Override
    public void setMaakuntaid(int maakuntaid) {
        _maakuntainfo.setMaakuntaid(maakuntaid);
    }

    /**
    * Returns the maakunta of this maakuntainfo.
    *
    * @return the maakunta of this maakuntainfo
    */
    @Override
    public java.lang.String getMaakunta() {
        return _maakuntainfo.getMaakunta();
    }

    /**
    * Sets the maakunta of this maakuntainfo.
    *
    * @param maakunta the maakunta of this maakuntainfo
    */
    @Override
    public void setMaakunta(java.lang.String maakunta) {
        _maakuntainfo.setMaakunta(maakunta);
    }

    /**
    * Returns the kpl of this maakuntainfo.
    *
    * @return the kpl of this maakuntainfo
    */
    @Override
    public int getKpl() {
        return _maakuntainfo.getKpl();
    }

    /**
    * Sets the kpl of this maakuntainfo.
    *
    * @param kpl the kpl of this maakuntainfo
    */
    @Override
    public void setKpl(int kpl) {
        _maakuntainfo.setKpl(kpl);
    }

    @Override
    public boolean isNew() {
        return _maakuntainfo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _maakuntainfo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _maakuntainfo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _maakuntainfo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _maakuntainfo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _maakuntainfo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _maakuntainfo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _maakuntainfo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _maakuntainfo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _maakuntainfo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _maakuntainfo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MaakuntainfoWrapper((Maakuntainfo) _maakuntainfo.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo) {
        return _maakuntainfo.compareTo(maakuntainfo);
    }

    @Override
    public int hashCode() {
        return _maakuntainfo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Maakuntainfo> toCacheModel() {
        return _maakuntainfo.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo toEscapedModel() {
        return new MaakuntainfoWrapper(_maakuntainfo.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo toUnescapedModel() {
        return new MaakuntainfoWrapper(_maakuntainfo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _maakuntainfo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _maakuntainfo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _maakuntainfo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MaakuntainfoWrapper)) {
            return false;
        }

        MaakuntainfoWrapper maakuntainfoWrapper = (MaakuntainfoWrapper) obj;

        if (Validator.equals(_maakuntainfo, maakuntainfoWrapper._maakuntainfo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Maakuntainfo getWrappedMaakuntainfo() {
        return _maakuntainfo;
    }

    @Override
    public Maakuntainfo getWrappedModel() {
        return _maakuntainfo;
    }

    @Override
    public void resetOriginalValues() {
        _maakuntainfo.resetOriginalValues();
    }
}
