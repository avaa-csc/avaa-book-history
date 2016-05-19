package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VanhatkirjatLocalService}.
 *
 * @author CSC
 * @see VanhatkirjatLocalService
 * @generated
 */
public class VanhatkirjatLocalServiceWrapper implements VanhatkirjatLocalService,
    ServiceWrapper<VanhatkirjatLocalService> {
    private VanhatkirjatLocalService _vanhatkirjatLocalService;

    public VanhatkirjatLocalServiceWrapper(
        VanhatkirjatLocalService vanhatkirjatLocalService) {
        _vanhatkirjatLocalService = vanhatkirjatLocalService;
    }

    /**
    * Adds the vanhatkirjat to the database. Also notifies the appropriate model listeners.
    *
    * @param vanhatkirjat the vanhatkirjat
    * @return the vanhatkirjat that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat addVanhatkirjat(
        fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.addVanhatkirjat(vanhatkirjat);
    }

    /**
    * Creates a new vanhatkirjat with the primary key. Does not add the vanhatkirjat to the database.
    *
    * @param vkid the primary key for the new vanhatkirjat
    * @return the new vanhatkirjat
    */
    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat createVanhatkirjat(int vkid) {
        return _vanhatkirjatLocalService.createVanhatkirjat(vkid);
    }

    /**
    * Deletes the vanhatkirjat with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param vkid the primary key of the vanhatkirjat
    * @return the vanhatkirjat that was removed
    * @throws PortalException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat deleteVanhatkirjat(int vkid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.deleteVanhatkirjat(vkid);
    }

    /**
    * Deletes the vanhatkirjat from the database. Also notifies the appropriate model listeners.
    *
    * @param vanhatkirjat the vanhatkirjat
    * @return the vanhatkirjat that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat deleteVanhatkirjat(
        fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.deleteVanhatkirjat(vanhatkirjat);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _vanhatkirjatLocalService.dynamicQuery();
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
        return _vanhatkirjatLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _vanhatkirjatLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _vanhatkirjatLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _vanhatkirjatLocalService.dynamicQueryCount(dynamicQuery);
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
        return _vanhatkirjatLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat fetchVanhatkirjat(int vkid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.fetchVanhatkirjat(vkid);
    }

    /**
    * Returns the vanhatkirjat with the primary key.
    *
    * @param vkid the primary key of the vanhatkirjat
    * @return the vanhatkirjat
    * @throws PortalException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat getVanhatkirjat(int vkid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.getVanhatkirjat(vkid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the vanhatkirjats.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @return the range of vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getVanhatkirjats(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.getVanhatkirjats(start, end);
    }

    /**
    * Returns the number of vanhatkirjats.
    *
    * @return the number of vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getVanhatkirjatsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.getVanhatkirjatsCount();
    }

    /**
    * Updates the vanhatkirjat in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param vanhatkirjat the vanhatkirjat
    * @return the vanhatkirjat that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat updateVanhatkirjat(
        fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.updateVanhatkirjat(vanhatkirjat);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _vanhatkirjatLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _vanhatkirjatLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _vanhatkirjatLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAllByPublishStatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.findAllByPublishStatus(status);
    }

    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAllByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.findAllByTitle(title);
    }

    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAllByAuthor(
        java.lang.String author)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.findAllByAuthor(author);
    }

    @Override
    public boolean deleteAllVanhatkirjat()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _vanhatkirjatLocalService.deleteAllVanhatkirjat();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public VanhatkirjatLocalService getWrappedVanhatkirjatLocalService() {
        return _vanhatkirjatLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedVanhatkirjatLocalService(
        VanhatkirjatLocalService vanhatkirjatLocalService) {
        _vanhatkirjatLocalService = vanhatkirjatLocalService;
    }

    @Override
    public VanhatkirjatLocalService getWrappedService() {
        return _vanhatkirjatLocalService;
    }

    @Override
    public void setWrappedService(
        VanhatkirjatLocalService vanhatkirjatLocalService) {
        _vanhatkirjatLocalService = vanhatkirjatLocalService;
    }
}
