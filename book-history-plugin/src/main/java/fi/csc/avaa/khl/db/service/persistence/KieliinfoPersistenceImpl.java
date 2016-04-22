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

import fi.csc.avaa.khl.db.NoSuchKieliinfoException;
import fi.csc.avaa.khl.db.model.Kieliinfo;
import fi.csc.avaa.khl.db.model.impl.KieliinfoImpl;
import fi.csc.avaa.khl.db.model.impl.KieliinfoModelImpl;
import fi.csc.avaa.khl.db.service.persistence.KieliinfoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the kieliinfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KieliinfoPersistence
 * @see KieliinfoUtil
 * @generated
 */
public class KieliinfoPersistenceImpl extends BasePersistenceImpl<Kieliinfo>
    implements KieliinfoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link KieliinfoUtil} to access the kieliinfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = KieliinfoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
            KieliinfoModelImpl.FINDER_CACHE_ENABLED, KieliinfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
            KieliinfoModelImpl.FINDER_CACHE_ENABLED, KieliinfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
            KieliinfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_KIELI = new FinderPath(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
            KieliinfoModelImpl.FINDER_CACHE_ENABLED, KieliinfoImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByKieli",
            new String[] { String.class.getName() },
            KieliinfoModelImpl.KIELI_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_KIELI = new FinderPath(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
            KieliinfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKieli",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_KIELI_KIELI_1 = "kieliinfo.kieli IS NULL";
    private static final String _FINDER_COLUMN_KIELI_KIELI_2 = "kieliinfo.kieli = ?";
    private static final String _FINDER_COLUMN_KIELI_KIELI_3 = "(kieliinfo.kieli IS NULL OR kieliinfo.kieli = '')";
    private static final String _SQL_SELECT_KIELIINFO = "SELECT kieliinfo FROM Kieliinfo kieliinfo";
    private static final String _SQL_SELECT_KIELIINFO_WHERE = "SELECT kieliinfo FROM Kieliinfo kieliinfo WHERE ";
    private static final String _SQL_COUNT_KIELIINFO = "SELECT COUNT(kieliinfo) FROM Kieliinfo kieliinfo";
    private static final String _SQL_COUNT_KIELIINFO_WHERE = "SELECT COUNT(kieliinfo) FROM Kieliinfo kieliinfo WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "kieliinfo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Kieliinfo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Kieliinfo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(KieliinfoPersistenceImpl.class);
    private static Kieliinfo _nullKieliinfo = new KieliinfoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Kieliinfo> toCacheModel() {
                return _nullKieliinfoCacheModel;
            }
        };

    private static CacheModel<Kieliinfo> _nullKieliinfoCacheModel = new CacheModel<Kieliinfo>() {
            @Override
            public Kieliinfo toEntityModel() {
                return _nullKieliinfo;
            }
        };

    public KieliinfoPersistenceImpl() {
        setModelClass(Kieliinfo.class);
    }

    /**
     * Returns the kieliinfo where kieli = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKieliinfoException} if it could not be found.
     *
     * @param kieli the kieli
     * @return the matching kieliinfo
     * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a matching kieliinfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo findByKieli(String kieli)
        throws NoSuchKieliinfoException, SystemException {
        Kieliinfo kieliinfo = fetchByKieli(kieli);

        if (kieliinfo == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("kieli=");
            msg.append(kieli);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchKieliinfoException(msg.toString());
        }

        return kieliinfo;
    }

    /**
     * Returns the kieliinfo where kieli = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param kieli the kieli
     * @return the matching kieliinfo, or <code>null</code> if a matching kieliinfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo fetchByKieli(String kieli) throws SystemException {
        return fetchByKieli(kieli, true);
    }

    /**
     * Returns the kieliinfo where kieli = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param kieli the kieli
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching kieliinfo, or <code>null</code> if a matching kieliinfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo fetchByKieli(String kieli, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { kieli };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KIELI,
                    finderArgs, this);
        }

        if (result instanceof Kieliinfo) {
            Kieliinfo kieliinfo = (Kieliinfo) result;

            if (!Validator.equals(kieli, kieliinfo.getKieli())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_KIELIINFO_WHERE);

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

                List<Kieliinfo> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "KieliinfoPersistenceImpl.fetchByKieli(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Kieliinfo kieliinfo = list.get(0);

                    result = kieliinfo;

                    cacheResult(kieliinfo);

                    if ((kieliinfo.getKieli() == null) ||
                            !kieliinfo.getKieli().equals(kieli)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI,
                            finderArgs, kieliinfo);
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
            return (Kieliinfo) result;
        }
    }

    /**
     * Removes the kieliinfo where kieli = &#63; from the database.
     *
     * @param kieli the kieli
     * @return the kieliinfo that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo removeByKieli(String kieli)
        throws NoSuchKieliinfoException, SystemException {
        Kieliinfo kieliinfo = findByKieli(kieli);

        return remove(kieliinfo);
    }

    /**
     * Returns the number of kieliinfos where kieli = &#63;.
     *
     * @param kieli the kieli
     * @return the number of matching kieliinfos
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

            query.append(_SQL_COUNT_KIELIINFO_WHERE);

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
     * Caches the kieliinfo in the entity cache if it is enabled.
     *
     * @param kieliinfo the kieliinfo
     */
    @Override
    public void cacheResult(Kieliinfo kieliinfo) {
        EntityCacheUtil.putResult(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
            KieliinfoImpl.class, kieliinfo.getPrimaryKey(), kieliinfo);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI,
            new Object[] { kieliinfo.getKieli() }, kieliinfo);

        kieliinfo.resetOriginalValues();
    }

    /**
     * Caches the kieliinfos in the entity cache if it is enabled.
     *
     * @param kieliinfos the kieliinfos
     */
    @Override
    public void cacheResult(List<Kieliinfo> kieliinfos) {
        for (Kieliinfo kieliinfo : kieliinfos) {
            if (EntityCacheUtil.getResult(
                        KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
                        KieliinfoImpl.class, kieliinfo.getPrimaryKey()) == null) {
                cacheResult(kieliinfo);
            } else {
                kieliinfo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all kieliinfos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(KieliinfoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(KieliinfoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the kieliinfo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Kieliinfo kieliinfo) {
        EntityCacheUtil.removeResult(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
            KieliinfoImpl.class, kieliinfo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(kieliinfo);
    }

    @Override
    public void clearCache(List<Kieliinfo> kieliinfos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Kieliinfo kieliinfo : kieliinfos) {
            EntityCacheUtil.removeResult(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
                KieliinfoImpl.class, kieliinfo.getPrimaryKey());

            clearUniqueFindersCache(kieliinfo);
        }
    }

    protected void cacheUniqueFindersCache(Kieliinfo kieliinfo) {
        if (kieliinfo.isNew()) {
            Object[] args = new Object[] { kieliinfo.getKieli() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KIELI, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI, args,
                kieliinfo);
        } else {
            KieliinfoModelImpl kieliinfoModelImpl = (KieliinfoModelImpl) kieliinfo;

            if ((kieliinfoModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_KIELI.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { kieliinfo.getKieli() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KIELI, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KIELI, args,
                    kieliinfo);
            }
        }
    }

    protected void clearUniqueFindersCache(Kieliinfo kieliinfo) {
        KieliinfoModelImpl kieliinfoModelImpl = (KieliinfoModelImpl) kieliinfo;

        Object[] args = new Object[] { kieliinfo.getKieli() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KIELI, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KIELI, args);

        if ((kieliinfoModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_KIELI.getColumnBitmask()) != 0) {
            args = new Object[] { kieliinfoModelImpl.getOriginalKieli() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KIELI, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KIELI, args);
        }
    }

    /**
     * Creates a new kieliinfo with the primary key. Does not add the kieliinfo to the database.
     *
     * @param kieliid the primary key for the new kieliinfo
     * @return the new kieliinfo
     */
    @Override
    public Kieliinfo create(int kieliid) {
        Kieliinfo kieliinfo = new KieliinfoImpl();

        kieliinfo.setNew(true);
        kieliinfo.setPrimaryKey(kieliid);

        return kieliinfo;
    }

    /**
     * Removes the kieliinfo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param kieliid the primary key of the kieliinfo
     * @return the kieliinfo that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a kieliinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo remove(int kieliid)
        throws NoSuchKieliinfoException, SystemException {
        return remove((Serializable) kieliid);
    }

    /**
     * Removes the kieliinfo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the kieliinfo
     * @return the kieliinfo that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a kieliinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo remove(Serializable primaryKey)
        throws NoSuchKieliinfoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Kieliinfo kieliinfo = (Kieliinfo) session.get(KieliinfoImpl.class,
                    primaryKey);

            if (kieliinfo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchKieliinfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(kieliinfo);
        } catch (NoSuchKieliinfoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Kieliinfo removeImpl(Kieliinfo kieliinfo)
        throws SystemException {
        kieliinfo = toUnwrappedModel(kieliinfo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(kieliinfo)) {
                kieliinfo = (Kieliinfo) session.get(KieliinfoImpl.class,
                        kieliinfo.getPrimaryKeyObj());
            }

            if (kieliinfo != null) {
                session.delete(kieliinfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (kieliinfo != null) {
            clearCache(kieliinfo);
        }

        return kieliinfo;
    }

    @Override
    public Kieliinfo updateImpl(fi.csc.avaa.khl.db.model.Kieliinfo kieliinfo)
        throws SystemException {
        kieliinfo = toUnwrappedModel(kieliinfo);

        boolean isNew = kieliinfo.isNew();

        Session session = null;

        try {
            session = openSession();

            if (kieliinfo.isNew()) {
                session.save(kieliinfo);

                kieliinfo.setNew(false);
            } else {
                session.merge(kieliinfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !KieliinfoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
            KieliinfoImpl.class, kieliinfo.getPrimaryKey(), kieliinfo);

        clearUniqueFindersCache(kieliinfo);
        cacheUniqueFindersCache(kieliinfo);

        return kieliinfo;
    }

    protected Kieliinfo toUnwrappedModel(Kieliinfo kieliinfo) {
        if (kieliinfo instanceof KieliinfoImpl) {
            return kieliinfo;
        }

        KieliinfoImpl kieliinfoImpl = new KieliinfoImpl();

        kieliinfoImpl.setNew(kieliinfo.isNew());
        kieliinfoImpl.setPrimaryKey(kieliinfo.getPrimaryKey());

        kieliinfoImpl.setKieliid(kieliinfo.getKieliid());
        kieliinfoImpl.setKieli(kieliinfo.getKieli());

        return kieliinfoImpl;
    }

    /**
     * Returns the kieliinfo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the kieliinfo
     * @return the kieliinfo
     * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a kieliinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchKieliinfoException, SystemException {
        Kieliinfo kieliinfo = fetchByPrimaryKey(primaryKey);

        if (kieliinfo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchKieliinfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return kieliinfo;
    }

    /**
     * Returns the kieliinfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKieliinfoException} if it could not be found.
     *
     * @param kieliid the primary key of the kieliinfo
     * @return the kieliinfo
     * @throws fi.csc.avaa.khl.db.NoSuchKieliinfoException if a kieliinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo findByPrimaryKey(int kieliid)
        throws NoSuchKieliinfoException, SystemException {
        return findByPrimaryKey((Serializable) kieliid);
    }

    /**
     * Returns the kieliinfo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the kieliinfo
     * @return the kieliinfo, or <code>null</code> if a kieliinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Kieliinfo kieliinfo = (Kieliinfo) EntityCacheUtil.getResult(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
                KieliinfoImpl.class, primaryKey);

        if (kieliinfo == _nullKieliinfo) {
            return null;
        }

        if (kieliinfo == null) {
            Session session = null;

            try {
                session = openSession();

                kieliinfo = (Kieliinfo) session.get(KieliinfoImpl.class,
                        primaryKey);

                if (kieliinfo != null) {
                    cacheResult(kieliinfo);
                } else {
                    EntityCacheUtil.putResult(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
                        KieliinfoImpl.class, primaryKey, _nullKieliinfo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(KieliinfoModelImpl.ENTITY_CACHE_ENABLED,
                    KieliinfoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return kieliinfo;
    }

    /**
     * Returns the kieliinfo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param kieliid the primary key of the kieliinfo
     * @return the kieliinfo, or <code>null</code> if a kieliinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kieliinfo fetchByPrimaryKey(int kieliid) throws SystemException {
        return fetchByPrimaryKey((Serializable) kieliid);
    }

    /**
     * Returns all the kieliinfos.
     *
     * @return the kieliinfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kieliinfo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Kieliinfo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Kieliinfo> findAll(int start, int end,
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

        List<Kieliinfo> list = (List<Kieliinfo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_KIELIINFO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_KIELIINFO;

                if (pagination) {
                    sql = sql.concat(KieliinfoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Kieliinfo>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Kieliinfo>(list);
                } else {
                    list = (List<Kieliinfo>) QueryUtil.list(q, getDialect(),
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
     * Removes all the kieliinfos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Kieliinfo kieliinfo : findAll()) {
            remove(kieliinfo);
        }
    }

    /**
     * Returns the number of kieliinfos.
     *
     * @return the number of kieliinfos
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

                Query q = session.createQuery(_SQL_COUNT_KIELIINFO);

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
     * Initializes the kieliinfo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Kieliinfo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Kieliinfo>> listenersList = new ArrayList<ModelListener<Kieliinfo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Kieliinfo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(KieliinfoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
