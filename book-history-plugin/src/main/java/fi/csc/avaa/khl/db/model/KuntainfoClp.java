package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.KuntainfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class KuntainfoClp extends BaseModelImpl<Kuntainfo> implements Kuntainfo {
    private int _kuntaid;
    private String _capitalkuntanimi;
    private int _kpl;
    private String _kuntanimi;
    private int _maakuntaid;
    private int _kuntano;
    private String _kuntanimi_2014;
    private BaseModel<?> _kuntainfoRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public KuntainfoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Kuntainfo.class;
    }

    @Override
    public String getModelClassName() {
        return Kuntainfo.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _kuntaid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setKuntaid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _kuntaid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("kuntaid", getKuntaid());
        attributes.put("capitalkuntanimi", getCapitalkuntanimi());
        attributes.put("kpl", getKpl());
        attributes.put("kuntanimi", getKuntanimi());
        attributes.put("maakuntaid", getMaakuntaid());
        attributes.put("kuntano", getKuntano());
        attributes.put("kuntanimi_2014", getKuntanimi_2014());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer kuntaid = (Integer) attributes.get("kuntaid");

        if (kuntaid != null) {
            setKuntaid(kuntaid);
        }

        String capitalkuntanimi = (String) attributes.get("capitalkuntanimi");

        if (capitalkuntanimi != null) {
            setCapitalkuntanimi(capitalkuntanimi);
        }

        Integer kpl = (Integer) attributes.get("kpl");

        if (kpl != null) {
            setKpl(kpl);
        }

        String kuntanimi = (String) attributes.get("kuntanimi");

        if (kuntanimi != null) {
            setKuntanimi(kuntanimi);
        }

        Integer maakuntaid = (Integer) attributes.get("maakuntaid");

        if (maakuntaid != null) {
            setMaakuntaid(maakuntaid);
        }

        Integer kuntano = (Integer) attributes.get("kuntano");

        if (kuntano != null) {
            setKuntano(kuntano);
        }

        String kuntanimi_2014 = (String) attributes.get("kuntanimi_2014");

        if (kuntanimi_2014 != null) {
            setKuntanimi_2014(kuntanimi_2014);
        }
    }

    @Override
    public int getKuntaid() {
        return _kuntaid;
    }

    @Override
    public void setKuntaid(int kuntaid) {
        _kuntaid = kuntaid;

        if (_kuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _kuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setKuntaid", int.class);

                method.invoke(_kuntainfoRemoteModel, kuntaid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCapitalkuntanimi() {
        return _capitalkuntanimi;
    }

    @Override
    public void setCapitalkuntanimi(String capitalkuntanimi) {
        _capitalkuntanimi = capitalkuntanimi;

        if (_kuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _kuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setCapitalkuntanimi",
                        String.class);

                method.invoke(_kuntainfoRemoteModel, capitalkuntanimi);
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

        if (_kuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _kuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setKpl", int.class);

                method.invoke(_kuntainfoRemoteModel, kpl);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKuntanimi() {
        return _kuntanimi;
    }

    @Override
    public void setKuntanimi(String kuntanimi) {
        _kuntanimi = kuntanimi;

        if (_kuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _kuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setKuntanimi", String.class);

                method.invoke(_kuntainfoRemoteModel, kuntanimi);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getMaakuntaid() {
        return _maakuntaid;
    }

    @Override
    public void setMaakuntaid(int maakuntaid) {
        _maakuntaid = maakuntaid;

        if (_kuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _kuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setMaakuntaid", int.class);

                method.invoke(_kuntainfoRemoteModel, maakuntaid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKuntano() {
        return _kuntano;
    }

    @Override
    public void setKuntano(int kuntano) {
        _kuntano = kuntano;

        if (_kuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _kuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setKuntano", int.class);

                method.invoke(_kuntainfoRemoteModel, kuntano);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKuntanimi_2014() {
        return _kuntanimi_2014;
    }

    @Override
    public void setKuntanimi_2014(String kuntanimi_2014) {
        _kuntanimi_2014 = kuntanimi_2014;

        if (_kuntainfoRemoteModel != null) {
            try {
                Class<?> clazz = _kuntainfoRemoteModel.getClass();

                Method method = clazz.getMethod("setKuntanimi_2014",
                        String.class);

                method.invoke(_kuntainfoRemoteModel, kuntanimi_2014);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getKuntainfoRemoteModel() {
        return _kuntainfoRemoteModel;
    }

    public void setKuntainfoRemoteModel(BaseModel<?> kuntainfoRemoteModel) {
        _kuntainfoRemoteModel = kuntainfoRemoteModel;
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

        Class<?> remoteModelClass = _kuntainfoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_kuntainfoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            KuntainfoLocalServiceUtil.addKuntainfo(this);
        } else {
            KuntainfoLocalServiceUtil.updateKuntainfo(this);
        }
    }

    @Override
    public Kuntainfo toEscapedModel() {
        return (Kuntainfo) ProxyUtil.newProxyInstance(Kuntainfo.class.getClassLoader(),
            new Class[] { Kuntainfo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        KuntainfoClp clone = new KuntainfoClp();

        clone.setKuntaid(getKuntaid());
        clone.setCapitalkuntanimi(getCapitalkuntanimi());
        clone.setKpl(getKpl());
        clone.setKuntanimi(getKuntanimi());
        clone.setMaakuntaid(getMaakuntaid());
        clone.setKuntano(getKuntano());
        clone.setKuntanimi_2014(getKuntanimi_2014());

        return clone;
    }

    @Override
    public int compareTo(Kuntainfo kuntainfo) {
        int primaryKey = kuntainfo.getPrimaryKey();

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

        if (!(obj instanceof KuntainfoClp)) {
            return false;
        }

        KuntainfoClp kuntainfo = (KuntainfoClp) obj;

        int primaryKey = kuntainfo.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{kuntaid=");
        sb.append(getKuntaid());
        sb.append(", capitalkuntanimi=");
        sb.append(getCapitalkuntanimi());
        sb.append(", kpl=");
        sb.append(getKpl());
        sb.append(", kuntanimi=");
        sb.append(getKuntanimi());
        sb.append(", maakuntaid=");
        sb.append(getMaakuntaid());
        sb.append(", kuntano=");
        sb.append(getKuntano());
        sb.append(", kuntanimi_2014=");
        sb.append(getKuntanimi_2014());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Kuntainfo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>kuntaid</column-name><column-value><![CDATA[");
        sb.append(getKuntaid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>capitalkuntanimi</column-name><column-value><![CDATA[");
        sb.append(getCapitalkuntanimi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kpl</column-name><column-value><![CDATA[");
        sb.append(getKpl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kuntanimi</column-name><column-value><![CDATA[");
        sb.append(getKuntanimi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maakuntaid</column-name><column-value><![CDATA[");
        sb.append(getMaakuntaid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kuntano</column-name><column-value><![CDATA[");
        sb.append(getKuntano());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kuntanimi_2014</column-name><column-value><![CDATA[");
        sb.append(getKuntanimi_2014());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
