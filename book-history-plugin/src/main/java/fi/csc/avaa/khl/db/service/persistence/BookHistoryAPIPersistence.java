package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.BookHistoryAPI;

/**
 * The persistence interface for the book history a p i service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see BookHistoryAPIPersistenceImpl
 * @see BookHistoryAPIUtil
 * @generated
 */
public interface BookHistoryAPIPersistence extends BasePersistence<BookHistoryAPI> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BookHistoryAPIUtil} to access the book history a p i persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the book history a p i in the entity cache if it is enabled.
    *
    * @param bookHistoryAPI the book history a p i
    */
    public void cacheResult(
        fi.csc.avaa.khl.db.model.BookHistoryAPI bookHistoryAPI);

    /**
    * Caches the book history a p is in the entity cache if it is enabled.
    *
    * @param bookHistoryAPIs the book history a p is
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.BookHistoryAPI> bookHistoryAPIs);

    /**
    * Creates a new book history a p i with the primary key. Does not add the book history a p i to the database.
    *
    * @param name the primary key for the new book history a p i
    * @return the new book history a p i
    */
    public fi.csc.avaa.khl.db.model.BookHistoryAPI create(java.lang.String name);

    /**
    * Removes the book history a p i with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param name the primary key of the book history a p i
    * @return the book history a p i that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException if a book history a p i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.BookHistoryAPI remove(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException;

    public fi.csc.avaa.khl.db.model.BookHistoryAPI updateImpl(
        fi.csc.avaa.khl.db.model.BookHistoryAPI bookHistoryAPI)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the book history a p i with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException} if it could not be found.
    *
    * @param name the primary key of the book history a p i
    * @return the book history a p i
    * @throws fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException if a book history a p i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.BookHistoryAPI findByPrimaryKey(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException;

    /**
    * Returns the book history a p i with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param name the primary key of the book history a p i
    * @return the book history a p i, or <code>null</code> if a book history a p i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.BookHistoryAPI fetchByPrimaryKey(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the book history a p is.
    *
    * @return the book history a p is
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.BookHistoryAPI> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.BookHistoryAPI> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.BookHistoryAPI> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the book history a p is from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of book history a p is.
    *
    * @return the number of book history a p is
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
