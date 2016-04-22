package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.KartoituskohdeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class KartoituskohdeClp extends BaseModelImpl<Kartoituskohde>
    implements Kartoituskohde {
    private int _kohdeid;
    private String _kartkohde;
    private int _kpl;
    private BaseModel<?> _kartoituskohdeRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public KartoituskohdeClp() {
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

    @Override
    public int getKohdeid() {
        return _kohdeid;
    }

    @Override
    public void setKohdeid(int kohdeid) {
        _kohdeid = kohdeid;

        if (_kartoituskohdeRemoteModel != null) {
            try {
                Class<?> clazz = _kartoituskohdeRemoteModel.getClass();

                Method method = clazz.getMethod("setKohdeid", int.class);

                method.invoke(_kartoituskohdeRemoteModel, kohdeid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKartkohde() {
        return _kartkohde;
    }

    @Override
    public void setKartkohde(String kartkohde) {
        _kartkohde = kartkohde;

        if (_kartoituskohdeRemoteModel != null) {
            try {
                Class<?> clazz = _kartoituskohdeRemoteModel.getClass();

                Method method = clazz.getMethod("setKartkohde", String.class);

                method.invoke(_kartoituskohdeRemoteModel, kartkohde);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKpl() {
        return _kpl;
    }

    @Override
    public void setKpl(int kpl) {
        _kpl = kpl;

        if (_kartoituskohdeRemoteModel != null) {
            try {
                Class<?> clazz = _kartoituskohdeRemoteModel.getClass();

                Method method = clazz.getMethod("setKpl", int.class);

                method.invoke(_kartoituskohdeRemoteModel, kpl);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getKartoituskohdeRemoteModel() {
        return _kartoituskohdeRemoteModel;
    }

    public void setKartoituskohdeRemoteModel(
        BaseModel<?> kartoituskohdeRemoteModel) {
        _kartoituskohdeRemoteModel = kartoituskohdeRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _kartoituskohdeRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_kartoituskohdeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            KartoituskohdeLocalServiceUtil.addKartoituskohde(this);
        } else {
            KartoituskohdeLocalServiceUtil.updateKartoituskohde(this);
        }
    }

    @Override
    public Kartoituskohde toEscapedModel() {
        return (Kartoituskohde) ProxyUtil.newProxyInstance(Kartoituskohde.class.getClassLoader(),
            new Class[] { Kartoituskohde.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        KartoituskohdeClp clone = new KartoituskohdeClp();

        clone.setKohdeid(getKohdeid());
        clone.setKartkohde(getKartkohde());
        clone.setKpl(getKpl());

        return clone;
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

        if (!(obj instanceof KartoituskohdeClp)) {
            return false;
        }

        KartoituskohdeClp kartoituskohde = (KartoituskohdeClp) obj;

        int primaryKey = kartoituskohde.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return getPrimaryKey();
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
