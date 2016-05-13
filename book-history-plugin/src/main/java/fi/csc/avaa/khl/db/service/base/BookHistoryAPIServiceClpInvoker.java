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
    private String _methodName91;
    private String[] _methodParameterTypes91;
    private String _methodName92;
    private String[] _methodParameterTypes92;
    private String _methodName93;
    private String[] _methodParameterTypes93;

    public BookHistoryAPIServiceClpInvoker() {
        _methodName84 = "getBeanIdentifier";

        _methodParameterTypes84 = new String[] {  };

        _methodName85 = "setBeanIdentifier";

        _methodParameterTypes85 = new String[] { "java.lang.String" };

        _methodName90 = "getBooksByTitleAuthorFromYearPublisedToYearPublished";

        _methodParameterTypes90 = new String[] {
                "java.lang.String", "java.lang.String", "int", "int"
            };

        _methodName91 = "getBooksByTitle";

        _methodParameterTypes91 = new String[] { "java.lang.String" };

        _methodName92 = "getBooksByAuthor";

        _methodParameterTypes92 = new String[] { "java.lang.String" };

        _methodName93 = "getBooksByFromYearPublisedToYearPublished";

        _methodParameterTypes93 = new String[] { "int", "int" };
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
            return BookHistoryAPIServiceUtil.getBooksByTitleAuthorFromYearPublisedToYearPublished((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue());
        }

        if (_methodName91.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
            return BookHistoryAPIServiceUtil.getBooksByTitle((java.lang.String) arguments[0]);
        }

        if (_methodName92.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
            return BookHistoryAPIServiceUtil.getBooksByAuthor((java.lang.String) arguments[0]);
        }

        if (_methodName93.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
            return BookHistoryAPIServiceUtil.getBooksByFromYearPublisedToYearPublished(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        throw new UnsupportedOperationException();
    }
}
