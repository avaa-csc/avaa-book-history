package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Puute;

/**
 * The persistence interface for the puute service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see PuutePersistenceImpl
 * @see PuuteUtil
 * @generated
 */
public interface PuutePersistence extends BasePersistence<Puute> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PuuteUtil} to access the puute persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the puute where puutenimi = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchPuuteException} if it could not be found.
    *
    * @param puutenimi the puutenimi
    * @return the matching puute
    * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a matching puute could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Puute findByPuutenimi(
        java.lang.String puutenimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException;

    /**
    * Returns the puute where puutenimi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param puutenimi the puutenimi
    * @return the matching puute, or <code>null</code> if a matching puute could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Puute fetchByPuutenimi(
        java.lang.String puutenimi)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the puute where puutenimi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param puutenimi the puutenimi
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching puute, or <code>null</code> if a matching puute could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Puute fetchByPuutenimi(
        java.lang.String puutenimi, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the puute where puutenimi = &#63; from the database.
    *
    * @param puutenimi the puutenimi
    * @return the puute that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Puute removeByPuutenimi(
        java.lang.String puutenimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException;

    /**
    * Returns the number of puutes where puutenimi = &#63;.
    *
    * @param puutenimi the puutenimi
    * @return the number of matching puutes
    * @throws SystemException if a system exception occurred
    */
    public int countByPuutenimi(java.lang.String puutenimi)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the puute in the entity cache if it is enabled.
    *
    * @param puute the puute
    */
    public void cacheResult(fi.csc.avaa.khl.db.model.Puute puute);

    /**
    * Caches the puutes in the entity cache if it is enabled.
    *
    * @param puutes the puutes
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Puute> puutes);

    /**
    * Creates a new puute with the primary key. Does not add the puute to the database.
    *
    * @param puuteid the primary key for the new puute
    * @return the new puute
    */
    public fi.csc.avaa.khl.db.model.Puute create(int puuteid);

    /**
    * Removes the puute with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param puuteid the primary key of the puute
    * @return the puute that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a puute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Puute remove(int puuteid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException;

    public fi.csc.avaa.khl.db.model.Puute updateImpl(
        fi.csc.avaa.khl.db.model.Puute puute)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the puute with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchPuuteException} if it could not be found.
    *
    * @param puuteid the primary key of the puute
    * @return the puute
    * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a puute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Puute findByPrimaryKey(int puuteid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchPuuteException;

    /**
    * Returns the puute with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param puuteid the primary key of the puute
    * @return the puute, or <code>null</code> if a puute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Puute fetchByPrimaryKey(int puuteid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the puutes.
    *
    * @return the puutes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Puute> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the puutes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.PuuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of puutes
    * @param end the upper bound of the range of puutes (not inclusive)
    * @return the range of puutes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Puute> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the puutes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.PuuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of puutes
    * @param end the upper bound of the range of puutes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of puutes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Puute> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the puutes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of puutes.
    *
    * @return the number of puutes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
