package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KartoituskohdeService}.
 *
 * @author CSC
 * @see KartoituskohdeService
 * @generated
 */
public class KartoituskohdeServiceWrapper implements KartoituskohdeService,
    ServiceWrapper<KartoituskohdeService> {
    private KartoituskohdeService _kartoituskohdeService;

    public KartoituskohdeServiceWrapper(
        KartoituskohdeService kartoituskohdeService) {
        _kartoituskohdeService = kartoituskohdeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kartoituskohdeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kartoituskohdeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kartoituskohdeService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KartoituskohdeService getWrappedKartoituskohdeService() {
        return _kartoituskohdeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKartoituskohdeService(
        KartoituskohdeService kartoituskohdeService) {
        _kartoituskohdeService = kartoituskohdeService;
    }

    @Override
    public KartoituskohdeService getWrappedService() {
        return _kartoituskohdeService;
    }

    @Override
    public void setWrappedService(KartoituskohdeService kartoituskohdeService) {
        _kartoituskohdeService = kartoituskohdeService;
    }
}
