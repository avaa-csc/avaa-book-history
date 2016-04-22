package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Kielesta;

/**
 * The persistence interface for the kielesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KielestaPersistenceImpl
 * @see KielestaUtil
 * @generated
 */
public interface KielestaPersistence extends BasePersistence<Kielesta> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link KielestaUtil} to access the kielesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the kielesta where kieli = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKielestaException} if it could not be found.
    *
    * @param kieli the kieli
    * @return the matching kielesta
    * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a matching kielesta could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kielesta findByKieli(java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException;

    /**
    * Returns the kielesta where kieli = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param kieli the kieli
    * @return the matching kielesta, or <code>null</code> if a matching kielesta could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kielesta fetchByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kielesta where kieli = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param kieli the kieli
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kielesta, or <code>null</code> if a matching kielesta could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kielesta fetchByKieli(
        java.lang.String kieli, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the kielesta where kieli = &#63; from the database.
    *
    * @param kieli the kieli
    * @return the kielesta that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kielesta removeByKieli(
        java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException;

    /**
    * Returns the number of kielestas where kieli = &#63;.
    *
    * @param kieli the kieli
    * @return the number of matching kielestas
    * @throws SystemException if a system exception occurred
    */
    public int countByKieli(java.lang.String kieli)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the kielesta in the entity cache if it is enabled.
    *
    * @param kielesta the kielesta
    */
    public void cacheResult(fi.csc.avaa.khl.db.model.Kielesta kielesta);

    /**
    * Caches the kielestas in the entity cache if it is enabled.
    *
    * @param kielestas the kielestas
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kielesta> kielestas);

    /**
    * Creates a new kielesta with the primary key. Does not add the kielesta to the database.
    *
    * @param kieliid the primary key for the new kielesta
    * @return the new kielesta
    */
    public fi.csc.avaa.khl.db.model.Kielesta create(int kieliid);

    /**
    * Removes the kielesta with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kieliid the primary key of the kielesta
    * @return the kielesta that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a kielesta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kielesta remove(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException;

    public fi.csc.avaa.khl.db.model.Kielesta updateImpl(
        fi.csc.avaa.khl.db.model.Kielesta kielesta)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kielesta with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKielestaException} if it could not be found.
    *
    * @param kieliid the primary key of the kielesta
    * @return the kielesta
    * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a kielesta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kielesta findByPrimaryKey(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKielestaException;

    /**
    * Returns the kielesta with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kieliid the primary key of the kielesta
    * @return the kielesta, or <code>null</code> if a kielesta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kielesta fetchByPrimaryKey(int kieliid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the kielestas.
    *
    * @return the kielestas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kielesta> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the kielestas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KielestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kielestas
    * @param end the upper bound of the range of kielestas (not inclusive)
    * @return the range of kielestas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kielesta> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the kielestas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KielestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kielestas
    * @param end the upper bound of the range of kielestas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of kielestas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kielesta> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the kielestas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of kielestas.
    *
    * @return the number of kielestas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
