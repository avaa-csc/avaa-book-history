package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.KielestaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class KielestaClp extends BaseModelImpl<Kielesta> implements Kielesta {
    private int _kieliid;
    private String _kieli;
    private BaseModel<?> _kielestaRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public KielestaClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Kielesta.class;
    }

    @Override
    public String getModelClassName() {
        return Kielesta.class.getName();
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

        if (_kielestaRemoteModel != null) {
            try {
                Class<?> clazz = _kielestaRemoteModel.getClass();

                Method method = clazz.getMethod("setKieliid", int.class);

                method.invoke(_kielestaRemoteModel, kieliid);
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

        if (_kielestaRemoteModel != null) {
            try {
                Class<?> clazz = _kielestaRemoteModel.getClass();

                Method method = clazz.getMethod("setKieli", String.class);

                method.invoke(_kielestaRemoteModel, kieli);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getKielestaRemoteModel() {
        return _kielestaRemoteModel;
    }

    public void setKielestaRemoteModel(BaseModel<?> kielestaRemoteModel) {
        _kielestaRemoteModel = kielestaRemoteModel;
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

        Class<?> remoteModelClass = _kielestaRemoteModel.getClass();

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

        Object returnValue = method.invoke(_kielestaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            KielestaLocalServiceUtil.addKielesta(this);
        } else {
            KielestaLocalServiceUtil.updateKielesta(this);
        }
    }

    @Override
    public Kielesta toEscapedModel() {
        return (Kielesta) ProxyUtil.newProxyInstance(Kielesta.class.getClassLoader(),
            new Class[] { Kielesta.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        KielestaClp clone = new KielestaClp();

        clone.setKieliid(getKieliid());
        clone.setKieli(getKieli());

        return clone;
    }

    @Override
    public int compareTo(Kielesta kielesta) {
        int primaryKey = kielesta.getPrimaryKey();

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

        if (!(obj instanceof KielestaClp)) {
            return false;
        }

        KielestaClp kielesta = (KielestaClp) obj;

        int primaryKey = kielesta.getPrimaryKey();

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
        sb.append("fi.csc.avaa.khl.db.model.Kielesta");
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
