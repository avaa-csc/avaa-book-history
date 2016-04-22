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

import fi.csc.avaa.khl.db.NoSuchPuuteException;
import fi.csc.avaa.khl.db.model.Puute;
import fi.csc.avaa.khl.db.model.impl.PuuteImpl;
import fi.csc.avaa.khl.db.model.impl.PuuteModelImpl;
import fi.csc.avaa.khl.db.service.persistence.PuutePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the puute service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see PuutePersistence
 * @see PuuteUtil
 * @generated
 */
public class PuutePersistenceImpl extends BasePersistenceImpl<Puute>
    implements PuutePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PuuteUtil} to access the puute persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PuuteImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PuuteModelImpl.ENTITY_CACHE_ENABLED,
            PuuteModelImpl.FINDER_CACHE_ENABLED, PuuteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PuuteModelImpl.ENTITY_CACHE_ENABLED,
            PuuteModelImpl.FINDER_CACHE_ENABLED, PuuteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PuuteModelImpl.ENTITY_CACHE_ENABLED,
            PuuteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_PUUTENIMI = new FinderPath(PuuteModelImpl.ENTITY_CACHE_ENABLED,
            PuuteModelImpl.FINDER_CACHE_ENABLED, PuuteImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByPuutenimi",
            new String[] { String.class.getName() },
            PuuteModelImpl.PUUTENIMI_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PUUTENIMI = new FinderPath(PuuteModelImpl.ENTITY_CACHE_ENABLED,
            PuuteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPuutenimi",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_PUUTENIMI_PUUTENIMI_1 = "puute.puutenimi IS NULL";
    private static final String _FINDER_COLUMN_PUUTENIMI_PUUTENIMI_2 = "puute.puutenimi = ?";
    private static final String _FINDER_COLUMN_PUUTENIMI_PUUTENIMI_3 = "(puute.puutenimi IS NULL OR puute.puutenimi = '')";
    private static final String _SQL_SELECT_PUUTE = "SELECT puute FROM Puute puute";
    private static final String _SQL_SELECT_PUUTE_WHERE = "SELECT puute FROM Puute puute WHERE ";
    private static final String _SQL_COUNT_PUUTE = "SELECT COUNT(puute) FROM Puute puute";
    private static final String _SQL_COUNT_PUUTE_WHERE = "SELECT COUNT(puute) FROM Puute puute WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "puute.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Puute exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Puute exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PuutePersistenceImpl.class);
    private static Puute _nullPuute = new PuuteImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Puute> toCacheModel() {
                return _nullPuuteCacheModel;
            }
        };

    private static CacheModel<Puute> _nullPuuteCacheModel = new CacheModel<Puute>() {
            @Override
            public Puute toEntityModel() {
                return _nullPuute;
            }
        };

    public PuutePersistenceImpl() {
        setModelClass(Puute.class);
    }

    /**
     * Returns the puute where puutenimi = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchPuuteException} if it could not be found.
     *
     * @param puutenimi the puutenimi
     * @return the matching puute
     * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a matching puute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute findByPuutenimi(String puutenimi)
        throws NoSuchPuuteException, SystemException {
        Puute puute = fetchByPuutenimi(puutenimi);

        if (puute == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("puutenimi=");
            msg.append(puutenimi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPuuteException(msg.toString());
        }

        return puute;
    }

    /**
     * Returns the puute where puutenimi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param puutenimi the puutenimi
     * @return the matching puute, or <code>null</code> if a matching puute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute fetchByPuutenimi(String puutenimi) throws SystemException {
        return fetchByPuutenimi(puutenimi, true);
    }

    /**
     * Returns the puute where puutenimi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param puutenimi the puutenimi
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching puute, or <code>null</code> if a matching puute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute fetchByPuutenimi(String puutenimi, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { puutenimi };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUUTENIMI,
                    finderArgs, this);
        }

        if (result instanceof Puute) {
            Puute puute = (Puute) result;

            if (!Validator.equals(puutenimi, puute.getPuutenimi())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_PUUTE_WHERE);

            boolean bindPuutenimi = false;

            if (puutenimi == null) {
                query.append(_FINDER_COLUMN_PUUTENIMI_PUUTENIMI_1);
            } else if (puutenimi.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PUUTENIMI_PUUTENIMI_3);
            } else {
                bindPuutenimi = true;

                query.append(_FINDER_COLUMN_PUUTENIMI_PUUTENIMI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPuutenimi) {
                    qPos.add(puutenimi);
                }

                List<Puute> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUUTENIMI,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "PuutePersistenceImpl.fetchByPuutenimi(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Puute puute = list.get(0);

                    result = puute;

                    cacheResult(puute);

                    if ((puute.getPuutenimi() == null) ||
                            !puute.getPuutenimi().equals(puutenimi)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUUTENIMI,
                            finderArgs, puute);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUUTENIMI,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Puute) result;
        }
    }

    /**
     * Removes the puute where puutenimi = &#63; from the database.
     *
     * @param puutenimi the puutenimi
     * @return the puute that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute removeByPuutenimi(String puutenimi)
        throws NoSuchPuuteException, SystemException {
        Puute puute = findByPuutenimi(puutenimi);

        return remove(puute);
    }

    /**
     * Returns the number of puutes where puutenimi = &#63;.
     *
     * @param puutenimi the puutenimi
     * @return the number of matching puutes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPuutenimi(String puutenimi) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PUUTENIMI;

        Object[] finderArgs = new Object[] { puutenimi };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUUTE_WHERE);

            boolean bindPuutenimi = false;

            if (puutenimi == null) {
                query.append(_FINDER_COLUMN_PUUTENIMI_PUUTENIMI_1);
            } else if (puutenimi.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PUUTENIMI_PUUTENIMI_3);
            } else {
                bindPuutenimi = true;

                query.append(_FINDER_COLUMN_PUUTENIMI_PUUTENIMI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPuutenimi) {
                    qPos.add(puutenimi);
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
     * Caches the puute in the entity cache if it is enabled.
     *
     * @param puute the puute
     */
    @Override
    public void cacheResult(Puute puute) {
        EntityCacheUtil.putResult(PuuteModelImpl.ENTITY_CACHE_ENABLED,
            PuuteImpl.class, puute.getPrimaryKey(), puute);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUUTENIMI,
            new Object[] { puute.getPuutenimi() }, puute);

        puute.resetOriginalValues();
    }

    /**
     * Caches the puutes in the entity cache if it is enabled.
     *
     * @param puutes the puutes
     */
    @Override
    public void cacheResult(List<Puute> puutes) {
        for (Puute puute : puutes) {
            if (EntityCacheUtil.getResult(PuuteModelImpl.ENTITY_CACHE_ENABLED,
                        PuuteImpl.class, puute.getPrimaryKey()) == null) {
                cacheResult(puute);
            } else {
                puute.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all puutes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PuuteImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PuuteImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the puute.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Puute puute) {
        EntityCacheUtil.removeResult(PuuteModelImpl.ENTITY_CACHE_ENABLED,
            PuuteImpl.class, puute.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(puute);
    }

    @Override
    public void clearCache(List<Puute> puutes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Puute puute : puutes) {
            EntityCacheUtil.removeResult(PuuteModelImpl.ENTITY_CACHE_ENABLED,
                PuuteImpl.class, puute.getPrimaryKey());

            clearUniqueFindersCache(puute);
        }
    }

    protected void cacheUniqueFindersCache(Puute puute) {
        if (puute.isNew()) {
            Object[] args = new Object[] { puute.getPuutenimi() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUUTENIMI, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUUTENIMI, args,
                puute);
        } else {
            PuuteModelImpl puuteModelImpl = (PuuteModelImpl) puute;

            if ((puuteModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_PUUTENIMI.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { puute.getPuutenimi() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUUTENIMI, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUUTENIMI, args,
                    puute);
            }
        }
    }

    protected void clearUniqueFindersCache(Puute puute) {
        PuuteModelImpl puuteModelImpl = (PuuteModelImpl) puute;

        Object[] args = new Object[] { puute.getPuutenimi() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUUTENIMI, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUUTENIMI, args);

        if ((puuteModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_PUUTENIMI.getColumnBitmask()) != 0) {
            args = new Object[] { puuteModelImpl.getOriginalPuutenimi() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUUTENIMI, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUUTENIMI, args);
        }
    }

    /**
     * Creates a new puute with the primary key. Does not add the puute to the database.
     *
     * @param puuteid the primary key for the new puute
     * @return the new puute
     */
    @Override
    public Puute create(int puuteid) {
        Puute puute = new PuuteImpl();

        puute.setNew(true);
        puute.setPrimaryKey(puuteid);

        return puute;
    }

    /**
     * Removes the puute with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param puuteid the primary key of the puute
     * @return the puute that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a puute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute remove(int puuteid)
        throws NoSuchPuuteException, SystemException {
        return remove((Serializable) puuteid);
    }

    /**
     * Removes the puute with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the puute
     * @return the puute that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a puute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute remove(Serializable primaryKey)
        throws NoSuchPuuteException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Puute puute = (Puute) session.get(PuuteImpl.class, primaryKey);

            if (puute == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPuuteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(puute);
        } catch (NoSuchPuuteException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Puute removeImpl(Puute puute) throws SystemException {
        puute = toUnwrappedModel(puute);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(puute)) {
                puute = (Puute) session.get(PuuteImpl.class,
                        puute.getPrimaryKeyObj());
            }

            if (puute != null) {
                session.delete(puute);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (puute != null) {
            clearCache(puute);
        }

        return puute;
    }

    @Override
    public Puute updateImpl(fi.csc.avaa.khl.db.model.Puute puute)
        throws SystemException {
        puute = toUnwrappedModel(puute);

        boolean isNew = puute.isNew();

        Session session = null;

        try {
            session = openSession();

            if (puute.isNew()) {
                session.save(puute);

                puute.setNew(false);
            } else {
                session.merge(puute);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PuuteModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(PuuteModelImpl.ENTITY_CACHE_ENABLED,
            PuuteImpl.class, puute.getPrimaryKey(), puute);

        clearUniqueFindersCache(puute);
        cacheUniqueFindersCache(puute);

        return puute;
    }

    protected Puute toUnwrappedModel(Puute puute) {
        if (puute instanceof PuuteImpl) {
            return puute;
        }

        PuuteImpl puuteImpl = new PuuteImpl();

        puuteImpl.setNew(puute.isNew());
        puuteImpl.setPrimaryKey(puute.getPrimaryKey());

        puuteImpl.setPuuteid(puute.getPuuteid());
        puuteImpl.setPuutenimi(puute.getPuutenimi());

        return puuteImpl;
    }

    /**
     * Returns the puute with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the puute
     * @return the puute
     * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a puute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPuuteException, SystemException {
        Puute puute = fetchByPrimaryKey(primaryKey);

        if (puute == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPuuteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return puute;
    }

    /**
     * Returns the puute with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchPuuteException} if it could not be found.
     *
     * @param puuteid the primary key of the puute
     * @return the puute
     * @throws fi.csc.avaa.khl.db.NoSuchPuuteException if a puute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute findByPrimaryKey(int puuteid)
        throws NoSuchPuuteException, SystemException {
        return findByPrimaryKey((Serializable) puuteid);
    }

    /**
     * Returns the puute with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the puute
     * @return the puute, or <code>null</code> if a puute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Puute puute = (Puute) EntityCacheUtil.getResult(PuuteModelImpl.ENTITY_CACHE_ENABLED,
                PuuteImpl.class, primaryKey);

        if (puute == _nullPuute) {
            return null;
        }

        if (puute == null) {
            Session session = null;

            try {
                session = openSession();

                puute = (Puute) session.get(PuuteImpl.class, primaryKey);

                if (puute != null) {
                    cacheResult(puute);
                } else {
                    EntityCacheUtil.putResult(PuuteModelImpl.ENTITY_CACHE_ENABLED,
                        PuuteImpl.class, primaryKey, _nullPuute);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PuuteModelImpl.ENTITY_CACHE_ENABLED,
                    PuuteImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return puute;
    }

    /**
     * Returns the puute with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param puuteid the primary key of the puute
     * @return the puute, or <code>null</code> if a puute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Puute fetchByPrimaryKey(int puuteid) throws SystemException {
        return fetchByPrimaryKey((Serializable) puuteid);
    }

    /**
     * Returns all the puutes.
     *
     * @return the puutes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Puute> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Puute> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Puute> findAll(int start, int end,
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

        List<Puute> list = (List<Puute>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PUUTE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PUUTE;

                if (pagination) {
                    sql = sql.concat(PuuteModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Puute>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Puute>(list);
                } else {
                    list = (List<Puute>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the puutes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Puute puute : findAll()) {
            remove(puute);
        }
    }

    /**
     * Returns the number of puutes.
     *
     * @return the number of puutes
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

                Query q = session.createQuery(_SQL_COUNT_PUUTE);

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
     * Initializes the puute persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Puute")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Puute>> listenersList = new ArrayList<ModelListener<Puute>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Puute>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PuuteImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
