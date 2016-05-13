package fi.csc.avaa.khl.db.service.base;

import fi.csc.avaa.khl.db.service.BookHistoryAPIServiceUtil;

import java.util.Arrays;

/**
 * @author CSC
 * @generated
 */
public class BookHistoryAPIServiceClpInvoker {
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;
    private String _methodName90;
    private String[] _methodParameterTypes90;

    public BookHistoryAPIServiceClpInvoker() {
        _methodName84 = "getBeanIdentifier";

        _methodParameterTypes84 = new String[] {  };

        _methodName85 = "setBeanIdentifier";

        _methodParameterTypes85 = new String[] { "java.lang.String" };

        _methodName90 = "getHelloWorld";

        _methodParameterTypes90 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return BookHistoryAPIServiceUtil.getBeanIdentifier();
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            BookHistoryAPIServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName90.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
            return BookHistoryAPIServiceUtil.getHelloWorld();
        }

        throw new UnsupportedOperationException();
    }
}
