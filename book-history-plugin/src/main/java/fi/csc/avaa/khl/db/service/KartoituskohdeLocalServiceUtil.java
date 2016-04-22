package fi.csc.avaa.khl.db.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Kartoituskohde. This utility wraps
 * {@link fi.csc.avaa.khl.db.service.impl.KartoituskohdeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author CSC
 * @see KartoituskohdeLocalService
 * @see fi.csc.avaa.khl.db.service.base.KartoituskohdeLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.impl.KartoituskohdeLocalServiceImpl
 * @generated
 */
public class KartoituskohdeLocalServiceUtil {
    private static KartoituskohdeLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link fi.csc.avaa.khl.db.service.impl.KartoituskohdeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the kartoituskohde to the database. Also notifies the appropriate model listeners.
    *
    * @param kartoituskohde the kartoituskohde
    * @return the kartoituskohde that was added
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde addKartoituskohde(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addKartoituskohde(kartoituskohde);
    }

    /**
    * Creates a new kartoituskohde with the primary key. Does not add the kartoituskohde to the database.
    *
    * @param kohdeid the primary key for the new kartoituskohde
    * @return the new kartoituskohde
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde createKartoituskohde(
        int kohdeid) {
        return getService().createKartoituskohde(kohdeid);
    }

    /**
    * Deletes the kartoituskohde with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde that was removed
    * @throws PortalException if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde deleteKartoituskohde(
        int kohdeid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteKartoituskohde(kohdeid);
    }

    /**
    * Deletes the kartoituskohde from the database. Also notifies the appropriate model listeners.
    *
    * @param kartoituskohde the kartoituskohde
    * @return the kartoituskohde that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde deleteKartoituskohde(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteKartoituskohde(kartoituskohde);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static fi.csc.avaa.khl.db.model.Kartoituskohde fetchKartoituskohde(
        int kohdeid) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchKartoituskohde(kohdeid);
    }

    /**
    * Returns the kartoituskohde with the primary key.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde
    * @throws PortalException if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde getKartoituskohde(
        int kohdeid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getKartoituskohde(kohdeid);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> getKartoituskohdes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getKartoituskohdes(start, end);
    }

    /**
    * Returns the number of kartoituskohdes.
    *
    * @return the number of kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    public static int getKartoituskohdesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getKartoituskohdesCount();
    }

    /**
    * Updates the kartoituskohde in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param kartoituskohde the kartoituskohde
    * @return the kartoituskohde that was updated
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde updateKartoituskohde(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateKartoituskohde(kartoituskohde);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static fi.csc.avaa.khl.db.model.Kartoituskohde findByKartkohde(
        java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException {
        return getService().findByKartkohde(kartkohde);
    }

    public static void clearService() {
        _service = null;
    }

    public static KartoituskohdeLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    KartoituskohdeLocalService.class.getName());

            if (invokableLocalService instanceof KartoituskohdeLocalService) {
                _service = (KartoituskohdeLocalService) invokableLocalService;
            } else {
                _service = new KartoituskohdeLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(KartoituskohdeLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(KartoituskohdeLocalService service) {
    }
}
