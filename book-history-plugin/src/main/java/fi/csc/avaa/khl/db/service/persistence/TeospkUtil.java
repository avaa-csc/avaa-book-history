package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Teospk;

import java.util.List;

/**
 * The persistence utility for the teospk service. This utility wraps {@link TeospkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see TeospkPersistence
 * @see TeospkPersistenceImpl
 * @generated
 */
public class TeospkUtil {
    private static TeospkPersistence _persistence;

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
    public static void clearCache(Teospk teospk) {
        getPersistence().clearCache(teospk);
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
    public static List<Teospk> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Teospk> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Teospk> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Teospk update(Teospk teospk) throws SystemException {
        return getPersistence().update(teospk);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Teospk update(Teospk teospk, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(teospk, serviceContext);
    }

    /**
    * Returns the teospk where teospknimi = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchTeospkException} if it could not be found.
    *
    * @param teospknimi the teospknimi
    * @return the matching teospk
    * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a matching teospk could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Teospk findByTeospknimi(
        java.lang.String teospknimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException {
        return getPersistence().findByTeospknimi(teospknimi);
    }

    /**
    * Returns the teospk where teospknimi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param teospknimi the teospknimi
    * @return the matching teospk, or <code>null</code> if a matching teospk could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Teospk fetchByTeospknimi(
        java.lang.String teospknimi)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTeospknimi(teospknimi);
    }

    /**
    * Returns the teospk where teospknimi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param teospknimi the teospknimi
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching teospk, or <code>null</code> if a matching teospk could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Teospk fetchByTeospknimi(
        java.lang.String teospknimi, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTeospknimi(teospknimi, retrieveFromCache);
    }

    /**
    * Removes the teospk where teospknimi = &#63; from the database.
    *
    * @param teospknimi the teospknimi
    * @return the teospk that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Teospk removeByTeospknimi(
        java.lang.String teospknimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException {
        return getPersistence().removeByTeospknimi(teospknimi);
    }

    /**
    * Returns the number of teospks where teospknimi = &#63;.
    *
    * @param teospknimi the teospknimi
    * @return the number of matching teospks
    * @throws SystemException if a system exception occurred
    */
    public static int countByTeospknimi(java.lang.String teospknimi)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTeospknimi(teospknimi);
    }

    /**
    * Caches the teospk in the entity cache if it is enabled.
    *
    * @param teospk the teospk
    */
    public static void cacheResult(fi.csc.avaa.khl.db.model.Teospk teospk) {
        getPersistence().cacheResult(teospk);
    }

    /**
    * Caches the teospks in the entity cache if it is enabled.
    *
    * @param teospks the teospks
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Teospk> teospks) {
        getPersistence().cacheResult(teospks);
    }

    /**
    * Creates a new teospk with the primary key. Does not add the teospk to the database.
    *
    * @param teospkid the primary key for the new teospk
    * @return the new teospk
    */
    public static fi.csc.avaa.khl.db.model.Teospk create(int teospkid) {
        return getPersistence().create(teospkid);
    }

    /**
    * Removes the teospk with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param teospkid the primary key of the teospk
    * @return the teospk that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a teospk with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Teospk remove(int teospkid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException {
        return getPersistence().remove(teospkid);
    }

    public static fi.csc.avaa.khl.db.model.Teospk updateImpl(
        fi.csc.avaa.khl.db.model.Teospk teospk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(teospk);
    }

    /**
    * Returns the teospk with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchTeospkException} if it could not be found.
    *
    * @param teospkid the primary key of the teospk
    * @return the teospk
    * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a teospk with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Teospk findByPrimaryKey(int teospkid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException {
        return getPersistence().findByPrimaryKey(teospkid);
    }

    /**
    * Returns the teospk with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param teospkid the primary key of the teospk
    * @return the teospk, or <code>null</code> if a teospk with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Teospk fetchByPrimaryKey(
        int teospkid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(teospkid);
    }

    /**
    * Returns all the teospks.
    *
    * @return the teospks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Teospk> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the teospks.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.TeospkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of teospks
    * @param end the upper bound of the range of teospks (not inclusive)
    * @return the range of teospks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Teospk> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the teospks.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.TeospkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of teospks
    * @param end the upper bound of the range of teospks (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of teospks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Teospk> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the teospks from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of teospks.
    *
    * @return the number of teospks
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TeospkPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TeospkPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    TeospkPersistence.class.getName());

            ReferenceRegistry.registerReference(TeospkUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TeospkPersistence persistence) {
    }
}
