package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JulkaisulajiinfoLocalService}.
 *
 * @author CSC
 * @see JulkaisulajiinfoLocalService
 * @generated
 */
public class JulkaisulajiinfoLocalServiceWrapper
    implements JulkaisulajiinfoLocalService,
        ServiceWrapper<JulkaisulajiinfoLocalService> {
    private JulkaisulajiinfoLocalService _julkaisulajiinfoLocalService;

    public JulkaisulajiinfoLocalServiceWrapper(
        JulkaisulajiinfoLocalService julkaisulajiinfoLocalService) {
        _julkaisulajiinfoLocalService = julkaisulajiinfoLocalService;
    }

    /**
    * Adds the julkaisulajiinfo to the database. Also notifies the appropriate model listeners.
    *
    * @param julkaisulajiinfo the julkaisulajiinfo
    * @return the julkaisulajiinfo that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo addJulkaisulajiinfo(
        fi.csc.avaa.khl.db.model.Julkaisulajiinfo julkaisulajiinfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.addJulkaisulajiinfo(julkaisulajiinfo);
    }

    /**
    * Creates a new julkaisulajiinfo with the primary key. Does not add the julkaisulajiinfo to the database.
    *
    * @param julklajiid the primary key for the new julkaisulajiinfo
    * @return the new julkaisulajiinfo
    */
    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo createJulkaisulajiinfo(
        int julklajiid) {
        return _julkaisulajiinfoLocalService.createJulkaisulajiinfo(julklajiid);
    }

    /**
    * Deletes the julkaisulajiinfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param julklajiid the primary key of the julkaisulajiinfo
    * @return the julkaisulajiinfo that was removed
    * @throws PortalException if a julkaisulajiinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo deleteJulkaisulajiinfo(
        int julklajiid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.deleteJulkaisulajiinfo(julklajiid);
    }

    /**
    * Deletes the julkaisulajiinfo from the database. Also notifies the appropriate model listeners.
    *
    * @param julkaisulajiinfo the julkaisulajiinfo
    * @return the julkaisulajiinfo that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo deleteJulkaisulajiinfo(
        fi.csc.avaa.khl.db.model.Julkaisulajiinfo julkaisulajiinfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.deleteJulkaisulajiinfo(julkaisulajiinfo);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _julkaisulajiinfoLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo fetchJulkaisulajiinfo(
        int julklajiid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.fetchJulkaisulajiinfo(julklajiid);
    }

    /**
    * Returns the julkaisulajiinfo with the primary key.
    *
    * @param julklajiid the primary key of the julkaisulajiinfo
    * @return the julkaisulajiinfo
    * @throws PortalException if a julkaisulajiinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo getJulkaisulajiinfo(
        int julklajiid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.getJulkaisulajiinfo(julklajiid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the julkaisulajiinfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of julkaisulajiinfos
    * @param end the upper bound of the range of julkaisulajiinfos (not inclusive)
    * @return the range of julkaisulajiinfos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Julkaisulajiinfo> getJulkaisulajiinfos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.getJulkaisulajiinfos(start, end);
    }

    /**
    * Returns the number of julkaisulajiinfos.
    *
    * @return the number of julkaisulajiinfos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getJulkaisulajiinfosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.getJulkaisulajiinfosCount();
    }

    /**
    * Updates the julkaisulajiinfo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param julkaisulajiinfo the julkaisulajiinfo
    * @return the julkaisulajiinfo that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo updateJulkaisulajiinfo(
        fi.csc.avaa.khl.db.model.Julkaisulajiinfo julkaisulajiinfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _julkaisulajiinfoLocalService.updateJulkaisulajiinfo(julkaisulajiinfo);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _julkaisulajiinfoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _julkaisulajiinfoLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _julkaisulajiinfoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Julkaisulajiinfo findByJulkaisulaji(
        java.lang.String julkaisulaji)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException {
        return _julkaisulajiinfoLocalService.findByJulkaisulaji(julkaisulaji);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JulkaisulajiinfoLocalService getWrappedJulkaisulajiinfoLocalService() {
        return _julkaisulajiinfoLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJulkaisulajiinfoLocalService(
        JulkaisulajiinfoLocalService julkaisulajiinfoLocalService) {
        _julkaisulajiinfoLocalService = julkaisulajiinfoLocalService;
    }

    @Override
    public JulkaisulajiinfoLocalService getWrappedService() {
        return _julkaisulajiinfoLocalService;
    }

    @Override
    public void setWrappedService(
        JulkaisulajiinfoLocalService julkaisulajiinfoLocalService) {
        _julkaisulajiinfoLocalService = julkaisulajiinfoLocalService;
    }
}
