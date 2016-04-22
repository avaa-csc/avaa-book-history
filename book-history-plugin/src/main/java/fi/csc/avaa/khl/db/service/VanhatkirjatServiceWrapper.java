package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VanhatkirjatService}.
 *
 * @author CSC
 * @see VanhatkirjatService
 * @generated
 */
public class VanhatkirjatServiceWrapper implements VanhatkirjatService,
    ServiceWrapper<VanhatkirjatService> {
    private VanhatkirjatService _vanhatkirjatService;

    public VanhatkirjatServiceWrapper(VanhatkirjatService vanhatkirjatService) {
        _vanhatkirjatService = vanhatkirjatService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _vanhatkirjatService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _vanhatkirjatService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _vanhatkirjatService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public VanhatkirjatService getWrappedVanhatkirjatService() {
        return _vanhatkirjatService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedVanhatkirjatService(
        VanhatkirjatService vanhatkirjatService) {
        _vanhatkirjatService = vanhatkirjatService;
    }

    @Override
    public VanhatkirjatService getWrappedService() {
        return _vanhatkirjatService;
    }

    @Override
    public void setWrappedService(VanhatkirjatService vanhatkirjatService) {
        _vanhatkirjatService = vanhatkirjatService;
    }
}
