package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Julkaisulajiinfo;

import java.util.List;

/**
 * The persistence utility for the julkaisulajiinfo service. This utility wraps {@link JulkaisulajiinfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see JulkaisulajiinfoPersistence
 * @see JulkaisulajiinfoPersistenceImpl
 * @generated
 */
public class JulkaisulajiinfoUtil {
    private static JulkaisulajiinfoPersistence _persistence;

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
    public static void clearCache(Julkaisulajiinfo julkaisulajiinfo) {
        getPersistence().clearCache(julkaisulajiinfo);
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
    public static List<Julkaisulajiinfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Julkaisulajiinfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Julkaisulajiinfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Julkaisulajiinfo update(Julkaisulajiinfo julkaisulajiinfo)
        throws SystemException {
        return getPersistence().update(julkaisulajiinfo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Julkaisulajiinfo update(Julkaisulajiinfo julkaisulajiinfo,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(julkaisulajiinfo, serviceContext);
    }

    /**
    * Returns the julkaisulajiinfo where julklaji = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException} if it could not be found.
    *
    * @param julklaji the julklaji
    * @return the matching julkaisulajiinfo
    * @throws fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException if a matching julkaisulajiinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo findByJulklaji(
        java.lang.String julklaji)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException {
        return getPersistence().findByJulklaji(julklaji);
    }

    /**
    * Returns the julkaisulajiinfo where julklaji = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param julklaji the julklaji
    * @return the matching julkaisulajiinfo, or <code>null</code> if a matching julkaisulajiinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo fetchByJulklaji(
        java.lang.String julklaji)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByJulklaji(julklaji);
    }

    /**
    * Returns the julkaisulajiinfo where julklaji = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param julklaji the julklaji
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching julkaisulajiinfo, or <code>null</code> if a matching julkaisulajiinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo fetchByJulklaji(
        java.lang.String julklaji, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByJulklaji(julklaji, retrieveFromCache);
    }

    /**
    * Removes the julkaisulajiinfo where julklaji = &#63; from the database.
    *
    * @param julklaji the julklaji
    * @return the julkaisulajiinfo that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo removeByJulklaji(
        java.lang.String julklaji)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException {
        return getPersistence().removeByJulklaji(julklaji);
    }

    /**
    * Returns the number of julkaisulajiinfos where julklaji = &#63;.
    *
    * @param julklaji the julklaji
    * @return the number of matching julkaisulajiinfos
    * @throws SystemException if a system exception occurred
    */
    public static int countByJulklaji(java.lang.String julklaji)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByJulklaji(julklaji);
    }

    /**
    * Caches the julkaisulajiinfo in the entity cache if it is enabled.
    *
    * @param julkaisulajiinfo the julkaisulajiinfo
    */
    public static void cacheResult(
        fi.csc.avaa.khl.db.model.Julkaisulajiinfo julkaisulajiinfo) {
        getPersistence().cacheResult(julkaisulajiinfo);
    }

    /**
    * Caches the julkaisulajiinfos in the entity cache if it is enabled.
    *
    * @param julkaisulajiinfos the julkaisulajiinfos
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Julkaisulajiinfo> julkaisulajiinfos) {
        getPersistence().cacheResult(julkaisulajiinfos);
    }

    /**
    * Creates a new julkaisulajiinfo with the primary key. Does not add the julkaisulajiinfo to the database.
    *
    * @param julklajiid the primary key for the new julkaisulajiinfo
    * @return the new julkaisulajiinfo
    */
    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo create(
        int julklajiid) {
        return getPersistence().create(julklajiid);
    }

    /**
    * Removes the julkaisulajiinfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param julklajiid the primary key of the julkaisulajiinfo
    * @return the julkaisulajiinfo that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException if a julkaisulajiinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo remove(
        int julklajiid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException {
        return getPersistence().remove(julklajiid);
    }

    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo updateImpl(
        fi.csc.avaa.khl.db.model.Julkaisulajiinfo julkaisulajiinfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(julkaisulajiinfo);
    }

    /**
    * Returns the julkaisulajiinfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException} if it could not be found.
    *
    * @param julklajiid the primary key of the julkaisulajiinfo
    * @return the julkaisulajiinfo
    * @throws fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException if a julkaisulajiinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo findByPrimaryKey(
        int julklajiid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException {
        return getPersistence().findByPrimaryKey(julklajiid);
    }

    /**
    * Returns the julkaisulajiinfo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param julklajiid the primary key of the julkaisulajiinfo
    * @return the julkaisulajiinfo, or <code>null</code> if a julkaisulajiinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Julkaisulajiinfo fetchByPrimaryKey(
        int julklajiid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(julklajiid);
    }

    /**
    * Returns all the julkaisulajiinfos.
    *
    * @return the julkaisulajiinfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Julkaisulajiinfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the julkaisulajiinfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of julkaisulajiinfos
    * @param end the upper bound of the range of julkaisulajiinfos (not inclusive)
    * @return the range of julkaisulajiinfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Julkaisulajiinfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the julkaisulajiinfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of julkaisulajiinfos
    * @param end the upper bound of the range of julkaisulajiinfos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of julkaisulajiinfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Julkaisulajiinfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the julkaisulajiinfos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of julkaisulajiinfos.
    *
    * @return the number of julkaisulajiinfos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static JulkaisulajiinfoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (JulkaisulajiinfoPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    JulkaisulajiinfoPersistence.class.getName());

            ReferenceRegistry.registerReference(JulkaisulajiinfoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(JulkaisulajiinfoPersistence persistence) {
    }
}
