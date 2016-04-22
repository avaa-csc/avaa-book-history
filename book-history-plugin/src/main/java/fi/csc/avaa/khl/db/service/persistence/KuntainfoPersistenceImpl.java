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

import fi.csc.avaa.khl.db.NoSuchKuntainfoException;
import fi.csc.avaa.khl.db.model.Kuntainfo;
import fi.csc.avaa.khl.db.model.impl.KuntainfoImpl;
import fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl;
import fi.csc.avaa.khl.db.service.persistence.KuntainfoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the kuntainfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KuntainfoPersistence
 * @see KuntainfoUtil
 * @generated
 */
public class KuntainfoPersistenceImpl extends BasePersistenceImpl<Kuntainfo>
    implements KuntainfoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link KuntainfoUtil} to access the kuntainfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = KuntainfoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            KuntainfoModelImpl.FINDER_CACHE_ENABLED, KuntainfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            KuntainfoModelImpl.FINDER_CACHE_ENABLED, KuntainfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            KuntainfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI = new FinderPath(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            KuntainfoModelImpl.FINDER_CACHE_ENABLED, KuntainfoImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByCapitalkuntanimi",
            new String[] { String.class.getName() },
            KuntainfoModelImpl.CAPITALKUNTANIMI_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CAPITALKUNTANIMI = new FinderPath(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            KuntainfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCapitalkuntanimi", new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_1 =
        "kuntainfo.capitalkuntanimi IS NULL";
    private static final String _FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_2 =
        "kuntainfo.capitalkuntanimi = ?";
    private static final String _FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_3 =
        "(kuntainfo.capitalkuntanimi IS NULL OR kuntainfo.capitalkuntanimi = '')";
    private static final String _SQL_SELECT_KUNTAINFO = "SELECT kuntainfo FROM Kuntainfo kuntainfo";
    private static final String _SQL_SELECT_KUNTAINFO_WHERE = "SELECT kuntainfo FROM Kuntainfo kuntainfo WHERE ";
    private static final String _SQL_COUNT_KUNTAINFO = "SELECT COUNT(kuntainfo) FROM Kuntainfo kuntainfo";
    private static final String _SQL_COUNT_KUNTAINFO_WHERE = "SELECT COUNT(kuntainfo) FROM Kuntainfo kuntainfo WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "kuntainfo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Kuntainfo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Kuntainfo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(KuntainfoPersistenceImpl.class);
    private static Kuntainfo _nullKuntainfo = new KuntainfoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Kuntainfo> toCacheModel() {
                return _nullKuntainfoCacheModel;
            }
        };

    private static CacheModel<Kuntainfo> _nullKuntainfoCacheModel = new CacheModel<Kuntainfo>() {
            @Override
            public Kuntainfo toEntityModel() {
                return _nullKuntainfo;
            }
        };

    public KuntainfoPersistenceImpl() {
        setModelClass(Kuntainfo.class);
    }

    /**
     * Returns the kuntainfo where capitalkuntanimi = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntainfoException} if it could not be found.
     *
     * @param capitalkuntanimi the capitalkuntanimi
     * @return the matching kuntainfo
     * @throws fi.csc.avaa.khl.db.NoSuchKuntainfoException if a matching kuntainfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo findByCapitalkuntanimi(String capitalkuntanimi)
        throws NoSuchKuntainfoException, SystemException {
        Kuntainfo kuntainfo = fetchByCapitalkuntanimi(capitalkuntanimi);

        if (kuntainfo == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("capitalkuntanimi=");
            msg.append(capitalkuntanimi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchKuntainfoException(msg.toString());
        }

        return kuntainfo;
    }

    /**
     * Returns the kuntainfo where capitalkuntanimi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param capitalkuntanimi the capitalkuntanimi
     * @return the matching kuntainfo, or <code>null</code> if a matching kuntainfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo fetchByCapitalkuntanimi(String capitalkuntanimi)
        throws SystemException {
        return fetchByCapitalkuntanimi(capitalkuntanimi, true);
    }

    /**
     * Returns the kuntainfo where capitalkuntanimi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param capitalkuntanimi the capitalkuntanimi
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching kuntainfo, or <code>null</code> if a matching kuntainfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo fetchByCapitalkuntanimi(String capitalkuntanimi,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { capitalkuntanimi };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI,
                    finderArgs, this);
        }

        if (result instanceof Kuntainfo) {
            Kuntainfo kuntainfo = (Kuntainfo) result;

            if (!Validator.equals(capitalkuntanimi,
                        kuntainfo.getCapitalkuntanimi())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_KUNTAINFO_WHERE);

            boolean bindCapitalkuntanimi = false;

            if (capitalkuntanimi == null) {
                query.append(_FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_1);
            } else if (capitalkuntanimi.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_3);
            } else {
                bindCapitalkuntanimi = true;

                query.append(_FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCapitalkuntanimi) {
                    qPos.add(capitalkuntanimi);
                }

                List<Kuntainfo> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "KuntainfoPersistenceImpl.fetchByCapitalkuntanimi(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Kuntainfo kuntainfo = list.get(0);

                    result = kuntainfo;

                    cacheResult(kuntainfo);

                    if ((kuntainfo.getCapitalkuntanimi() == null) ||
                            !kuntainfo.getCapitalkuntanimi()
                                          .equals(capitalkuntanimi)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI,
                            finderArgs, kuntainfo);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Kuntainfo) result;
        }
    }

    /**
     * Removes the kuntainfo where capitalkuntanimi = &#63; from the database.
     *
     * @param capitalkuntanimi the capitalkuntanimi
     * @return the kuntainfo that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo removeByCapitalkuntanimi(String capitalkuntanimi)
        throws NoSuchKuntainfoException, SystemException {
        Kuntainfo kuntainfo = findByCapitalkuntanimi(capitalkuntanimi);

        return remove(kuntainfo);
    }

    /**
     * Returns the number of kuntainfos where capitalkuntanimi = &#63;.
     *
     * @param capitalkuntanimi the capitalkuntanimi
     * @return the number of matching kuntainfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCapitalkuntanimi(String capitalkuntanimi)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CAPITALKUNTANIMI;

        Object[] finderArgs = new Object[] { capitalkuntanimi };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_KUNTAINFO_WHERE);

            boolean bindCapitalkuntanimi = false;

            if (capitalkuntanimi == null) {
                query.append(_FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_1);
            } else if (capitalkuntanimi.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_3);
            } else {
                bindCapitalkuntanimi = true;

                query.append(_FINDER_COLUMN_CAPITALKUNTANIMI_CAPITALKUNTANIMI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCapitalkuntanimi) {
                    qPos.add(capitalkuntanimi);
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
     * Caches the kuntainfo in the entity cache if it is enabled.
     *
     * @param kuntainfo the kuntainfo
     */
    @Override
    public void cacheResult(Kuntainfo kuntainfo) {
        EntityCacheUtil.putResult(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            KuntainfoImpl.class, kuntainfo.getPrimaryKey(), kuntainfo);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI,
            new Object[] { kuntainfo.getCapitalkuntanimi() }, kuntainfo);

        kuntainfo.resetOriginalValues();
    }

    /**
     * Caches the kuntainfos in the entity cache if it is enabled.
     *
     * @param kuntainfos the kuntainfos
     */
    @Override
    public void cacheResult(List<Kuntainfo> kuntainfos) {
        for (Kuntainfo kuntainfo : kuntainfos) {
            if (EntityCacheUtil.getResult(
                        KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                        KuntainfoImpl.class, kuntainfo.getPrimaryKey()) == null) {
                cacheResult(kuntainfo);
            } else {
                kuntainfo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all kuntainfos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(KuntainfoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(KuntainfoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the kuntainfo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Kuntainfo kuntainfo) {
        EntityCacheUtil.removeResult(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            KuntainfoImpl.class, kuntainfo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(kuntainfo);
    }

    @Override
    public void clearCache(List<Kuntainfo> kuntainfos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Kuntainfo kuntainfo : kuntainfos) {
            EntityCacheUtil.removeResult(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                KuntainfoImpl.class, kuntainfo.getPrimaryKey());

            clearUniqueFindersCache(kuntainfo);
        }
    }

    protected void cacheUniqueFindersCache(Kuntainfo kuntainfo) {
        if (kuntainfo.isNew()) {
            Object[] args = new Object[] { kuntainfo.getCapitalkuntanimi() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAPITALKUNTANIMI,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI,
                args, kuntainfo);
        } else {
            KuntainfoModelImpl kuntainfoModelImpl = (KuntainfoModelImpl) kuntainfo;

            if ((kuntainfoModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { kuntainfo.getCapitalkuntanimi() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAPITALKUNTANIMI,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI,
                    args, kuntainfo);
            }
        }
    }

    protected void clearUniqueFindersCache(Kuntainfo kuntainfo) {
        KuntainfoModelImpl kuntainfoModelImpl = (KuntainfoModelImpl) kuntainfo;

        Object[] args = new Object[] { kuntainfo.getCapitalkuntanimi() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAPITALKUNTANIMI, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI, args);

        if ((kuntainfoModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI.getColumnBitmask()) != 0) {
            args = new Object[] { kuntainfoModelImpl.getOriginalCapitalkuntanimi() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAPITALKUNTANIMI,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAPITALKUNTANIMI,
                args);
        }
    }

    /**
     * Creates a new kuntainfo with the primary key. Does not add the kuntainfo to the database.
     *
     * @param kuntaid the primary key for the new kuntainfo
     * @return the new kuntainfo
     */
    @Override
    public Kuntainfo create(int kuntaid) {
        Kuntainfo kuntainfo = new KuntainfoImpl();

        kuntainfo.setNew(true);
        kuntainfo.setPrimaryKey(kuntaid);

        return kuntainfo;
    }

    /**
     * Removes the kuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param kuntaid the primary key of the kuntainfo
     * @return the kuntainfo that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKuntainfoException if a kuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo remove(int kuntaid)
        throws NoSuchKuntainfoException, SystemException {
        return remove((Serializable) kuntaid);
    }

    /**
     * Removes the kuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the kuntainfo
     * @return the kuntainfo that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKuntainfoException if a kuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo remove(Serializable primaryKey)
        throws NoSuchKuntainfoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Kuntainfo kuntainfo = (Kuntainfo) session.get(KuntainfoImpl.class,
                    primaryKey);

            if (kuntainfo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchKuntainfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(kuntainfo);
        } catch (NoSuchKuntainfoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Kuntainfo removeImpl(Kuntainfo kuntainfo)
        throws SystemException {
        kuntainfo = toUnwrappedModel(kuntainfo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(kuntainfo)) {
                kuntainfo = (Kuntainfo) session.get(KuntainfoImpl.class,
                        kuntainfo.getPrimaryKeyObj());
            }

            if (kuntainfo != null) {
                session.delete(kuntainfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (kuntainfo != null) {
            clearCache(kuntainfo);
        }

        return kuntainfo;
    }

    @Override
    public Kuntainfo updateImpl(fi.csc.avaa.khl.db.model.Kuntainfo kuntainfo)
        throws SystemException {
        kuntainfo = toUnwrappedModel(kuntainfo);

        boolean isNew = kuntainfo.isNew();

        Session session = null;

        try {
            session = openSession();

            if (kuntainfo.isNew()) {
                session.save(kuntainfo);

                kuntainfo.setNew(false);
            } else {
                session.merge(kuntainfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !KuntainfoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            KuntainfoImpl.class, kuntainfo.getPrimaryKey(), kuntainfo);

        clearUniqueFindersCache(kuntainfo);
        cacheUniqueFindersCache(kuntainfo);

        return kuntainfo;
    }

    protected Kuntainfo toUnwrappedModel(Kuntainfo kuntainfo) {
        if (kuntainfo instanceof KuntainfoImpl) {
            return kuntainfo;
        }

        KuntainfoImpl kuntainfoImpl = new KuntainfoImpl();

        kuntainfoImpl.setNew(kuntainfo.isNew());
        kuntainfoImpl.setPrimaryKey(kuntainfo.getPrimaryKey());

        kuntainfoImpl.setKuntaid(kuntainfo.getKuntaid());
        kuntainfoImpl.setCapitalkuntanimi(kuntainfo.getCapitalkuntanimi());
        kuntainfoImpl.setKpl(kuntainfo.getKpl());
        kuntainfoImpl.setKuntanimi(kuntainfo.getKuntanimi());
        kuntainfoImpl.setMaakuntaid(kuntainfo.getMaakuntaid());
        kuntainfoImpl.setKuntano(kuntainfo.getKuntano());
        kuntainfoImpl.setKuntanimi_2014(kuntainfo.getKuntanimi_2014());

        return kuntainfoImpl;
    }

    /**
     * Returns the kuntainfo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the kuntainfo
     * @return the kuntainfo
     * @throws fi.csc.avaa.khl.db.NoSuchKuntainfoException if a kuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchKuntainfoException, SystemException {
        Kuntainfo kuntainfo = fetchByPrimaryKey(primaryKey);

        if (kuntainfo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchKuntainfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return kuntainfo;
    }

    /**
     * Returns the kuntainfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKuntainfoException} if it could not be found.
     *
     * @param kuntaid the primary key of the kuntainfo
     * @return the kuntainfo
     * @throws fi.csc.avaa.khl.db.NoSuchKuntainfoException if a kuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo findByPrimaryKey(int kuntaid)
        throws NoSuchKuntainfoException, SystemException {
        return findByPrimaryKey((Serializable) kuntaid);
    }

    /**
     * Returns the kuntainfo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the kuntainfo
     * @return the kuntainfo, or <code>null</code> if a kuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Kuntainfo kuntainfo = (Kuntainfo) EntityCacheUtil.getResult(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                KuntainfoImpl.class, primaryKey);

        if (kuntainfo == _nullKuntainfo) {
            return null;
        }

        if (kuntainfo == null) {
            Session session = null;

            try {
                session = openSession();

                kuntainfo = (Kuntainfo) session.get(KuntainfoImpl.class,
                        primaryKey);

                if (kuntainfo != null) {
                    cacheResult(kuntainfo);
                } else {
                    EntityCacheUtil.putResult(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                        KuntainfoImpl.class, primaryKey, _nullKuntainfo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(KuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                    KuntainfoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return kuntainfo;
    }

    /**
     * Returns the kuntainfo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param kuntaid the primary key of the kuntainfo
     * @return the kuntainfo, or <code>null</code> if a kuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kuntainfo fetchByPrimaryKey(int kuntaid) throws SystemException {
        return fetchByPrimaryKey((Serializable) kuntaid);
    }

    /**
     * Returns all the kuntainfos.
     *
     * @return the kuntainfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kuntainfo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the kuntainfos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of kuntainfos
     * @param end the upper bound of the range of kuntainfos (not inclusive)
     * @return the range of kuntainfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kuntainfo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the kuntainfos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KuntainfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of kuntainfos
     * @param end the upper bound of the range of kuntainfos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of kuntainfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kuntainfo> findAll(int start, int end,
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

        List<Kuntainfo> list = (List<Kuntainfo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_KUNTAINFO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_KUNTAINFO;

                if (pagination) {
                    sql = sql.concat(KuntainfoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Kuntainfo>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Kuntainfo>(list);
                } else {
                    list = (List<Kuntainfo>) QueryUtil.list(q, getDialect(),
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
     * Removes all the kuntainfos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Kuntainfo kuntainfo : findAll()) {
            remove(kuntainfo);
        }
    }

    /**
     * Returns the number of kuntainfos.
     *
     * @return the number of kuntainfos
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

                Query q = session.createQuery(_SQL_COUNT_KUNTAINFO);

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
     * Initializes the kuntainfo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Kuntainfo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Kuntainfo>> listenersList = new ArrayList<ModelListener<Kuntainfo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Kuntainfo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(KuntainfoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
