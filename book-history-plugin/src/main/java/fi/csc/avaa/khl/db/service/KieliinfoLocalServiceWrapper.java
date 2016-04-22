package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KieliinfoLocalService}.
 *
 * @author CSC
 * @see KieliinfoLocalService
 * @generated
 */
public class KieliinfoLocalServiceWrapper implements KieliinfoLocalService,
    ServiceWrapper<KieliinfoLocalService> {
    private KieliinfoLocalService _kieliinfoLocalService;

    public KieliinfoLocalServiceWrapper(
        KieliinfoLocalService kieliinfoLocalService) {
        _kieliinfoLocalService = kieliinfoLocalService;
    }

    /**
    * Adds the kieliinfo to the database. Also notifies the appropriate model listeners.
    *
    * @param kieliinfo the kieliinfo
    * @return the kieliinfo that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo addKieliinfo(
        fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.addKieliinfo(kieliinfo);
    }

    /**
    * Creates a new kieliinfo with the primary key. Does not add the kieliinfo to the database.
    *
    * @param kieliid the primary key for the new kieliinfo
    * @return the new kieliinfo
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo createKieliinfo(int kieliid) {
        return _kieliinfoLocalService.createKieliinfo(kieliid);
    }

    /**
    * Deletes the kieliinfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kieliid the primary key of the kieliinfo
    * @return the kieliinfo that was removed
    * @throws PortalException if a kieliinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo deleteKieliinfo(int kieliid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.deleteKieliinfo(kieliid);
    }

    /**
    * Deletes the kieliinfo from the database. Also notifies the appropriate model listeners.
    *
    * @param kieliinfo the kieliinfo
    * @return the kieliinfo that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo deleteKieliinfo(
        fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.deleteKieliinfo(kieliinfo);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _kieliinfoLocalService.dynamicQuery();
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
        return _kieliinfoLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KieliinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kieliinfoLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KieliinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kieliinfoLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _kieliinfoLocalService.dynamicQueryCount(dynamicQuery);
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
        return _kieliinfoLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo fetchKieliinfo(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.fetchKieliinfo(kieliid);
    }

    /**
    * Returns the kieliinfo with the primary key.
    *
    * @param kieliid the primary key of the kieliinfo
    * @return the kieliinfo
    * @throws PortalException if a kieliinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo getKieliinfo(int kieliid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.getKieliinfo(kieliid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the kieliinfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KieliinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kieliinfos
    * @param end the upper bound of the range of kieliinfos (not inclusive)
    * @return the range of kieliinfos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> getKieliinfos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.getKieliinfos(start, end);
    }

    /**
    * Returns the number of kieliinfos.
    *
    * @return the number of kieliinfos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getKieliinfosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.getKieliinfosCount();
    }

    /**
    * Updates the kieliinfo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param kieliinfo the kieliinfo
    * @return the kieliinfo that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo updateKieliinfo(
        fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kieliinfoLocalService.updateKieliinfo(kieliinfo);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kieliinfoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kieliinfoLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kieliinfoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kieliinfo findByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException {
        return _kieliinfoLocalService.findByKieli(kieli);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KieliinfoLocalService getWrappedKieliinfoLocalService() {
        return _kieliinfoLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKieliinfoLocalService(
        KieliinfoLocalService kieliinfoLocalService) {
        _kieliinfoLocalService = kieliinfoLocalService;
    }

    @Override
    public KieliinfoLocalService getWrappedService() {
        return _kieliinfoLocalService;
    }

    @Override
    public void setWrappedService(KieliinfoLocalService kieliinfoLocalService) {
        _kieliinfoLocalService = kieliinfoLocalService;
    }
}
