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

import fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException;
import fi.csc.avaa.khl.db.model.Julkaisulajiinfo;
import fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoImpl;
import fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoModelImpl;
import fi.csc.avaa.khl.db.service.persistence.JulkaisulajiinfoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the julkaisulajiinfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see JulkaisulajiinfoPersistence
 * @see JulkaisulajiinfoUtil
 * @generated
 */
public class JulkaisulajiinfoPersistenceImpl extends BasePersistenceImpl<Julkaisulajiinfo>
    implements JulkaisulajiinfoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link JulkaisulajiinfoUtil} to access the julkaisulajiinfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = JulkaisulajiinfoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
            JulkaisulajiinfoModelImpl.FINDER_CACHE_ENABLED,
            JulkaisulajiinfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
            JulkaisulajiinfoModelImpl.FINDER_CACHE_ENABLED,
            JulkaisulajiinfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
            JulkaisulajiinfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_JULKLAJI = new FinderPath(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
            JulkaisulajiinfoModelImpl.FINDER_CACHE_ENABLED,
            JulkaisulajiinfoImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByJulklaji", new String[] { String.class.getName() },
            JulkaisulajiinfoModelImpl.JULKLAJI_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_JULKLAJI = new FinderPath(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
            JulkaisulajiinfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJulklaji",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_JULKLAJI_JULKLAJI_1 = "julkaisulajiinfo.julklaji IS NULL";
    private static final String _FINDER_COLUMN_JULKLAJI_JULKLAJI_2 = "julkaisulajiinfo.julklaji = ?";
    private static final String _FINDER_COLUMN_JULKLAJI_JULKLAJI_3 = "(julkaisulajiinfo.julklaji IS NULL OR julkaisulajiinfo.julklaji = '')";
    private static final String _SQL_SELECT_JULKAISULAJIINFO = "SELECT julkaisulajiinfo FROM Julkaisulajiinfo julkaisulajiinfo";
    private static final String _SQL_SELECT_JULKAISULAJIINFO_WHERE = "SELECT julkaisulajiinfo FROM Julkaisulajiinfo julkaisulajiinfo WHERE ";
    private static final String _SQL_COUNT_JULKAISULAJIINFO = "SELECT COUNT(julkaisulajiinfo) FROM Julkaisulajiinfo julkaisulajiinfo";
    private static final String _SQL_COUNT_JULKAISULAJIINFO_WHERE = "SELECT COUNT(julkaisulajiinfo) FROM Julkaisulajiinfo julkaisulajiinfo WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "julkaisulajiinfo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Julkaisulajiinfo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Julkaisulajiinfo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(JulkaisulajiinfoPersistenceImpl.class);
    private static Julkaisulajiinfo _nullJulkaisulajiinfo = new JulkaisulajiinfoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Julkaisulajiinfo> toCacheModel() {
                return _nullJulkaisulajiinfoCacheModel;
            }
        };

    private static CacheModel<Julkaisulajiinfo> _nullJulkaisulajiinfoCacheModel = new CacheModel<Julkaisulajiinfo>() {
            @Override
            public Julkaisulajiinfo toEntityModel() {
                return _nullJulkaisulajiinfo;
            }
        };

    public JulkaisulajiinfoPersistenceImpl() {
        setModelClass(Julkaisulajiinfo.class);
    }

    /**
     * Returns the julkaisulajiinfo where julklaji = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException} if it could not be found.
     *
     * @param julklaji the julklaji
     * @return the matching julkaisulajiinfo
     * @throws fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException if a matching julkaisulajiinfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo findByJulklaji(String julklaji)
        throws NoSuchJulkaisulajiinfoException, SystemException {
        Julkaisulajiinfo julkaisulajiinfo = fetchByJulklaji(julklaji);

        if (julkaisulajiinfo == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("julklaji=");
            msg.append(julklaji);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchJulkaisulajiinfoException(msg.toString());
        }

        return julkaisulajiinfo;
    }

    /**
     * Returns the julkaisulajiinfo where julklaji = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param julklaji the julklaji
     * @return the matching julkaisulajiinfo, or <code>null</code> if a matching julkaisulajiinfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo fetchByJulklaji(String julklaji)
        throws SystemException {
        return fetchByJulklaji(julklaji, true);
    }

    /**
     * Returns the julkaisulajiinfo where julklaji = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param julklaji the julklaji
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching julkaisulajiinfo, or <code>null</code> if a matching julkaisulajiinfo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo fetchByJulklaji(String julklaji,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { julklaji };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_JULKLAJI,
                    finderArgs, this);
        }

        if (result instanceof Julkaisulajiinfo) {
            Julkaisulajiinfo julkaisulajiinfo = (Julkaisulajiinfo) result;

            if (!Validator.equals(julklaji, julkaisulajiinfo.getJulklaji())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_JULKAISULAJIINFO_WHERE);

            boolean bindJulklaji = false;

            if (julklaji == null) {
                query.append(_FINDER_COLUMN_JULKLAJI_JULKLAJI_1);
            } else if (julklaji.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_JULKLAJI_JULKLAJI_3);
            } else {
                bindJulklaji = true;

                query.append(_FINDER_COLUMN_JULKLAJI_JULKLAJI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindJulklaji) {
                    qPos.add(julklaji);
                }

                List<Julkaisulajiinfo> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JULKLAJI,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "JulkaisulajiinfoPersistenceImpl.fetchByJulklaji(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Julkaisulajiinfo julkaisulajiinfo = list.get(0);

                    result = julkaisulajiinfo;

                    cacheResult(julkaisulajiinfo);

                    if ((julkaisulajiinfo.getJulklaji() == null) ||
                            !julkaisulajiinfo.getJulklaji().equals(julklaji)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JULKLAJI,
                            finderArgs, julkaisulajiinfo);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JULKLAJI,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Julkaisulajiinfo) result;
        }
    }

    /**
     * Removes the julkaisulajiinfo where julklaji = &#63; from the database.
     *
     * @param julklaji the julklaji
     * @return the julkaisulajiinfo that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo removeByJulklaji(String julklaji)
        throws NoSuchJulkaisulajiinfoException, SystemException {
        Julkaisulajiinfo julkaisulajiinfo = findByJulklaji(julklaji);

        return remove(julkaisulajiinfo);
    }

    /**
     * Returns the number of julkaisulajiinfos where julklaji = &#63;.
     *
     * @param julklaji the julklaji
     * @return the number of matching julkaisulajiinfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByJulklaji(String julklaji) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_JULKLAJI;

        Object[] finderArgs = new Object[] { julklaji };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_JULKAISULAJIINFO_WHERE);

            boolean bindJulklaji = false;

            if (julklaji == null) {
                query.append(_FINDER_COLUMN_JULKLAJI_JULKLAJI_1);
            } else if (julklaji.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_JULKLAJI_JULKLAJI_3);
            } else {
                bindJulklaji = true;

                query.append(_FINDER_COLUMN_JULKLAJI_JULKLAJI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindJulklaji) {
                    qPos.add(julklaji);
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
     * Caches the julkaisulajiinfo in the entity cache if it is enabled.
     *
     * @param julkaisulajiinfo the julkaisulajiinfo
     */
    @Override
    public void cacheResult(Julkaisulajiinfo julkaisulajiinfo) {
        EntityCacheUtil.putResult(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
            JulkaisulajiinfoImpl.class, julkaisulajiinfo.getPrimaryKey(),
            julkaisulajiinfo);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JULKLAJI,
            new Object[] { julkaisulajiinfo.getJulklaji() }, julkaisulajiinfo);

        julkaisulajiinfo.resetOriginalValues();
    }

    /**
     * Caches the julkaisulajiinfos in the entity cache if it is enabled.
     *
     * @param julkaisulajiinfos the julkaisulajiinfos
     */
    @Override
    public void cacheResult(List<Julkaisulajiinfo> julkaisulajiinfos) {
        for (Julkaisulajiinfo julkaisulajiinfo : julkaisulajiinfos) {
            if (EntityCacheUtil.getResult(
                        JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
                        JulkaisulajiinfoImpl.class,
                        julkaisulajiinfo.getPrimaryKey()) == null) {
                cacheResult(julkaisulajiinfo);
            } else {
                julkaisulajiinfo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all julkaisulajiinfos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(JulkaisulajiinfoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(JulkaisulajiinfoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the julkaisulajiinfo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Julkaisulajiinfo julkaisulajiinfo) {
        EntityCacheUtil.removeResult(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
            JulkaisulajiinfoImpl.class, julkaisulajiinfo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(julkaisulajiinfo);
    }

    @Override
    public void clearCache(List<Julkaisulajiinfo> julkaisulajiinfos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Julkaisulajiinfo julkaisulajiinfo : julkaisulajiinfos) {
            EntityCacheUtil.removeResult(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
                JulkaisulajiinfoImpl.class, julkaisulajiinfo.getPrimaryKey());

            clearUniqueFindersCache(julkaisulajiinfo);
        }
    }

    protected void cacheUniqueFindersCache(Julkaisulajiinfo julkaisulajiinfo) {
        if (julkaisulajiinfo.isNew()) {
            Object[] args = new Object[] { julkaisulajiinfo.getJulklaji() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JULKLAJI, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JULKLAJI, args,
                julkaisulajiinfo);
        } else {
            JulkaisulajiinfoModelImpl julkaisulajiinfoModelImpl = (JulkaisulajiinfoModelImpl) julkaisulajiinfo;

            if ((julkaisulajiinfoModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_JULKLAJI.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { julkaisulajiinfo.getJulklaji() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JULKLAJI, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JULKLAJI, args,
                    julkaisulajiinfo);
            }
        }
    }

    protected void clearUniqueFindersCache(Julkaisulajiinfo julkaisulajiinfo) {
        JulkaisulajiinfoModelImpl julkaisulajiinfoModelImpl = (JulkaisulajiinfoModelImpl) julkaisulajiinfo;

        Object[] args = new Object[] { julkaisulajiinfo.getJulklaji() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JULKLAJI, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JULKLAJI, args);

        if ((julkaisulajiinfoModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_JULKLAJI.getColumnBitmask()) != 0) {
            args = new Object[] { julkaisulajiinfoModelImpl.getOriginalJulklaji() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JULKLAJI, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JULKLAJI, args);
        }
    }

    /**
     * Creates a new julkaisulajiinfo with the primary key. Does not add the julkaisulajiinfo to the database.
     *
     * @param julklajiid the primary key for the new julkaisulajiinfo
     * @return the new julkaisulajiinfo
     */
    @Override
    public Julkaisulajiinfo create(int julklajiid) {
        Julkaisulajiinfo julkaisulajiinfo = new JulkaisulajiinfoImpl();

        julkaisulajiinfo.setNew(true);
        julkaisulajiinfo.setPrimaryKey(julklajiid);

        return julkaisulajiinfo;
    }

    /**
     * Removes the julkaisulajiinfo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param julklajiid the primary key of the julkaisulajiinfo
     * @return the julkaisulajiinfo that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException if a julkaisulajiinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo remove(int julklajiid)
        throws NoSuchJulkaisulajiinfoException, SystemException {
        return remove((Serializable) julklajiid);
    }

    /**
     * Removes the julkaisulajiinfo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the julkaisulajiinfo
     * @return the julkaisulajiinfo that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException if a julkaisulajiinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo remove(Serializable primaryKey)
        throws NoSuchJulkaisulajiinfoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Julkaisulajiinfo julkaisulajiinfo = (Julkaisulajiinfo) session.get(JulkaisulajiinfoImpl.class,
                    primaryKey);

            if (julkaisulajiinfo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchJulkaisulajiinfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(julkaisulajiinfo);
        } catch (NoSuchJulkaisulajiinfoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Julkaisulajiinfo removeImpl(Julkaisulajiinfo julkaisulajiinfo)
        throws SystemException {
        julkaisulajiinfo = toUnwrappedModel(julkaisulajiinfo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(julkaisulajiinfo)) {
                julkaisulajiinfo = (Julkaisulajiinfo) session.get(JulkaisulajiinfoImpl.class,
                        julkaisulajiinfo.getPrimaryKeyObj());
            }

            if (julkaisulajiinfo != null) {
                session.delete(julkaisulajiinfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (julkaisulajiinfo != null) {
            clearCache(julkaisulajiinfo);
        }

        return julkaisulajiinfo;
    }

    @Override
    public Julkaisulajiinfo updateImpl(
        fi.csc.avaa.khl.db.model.Julkaisulajiinfo julkaisulajiinfo)
        throws SystemException {
        julkaisulajiinfo = toUnwrappedModel(julkaisulajiinfo);

        boolean isNew = julkaisulajiinfo.isNew();

        Session session = null;

        try {
            session = openSession();

            if (julkaisulajiinfo.isNew()) {
                session.save(julkaisulajiinfo);

                julkaisulajiinfo.setNew(false);
            } else {
                session.merge(julkaisulajiinfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !JulkaisulajiinfoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
            JulkaisulajiinfoImpl.class, julkaisulajiinfo.getPrimaryKey(),
            julkaisulajiinfo);

        clearUniqueFindersCache(julkaisulajiinfo);
        cacheUniqueFindersCache(julkaisulajiinfo);

        return julkaisulajiinfo;
    }

    protected Julkaisulajiinfo toUnwrappedModel(
        Julkaisulajiinfo julkaisulajiinfo) {
        if (julkaisulajiinfo instanceof JulkaisulajiinfoImpl) {
            return julkaisulajiinfo;
        }

        JulkaisulajiinfoImpl julkaisulajiinfoImpl = new JulkaisulajiinfoImpl();

        julkaisulajiinfoImpl.setNew(julkaisulajiinfo.isNew());
        julkaisulajiinfoImpl.setPrimaryKey(julkaisulajiinfo.getPrimaryKey());

        julkaisulajiinfoImpl.setJulklajiid(julkaisulajiinfo.getJulklajiid());
        julkaisulajiinfoImpl.setJulklaji(julkaisulajiinfo.getJulklaji());

        return julkaisulajiinfoImpl;
    }

    /**
     * Returns the julkaisulajiinfo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the julkaisulajiinfo
     * @return the julkaisulajiinfo
     * @throws fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException if a julkaisulajiinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchJulkaisulajiinfoException, SystemException {
        Julkaisulajiinfo julkaisulajiinfo = fetchByPrimaryKey(primaryKey);

        if (julkaisulajiinfo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchJulkaisulajiinfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return julkaisulajiinfo;
    }

    /**
     * Returns the julkaisulajiinfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException} if it could not be found.
     *
     * @param julklajiid the primary key of the julkaisulajiinfo
     * @return the julkaisulajiinfo
     * @throws fi.csc.avaa.khl.db.NoSuchJulkaisulajiinfoException if a julkaisulajiinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo findByPrimaryKey(int julklajiid)
        throws NoSuchJulkaisulajiinfoException, SystemException {
        return findByPrimaryKey((Serializable) julklajiid);
    }

    /**
     * Returns the julkaisulajiinfo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the julkaisulajiinfo
     * @return the julkaisulajiinfo, or <code>null</code> if a julkaisulajiinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Julkaisulajiinfo julkaisulajiinfo = (Julkaisulajiinfo) EntityCacheUtil.getResult(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
                JulkaisulajiinfoImpl.class, primaryKey);

        if (julkaisulajiinfo == _nullJulkaisulajiinfo) {
            return null;
        }

        if (julkaisulajiinfo == null) {
            Session session = null;

            try {
                session = openSession();

                julkaisulajiinfo = (Julkaisulajiinfo) session.get(JulkaisulajiinfoImpl.class,
                        primaryKey);

                if (julkaisulajiinfo != null) {
                    cacheResult(julkaisulajiinfo);
                } else {
                    EntityCacheUtil.putResult(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
                        JulkaisulajiinfoImpl.class, primaryKey,
                        _nullJulkaisulajiinfo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(JulkaisulajiinfoModelImpl.ENTITY_CACHE_ENABLED,
                    JulkaisulajiinfoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return julkaisulajiinfo;
    }

    /**
     * Returns the julkaisulajiinfo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param julklajiid the primary key of the julkaisulajiinfo
     * @return the julkaisulajiinfo, or <code>null</code> if a julkaisulajiinfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Julkaisulajiinfo fetchByPrimaryKey(int julklajiid)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) julklajiid);
    }

    /**
     * Returns all the julkaisulajiinfos.
     *
     * @return the julkaisulajiinfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Julkaisulajiinfo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the julkaisulajiinfos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of julkaisulajiinfos
     * @param end the upper bound of the range of julkaisulajiinfos (not inclusive)
     * @return the range of julkaisulajiinfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Julkaisulajiinfo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the julkaisulajiinfos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.JulkaisulajiinfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of julkaisulajiinfos
     * @param end the upper bound of the range of julkaisulajiinfos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of julkaisulajiinfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Julkaisulajiinfo> findAll(int start, int end,
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

        List<Julkaisulajiinfo> list = (List<Julkaisulajiinfo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_JULKAISULAJIINFO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_JULKAISULAJIINFO;

                if (pagination) {
                    sql = sql.concat(JulkaisulajiinfoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Julkaisulajiinfo>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Julkaisulajiinfo>(list);
                } else {
                    list = (List<Julkaisulajiinfo>) QueryUtil.list(q,
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
     * Removes all the julkaisulajiinfos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Julkaisulajiinfo julkaisulajiinfo : findAll()) {
            remove(julkaisulajiinfo);
        }
    }

    /**
     * Returns the number of julkaisulajiinfos.
     *
     * @return the number of julkaisulajiinfos
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

                Query q = session.createQuery(_SQL_COUNT_JULKAISULAJIINFO);

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
     * Initializes the julkaisulajiinfo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Julkaisulajiinfo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Julkaisulajiinfo>> listenersList = new ArrayList<ModelListener<Julkaisulajiinfo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Julkaisulajiinfo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(JulkaisulajiinfoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
