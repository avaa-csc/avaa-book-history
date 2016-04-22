package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import fi.csc.avaa.khl.db.NoSuchMaakuntainfoException;
import fi.csc.avaa.khl.db.model.Maakuntainfo;
import fi.csc.avaa.khl.db.model.impl.MaakuntainfoImpl;
import fi.csc.avaa.khl.db.model.impl.MaakuntainfoModelImpl;
import fi.csc.avaa.khl.db.service.persistence.MaakuntainfoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the maakuntainfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see MaakuntainfoPersistence
 * @see MaakuntainfoUtil
 * @generated
 */
public class MaakuntainfoPersistenceImpl extends BasePersistenceImpl<Maakuntainfo>
    implements MaakuntainfoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MaakuntainfoUtil} to access the maakuntainfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MaakuntainfoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            MaakuntainfoModelImpl.FINDER_CACHE_ENABLED, MaakuntainfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            MaakuntainfoModelImpl.FINDER_CACHE_ENABLED, MaakuntainfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            MaakuntainfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_MAAKUNTAINFO = "SELECT maakuntainfo FROM Maakuntainfo maakuntainfo";
    private static final String _SQL_COUNT_MAAKUNTAINFO = "SELECT COUNT(maakuntainfo) FROM Maakuntainfo maakuntainfo";
    private static final String _ORDER_BY_ENTITY_ALIAS = "maakuntainfo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Maakuntainfo exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MaakuntainfoPersistenceImpl.class);
    private static Maakuntainfo _nullMaakuntainfo = new MaakuntainfoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Maakuntainfo> toCacheModel() {
                return _nullMaakuntainfoCacheModel;
            }
        };

    private static CacheModel<Maakuntainfo> _nullMaakuntainfoCacheModel = new CacheModel<Maakuntainfo>() {
            @Override
            public Maakuntainfo toEntityModel() {
                return _nullMaakuntainfo;
            }
        };

    public MaakuntainfoPersistenceImpl() {
        setModelClass(Maakuntainfo.class);
    }

    /**
     * Caches the maakuntainfo in the entity cache if it is enabled.
     *
     * @param maakuntainfo the maakuntainfo
     */
    @Override
    public void cacheResult(Maakuntainfo maakuntainfo) {
        EntityCacheUtil.putResult(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            MaakuntainfoImpl.class, maakuntainfo.getPrimaryKey(), maakuntainfo);

        maakuntainfo.resetOriginalValues();
    }

    /**
     * Caches the maakuntainfos in the entity cache if it is enabled.
     *
     * @param maakuntainfos the maakuntainfos
     */
    @Override
    public void cacheResult(List<Maakuntainfo> maakuntainfos) {
        for (Maakuntainfo maakuntainfo : maakuntainfos) {
            if (EntityCacheUtil.getResult(
                        MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                        MaakuntainfoImpl.class, maakuntainfo.getPrimaryKey()) == null) {
                cacheResult(maakuntainfo);
            } else {
                maakuntainfo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all maakuntainfos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MaakuntainfoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MaakuntainfoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the maakuntainfo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Maakuntainfo maakuntainfo) {
        EntityCacheUtil.removeResult(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            MaakuntainfoImpl.class, maakuntainfo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Maakuntainfo> maakuntainfos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Maakuntainfo maakuntainfo : maakuntainfos) {
            EntityCacheUtil.removeResult(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                MaakuntainfoImpl.class, maakuntainfo.getPrimaryKey());
        }
    }

    /**
     * Creates a new maakuntainfo with the primary key. Does not add the maakuntainfo to the database.
     *
     * @param maakuntaid the primary key for the new maakuntainfo
     * @return the new maakuntainfo
     */
    @Override
    public Maakuntainfo create(int maakuntaid) {
        Maakuntainfo maakuntainfo = new MaakuntainfoImpl();

        maakuntainfo.setNew(true);
        maakuntainfo.setPrimaryKey(maakuntaid);

        return maakuntainfo;
    }

    /**
     * Removes the maakuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param maakuntaid the primary key of the maakuntainfo
     * @return the maakuntainfo that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchMaakuntainfoException if a maakuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Maakuntainfo remove(int maakuntaid)
        throws NoSuchMaakuntainfoException, SystemException {
        return remove((Serializable) maakuntaid);
    }

    /**
     * Removes the maakuntainfo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the maakuntainfo
     * @return the maakuntainfo that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchMaakuntainfoException if a maakuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Maakuntainfo remove(Serializable primaryKey)
        throws NoSuchMaakuntainfoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Maakuntainfo maakuntainfo = (Maakuntainfo) session.get(MaakuntainfoImpl.class,
                    primaryKey);

            if (maakuntainfo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMaakuntainfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(maakuntainfo);
        } catch (NoSuchMaakuntainfoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Maakuntainfo removeImpl(Maakuntainfo maakuntainfo)
        throws SystemException {
        maakuntainfo = toUnwrappedModel(maakuntainfo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(maakuntainfo)) {
                maakuntainfo = (Maakuntainfo) session.get(MaakuntainfoImpl.class,
                        maakuntainfo.getPrimaryKeyObj());
            }

            if (maakuntainfo != null) {
                session.delete(maakuntainfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (maakuntainfo != null) {
            clearCache(maakuntainfo);
        }

        return maakuntainfo;
    }

    @Override
    public Maakuntainfo updateImpl(
        fi.csc.avaa.khl.db.model.Maakuntainfo maakuntainfo)
        throws SystemException {
        maakuntainfo = toUnwrappedModel(maakuntainfo);

        boolean isNew = maakuntainfo.isNew();

        Session session = null;

        try {
            session = openSession();

            if (maakuntainfo.isNew()) {
                session.save(maakuntainfo);

                maakuntainfo.setNew(false);
            } else {
                session.merge(maakuntainfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
            MaakuntainfoImpl.class, maakuntainfo.getPrimaryKey(), maakuntainfo);

        return maakuntainfo;
    }

    protected Maakuntainfo toUnwrappedModel(Maakuntainfo maakuntainfo) {
        if (maakuntainfo instanceof MaakuntainfoImpl) {
            return maakuntainfo;
        }

        MaakuntainfoImpl maakuntainfoImpl = new MaakuntainfoImpl();

        maakuntainfoImpl.setNew(maakuntainfo.isNew());
        maakuntainfoImpl.setPrimaryKey(maakuntainfo.getPrimaryKey());

        maakuntainfoImpl.setMaakuntaid(maakuntainfo.getMaakuntaid());
        maakuntainfoImpl.setMaakunta(maakuntainfo.getMaakunta());
        maakuntainfoImpl.setKpl(maakuntainfo.getKpl());

        return maakuntainfoImpl;
    }

    /**
     * Returns the maakuntainfo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the maakuntainfo
     * @return the maakuntainfo
     * @throws fi.csc.avaa.khl.db.NoSuchMaakuntainfoException if a maakuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Maakuntainfo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMaakuntainfoException, SystemException {
        Maakuntainfo maakuntainfo = fetchByPrimaryKey(primaryKey);

        if (maakuntainfo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMaakuntainfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return maakuntainfo;
    }

    /**
     * Returns the maakuntainfo with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchMaakuntainfoException} if it could not be found.
     *
     * @param maakuntaid the primary key of the maakuntainfo
     * @return the maakuntainfo
     * @throws fi.csc.avaa.khl.db.NoSuchMaakuntainfoException if a maakuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Maakuntainfo findByPrimaryKey(int maakuntaid)
        throws NoSuchMaakuntainfoException, SystemException {
        return findByPrimaryKey((Serializable) maakuntaid);
    }

    /**
     * Returns the maakuntainfo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the maakuntainfo
     * @return the maakuntainfo, or <code>null</code> if a maakuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Maakuntainfo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Maakuntainfo maakuntainfo = (Maakuntainfo) EntityCacheUtil.getResult(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                MaakuntainfoImpl.class, primaryKey);

        if (maakuntainfo == _nullMaakuntainfo) {
            return null;
        }

        if (maakuntainfo == null) {
            Session session = null;

            try {
                session = openSession();

                maakuntainfo = (Maakuntainfo) session.get(MaakuntainfoImpl.class,
                        primaryKey);

                if (maakuntainfo != null) {
                    cacheResult(maakuntainfo);
                } else {
                    EntityCacheUtil.putResult(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                        MaakuntainfoImpl.class, primaryKey, _nullMaakuntainfo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MaakuntainfoModelImpl.ENTITY_CACHE_ENABLED,
                    MaakuntainfoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return maakuntainfo;
    }

    /**
     * Returns the maakuntainfo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param maakuntaid the primary key of the maakuntainfo
     * @return the maakuntainfo, or <code>null</code> if a maakuntainfo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Maakuntainfo fetchByPrimaryKey(int maakuntaid)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) maakuntaid);
    }

    /**
     * Returns all the maakuntainfos.
     *
     * @return the maakuntainfos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Maakuntainfo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Maakuntainfo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Maakuntainfo> findAll(int start, int end,
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

        List<Maakuntainfo> list = (List<Maakuntainfo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MAAKUNTAINFO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MAAKUNTAINFO;

                if (pagination) {
                    sql = sql.concat(MaakuntainfoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Maakuntainfo>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Maakuntainfo>(list);
                } else {
                    list = (List<Maakuntainfo>) QueryUtil.list(q, getDialect(),
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
     * Removes all the maakuntainfos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Maakuntainfo maakuntainfo : findAll()) {
            remove(maakuntainfo);
        }
    }

    /**
     * Returns the number of maakuntainfos.
     *
     * @return the number of maakuntainfos
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

                Query q = session.createQuery(_SQL_COUNT_MAAKUNTAINFO);

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
     * Initializes the maakuntainfo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Maakuntainfo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Maakuntainfo>> listenersList = new ArrayList<ModelListener<Maakuntainfo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Maakuntainfo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MaakuntainfoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
