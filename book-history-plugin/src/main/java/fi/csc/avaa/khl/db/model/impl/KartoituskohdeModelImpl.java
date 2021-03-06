package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.model.Kartoituskohde;
import fi.csc.avaa.khl.db.model.KartoituskohdeModel;
import fi.csc.avaa.khl.db.model.KartoituskohdeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Kartoituskohde service. Represents a row in the &quot;kartoituskohde&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link fi.csc.avaa.khl.db.model.KartoituskohdeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KartoituskohdeImpl}.
 * </p>
 *
 * @author CSC
 * @see KartoituskohdeImpl
 * @see fi.csc.avaa.khl.db.model.Kartoituskohde
 * @see fi.csc.avaa.khl.db.model.KartoituskohdeModel
 * @generated
 */
@JSON(strict = true)
public class KartoituskohdeModelImpl extends BaseModelImpl<Kartoituskohde>
    implements KartoituskohdeModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a kartoituskohde model instance should use the {@link fi.csc.avaa.khl.db.model.Kartoituskohde} interface instead.
     */
    public static final String TABLE_NAME = "kartoituskohde";
    public static final Object[][] TABLE_COLUMNS = {
            { "kohdeid", Types.INTEGER },
            { "kartkohde", Types.VARCHAR },
            { "kpl", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table kartoituskohde (kohdeid INTEGER not null primary key,kartkohde VARCHAR(75) null,kpl INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table kartoituskohde";
    public static final String ORDER_BY_JPQL = " ORDER BY kartoituskohde.kohdeid ASC";
    public static final String ORDER_BY_SQL = " ORDER BY kartoituskohde.kohdeid ASC";
    public static final String DATA_SOURCE = "khl";
    public static final String SESSION_FACTORY = "khlSessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.fi.csc.avaa.khl.db.model.Kartoituskohde"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.fi.csc.avaa.khl.db.model.Kartoituskohde"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.fi.csc.avaa.khl.db.model.Kartoituskohde"),
            true);
    public static long KARTKOHDE_COLUMN_BITMASK = 1L;
    public static long KOHDEID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.fi.csc.avaa.khl.db.model.Kartoituskohde"));
    private static ClassLoader _classLoader = Kartoituskohde.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Kartoituskohde.class
        };
    private int _kohdeid;
    private String _kartkohde;
    private String _originalKartkohde;
    private int _kpl;
    private long _columnBitmask;
    private Kartoituskohde _escapedModel;

    public KartoituskohdeModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Kartoituskohde toModel(KartoituskohdeSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Kartoituskohde model = new KartoituskohdeImpl();

        model.setKohdeid(soapModel.getKohdeid());
        model.setKartkohde(soapModel.getKartkohde());
        model.setKpl(soapModel.getKpl());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Kartoituskohde> toModels(KartoituskohdeSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Kartoituskohde> models = new ArrayList<Kartoituskohde>(soapModels.length);

        for (KartoituskohdeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public int getPrimaryKey() {
        return _kohdeid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setKohdeid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _kohdeid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
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

    @JSON
    @Override
    public int getKohdeid() {
        return _kohdeid;
    }

    @Override
    public void setKohdeid(int kohdeid) {
        _kohdeid = kohdeid;
    }

    @JSON
    @Override
    public String getKartkohde() {
        if (_kartkohde == null) {
            return StringPool.BLANK;
        } else {
            return _kartkohde;
        }
    }

    @Override
    public void setKartkohde(String kartkohde) {
        _columnBitmask |= KARTKOHDE_COLUMN_BITMASK;

        if (_originalKartkohde == null) {
            _originalKartkohde = _kartkohde;
        }

        _kartkohde = kartkohde;
    }

    public String getOriginalKartkohde() {
        return GetterUtil.getString(_originalKartkohde);
    }

    @JSON
    @Override
    public int getKpl() {
        return _kpl;
    }

    @Override
    public void setKpl(int kpl) {
        _kpl = kpl;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public Kartoituskohde toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Kartoituskohde) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        KartoituskohdeImpl kartoituskohdeImpl = new KartoituskohdeImpl();

        kartoituskohdeImpl.setKohdeid(getKohdeid());
        kartoituskohdeImpl.setKartkohde(getKartkohde());
        kartoituskohdeImpl.setKpl(getKpl());

        kartoituskohdeImpl.resetOriginalValues();

        return kartoituskohdeImpl;
    }

    @Override
    public int compareTo(Kartoituskohde kartoituskohde) {
        int primaryKey = kartoituskohde.getPrimaryKey();

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

        if (!(obj instanceof Kartoituskohde)) {
            return false;
        }

        Kartoituskohde kartoituskohde = (Kartoituskohde) obj;

        int primaryKey = kartoituskohde.getPrimaryKey();

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
        KartoituskohdeModelImpl kartoituskohdeModelImpl = this;

        kartoituskohdeModelImpl._originalKartkohde = kartoituskohdeModelImpl._kartkohde;

        kartoituskohdeModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Kartoituskohde> toCacheModel() {
        KartoituskohdeCacheModel kartoituskohdeCacheModel = new KartoituskohdeCacheModel();

        kartoituskohdeCacheModel.kohdeid = getKohdeid();

        kartoituskohdeCacheModel.kartkohde = getKartkohde();

        String kartkohde = kartoituskohdeCacheModel.kartkohde;

        if ((kartkohde != null) && (kartkohde.length() == 0)) {
            kartoituskohdeCacheModel.kartkohde = null;
        }

        kartoituskohdeCacheModel.kpl = getKpl();

        return kartoituskohdeCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{kohdeid=");
        sb.append(getKohdeid());
        sb.append(", kartkohde=");
        sb.append(getKartkohde());
        sb.append(", kpl=");
        sb.append(getKpl());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Kartoituskohde");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>kohdeid</column-name><column-value><![CDATA[");
        sb.append(getKohdeid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kartkohde</column-name><column-value><![CDATA[");
        sb.append(getKartkohde());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kpl</column-name><column-value><![CDATA[");
        sb.append(getKpl());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
