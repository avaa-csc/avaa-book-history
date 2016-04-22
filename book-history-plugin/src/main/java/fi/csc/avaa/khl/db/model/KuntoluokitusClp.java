package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.KuntoluokitusLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class KuntoluokitusClp extends BaseModelImpl<Kuntoluokitus>
    implements Kuntoluokitus {
    private int _kuntoid;
    private String _kunto;
    private BaseModel<?> _kuntoluokitusRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public KuntoluokitusClp() {
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

    @Override
    public int getKuntoid() {
        return _kuntoid;
    }

    @Override
    public void setKuntoid(int kuntoid) {
        _kuntoid = kuntoid;

        if (_kuntoluokitusRemoteModel != null) {
            try {
                Class<?> clazz = _kuntoluokitusRemoteModel.getClass();

                Method method = clazz.getMethod("setKuntoid", int.class);

                method.invoke(_kuntoluokitusRemoteModel, kuntoid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKunto() {
        return _kunto;
    }

    @Override
    public void setKunto(String kunto) {
        _kunto = kunto;

        if (_kuntoluokitusRemoteModel != null) {
            try {
                Class<?> clazz = _kuntoluokitusRemoteModel.getClass();

                Method method = clazz.getMethod("setKunto", String.class);

                method.invoke(_kuntoluokitusRemoteModel, kunto);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getKuntoluokitusRemoteModel() {
        return _kuntoluokitusRemoteModel;
    }

    public void setKuntoluokitusRemoteModel(
        BaseModel<?> kuntoluokitusRemoteModel) {
        _kuntoluokitusRemoteModel = kuntoluokitusRemoteModel;
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

        Class<?> remoteModelClass = _kuntoluokitusRemoteModel.getClass();

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

        Object returnValue = method.invoke(_kuntoluokitusRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            KuntoluokitusLocalServiceUtil.addKuntoluokitus(this);
        } else {
            KuntoluokitusLocalServiceUtil.updateKuntoluokitus(this);
        }
    }

    @Override
    public Kuntoluokitus toEscapedModel() {
        return (Kuntoluokitus) ProxyUtil.newProxyInstance(Kuntoluokitus.class.getClassLoader(),
            new Class[] { Kuntoluokitus.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        KuntoluokitusClp clone = new KuntoluokitusClp();

        clone.setKuntoid(getKuntoid());
        clone.setKunto(getKunto());

        return clone;
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

        if (!(obj instanceof KuntoluokitusClp)) {
            return false;
        }

        KuntoluokitusClp kuntoluokitus = (KuntoluokitusClp) obj;

        int primaryKey = kuntoluokitus.getPrimaryKey();

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
