package fi.csc.avaa.khl.db.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Kuntoluokitus. This utility wraps
 * {@link fi.csc.avaa.khl.db.service.impl.KuntoluokitusLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author CSC
 * @see KuntoluokitusLocalService
 * @see fi.csc.avaa.khl.db.service.base.KuntoluokitusLocalServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.impl.KuntoluokitusLocalServiceImpl
 * @generated
 */
public class KuntoluokitusLocalServiceUtil {
    private static KuntoluokitusLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link fi.csc.avaa.khl.db.service.impl.KuntoluokitusLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the kuntoluokitus to the database. Also notifies the appropriate model listeners.
    *
    * @param kuntoluokitus the kuntoluokitus
    * @return the kuntoluokitus that was added
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus addKuntoluokitus(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addKuntoluokitus(kuntoluokitus);
    }

    /**
    * Creates a new kuntoluokitus with the primary key. Does not add the kuntoluokitus to the database.
    *
    * @param kuntoid the primary key for the new kuntoluokitus
    * @return the new kuntoluokitus
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus createKuntoluokitus(
        int kuntoid) {
        return getService().createKuntoluokitus(kuntoid);
    }

    /**
    * Deletes the kuntoluokitus with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus that was removed
    * @throws PortalException if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus deleteKuntoluokitus(
        int kuntoid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteKuntoluokitus(kuntoid);
    }

    /**
    * Deletes the kuntoluokitus from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntoluokitus the kuntoluokitus
    * @return the kuntoluokitus that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus deleteKuntoluokitus(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteKuntoluokitus(kuntoluokitus);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static fi.csc.avaa.khl.db.model.Kuntoluokitus fetchKuntoluokitus(
        int kuntoid) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchKuntoluokitus(kuntoid);
    }

    /**
    * Returns the kuntoluokitus with the primary key.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus
    * @throws PortalException if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus getKuntoluokitus(
        int kuntoid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getKuntoluokitus(kuntoid);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> getKuntoluokituses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getKuntoluokituses(start, end);
    }

    /**
    * Returns the number of kuntoluokituses.
    *
    * @return the number of kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public static int getKuntoluokitusesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getKuntoluokitusesCount();
    }

    /**
    * Updates the kuntoluokitus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param kuntoluokitus the kuntoluokitus
    * @return the kuntoluokitus that was updated
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus updateKuntoluokitus(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateKuntoluokitus(kuntoluokitus);
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

    public static fi.csc.avaa.khl.db.model.Kuntoluokitus findByKunto(
        java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException {
        return getService().findByKunto(kunto);
    }

    public static void clearService() {
        _service = null;
    }

    public static KuntoluokitusLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    KuntoluokitusLocalService.class.getName());

            if (invokableLocalService instanceof KuntoluokitusLocalService) {
                _service = (KuntoluokitusLocalService) invokableLocalService;
            } else {
                _service = new KuntoluokitusLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(KuntoluokitusLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(KuntoluokitusLocalService service) {
    }
}
