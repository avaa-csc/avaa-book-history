package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import fi.csc.avaa.khl.db.NoSuchSidottuException;
import fi.csc.avaa.khl.db.model.Sidottu;
import fi.csc.avaa.khl.db.model.impl.SidottuImpl;
import fi.csc.avaa.khl.db.model.impl.SidottuModelImpl;
import fi.csc.avaa.khl.db.service.persistence.SidottuPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sidottu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see SidottuPersistence
 * @see SidottuUtil
 * @generated
 */
public class SidottuPersistenceImpl extends BasePersistenceImpl<Sidottu>
    implements SidottuPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SidottuUtil} to access the sidottu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SidottuImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SidottuModelImpl.ENTITY_CACHE_ENABLED,
            SidottuModelImpl.FINDER_CACHE_ENABLED, SidottuImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SidottuModelImpl.ENTITY_CACHE_ENABLED,
            SidottuModelImpl.FINDER_CACHE_ENABLED, SidottuImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SidottuModelImpl.ENTITY_CACHE_ENABLED,
            SidottuModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_SIDONTA = new FinderPath(SidottuModelImpl.ENTITY_CACHE_ENABLED,
            SidottuModelImpl.FINDER_CACHE_ENABLED, SidottuImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchBySidonta",
            new String[] { String.class.getName() },
            SidottuModelImpl.SIDONTA_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SIDONTA = new FinderPath(SidottuModelImpl.ENTITY_CACHE_ENABLED,
            SidottuModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySidonta",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_SIDONTA_SIDONTA_1 = "sidottu.sidonta IS NULL";
    private static final String _FINDER_COLUMN_SIDONTA_SIDONTA_2 = "sidottu.sidonta = ?";
    private static final String _FINDER_COLUMN_SIDONTA_SIDONTA_3 = "(sidottu.sidonta IS NULL OR sidottu.sidonta = '')";
    private static final String _SQL_SELECT_SIDOTTU = "SELECT sidottu FROM Sidottu sidottu";
    private static final String _SQL_SELECT_SIDOTTU_WHERE = "SELECT sidottu FROM Sidottu sidottu WHERE ";
    private static final String _SQL_COUNT_SIDOTTU = "SELECT COUNT(sidottu) FROM Sidottu sidottu";
    private static final String _SQL_COUNT_SIDOTTU_WHERE = "SELECT COUNT(sidottu) FROM Sidottu sidottu WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sidottu.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sidottu exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Sidottu exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SidottuPersistenceImpl.class);
    private static Sidottu _nullSidottu = new SidottuImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Sidottu> toCacheModel() {
                return _nullSidottuCacheModel;
            }
        };

    private static CacheModel<Sidottu> _nullSidottuCacheModel = new CacheModel<Sidottu>() {
            @Override
            public Sidottu toEntityModel() {
                return _nullSidottu;
            }
        };

    public SidottuPersistenceImpl() {
        setModelClass(Sidottu.class);
    }

    /**
     * Returns the sidottu where sidonta = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchSidottuException} if it could not be found.
     *
     * @param sidonta the sidonta
     * @return the matching sidottu
     * @throws fi.csc.avaa.khl.db.NoSuchSidottuException if a matching sidottu could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu findBySidonta(String sidonta)
        throws NoSuchSidottuException, SystemException {
        Sidottu sidottu = fetchBySidonta(sidonta);

        if (sidottu == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sidonta=");
            msg.append(sidonta);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchSidottuException(msg.toString());
        }

        return sidottu;
    }

    /**
     * Returns the sidottu where sidonta = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param sidonta the sidonta
     * @return the matching sidottu, or <code>null</code> if a matching sidottu could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu fetchBySidonta(String sidonta) throws SystemException {
        return fetchBySidonta(sidonta, true);
    }

    /**
     * Returns the sidottu where sidonta = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param sidonta the sidonta
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching sidottu, or <code>null</code> if a matching sidottu could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu fetchBySidonta(String sidonta, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { sidonta };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SIDONTA,
                    finderArgs, this);
        }

        if (result instanceof Sidottu) {
            Sidottu sidottu = (Sidottu) result;

            if (!Validator.equals(sidonta, sidottu.getSidonta())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SIDOTTU_WHERE);

            boolean bindSidonta = false;

            if (sidonta == null) {
                query.append(_FINDER_COLUMN_SIDONTA_SIDONTA_1);
            } else if (sidonta.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SIDONTA_SIDONTA_3);
            } else {
                bindSidonta = true;

                query.append(_FINDER_COLUMN_SIDONTA_SIDONTA_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindSidonta) {
                    qPos.add(sidonta);
                }

                List<Sidottu> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIDONTA,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "SidottuPersistenceImpl.fetchBySidonta(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Sidottu sidottu = list.get(0);

                    result = sidottu;

                    cacheResult(sidottu);

                    if ((sidottu.getSidonta() == null) ||
                            !sidottu.getSidonta().equals(sidonta)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIDONTA,
                            finderArgs, sidottu);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SIDONTA,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Sidottu) result;
        }
    }

    /**
     * Removes the sidottu where sidonta = &#63; from the database.
     *
     * @param sidonta the sidonta
     * @return the sidottu that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu removeBySidonta(String sidonta)
        throws NoSuchSidottuException, SystemException {
        Sidottu sidottu = findBySidonta(sidonta);

        return remove(sidottu);
    }

    /**
     * Returns the number of sidottus where sidonta = &#63;.
     *
     * @param sidonta the sidonta
     * @return the number of matching sidottus
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySidonta(String sidonta) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SIDONTA;

        Object[] finderArgs = new Object[] { sidonta };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SIDOTTU_WHERE);

            boolean bindSidonta = false;

            if (sidonta == null) {
                query.append(_FINDER_COLUMN_SIDONTA_SIDONTA_1);
            } else if (sidonta.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SIDONTA_SIDONTA_3);
            } else {
                bindSidonta = true;

                query.append(_FINDER_COLUMN_SIDONTA_SIDONTA_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindSidonta) {
                    qPos.add(sidonta);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the sidottu in the entity cache if it is enabled.
     *
     * @param sidottu the sidottu
     */
    @Override
    public void cacheResult(Sidottu sidottu) {
        EntityCacheUtil.putResult(SidottuModelImpl.ENTITY_CACHE_ENABLED,
            SidottuImpl.class, sidottu.getPrimaryKey(), sidottu);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIDONTA,
            new Object[] { sidottu.getSidonta() }, sidottu);

        sidottu.resetOriginalValues();
    }

    /**
     * Caches the sidottus in the entity cache if it is enabled.
     *
     * @param sidottus the sidottus
     */
    @Override
    public void cacheResult(List<Sidottu> sidottus) {
        for (Sidottu sidottu : sidottus) {
            if (EntityCacheUtil.getResult(
                        SidottuModelImpl.ENTITY_CACHE_ENABLED,
                        SidottuImpl.class, sidottu.getPrimaryKey()) == null) {
                cacheResult(sidottu);
            } else {
                sidottu.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all sidottus.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SidottuImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SidottuImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the sidottu.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Sidottu sidottu) {
        EntityCacheUtil.removeResult(SidottuModelImpl.ENTITY_CACHE_ENABLED,
            SidottuImpl.class, sidottu.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(sidottu);
    }

    @Override
    public void clearCache(List<Sidottu> sidottus) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Sidottu sidottu : sidottus) {
            EntityCacheUtil.removeResult(SidottuModelImpl.ENTITY_CACHE_ENABLED,
                SidottuImpl.class, sidottu.getPrimaryKey());

            clearUniqueFindersCache(sidottu);
        }
    }

    protected void cacheUniqueFindersCache(Sidottu sidottu) {
        if (sidottu.isNew()) {
            Object[] args = new Object[] { sidottu.getSidonta() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SIDONTA, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIDONTA, args,
                sidottu);
        } else {
            SidottuModelImpl sidottuModelImpl = (SidottuModelImpl) sidottu;

            if ((sidottuModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_SIDONTA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { sidottu.getSidonta() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SIDONTA, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIDONTA, args,
                    sidottu);
            }
        }
    }

    protected void clearUniqueFindersCache(Sidottu sidottu) {
        SidottuModelImpl sidottuModelImpl = (SidottuModelImpl) sidottu;

        Object[] args = new Object[] { sidottu.getSidonta() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SIDONTA, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SIDONTA, args);

        if ((sidottuModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_SIDONTA.getColumnBitmask()) != 0) {
            args = new Object[] { sidottuModelImpl.getOriginalSidonta() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SIDONTA, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SIDONTA, args);
        }
    }

    /**
     * Creates a new sidottu with the primary key. Does not add the sidottu to the database.
     *
     * @param sidontaid the primary key for the new sidottu
     * @return the new sidottu
     */
    @Override
    public Sidottu create(int sidontaid) {
        Sidottu sidottu = new SidottuImpl();

        sidottu.setNew(true);
        sidottu.setPrimaryKey(sidontaid);

        return sidottu;
    }

    /**
     * Removes the sidottu with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param sidontaid the primary key of the sidottu
     * @return the sidottu that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchSidottuException if a sidottu with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu remove(int sidontaid)
        throws NoSuchSidottuException, SystemException {
        return remove((Serializable) sidontaid);
    }

    /**
     * Removes the sidottu with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the sidottu
     * @return the sidottu that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchSidottuException if a sidottu with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu remove(Serializable primaryKey)
        throws NoSuchSidottuException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Sidottu sidottu = (Sidottu) session.get(SidottuImpl.class,
                    primaryKey);

            if (sidottu == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSidottuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sidottu);
        } catch (NoSuchSidottuException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Sidottu removeImpl(Sidottu sidottu) throws SystemException {
        sidottu = toUnwrappedModel(sidottu);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(sidottu)) {
                sidottu = (Sidottu) session.get(SidottuImpl.class,
                        sidottu.getPrimaryKeyObj());
            }

            if (sidottu != null) {
                session.delete(sidottu);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (sidottu != null) {
            clearCache(sidottu);
        }

        return sidottu;
    }

    @Override
    public Sidottu updateImpl(fi.csc.avaa.khl.db.model.Sidottu sidottu)
        throws SystemException {
        sidottu = toUnwrappedModel(sidottu);

        boolean isNew = sidottu.isNew();

        Session session = null;

        try {
            session = openSession();

            if (sidottu.isNew()) {
                session.save(sidottu);

                sidottu.setNew(false);
            } else {
                session.merge(sidottu);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !SidottuModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(SidottuModelImpl.ENTITY_CACHE_ENABLED,
            SidottuImpl.class, sidottu.getPrimaryKey(), sidottu);

        clearUniqueFindersCache(sidottu);
        cacheUniqueFindersCache(sidottu);

        return sidottu;
    }

    protected Sidottu toUnwrappedModel(Sidottu sidottu) {
        if (sidottu instanceof SidottuImpl) {
            return sidottu;
        }

        SidottuImpl sidottuImpl = new SidottuImpl();

        sidottuImpl.setNew(sidottu.isNew());
        sidottuImpl.setPrimaryKey(sidottu.getPrimaryKey());

        sidottuImpl.setSidontaid(sidottu.getSidontaid());
        sidottuImpl.setSidonta(sidottu.getSidonta());

        return sidottuImpl;
    }

    /**
     * Returns the sidottu with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the sidottu
     * @return the sidottu
     * @throws fi.csc.avaa.khl.db.NoSuchSidottuException if a sidottu with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu findByPrimaryKey(Serializable primaryKey)
        throws NoSuchSidottuException, SystemException {
        Sidottu sidottu = fetchByPrimaryKey(primaryKey);

        if (sidottu == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSidottuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return sidottu;
    }

    /**
     * Returns the sidottu with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchSidottuException} if it could not be found.
     *
     * @param sidontaid the primary key of the sidottu
     * @return the sidottu
     * @throws fi.csc.avaa.khl.db.NoSuchSidottuException if a sidottu with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu findByPrimaryKey(int sidontaid)
        throws NoSuchSidottuException, SystemException {
        return findByPrimaryKey((Serializable) sidontaid);
    }

    /**
     * Returns the sidottu with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the sidottu
     * @return the sidottu, or <code>null</code> if a sidottu with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Sidottu sidottu = (Sidottu) EntityCacheUtil.getResult(SidottuModelImpl.ENTITY_CACHE_ENABLED,
                SidottuImpl.class, primaryKey);

        if (sidottu == _nullSidottu) {
            return null;
        }

        if (sidottu == null) {
            Session session = null;

            try {
                session = openSession();

                sidottu = (Sidottu) session.get(SidottuImpl.class, primaryKey);

                if (sidottu != null) {
                    cacheResult(sidottu);
                } else {
                    EntityCacheUtil.putResult(SidottuModelImpl.ENTITY_CACHE_ENABLED,
                        SidottuImpl.class, primaryKey, _nullSidottu);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(SidottuModelImpl.ENTITY_CACHE_ENABLED,
                    SidottuImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return sidottu;
    }

    /**
     * Returns the sidottu with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param sidontaid the primary key of the sidottu
     * @return the sidottu, or <code>null</code> if a sidottu with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sidottu fetchByPrimaryKey(int sidontaid) throws SystemException {
        return fetchByPrimaryKey((Serializable) sidontaid);
    }

    /**
     * Returns all the sidottus.
     *
     * @return the sidottus
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sidottu> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sidottus.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.SidottuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sidottus
     * @param end the upper bound of the range of sidottus (not inclusive)
     * @return the range of sidottus
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sidottu> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the sidottus.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.SidottuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sidottus
     * @param end the upper bound of the range of sidottus (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of sidottus
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sidottu> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Sidottu> list = (List<Sidottu>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SIDOTTU);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SIDOTTU;

                if (pagination) {
                    sql = sql.concat(SidottuModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Sidottu>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sidottu>(list);
                } else {
                    list = (List<Sidottu>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the sidottus from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Sidottu sidottu : findAll()) {
            remove(sidottu);
        }
    }

    /**
     * Returns the number of sidottus.
     *
     * @return the number of sidottus
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SIDOTTU);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the sidottu persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Sidottu")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Sidottu>> listenersList = new ArrayList<ModelListener<Sidottu>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Sidottu>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SidottuImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
