package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SidottuLocalService}.
 *
 * @author CSC
 * @see SidottuLocalService
 * @generated
 */
public class SidottuLocalServiceWrapper implements SidottuLocalService,
    ServiceWrapper<SidottuLocalService> {
    private SidottuLocalService _sidottuLocalService;

    public SidottuLocalServiceWrapper(SidottuLocalService sidottuLocalService) {
        _sidottuLocalService = sidottuLocalService;
    }

    /**
    * Adds the sidottu to the database. Also notifies the appropriate model listeners.
    *
    * @param sidottu the sidottu
    * @return the sidottu that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Sidottu addSidottu(
        fi.csc.avaa.khl.db.model.Sidottu sidottu)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.addSidottu(sidottu);
    }

    /**
    * Creates a new sidottu with the primary key. Does not add the sidottu to the database.
    *
    * @param sidontaid the primary key for the new sidottu
    * @return the new sidottu
    */
    @Override
    public fi.csc.avaa.khl.db.model.Sidottu createSidottu(int sidontaid) {
        return _sidottuLocalService.createSidottu(sidontaid);
    }

    /**
    * Deletes the sidottu with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sidontaid the primary key of the sidottu
    * @return the sidottu that was removed
    * @throws PortalException if a sidottu with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Sidottu deleteSidottu(int sidontaid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.deleteSidottu(sidontaid);
    }

    /**
    * Deletes the sidottu from the database. Also notifies the appropriate model listeners.
    *
    * @param sidottu the sidottu
    * @return the sidottu that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Sidottu deleteSidottu(
        fi.csc.avaa.khl.db.model.Sidottu sidottu)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.deleteSidottu(sidottu);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _sidottuLocalService.dynamicQuery();
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
        return _sidottuLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.SidottuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _sidottuLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.SidottuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _sidottuLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _sidottuLocalService.dynamicQueryCount(dynamicQuery);
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
        return _sidottuLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Sidottu fetchSidottu(int sidontaid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.fetchSidottu(sidontaid);
    }

    /**
    * Returns the sidottu with the primary key.
    *
    * @param sidontaid the primary key of the sidottu
    * @return the sidottu
    * @throws PortalException if a sidottu with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Sidottu getSidottu(int sidontaid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.getSidottu(sidontaid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the sidottus.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.SidottuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sidottus
    * @param end the upper bound of the range of sidottus (not inclusive)
    * @return the range of sidottus
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Sidottu> getSidottus(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.getSidottus(start, end);
    }

    /**
    * Returns the number of sidottus.
    *
    * @return the number of sidottus
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSidottusCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.getSidottusCount();
    }

    /**
    * Updates the sidottu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sidottu the sidottu
    * @return the sidottu that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Sidottu updateSidottu(
        fi.csc.avaa.khl.db.model.Sidottu sidottu)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sidottuLocalService.updateSidottu(sidottu);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sidottuLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sidottuLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sidottuLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Sidottu findBySidonta(
        java.lang.String sidonta)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchSidottuException {
        return _sidottuLocalService.findBySidonta(sidonta);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SidottuLocalService getWrappedSidottuLocalService() {
        return _sidottuLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSidottuLocalService(
        SidottuLocalService sidottuLocalService) {
        _sidottuLocalService = sidottuLocalService;
    }

    @Override
    public SidottuLocalService getWrappedService() {
        return _sidottuLocalService;
    }

    @Override
    public void setWrappedService(SidottuLocalService sidottuLocalService) {
        _sidottuLocalService = sidottuLocalService;
    }
}
