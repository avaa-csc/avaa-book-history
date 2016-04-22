package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KuntoluokitusLocalService}.
 *
 * @author CSC
 * @see KuntoluokitusLocalService
 * @generated
 */
public class KuntoluokitusLocalServiceWrapper
    implements KuntoluokitusLocalService,
        ServiceWrapper<KuntoluokitusLocalService> {
    private KuntoluokitusLocalService _kuntoluokitusLocalService;

    public KuntoluokitusLocalServiceWrapper(
        KuntoluokitusLocalService kuntoluokitusLocalService) {
        _kuntoluokitusLocalService = kuntoluokitusLocalService;
    }

    /**
    * Adds the kuntoluokitus to the database. Also notifies the appropriate model listeners.
    *
    * @param kuntoluokitus the kuntoluokitus
    * @return the kuntoluokitus that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus addKuntoluokitus(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.addKuntoluokitus(kuntoluokitus);
    }

    /**
    * Creates a new kuntoluokitus with the primary key. Does not add the kuntoluokitus to the database.
    *
    * @param kuntoid the primary key for the new kuntoluokitus
    * @return the new kuntoluokitus
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus createKuntoluokitus(
        int kuntoid) {
        return _kuntoluokitusLocalService.createKuntoluokitus(kuntoid);
    }

    /**
    * Deletes the kuntoluokitus with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus that was removed
    * @throws PortalException if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus deleteKuntoluokitus(
        int kuntoid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.deleteKuntoluokitus(kuntoid);
    }

    /**
    * Deletes the kuntoluokitus from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntoluokitus the kuntoluokitus
    * @return the kuntoluokitus that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus deleteKuntoluokitus(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.deleteKuntoluokitus(kuntoluokitus);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _kuntoluokitusLocalService.dynamicQuery();
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
        return _kuntoluokitusLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kuntoluokitusLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kuntoluokitusLocalService.dynamicQuery(dynamicQuery, start,
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
        return _kuntoluokitusLocalService.dynamicQueryCount(dynamicQuery);
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
        return _kuntoluokitusLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus fetchKuntoluokitus(
        int kuntoid) throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.fetchKuntoluokitus(kuntoid);
    }

    /**
    * Returns the kuntoluokitus with the primary key.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus
    * @throws PortalException if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus getKuntoluokitus(int kuntoid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.getKuntoluokitus(kuntoid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the kuntoluokituses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kuntoluokituses
    * @param end the upper bound of the range of kuntoluokituses (not inclusive)
    * @return the range of kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> getKuntoluokituses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.getKuntoluokituses(start, end);
    }

    /**
    * Returns the number of kuntoluokituses.
    *
    * @return the number of kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getKuntoluokitusesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.getKuntoluokitusesCount();
    }

    /**
    * Updates the kuntoluokitus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param kuntoluokitus the kuntoluokitus
    * @return the kuntoluokitus that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus updateKuntoluokitus(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntoluokitusLocalService.updateKuntoluokitus(kuntoluokitus);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kuntoluokitusLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kuntoluokitusLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kuntoluokitusLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kuntoluokitus findByKunto(
        java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException {
        return _kuntoluokitusLocalService.findByKunto(kunto);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KuntoluokitusLocalService getWrappedKuntoluokitusLocalService() {
        return _kuntoluokitusLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKuntoluokitusLocalService(
        KuntoluokitusLocalService kuntoluokitusLocalService) {
        _kuntoluokitusLocalService = kuntoluokitusLocalService;
    }

    @Override
    public KuntoluokitusLocalService getWrappedService() {
        return _kuntoluokitusLocalService;
    }

    @Override
    public void setWrappedService(
        KuntoluokitusLocalService kuntoluokitusLocalService) {
        _kuntoluokitusLocalService = kuntoluokitusLocalService;
    }
}
