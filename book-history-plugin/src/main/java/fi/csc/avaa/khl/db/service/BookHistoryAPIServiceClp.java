package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author CSC
 * @generated
 */
public class BookHistoryAPIServiceClp implements BookHistoryAPIService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;

    public BookHistoryAPIServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getBooksByTitleAuthorFromYearPublisedToYearPublished";

        _methodParameterTypes3 = new String[] {
                "java.lang.String", "java.lang.String", "int", "int"
            };

        _methodName4 = "getBooksByTitle";

        _methodParameterTypes4 = new String[] { "java.lang.String" };

        _methodName5 = "getBooksByAuthor";

        _methodParameterTypes5 = new String[] { "java.lang.String" };

        _methodName6 = "getBooksByFromYearPublisedToYearPublished";

        _methodParameterTypes6 = new String[] { "int", "int" };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getBooksByTitleAuthorFromYearPublisedToYearPublished(
        java.lang.String bookTitle, java.lang.String bookAuthor,
        int fromYearPublished, int toYearPublished) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        ClpSerializer.translateInput(bookTitle),
                        
                    ClpSerializer.translateInput(bookAuthor),
                        
                    fromYearPublished,
                        
                    toYearPublished
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getBooksByTitle(
        java.lang.String bookTitle) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] { ClpSerializer.translateInput(bookTitle) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getBooksByAuthor(
        java.lang.String bookAuthor) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] { ClpSerializer.translateInput(bookAuthor) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getBooksByFromYearPublisedToYearPublished(
        int fromYearPublished, int toYearPublished) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] { fromYearPublished, toYearPublished });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat>) ClpSerializer.translateOutput(returnObj);
    }
}
