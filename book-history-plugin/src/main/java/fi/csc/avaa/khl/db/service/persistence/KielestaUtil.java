package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Kielesta;

import java.util.List;

/**
 * The persistence utility for the kielesta service. This utility wraps {@link KielestaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KielestaPersistence
 * @see KielestaPersistenceImpl
 * @generated
 */
public class KielestaUtil {
    private static KielestaPersistence _persistence;

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
    public static void clearCache(Kielesta kielesta) {
        getPersistence().clearCache(kielesta);
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
    public static List<Kielesta> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Kielesta> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Kielesta> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Kielesta update(Kielesta kielesta) throws SystemException {
        return getPersistence().update(kielesta);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Kielesta update(Kielesta kielesta,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(kielesta, serviceContext);
    }

    /**
    * Returns the kielesta where kieli = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKielestaException} if it could not be found.
    *
    * @param kieli the kieli
    * @return the matching kielesta
    * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a matching kielesta could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kielesta findByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException {
        return getPersistence().findByKieli(kieli);
    }

    /**
    * Returns the kielesta where kieli = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param kieli the kieli
    * @return the matching kielesta, or <code>null</code> if a matching kielesta could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kielesta fetchByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKieli(kieli);
    }

    /**
    * Returns the kielesta where kieli = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param kieli the kieli
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kielesta, or <code>null</code> if a matching kielesta could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kielesta fetchByKieli(
        java.lang.String kieli, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKieli(kieli, retrieveFromCache);
    }

    /**
    * Removes the kielesta where kieli = &#63; from the database.
    *
    * @param kieli the kieli
    * @return the kielesta that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kielesta removeByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException {
        return getPersistence().removeByKieli(kieli);
    }

    /**
    * Returns the number of kielestas where kieli = &#63;.
    *
    * @param kieli the kieli
    * @return the number of matching kielestas
    * @throws SystemException if a system exception occurred
    */
    public static int countByKieli(java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByKieli(kieli);
    }

    /**
    * Caches the kielesta in the entity cache if it is enabled.
    *
    * @param kielesta the kielesta
    */
    public static void cacheResult(fi.csc.avaa.khl.db.model.Kielesta kielesta) {
        getPersistence().cacheResult(kielesta);
    }

    /**
    * Caches the kielestas in the entity cache if it is enabled.
    *
    * @param kielestas the kielestas
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kielesta> kielestas) {
        getPersistence().cacheResult(kielestas);
    }

    /**
    * Creates a new kielesta with the primary key. Does not add the kielesta to the database.
    *
    * @param kieliid the primary key for the new kielesta
    * @return the new kielesta
    */
    public static fi.csc.avaa.khl.db.model.Kielesta create(int kieliid) {
        return getPersistence().create(kieliid);
    }

    /**
    * Removes the kielesta with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kieliid the primary key of the kielesta
    * @return the kielesta that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a kielesta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kielesta remove(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException {
        return getPersistence().remove(kieliid);
    }

    public static fi.csc.avaa.khl.db.model.Kielesta updateImpl(
        fi.csc.avaa.khl.db.model.Kielesta kielesta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(kielesta);
    }

    /**
    * Returns the kielesta with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKielestaException} if it could not be found.
    *
    * @param kieliid the primary key of the kielesta
    * @return the kielesta
    * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a kielesta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kielesta findByPrimaryKey(
        int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException {
        return getPersistence().findByPrimaryKey(kieliid);
    }

    /**
    * Returns the kielesta with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kieliid the primary key of the kielesta
    * @return the kielesta, or <code>null</code> if a kielesta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kielesta fetchByPrimaryKey(
        int kieliid) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(kieliid);
    }

    /**
    * Returns all the kielestas.
    *
    * @return the kielestas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kielesta> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<fi.csc.avaa.khl.db.model.Kielesta> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the kielestas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KielestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kielestas
    * @param end the upper bound of the range of kielestas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of kielestas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kielesta> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the kielestas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of kielestas.
    *
    * @return the number of kielestas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static KielestaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (KielestaPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    KielestaPersistence.class.getName());

            ReferenceRegistry.registerReference(KielestaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(KielestaPersistence persistence) {
    }
}
