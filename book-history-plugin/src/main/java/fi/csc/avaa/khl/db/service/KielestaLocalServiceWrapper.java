package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KielestaLocalService}.
 *
 * @author CSC
 * @see KielestaLocalService
 * @generated
 */
public class KielestaLocalServiceWrapper implements KielestaLocalService,
    ServiceWrapper<KielestaLocalService> {
    private KielestaLocalService _kielestaLocalService;

    public KielestaLocalServiceWrapper(
        KielestaLocalService kielestaLocalService) {
        _kielestaLocalService = kielestaLocalService;
    }

    /**
    * Adds the kielesta to the database. Also notifies the appropriate model listeners.
    *
    * @param kielesta the kielesta
    * @return the kielesta that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kielesta addKielesta(
        fi.csc.avaa.khl.db.model.Kielesta kielesta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.addKielesta(kielesta);
    }

    /**
    * Creates a new kielesta with the primary key. Does not add the kielesta to the database.
    *
    * @param kieliid the primary key for the new kielesta
    * @return the new kielesta
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kielesta createKielesta(int kieliid) {
        return _kielestaLocalService.createKielesta(kieliid);
    }

    /**
    * Deletes the kielesta with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kieliid the primary key of the kielesta
    * @return the kielesta that was removed
    * @throws PortalException if a kielesta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kielesta deleteKielesta(int kieliid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.deleteKielesta(kieliid);
    }

    /**
    * Deletes the kielesta from the database. Also notifies the appropriate model listeners.
    *
    * @param kielesta the kielesta
    * @return the kielesta that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kielesta deleteKielesta(
        fi.csc.avaa.khl.db.model.Kielesta kielesta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.deleteKielesta(kielesta);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _kielestaLocalService.dynamicQuery();
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
        return _kielestaLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KielestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kielestaLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KielestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kielestaLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _kielestaLocalService.dynamicQueryCount(dynamicQuery);
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
        return _kielestaLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kielesta fetchKielesta(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.fetchKielesta(kieliid);
    }

    /**
    * Returns the kielesta with the primary key.
    *
    * @param kieliid the primary key of the kielesta
    * @return the kielesta
    * @throws PortalException if a kielesta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kielesta getKielesta(int kieliid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.getKielesta(kieliid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the kielestas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KielestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kielestas
    * @param end the upper bound of the range of kielestas (not inclusive)
    * @return the range of kielestas
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Kielesta> getKielestas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.getKielestas(start, end);
    }

    /**
    * Returns the number of kielestas.
    *
    * @return the number of kielestas
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getKielestasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.getKielestasCount();
    }

    /**
    * Updates the kielesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param kielesta the kielesta
    * @return the kielesta that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kielesta updateKielesta(
        fi.csc.avaa.khl.db.model.Kielesta kielesta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kielestaLocalService.updateKielesta(kielesta);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kielestaLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kielestaLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kielestaLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kielesta findByKieli(java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException {
        return _kielestaLocalService.findByKieli(kieli);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KielestaLocalService getWrappedKielestaLocalService() {
        return _kielestaLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKielestaLocalService(
        KielestaLocalService kielestaLocalService) {
        _kielestaLocalService = kielestaLocalService;
    }

    @Override
    public KielestaLocalService getWrappedService() {
        return _kielestaLocalService;
    }

    @Override
    public void setWrappedService(KielestaLocalService kielestaLocalService) {
        _kielestaLocalService = kielestaLocalService;
    }
}
