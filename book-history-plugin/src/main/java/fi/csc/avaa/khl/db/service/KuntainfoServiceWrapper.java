package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KuntainfoService}.
 *
 * @author CSC
 * @see KuntainfoService
 * @generated
 */
public class KuntainfoServiceWrapper implements KuntainfoService,
    ServiceWrapper<KuntainfoService> {
    private KuntainfoService _kuntainfoService;

    public KuntainfoServiceWrapper(KuntainfoService kuntainfoService) {
        _kuntainfoService = kuntainfoService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kuntainfoService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kuntainfoService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kuntainfoService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KuntainfoService getWrappedKuntainfoService() {
        return _kuntainfoService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKuntainfoService(KuntainfoService kuntainfoService) {
        _kuntainfoService = kuntainfoService;
    }

    @Override
    public KuntainfoService getWrappedService() {
        return _kuntainfoService;
    }

    @Override
    public void setWrappedService(KuntainfoService kuntainfoService) {
        _kuntainfoService = kuntainfoService;
    }
}
