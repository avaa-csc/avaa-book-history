package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class JulkaisulajiinfoClp extends BaseModelImpl<Julkaisulajiinfo>
    implements Julkaisulajiinfo {
    private int _julklajiid;
    private String _julklaji;
    private BaseModel<?> _julkaisulajiinfoRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public JulkaisulajiinfoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Julkaisulajiinfo.class;
    }

    @Override
    public String getModelClassName() {
        return Julkaisulajiinfo.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _julklajiid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setJulklajiid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _julklajiid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("julklajiid", getJulklajiid());
        attributes.put("julklaji", getJulklaji());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer julklajiid = (Integer) attributes.get("julklajiid");

        if (julklajiid != null) {
            setJulklajiid(julklajiid);
        }

        String julklaji = (String) attributes.get("julklaji");

        if (julklaji != null) {
            setJulklaji(julklaji);
        }
    }

    @Override
    public int getJulklajiid() {
        return _julklajiid;
    }

    @Override
    public void setJulklajiid(int julklajiid) {
        _julklajiid = julklajiid;

        if (_julkaisulajiinfoRemoteModel != null) {
            try {
                Class<?> clazz = _julkaisulajiinfoRemoteModel.getClass();

                Method method = clazz.getMethod("setJulklajiid", int.class);

                method.invoke(_julkaisulajiinfoRemoteModel, julklajiid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getJulklaji() {
        return _julklaji;
    }

    @Override
    public void setJulklaji(String julklaji) {
        _julklaji = julklaji;

        if (_julkaisulajiinfoRemoteModel != null) {
            try {
                Class<?> clazz = _julkaisulajiinfoRemoteModel.getClass();

                Method method = clazz.getMethod("setJulklaji", String.class);

                method.invoke(_julkaisulajiinfoRemoteModel, julklaji);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getJulkaisulajiinfoRemoteModel() {
        return _julkaisulajiinfoRemoteModel;
    }

    public void setJulkaisulajiinfoRemoteModel(
        BaseModel<?> julkaisulajiinfoRemoteModel) {
        _julkaisulajiinfoRemoteModel = julkaisulajiinfoRemoteModel;
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

        Class<?> remoteModelClass = _julkaisulajiinfoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_julkaisulajiinfoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            JulkaisulajiinfoLocalServiceUtil.addJulkaisulajiinfo(this);
        } else {
            JulkaisulajiinfoLocalServiceUtil.updateJulkaisulajiinfo(this);
        }
    }

    @Override
    public Julkaisulajiinfo toEscapedModel() {
        return (Julkaisulajiinfo) ProxyUtil.newProxyInstance(Julkaisulajiinfo.class.getClassLoader(),
            new Class[] { Julkaisulajiinfo.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        JulkaisulajiinfoClp clone = new JulkaisulajiinfoClp();

        clone.setJulklajiid(getJulklajiid());
        clone.setJulklaji(getJulklaji());

        return clone;
    }

    @Override
    public int compareTo(Julkaisulajiinfo julkaisulajiinfo) {
        int primaryKey = julkaisulajiinfo.getPrimaryKey();

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

        if (!(obj instanceof JulkaisulajiinfoClp)) {
            return false;
        }

        JulkaisulajiinfoClp julkaisulajiinfo = (JulkaisulajiinfoClp) obj;

        int primaryKey = julkaisulajiinfo.getPrimaryKey();

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

        sb.append("{julklajiid=");
        sb.append(getJulklajiid());
        sb.append(", julklaji=");
        sb.append(getJulklaji());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Julkaisulajiinfo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>julklajiid</column-name><column-value><![CDATA[");
        sb.append(getJulklajiid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>julklaji</column-name><column-value><![CDATA[");
        sb.append(getJulklaji());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
