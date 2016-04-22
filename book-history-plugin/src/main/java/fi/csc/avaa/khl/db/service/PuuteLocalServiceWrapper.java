package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PuuteLocalService}.
 *
 * @author CSC
 * @see PuuteLocalService
 * @generated
 */
public class PuuteLocalServiceWrapper implements PuuteLocalService,
    ServiceWrapper<PuuteLocalService> {
    private PuuteLocalService _puuteLocalService;

    public PuuteLocalServiceWrapper(PuuteLocalService puuteLocalService) {
        _puuteLocalService = puuteLocalService;
    }

    /**
    * Adds the puute to the database. Also notifies the appropriate model listeners.
    *
    * @param puute the puute
    * @return the puute that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Puute addPuute(
        fi.csc.avaa.khl.db.model.Puute puute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.addPuute(puute);
    }

    /**
    * Creates a new puute with the primary key. Does not add the puute to the database.
    *
    * @param puuteid the primary key for the new puute
    * @return the new puute
    */
    @Override
    public fi.csc.avaa.khl.db.model.Puute createPuute(int puuteid) {
        return _puuteLocalService.createPuute(puuteid);
    }

    /**
    * Deletes the puute with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param puuteid the primary key of the puute
    * @return the puute that was removed
    * @throws PortalException if a puute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Puute deletePuute(int puuteid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.deletePuute(puuteid);
    }

    /**
    * Deletes the puute from the database. Also notifies the appropriate model listeners.
    *
    * @param puute the puute
    * @return the puute that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Puute deletePuute(
        fi.csc.avaa.khl.db.model.Puute puute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.deletePuute(puute);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _puuteLocalService.dynamicQuery();
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
        return _puuteLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.PuuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _puuteLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.PuuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _puuteLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _puuteLocalService.dynamicQueryCount(dynamicQuery);
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
        return _puuteLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Puute fetchPuute(int puuteid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.fetchPuute(puuteid);
    }

    /**
    * Returns the puute with the primary key.
    *
    * @param puuteid the primary key of the puute
    * @return the puute
    * @throws PortalException if a puute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Puute getPuute(int puuteid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.getPuute(puuteid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the puutes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.PuuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of puutes
    * @param end the upper bound of the range of puutes (not inclusive)
    * @return the range of puutes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Puute> getPuutes(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.getPuutes(start, end);
    }

    /**
    * Returns the number of puutes.
    *
    * @return the number of puutes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPuutesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.getPuutesCount();
    }

    /**
    * Updates the puute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param puute the puute
    * @return the puute that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Puute updatePuute(
        fi.csc.avaa.khl.db.model.Puute puute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _puuteLocalService.updatePuute(puute);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _puuteLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _puuteLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _puuteLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Puute findByPuute(java.lang.String puute)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException {
        return _puuteLocalService.findByPuute(puute);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PuuteLocalService getWrappedPuuteLocalService() {
        return _puuteLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPuuteLocalService(PuuteLocalService puuteLocalService) {
        _puuteLocalService = puuteLocalService;
    }

    @Override
    public PuuteLocalService getWrappedService() {
        return _puuteLocalService;
    }

    @Override
    public void setWrappedService(PuuteLocalService puuteLocalService) {
        _puuteLocalService = puuteLocalService;
    }
}
