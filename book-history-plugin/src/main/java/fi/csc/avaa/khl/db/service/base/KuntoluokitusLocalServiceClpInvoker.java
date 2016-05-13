package fi.csc.avaa.khl.db.service.base;

import fi.csc.avaa.khl.db.service.KuntoluokitusLocalServiceUtil;

import java.util.Arrays;

/**
 * @author CSC
 * @generated
 */
public class KuntoluokitusLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName100;
    private String[] _methodParameterTypes100;
    private String _methodName101;
    private String[] _methodParameterTypes101;
    private String _methodName106;
    private String[] _methodParameterTypes106;

    public KuntoluokitusLocalServiceClpInvoker() {
        _methodName0 = "addKuntoluokitus";

        _methodParameterTypes0 = new String[] {
                "fi.csc.avaa.khl.db.model.Kuntoluokitus"
            };

        _methodName1 = "createKuntoluokitus";

        _methodParameterTypes1 = new String[] { "int" };

        _methodName2 = "deleteKuntoluokitus";

        _methodParameterTypes2 = new String[] { "int" };

        _methodName3 = "deleteKuntoluokitus";

        _methodParameterTypes3 = new String[] {
                "fi.csc.avaa.khl.db.model.Kuntoluokitus"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchKuntoluokitus";

        _methodParameterTypes10 = new String[] { "int" };

        _methodName11 = "getKuntoluokitus";

        _methodParameterTypes11 = new String[] { "int" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getKuntoluokituses";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getKuntoluokitusesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateKuntoluokitus";

        _methodParameterTypes15 = new String[] {
                "fi.csc.avaa.khl.db.model.Kuntoluokitus"
            };

        _methodName100 = "getBeanIdentifier";

        _methodParameterTypes100 = new String[] {  };

        _methodName101 = "setBeanIdentifier";

        _methodParameterTypes101 = new String[] { "java.lang.String" };

        _methodName106 = "findByKunto";

        _methodParameterTypes106 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.addKuntoluokitus((fi.csc.avaa.khl.db.model.Kuntoluokitus) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.createKuntoluokitus(((Integer) arguments[0]).intValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.deleteKuntoluokitus(((Integer) arguments[0]).intValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.deleteKuntoluokitus((fi.csc.avaa.khl.db.model.Kuntoluokitus) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.fetchKuntoluokitus(((Integer) arguments[0]).intValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.getKuntoluokitus(((Integer) arguments[0]).intValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.getKuntoluokituses(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.getKuntoluokitusesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.updateKuntoluokitus((fi.csc.avaa.khl.db.model.Kuntoluokitus) arguments[0]);
        }

        if (_methodName100.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName101.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
            KuntoluokitusLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName106.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
            return KuntoluokitusLocalServiceUtil.findByKunto((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
