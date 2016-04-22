package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Kieliinfo;

/**
 * The persistence interface for the kieliinfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KieliinfoPersistenceImpl
 * @see KieliinfoUtil
 * @generated
 */
public interface KieliinfoPersistence extends BasePersistence<Kieliinfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link KieliinfoUtil} to access the kieliinfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the kieliinfo where kieli = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKieliinfoException} if it could not be found.
    *
    * @param kieli the kieli
    * @return the matching kieliinfo
    * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a matching kieliinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kieliinfo findByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException;

    /**
    * Returns the kieliinfo where kieli = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param kieli the kieli
    * @return the matching kieliinfo, or <code>null</code> if a matching kieliinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kieliinfo fetchByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kieliinfo where kieli = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param kieli the kieli
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kieliinfo, or <code>null</code> if a matching kieliinfo could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kieliinfo fetchByKieli(
        java.lang.String kieli, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the kieliinfo where kieli = &#63; from the database.
    *
    * @param kieli the kieli
    * @return the kieliinfo that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kieliinfo removeByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException;

    /**
    * Returns the number of kieliinfos where kieli = &#63;.
    *
    * @param kieli the kieli
    * @return the number of matching kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public int countByKieli(java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the kieliinfo in the entity cache if it is enabled.
    *
    * @param kieliinfo the kieliinfo
    */
    public void cacheResult(fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo);

    /**
    * Caches the kieliinfos in the entity cache if it is enabled.
    *
    * @param kieliinfos the kieliinfos
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> kieliinfos);

    /**
    * Creates a new kieliinfo with the primary key. Does not add the kieliinfo to the database.
    *
    * @param kieliid the primary key for the new kieliinfo
    * @return the new kieliinfo
    */
    public fi.csc.avaa.khl.db.model.Kieliinfo create(int kieliid);

    /**
    * Removes the kieliinfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kieliid the primary key of the kieliinfo
    * @return the kieliinfo that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a kieliinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kieliinfo remove(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException;

    public fi.csc.avaa.khl.db.model.Kieliinfo updateImpl(
        fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kieliinfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKieliinfoException} if it could not be found.
    *
    * @param kieliid the primary key of the kieliinfo
    * @return the kieliinfo
    * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a kieliinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kieliinfo findByPrimaryKey(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKieliinfoException;

    /**
    * Returns the kieliinfo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kieliid the primary key of the kieliinfo
    * @return the kieliinfo, or <code>null</code> if a kieliinfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kieliinfo fetchByPrimaryKey(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the kieliinfos.
    *
    * @return the kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the kieliinfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KieliinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kieliinfos
    * @param end the upper bound of the range of kieliinfos (not inclusive)
    * @return the range of kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the kieliinfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KieliinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kieliinfos
    * @param end the upper bound of the range of kieliinfos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kieliinfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the kieliinfos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of kieliinfos.
    *
    * @return the number of kieliinfos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
