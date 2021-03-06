package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TeospkLocalService}.
 *
 * @author CSC
 * @see TeospkLocalService
 * @generated
 */
public class TeospkLocalServiceWrapper implements TeospkLocalService,
    ServiceWrapper<TeospkLocalService> {
    private TeospkLocalService _teospkLocalService;

    public TeospkLocalServiceWrapper(TeospkLocalService teospkLocalService) {
        _teospkLocalService = teospkLocalService;
    }

    /**
    * Adds the teospk to the database. Also notifies the appropriate model listeners.
    *
    * @param teospk the teospk
    * @return the teospk that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Teospk addTeospk(
        fi.csc.avaa.khl.db.model.Teospk teospk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.addTeospk(teospk);
    }

    /**
    * Creates a new teospk with the primary key. Does not add the teospk to the database.
    *
    * @param teospkid the primary key for the new teospk
    * @return the new teospk
    */
    @Override
    public fi.csc.avaa.khl.db.model.Teospk createTeospk(int teospkid) {
        return _teospkLocalService.createTeospk(teospkid);
    }

    /**
    * Deletes the teospk with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param teospkid the primary key of the teospk
    * @return the teospk that was removed
    * @throws PortalException if a teospk with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Teospk deleteTeospk(int teospkid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.deleteTeospk(teospkid);
    }

    /**
    * Deletes the teospk from the database. Also notifies the appropriate model listeners.
    *
    * @param teospk the teospk
    * @return the teospk that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Teospk deleteTeospk(
        fi.csc.avaa.khl.db.model.Teospk teospk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.deleteTeospk(teospk);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _teospkLocalService.dynamicQuery();
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
        return _teospkLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.TeospkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _teospkLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.TeospkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _teospkLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _teospkLocalService.dynamicQueryCount(dynamicQuery);
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
        return _teospkLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Teospk fetchTeospk(int teospkid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.fetchTeospk(teospkid);
    }

    /**
    * Returns the teospk with the primary key.
    *
    * @param teospkid the primary key of the teospk
    * @return the teospk
    * @throws PortalException if a teospk with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Teospk getTeospk(int teospkid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.getTeospk(teospkid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the teospks.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.TeospkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of teospks
    * @param end the upper bound of the range of teospks (not inclusive)
    * @return the range of teospks
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Teospk> getTeospks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.getTeospks(start, end);
    }

    /**
    * Returns the number of teospks.
    *
    * @return the number of teospks
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTeospksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.getTeospksCount();
    }

    /**
    * Updates the teospk in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param teospk the teospk
    * @return the teospk that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Teospk updateTeospk(
        fi.csc.avaa.khl.db.model.Teospk teospk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _teospkLocalService.updateTeospk(teospk);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _teospkLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _teospkLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _teospkLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Teospk findByTeospk(java.lang.String teospk)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException {
        return _teospkLocalService.findByTeospk(teospk);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TeospkLocalService getWrappedTeospkLocalService() {
        return _teospkLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTeospkLocalService(
        TeospkLocalService teospkLocalService) {
        _teospkLocalService = teospkLocalService;
    }

    @Override
    public TeospkLocalService getWrappedService() {
        return _teospkLocalService;
    }

    @Override
    public void setWrappedService(TeospkLocalService teospkLocalService) {
        _teospkLocalService = teospkLocalService;
    }
}
