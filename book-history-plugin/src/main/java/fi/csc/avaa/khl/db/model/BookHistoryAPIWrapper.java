package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BookHistoryAPI}.
 * </p>
 *
 * @author CSC
 * @see BookHistoryAPI
 * @generated
 */
public class BookHistoryAPIWrapper implements BookHistoryAPI,
    ModelWrapper<BookHistoryAPI> {
    private BookHistoryAPI _bookHistoryAPI;

    public BookHistoryAPIWrapper(BookHistoryAPI bookHistoryAPI) {
        _bookHistoryAPI = bookHistoryAPI;
    }

    @Override
    public Class<?> getModelClass() {
        return BookHistoryAPI.class;
    }

    @Override
    public String getModelClassName() {
        return BookHistoryAPI.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    /**
    * Returns the primary key of this book history a p i.
    *
    * @return the primary key of this book history a p i
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _bookHistoryAPI.getPrimaryKey();
    }

    /**
    * Sets the primary key of this book history a p i.
    *
    * @param primaryKey the primary key of this book history a p i
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _bookHistoryAPI.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the name of this book history a p i.
    *
    * @return the name of this book history a p i
    */
    @Override
    public java.lang.String getName() {
        return _bookHistoryAPI.getName();
    }

    /**
    * Sets the name of this book history a p i.
    *
    * @param name the name of this book history a p i
    */
    @Override
    public void setName(java.lang.String name) {
        _bookHistoryAPI.setName(name);
    }

    @Override
    public boolean isNew() {
        return _bookHistoryAPI.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _bookHistoryAPI.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _bookHistoryAPI.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _bookHistoryAPI.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _bookHistoryAPI.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _bookHistoryAPI.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _bookHistoryAPI.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _bookHistoryAPI.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _bookHistoryAPI.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _bookHistoryAPI.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _bookHistoryAPI.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BookHistoryAPIWrapper((BookHistoryAPI) _bookHistoryAPI.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.BookHistoryAPI bookHistoryAPI) {
        return _bookHistoryAPI.compareTo(bookHistoryAPI);
    }

    @Override
    public int hashCode() {
        return _bookHistoryAPI.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.BookHistoryAPI> toCacheModel() {
        return _bookHistoryAPI.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.BookHistoryAPI toEscapedModel() {
        return new BookHistoryAPIWrapper(_bookHistoryAPI.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.BookHistoryAPI toUnescapedModel() {
        return new BookHistoryAPIWrapper(_bookHistoryAPI.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _bookHistoryAPI.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _bookHistoryAPI.toXmlString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BookHistoryAPIWrapper)) {
            return false;
        }

        BookHistoryAPIWrapper bookHistoryAPIWrapper = (BookHistoryAPIWrapper) obj;

        if (Validator.equals(_bookHistoryAPI,
                    bookHistoryAPIWrapper._bookHistoryAPI)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public BookHistoryAPI getWrappedBookHistoryAPI() {
        return _bookHistoryAPI;
    }

    @Override
    public BookHistoryAPI getWrappedModel() {
        return _bookHistoryAPI;
    }

    @Override
    public void resetOriginalValues() {
        _bookHistoryAPI.resetOriginalValues();
    }
}
