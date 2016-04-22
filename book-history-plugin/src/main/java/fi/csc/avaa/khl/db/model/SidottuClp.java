package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.SidottuLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class SidottuClp extends BaseModelImpl<Sidottu> implements Sidottu {
    private int _sidontaid;
    private String _sidonta;
    private BaseModel<?> _sidottuRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public SidottuClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Sidottu.class;
    }

    @Override
    public String getModelClassName() {
        return Sidottu.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _sidontaid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setSidontaid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _sidontaid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("sidontaid", getSidontaid());
        attributes.put("sidonta", getSidonta());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer sidontaid = (Integer) attributes.get("sidontaid");

        if (sidontaid != null) {
            setSidontaid(sidontaid);
        }

        String sidonta = (String) attributes.get("sidonta");

        if (sidonta != null) {
            setSidonta(sidonta);
        }
    }

    @Override
    public int getSidontaid() {
        return _sidontaid;
    }

    @Override
    public void setSidontaid(int sidontaid) {
        _sidontaid = sidontaid;

        if (_sidottuRemoteModel != null) {
            try {
                Class<?> clazz = _sidottuRemoteModel.getClass();

                Method method = clazz.getMethod("setSidontaid", int.class);

                method.invoke(_sidottuRemoteModel, sidontaid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSidonta() {
        return _sidonta;
    }

    @Override
    public void setSidonta(String sidonta) {
        _sidonta = sidonta;

        if (_sidottuRemoteModel != null) {
            try {
                Class<?> clazz = _sidottuRemoteModel.getClass();

                Method method = clazz.getMethod("setSidonta", String.class);

                method.invoke(_sidottuRemoteModel, sidonta);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getSidottuRemoteModel() {
        return _sidottuRemoteModel;
    }

    public void setSidottuRemoteModel(BaseModel<?> sidottuRemoteModel) {
        _sidottuRemoteModel = sidottuRemoteModel;
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

        Class<?> remoteModelClass = _sidottuRemoteModel.getClass();

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

        Object returnValue = method.invoke(_sidottuRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SidottuLocalServiceUtil.addSidottu(this);
        } else {
            SidottuLocalServiceUtil.updateSidottu(this);
        }
    }

    @Override
    public Sidottu toEscapedModel() {
        return (Sidottu) ProxyUtil.newProxyInstance(Sidottu.class.getClassLoader(),
            new Class[] { Sidottu.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SidottuClp clone = new SidottuClp();

        clone.setSidontaid(getSidontaid());
        clone.setSidonta(getSidonta());

        return clone;
    }

    @Override
    public int compareTo(Sidottu sidottu) {
        int primaryKey = sidottu.getPrimaryKey();

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

        if (!(obj instanceof SidottuClp)) {
            return false;
        }

        SidottuClp sidottu = (SidottuClp) obj;

        int primaryKey = sidottu.getPrimaryKey();

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

        sb.append("{sidontaid=");
        sb.append(getSidontaid());
        sb.append(", sidonta=");
        sb.append(getSidonta());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Sidottu");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>sidontaid</column-name><column-value><![CDATA[");
        sb.append(getSidontaid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sidonta</column-name><column-value><![CDATA[");
        sb.append(getSidonta());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
