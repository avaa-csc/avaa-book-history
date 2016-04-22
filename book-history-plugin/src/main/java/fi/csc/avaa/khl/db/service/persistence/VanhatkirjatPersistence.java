package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Vanhatkirjat;

/**
 * The persistence interface for the vanhatkirjat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see VanhatkirjatPersistenceImpl
 * @see VanhatkirjatUtil
 * @generated
 */
public interface VanhatkirjatPersistence extends BasePersistence<Vanhatkirjat> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link VanhatkirjatUtil} to access the vanhatkirjat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the vanhatkirjats where status = &#63;.
    *
    * @param status the status
    * @return the matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByPublishStatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByPublishStatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findByPublishStatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Vanhatkirjat findByPublishStatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException;

    /**
    * Returns the first vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByPublishStatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Vanhatkirjat findByPublishStatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException;

    /**
    * Returns the last vanhatkirjat in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByPublishStatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fi.csc.avaa.khl.db.model.Vanhatkirjat[] findByPublishStatus_PrevAndNext(
        int vkid, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException;

    /**
    * Removes all the vanhatkirjats where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByPublishStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of vanhatkirjats where status = &#63;.
    *
    * @param status the status
    * @return the number of matching vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public int countByPublishStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the vanhatkirjat in the entity cache if it is enabled.
    *
    * @param vanhatkirjat the vanhatkirjat
    */
    public void cacheResult(fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat);

    /**
    * Caches the vanhatkirjats in the entity cache if it is enabled.
    *
    * @param vanhatkirjats the vanhatkirjats
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> vanhatkirjats);

    /**
    * Creates a new vanhatkirjat with the primary key. Does not add the vanhatkirjat to the database.
    *
    * @param vkid the primary key for the new vanhatkirjat
    * @return the new vanhatkirjat
    */
    public fi.csc.avaa.khl.db.model.Vanhatkirjat create(int vkid);

    /**
    * Removes the vanhatkirjat with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param vkid the primary key of the vanhatkirjat
    * @return the vanhatkirjat that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Vanhatkirjat remove(int vkid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException;

    public fi.csc.avaa.khl.db.model.Vanhatkirjat updateImpl(
        fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the vanhatkirjat with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchVanhatkirjatException} if it could not be found.
    *
    * @param vkid the primary key of the vanhatkirjat
    * @return the vanhatkirjat
    * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Vanhatkirjat findByPrimaryKey(int vkid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchVanhatkirjatException;

    /**
    * Returns the vanhatkirjat with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param vkid the primary key of the vanhatkirjat
    * @return the vanhatkirjat, or <code>null</code> if a vanhatkirjat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Vanhatkirjat fetchByPrimaryKey(int vkid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the vanhatkirjats.
    *
    * @return the vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the vanhatkirjats from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of vanhatkirjats.
    *
    * @return the number of vanhatkirjats
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
