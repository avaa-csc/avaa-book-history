package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.model.Teospk;
import fi.csc.avaa.khl.db.model.TeospkModel;
import fi.csc.avaa.khl.db.model.TeospkSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Teospk service. Represents a row in the &quot;teospk&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link fi.csc.avaa.khl.db.model.TeospkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TeospkImpl}.
 * </p>
 *
 * @author CSC
 * @see TeospkImpl
 * @see fi.csc.avaa.khl.db.model.Teospk
 * @see fi.csc.avaa.khl.db.model.TeospkModel
 * @generated
 */
@JSON(strict = true)
public class TeospkModelImpl extends BaseModelImpl<Teospk>
    implements TeospkModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a teospk model instance should use the {@link fi.csc.avaa.khl.db.model.Teospk} interface instead.
     */
    public static final String TABLE_NAME = "teospk";
    public static final Object[][] TABLE_COLUMNS = {
            { "teospkid", Types.INTEGER },
            { "teospknimi", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table teospk (teospkid INTEGER not null primary key,teospknimi VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table teospk";
    public static final String ORDER_BY_JPQL = " ORDER BY teospk.teospkid ASC";
    public static final String ORDER_BY_SQL = " ORDER BY teospk.teospkid ASC";
    public static final String DATA_SOURCE = "khl";
    public static final String SESSION_FACTORY = "khlSessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.fi.csc.avaa.khl.db.model.Teospk"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.fi.csc.avaa.khl.db.model.Teospk"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.fi.csc.avaa.khl.db.model.Teospk"),
            true);
    public static long TEOSPKNIMI_COLUMN_BITMASK = 1L;
    public static long TEOSPKID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.fi.csc.avaa.khl.db.model.Teospk"));
    private static ClassLoader _classLoader = Teospk.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Teospk.class };
    private int _teospkid;
    private String _teospknimi;
    private String _originalTeospknimi;
    private long _columnBitmask;
    private Teospk _escapedModel;

    public TeospkModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Teospk toModel(TeospkSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Teospk model = new TeospkImpl();

        model.setTeospkid(soapModel.getTeospkid());
        model.setTeospknimi(soapModel.getTeospknimi());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Teospk> toModels(TeospkSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Teospk> models = new ArrayList<Teospk>(soapModels.length);

        for (TeospkSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public int getPrimaryKey() {
        return _teospkid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setTeospkid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _teospkid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
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

    @JSON
    @Override
    public int getTeospkid() {
        return _teospkid;
    }

    @Override
    public void setTeospkid(int teospkid) {
        _teospkid = teospkid;
    }

    @JSON
    @Override
    public String getTeospknimi() {
        if (_teospknimi == null) {
            return StringPool.BLANK;
        } else {
            return _teospknimi;
        }
    }

    @Override
    public void setTeospknimi(String teospknimi) {
        _columnBitmask |= TEOSPKNIMI_COLUMN_BITMASK;

        if (_originalTeospknimi == null) {
            _originalTeospknimi = _teospknimi;
        }

        _teospknimi = teospknimi;
    }

    public String getOriginalTeospknimi() {
        return GetterUtil.getString(_originalTeospknimi);
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public Teospk toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Teospk) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        TeospkImpl teospkImpl = new TeospkImpl();

        teospkImpl.setTeospkid(getTeospkid());
        teospkImpl.setTeospknimi(getTeospknimi());

        teospkImpl.resetOriginalValues();

        return teospkImpl;
    }

    @Override
    public int compareTo(Teospk teospk) {
        int primaryKey = teospk.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Teospk)) {
            return false;
        }

        Teospk teospk = (Teospk) obj;

        int primaryKey = teospk.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        TeospkModelImpl teospkModelImpl = this;

        teospkModelImpl._originalTeospknimi = teospkModelImpl._teospknimi;

        teospkModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Teospk> toCacheModel() {
        TeospkCacheModel teospkCacheModel = new TeospkCacheModel();

        teospkCacheModel.teospkid = getTeospkid();

        teospkCacheModel.teospknimi = getTeospknimi();

        String teospknimi = teospkCacheModel.teospknimi;

        if ((teospknimi != null) && (teospknimi.length() == 0)) {
            teospkCacheModel.teospknimi = null;
        }

        return teospkCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{teospkid=");
        sb.append(getTeospkid());
        sb.append(", teospknimi=");
        sb.append(getTeospknimi());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Teospk");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>teospkid</column-name><column-value><![CDATA[");
        sb.append(getTeospkid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>teospknimi</column-name><column-value><![CDATA[");
        sb.append(getTeospknimi());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
