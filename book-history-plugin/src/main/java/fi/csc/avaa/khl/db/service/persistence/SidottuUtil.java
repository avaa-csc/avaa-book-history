package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Sidottu;

import java.util.List;

/**
 * The persistence utility for the sidottu service. This utility wraps {@link SidottuPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see SidottuPersistence
 * @see SidottuPersistenceImpl
 * @generated
 */
public class SidottuUtil {
    private static SidottuPersistence _persistence;

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
    public static void clearCache(Sidottu sidottu) {
        getPersistence().clearCache(sidottu);
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
    public static List<Sidottu> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Sidottu> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Sidottu> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Sidottu update(Sidottu sidottu) throws SystemException {
        return getPersistence().update(sidottu);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Sidottu update(Sidottu sidottu, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(sidottu, serviceContext);
    }

    /**
    * Returns the sidottu where sidonta = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchSidottuException} if it could not be found.
    *
    * @param sidonta the sidonta
    * @return the matching sidottu
    * @throws fi.csc.avaa.khl.db.NoSuchSidottuException if a matching sidottu could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Sidottu findBySidonta(
        java.lang.String sidonta)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchSidottuException {
        return getPersistence().findBySidonta(sidonta);
    }

    /**
    * Returns the sidottu where sidonta = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param sidonta the sidonta
    * @return the matching sidottu, or <code>null</code> if a matching sidottu could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Sidottu fetchBySidonta(
        java.lang.String sidonta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBySidonta(sidonta);
    }

    /**
    * Returns the sidottu where sidonta = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param sidonta the sidonta
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching sidottu, or <code>null</code> if a matching sidottu could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Sidottu fetchBySidonta(
        java.lang.String sidonta, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBySidonta(sidonta, retrieveFromCache);
    }

    /**
    * Removes the sidottu where sidonta = &#63; from the database.
    *
    * @param sidonta the sidonta
    * @return the sidottu that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Sidottu removeBySidonta(
        java.lang.String sidonta)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchSidottuException {
        return getPersistence().removeBySidonta(sidonta);
    }

    /**
    * Returns the number of sidottus where sidonta = &#63;.
    *
    * @param sidonta the sidonta
    * @return the number of matching sidottus
    * @throws SystemException if a system exception occurred
    */
    public static int countBySidonta(java.lang.String sidonta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySidonta(sidonta);
    }

    /**
    * Caches the sidottu in the entity cache if it is enabled.
    *
    * @param sidottu the sidottu
    */
    public static void cacheResult(fi.csc.avaa.khl.db.model.Sidottu sidottu) {
        getPersistence().cacheResult(sidottu);
    }

    /**
    * Caches the sidottus in the entity cache if it is enabled.
    *
    * @param sidottus the sidottus
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Sidottu> sidottus) {
        getPersistence().cacheResult(sidottus);
    }

    /**
    * Creates a new sidottu with the primary key. Does not add the sidottu to the database.
    *
    * @param sidontaid the primary key for the new sidottu
    * @return the new sidottu
    */
    public static fi.csc.avaa.khl.db.model.Sidottu create(int sidontaid) {
        return getPersistence().create(sidontaid);
    }

    /**
    * Removes the sidottu with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sidontaid the primary key of the sidottu
    * @return the sidottu that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchSidottuException if a sidottu with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Sidottu remove(int sidontaid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchSidottuException {
        return getPersistence().remove(sidontaid);
    }

    public static fi.csc.avaa.khl.db.model.Sidottu updateImpl(
        fi.csc.avaa.khl.db.model.Sidottu sidottu)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(sidottu);
    }

    /**
    * Returns the sidottu with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchSidottuException} if it could not be found.
    *
    * @param sidontaid the primary key of the sidottu
    * @return the sidottu
    * @throws fi.csc.avaa.khl.db.NoSuchSidottuException if a sidottu with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Sidottu findByPrimaryKey(
        int sidontaid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchSidottuException {
        return getPersistence().findByPrimaryKey(sidontaid);
    }

    /**
    * Returns the sidottu with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param sidontaid the primary key of the sidottu
    * @return the sidottu, or <code>null</code> if a sidottu with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Sidottu fetchByPrimaryKey(
        int sidontaid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(sidontaid);
    }

    /**
    * Returns all the sidottus.
    *
    * @return the sidottus
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Sidottu> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the sidottus.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.SidottuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sidottus
    * @param end the upper bound of the range of sidottus (not inclusive)
    * @return the range of sidottus
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Sidottu> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the sidottus.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.SidottuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sidottus
    * @param end the upper bound of the range of sidottus (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of sidottus
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Sidottu> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the sidottus from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of sidottus.
    *
    * @return the number of sidottus
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SidottuPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SidottuPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    SidottuPersistence.class.getName());

            ReferenceRegistry.registerReference(SidottuUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SidottuPersistence persistence) {
    }
}
