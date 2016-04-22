package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KuntoluokitusService}.
 *
 * @author CSC
 * @see KuntoluokitusService
 * @generated
 */
public class KuntoluokitusServiceWrapper implements KuntoluokitusService,
    ServiceWrapper<KuntoluokitusService> {
    private KuntoluokitusService _kuntoluokitusService;

    public KuntoluokitusServiceWrapper(
        KuntoluokitusService kuntoluokitusService) {
        _kuntoluokitusService = kuntoluokitusService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kuntoluokitusService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kuntoluokitusService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kuntoluokitusService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KuntoluokitusService getWrappedKuntoluokitusService() {
        return _kuntoluokitusService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKuntoluokitusService(
        KuntoluokitusService kuntoluokitusService) {
        _kuntoluokitusService = kuntoluokitusService;
    }

    @Override
    public KuntoluokitusService getWrappedService() {
        return _kuntoluokitusService;
    }

    @Override
    public void setWrappedService(KuntoluokitusService kuntoluokitusService) {
        _kuntoluokitusService = kuntoluokitusService;
    }
}
