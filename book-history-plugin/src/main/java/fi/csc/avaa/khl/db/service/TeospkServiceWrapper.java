package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TeospkService}.
 *
 * @author CSC
 * @see TeospkService
 * @generated
 */
public class TeospkServiceWrapper implements TeospkService,
    ServiceWrapper<TeospkService> {
    private TeospkService _teospkService;

    public TeospkServiceWrapper(TeospkService teospkService) {
        _teospkService = teospkService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _teospkService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _teospkService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _teospkService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TeospkService getWrappedTeospkService() {
        return _teospkService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTeospkService(TeospkService teospkService) {
        _teospkService = teospkService;
    }

    @Override
    public TeospkService getWrappedService() {
        return _teospkService;
    }

    @Override
    public void setWrappedService(TeospkService teospkService) {
        _teospkService = teospkService;
    }
}
