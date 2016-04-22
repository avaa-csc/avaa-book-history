package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KartoituskohdeLocalService}.
 *
 * @author CSC
 * @see KartoituskohdeLocalService
 * @generated
 */
public class KartoituskohdeLocalServiceWrapper
    implements KartoituskohdeLocalService,
        ServiceWrapper<KartoituskohdeLocalService> {
    private KartoituskohdeLocalService _kartoituskohdeLocalService;

    public KartoituskohdeLocalServiceWrapper(
        KartoituskohdeLocalService kartoituskohdeLocalService) {
        _kartoituskohdeLocalService = kartoituskohdeLocalService;
    }

    /**
    * Adds the kartoituskohde to the database. Also notifies the appropriate model listeners.
    *
    * @param kartoituskohde the kartoituskohde
    * @return the kartoituskohde that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde addKartoituskohde(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.addKartoituskohde(kartoituskohde);
    }

    /**
    * Creates a new kartoituskohde with the primary key. Does not add the kartoituskohde to the database.
    *
    * @param kohdeid the primary key for the new kartoituskohde
    * @return the new kartoituskohde
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde createKartoituskohde(
        int kohdeid) {
        return _kartoituskohdeLocalService.createKartoituskohde(kohdeid);
    }

    /**
    * Deletes the kartoituskohde with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde that was removed
    * @throws PortalException if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde deleteKartoituskohde(
        int kohdeid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.deleteKartoituskohde(kohdeid);
    }

    /**
    * Deletes the kartoituskohde from the database. Also notifies the appropriate model listeners.
    *
    * @param kartoituskohde the kartoituskohde
    * @return the kartoituskohde that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde deleteKartoituskohde(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.deleteKartoituskohde(kartoituskohde);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _kartoituskohdeLocalService.dynamicQuery();
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
        return _kartoituskohdeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kartoituskohdeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _kartoituskohdeLocalService.dynamicQuery(dynamicQuery, start,
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
        return _kartoituskohdeLocalService.dynamicQueryCount(dynamicQuery);
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
        return _kartoituskohdeLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde fetchKartoituskohde(
        int kohdeid) throws com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.fetchKartoituskohde(kohdeid);
    }

    /**
    * Returns the kartoituskohde with the primary key.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde
    * @throws PortalException if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde getKartoituskohde(
        int kohdeid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.getKartoituskohde(kohdeid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the kartoituskohdes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kartoituskohdes
    * @param end the upper bound of the range of kartoituskohdes (not inclusive)
    * @return the range of kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> getKartoituskohdes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.getKartoituskohdes(start, end);
    }

    /**
    * Returns the number of kartoituskohdes.
    *
    * @return the number of kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getKartoituskohdesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.getKartoituskohdesCount();
    }

    /**
    * Updates the kartoituskohde in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param kartoituskohde the kartoituskohde
    * @return the kartoituskohde that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde updateKartoituskohde(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _kartoituskohdeLocalService.updateKartoituskohde(kartoituskohde);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _kartoituskohdeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _kartoituskohdeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _kartoituskohdeLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Kartoituskohde findByKartkohde(
        java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException {
        return _kartoituskohdeLocalService.findByKartkohde(kartkohde);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public KartoituskohdeLocalService getWrappedKartoituskohdeLocalService() {
        return _kartoituskohdeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedKartoituskohdeLocalService(
        KartoituskohdeLocalService kartoituskohdeLocalService) {
        _kartoituskohdeLocalService = kartoituskohdeLocalService;
    }

    @Override
    public KartoituskohdeLocalService getWrappedService() {
        return _kartoituskohdeLocalService;
    }

    @Override
    public void setWrappedService(
        KartoituskohdeLocalService kartoituskohdeLocalService) {
        _kartoituskohdeLocalService = kartoituskohdeLocalService;
    }
}
