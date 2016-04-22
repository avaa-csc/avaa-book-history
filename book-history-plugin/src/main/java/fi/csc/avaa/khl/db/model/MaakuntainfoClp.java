package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.MaakuntainfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class MaakuntainfoClp extends BaseModelImpl<Maakuntainfo>
    implements Maakuntainfo {
    private int _maakuntaid;
    private String _maakunta;
    private int _kpl;
    private BaseModel<?> _maakuntainfoRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public MaakuntainfoClp() {
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
    public int getPrimaryKey() {
        return _maakuntaid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setMaakuntaid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _maakuntaid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
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

    @Override
    public int getMaakuntaid() {
        return _maakuntaid;
    }

    @Override
    public void setMaakuntaid(int maakuntaid) {
        _maakuntaid = maakuntaid;

        if (_maakuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _maakuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setMaakuntaid", int.class);

                method.invoke(_maakuntainfoRemoteModel, maakuntaid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMaakunta() {
        return _maakunta;
    }

    @Override
    public void setMaakunta(String maakunta) {
        _maakunta = maakunta;

        if (_maakuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _maakuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setMaakunta", String.class);

                method.invoke(_maakuntainfoRemoteModel, maakunta);
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

        if (_maakuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _maakuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setKpl", int.class);

                method.invoke(_maakuntainfoRemoteModel, kpl);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getMaakuntainfoRemoteModel() {
        return _maakuntainfoRemoteModel;
    }

    public void setMaakuntainfoRemoteModel(BaseModel<?> maakuntainfoRemoteModel) {
        _maakuntainfoRemoteModel = maakuntainfoRemoteModel;
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

        Class<?> remoteModelClass = _maakuntainfoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_maakuntainfoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MaakuntainfoLocalServiceUtil.addMaakuntainfo(this);
        } else {
            MaakuntainfoLocalServiceUtil.updateMaakuntainfo(this);
        }
    }

    @Override
    public Maakuntainfo toEscapedModel() {
        return (Maakuntainfo) ProxyUtil.newProxyInstance(Maakuntainfo.class.getClassLoader(),
            new Class[] { Maakuntainfo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MaakuntainfoClp clone = new MaakuntainfoClp();

        clone.setMaakuntaid(getMaakuntaid());
        clone.setMaakunta(getMaakunta());
        clone.setKpl(getKpl());

        return clone;
    }

    @Override
    public int compareTo(Maakuntainfo maakuntainfo) {
        int primaryKey = maakuntainfo.getPrimaryKey();

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

        if (!(obj instanceof MaakuntainfoClp)) {
            return false;
        }

        MaakuntainfoClp maakuntainfo = (MaakuntainfoClp) obj;

        int primaryKey = maakuntainfo.getPrimaryKey();

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

        sb.append("{maakuntaid=");
        sb.append(getMaakuntaid());
        sb.append(", maakunta=");
        sb.append(getMaakunta());
        sb.append(", kpl=");
        sb.append(getKpl());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Maakuntainfo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maakuntaid</column-name><column-value><![CDATA[");
        sb.append(getMaakuntaid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maakunta</column-name><column-value><![CDATA[");
        sb.append(getMaakunta());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kpl</column-name><column-value><![CDATA[");
        sb.append(getKpl());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
