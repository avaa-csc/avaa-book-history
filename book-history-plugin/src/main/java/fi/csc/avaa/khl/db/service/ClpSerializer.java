package fi.csc.avaa.khl.db.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import fi.csc.avaa.khl.db.model.BookHistoryAPIClp;
import fi.csc.avaa.khl.db.model.JulkaisulajiinfoClp;
import fi.csc.avaa.khl.db.model.KartoituskohdeClp;
import fi.csc.avaa.khl.db.model.KielestaClp;
import fi.csc.avaa.khl.db.model.KieliinfoClp;
import fi.csc.avaa.khl.db.model.KuntainfoClp;
import fi.csc.avaa.khl.db.model.KuntoluokitusClp;
import fi.csc.avaa.khl.db.model.MaakuntainfoClp;
import fi.csc.avaa.khl.db.model.PuuteClp;
import fi.csc.avaa.khl.db.model.SidottuClp;
import fi.csc.avaa.khl.db.model.TeospkClp;
import fi.csc.avaa.khl.db.model.VanhatkirjatClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "kirjakartoitus-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "kirjakartoitus-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "kirjakartoitus-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(BookHistoryAPIClp.class.getName())) {
            return translateInputBookHistoryAPI(oldModel);
        }

        if (oldModelClassName.equals(JulkaisulajiinfoClp.class.getName())) {
            return translateInputJulkaisulajiinfo(oldModel);
        }

        if (oldModelClassName.equals(KartoituskohdeClp.class.getName())) {
            return translateInputKartoituskohde(oldModel);
        }

        if (oldModelClassName.equals(KielestaClp.class.getName())) {
            return translateInputKielesta(oldModel);
        }

        if (oldModelClassName.equals(KieliinfoClp.class.getName())) {
            return translateInputKieliinfo(oldModel);
        }

        if (oldModelClassName.equals(KuntainfoClp.class.getName())) {
            return translateInputKuntainfo(oldModel);
        }

        if (oldModelClassName.equals(KuntoluokitusClp.class.getName())) {
            return translateInputKuntoluokitus(oldModel);
        }

        if (oldModelClassName.equals(MaakuntainfoClp.class.getName())) {
            return translateInputMaakuntainfo(oldModel);
        }

        if (oldModelClassName.equals(PuuteClp.class.getName())) {
            return translateInputPuute(oldModel);
        }

        if (oldModelClassName.equals(SidottuClp.class.getName())) {
            return translateInputSidottu(oldModel);
        }

        if (oldModelClassName.equals(TeospkClp.class.getName())) {
            return translateInputTeospk(oldModel);
        }

        if (oldModelClassName.equals(VanhatkirjatClp.class.getName())) {
            return translateInputVanhatkirjat(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputBookHistoryAPI(BaseModel<?> oldModel) {
        BookHistoryAPIClp oldClpModel = (BookHistoryAPIClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getBookHistoryAPIRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputJulkaisulajiinfo(BaseModel<?> oldModel) {
        JulkaisulajiinfoClp oldClpModel = (JulkaisulajiinfoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getJulkaisulajiinfoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputKartoituskohde(BaseModel<?> oldModel) {
        KartoituskohdeClp oldClpModel = (KartoituskohdeClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getKartoituskohdeRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputKielesta(BaseModel<?> oldModel) {
        KielestaClp oldClpModel = (KielestaClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getKielestaRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputKieliinfo(BaseModel<?> oldModel) {
        KieliinfoClp oldClpModel = (KieliinfoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getKieliinfoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputKuntainfo(BaseModel<?> oldModel) {
        KuntainfoClp oldClpModel = (KuntainfoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getKuntainfoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputKuntoluokitus(BaseModel<?> oldModel) {
        KuntoluokitusClp oldClpModel = (KuntoluokitusClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getKuntoluokitusRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputMaakuntainfo(BaseModel<?> oldModel) {
        MaakuntainfoClp oldClpModel = (MaakuntainfoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getMaakuntainfoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputPuute(BaseModel<?> oldModel) {
        PuuteClp oldClpModel = (PuuteClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getPuuteRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSidottu(BaseModel<?> oldModel) {
        SidottuClp oldClpModel = (SidottuClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSidottuRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputTeospk(BaseModel<?> oldModel) {
        TeospkClp oldClpModel = (TeospkClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getTeospkRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputVanhatkirjat(BaseModel<?> oldModel) {
        VanhatkirjatClp oldClpModel = (VanhatkirjatClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getVanhatkirjatRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.BookHistoryAPIImpl")) {
            return translateOutputBookHistoryAPI(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoImpl")) {
            return translateOutputJulkaisulajiinfo(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.KartoituskohdeImpl")) {
            return translateOutputKartoituskohde(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.KielestaImpl")) {
            return translateOutputKielesta(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.KieliinfoImpl")) {
            return translateOutputKieliinfo(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.KuntainfoImpl")) {
            return translateOutputKuntainfo(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.KuntoluokitusImpl")) {
            return translateOutputKuntoluokitus(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.MaakuntainfoImpl")) {
            return translateOutputMaakuntainfo(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("fi.csc.avaa.khl.db.model.impl.PuuteImpl")) {
            return translateOutputPuute(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.SidottuImpl")) {
            return translateOutputSidottu(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("fi.csc.avaa.khl.db.model.impl.TeospkImpl")) {
            return translateOutputTeospk(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "fi.csc.avaa.khl.db.model.impl.VanhatkirjatImpl")) {
            return translateOutputVanhatkirjat(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException")) {
            return new fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException();
        }

        if (className.equals(
                    "fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException")) {
            return new fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchKartoituskohdeException")) {
            return new fi.csc.avaa.khl.db.NoSuchKartoituskohdeException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchKielestaException")) {
            return new fi.csc.avaa.khl.db.NoSuchKielestaException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchKieliinfoException")) {
            return new fi.csc.avaa.khl.db.NoSuchKieliinfoException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchKuntainfoException")) {
            return new fi.csc.avaa.khl.db.NoSuchKuntainfoException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchKuntoluokitusException")) {
            return new fi.csc.avaa.khl.db.NoSuchKuntoluokitusException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchMaakuntainfoException")) {
            return new fi.csc.avaa.khl.db.NoSuchMaakuntainfoException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchPuuteException")) {
            return new fi.csc.avaa.khl.db.NoSuchPuuteException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchSidottuException")) {
            return new fi.csc.avaa.khl.db.NoSuchSidottuException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchTeospkException")) {
            return new fi.csc.avaa.khl.db.NoSuchTeospkException();
        }

        if (className.equals("fi.csc.avaa.khl.db.NoSuchVanhatkirjatException")) {
            return new fi.csc.avaa.khl.db.NoSuchVanhatkirjatException();
        }

        return throwable;
    }

    public static Object translateOutputBookHistoryAPI(BaseModel<?> oldModel) {
        BookHistoryAPIClp newModel = new BookHistoryAPIClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setBookHistoryAPIRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputJulkaisulajiinfo(BaseModel<?> oldModel) {
        JulkaisulajiinfoClp newModel = new JulkaisulajiinfoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setJulkaisulajiinfoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputKartoituskohde(BaseModel<?> oldModel) {
        KartoituskohdeClp newModel = new KartoituskohdeClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setKartoituskohdeRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputKielesta(BaseModel<?> oldModel) {
        KielestaClp newModel = new KielestaClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setKielestaRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputKieliinfo(BaseModel<?> oldModel) {
        KieliinfoClp newModel = new KieliinfoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setKieliinfoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputKuntainfo(BaseModel<?> oldModel) {
        KuntainfoClp newModel = new KuntainfoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setKuntainfoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputKuntoluokitus(BaseModel<?> oldModel) {
        KuntoluokitusClp newModel = new KuntoluokitusClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setKuntoluokitusRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputMaakuntainfo(BaseModel<?> oldModel) {
        MaakuntainfoClp newModel = new MaakuntainfoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setMaakuntainfoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputPuute(BaseModel<?> oldModel) {
        PuuteClp newModel = new PuuteClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setPuuteRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSidottu(BaseModel<?> oldModel) {
        SidottuClp newModel = new SidottuClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSidottuRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputTeospk(BaseModel<?> oldModel) {
        TeospkClp newModel = new TeospkClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setTeospkRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputVanhatkirjat(BaseModel<?> oldModel) {
        VanhatkirjatClp newModel = new VanhatkirjatClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setVanhatkirjatRemoteModel(oldModel);

        return newModel;
    }
}
