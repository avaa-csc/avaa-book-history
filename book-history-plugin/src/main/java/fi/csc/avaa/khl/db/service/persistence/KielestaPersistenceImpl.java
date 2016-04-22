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

import fi.csc.avaa.khl.db.NoSuchKielestaException;
import fi.csc.avaa.khl.db.model.Kielesta;
import fi.csc.avaa.khl.db.model.impl.KielestaImpl;
import fi.csc.avaa.khl.db.model.impl.KielestaModelImpl;
import fi.csc.avaa.khl.db.service.persistence.KielestaPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the kielesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KielestaPersistence
 * @see KielestaUtil
 * @generated
 */
public class KielestaPersistenceImpl extends BasePersistenceImpl<Kielesta>
    implements KielestaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link KielestaUtil} to access the kielesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = KielestaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KielestaModelImpl.ENTITY_CACHE_ENABLED,
            KielestaModelImpl.FINDER_CACHE_ENABLED, KielestaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KielestaModelImpl.ENTITY_CACHE_ENABLED,
            KielestaModelImpl.FINDER_CACHE_ENABLED, KielestaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KielestaModelImpl.ENTITY_CACHE_ENABLED,
            KielestaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_KIELI = new FinderPath(KielestaModelImpl.ENTITY_CACHE_ENABLED,
            KielestaModelImpl.FINDER_CACHE_ENABLED, KielestaImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByKieli",
            new String[] { String.class.getName() },
            KielestaModelImpl.KIELI_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_KIELI = new FinderPath(KielestaModelImpl.ENTITY_CACHE_ENABLED,
            KielestaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKieli",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_KIELI_KIELI_1 = "kielesta.kieli IS NULL";
    private static final String _FINDER_COLUMN_KIELI_KIELI_2 = "kielesta.kieli = ?";
    private static final String _FINDER_COLUMN_KIELI_KIELI_3 = "(kielesta.kieli IS NULL OR kielesta.kieli = '')";
    private static final String _SQL_SELECT_KIELESTA = "SELECT kielesta FROM Kielesta kielesta";
    private static final String _SQL_SELECT_KIELESTA_WHERE = "SELECT kielesta FROM Kielesta kielesta WHERE ";
    private static final String _SQL_COUNT_KIELESTA = "SELECT COUNT(kielesta) FROM Kielesta kielesta";
    private static final String _SQL_COUNT_KIELESTA_WHERE = "SELECT COUNT(kielesta) FROM Kielesta kielesta WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "kielesta.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Kielesta exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Kielesta exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(KielestaPersistenceImpl.class);
    private static Kielesta _nullKielesta = new KielestaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Kielesta> toCacheModel() {
                return _nullKielestaCacheModel;
            }
        };

    private static CacheModel<Kielesta> _nullKielestaCacheModel = new CacheModel<Kielesta>() {
            @Override
            public Kielesta toEntityModel() {
                return _nullKielesta;
            }
        };

    public KielestaPersistenceImpl() {
        setModelClass(Kielesta.class);
    }

    /**
     * Returns the kielesta where kieli = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKielestaException} if it could not be found.
     *
     * @param kieli the kieli
     * @return the matching kielesta
     * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a matching kielesta could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta findByKieli(String kieli)
        throws NoSuchKielestaException, SystemException {
        Kielesta kielesta = fetchByKieli(kieli);

        if (kielesta == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("kieli=");
            msg.append(kieli);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchKielestaException(msg.toString());
        }

        return kielesta;
    }

    /**
     * Returns the kielesta where kieli = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param kieli the kieli
     * @return the matching kielesta, or <code>null</code> if a matching kielesta could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta fetchByKieli(String kieli) throws SystemException {
        return fetchByKieli(kieli, true);
    }

    /**
     * Returns the kielesta where kieli = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param kieli the kieli
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching kielesta, or <code>null</code> if a matching kielesta could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta fetchByKieli(String kieli, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { kieli };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KIELI,
                    finderArgs, this);
        }

        if (result instanceof Kielesta) {
            Kielesta kielesta = (Kielesta) result;

            if (!Validator.equals(kieli, kielesta.getKieli())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_KIELESTA_WHERE);

            boolean bindKieli = false;

            if (kieli == null) {
                query.append(_FINDER_COLUMN_KIELI_KIELI_1);
            } else if (kieli.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_KIELI_KIELI_3);
            } else {
                bindKieli = true;

                query.append(_FINDER_COLUMN_KIELI_KIELI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKieli) {
                    qPos.add(kieli);
                }

                List<Kielesta> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "KielestaPersistenceImpl.fetchByKieli(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Kielesta kielesta = list.get(0);

                    result = kielesta;

                    cacheResult(kielesta);

                    if ((kielesta.getKieli() == null) ||
                            !kielesta.getKieli().equals(kieli)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI,
                            finderArgs, kielesta);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KIELI,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Kielesta) result;
        }
    }

    /**
     * Removes the kielesta where kieli = &#63; from the database.
     *
     * @param kieli the kieli
     * @return the kielesta that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta removeByKieli(String kieli)
        throws NoSuchKielestaException, SystemException {
        Kielesta kielesta = findByKieli(kieli);

        return remove(kielesta);
    }

    /**
     * Returns the number of kielestas where kieli = &#63;.
     *
     * @param kieli the kieli
     * @return the number of matching kielestas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByKieli(String kieli) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_KIELI;

        Object[] finderArgs = new Object[] { kieli };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_KIELESTA_WHERE);

            boolean bindKieli = false;

            if (kieli == null) {
                query.append(_FINDER_COLUMN_KIELI_KIELI_1);
            } else if (kieli.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_KIELI_KIELI_3);
            } else {
                bindKieli = true;

                query.append(_FINDER_COLUMN_KIELI_KIELI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKieli) {
                    qPos.add(kieli);
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
     * Caches the kielesta in the entity cache if it is enabled.
     *
     * @param kielesta the kielesta
     */
    @Override
    public void cacheResult(Kielesta kielesta) {
        EntityCacheUtil.putResult(KielestaModelImpl.ENTITY_CACHE_ENABLED,
            KielestaImpl.class, kielesta.getPrimaryKey(), kielesta);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI,
            new Object[] { kielesta.getKieli() }, kielesta);

        kielesta.resetOriginalValues();
    }

    /**
     * Caches the kielestas in the entity cache if it is enabled.
     *
     * @param kielestas the kielestas
     */
    @Override
    public void cacheResult(List<Kielesta> kielestas) {
        for (Kielesta kielesta : kielestas) {
            if (EntityCacheUtil.getResult(
                        KielestaModelImpl.ENTITY_CACHE_ENABLED,
                        KielestaImpl.class, kielesta.getPrimaryKey()) == null) {
                cacheResult(kielesta);
            } else {
                kielesta.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all kielestas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(KielestaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(KielestaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the kielesta.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Kielesta kielesta) {
        EntityCacheUtil.removeResult(KielestaModelImpl.ENTITY_CACHE_ENABLED,
            KielestaImpl.class, kielesta.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(kielesta);
    }

    @Override
    public void clearCache(List<Kielesta> kielestas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Kielesta kielesta : kielestas) {
            EntityCacheUtil.removeResult(KielestaModelImpl.ENTITY_CACHE_ENABLED,
                KielestaImpl.class, kielesta.getPrimaryKey());

            clearUniqueFindersCache(kielesta);
        }
    }

    protected void cacheUniqueFindersCache(Kielesta kielesta) {
        if (kielesta.isNew()) {
            Object[] args = new Object[] { kielesta.getKieli() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KIELI, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI, args, kielesta);
        } else {
            KielestaModelImpl kielestaModelImpl = (KielestaModelImpl) kielesta;

            if ((kielestaModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_KIELI.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { kielesta.getKieli() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KIELI, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI, args,
                    kielesta);
            }
        }
    }

    protected void clearUniqueFindersCache(Kielesta kielesta) {
        KielestaModelImpl kielestaModelImpl = (KielestaModelImpl) kielesta;

        Object[] args = new Object[] { kielesta.getKieli() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KIELI, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KIELI, args);

        if ((kielestaModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_KIELI.getColumnBitmask()) != 0) {
            args = new Object[] { kielestaModelImpl.getOriginalKieli() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KIELI, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KIELI, args);
        }
    }

    /**
     * Creates a new kielesta with the primary key. Does not add the kielesta to the database.
     *
     * @param kieliid the primary key for the new kielesta
     * @return the new kielesta
     */
    @Override
    public Kielesta create(int kieliid) {
        Kielesta kielesta = new KielestaImpl();

        kielesta.setNew(true);
        kielesta.setPrimaryKey(kieliid);

        return kielesta;
    }

    /**
     * Removes the kielesta with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param kieliid the primary key of the kielesta
     * @return the kielesta that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a kielesta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta remove(int kieliid)
        throws NoSuchKielestaException, SystemException {
        return remove((Serializable) kieliid);
    }

    /**
     * Removes the kielesta with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the kielesta
     * @return the kielesta that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a kielesta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta remove(Serializable primaryKey)
        throws NoSuchKielestaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Kielesta kielesta = (Kielesta) session.get(KielestaImpl.class,
                    primaryKey);

            if (kielesta == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchKielestaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(kielesta);
        } catch (NoSuchKielestaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Kielesta removeImpl(Kielesta kielesta) throws SystemException {
        kielesta = toUnwrappedModel(kielesta);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(kielesta)) {
                kielesta = (Kielesta) session.get(KielestaImpl.class,
                        kielesta.getPrimaryKeyObj());
            }

            if (kielesta != null) {
                session.delete(kielesta);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (kielesta != null) {
            clearCache(kielesta);
        }

        return kielesta;
    }

    @Override
    public Kielesta updateImpl(fi.csc.avaa.khl.db.model.Kielesta kielesta)
        throws SystemException {
        kielesta = toUnwrappedModel(kielesta);

        boolean isNew = kielesta.isNew();

        Session session = null;

        try {
            session = openSession();

            if (kielesta.isNew()) {
                session.save(kielesta);

                kielesta.setNew(false);
            } else {
                session.merge(kielesta);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !KielestaModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(KielestaModelImpl.ENTITY_CACHE_ENABLED,
            KielestaImpl.class, kielesta.getPrimaryKey(), kielesta);

        clearUniqueFindersCache(kielesta);
        cacheUniqueFindersCache(kielesta);

        return kielesta;
    }

    protected Kielesta toUnwrappedModel(Kielesta kielesta) {
        if (kielesta instanceof KielestaImpl) {
            return kielesta;
        }

        KielestaImpl kielestaImpl = new KielestaImpl();

        kielestaImpl.setNew(kielesta.isNew());
        kielestaImpl.setPrimaryKey(kielesta.getPrimaryKey());

        kielestaImpl.setKieliid(kielesta.getKieliid());
        kielestaImpl.setKieli(kielesta.getKieli());

        return kielestaImpl;
    }

    /**
     * Returns the kielesta with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the kielesta
     * @return the kielesta
     * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a kielesta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta findByPrimaryKey(Serializable primaryKey)
        throws NoSuchKielestaException, SystemException {
        Kielesta kielesta = fetchByPrimaryKey(primaryKey);

        if (kielesta == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchKielestaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return kielesta;
    }

    /**
     * Returns the kielesta with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKielestaException} if it could not be found.
     *
     * @param kieliid the primary key of the kielesta
     * @return the kielesta
     * @throws fi.csc.avaa.khl.db.NoSuchKielestaException if a kielesta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta findByPrimaryKey(int kieliid)
        throws NoSuchKielestaException, SystemException {
        return findByPrimaryKey((Serializable) kieliid);
    }

    /**
     * Returns the kielesta with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the kielesta
     * @return the kielesta, or <code>null</code> if a kielesta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Kielesta kielesta = (Kielesta) EntityCacheUtil.getResult(KielestaModelImpl.ENTITY_CACHE_ENABLED,
                KielestaImpl.class, primaryKey);

        if (kielesta == _nullKielesta) {
            return null;
        }

        if (kielesta == null) {
            Session session = null;

            try {
                session = openSession();

                kielesta = (Kielesta) session.get(KielestaImpl.class, primaryKey);

                if (kielesta != null) {
                    cacheResult(kielesta);
                } else {
                    EntityCacheUtil.putResult(KielestaModelImpl.ENTITY_CACHE_ENABLED,
                        KielestaImpl.class, primaryKey, _nullKielesta);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(KielestaModelImpl.ENTITY_CACHE_ENABLED,
                    KielestaImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return kielesta;
    }

    /**
     * Returns the kielesta with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param kieliid the primary key of the kielesta
     * @return the kielesta, or <code>null</code> if a kielesta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kielesta fetchByPrimaryKey(int kieliid) throws SystemException {
        return fetchByPrimaryKey((Serializable) kieliid);
    }

    /**
     * Returns all the kielestas.
     *
     * @return the kielestas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kielesta> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Kielesta> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Kielesta> findAll(int start, int end,
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

        List<Kielesta> list = (List<Kielesta>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_KIELESTA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_KIELESTA;

                if (pagination) {
                    sql = sql.concat(KielestaModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Kielesta>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Kielesta>(list);
                } else {
                    list = (List<Kielesta>) QueryUtil.list(q, getDialect(),
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
     * Removes all the kielestas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Kielesta kielesta : findAll()) {
            remove(kielesta);
        }
    }

    /**
     * Returns the number of kielestas.
     *
     * @return the number of kielestas
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

                Query q = session.createQuery(_SQL_COUNT_KIELESTA);

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
     * Initializes the kielesta persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Kielesta")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Kielesta>> listenersList = new ArrayList<ModelListener<Kielesta>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Kielesta>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(KielestaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
