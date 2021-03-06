package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Kuntoluokitus;

/**
 * The persistence interface for the kuntoluokitus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KuntoluokitusPersistenceImpl
 * @see KuntoluokitusUtil
 * @generated
 */
public interface KuntoluokitusPersistence extends BasePersistence<Kuntoluokitus> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link KuntoluokitusUtil} to access the kuntoluokitus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the kuntoluokitus where kunto = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntoluokitusException} if it could not be found.
    *
    * @param kunto the kunto
    * @return the matching kuntoluokitus
    * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a matching kuntoluokitus could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntoluokitus findByKunto(
        java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException;

    /**
    * Returns the kuntoluokitus where kunto = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param kunto the kunto
    * @return the matching kuntoluokitus, or <code>null</code> if a matching kuntoluokitus could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntoluokitus fetchByKunto(
        java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kuntoluokitus where kunto = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param kunto the kunto
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching kuntoluokitus, or <code>null</code> if a matching kuntoluokitus could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntoluokitus fetchByKunto(
        java.lang.String kunto, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the kuntoluokitus where kunto = &#63; from the database.
    *
    * @param kunto the kunto
    * @return the kuntoluokitus that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntoluokitus removeByKunto(
        java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException;

    /**
    * Returns the number of kuntoluokituses where kunto = &#63;.
    *
    * @param kunto the kunto
    * @return the number of matching kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public int countByKunto(java.lang.String kunto)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the kuntoluokitus in the entity cache if it is enabled.
    *
    * @param kuntoluokitus the kuntoluokitus
    */
    public void cacheResult(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus);

    /**
    * Caches the kuntoluokituses in the entity cache if it is enabled.
    *
    * @param kuntoluokituses the kuntoluokituses
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> kuntoluokituses);

    /**
    * Creates a new kuntoluokitus with the primary key. Does not add the kuntoluokitus to the database.
    *
    * @param kuntoid the primary key for the new kuntoluokitus
    * @return the new kuntoluokitus
    */
    public fi.csc.avaa.khl.db.model.Kuntoluokitus create(int kuntoid);

    /**
    * Removes the kuntoluokitus with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntoluokitus remove(int kuntoid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException;

    public fi.csc.avaa.khl.db.model.Kuntoluokitus updateImpl(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the kuntoluokitus with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntoluokitusException} if it could not be found.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus
    * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntoluokitus findByPrimaryKey(int kuntoid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchKuntoluokitusException;

    /**
    * Returns the kuntoluokitus with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param kuntoid the primary key of the kuntoluokitus
    * @return the kuntoluokitus, or <code>null</code> if a kuntoluokitus with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Kuntoluokitus fetchByPrimaryKey(int kuntoid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the kuntoluokituses.
    *
    * @return the kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the kuntoluokituses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kuntoluokituses
    * @param end the upper bound of the range of kuntoluokituses (not inclusive)
    * @return the range of kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the kuntoluokituses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of kuntoluokituses
    * @param end the upper bound of the range of kuntoluokituses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Kuntoluokitus> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the kuntoluokituses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of kuntoluokituses.
    *
    * @return the number of kuntoluokituses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
