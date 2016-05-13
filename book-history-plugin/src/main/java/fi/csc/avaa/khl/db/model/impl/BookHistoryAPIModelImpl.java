package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.model.BookHistoryAPI;
import fi.csc.avaa.khl.db.model.BookHistoryAPIModel;
import fi.csc.avaa.khl.db.model.BookHistoryAPISoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the BookHistoryAPI service. Represents a row in the &quot;khl_BookHistoryAPI&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link fi.csc.avaa.khl.db.model.BookHistoryAPIModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BookHistoryAPIImpl}.
 * </p>
 *
 * @author CSC
 * @see BookHistoryAPIImpl
 * @see fi.csc.avaa.khl.db.model.BookHistoryAPI
 * @see fi.csc.avaa.khl.db.model.BookHistoryAPIModel
 * @generated
 */
@JSON(strict = true)
public class BookHistoryAPIModelImpl extends BaseModelImpl<BookHistoryAPI>
    implements BookHistoryAPIModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a book history a p i model instance should use the {@link fi.csc.avaa.khl.db.model.BookHistoryAPI} interface instead.
     */
    public static final String TABLE_NAME = "khl_BookHistoryAPI";
    public static final Object[][] TABLE_COLUMNS = {
            { "name", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table khl_BookHistoryAPI (name VARCHAR(75) not null primary key)";
    public static final String TABLE_SQL_DROP = "drop table khl_BookHistoryAPI";
    public static final String ORDER_BY_JPQL = " ORDER BY bookHistoryAPI.name ASC";
    public static final String ORDER_BY_SQL = " ORDER BY khl_BookHistoryAPI.name ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.fi.csc.avaa.khl.db.model.BookHistoryAPI"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.fi.csc.avaa.khl.db.model.BookHistoryAPI"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.fi.csc.avaa.khl.db.model.BookHistoryAPI"));
    private static ClassLoader _classLoader = BookHistoryAPI.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            BookHistoryAPI.class
        };
    private String _name;
    private BookHistoryAPI _escapedModel;

    public BookHistoryAPIModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static BookHistoryAPI toModel(BookHistoryAPISoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        BookHistoryAPI model = new BookHistoryAPIImpl();

        model.setName(soapModel.getName());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<BookHistoryAPI> toModels(BookHistoryAPISoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<BookHistoryAPI> models = new ArrayList<BookHistoryAPI>(soapModels.length);

        for (BookHistoryAPISoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public String getPrimaryKey() {
        return _name;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setName(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _name;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
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

    @JSON
    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public BookHistoryAPI toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (BookHistoryAPI) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        BookHistoryAPIImpl bookHistoryAPIImpl = new BookHistoryAPIImpl();

        bookHistoryAPIImpl.setName(getName());

        bookHistoryAPIImpl.resetOriginalValues();

        return bookHistoryAPIImpl;
    }

    @Override
    public int compareTo(BookHistoryAPI bookHistoryAPI) {
        String primaryKey = bookHistoryAPI.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BookHistoryAPI)) {
            return false;
        }

        BookHistoryAPI bookHistoryAPI = (BookHistoryAPI) obj;

        String primaryKey = bookHistoryAPI.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<BookHistoryAPI> toCacheModel() {
        BookHistoryAPICacheModel bookHistoryAPICacheModel = new BookHistoryAPICacheModel();

        bookHistoryAPICacheModel.name = getName();

        String name = bookHistoryAPICacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            bookHistoryAPICacheModel.name = null;
        }

        return bookHistoryAPICacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(3);

        sb.append("{name=");
        sb.append(getName());

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(7);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.BookHistoryAPI");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}