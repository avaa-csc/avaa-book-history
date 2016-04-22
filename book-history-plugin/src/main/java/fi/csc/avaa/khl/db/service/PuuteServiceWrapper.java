package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PuuteService}.
 *
 * @author CSC
 * @see PuuteService
 * @generated
 */
public class PuuteServiceWrapper implements PuuteService,
    ServiceWrapper<PuuteService> {
    private PuuteService _puuteService;

    public PuuteServiceWrapper(PuuteService puuteService) {
        _puuteService = puuteService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _puuteService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _puuteService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _puuteService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PuuteService getWrappedPuuteService() {
        return _puuteService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPuuteService(PuuteService puuteService) {
        _puuteService = puuteService;
    }

    @Override
    public PuuteService getWrappedService() {
        return _puuteService;
    }

    @Override
    public void setWrappedService(PuuteService puuteService) {
        _puuteService = puuteService;
    }
}
