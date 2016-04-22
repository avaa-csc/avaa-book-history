package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Puute;

import java.util.List;

/**
 * The persistence utility for the puute service. This utility wraps {@link PuutePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see PuutePersistence
 * @see PuutePersistenceImpl
 * @generated
 */
public class PuuteUtil {
    private static PuutePersistence _persistence;

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
    public static void clearCache(Puute puute) {
        getPersistence().clearCache(puute);
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
    public static List<Puute> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Puute> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Puute> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Puute update(Puute puute) throws SystemException {
        return getPersistence().update(puute);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Puute update(Puute puute, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(puute, serviceContext);
    }

    /**
    * Returns the puute where puutenimi = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchPuuteException} if it could not be found.
    *
    * @param puutenimi the puutenimi
    * @return the matching puute
    * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a matching puute could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Puute findByPuutenimi(
        java.lang.String puutenimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException {
        return getPersistence().findByPuutenimi(puutenimi);
    }

    /**
    * Returns the puute where puutenimi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param puutenimi the puutenimi
    * @return the matching puute, or <code>null</code> if a matching puute could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Puute fetchByPuutenimi(
        java.lang.String puutenimi)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPuutenimi(puutenimi);
    }

    /**
    * Returns the puute where puutenimi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param puutenimi the puutenimi
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching puute, or <code>null</code> if a matching puute could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Puute fetchByPuutenimi(
        java.lang.String puutenimi, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPuutenimi(puutenimi, retrieveFromCache);
    }

    /**
    * Removes the puute where puutenimi = &#63; from the database.
    *
    * @param puutenimi the puutenimi
    * @return the puute that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Puute removeByPuutenimi(
        java.lang.String puutenimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException {
        return getPersistence().removeByPuutenimi(puutenimi);
    }

    /**
    * Returns the number of puutes where puutenimi = &#63;.
    *
    * @param puutenimi the puutenimi
    * @return the number of matching puutes
    * @throws SystemException if a system exception occurred
    */
    public static int countByPuutenimi(java.lang.String puutenimi)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPuutenimi(puutenimi);
    }

    /**
    * Caches the puute in the entity cache if it is enabled.
    *
    * @param puute the puute
    */
    public static void cacheResult(fi.csc.avaa.khl.db.model.Puute puute) {
        getPersistence().cacheResult(puute);
    }

    /**
    * Caches the puutes in the entity cache if it is enabled.
    *
    * @param puutes the puutes
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Puute> puutes) {
        getPersistence().cacheResult(puutes);
    }

    /**
    * Creates a new puute with the primary key. Does not add the puute to the database.
    *
    * @param puuteid the primary key for the new puute
    * @return the new puute
    */
    public static fi.csc.avaa.khl.db.model.Puute create(int puuteid) {
        return getPersistence().create(puuteid);
    }

    /**
    * Removes the puute with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param puuteid the primary key of the puute
    * @return the puute that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a puute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Puute remove(int puuteid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException {
        return getPersistence().remove(puuteid);
    }

    public static fi.csc.avaa.khl.db.model.Puute updateImpl(
        fi.csc.avaa.khl.db.model.Puute puute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(puute);
    }

    /**
    * Returns the puute with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchPuuteException} if it could not be found.
    *
    * @param puuteid the primary key of the puute
    * @return the puute
    * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a puute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Puute findByPrimaryKey(int puuteid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException {
        return getPersistence().findByPrimaryKey(puuteid);
    }

    /**
    * Returns the puute with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param puuteid the primary key of the puute
    * @return the puute, or <code>null</code> if a puute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Puute fetchByPrimaryKey(int puuteid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(puuteid);
    }

    /**
    * Returns all the puutes.
    *
    * @return the puutes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Puute> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<fi.csc.avaa.khl.db.model.Puute> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the puutes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.PuuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of puutes
    * @param end the upper bound of the range of puutes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of puutes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Puute> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the puutes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of puutes.
    *
    * @return the number of puutes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PuutePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PuutePersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    PuutePersistence.class.getName());

            ReferenceRegistry.registerReference(PuuteUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PuutePersistence persistence) {
    }
}
