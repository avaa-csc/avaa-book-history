package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SidottuService}.
 *
 * @author CSC
 * @see SidottuService
 * @generated
 */
public class SidottuServiceWrapper implements SidottuService,
    ServiceWrapper<SidottuService> {
    private SidottuService _sidottuService;

    public SidottuServiceWrapper(SidottuService sidottuService) {
        _sidottuService = sidottuService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sidottuService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sidottuService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sidottuService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SidottuService getWrappedSidottuService() {
        return _sidottuService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSidottuService(SidottuService sidottuService) {
        _sidottuService = sidottuService;
    }

    @Override
    public SidottuService getWrappedService() {
        return _sidottuService;
    }

    @Override
    public void setWrappedService(SidottuService sidottuService) {
        _sidottuService = sidottuService;
    }
}
