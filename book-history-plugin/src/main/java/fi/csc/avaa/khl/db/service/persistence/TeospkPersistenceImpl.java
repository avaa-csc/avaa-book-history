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

import fi.csc.avaa.khl.db.NoSuchTeospkException;
import fi.csc.avaa.khl.db.model.Teospk;
import fi.csc.avaa.khl.db.model.impl.TeospkImpl;
import fi.csc.avaa.khl.db.model.impl.TeospkModelImpl;
import fi.csc.avaa.khl.db.service.persistence.TeospkPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the teospk service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see TeospkPersistence
 * @see TeospkUtil
 * @generated
 */
public class TeospkPersistenceImpl extends BasePersistenceImpl<Teospk>
    implements TeospkPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TeospkUtil} to access the teospk persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TeospkImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TeospkModelImpl.ENTITY_CACHE_ENABLED,
            TeospkModelImpl.FINDER_CACHE_ENABLED, TeospkImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TeospkModelImpl.ENTITY_CACHE_ENABLED,
            TeospkModelImpl.FINDER_CACHE_ENABLED, TeospkImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TeospkModelImpl.ENTITY_CACHE_ENABLED,
            TeospkModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_TEOSPKNIMI = new FinderPath(TeospkModelImpl.ENTITY_CACHE_ENABLED,
            TeospkModelImpl.FINDER_CACHE_ENABLED, TeospkImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByTeospknimi",
            new String[] { String.class.getName() },
            TeospkModelImpl.TEOSPKNIMI_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TEOSPKNIMI = new FinderPath(TeospkModelImpl.ENTITY_CACHE_ENABLED,
            TeospkModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTeospknimi",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_1 = "teospk.teospknimi IS NULL";
    private static final String _FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_2 = "teospk.teospknimi = ?";
    private static final String _FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_3 = "(teospk.teospknimi IS NULL OR teospk.teospknimi = '')";
    private static final String _SQL_SELECT_TEOSPK = "SELECT teospk FROM Teospk teospk";
    private static final String _SQL_SELECT_TEOSPK_WHERE = "SELECT teospk FROM Teospk teospk WHERE ";
    private static final String _SQL_COUNT_TEOSPK = "SELECT COUNT(teospk) FROM Teospk teospk";
    private static final String _SQL_COUNT_TEOSPK_WHERE = "SELECT COUNT(teospk) FROM Teospk teospk WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "teospk.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Teospk exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Teospk exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TeospkPersistenceImpl.class);
    private static Teospk _nullTeospk = new TeospkImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Teospk> toCacheModel() {
                return _nullTeospkCacheModel;
            }
        };

    private static CacheModel<Teospk> _nullTeospkCacheModel = new CacheModel<Teospk>() {
            @Override
            public Teospk toEntityModel() {
                return _nullTeospk;
            }
        };

    public TeospkPersistenceImpl() {
        setModelClass(Teospk.class);
    }

    /**
     * Returns the teospk where teospknimi = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchTeospkException} if it could not be found.
     *
     * @param teospknimi the teospknimi
     * @return the matching teospk
     * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a matching teospk could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk findByTeospknimi(String teospknimi)
        throws NoSuchTeospkException, SystemException {
        Teospk teospk = fetchByTeospknimi(teospknimi);

        if (teospk == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("teospknimi=");
            msg.append(teospknimi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchTeospkException(msg.toString());
        }

        return teospk;
    }

    /**
     * Returns the teospk where teospknimi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param teospknimi the teospknimi
     * @return the matching teospk, or <code>null</code> if a matching teospk could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk fetchByTeospknimi(String teospknimi)
        throws SystemException {
        return fetchByTeospknimi(teospknimi, true);
    }

    /**
     * Returns the teospk where teospknimi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param teospknimi the teospknimi
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching teospk, or <code>null</code> if a matching teospk could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk fetchByTeospknimi(String teospknimi, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { teospknimi };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI,
                    finderArgs, this);
        }

        if (result instanceof Teospk) {
            Teospk teospk = (Teospk) result;

            if (!Validator.equals(teospknimi, teospk.getTeospknimi())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_TEOSPK_WHERE);

            boolean bindTeospknimi = false;

            if (teospknimi == null) {
                query.append(_FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_1);
            } else if (teospknimi.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_3);
            } else {
                bindTeospknimi = true;

                query.append(_FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTeospknimi) {
                    qPos.add(teospknimi);
                }

                List<Teospk> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "TeospkPersistenceImpl.fetchByTeospknimi(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Teospk teospk = list.get(0);

                    result = teospk;

                    cacheResult(teospk);

                    if ((teospk.getTeospknimi() == null) ||
                            !teospk.getTeospknimi().equals(teospknimi)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI,
                            finderArgs, teospk);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Teospk) result;
        }
    }

    /**
     * Removes the teospk where teospknimi = &#63; from the database.
     *
     * @param teospknimi the teospknimi
     * @return the teospk that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk removeByTeospknimi(String teospknimi)
        throws NoSuchTeospkException, SystemException {
        Teospk teospk = findByTeospknimi(teospknimi);

        return remove(teospk);
    }

    /**
     * Returns the number of teospks where teospknimi = &#63;.
     *
     * @param teospknimi the teospknimi
     * @return the number of matching teospks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTeospknimi(String teospknimi) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TEOSPKNIMI;

        Object[] finderArgs = new Object[] { teospknimi };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TEOSPK_WHERE);

            boolean bindTeospknimi = false;

            if (teospknimi == null) {
                query.append(_FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_1);
            } else if (teospknimi.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_3);
            } else {
                bindTeospknimi = true;

                query.append(_FINDER_COLUMN_TEOSPKNIMI_TEOSPKNIMI_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTeospknimi) {
                    qPos.add(teospknimi);
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
     * Caches the teospk in the entity cache if it is enabled.
     *
     * @param teospk the teospk
     */
    @Override
    public void cacheResult(Teospk teospk) {
        EntityCacheUtil.putResult(TeospkModelImpl.ENTITY_CACHE_ENABLED,
            TeospkImpl.class, teospk.getPrimaryKey(), teospk);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI,
            new Object[] { teospk.getTeospknimi() }, teospk);

        teospk.resetOriginalValues();
    }

    /**
     * Caches the teospks in the entity cache if it is enabled.
     *
     * @param teospks the teospks
     */
    @Override
    public void cacheResult(List<Teospk> teospks) {
        for (Teospk teospk : teospks) {
            if (EntityCacheUtil.getResult(
                        TeospkModelImpl.ENTITY_CACHE_ENABLED, TeospkImpl.class,
                        teospk.getPrimaryKey()) == null) {
                cacheResult(teospk);
            } else {
                teospk.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all teospks.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TeospkImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TeospkImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the teospk.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Teospk teospk) {
        EntityCacheUtil.removeResult(TeospkModelImpl.ENTITY_CACHE_ENABLED,
            TeospkImpl.class, teospk.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(teospk);
    }

    @Override
    public void clearCache(List<Teospk> teospks) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Teospk teospk : teospks) {
            EntityCacheUtil.removeResult(TeospkModelImpl.ENTITY_CACHE_ENABLED,
                TeospkImpl.class, teospk.getPrimaryKey());

            clearUniqueFindersCache(teospk);
        }
    }

    protected void cacheUniqueFindersCache(Teospk teospk) {
        if (teospk.isNew()) {
            Object[] args = new Object[] { teospk.getTeospknimi() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEOSPKNIMI, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI, args,
                teospk);
        } else {
            TeospkModelImpl teospkModelImpl = (TeospkModelImpl) teospk;

            if ((teospkModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TEOSPKNIMI.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { teospk.getTeospknimi() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEOSPKNIMI,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI,
                    args, teospk);
            }
        }
    }

    protected void clearUniqueFindersCache(Teospk teospk) {
        TeospkModelImpl teospkModelImpl = (TeospkModelImpl) teospk;

        Object[] args = new Object[] { teospk.getTeospknimi() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEOSPKNIMI, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI, args);

        if ((teospkModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TEOSPKNIMI.getColumnBitmask()) != 0) {
            args = new Object[] { teospkModelImpl.getOriginalTeospknimi() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEOSPKNIMI, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEOSPKNIMI, args);
        }
    }

    /**
     * Creates a new teospk with the primary key. Does not add the teospk to the database.
     *
     * @param teospkid the primary key for the new teospk
     * @return the new teospk
     */
    @Override
    public Teospk create(int teospkid) {
        Teospk teospk = new TeospkImpl();

        teospk.setNew(true);
        teospk.setPrimaryKey(teospkid);

        return teospk;
    }

    /**
     * Removes the teospk with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param teospkid the primary key of the teospk
     * @return the teospk that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a teospk with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk remove(int teospkid)
        throws NoSuchTeospkException, SystemException {
        return remove((Serializable) teospkid);
    }

    /**
     * Removes the teospk with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the teospk
     * @return the teospk that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a teospk with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk remove(Serializable primaryKey)
        throws NoSuchTeospkException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Teospk teospk = (Teospk) session.get(TeospkImpl.class, primaryKey);

            if (teospk == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTeospkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(teospk);
        } catch (NoSuchTeospkException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Teospk removeImpl(Teospk teospk) throws SystemException {
        teospk = toUnwrappedModel(teospk);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(teospk)) {
                teospk = (Teospk) session.get(TeospkImpl.class,
                        teospk.getPrimaryKeyObj());
            }

            if (teospk != null) {
                session.delete(teospk);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (teospk != null) {
            clearCache(teospk);
        }

        return teospk;
    }

    @Override
    public Teospk updateImpl(fi.csc.avaa.khl.db.model.Teospk teospk)
        throws SystemException {
        teospk = toUnwrappedModel(teospk);

        boolean isNew = teospk.isNew();

        Session session = null;

        try {
            session = openSession();

            if (teospk.isNew()) {
                session.save(teospk);

                teospk.setNew(false);
            } else {
                session.merge(teospk);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TeospkModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(TeospkModelImpl.ENTITY_CACHE_ENABLED,
            TeospkImpl.class, teospk.getPrimaryKey(), teospk);

        clearUniqueFindersCache(teospk);
        cacheUniqueFindersCache(teospk);

        return teospk;
    }

    protected Teospk toUnwrappedModel(Teospk teospk) {
        if (teospk instanceof TeospkImpl) {
            return teospk;
        }

        TeospkImpl teospkImpl = new TeospkImpl();

        teospkImpl.setNew(teospk.isNew());
        teospkImpl.setPrimaryKey(teospk.getPrimaryKey());

        teospkImpl.setTeospkid(teospk.getTeospkid());
        teospkImpl.setTeospknimi(teospk.getTeospknimi());

        return teospkImpl;
    }

    /**
     * Returns the teospk with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the teospk
     * @return the teospk
     * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a teospk with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTeospkException, SystemException {
        Teospk teospk = fetchByPrimaryKey(primaryKey);

        if (teospk == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTeospkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return teospk;
    }

    /**
     * Returns the teospk with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchTeospkException} if it could not be found.
     *
     * @param teospkid the primary key of the teospk
     * @return the teospk
     * @throws fi.csc.avaa.khl.db.NoSuchTeospkException if a teospk with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk findByPrimaryKey(int teospkid)
        throws NoSuchTeospkException, SystemException {
        return findByPrimaryKey((Serializable) teospkid);
    }

    /**
     * Returns the teospk with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the teospk
     * @return the teospk, or <code>null</code> if a teospk with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Teospk teospk = (Teospk) EntityCacheUtil.getResult(TeospkModelImpl.ENTITY_CACHE_ENABLED,
                TeospkImpl.class, primaryKey);

        if (teospk == _nullTeospk) {
            return null;
        }

        if (teospk == null) {
            Session session = null;

            try {
                session = openSession();

                teospk = (Teospk) session.get(TeospkImpl.class, primaryKey);

                if (teospk != null) {
                    cacheResult(teospk);
                } else {
                    EntityCacheUtil.putResult(TeospkModelImpl.ENTITY_CACHE_ENABLED,
                        TeospkImpl.class, primaryKey, _nullTeospk);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TeospkModelImpl.ENTITY_CACHE_ENABLED,
                    TeospkImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return teospk;
    }

    /**
     * Returns the teospk with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param teospkid the primary key of the teospk
     * @return the teospk, or <code>null</code> if a teospk with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Teospk fetchByPrimaryKey(int teospkid) throws SystemException {
        return fetchByPrimaryKey((Serializable) teospkid);
    }

    /**
     * Returns all the teospks.
     *
     * @return the teospks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Teospk> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the teospks.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.TeospkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of teospks
     * @param end the upper bound of the range of teospks (not inclusive)
     * @return the range of teospks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Teospk> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the teospks.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.TeospkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of teospks
     * @param end the upper bound of the range of teospks (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of teospks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Teospk> findAll(int start, int end,
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

        List<Teospk> list = (List<Teospk>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TEOSPK);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TEOSPK;

                if (pagination) {
                    sql = sql.concat(TeospkModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Teospk>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Teospk>(list);
                } else {
                    list = (List<Teospk>) QueryUtil.list(q, getDialect(),
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
     * Removes all the teospks from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Teospk teospk : findAll()) {
            remove(teospk);
        }
    }

    /**
     * Returns the number of teospks.
     *
     * @return the number of teospks
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

                Query q = session.createQuery(_SQL_COUNT_TEOSPK);

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
     * Initializes the teospk persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Teospk")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Teospk>> listenersList = new ArrayList<ModelListener<Teospk>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Teospk>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TeospkImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
