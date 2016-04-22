package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JulkaisulajiinfoService}.
 *
 * @author CSC
 * @see JulkaisulajiinfoService
 * @generated
 */
public class JulkaisulajiinfoServiceWrapper implements JulkaisulajiinfoService,
    ServiceWrapper<JulkaisulajiinfoService> {
    private JulkaisulajiinfoService _julkaisulajiinfoService;

    public JulkaisulajiinfoServiceWrapper(
        JulkaisulajiinfoService julkaisulajiinfoService) {
        _julkaisulajiinfoService = julkaisulajiinfoService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _julkaisulajiinfoService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _julkaisulajiinfoService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _julkaisulajiinfoService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JulkaisulajiinfoService getWrappedJulkaisulajiinfoService() {
        return _julkaisulajiinfoService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJulkaisulajiinfoService(
        JulkaisulajiinfoService julkaisulajiinfoService) {
        _julkaisulajiinfoService = julkaisulajiinfoService;
    }

    @Override
    public JulkaisulajiinfoService getWrappedService() {
        return _julkaisulajiinfoService;
    }

    @Override
    public void setWrappedService(
        JulkaisulajiinfoService julkaisulajiinfoService) {
        _julkaisulajiinfoService = julkaisulajiinfoService;
    }
}
