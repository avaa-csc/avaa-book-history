package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Teospk;

/**
 * The persistence interface for the teospk service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see TeospkPersistenceImpl
 * @see TeospkUtil
 * @generated
 */
public interface TeospkPersistence extends BasePersistence<Teospk> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TeospkUtil} to access the teospk persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the teospk where teospknimi = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchTeospkException} if it could not be found.
    *
    * @param teospknimi the teospknimi
    * @return the matching teospk
    * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a matching teospk could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Teospk findByTeospknimi(
        java.lang.String teospknimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException;

    /**
    * Returns the teospk where teospknimi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param teospknimi the teospknimi
    * @return the matching teospk, or <code>null</code> if a matching teospk could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Teospk fetchByTeospknimi(
        java.lang.String teospknimi)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the teospk where teospknimi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param teospknimi the teospknimi
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching teospk, or <code>null</code> if a matching teospk could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Teospk fetchByTeospknimi(
        java.lang.String teospknimi, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the teospk where teospknimi = &#63; from the database.
    *
    * @param teospknimi the teospknimi
    * @return the teospk that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Teospk removeByTeospknimi(
        java.lang.String teospknimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException;

    /**
    * Returns the number of teospks where teospknimi = &#63;.
    *
    * @param teospknimi the teospknimi
    * @return the number of matching teospks
    * @throws SystemException if a system exception occurred
    */
    public int countByTeospknimi(java.lang.String teospknimi)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the teospk in the entity cache if it is enabled.
    *
    * @param teospk the teospk
    */
    public void cacheResult(fi.csc.avaa.khl.db.model.Teospk teospk);

    /**
    * Caches the teospks in the entity cache if it is enabled.
    *
    * @param teospks the teospks
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Teospk> teospks);

    /**
    * Creates a new teospk with the primary key. Does not add the teospk to the database.
    *
    * @param teospkid the primary key for the new teospk
    * @return the new teospk
    */
    public fi.csc.avaa.khl.db.model.Teospk create(int teospkid);

    /**
    * Removes the teospk with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param teospkid the primary key of the teospk
    * @return the teospk that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a teospk with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Teospk remove(int teospkid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException;

    public fi.csc.avaa.khl.db.model.Teospk updateImpl(
        fi.csc.avaa.khl.db.model.Teospk teospk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the teospk with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchTeospkException} if it could not be found.
    *
    * @param teospkid the primary key of the teospk
    * @return the teospk
    * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a teospk with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Teospk findByPrimaryKey(int teospkid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchTeospkException;

    /**
    * Returns the teospk with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param teospkid the primary key of the teospk
    * @return the teospk, or <code>null</code> if a teospk with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Teospk fetchByPrimaryKey(int teospkid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the teospks.
    *
    * @return the teospks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Teospk> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.Teospk> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.Teospk> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the teospks from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of teospks.
    *
    * @return the number of teospks
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
