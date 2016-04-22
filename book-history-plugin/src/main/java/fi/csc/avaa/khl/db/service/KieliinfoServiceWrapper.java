package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KieliinfoService}.
 *
 * @author CSC
 * @see KieliinfoService
 * @generated
 */
public class KieliinfoServiceWrapper implements KieliinfoService,
    ServiceWrapper<KieliinfoService> {
    private KieliinfoService _kieliinfoService;

    public KieliinfoServiceWrapper(KieliinfoService kieliinfoService) {
        _kieliinfoService = kieliinfoService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kieliinfoService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kieliinfoService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kieliinfoService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KieliinfoService getWrappedKieliinfoService() {
        return _kieliinfoService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKieliinfoService(KieliinfoService kieliinfoService) {
        _kieliinfoService = kieliinfoService;
    }

    @Override
    public KieliinfoService getWrappedService() {
        return _kieliinfoService;
    }

    @Override
    public void setWrappedService(KieliinfoService kieliinfoService) {
        _kieliinfoService = kieliinfoService;
    }
}
