package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MaakuntainfoLocalService}.
 *
 * @author CSC
 * @see MaakuntainfoLocalService
 * @generated
 */
public class MaakuntainfoLocalServiceWrapper implements MaakuntainfoLocalService,
    ServiceWrapper<MaakuntainfoLocalService> {
    private MaakuntainfoLocalService _maakuntainfoLocalService;

    public MaakuntainfoLocalServiceWrapper(
        MaakuntainfoLocalService maakuntainfoLocalService) {
        _maakuntainfoLocalService = maakuntainfoLocalService;
    }

    /**
    * Adds the maakuntainfo to the database. Also notifies the appropriate model listeners.
    *
    * @param maakuntainfo the maakuntainfo
    * @return the maakuntainfo that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo addMaakuntainfo(
        fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.addMaakuntainfo(maakuntainfo);
    }

    /**
    * Creates a new maakuntainfo with the primary key. Does not add the maakuntainfo to the database.
    *
    * @param maakuntaid the primary key for the new maakuntainfo
    * @return the new maakuntainfo
    */
    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo createMaakuntainfo(
        int maakuntaid) {
        return _maakuntainfoLocalService.createMaakuntainfo(maakuntaid);
    }

    /**
    * Deletes the maakuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param maakuntaid the primary key of the maakuntainfo
    * @return the maakuntainfo that was removed
    * @throws PortalException if a maakuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo deleteMaakuntainfo(
        int maakuntaid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.deleteMaakuntainfo(maakuntaid);
    }

    /**
    * Deletes the maakuntainfo from the database. Also notifies the appropriate model listeners.
    *
    * @param maakuntainfo the maakuntainfo
    * @return the maakuntainfo that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo deleteMaakuntainfo(
        fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.deleteMaakuntainfo(maakuntainfo);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _maakuntainfoLocalService.dynamicQuery();
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
        return _maakuntainfoLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _maakuntainfoLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _maakuntainfoLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _maakuntainfoLocalService.dynamicQueryCount(dynamicQuery);
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
        return _maakuntainfoLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo fetchMaakuntainfo(
        int maakuntaid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.fetchMaakuntainfo(maakuntaid);
    }

    /**
    * Returns the maakuntainfo with the primary key.
    *
    * @param maakuntaid the primary key of the maakuntainfo
    * @return the maakuntainfo
    * @throws PortalException if a maakuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo getMaakuntainfo(int maakuntaid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.getMaakuntainfo(maakuntaid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the maakuntainfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of maakuntainfos
    * @param end the upper bound of the range of maakuntainfos (not inclusive)
    * @return the range of maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> getMaakuntainfos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.getMaakuntainfos(start, end);
    }

    /**
    * Returns the number of maakuntainfos.
    *
    * @return the number of maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getMaakuntainfosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.getMaakuntainfosCount();
    }

    /**
    * Updates the maakuntainfo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param maakuntainfo the maakuntainfo
    * @return the maakuntainfo that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public fi.csc.avaa.khl.db.model.Maakuntainfo updateMaakuntainfo(
        fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _maakuntainfoLocalService.updateMaakuntainfo(maakuntainfo);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _maakuntainfoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _maakuntainfoLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _maakuntainfoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MaakuntainfoLocalService getWrappedMaakuntainfoLocalService() {
        return _maakuntainfoLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMaakuntainfoLocalService(
        MaakuntainfoLocalService maakuntainfoLocalService) {
        _maakuntainfoLocalService = maakuntainfoLocalService;
    }

    @Override
    public MaakuntainfoLocalService getWrappedService() {
        return _maakuntainfoLocalService;
    }

    @Override
    public void setWrappedService(
        MaakuntainfoLocalService maakuntainfoLocalService) {
        _maakuntainfoLocalService = maakuntainfoLocalService;
    }
}
