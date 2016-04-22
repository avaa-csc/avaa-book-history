package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.TeospkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class TeospkClp extends BaseModelImpl<Teospk> implements Teospk {
    private int _teospkid;
    private String _teospknimi;
    private BaseModel<?> _teospkRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public TeospkClp() {
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

    @Override
    public int getTeospkid() {
        return _teospkid;
    }

    @Override
    public void setTeospkid(int teospkid) {
        _teospkid = teospkid;

        if (_teospkRemoteModel != null) {
            try {
                Class<?> clazz = _teospkRemoteModel.getClass();

                Method method = clazz.getMethod("setTeospkid", int.class);

                method.invoke(_teospkRemoteModel, teospkid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTeospknimi() {
        return _teospknimi;
    }

    @Override
    public void setTeospknimi(String teospknimi) {
        _teospknimi = teospknimi;

        if (_teospkRemoteModel != null) {
            try {
                Class<?> clazz = _teospkRemoteModel.getClass();

                Method method = clazz.getMethod("setTeospknimi", String.class);

                method.invoke(_teospkRemoteModel, teospknimi);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTeospkRemoteModel() {
        return _teospkRemoteModel;
    }

    public void setTeospkRemoteModel(BaseModel<?> teospkRemoteModel) {
        _teospkRemoteModel = teospkRemoteModel;
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

        Class<?> remoteModelClass = _teospkRemoteModel.getClass();

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

        Object returnValue = method.invoke(_teospkRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TeospkLocalServiceUtil.addTeospk(this);
        } else {
            TeospkLocalServiceUtil.updateTeospk(this);
        }
    }

    @Override
    public Teospk toEscapedModel() {
        return (Teospk) ProxyUtil.newProxyInstance(Teospk.class.getClassLoader(),
            new Class[] { Teospk.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TeospkClp clone = new TeospkClp();

        clone.setTeospkid(getTeospkid());
        clone.setTeospknimi(getTeospknimi());

        return clone;
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

        if (!(obj instanceof TeospkClp)) {
            return false;
        }

        TeospkClp teospk = (TeospkClp) obj;

        int primaryKey = teospk.getPrimaryKey();

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
