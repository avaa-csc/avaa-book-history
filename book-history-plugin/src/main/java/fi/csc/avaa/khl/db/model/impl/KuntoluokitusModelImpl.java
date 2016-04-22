package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.model.Kuntoluokitus;
import fi.csc.avaa.khl.db.model.KuntoluokitusModel;
import fi.csc.avaa.khl.db.model.KuntoluokitusSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Kuntoluokitus service. Represents a row in the &quot;kuntoluokitus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link fi.csc.avaa.khl.db.model.KuntoluokitusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KuntoluokitusImpl}.
 * </p>
 *
 * @author CSC
 * @see KuntoluokitusImpl
 * @see fi.csc.avaa.khl.db.model.Kuntoluokitus
 * @see fi.csc.avaa.khl.db.model.KuntoluokitusModel
 * @generated
 */
@JSON(strict = true)
public class KuntoluokitusModelImpl extends BaseModelImpl<Kuntoluokitus>
    implements KuntoluokitusModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a kuntoluokitus model instance should use the {@link fi.csc.avaa.khl.db.model.Kuntoluokitus} interface instead.
     */
    public static final String TABLE_NAME = "kuntoluokitus";
    public static final Object[][] TABLE_COLUMNS = {
            { "kuntoid", Types.INTEGER },
            { "kunto", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table kuntoluokitus (kuntoid INTEGER not null primary key,kunto VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table kuntoluokitus";
    public static final String ORDER_BY_JPQL = " ORDER BY kuntoluokitus.kuntoid ASC";
    public static final String ORDER_BY_SQL = " ORDER BY kuntoluokitus.kuntoid ASC";
    public static final String DATA_SOURCE = "khl";
    public static final String SESSION_FACTORY = "khlSessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.fi.csc.avaa.khl.db.model.Kuntoluokitus"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.fi.csc.avaa.khl.db.model.Kuntoluokitus"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.fi.csc.avaa.khl.db.model.Kuntoluokitus"),
            true);
    public static long KUNTO_COLUMN_BITMASK = 1L;
    public static long KUNTOID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.fi.csc.avaa.khl.db.model.Kuntoluokitus"));
    private static ClassLoader _classLoader = Kuntoluokitus.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Kuntoluokitus.class
        };
    private int _kuntoid;
    private String _kunto;
    private String _originalKunto;
    private long _columnBitmask;
    private Kuntoluokitus _escapedModel;

    public KuntoluokitusModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Kuntoluokitus toModel(KuntoluokitusSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Kuntoluokitus model = new KuntoluokitusImpl();

        model.setKuntoid(soapModel.getKuntoid());
        model.setKunto(soapModel.getKunto());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Kuntoluokitus> toModels(KuntoluokitusSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Kuntoluokitus> models = new ArrayList<Kuntoluokitus>(soapModels.length);

        for (KuntoluokitusSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public int getPrimaryKey() {
        return _kuntoid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setKuntoid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _kuntoid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Kuntoluokitus.class;
    }

    @Override
    public String getModelClassName() {
        return Kuntoluokitus.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("kuntoid", getKuntoid());
        attributes.put("kunto", getKunto());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer kuntoid = (Integer) attributes.get("kuntoid");

        if (kuntoid != null) {
            setKuntoid(kuntoid);
        }

        String kunto = (String) attributes.get("kunto");

        if (kunto != null) {
            setKunto(kunto);
        }
    }

    @JSON
    @Override
    public int getKuntoid() {
        return _kuntoid;
    }

    @Override
    public void setKuntoid(int kuntoid) {
        _kuntoid = kuntoid;
    }

    @JSON
    @Override
    public String getKunto() {
        if (_kunto == null) {
            return StringPool.BLANK;
        } else {
            return _kunto;
        }
    }

    @Override
    public void setKunto(String kunto) {
        _columnBitmask |= KUNTO_COLUMN_BITMASK;

        if (_originalKunto == null) {
            _originalKunto = _kunto;
        }

        _kunto = kunto;
    }

    public String getOriginalKunto() {
        return GetterUtil.getString(_originalKunto);
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public Kuntoluokitus toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Kuntoluokitus) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        KuntoluokitusImpl kuntoluokitusImpl = new KuntoluokitusImpl();

        kuntoluokitusImpl.setKuntoid(getKuntoid());
        kuntoluokitusImpl.setKunto(getKunto());

        kuntoluokitusImpl.resetOriginalValues();

        return kuntoluokitusImpl;
    }

    @Override
    public int compareTo(Kuntoluokitus kuntoluokitus) {
        int primaryKey = kuntoluokitus.getPrimaryKey();

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

        if (!(obj instanceof Kuntoluokitus)) {
            return false;
        }

        Kuntoluokitus kuntoluokitus = (Kuntoluokitus) obj;

        int primaryKey = kuntoluokitus.getPrimaryKey();

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
        KuntoluokitusModelImpl kuntoluokitusModelImpl = this;

        kuntoluokitusModelImpl._originalKunto = kuntoluokitusModelImpl._kunto;

        kuntoluokitusModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Kuntoluokitus> toCacheModel() {
        KuntoluokitusCacheModel kuntoluokitusCacheModel = new KuntoluokitusCacheModel();

        kuntoluokitusCacheModel.kuntoid = getKuntoid();

        kuntoluokitusCacheModel.kunto = getKunto();

        String kunto = kuntoluokitusCacheModel.kunto;

        if ((kunto != null) && (kunto.length() == 0)) {
            kuntoluokitusCacheModel.kunto = null;
        }

        return kuntoluokitusCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{kuntoid=");
        sb.append(getKuntoid());
        sb.append(", kunto=");
        sb.append(getKunto());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Kuntoluokitus");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>kuntoid</column-name><column-value><![CDATA[");
        sb.append(getKuntoid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kunto</column-name><column-value><![CDATA[");
        sb.append(getKunto());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}