package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.csc.avaa.khl.db.model.Maakuntainfo;

/**
 * The persistence interface for the maakuntainfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see MaakuntainfoPersistenceImpl
 * @see MaakuntainfoUtil
 * @generated
 */
public interface MaakuntainfoPersistence extends BasePersistence<Maakuntainfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MaakuntainfoUtil} to access the maakuntainfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the maakuntainfo in the entity cache if it is enabled.
    *
    * @param maakuntainfo the maakuntainfo
    */
    public void cacheResult(fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo);

    /**
    * Caches the maakuntainfos in the entity cache if it is enabled.
    *
    * @param maakuntainfos the maakuntainfos
    */
    public void cacheResult(
        java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> maakuntainfos);

    /**
    * Creates a new maakuntainfo with the primary key. Does not add the maakuntainfo to the database.
    *
    * @param maakuntaid the primary key for the new maakuntainfo
    * @return the new maakuntainfo
    */
    public fi.csc.avaa.khl.db.model.Maakuntainfo create(int maakuntaid);

    /**
    * Removes the maakuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param maakuntaid the primary key of the maakuntainfo
    * @return the maakuntainfo that was removed
    * @throws fi.csc.avaa.khl.db.NoSuchMaakuntainfoException if a maakuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Maakuntainfo remove(int maakuntaid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchMaakuntainfoException;

    public fi.csc.avaa.khl.db.model.Maakuntainfo updateImpl(
        fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the maakuntainfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchMaakuntainfoException} if it could not be found.
    *
    * @param maakuntaid the primary key of the maakuntainfo
    * @return the maakuntainfo
    * @throws fi.csc.avaa.khl.db.NoSuchMaakuntainfoException if a maakuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Maakuntainfo findByPrimaryKey(
        int maakuntaid)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.csc.avaa.khl.db.NoSuchMaakuntainfoException;

    /**
    * Returns the maakuntainfo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param maakuntaid the primary key of the maakuntainfo
    * @return the maakuntainfo, or <code>null</code> if a maakuntainfo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.csc.avaa.khl.db.model.Maakuntainfo fetchByPrimaryKey(
        int maakuntaid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the maakuntainfos.
    *
    * @return the maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the maakuntainfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of maakuntainfos
    * @param end the upper bound of the range of maakuntainfos (not inclusive)
    * @return the range of maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the maakuntainfos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of maakuntainfos
    * @param end the upper bound of the range of maakuntainfos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.csc.avaa.khl.db.model.Maakuntainfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the maakuntainfos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of maakuntainfos.
    *
    * @return the number of maakuntainfos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
