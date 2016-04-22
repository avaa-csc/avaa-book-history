package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KielestaService}.
 *
 * @author CSC
 * @see KielestaService
 * @generated
 */
public class KielestaServiceWrapper implements KielestaService,
    ServiceWrapper<KielestaService> {
    private KielestaService _kielestaService;

    public KielestaServiceWrapper(KielestaService kielestaService) {
        _kielestaService = kielestaService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kielestaService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kielestaService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kielestaService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KielestaService getWrappedKielestaService() {
        return _kielestaService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKielestaService(KielestaService kielestaService) {
        _kielestaService = kielestaService;
    }

    @Override
    public KielestaService getWrappedService() {
        return _kielestaService;
    }

    @Override
    public void setWrappedService(KielestaService kielestaService) {
        _kielestaService = kielestaService;
    }
}
