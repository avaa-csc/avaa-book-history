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

import fi.csc.avaa.khl.db.NoSuchKartoituskohdeException;
import fi.csc.avaa.khl.db.model.Kartoituskohde;
import fi.csc.avaa.khl.db.model.impl.KartoituskohdeImpl;
import fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl;
import fi.csc.avaa.khl.db.service.persistence.KartoituskohdePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the kartoituskohde service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see KartoituskohdePersistence
 * @see KartoituskohdeUtil
 * @generated
 */
public class KartoituskohdePersistenceImpl extends BasePersistenceImpl<Kartoituskohde>
    implements KartoituskohdePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link KartoituskohdeUtil} to access the kartoituskohde persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = KartoituskohdeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
            KartoituskohdeModelImpl.FINDER_CACHE_ENABLED,
            KartoituskohdeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
            KartoituskohdeModelImpl.FINDER_CACHE_ENABLED,
            KartoituskohdeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
            KartoituskohdeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_KARTKOHDE = new FinderPath(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
            KartoituskohdeModelImpl.FINDER_CACHE_ENABLED,
            KartoituskohdeImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByKartkohde", new String[] { String.class.getName() },
            KartoituskohdeModelImpl.KARTKOHDE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_KARTKOHDE = new FinderPath(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
            KartoituskohdeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKartkohde",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_KARTKOHDE_KARTKOHDE_1 = "kartoituskohde.kartkohde IS NULL";
    private static final String _FINDER_COLUMN_KARTKOHDE_KARTKOHDE_2 = "kartoituskohde.kartkohde = ?";
    private static final String _FINDER_COLUMN_KARTKOHDE_KARTKOHDE_3 = "(kartoituskohde.kartkohde IS NULL OR kartoituskohde.kartkohde = '')";
    private static final String _SQL_SELECT_KARTOITUSKOHDE = "SELECT kartoituskohde FROM Kartoituskohde kartoituskohde";
    private static final String _SQL_SELECT_KARTOITUSKOHDE_WHERE = "SELECT kartoituskohde FROM Kartoituskohde kartoituskohde WHERE ";
    private static final String _SQL_COUNT_KARTOITUSKOHDE = "SELECT COUNT(kartoituskohde) FROM Kartoituskohde kartoituskohde";
    private static final String _SQL_COUNT_KARTOITUSKOHDE_WHERE = "SELECT COUNT(kartoituskohde) FROM Kartoituskohde kartoituskohde WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "kartoituskohde.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Kartoituskohde exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Kartoituskohde exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(KartoituskohdePersistenceImpl.class);
    private static Kartoituskohde _nullKartoituskohde = new KartoituskohdeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Kartoituskohde> toCacheModel() {
                return _nullKartoituskohdeCacheModel;
            }
        };

    private static CacheModel<Kartoituskohde> _nullKartoituskohdeCacheModel = new CacheModel<Kartoituskohde>() {
            @Override
            public Kartoituskohde toEntityModel() {
                return _nullKartoituskohde;
            }
        };

    public KartoituskohdePersistenceImpl() {
        setModelClass(Kartoituskohde.class);
    }

    /**
     * Returns the kartoituskohde where kartkohde = &#63; or throws a {@link fi.csc.avaa.khl.db.NoSuchKartoituskohdeException} if it could not be found.
     *
     * @param kartkohde the kartkohde
     * @return the matching kartoituskohde
     * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a matching kartoituskohde could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde findByKartkohde(String kartkohde)
        throws NoSuchKartoituskohdeException, SystemException {
        Kartoituskohde kartoituskohde = fetchByKartkohde(kartkohde);

        if (kartoituskohde == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("kartkohde=");
            msg.append(kartkohde);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchKartoituskohdeException(msg.toString());
        }

        return kartoituskohde;
    }

    /**
     * Returns the kartoituskohde where kartkohde = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param kartkohde the kartkohde
     * @return the matching kartoituskohde, or <code>null</code> if a matching kartoituskohde could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde fetchByKartkohde(String kartkohde)
        throws SystemException {
        return fetchByKartkohde(kartkohde, true);
    }

    /**
     * Returns the kartoituskohde where kartkohde = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param kartkohde the kartkohde
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching kartoituskohde, or <code>null</code> if a matching kartoituskohde could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde fetchByKartkohde(String kartkohde,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { kartkohde };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KARTKOHDE,
                    finderArgs, this);
        }

        if (result instanceof Kartoituskohde) {
            Kartoituskohde kartoituskohde = (Kartoituskohde) result;

            if (!Validator.equals(kartkohde, kartoituskohde.getKartkohde())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_KARTOITUSKOHDE_WHERE);

            boolean bindKartkohde = false;

            if (kartkohde == null) {
                query.append(_FINDER_COLUMN_KARTKOHDE_KARTKOHDE_1);
            } else if (kartkohde.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_KARTKOHDE_KARTKOHDE_3);
            } else {
                bindKartkohde = true;

                query.append(_FINDER_COLUMN_KARTKOHDE_KARTKOHDE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKartkohde) {
                    qPos.add(kartkohde);
                }

                List<Kartoituskohde> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KARTKOHDE,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "KartoituskohdePersistenceImpl.fetchByKartkohde(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Kartoituskohde kartoituskohde = list.get(0);

                    result = kartoituskohde;

                    cacheResult(kartoituskohde);

                    if ((kartoituskohde.getKartkohde() == null) ||
                            !kartoituskohde.getKartkohde().equals(kartkohde)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KARTKOHDE,
                            finderArgs, kartoituskohde);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KARTKOHDE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Kartoituskohde) result;
        }
    }

    /**
     * Removes the kartoituskohde where kartkohde = &#63; from the database.
     *
     * @param kartkohde the kartkohde
     * @return the kartoituskohde that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde removeByKartkohde(String kartkohde)
        throws NoSuchKartoituskohdeException, SystemException {
        Kartoituskohde kartoituskohde = findByKartkohde(kartkohde);

        return remove(kartoituskohde);
    }

    /**
     * Returns the number of kartoituskohdes where kartkohde = &#63;.
     *
     * @param kartkohde the kartkohde
     * @return the number of matching kartoituskohdes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByKartkohde(String kartkohde) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_KARTKOHDE;

        Object[] finderArgs = new Object[] { kartkohde };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_KARTOITUSKOHDE_WHERE);

            boolean bindKartkohde = false;

            if (kartkohde == null) {
                query.append(_FINDER_COLUMN_KARTKOHDE_KARTKOHDE_1);
            } else if (kartkohde.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_KARTKOHDE_KARTKOHDE_3);
            } else {
                bindKartkohde = true;

                query.append(_FINDER_COLUMN_KARTKOHDE_KARTKOHDE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKartkohde) {
                    qPos.add(kartkohde);
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
     * Caches the kartoituskohde in the entity cache if it is enabled.
     *
     * @param kartoituskohde the kartoituskohde
     */
    @Override
    public void cacheResult(Kartoituskohde kartoituskohde) {
        EntityCacheUtil.putResult(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
            KartoituskohdeImpl.class, kartoituskohde.getPrimaryKey(),
            kartoituskohde);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KARTKOHDE,
            new Object[] { kartoituskohde.getKartkohde() }, kartoituskohde);

        kartoituskohde.resetOriginalValues();
    }

    /**
     * Caches the kartoituskohdes in the entity cache if it is enabled.
     *
     * @param kartoituskohdes the kartoituskohdes
     */
    @Override
    public void cacheResult(List<Kartoituskohde> kartoituskohdes) {
        for (Kartoituskohde kartoituskohde : kartoituskohdes) {
            if (EntityCacheUtil.getResult(
                        KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
                        KartoituskohdeImpl.class, kartoituskohde.getPrimaryKey()) == null) {
                cacheResult(kartoituskohde);
            } else {
                kartoituskohde.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all kartoituskohdes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(KartoituskohdeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(KartoituskohdeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the kartoituskohde.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Kartoituskohde kartoituskohde) {
        EntityCacheUtil.removeResult(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
            KartoituskohdeImpl.class, kartoituskohde.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(kartoituskohde);
    }

    @Override
    public void clearCache(List<Kartoituskohde> kartoituskohdes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Kartoituskohde kartoituskohde : kartoituskohdes) {
            EntityCacheUtil.removeResult(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
                KartoituskohdeImpl.class, kartoituskohde.getPrimaryKey());

            clearUniqueFindersCache(kartoituskohde);
        }
    }

    protected void cacheUniqueFindersCache(Kartoituskohde kartoituskohde) {
        if (kartoituskohde.isNew()) {
            Object[] args = new Object[] { kartoituskohde.getKartkohde() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KARTKOHDE, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KARTKOHDE, args,
                kartoituskohde);
        } else {
            KartoituskohdeModelImpl kartoituskohdeModelImpl = (KartoituskohdeModelImpl) kartoituskohde;

            if ((kartoituskohdeModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_KARTKOHDE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { kartoituskohde.getKartkohde() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KARTKOHDE, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KARTKOHDE, args,
                    kartoituskohde);
            }
        }
    }

    protected void clearUniqueFindersCache(Kartoituskohde kartoituskohde) {
        KartoituskohdeModelImpl kartoituskohdeModelImpl = (KartoituskohdeModelImpl) kartoituskohde;

        Object[] args = new Object[] { kartoituskohde.getKartkohde() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KARTKOHDE, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KARTKOHDE, args);

        if ((kartoituskohdeModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_KARTKOHDE.getColumnBitmask()) != 0) {
            args = new Object[] { kartoituskohdeModelImpl.getOriginalKartkohde() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KARTKOHDE, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KARTKOHDE, args);
        }
    }

    /**
     * Creates a new kartoituskohde with the primary key. Does not add the kartoituskohde to the database.
     *
     * @param kohdeid the primary key for the new kartoituskohde
     * @return the new kartoituskohde
     */
    @Override
    public Kartoituskohde create(int kohdeid) {
        Kartoituskohde kartoituskohde = new KartoituskohdeImpl();

        kartoituskohde.setNew(true);
        kartoituskohde.setPrimaryKey(kohdeid);

        return kartoituskohde;
    }

    /**
     * Removes the kartoituskohde with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param kohdeid the primary key of the kartoituskohde
     * @return the kartoituskohde that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a kartoituskohde with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde remove(int kohdeid)
        throws NoSuchKartoituskohdeException, SystemException {
        return remove((Serializable) kohdeid);
    }

    /**
     * Removes the kartoituskohde with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the kartoituskohde
     * @return the kartoituskohde that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a kartoituskohde with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde remove(Serializable primaryKey)
        throws NoSuchKartoituskohdeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Kartoituskohde kartoituskohde = (Kartoituskohde) session.get(KartoituskohdeImpl.class,
                    primaryKey);

            if (kartoituskohde == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchKartoituskohdeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(kartoituskohde);
        } catch (NoSuchKartoituskohdeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Kartoituskohde removeImpl(Kartoituskohde kartoituskohde)
        throws SystemException {
        kartoituskohde = toUnwrappedModel(kartoituskohde);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(kartoituskohde)) {
                kartoituskohde = (Kartoituskohde) session.get(KartoituskohdeImpl.class,
                        kartoituskohde.getPrimaryKeyObj());
            }

            if (kartoituskohde != null) {
                session.delete(kartoituskohde);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (kartoituskohde != null) {
            clearCache(kartoituskohde);
        }

        return kartoituskohde;
    }

    @Override
    public Kartoituskohde updateImpl(
        fi.csc.avaa.khl.db.model.Kartoituskohde kartoituskohde)
        throws SystemException {
        kartoituskohde = toUnwrappedModel(kartoituskohde);

        boolean isNew = kartoituskohde.isNew();

        Session session = null;

        try {
            session = openSession();

            if (kartoituskohde.isNew()) {
                session.save(kartoituskohde);

                kartoituskohde.setNew(false);
            } else {
                session.merge(kartoituskohde);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !KartoituskohdeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
            KartoituskohdeImpl.class, kartoituskohde.getPrimaryKey(),
            kartoituskohde);

        clearUniqueFindersCache(kartoituskohde);
        cacheUniqueFindersCache(kartoituskohde);

        return kartoituskohde;
    }

    protected Kartoituskohde toUnwrappedModel(Kartoituskohde kartoituskohde) {
        if (kartoituskohde instanceof KartoituskohdeImpl) {
            return kartoituskohde;
        }

        KartoituskohdeImpl kartoituskohdeImpl = new KartoituskohdeImpl();

        kartoituskohdeImpl.setNew(kartoituskohde.isNew());
        kartoituskohdeImpl.setPrimaryKey(kartoituskohde.getPrimaryKey());

        kartoituskohdeImpl.setKohdeid(kartoituskohde.getKohdeid());
        kartoituskohdeImpl.setKartkohde(kartoituskohde.getKartkohde());
        kartoituskohdeImpl.setKpl(kartoituskohde.getKpl());

        return kartoituskohdeImpl;
    }

    /**
     * Returns the kartoituskohde with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the kartoituskohde
     * @return the kartoituskohde
     * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a kartoituskohde with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde findByPrimaryKey(Serializable primaryKey)
        throws NoSuchKartoituskohdeException, SystemException {
        Kartoituskohde kartoituskohde = fetchByPrimaryKey(primaryKey);

        if (kartoituskohde == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchKartoituskohdeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return kartoituskohde;
    }

    /**
     * Returns the kartoituskohde with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchKartoituskohdeException} if it could not be found.
     *
     * @param kohdeid the primary key of the kartoituskohde
     * @return the kartoituskohde
     * @throws fi.csc.avaa.khl.db.NoSuchKartoituskohdeException if a kartoituskohde with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde findByPrimaryKey(int kohdeid)
        throws NoSuchKartoituskohdeException, SystemException {
        return findByPrimaryKey((Serializable) kohdeid);
    }

    /**
     * Returns the kartoituskohde with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the kartoituskohde
     * @return the kartoituskohde, or <code>null</code> if a kartoituskohde with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Kartoituskohde kartoituskohde = (Kartoituskohde) EntityCacheUtil.getResult(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
                KartoituskohdeImpl.class, primaryKey);

        if (kartoituskohde == _nullKartoituskohde) {
            return null;
        }

        if (kartoituskohde == null) {
            Session session = null;

            try {
                session = openSession();

                kartoituskohde = (Kartoituskohde) session.get(KartoituskohdeImpl.class,
                        primaryKey);

                if (kartoituskohde != null) {
                    cacheResult(kartoituskohde);
                } else {
                    EntityCacheUtil.putResult(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
                        KartoituskohdeImpl.class, primaryKey,
                        _nullKartoituskohde);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(KartoituskohdeModelImpl.ENTITY_CACHE_ENABLED,
                    KartoituskohdeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return kartoituskohde;
    }

    /**
     * Returns the kartoituskohde with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param kohdeid the primary key of the kartoituskohde
     * @return the kartoituskohde, or <code>null</code> if a kartoituskohde with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Kartoituskohde fetchByPrimaryKey(int kohdeid)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) kohdeid);
    }

    /**
     * Returns all the kartoituskohdes.
     *
     * @return the kartoituskohdes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kartoituskohde> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the kartoituskohdes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of kartoituskohdes
     * @param end the upper bound of the range of kartoituskohdes (not inclusive)
     * @return the range of kartoituskohdes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kartoituskohde> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the kartoituskohdes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.KartoituskohdeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of kartoituskohdes
     * @param end the upper bound of the range of kartoituskohdes (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of kartoituskohdes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Kartoituskohde> findAll(int start, int end,
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

        List<Kartoituskohde> list = (List<Kartoituskohde>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_KARTOITUSKOHDE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_KARTOITUSKOHDE;

                if (pagination) {
                    sql = sql.concat(KartoituskohdeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Kartoituskohde>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Kartoituskohde>(list);
                } else {
                    list = (List<Kartoituskohde>) QueryUtil.list(q,
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
     * Removes all the kartoituskohdes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Kartoituskohde kartoituskohde : findAll()) {
            remove(kartoituskohde);
        }
    }

    /**
     * Returns the number of kartoituskohdes.
     *
     * @return the number of kartoituskohdes
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

                Query q = session.createQuery(_SQL_COUNT_KARTOITUSKOHDE);

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
     * Initializes the kartoituskohde persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Kartoituskohde")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Kartoituskohde>> listenersList = new ArrayList<ModelListener<Kartoituskohde>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Kartoituskohde>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(KartoituskohdeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
