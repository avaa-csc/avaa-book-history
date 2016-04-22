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

import fi.csc.avaa.khl.db.NoSuchKuntoluokitusException;
import fi.csc.avaa.khl.db.model.Kuntoluokitus;
import fi.csc.avaa.khl.db.model.impl.KuntoluokitusImpl;
import fi.csc.avaa.khl.db.model.impl.KuntoluokitusModelImpl;
import fi.csc.avaa.khl.db.service.persistence.KuntoluokitusPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the kuntoluokitus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KuntoluokitusPersistence
 * @see KuntoluokitusUtil
 * @generated
 */
public class KuntoluokitusPersistenceImpl extends BasePersistenceImpl<Kuntoluokitus>
    implements KuntoluokitusPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link KuntoluokitusUtil} to access the kuntoluokitus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = KuntoluokitusImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
            KuntoluokitusModelImpl.FINDER_CACHE_ENABLED,
            KuntoluokitusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
            KuntoluokitusModelImpl.FINDER_CACHE_ENABLED,
            KuntoluokitusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
            KuntoluokitusModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_KUNTO = new FinderPath(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
            KuntoluokitusModelImpl.FINDER_CACHE_ENABLED,
            KuntoluokitusImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByKunto",
            new String[] { String.class.getName() },
            KuntoluokitusModelImpl.KUNTO_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_KUNTO = new FinderPath(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
            KuntoluokitusModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKunto",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_KUNTO_KUNTO_1 = "kuntoluokitus.kunto IS NULL";
    private static final String _FINDER_COLUMN_KUNTO_KUNTO_2 = "kuntoluokitus.kunto = ?";
    private static final String _FINDER_COLUMN_KUNTO_KUNTO_3 = "(kuntoluokitus.kunto IS NULL OR kuntoluokitus.kunto = '')";
    private static final String _SQL_SELECT_KUNTOLUOKITUS = "SELECT kuntoluokitus FROM Kuntoluokitus kuntoluokitus";
    private static final String _SQL_SELECT_KUNTOLUOKITUS_WHERE = "SELECT kuntoluokitus FROM Kuntoluokitus kuntoluokitus WHERE ";
    private static final String _SQL_COUNT_KUNTOLUOKITUS = "SELECT COUNT(kuntoluokitus) FROM Kuntoluokitus kuntoluokitus";
    private static final String _SQL_COUNT_KUNTOLUOKITUS_WHERE = "SELECT COUNT(kuntoluokitus) FROM Kuntoluokitus kuntoluokitus WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "kuntoluokitus.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Kuntoluokitus exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Kuntoluokitus exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(KuntoluokitusPersistenceImpl.class);
    private static Kuntoluokitus _nullKuntoluokitus = new KuntoluokitusImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Kuntoluokitus> toCacheModel() {
                return _nullKuntoluokitusCacheModel;
            }
        };

    private static CacheModel<Kuntoluokitus> _nullKuntoluokitusCacheModel = new CacheModel<Kuntoluokitus>() {
            @Override
            public Kuntoluokitus toEntityModel() {
                return _nullKuntoluokitus;
            }
        };

    public KuntoluokitusPersistenceImpl() {
        setModelClass(Kuntoluokitus.class);
    }

    /**
     * Returns the kuntoluokitus where kunto = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntoluokitusException} if it could not be found.
     *
     * @param kunto the kunto
     * @return the matching kuntoluokitus
     * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a matching kuntoluokitus could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus findByKunto(String kunto)
        throws NoSuchKuntoluokitusException, SystemException {
        Kuntoluokitus kuntoluokitus = fetchByKunto(kunto);

        if (kuntoluokitus == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("kunto=");
            msg.append(kunto);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchKuntoluokitusException(msg.toString());
        }

        return kuntoluokitus;
    }

    /**
     * Returns the kuntoluokitus where kunto = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param kunto the kunto
     * @return the matching kuntoluokitus, or <code>null</code> if a matching kuntoluokitus could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus fetchByKunto(String kunto) throws SystemException {
        return fetchByKunto(kunto, true);
    }

    /**
     * Returns the kuntoluokitus where kunto = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param kunto the kunto
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching kuntoluokitus, or <code>null</code> if a matching kuntoluokitus could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus fetchByKunto(String kunto, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { kunto };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KUNTO,
                    finderArgs, this);
        }

        if (result instanceof Kuntoluokitus) {
            Kuntoluokitus kuntoluokitus = (Kuntoluokitus) result;

            if (!Validator.equals(kunto, kuntoluokitus.getKunto())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_KUNTOLUOKITUS_WHERE);

            boolean bindKunto = false;

            if (kunto == null) {
                query.append(_FINDER_COLUMN_KUNTO_KUNTO_1);
            } else if (kunto.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_KUNTO_KUNTO_3);
            } else {
                bindKunto = true;

                query.append(_FINDER_COLUMN_KUNTO_KUNTO_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKunto) {
                    qPos.add(kunto);
                }

                List<Kuntoluokitus> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KUNTO,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "KuntoluokitusPersistenceImpl.fetchByKunto(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Kuntoluokitus kuntoluokitus = list.get(0);

                    result = kuntoluokitus;

                    cacheResult(kuntoluokitus);

                    if ((kuntoluokitus.getKunto() == null) ||
                            !kuntoluokitus.getKunto().equals(kunto)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KUNTO,
                            finderArgs, kuntoluokitus);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KUNTO,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Kuntoluokitus) result;
        }
    }

    /**
     * Removes the kuntoluokitus where kunto = &#63; from the database.
     *
     * @param kunto the kunto
     * @return the kuntoluokitus that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus removeByKunto(String kunto)
        throws NoSuchKuntoluokitusException, SystemException {
        Kuntoluokitus kuntoluokitus = findByKunto(kunto);

        return remove(kuntoluokitus);
    }

    /**
     * Returns the number of kuntoluokituses where kunto = &#63;.
     *
     * @param kunto the kunto
     * @return the number of matching kuntoluokituses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByKunto(String kunto) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_KUNTO;

        Object[] finderArgs = new Object[] { kunto };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_KUNTOLUOKITUS_WHERE);

            boolean bindKunto = false;

            if (kunto == null) {
                query.append(_FINDER_COLUMN_KUNTO_KUNTO_1);
            } else if (kunto.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_KUNTO_KUNTO_3);
            } else {
                bindKunto = true;

                query.append(_FINDER_COLUMN_KUNTO_KUNTO_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKunto) {
                    qPos.add(kunto);
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
     * Caches the kuntoluokitus in the entity cache if it is enabled.
     *
     * @param kuntoluokitus the kuntoluokitus
     */
    @Override
    public void cacheResult(Kuntoluokitus kuntoluokitus) {
        EntityCacheUtil.putResult(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
            KuntoluokitusImpl.class, kuntoluokitus.getPrimaryKey(),
            kuntoluokitus);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KUNTO,
            new Object[] { kuntoluokitus.getKunto() }, kuntoluokitus);

        kuntoluokitus.resetOriginalValues();
    }

    /**
     * Caches the kuntoluokituses in the entity cache if it is enabled.
     *
     * @param kuntoluokituses the kuntoluokituses
     */
    @Override
    public void cacheResult(List<Kuntoluokitus> kuntoluokituses) {
        for (Kuntoluokitus kuntoluokitus : kuntoluokituses) {
            if (EntityCacheUtil.getResult(
                        KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
                        KuntoluokitusImpl.class, kuntoluokitus.getPrimaryKey()) == null) {
                cacheResult(kuntoluokitus);
            } else {
                kuntoluokitus.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all kuntoluokituses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(KuntoluokitusImpl.class.getName());
        }

        EntityCacheUtil.clearCache(KuntoluokitusImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the kuntoluokitus.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Kuntoluokitus kuntoluokitus) {
        EntityCacheUtil.removeResult(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
            KuntoluokitusImpl.class, kuntoluokitus.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(kuntoluokitus);
    }

    @Override
    public void clearCache(List<Kuntoluokitus> kuntoluokituses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Kuntoluokitus kuntoluokitus : kuntoluokituses) {
            EntityCacheUtil.removeResult(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
                KuntoluokitusImpl.class, kuntoluokitus.getPrimaryKey());

            clearUniqueFindersCache(kuntoluokitus);
        }
    }

    protected void cacheUniqueFindersCache(Kuntoluokitus kuntoluokitus) {
        if (kuntoluokitus.isNew()) {
            Object[] args = new Object[] { kuntoluokitus.getKunto() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KUNTO, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KUNTO, args,
                kuntoluokitus);
        } else {
            KuntoluokitusModelImpl kuntoluokitusModelImpl = (KuntoluokitusModelImpl) kuntoluokitus;

            if ((kuntoluokitusModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_KUNTO.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { kuntoluokitus.getKunto() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KUNTO, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KUNTO, args,
                    kuntoluokitus);
            }
        }
    }

    protected void clearUniqueFindersCache(Kuntoluokitus kuntoluokitus) {
        KuntoluokitusModelImpl kuntoluokitusModelImpl = (KuntoluokitusModelImpl) kuntoluokitus;

        Object[] args = new Object[] { kuntoluokitus.getKunto() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KUNTO, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KUNTO, args);

        if ((kuntoluokitusModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_KUNTO.getColumnBitmask()) != 0) {
            args = new Object[] { kuntoluokitusModelImpl.getOriginalKunto() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KUNTO, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KUNTO, args);
        }
    }

    /**
     * Creates a new kuntoluokitus with the primary key. Does not add the kuntoluokitus to the database.
     *
     * @param kuntoid the primary key for the new kuntoluokitus
     * @return the new kuntoluokitus
     */
    @Override
    public Kuntoluokitus create(int kuntoid) {
        Kuntoluokitus kuntoluokitus = new KuntoluokitusImpl();

        kuntoluokitus.setNew(true);
        kuntoluokitus.setPrimaryKey(kuntoid);

        return kuntoluokitus;
    }

    /**
     * Removes the kuntoluokitus with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param kuntoid the primary key of the kuntoluokitus
     * @return the kuntoluokitus that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a kuntoluokitus with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus remove(int kuntoid)
        throws NoSuchKuntoluokitusException, SystemException {
        return remove((Serializable) kuntoid);
    }

    /**
     * Removes the kuntoluokitus with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the kuntoluokitus
     * @return the kuntoluokitus that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a kuntoluokitus with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus remove(Serializable primaryKey)
        throws NoSuchKuntoluokitusException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Kuntoluokitus kuntoluokitus = (Kuntoluokitus) session.get(KuntoluokitusImpl.class,
                    primaryKey);

            if (kuntoluokitus == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchKuntoluokitusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(kuntoluokitus);
        } catch (NoSuchKuntoluokitusException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Kuntoluokitus removeImpl(Kuntoluokitus kuntoluokitus)
        throws SystemException {
        kuntoluokitus = toUnwrappedModel(kuntoluokitus);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(kuntoluokitus)) {
                kuntoluokitus = (Kuntoluokitus) session.get(KuntoluokitusImpl.class,
                        kuntoluokitus.getPrimaryKeyObj());
            }

            if (kuntoluokitus != null) {
                session.delete(kuntoluokitus);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (kuntoluokitus != null) {
            clearCache(kuntoluokitus);
        }

        return kuntoluokitus;
    }

    @Override
    public Kuntoluokitus updateImpl(
        fi.csc.avaa.khl.db.model.Kuntoluokitus kuntoluokitus)
        throws SystemException {
        kuntoluokitus = toUnwrappedModel(kuntoluokitus);

        boolean isNew = kuntoluokitus.isNew();

        Session session = null;

        try {
            session = openSession();

            if (kuntoluokitus.isNew()) {
                session.save(kuntoluokitus);

                kuntoluokitus.setNew(false);
            } else {
                session.merge(kuntoluokitus);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !KuntoluokitusModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
            KuntoluokitusImpl.class, kuntoluokitus.getPrimaryKey(),
            kuntoluokitus);

        clearUniqueFindersCache(kuntoluokitus);
        cacheUniqueFindersCache(kuntoluokitus);

        return kuntoluokitus;
    }

    protected Kuntoluokitus toUnwrappedModel(Kuntoluokitus kuntoluokitus) {
        if (kuntoluokitus instanceof KuntoluokitusImpl) {
            return kuntoluokitus;
        }

        KuntoluokitusImpl kuntoluokitusImpl = new KuntoluokitusImpl();

        kuntoluokitusImpl.setNew(kuntoluokitus.isNew());
        kuntoluokitusImpl.setPrimaryKey(kuntoluokitus.getPrimaryKey());

        kuntoluokitusImpl.setKuntoid(kuntoluokitus.getKuntoid());
        kuntoluokitusImpl.setKunto(kuntoluokitus.getKunto());

        return kuntoluokitusImpl;
    }

    /**
     * Returns the kuntoluokitus with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the kuntoluokitus
     * @return the kuntoluokitus
     * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a kuntoluokitus with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus findByPrimaryKey(Serializable primaryKey)
        throws NoSuchKuntoluokitusException, SystemException {
        Kuntoluokitus kuntoluokitus = fetchByPrimaryKey(primaryKey);

        if (kuntoluokitus == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchKuntoluokitusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return kuntoluokitus;
    }

    /**
     * Returns the kuntoluokitus with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntoluokitusException} if it could not be found.
     *
     * @param kuntoid the primary key of the kuntoluokitus
     * @return the kuntoluokitus
     * @throws fi.csc.avaa.khl.db.NoSuchKuntoluokitusException if a kuntoluokitus with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus findByPrimaryKey(int kuntoid)
        throws NoSuchKuntoluokitusException, SystemException {
        return findByPrimaryKey((Serializable) kuntoid);
    }

    /**
     * Returns the kuntoluokitus with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the kuntoluokitus
     * @return the kuntoluokitus, or <code>null</code> if a kuntoluokitus with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Kuntoluokitus kuntoluokitus = (Kuntoluokitus) EntityCacheUtil.getResult(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
                KuntoluokitusImpl.class, primaryKey);

        if (kuntoluokitus == _nullKuntoluokitus) {
            return null;
        }

        if (kuntoluokitus == null) {
            Session session = null;

            try {
                session = openSession();

                kuntoluokitus = (Kuntoluokitus) session.get(KuntoluokitusImpl.class,
                        primaryKey);

                if (kuntoluokitus != null) {
                    cacheResult(kuntoluokitus);
                } else {
                    EntityCacheUtil.putResult(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
                        KuntoluokitusImpl.class, primaryKey, _nullKuntoluokitus);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(KuntoluokitusModelImpl.ENTITY_CACHE_ENABLED,
                    KuntoluokitusImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return kuntoluokitus;
    }

    /**
     * Returns the kuntoluokitus with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param kuntoid the primary key of the kuntoluokitus
     * @return the kuntoluokitus, or <code>null</code> if a kuntoluokitus with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntoluokitus fetchByPrimaryKey(int kuntoid)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) kuntoid);
    }

    /**
     * Returns all the kuntoluokituses.
     *
     * @return the kuntoluokituses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kuntoluokitus> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Kuntoluokitus> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Kuntoluokitus> findAll(int start, int end,
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

        List<Kuntoluokitus> list = (List<Kuntoluokitus>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_KUNTOLUOKITUS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_KUNTOLUOKITUS;

                if (pagination) {
                    sql = sql.concat(KuntoluokitusModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Kuntoluokitus>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Kuntoluokitus>(list);
                } else {
                    list = (List<Kuntoluokitus>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the kuntoluokituses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Kuntoluokitus kuntoluokitus : findAll()) {
            remove(kuntoluokitus);
        }
    }

    /**
     * Returns the number of kuntoluokituses.
     *
     * @return the number of kuntoluokituses
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

                Query q = session.createQuery(_SQL_COUNT_KUNTOLUOKITUS);

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
     * Initializes the kuntoluokitus persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Kuntoluokitus")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Kuntoluokitus>> listenersList = new ArrayList<ModelListener<Kuntoluokitus>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Kuntoluokitus>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(KuntoluokitusImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
