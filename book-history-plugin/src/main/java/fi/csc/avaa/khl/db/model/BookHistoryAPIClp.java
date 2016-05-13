package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class BookHistoryAPIClp extends BaseModelImpl<BookHistoryAPI>
    implements BookHistoryAPI {
    private String _name;
    private BaseModel<?> _bookHistoryAPIRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public BookHistoryAPIClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return BookHistoryAPI.class;
    }

    @Override
    public String getModelClassName() {
        return BookHistoryAPI.class.getName();
    }

    @Override
    public String getPrimaryKey() {
        return _name;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setName(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _name;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_bookHistoryAPIRemoteModel != null) {
            try {
                Class<?> clazz = _bookHistoryAPIRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_bookHistoryAPIRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getBookHistoryAPIRemoteModel() {
        return _bookHistoryAPIRemoteModel;
    }

    public void setBookHistoryAPIRemoteModel(
        BaseModel<?> bookHistoryAPIRemoteModel) {
        _bookHistoryAPIRemoteModel = bookHistoryAPIRemoteModel;
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

        Class<?> remoteModelClass = _bookHistoryAPIRemoteModel.getClass();

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

        Object returnValue = method.invoke(_bookHistoryAPIRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public BookHistoryAPI toEscapedModel() {
        return (BookHistoryAPI) ProxyUtil.newProxyInstance(BookHistoryAPI.class.getClassLoader(),
            new Class[] { BookHistoryAPI.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BookHistoryAPIClp clone = new BookHistoryAPIClp();

        clone.setName(getName());

        return clone;
    }

    @Override
    public int compareTo(BookHistoryAPI bookHistoryAPI) {
        String primaryKey = bookHistoryAPI.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BookHistoryAPIClp)) {
            return false;
        }

        BookHistoryAPIClp bookHistoryAPI = (BookHistoryAPIClp) obj;

        String primaryKey = bookHistoryAPI.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
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
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(3);

        sb.append("{name=");
        sb.append(getName());

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(7);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.BookHistoryAPI");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
