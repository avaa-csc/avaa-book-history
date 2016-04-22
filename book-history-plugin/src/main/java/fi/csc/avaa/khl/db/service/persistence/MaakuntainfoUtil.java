package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Maakuntainfo;

import java.util.List;

/**
 * The persistence utility for the maakuntainfo service. This utility wraps {@link MaakuntainfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see MaakuntainfoPersistence
 * @see MaakuntainfoPersistenceImpl
 * @generated
 */
public class MaakuntainfoUtil {
    private static MaakuntainfoPersistence _persistence;

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
    public static void clearCache(Maakuntainfo maakuntainfo) {
        getPersistence().clearCache(maakuntainfo);
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
    public static List<Maakuntainfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Maakuntainfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Maakuntainfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Maakuntainfo update(Maakuntainfo maakuntainfo)
        throws SystemException {
        return getPersistence().update(maakuntainfo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Maakuntainfo update(Maakuntainfo maakuntainfo,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(maakuntainfo, serviceContext);
    }

    /**
    * Caches the maakuntainfo in the entity cache if it is enabled.
    *
    * @param maakuntainfo the maakuntainfo
    */
    public static void cacheResult(
        fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo) {
        getPersistence().cacheResult(maakuntainfo);
    }

    /**
    * Caches the maakuntainfos in the entity cache if it is enabled.
    *
    * @param maakuntainfos the maakuntainfos
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> maakuntainfos) {
        getPersistence().cacheResult(maakuntainfos);
    }

    /**
    * Creates a new maakuntainfo with the primary key. Does not add the maakuntainfo to the database.
    *
    * @param maakuntaid the primary key for the new maakuntainfo
    * @return the new maakuntainfo
    */
    public static fi.csc.avaa.khl.db.model.Maakuntainfo create(int maakuntaid) {
        return getPersistence().create(maakuntaid);
    }

    /**
    * Removes the maakuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param maakuntaid the primary key of the maakuntainfo
    * @return the maakuntainfo that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchMaakuntainfoException if a maakuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Maakuntainfo remove(int maakuntaid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchMaakuntainfoException {
        return getPersistence().remove(maakuntaid);
    }

    public static fi.csc.avaa.khl.db.model.Maakuntainfo updateImpl(
        fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(maakuntainfo);
    }

    /**
    * Returns the maakuntainfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchMaakuntainfoException} if it could not be found.
    *
    * @param maakuntaid the primary key of the maakuntainfo
    * @return the maakuntainfo
    * @throws fi.csc.avaa.khl.db.NoSuchMaakuntainfoException if a maakuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Maakuntainfo findByPrimaryKey(
        int maakuntaid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchMaakuntainfoException {
        return getPersistence().findByPrimaryKey(maakuntaid);
    }

    /**
    * Returns the maakuntainfo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param maakuntaid the primary key of the maakuntainfo
    * @return the maakuntainfo, or <code>null</code> if a maakuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Maakuntainfo fetchByPrimaryKey(
        int maakuntaid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(maakuntaid);
    }

    /**
    * Returns all the maakuntainfos.
    *
    * @return the maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the maakuntainfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of maakuntainfos
    * @param end the upper bound of the range of maakuntainfos (not inclusive)
    * @return the range of maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the maakuntainfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of maakuntainfos
    * @param end the upper bound of the range of maakuntainfos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the maakuntainfos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of maakuntainfos.
    *
    * @return the number of maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MaakuntainfoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MaakuntainfoPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    MaakuntainfoPersistence.class.getName());

            ReferenceRegistry.registerReference(MaakuntainfoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(MaakuntainfoPersistence persistence) {
    }
}
