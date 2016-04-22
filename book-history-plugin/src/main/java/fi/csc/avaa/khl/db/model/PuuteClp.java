package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.PuuteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class PuuteClp extends BaseModelImpl<Puute> implements Puute {
    private int _puuteid;
    private String _puutenimi;
    private BaseModel<?> _puuteRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public PuuteClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Puute.class;
    }

    @Override
    public String getModelClassName() {
        return Puute.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _puuteid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setPuuteid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _puuteid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("puuteid", getPuuteid());
        attributes.put("puutenimi", getPuutenimi());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer puuteid = (Integer) attributes.get("puuteid");

        if (puuteid != null) {
            setPuuteid(puuteid);
        }

        String puutenimi = (String) attributes.get("puutenimi");

        if (puutenimi != null) {
            setPuutenimi(puutenimi);
        }
    }

    @Override
    public int getPuuteid() {
        return _puuteid;
    }

    @Override
    public void setPuuteid(int puuteid) {
        _puuteid = puuteid;

        if (_puuteRemoteModel != null) {
            try {
                Class<?> clazz = _puuteRemoteModel.getClass();

                Method method = clazz.getMethod("setPuuteid", int.class);

                method.invoke(_puuteRemoteModel, puuteid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPuutenimi() {
        return _puutenimi;
    }

    @Override
    public void setPuutenimi(String puutenimi) {
        _puutenimi = puutenimi;

        if (_puuteRemoteModel != null) {
            try {
                Class<?> clazz = _puuteRemoteModel.getClass();

                Method method = clazz.getMethod("setPuutenimi", String.class);

                method.invoke(_puuteRemoteModel, puutenimi);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getPuuteRemoteModel() {
        return _puuteRemoteModel;
    }

    public void setPuuteRemoteModel(BaseModel<?> puuteRemoteModel) {
        _puuteRemoteModel = puuteRemoteModel;
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

        Class<?> remoteModelClass = _puuteRemoteModel.getClass();

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

        Object returnValue = method.invoke(_puuteRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PuuteLocalServiceUtil.addPuute(this);
        } else {
            PuuteLocalServiceUtil.updatePuute(this);
        }
    }

    @Override
    public Puute toEscapedModel() {
        return (Puute) ProxyUtil.newProxyInstance(Puute.class.getClassLoader(),
            new Class[] { Puute.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PuuteClp clone = new PuuteClp();

        clone.setPuuteid(getPuuteid());
        clone.setPuutenimi(getPuutenimi());

        return clone;
    }

    @Override
    public int compareTo(Puute puute) {
        int primaryKey = puute.getPrimaryKey();

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

        if (!(obj instanceof PuuteClp)) {
            return false;
        }

        PuuteClp puute = (PuuteClp) obj;

        int primaryKey = puute.getPrimaryKey();

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

        sb.append("{puuteid=");
        sb.append(getPuuteid());
        sb.append(", puutenimi=");
        sb.append(getPuutenimi());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Puute");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>puuteid</column-name><column-value><![CDATA[");
        sb.append(getPuuteid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>puutenimi</column-name><column-value><![CDATA[");
        sb.append(getPuutenimi());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
