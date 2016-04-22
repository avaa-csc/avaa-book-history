package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MaakuntainfoService}.
 *
 * @author CSC
 * @see MaakuntainfoService
 * @generated
 */
public class MaakuntainfoServiceWrapper implements MaakuntainfoService,
    ServiceWrapper<MaakuntainfoService> {
    private MaakuntainfoService _maakuntainfoService;

    public MaakuntainfoServiceWrapper(MaakuntainfoService maakuntainfoService) {
        _maakuntainfoService = maakuntainfoService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _maakuntainfoService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _maakuntainfoService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _maakuntainfoService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MaakuntainfoService getWrappedMaakuntainfoService() {
        return _maakuntainfoService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMaakuntainfoService(
        MaakuntainfoService maakuntainfoService) {
        _maakuntainfoService = maakuntainfoService;
    }

    @Override
    public MaakuntainfoService getWrappedService() {
        return _maakuntainfoService;
    }

    @Override
    public void setWrappedService(MaakuntainfoService maakuntainfoService) {
        _maakuntainfoService = maakuntainfoService;
    }
}
