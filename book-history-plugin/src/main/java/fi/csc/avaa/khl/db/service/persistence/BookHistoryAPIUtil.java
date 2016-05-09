package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.csc.avaa.khl.db.model.BookHistoryAPI;

import java.util.List;

/**
 * The persistence utility for the book history a p i service. This utility wraps {@link BookHistoryAPIPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see BookHistoryAPIPersistence
 * @see BookHistoryAPIPersistenceImpl
 * @generated
 */
public class BookHistoryAPIUtil {
    private static BookHistoryAPIPersistence _persistence;

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
    public static void clearCache(BookHistoryAPI bookHistoryAPI) {
        getPersistence().clearCache(bookHistoryAPI);
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
    public static List<BookHistoryAPI> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<BookHistoryAPI> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<BookHistoryAPI> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static BookHistoryAPI update(BookHistoryAPI bookHistoryAPI)
        throws SystemException {
        return getPersistence().update(bookHistoryAPI);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static BookHistoryAPI update(BookHistoryAPI bookHistoryAPI,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(bookHistoryAPI, serviceContext);
    }

    /**
    * Caches the book history a p i in the entity cache if it is enabled.
    *
    * @param bookHistoryAPI the book history a p i
    */
    public static void cacheResult(
        fi.csc.avaa.khl.db.model.BookHistoryAPI bookHistoryAPI) {
        getPersistence().cacheResult(bookHistoryAPI);
    }

    /**
    * Caches the book history a p is in the entity cache if it is enabled.
    *
    * @param bookHistoryAPIs the book history a p is
    */
    public static void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.BookHistoryAPI> bookHistoryAPIs) {
        getPersistence().cacheResult(bookHistoryAPIs);
    }

    /**
    * Creates a new book history a p i with the primary key. Does not add the book history a p i to the database.
    *
    * @param name the primary key for the new book history a p i
    * @return the new book history a p i
    */
    public static fi.csc.avaa.khl.db.model.BookHistoryAPI create(
        java.lang.String name) {
        return getPersistence().create(name);
    }

    /**
    * Removes the book history a p i with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param name the primary key of the book history a p i
    * @return the book history a p i that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException if a book history a p i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.BookHistoryAPI remove(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException {
        return getPersistence().remove(name);
    }

    public static fi.csc.avaa.khl.db.model.BookHistoryAPI updateImpl(
        fi.csc.avaa.khl.db.model.BookHistoryAPI bookHistoryAPI)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(bookHistoryAPI);
    }

    /**
    * Returns the book history a p i with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException} if it could not be found.
    *
    * @param name the primary key of the book history a p i
    * @return the book history a p i
    * @throws fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException if a book history a p i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.BookHistoryAPI findByPrimaryKey(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException {
        return getPersistence().findByPrimaryKey(name);
    }

    /**
    * Returns the book history a p i with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param name the primary key of the book history a p i
    * @return the book history a p i, or <code>null</code> if a book history a p i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.csc.avaa.khl.db.model.BookHistoryAPI fetchByPrimaryKey(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(name);
    }

    /**
    * Returns all the book history a p is.
    *
    * @return the book history a p is
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.BookHistoryAPI> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the book history a p is.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.BookHistoryAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of book history a p is
    * @param end the upper bound of the range of book history a p is (not inclusive)
    * @return the range of book history a p is
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.BookHistoryAPI> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the book history a p is.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.BookHistoryAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of book history a p is
    * @param end the upper bound of the range of book history a p is (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of book history a p is
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.csc.avaa.khl.db.model.BookHistoryAPI> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the book history a p is from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of book history a p is.
    *
    * @return the number of book history a p is
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BookHistoryAPIPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BookHistoryAPIPersistence) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    BookHistoryAPIPersistence.class.getName());

            ReferenceRegistry.registerReference(BookHistoryAPIUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(BookHistoryAPIPersistence persistence) {
    }
}
