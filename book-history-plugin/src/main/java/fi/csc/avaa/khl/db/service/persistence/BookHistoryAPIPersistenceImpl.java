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

import fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException;
import fi.csc.avaa.khl.db.model.BookHistoryAPI;
import fi.csc.avaa.khl.db.model.impl.BookHistoryAPIImpl;
import fi.csc.avaa.khl.db.model.impl.BookHistoryAPIModelImpl;
import fi.csc.avaa.khl.db.service.persistence.BookHistoryAPIPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the book history a p i service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see BookHistoryAPIPersistence
 * @see BookHistoryAPIUtil
 * @generated
 */
public class BookHistoryAPIPersistenceImpl extends BasePersistenceImpl<BookHistoryAPI>
    implements BookHistoryAPIPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BookHistoryAPIUtil} to access the book history a p i persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BookHistoryAPIImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
            BookHistoryAPIModelImpl.FINDER_CACHE_ENABLED,
            BookHistoryAPIImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
            BookHistoryAPIModelImpl.FINDER_CACHE_ENABLED,
            BookHistoryAPIImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
            BookHistoryAPIModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_BOOKHISTORYAPI = "SELECT bookHistoryAPI FROM BookHistoryAPI bookHistoryAPI";
    private static final String _SQL_COUNT_BOOKHISTORYAPI = "SELECT COUNT(bookHistoryAPI) FROM BookHistoryAPI bookHistoryAPI";
    private static final String _ORDER_BY_ENTITY_ALIAS = "bookHistoryAPI.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BookHistoryAPI exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BookHistoryAPIPersistenceImpl.class);
    private static BookHistoryAPI _nullBookHistoryAPI = new BookHistoryAPIImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<BookHistoryAPI> toCacheModel() {
                return _nullBookHistoryAPICacheModel;
            }
        };

    private static CacheModel<BookHistoryAPI> _nullBookHistoryAPICacheModel = new CacheModel<BookHistoryAPI>() {
            @Override
            public BookHistoryAPI toEntityModel() {
                return _nullBookHistoryAPI;
            }
        };

    public BookHistoryAPIPersistenceImpl() {
        setModelClass(BookHistoryAPI.class);
    }

    /**
     * Caches the book history a p i in the entity cache if it is enabled.
     *
     * @param bookHistoryAPI the book history a p i
     */
    @Override
    public void cacheResult(BookHistoryAPI bookHistoryAPI) {
        EntityCacheUtil.putResult(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
            BookHistoryAPIImpl.class, bookHistoryAPI.getPrimaryKey(),
            bookHistoryAPI);

        bookHistoryAPI.resetOriginalValues();
    }

    /**
     * Caches the book history a p is in the entity cache if it is enabled.
     *
     * @param bookHistoryAPIs the book history a p is
     */
    @Override
    public void cacheResult(List<BookHistoryAPI> bookHistoryAPIs) {
        for (BookHistoryAPI bookHistoryAPI : bookHistoryAPIs) {
            if (EntityCacheUtil.getResult(
                        BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
                        BookHistoryAPIImpl.class, bookHistoryAPI.getPrimaryKey()) == null) {
                cacheResult(bookHistoryAPI);
            } else {
                bookHistoryAPI.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all book history a p is.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BookHistoryAPIImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BookHistoryAPIImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the book history a p i.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(BookHistoryAPI bookHistoryAPI) {
        EntityCacheUtil.removeResult(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
            BookHistoryAPIImpl.class, bookHistoryAPI.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<BookHistoryAPI> bookHistoryAPIs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (BookHistoryAPI bookHistoryAPI : bookHistoryAPIs) {
            EntityCacheUtil.removeResult(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
                BookHistoryAPIImpl.class, bookHistoryAPI.getPrimaryKey());
        }
    }

    /**
     * Creates a new book history a p i with the primary key. Does not add the book history a p i to the database.
     *
     * @param name the primary key for the new book history a p i
     * @return the new book history a p i
     */
    @Override
    public BookHistoryAPI create(String name) {
        BookHistoryAPI bookHistoryAPI = new BookHistoryAPIImpl();

        bookHistoryAPI.setNew(true);
        bookHistoryAPI.setPrimaryKey(name);

        return bookHistoryAPI;
    }

    /**
     * Removes the book history a p i with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param name the primary key of the book history a p i
     * @return the book history a p i that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException if a book history a p i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BookHistoryAPI remove(String name)
        throws NoSuchBookHistoryAPIException, SystemException {
        return remove((Serializable) name);
    }

    /**
     * Removes the book history a p i with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the book history a p i
     * @return the book history a p i that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException if a book history a p i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BookHistoryAPI remove(Serializable primaryKey)
        throws NoSuchBookHistoryAPIException, SystemException {
        Session session = null;

        try {
            session = openSession();

            BookHistoryAPI bookHistoryAPI = (BookHistoryAPI) session.get(BookHistoryAPIImpl.class,
                    primaryKey);

            if (bookHistoryAPI == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBookHistoryAPIException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(bookHistoryAPI);
        } catch (NoSuchBookHistoryAPIException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected BookHistoryAPI removeImpl(BookHistoryAPI bookHistoryAPI)
        throws SystemException {
        bookHistoryAPI = toUnwrappedModel(bookHistoryAPI);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(bookHistoryAPI)) {
                bookHistoryAPI = (BookHistoryAPI) session.get(BookHistoryAPIImpl.class,
                        bookHistoryAPI.getPrimaryKeyObj());
            }

            if (bookHistoryAPI != null) {
                session.delete(bookHistoryAPI);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (bookHistoryAPI != null) {
            clearCache(bookHistoryAPI);
        }

        return bookHistoryAPI;
    }

    @Override
    public BookHistoryAPI updateImpl(
        fi.csc.avaa.khl.db.model.BookHistoryAPI bookHistoryAPI)
        throws SystemException {
        bookHistoryAPI = toUnwrappedModel(bookHistoryAPI);

        boolean isNew = bookHistoryAPI.isNew();

        Session session = null;

        try {
            session = openSession();

            if (bookHistoryAPI.isNew()) {
                session.save(bookHistoryAPI);

                bookHistoryAPI.setNew(false);
            } else {
                session.merge(bookHistoryAPI);
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

        EntityCacheUtil.putResult(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
            BookHistoryAPIImpl.class, bookHistoryAPI.getPrimaryKey(),
            bookHistoryAPI);

        return bookHistoryAPI;
    }

    protected BookHistoryAPI toUnwrappedModel(BookHistoryAPI bookHistoryAPI) {
        if (bookHistoryAPI instanceof BookHistoryAPIImpl) {
            return bookHistoryAPI;
        }

        BookHistoryAPIImpl bookHistoryAPIImpl = new BookHistoryAPIImpl();

        bookHistoryAPIImpl.setNew(bookHistoryAPI.isNew());
        bookHistoryAPIImpl.setPrimaryKey(bookHistoryAPI.getPrimaryKey());

        bookHistoryAPIImpl.setName(bookHistoryAPI.getName());

        return bookHistoryAPIImpl;
    }

    /**
     * Returns the book history a p i with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the book history a p i
     * @return the book history a p i
     * @throws fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException if a book history a p i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BookHistoryAPI findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBookHistoryAPIException, SystemException {
        BookHistoryAPI bookHistoryAPI = fetchByPrimaryKey(primaryKey);

        if (bookHistoryAPI == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBookHistoryAPIException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return bookHistoryAPI;
    }

    /**
     * Returns the book history a p i with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException} if it could not be found.
     *
     * @param name the primary key of the book history a p i
     * @return the book history a p i
     * @throws fi.csc.avaa.khl.db.NoSuchBookHistoryAPIException if a book history a p i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BookHistoryAPI findByPrimaryKey(String name)
        throws NoSuchBookHistoryAPIException, SystemException {
        return findByPrimaryKey((Serializable) name);
    }

    /**
     * Returns the book history a p i with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the book history a p i
     * @return the book history a p i, or <code>null</code> if a book history a p i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BookHistoryAPI fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        BookHistoryAPI bookHistoryAPI = (BookHistoryAPI) EntityCacheUtil.getResult(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
                BookHistoryAPIImpl.class, primaryKey);

        if (bookHistoryAPI == _nullBookHistoryAPI) {
            return null;
        }

        if (bookHistoryAPI == null) {
            Session session = null;

            try {
                session = openSession();

                bookHistoryAPI = (BookHistoryAPI) session.get(BookHistoryAPIImpl.class,
                        primaryKey);

                if (bookHistoryAPI != null) {
                    cacheResult(bookHistoryAPI);
                } else {
                    EntityCacheUtil.putResult(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
                        BookHistoryAPIImpl.class, primaryKey,
                        _nullBookHistoryAPI);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BookHistoryAPIModelImpl.ENTITY_CACHE_ENABLED,
                    BookHistoryAPIImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return bookHistoryAPI;
    }

    /**
     * Returns the book history a p i with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param name the primary key of the book history a p i
     * @return the book history a p i, or <code>null</code> if a book history a p i with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BookHistoryAPI fetchByPrimaryKey(String name)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) name);
    }

    /**
     * Returns all the book history a p is.
     *
     * @return the book history a p is
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BookHistoryAPI> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the book history a p is.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.BookHistoryAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of book history a p is
     * @param end the upper bound of the range of book history a p is (not inclusive)
     * @return the range of book history a p is
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BookHistoryAPI> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the book history a p is.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.BookHistoryAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of book history a p is
     * @param end the upper bound of the range of book history a p is (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of book history a p is
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BookHistoryAPI> findAll(int start, int end,
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

        List<BookHistoryAPI> list = (List<BookHistoryAPI>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BOOKHISTORYAPI);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BOOKHISTORYAPI;

                if (pagination) {
                    sql = sql.concat(BookHistoryAPIModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<BookHistoryAPI>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BookHistoryAPI>(list);
                } else {
                    list = (List<BookHistoryAPI>) QueryUtil.list(q,
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
     * Removes all the book history a p is from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (BookHistoryAPI bookHistoryAPI : findAll()) {
            remove(bookHistoryAPI);
        }
    }

    /**
     * Returns the number of book history a p is.
     *
     * @return the number of book history a p is
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

                Query q = session.createQuery(_SQL_COUNT_BOOKHISTORYAPI);

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
     * Initializes the book history a p i persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.BookHistoryAPI")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<BookHistoryAPI>> listenersList = new ArrayList<ModelListener<BookHistoryAPI>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<BookHistoryAPI>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BookHistoryAPIImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
