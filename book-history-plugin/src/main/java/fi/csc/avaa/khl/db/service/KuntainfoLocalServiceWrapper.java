package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KuntainfoLocalService}.
 *
 * @author CSC
 * @see KuntainfoLocalService
 * @generated
 */
public class KuntainfoLocalServiceWrapper implements KuntainfoLocalService,
    ServiceWrapper<KuntainfoLocalService> {
    private KuntainfoLocalService _kuntainfoLocalService;

    public KuntainfoLocalServiceWrapper(
        KuntainfoLocalService kuntainfoLocalService) {
        _kuntainfoLocalService = kuntainfoLocalService;
    }

    /**
    * Adds the kuntainfo to the database. Also notifies the appropriate model listeners.
    *
    * @param kuntainfo the kuntainfo
    * @return the kuntainfo that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo addKuntainfo(
        fi.csc.avaa.khl.db.model.Kuntainfo kuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.addKuntainfo(kuntainfo);
    }

    /**
    * Creates a new kuntainfo with the primary key. Does not add the kuntainfo to the database.
    *
    * @param kuntaid the primary key for the new kuntainfo
    * @return the new kuntainfo
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo createKuntainfo(int kuntaid) {
        return _kuntainfoLocalService.createKuntainfo(kuntaid);
    }

    /**
    * Deletes the kuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntaid the primary key of the kuntainfo
    * @return the kuntainfo that was removed
    * @throws PortalException if a kuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo deleteKuntainfo(int kuntaid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.deleteKuntainfo(kuntaid);
    }

    /**
    * Deletes the kuntainfo from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntainfo the kuntainfo
    * @return the kuntainfo that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo deleteKuntainfo(
        fi.csc.avaa.khl.db.model.Kuntainfo kuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.deleteKuntainfo(kuntainfo);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _kuntainfoLocalService.dynamicQuery();
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
        return _kuntainfoLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kuntainfoLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kuntainfoLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _kuntainfoLocalService.dynamicQueryCount(dynamicQuery);
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
        return _kuntainfoLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo fetchKuntainfo(int kuntaid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.fetchKuntainfo(kuntaid);
    }

    /**
    * Returns the kuntainfo with the primary key.
    *
    * @param kuntaid the primary key of the kuntainfo
    * @return the kuntainfo
    * @throws PortalException if a kuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo getKuntainfo(int kuntaid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.getKuntainfo(kuntaid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the kuntainfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kuntainfos
    * @param end the upper bound of the range of kuntainfos (not inclusive)
    * @return the range of kuntainfos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Kuntainfo> getKuntainfos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.getKuntainfos(start, end);
    }

    /**
    * Returns the number of kuntainfos.
    *
    * @return the number of kuntainfos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getKuntainfosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.getKuntainfosCount();
    }

    /**
    * Updates the kuntainfo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param kuntainfo the kuntainfo
    * @return the kuntainfo that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo updateKuntainfo(
        fi.csc.avaa.khl.db.model.Kuntainfo kuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kuntainfoLocalService.updateKuntainfo(kuntainfo);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kuntainfoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kuntainfoLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kuntainfoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kuntainfo findByCapitalkuntanimi(
        java.lang.String capitalKuntanimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntainfoException {
        return _kuntainfoLocalService.findByCapitalkuntanimi(capitalKuntanimi);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KuntainfoLocalService getWrappedKuntainfoLocalService() {
        return _kuntainfoLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKuntainfoLocalService(
        KuntainfoLocalService kuntainfoLocalService) {
        _kuntainfoLocalService = kuntainfoLocalService;
    }

    @Override
    public KuntainfoLocalService getWrappedService() {
        return _kuntainfoLocalService;
    }

    @Override
    public void setWrappedService(KuntainfoLocalService kuntainfoLocalService) {
        _kuntainfoLocalService = kuntainfoLocalService;
    }
}
