package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Kuntoluokitus;

import java.util.List;

/**
 * The persistence utility for the kuntoluokitus service. This utility wraps {@link KuntoluokitusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KuntoluokitusPersistence
 * @see KuntoluokitusPersistenceImpl
 * @generated
 */
public class KuntoluokitusUtil {
    private static KuntoluokitusPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Kuntoluokitus kuntoluokitus) {
        getPersistence().clearCache(kuntoluokitus);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Kuntoluokitus> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Kuntoluokitus> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Kuntoluokitus> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Kuntoluokitus update(Kuntoluokitus kuntoluokitus)
        throws SystemException {
        return getPersistence().update(kuntoluokitus);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Kuntoluokitus update(Kuntoluokitus kuntoluokitus,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(kuntoluokitus, serviceContext);
    }

    /**
    * Returns the kuntoluokitus where kunto = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntoluokitusException} if it could not be found.
    *
    * @param kunto the kunto
    * @return the matching kuntoluokitus
    * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a matching kuntoluokitus could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus findByKunto(
        java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException {
        return getPersistence().findByKunto(kunto);
    }

    /**
    * Returns the kuntoluokitus where kunto = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param kunto the kunto
    * @return the matching kuntoluokitus, or <code>null</code> if a matching kuntoluokitus could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus fetchByKunto(
        java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKunto(kunto);
    }

    /**
    * Returns the kuntoluokitus where kunto = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param kunto the kunto
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kuntoluokitus, or <code>null</code> if a matching kuntoluokitus could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus fetchByKunto(
        java.lang.String kunto, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKunto(kunto, retrieveFromCache);
    }

    /**
    * Removes the kuntoluokitus where kunto = &#63; from the database.
    *
    * @param kunto the kunto
    * @return the kuntoluokitus that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus removeByKunto(
        java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException {
        return getPersistence().removeByKunto(kunto);
    }

    /**
    * Returns the number of kuntoluokituses where kunto = &#63;.
    *
    * @param kunto the kunto
    * @return the number of matching kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public static int countByKunto(java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByKunto(kunto);
    }

    /**
    * Caches the kuntoluokitus in the entity cache if it is enabled.
    *
    * @param kuntoluokitus the kuntoluokitus
    */
    public static void cacheResult(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus) {
        getPersistence().cacheResult(kuntoluokitus);
    }

    /**
    * Caches the kuntoluokituses in the entity cache if it is enabled.
    *
    * @param kuntoluokituses the kuntoluokituses
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> kuntoluokituses) {
        getPersistence().cacheResult(kuntoluokituses);
    }

    /**
    * Creates a new kuntoluokitus with the primary key. Does not add the kuntoluokitus to the database.
    *
    * @param kuntoid the primary key for the new kuntoluokitus
    * @return the new kuntoluokitus
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus create(int kuntoid) {
        return getPersistence().create(kuntoid);
    }

    /**
    * Removes the kuntoluokitus with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus remove(int kuntoid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException {
        return getPersistence().remove(kuntoid);
    }

    public static fi.csc.avaa.khl.db.model.Kuntoluokitus updateImpl(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(kuntoluokitus);
    }

    /**
    * Returns the kuntoluokitus with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntoluokitusException} if it could not be found.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus
    * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus findByPrimaryKey(
        int kuntoid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException {
        return getPersistence().findByPrimaryKey(kuntoid);
    }

    /**
    * Returns the kuntoluokitus with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus, or <code>null</code> if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kuntoluokitus fetchByPrimaryKey(
        int kuntoid) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(kuntoid);
    }

    /**
    * Returns all the kuntoluokituses.
    *
    * @return the kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the kuntoluokituses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kuntoluokituses
    * @param end the upper bound of the range of kuntoluokituses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the kuntoluokituses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of kuntoluokituses.
    *
    * @return the number of kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static KuntoluokitusPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (KuntoluokitusPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    KuntoluokitusPersistence.class.getName());

            ReferenceRegistry.registerReference(KuntoluokitusUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(KuntoluokitusPersistence persistence) {
    }
}
