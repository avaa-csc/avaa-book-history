package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.KieliinfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class KieliinfoClp extends BaseModelImpl<Kieliinfo> implements Kieliinfo {
    private int _kieliid;
    private String _kieli;
    private BaseModel<?> _kieliinfoRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public KieliinfoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Kieliinfo.class;
    }

    @Override
    public String getModelClassName() {
        return Kieliinfo.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _kieliid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setKieliid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _kieliid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("kieliid", getKieliid());
        attributes.put("kieli", getKieli());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer kieliid = (Integer) attributes.get("kieliid");

        if (kieliid != null) {
            setKieliid(kieliid);
        }

        String kieli = (String) attributes.get("kieli");

        if (kieli != null) {
            setKieli(kieli);
        }
    }

    @Override
    public int getKieliid() {
        return _kieliid;
    }

    @Override
    public void setKieliid(int kieliid) {
        _kieliid = kieliid;

        if (_kieliinfoRemoteModel != null) {
            try {
                Class<?> clazz = _kieliinfoRemoteModel.getClass();

                Method method = clazz.getMethod("setKieliid", int.class);

                method.invoke(_kieliinfoRemoteModel, kieliid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKieli() {
        return _kieli;
    }

    @Override
    public void setKieli(String kieli) {
        _kieli = kieli;

        if (_kieliinfoRemoteModel != null) {
            try {
                Class<?> clazz = _kieliinfoRemoteModel.getClass();

                Method method = clazz.getMethod("setKieli", String.class);

                method.invoke(_kieliinfoRemoteModel, kieli);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getKieliinfoRemoteModel() {
        return _kieliinfoRemoteModel;
    }

    public void setKieliinfoRemoteModel(BaseModel<?> kieliinfoRemoteModel) {
        _kieliinfoRemoteModel = kieliinfoRemoteModel;
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

        Class<?> remoteModelClass = _kieliinfoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_kieliinfoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            KieliinfoLocalServiceUtil.addKieliinfo(this);
        } else {
            KieliinfoLocalServiceUtil.updateKieliinfo(this);
        }
    }

    @Override
    public Kieliinfo toEscapedModel() {
        return (Kieliinfo) ProxyUtil.newProxyInstance(Kieliinfo.class.getClassLoader(),
            new Class[] { Kieliinfo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        KieliinfoClp clone = new KieliinfoClp();

        clone.setKieliid(getKieliid());
        clone.setKieli(getKieli());

        return clone;
    }

    @Override
    public int compareTo(Kieliinfo kieliinfo) {
        int primaryKey = kieliinfo.getPrimaryKey();

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

        if (!(obj instanceof KieliinfoClp)) {
            return false;
        }

        KieliinfoClp kieliinfo = (KieliinfoClp) obj;

        int primaryKey = kieliinfo.getPrimaryKey();

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

        sb.append("{kieliid=");
        sb.append(getKieliid());
        sb.append(", kieli=");
        sb.append(getKieli());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Kieliinfo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>kieliid</column-name><column-value><![CDATA[");
        sb.append(getKieliid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kieli</column-name><column-value><![CDATA[");
        sb.append(getKieli());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
