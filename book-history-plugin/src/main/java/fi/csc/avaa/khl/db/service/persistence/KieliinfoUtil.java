package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Kieliinfo;

import java.util.List;

/**
 * The persistence utility for the kieliinfo service. This utility wraps {@link KieliinfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KieliinfoPersistence
 * @see KieliinfoPersistenceImpl
 * @generated
 */
public class KieliinfoUtil {
    private static KieliinfoPersistence _persistence;

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
    public static void clearCache(Kieliinfo kieliinfo) {
        getPersistence().clearCache(kieliinfo);
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
    public static List<Kieliinfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Kieliinfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Kieliinfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Kieliinfo update(Kieliinfo kieliinfo)
        throws SystemException {
        return getPersistence().update(kieliinfo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Kieliinfo update(Kieliinfo kieliinfo,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(kieliinfo, serviceContext);
    }

    /**
    * Returns the kieliinfo where kieli = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKieliinfoException} if it could not be found.
    *
    * @param kieli the kieli
    * @return the matching kieliinfo
    * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a matching kieliinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kieliinfo findByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException {
        return getPersistence().findByKieli(kieli);
    }

    /**
    * Returns the kieliinfo where kieli = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param kieli the kieli
    * @return the matching kieliinfo, or <code>null</code> if a matching kieliinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kieliinfo fetchByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKieli(kieli);
    }

    /**
    * Returns the kieliinfo where kieli = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param kieli the kieli
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kieliinfo, or <code>null</code> if a matching kieliinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kieliinfo fetchByKieli(
        java.lang.String kieli, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKieli(kieli, retrieveFromCache);
    }

    /**
    * Removes the kieliinfo where kieli = &#63; from the database.
    *
    * @param kieli the kieli
    * @return the kieliinfo that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kieliinfo removeByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException {
        return getPersistence().removeByKieli(kieli);
    }

    /**
    * Returns the number of kieliinfos where kieli = &#63;.
    *
    * @param kieli the kieli
    * @return the number of matching kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public static int countByKieli(java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByKieli(kieli);
    }

    /**
    * Caches the kieliinfo in the entity cache if it is enabled.
    *
    * @param kieliinfo the kieliinfo
    */
    public static void cacheResult(fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo) {
        getPersistence().cacheResult(kieliinfo);
    }

    /**
    * Caches the kieliinfos in the entity cache if it is enabled.
    *
    * @param kieliinfos the kieliinfos
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> kieliinfos) {
        getPersistence().cacheResult(kieliinfos);
    }

    /**
    * Creates a new kieliinfo with the primary key. Does not add the kieliinfo to the database.
    *
    * @param kieliid the primary key for the new kieliinfo
    * @return the new kieliinfo
    */
    public static fi.csc.avaa.khl.db.model.Kieliinfo create(int kieliid) {
        return getPersistence().create(kieliid);
    }

    /**
    * Removes the kieliinfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kieliid the primary key of the kieliinfo
    * @return the kieliinfo that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a kieliinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kieliinfo remove(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException {
        return getPersistence().remove(kieliid);
    }

    public static fi.csc.avaa.khl.db.model.Kieliinfo updateImpl(
        fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(kieliinfo);
    }

    /**
    * Returns the kieliinfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKieliinfoException} if it could not be found.
    *
    * @param kieliid the primary key of the kieliinfo
    * @return the kieliinfo
    * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a kieliinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kieliinfo findByPrimaryKey(
        int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException {
        return getPersistence().findByPrimaryKey(kieliid);
    }

    /**
    * Returns the kieliinfo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kieliid the primary key of the kieliinfo
    * @return the kieliinfo, or <code>null</code> if a kieliinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kieliinfo fetchByPrimaryKey(
        int kieliid) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(kieliid);
    }

    /**
    * Returns all the kieliinfos.
    *
    * @return the kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the kieliinfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KieliinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kieliinfos
    * @param end the upper bound of the range of kieliinfos (not inclusive)
    * @return the range of kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the kieliinfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KieliinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kieliinfos
    * @param end the upper bound of the range of kieliinfos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the kieliinfos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of kieliinfos.
    *
    * @return the number of kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static KieliinfoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (KieliinfoPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    KieliinfoPersistence.class.getName());

            ReferenceRegistry.registerReference(KieliinfoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(KieliinfoPersistence persistence) {
    }
}
