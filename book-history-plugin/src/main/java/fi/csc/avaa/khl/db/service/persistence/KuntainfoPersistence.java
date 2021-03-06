package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Kuntainfo;

/**
 * The persistence interface for the kuntainfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KuntainfoPersistenceImpl
 * @see KuntainfoUtil
 * @generated
 */
public interface KuntainfoPersistence extends BasePersistence<Kuntainfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link KuntainfoUtil} to access the kuntainfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the kuntainfo where capitalkuntanimi = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntainfoException} if it could not be found.
    *
    * @param capitalkuntanimi the capitalkuntanimi
    * @return the matching kuntainfo
    * @throws fi.csc.avaa.khl.db.NoSuchKuntainfoException if a matching kuntainfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntainfo findByCapitalkuntanimi(
        java.lang.String capitalkuntanimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntainfoException;

    /**
    * Returns the kuntainfo where capitalkuntanimi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param capitalkuntanimi the capitalkuntanimi
    * @return the matching kuntainfo, or <code>null</code> if a matching kuntainfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntainfo fetchByCapitalkuntanimi(
        java.lang.String capitalkuntanimi)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kuntainfo where capitalkuntanimi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param capitalkuntanimi the capitalkuntanimi
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kuntainfo, or <code>null</code> if a matching kuntainfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntainfo fetchByCapitalkuntanimi(
        java.lang.String capitalkuntanimi, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the kuntainfo where capitalkuntanimi = &#63; from the database.
    *
    * @param capitalkuntanimi the capitalkuntanimi
    * @return the kuntainfo that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntainfo removeByCapitalkuntanimi(
        java.lang.String capitalkuntanimi)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntainfoException;

    /**
    * Returns the number of kuntainfos where capitalkuntanimi = &#63;.
    *
    * @param capitalkuntanimi the capitalkuntanimi
    * @return the number of matching kuntainfos
    * @throws SystemException if a system exception occurred
    */
    public int countByCapitalkuntanimi(java.lang.String capitalkuntanimi)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the kuntainfo in the entity cache if it is enabled.
    *
    * @param kuntainfo the kuntainfo
    */
    public void cacheResult(fi.csc.avaa.khl.db.model.Kuntainfo kuntainfo);

    /**
    * Caches the kuntainfos in the entity cache if it is enabled.
    *
    * @param kuntainfos the kuntainfos
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kuntainfo> kuntainfos);

    /**
    * Creates a new kuntainfo with the primary key. Does not add the kuntainfo to the database.
    *
    * @param kuntaid the primary key for the new kuntainfo
    * @return the new kuntainfo
    */
    public fi.csc.avaa.khl.db.model.Kuntainfo create(int kuntaid);

    /**
    * Removes the kuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntaid the primary key of the kuntainfo
    * @return the kuntainfo that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKuntainfoException if a kuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntainfo remove(int kuntaid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntainfoException;

    public fi.csc.avaa.khl.db.model.Kuntainfo updateImpl(
        fi.csc.avaa.khl.db.model.Kuntainfo kuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kuntainfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntainfoException} if it could not be found.
    *
    * @param kuntaid the primary key of the kuntainfo
    * @return the kuntainfo
    * @throws fi.csc.avaa.khl.db.NoSuchKuntainfoException if a kuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntainfo findByPrimaryKey(int kuntaid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntainfoException;

    /**
    * Returns the kuntainfo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kuntaid the primary key of the kuntainfo
    * @return the kuntainfo, or <code>null</code> if a kuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntainfo fetchByPrimaryKey(int kuntaid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the kuntainfos.
    *
    * @return the kuntainfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kuntainfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the kuntainfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kuntainfos
    * @param end the upper bound of the range of kuntainfos (not inclusive)
    * @return the range of kuntainfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kuntainfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the kuntainfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kuntainfos
    * @param end the upper bound of the range of kuntainfos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of kuntainfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kuntainfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the kuntainfos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of kuntainfos.
    *
    * @return the number of kuntainfos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
