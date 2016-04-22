package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Kartoituskohde;

/**
 * The persistence interface for the kartoituskohde service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KartoituskohdePersistenceImpl
 * @see KartoituskohdeUtil
 * @generated
 */
public interface KartoituskohdePersistence extends BasePersistence<Kartoituskohde> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link KartoituskohdeUtil} to access the kartoituskohde persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the kartoituskohde where kartkohde = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKartoituskohdeException} if it could not be found.
    *
    * @param kartkohde the kartkohde
    * @return the matching kartoituskohde
    * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a matching kartoituskohde could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kartoituskohde findByKartkohde(
        java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException;

    /**
    * Returns the kartoituskohde where kartkohde = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param kartkohde the kartkohde
    * @return the matching kartoituskohde, or <code>null</code> if a matching kartoituskohde could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kartoituskohde fetchByKartkohde(
        java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kartoituskohde where kartkohde = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param kartkohde the kartkohde
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kartoituskohde, or <code>null</code> if a matching kartoituskohde could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kartoituskohde fetchByKartkohde(
        java.lang.String kartkohde, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the kartoituskohde where kartkohde = &#63; from the database.
    *
    * @param kartkohde the kartkohde
    * @return the kartoituskohde that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kartoituskohde removeByKartkohde(
        java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException;

    /**
    * Returns the number of kartoituskohdes where kartkohde = &#63;.
    *
    * @param kartkohde the kartkohde
    * @return the number of matching kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    public int countByKartkohde(java.lang.String kartkohde)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the kartoituskohde in the entity cache if it is enabled.
    *
    * @param kartoituskohde the kartoituskohde
    */
    public void cacheResult(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde);

    /**
    * Caches the kartoituskohdes in the entity cache if it is enabled.
    *
    * @param kartoituskohdes the kartoituskohdes
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> kartoituskohdes);

    /**
    * Creates a new kartoituskohde with the primary key. Does not add the kartoituskohde to the database.
    *
    * @param kohdeid the primary key for the new kartoituskohde
    * @return the new kartoituskohde
    */
    public fi.csc.avaa.khl.db.model.Kartoituskohde create(int kohdeid);

    /**
    * Removes the kartoituskohde with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kartoituskohde remove(int kohdeid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException;

    public fi.csc.avaa.khl.db.model.Kartoituskohde updateImpl(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kartoituskohde with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKartoituskohdeException} if it could not be found.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde
    * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kartoituskohde findByPrimaryKey(int kohdeid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKartoituskohdeException;

    /**
    * Returns the kartoituskohde with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kohdeid the primary key of the kartoituskohde
    * @return the kartoituskohde, or <code>null</code> if a kartoituskohde with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kartoituskohde fetchByPrimaryKey(
        int kohdeid) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the kartoituskohdes.
    *
    * @return the kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.Kartoituskohde> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the kartoituskohdes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of kartoituskohdes.
    *
    * @return the number of kartoituskohdes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
