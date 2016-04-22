package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Kartoituskohde;

import java.util.List;

/**
 * The persistence utility for the kartoituskohde service. This utility wraps {@link KartoituskohdePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KartoituskohdePersistence
 * @see KartoituskohdePersistenceImpl
 * @generated
 */
public class KartoituskohdeUtil {
    private static KartoituskohdePersistence _persistence;

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
    public static void clearCache(Kartoituskohde kartoituskohde) {
        getPersistence().clearCache(kartoituskohde);
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
    public static List<Kartoituskohde> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Kartoituskohde> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Kartoituskohde> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Kartoituskohde update(Kartoituskohde kartoituskohde)
        throws SystemException {
        return getPersistence().update(kartoituskohde);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Kartoituskohde update(Kartoituskohde kartoituskohde,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(kartoituskohde, serviceContext);
    }

    /**
    * Returns the kartoituskohde where kartkohde = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKartoituskohdeException} if it could not be found.
    *
    * @param kartkohde the kartkohde
    * @return the matching kartoituskohde
    * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a matching kartoituskohde could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde findByKartkohde(
        java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException {
        return getPersistence().findByKartkohde(kartkohde);
    }

    /**
    * Returns the kartoituskohde where kartkohde = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param kartkohde the kartkohde
    * @return the matching kartoituskohde, or <code>null</code> if a matching kartoituskohde could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde fetchByKartkohde(
        java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKartkohde(kartkohde);
    }

    /**
    * Returns the kartoituskohde where kartkohde = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param kartkohde the kartkohde
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kartoituskohde, or <code>null</code> if a matching kartoituskohde could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde fetchByKartkohde(
        java.lang.String kartkohde, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByKartkohde(kartkohde, retrieveFromCache);
    }

    /**
    * Removes the kartoituskohde where kartkohde = &#63; from the database.
    *
    * @param kartkohde the kartkohde
    * @return the kartoituskohde that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde removeByKartkohde(
        java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException {
        return getPersistence().removeByKartkohde(kartkohde);
    }

    /**
    * Returns the number of kartoituskohdes where kartkohde = &#63;.
    *
    * @param kartkohde the kartkohde
    * @return the number of matching kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    public static int countByKartkohde(java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByKartkohde(kartkohde);
    }

    /**
    * Caches the kartoituskohde in the entity cache if it is enabled.
    *
    * @param kartoituskohde the kartoituskohde
    */
    public static void cacheResult(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde) {
        getPersistence().cacheResult(kartoituskohde);
    }

    /**
    * Caches the kartoituskohdes in the entity cache if it is enabled.
    *
    * @param kartoituskohdes the kartoituskohdes
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> kartoituskohdes) {
        getPersistence().cacheResult(kartoituskohdes);
    }

    /**
    * Creates a new kartoituskohde with the primary key. Does not add the kartoituskohde to the database.
    *
    * @param kohdeid the primary key for the new kartoituskohde
    * @return the new kartoituskohde
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde create(int kohdeid) {
        return getPersistence().create(kohdeid);
    }

    /**
    * Removes the kartoituskohde with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde remove(int kohdeid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException {
        return getPersistence().remove(kohdeid);
    }

    public static fi.csc.avaa.khl.db.model.Kartoituskohde updateImpl(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(kartoituskohde);
    }

    /**
    * Returns the kartoituskohde with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKartoituskohdeException} if it could not be found.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde
    * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde findByPrimaryKey(
        int kohdeid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException {
        return getPersistence().findByPrimaryKey(kohdeid);
    }

    /**
    * Returns the kartoituskohde with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde, or <code>null</code> if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Kartoituskohde fetchByPrimaryKey(
        int kohdeid) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(kohdeid);
    }

    /**
    * Returns all the kartoituskohdes.
    *
    * @return the kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the kartoituskohdes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kartoituskohdes
    * @param end the upper bound of the range of kartoituskohdes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the kartoituskohdes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of kartoituskohdes.
    *
    * @return the number of kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static KartoituskohdePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (KartoituskohdePersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    KartoituskohdePersistence.class.getName());

            ReferenceRegistry.registerReference(KartoituskohdeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(KartoituskohdePersistence persistence) {
    }
}
