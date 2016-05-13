package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.Vanhatkirjat;

import java.util.List;

/**
 * The persistence utility for the vanhatkirjat service. This utility wraps {@link VanhatkirjatPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see VanhatkirjatPersistence
 * @see VanhatkirjatPersistenceImpl
 * @generated
 */
public class VanhatkirjatUtil {
    private static VanhatkirjatPersistence _persistence;

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
    public static void clearCache(Vanhatkirjat vanhatkirjat) {
        getPersistence().clearCache(vanhatkirjat);
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
    public static List<Vanhatkirjat> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Vanhatkirjat> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Vanhatkirjat> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Vanhatkirjat update(Vanhatkirjat vanhatkirjat)
        throws SystemException {
        return getPersistence().update(vanhatkirjat);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Vanhatkirjat update(Vanhatkirjat vanhatkirjat,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(vanhatkirjat, serviceContext);
    }

    /**
    * Returns all the vanhatkirjats where status = &#63;.
    *
    * @param status the status
    * @return the matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByPublishStatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPublishStatus(status);
    }

    /**
    * Returns a range of all the vanhatkirjats where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @return the range of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByPublishStatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPublishStatus(status, start, end);
    }

    /**
    * Returns an ordered range of all the vanhatkirjats where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByPublishStatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPublishStatus(status, start, end, orderByComparator);
    }

    /**
    * Returns the first vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat findByPublishStatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence()
                   .findByPublishStatus_First(status, orderByComparator);
    }

    /**
    * Returns the first vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByPublishStatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPublishStatus_First(status, orderByComparator);
    }

    /**
    * Returns the last vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat findByPublishStatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence()
                   .findByPublishStatus_Last(status, orderByComparator);
    }

    /**
    * Returns the last vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByPublishStatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPublishStatus_Last(status, orderByComparator);
    }

    /**
    * Returns the vanhatkirjats before and after the current vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param vkid the primary key of the current vanhatkirjat
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat[] findByPublishStatus_PrevAndNext(
        int vkid, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence()
                   .findByPublishStatus_PrevAndNext(vkid, status,
            orderByComparator);
    }

    /**
    * Removes all the vanhatkirjats where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPublishStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPublishStatus(status);
    }

    /**
    * Returns the number of vanhatkirjats where status = &#63;.
    *
    * @param status the status
    * @return the number of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static int countByPublishStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPublishStatus(status);
    }

    /**
    * Returns all the vanhatkirjats where teoknimi = &#63;.
    *
    * @param teoknimi the teoknimi
    * @return the matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByTitle(
        java.lang.String teoknimi)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTitle(teoknimi);
    }

    /**
    * Returns a range of all the vanhatkirjats where teoknimi = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param teoknimi the teoknimi
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @return the range of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByTitle(
        java.lang.String teoknimi, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTitle(teoknimi, start, end);
    }

    /**
    * Returns an ordered range of all the vanhatkirjats where teoknimi = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param teoknimi the teoknimi
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByTitle(
        java.lang.String teoknimi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTitle(teoknimi, start, end, orderByComparator);
    }

    /**
    * Returns the first vanhatkirjat in the ordered set where teoknimi = &#63;.
    *
    * @param teoknimi the teoknimi
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat findByTitle_First(
        java.lang.String teoknimi,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence().findByTitle_First(teoknimi, orderByComparator);
    }

    /**
    * Returns the first vanhatkirjat in the ordered set where teoknimi = &#63;.
    *
    * @param teoknimi the teoknimi
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByTitle_First(
        java.lang.String teoknimi,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTitle_First(teoknimi, orderByComparator);
    }

    /**
    * Returns the last vanhatkirjat in the ordered set where teoknimi = &#63;.
    *
    * @param teoknimi the teoknimi
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat findByTitle_Last(
        java.lang.String teoknimi,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence().findByTitle_Last(teoknimi, orderByComparator);
    }

    /**
    * Returns the last vanhatkirjat in the ordered set where teoknimi = &#63;.
    *
    * @param teoknimi the teoknimi
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByTitle_Last(
        java.lang.String teoknimi,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTitle_Last(teoknimi, orderByComparator);
    }

    /**
    * Returns the vanhatkirjats before and after the current vanhatkirjat in the ordered set where teoknimi = &#63;.
    *
    * @param vkid the primary key of the current vanhatkirjat
    * @param teoknimi the teoknimi
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat[] findByTitle_PrevAndNext(
        int vkid, java.lang.String teoknimi,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence()
                   .findByTitle_PrevAndNext(vkid, teoknimi, orderByComparator);
    }

    /**
    * Removes all the vanhatkirjats where teoknimi = &#63; from the database.
    *
    * @param teoknimi the teoknimi
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTitle(java.lang.String teoknimi)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTitle(teoknimi);
    }

    /**
    * Returns the number of vanhatkirjats where teoknimi = &#63;.
    *
    * @param teoknimi the teoknimi
    * @return the number of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static int countByTitle(java.lang.String teoknimi)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTitle(teoknimi);
    }

    /**
    * Returns all the vanhatkirjats where tekija = &#63;.
    *
    * @param tekija the tekija
    * @return the matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByAuthor(
        java.lang.String tekija)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAuthor(tekija);
    }

    /**
    * Returns a range of all the vanhatkirjats where tekija = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param tekija the tekija
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @return the range of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByAuthor(
        java.lang.String tekija, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAuthor(tekija, start, end);
    }

    /**
    * Returns an ordered range of all the vanhatkirjats where tekija = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param tekija the tekija
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByAuthor(
        java.lang.String tekija, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAuthor(tekija, start, end, orderByComparator);
    }

    /**
    * Returns the first vanhatkirjat in the ordered set where tekija = &#63;.
    *
    * @param tekija the tekija
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat findByAuthor_First(
        java.lang.String tekija,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence().findByAuthor_First(tekija, orderByComparator);
    }

    /**
    * Returns the first vanhatkirjat in the ordered set where tekija = &#63;.
    *
    * @param tekija the tekija
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByAuthor_First(
        java.lang.String tekija,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAuthor_First(tekija, orderByComparator);
    }

    /**
    * Returns the last vanhatkirjat in the ordered set where tekija = &#63;.
    *
    * @param tekija the tekija
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat findByAuthor_Last(
        java.lang.String tekija,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence().findByAuthor_Last(tekija, orderByComparator);
    }

    /**
    * Returns the last vanhatkirjat in the ordered set where tekija = &#63;.
    *
    * @param tekija the tekija
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByAuthor_Last(
        java.lang.String tekija,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAuthor_Last(tekija, orderByComparator);
    }

    /**
    * Returns the vanhatkirjats before and after the current vanhatkirjat in the ordered set where tekija = &#63;.
    *
    * @param vkid the primary key of the current vanhatkirjat
    * @param tekija the tekija
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat[] findByAuthor_PrevAndNext(
        int vkid, java.lang.String tekija,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence()
                   .findByAuthor_PrevAndNext(vkid, tekija, orderByComparator);
    }

    /**
    * Removes all the vanhatkirjats where tekija = &#63; from the database.
    *
    * @param tekija the tekija
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAuthor(java.lang.String tekija)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAuthor(tekija);
    }

    /**
    * Returns the number of vanhatkirjats where tekija = &#63;.
    *
    * @param tekija the tekija
    * @return the number of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static int countByAuthor(java.lang.String tekija)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAuthor(tekija);
    }

    /**
    * Caches the vanhatkirjat in the entity cache if it is enabled.
    *
    * @param vanhatkirjat the vanhatkirjat
    */
    public static void cacheResult(
        fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat) {
        getPersistence().cacheResult(vanhatkirjat);
    }

    /**
    * Caches the vanhatkirjats in the entity cache if it is enabled.
    *
    * @param vanhatkirjats the vanhatkirjats
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> vanhatkirjats) {
        getPersistence().cacheResult(vanhatkirjats);
    }

    /**
    * Creates a new vanhatkirjat with the primary key. Does not add the vanhatkirjat to the database.
    *
    * @param vkid the primary key for the new vanhatkirjat
    * @return the new vanhatkirjat
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat create(int vkid) {
        return getPersistence().create(vkid);
    }

    /**
    * Removes the vanhatkirjat with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param vkid the primary key of the vanhatkirjat
    * @return the vanhatkirjat that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat remove(int vkid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence().remove(vkid);
    }

    public static fi.csc.avaa.khl.db.model.Vanhatkirjat updateImpl(
        fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(vanhatkirjat);
    }

    /**
    * Returns the vanhatkirjat with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchVanhatkirjatException} if it could not be found.
    *
    * @param vkid the primary key of the vanhatkirjat
    * @return the vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat findByPrimaryKey(
        int vkid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException {
        return getPersistence().findByPrimaryKey(vkid);
    }

    /**
    * Returns the vanhatkirjat with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param vkid the primary key of the vanhatkirjat
    * @return the vanhatkirjat, or <code>null</code> if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByPrimaryKey(
        int vkid) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(vkid);
    }

    /**
    * Returns all the vanhatkirjats.
    *
    * @return the vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the vanhatkirjats.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @return the range of vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the vanhatkirjats.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of vanhatkirjats
    * @param end the upper bound of the range of vanhatkirjats (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the vanhatkirjats from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of vanhatkirjats.
    *
    * @return the number of vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static VanhatkirjatPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (VanhatkirjatPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    VanhatkirjatPersistence.class.getName());

            ReferenceRegistry.registerReference(VanhatkirjatUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(VanhatkirjatPersistence persistence) {
    }
}
