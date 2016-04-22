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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import fi.csc.avaa.khl.db.NoSuchVanhatkirjatException;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.khl.db.model.impl.VanhatkirjatImpl;
import fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl;
import fi.csc.avaa.khl.db.service.persistence.VanhatkirjatPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vanhatkirjat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CSC
 * @see VanhatkirjatPersistence
 * @see VanhatkirjatUtil
 * @generated
 */
public class VanhatkirjatPersistenceImpl extends BasePersistenceImpl<Vanhatkirjat>
    implements VanhatkirjatPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link VanhatkirjatUtil} to access the vanhatkirjat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = VanhatkirjatImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatModelImpl.FINDER_CACHE_ENABLED, VanhatkirjatImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatModelImpl.FINDER_CACHE_ENABLED, VanhatkirjatImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHSTATUS =
        new FinderPath(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatModelImpl.FINDER_CACHE_ENABLED, VanhatkirjatImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishStatus",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS =
        new FinderPath(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatModelImpl.FINDER_CACHE_ENABLED, VanhatkirjatImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishStatus",
            new String[] { Integer.class.getName() },
            VanhatkirjatModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHSTATUS = new FinderPath(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishStatus",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_PUBLISHSTATUS_STATUS_2 = "vanhatkirjat.status = ?";
    private static final String _SQL_SELECT_VANHATKIRJAT = "SELECT vanhatkirjat FROM Vanhatkirjat vanhatkirjat";
    private static final String _SQL_SELECT_VANHATKIRJAT_WHERE = "SELECT vanhatkirjat FROM Vanhatkirjat vanhatkirjat WHERE ";
    private static final String _SQL_COUNT_VANHATKIRJAT = "SELECT COUNT(vanhatkirjat) FROM Vanhatkirjat vanhatkirjat";
    private static final String _SQL_COUNT_VANHATKIRJAT_WHERE = "SELECT COUNT(vanhatkirjat) FROM Vanhatkirjat vanhatkirjat WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "vanhatkirjat.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Vanhatkirjat exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Vanhatkirjat exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(VanhatkirjatPersistenceImpl.class);
    private static Vanhatkirjat _nullVanhatkirjat = new VanhatkirjatImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Vanhatkirjat> toCacheModel() {
                return _nullVanhatkirjatCacheModel;
            }
        };

    private static CacheModel<Vanhatkirjat> _nullVanhatkirjatCacheModel = new CacheModel<Vanhatkirjat>() {
            @Override
            public Vanhatkirjat toEntityModel() {
                return _nullVanhatkirjat;
            }
        };

    public VanhatkirjatPersistenceImpl() {
        setModelClass(Vanhatkirjat.class);
    }

    /**
     * Returns all the vanhatkirjats where status = &#63;.
     *
     * @param status the status
     * @return the matching vanhatkirjats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Vanhatkirjat> findByPublishStatus(int status)
        throws SystemException {
        return findByPublishStatus(status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the vanhatkirjats where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of vanhatkirjats
     * @param end the upper bound of the range of vanhatkirjats (not inclusive)
     * @return the range of matching vanhatkirjats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Vanhatkirjat> findByPublishStatus(int status, int start, int end)
        throws SystemException {
        return findByPublishStatus(status, start, end, null);
    }

    /**
     * Returns an ordered range of all the vanhatkirjats where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of vanhatkirjats
     * @param end the upper bound of the range of vanhatkirjats (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching vanhatkirjats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Vanhatkirjat> findByPublishStatus(int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS;
            finderArgs = new Object[] { status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHSTATUS;
            finderArgs = new Object[] { status, start, end, orderByComparator };
        }

        List<Vanhatkirjat> list = (List<Vanhatkirjat>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Vanhatkirjat vanhatkirjat : list) {
                if ((status != vanhatkirjat.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_VANHATKIRJAT_WHERE);

            query.append(_FINDER_COLUMN_PUBLISHSTATUS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(VanhatkirjatModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Vanhatkirjat>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Vanhatkirjat>(list);
                } else {
                    list = (List<Vanhatkirjat>) QueryUtil.list(q, getDialect(),
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
     * Returns the first vanhatkirjat in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching vanhatkirjat
     * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat findByPublishStatus_First(int status,
        OrderByComparator orderByComparator)
        throws NoSuchVanhatkirjatException, SystemException {
        Vanhatkirjat vanhatkirjat = fetchByPublishStatus_First(status,
                orderByComparator);

        if (vanhatkirjat != null) {
            return vanhatkirjat;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchVanhatkirjatException(msg.toString());
    }

    /**
     * Returns the first vanhatkirjat in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat fetchByPublishStatus_First(int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Vanhatkirjat> list = findByPublishStatus(status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last vanhatkirjat in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching vanhatkirjat
     * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a matching vanhatkirjat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat findByPublishStatus_Last(int status,
        OrderByComparator orderByComparator)
        throws NoSuchVanhatkirjatException, SystemException {
        Vanhatkirjat vanhatkirjat = fetchByPublishStatus_Last(status,
                orderByComparator);

        if (vanhatkirjat != null) {
            return vanhatkirjat;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchVanhatkirjatException(msg.toString());
    }

    /**
     * Returns the last vanhatkirjat in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching vanhatkirjat, or <code>null</code> if a matching vanhatkirjat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat fetchByPublishStatus_Last(int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPublishStatus(status);

        if (count == 0) {
            return null;
        }

        List<Vanhatkirjat> list = findByPublishStatus(status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the vanhatkirjats before and after the current vanhatkirjat in the ordered set where status = &#63;.
     *
     * @param vkid the primary key of the current vanhatkirjat
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next vanhatkirjat
     * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat[] findByPublishStatus_PrevAndNext(int vkid, int status,
        OrderByComparator orderByComparator)
        throws NoSuchVanhatkirjatException, SystemException {
        Vanhatkirjat vanhatkirjat = findByPrimaryKey(vkid);

        Session session = null;

        try {
            session = openSession();

            Vanhatkirjat[] array = new VanhatkirjatImpl[3];

            array[0] = getByPublishStatus_PrevAndNext(session, vanhatkirjat,
                    status, orderByComparator, true);

            array[1] = vanhatkirjat;

            array[2] = getByPublishStatus_PrevAndNext(session, vanhatkirjat,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Vanhatkirjat getByPublishStatus_PrevAndNext(Session session,
        Vanhatkirjat vanhatkirjat, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_VANHATKIRJAT_WHERE);

        query.append(_FINDER_COLUMN_PUBLISHSTATUS_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(VanhatkirjatModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(vanhatkirjat);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Vanhatkirjat> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the vanhatkirjats where status = &#63; from the database.
     *
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPublishStatus(int status) throws SystemException {
        for (Vanhatkirjat vanhatkirjat : findByPublishStatus(status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(vanhatkirjat);
        }
    }

    /**
     * Returns the number of vanhatkirjats where status = &#63;.
     *
     * @param status the status
     * @return the number of matching vanhatkirjats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPublishStatus(int status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHSTATUS;

        Object[] finderArgs = new Object[] { status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_VANHATKIRJAT_WHERE);

            query.append(_FINDER_COLUMN_PUBLISHSTATUS_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

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
     * Caches the vanhatkirjat in the entity cache if it is enabled.
     *
     * @param vanhatkirjat the vanhatkirjat
     */
    @Override
    public void cacheResult(Vanhatkirjat vanhatkirjat) {
        EntityCacheUtil.putResult(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatImpl.class, vanhatkirjat.getPrimaryKey(), vanhatkirjat);

        vanhatkirjat.resetOriginalValues();
    }

    /**
     * Caches the vanhatkirjats in the entity cache if it is enabled.
     *
     * @param vanhatkirjats the vanhatkirjats
     */
    @Override
    public void cacheResult(List<Vanhatkirjat> vanhatkirjats) {
        for (Vanhatkirjat vanhatkirjat : vanhatkirjats) {
            if (EntityCacheUtil.getResult(
                        VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
                        VanhatkirjatImpl.class, vanhatkirjat.getPrimaryKey()) == null) {
                cacheResult(vanhatkirjat);
            } else {
                vanhatkirjat.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all vanhatkirjats.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(VanhatkirjatImpl.class.getName());
        }

        EntityCacheUtil.clearCache(VanhatkirjatImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the vanhatkirjat.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Vanhatkirjat vanhatkirjat) {
        EntityCacheUtil.removeResult(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatImpl.class, vanhatkirjat.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Vanhatkirjat> vanhatkirjats) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Vanhatkirjat vanhatkirjat : vanhatkirjats) {
            EntityCacheUtil.removeResult(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
                VanhatkirjatImpl.class, vanhatkirjat.getPrimaryKey());
        }
    }

    /**
     * Creates a new vanhatkirjat with the primary key. Does not add the vanhatkirjat to the database.
     *
     * @param vkid the primary key for the new vanhatkirjat
     * @return the new vanhatkirjat
     */
    @Override
    public Vanhatkirjat create(int vkid) {
        Vanhatkirjat vanhatkirjat = new VanhatkirjatImpl();

        vanhatkirjat.setNew(true);
        vanhatkirjat.setPrimaryKey(vkid);

        return vanhatkirjat;
    }

    /**
     * Removes the vanhatkirjat with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param vkid the primary key of the vanhatkirjat
     * @return the vanhatkirjat that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat remove(int vkid)
        throws NoSuchVanhatkirjatException, SystemException {
        return remove((Serializable) vkid);
    }

    /**
     * Removes the vanhatkirjat with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the vanhatkirjat
     * @return the vanhatkirjat that was removed
     * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat remove(Serializable primaryKey)
        throws NoSuchVanhatkirjatException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Vanhatkirjat vanhatkirjat = (Vanhatkirjat) session.get(VanhatkirjatImpl.class,
                    primaryKey);

            if (vanhatkirjat == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchVanhatkirjatException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(vanhatkirjat);
        } catch (NoSuchVanhatkirjatException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Vanhatkirjat removeImpl(Vanhatkirjat vanhatkirjat)
        throws SystemException {
        vanhatkirjat = toUnwrappedModel(vanhatkirjat);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(vanhatkirjat)) {
                vanhatkirjat = (Vanhatkirjat) session.get(VanhatkirjatImpl.class,
                        vanhatkirjat.getPrimaryKeyObj());
            }

            if (vanhatkirjat != null) {
                session.delete(vanhatkirjat);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (vanhatkirjat != null) {
            clearCache(vanhatkirjat);
        }

        return vanhatkirjat;
    }

    @Override
    public Vanhatkirjat updateImpl(
        fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat)
        throws SystemException {
        vanhatkirjat = toUnwrappedModel(vanhatkirjat);

        boolean isNew = vanhatkirjat.isNew();

        VanhatkirjatModelImpl vanhatkirjatModelImpl = (VanhatkirjatModelImpl) vanhatkirjat;

        Session session = null;

        try {
            session = openSession();

            if (vanhatkirjat.isNew()) {
                session.save(vanhatkirjat);

                vanhatkirjat.setNew(false);
            } else {
                session.merge(vanhatkirjat);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !VanhatkirjatModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((vanhatkirjatModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        vanhatkirjatModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHSTATUS,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS,
                    args);

                args = new Object[] { vanhatkirjatModelImpl.getStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHSTATUS,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS,
                    args);
            }
        }

        EntityCacheUtil.putResult(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
            VanhatkirjatImpl.class, vanhatkirjat.getPrimaryKey(), vanhatkirjat);

        return vanhatkirjat;
    }

    protected Vanhatkirjat toUnwrappedModel(Vanhatkirjat vanhatkirjat) {
        if (vanhatkirjat instanceof VanhatkirjatImpl) {
            return vanhatkirjat;
        }

        VanhatkirjatImpl vanhatkirjatImpl = new VanhatkirjatImpl();

        vanhatkirjatImpl.setNew(vanhatkirjat.isNew());
        vanhatkirjatImpl.setPrimaryKey(vanhatkirjat.getPrimaryKey());

        vanhatkirjatImpl.setVkid(vanhatkirjat.getVkid());
        vanhatkirjatImpl.setKuntaid(vanhatkirjat.getKuntaid());
        vanhatkirjatImpl.setMaakuntaid(vanhatkirjat.getMaakuntaid());
        vanhatkirjatImpl.setLomakenum(vanhatkirjat.getLomakenum());
        vanhatkirjatImpl.setPaivays(vanhatkirjat.getPaivays());
        vanhatkirjatImpl.setKartkohde(vanhatkirjat.getKartkohde());
        vanhatkirjatImpl.setTekija(vanhatkirjat.getTekija());
        vanhatkirjatImpl.setTeoknimi(vanhatkirjat.getTeoknimi());
        vanhatkirjatImpl.setPainovuosi(vanhatkirjat.getPainovuosi());
        vanhatkirjatImpl.setPainopaikka(vanhatkirjat.getPainopaikka());
        vanhatkirjatImpl.setKirjapaino(vanhatkirjat.getKirjapaino());
        vanhatkirjatImpl.setPainosmerk(vanhatkirjat.getPainosmerk());
        vanhatkirjatImpl.setImprimatur(vanhatkirjat.getImprimatur());
        vanhatkirjatImpl.setKuvitus(vanhatkirjat.getKuvitus());
        vanhatkirjatImpl.setKartat(vanhatkirjat.getKartat());
        vanhatkirjatImpl.setLiitteita(vanhatkirjat.getLiitteita());
        vanhatkirjatImpl.setNimikirj(vanhatkirjat.getNimikirj());
        vanhatkirjatImpl.setSinetti(vanhatkirjat.getSinetti());
        vanhatkirjatImpl.setLeima(vanhatkirjat.getLeima());
        vanhatkirjatImpl.setExlibris(vanhatkirjat.getExlibris());
        vanhatkirjatImpl.setHintamerk(vanhatkirjat.getHintamerk());
        vanhatkirjatImpl.setOmiste(vanhatkirjat.getOmiste());
        vanhatkirjatImpl.setReunamerk(vanhatkirjat.getReunamerk());
        vanhatkirjatImpl.setLisatieto(vanhatkirjat.getLisatieto());
        vanhatkirjatImpl.setLahosoite(vanhatkirjat.getLahosoite());
        vanhatkirjatImpl.setLahemail(vanhatkirjat.getLahemail());
        vanhatkirjatImpl.setStatus(vanhatkirjat.getStatus());
        vanhatkirjatImpl.setKieliid(vanhatkirjat.getKieliid());
        vanhatkirjatImpl.setKielestaid(vanhatkirjat.getKielestaid());
        vanhatkirjatImpl.setJulklajiid(vanhatkirjat.getJulklajiid());
        vanhatkirjatImpl.setKuntoid(vanhatkirjat.getKuntoid());
        vanhatkirjatImpl.setPuuteid(vanhatkirjat.getPuuteid());
        vanhatkirjatImpl.setTeospkid(vanhatkirjat.getTeospkid());
        vanhatkirjatImpl.setSidonta(vanhatkirjat.getSidonta());
        vanhatkirjatImpl.setKokoelma(vanhatkirjat.getKokoelma());
        vanhatkirjatImpl.setPoistettu(vanhatkirjat.getPoistettu());
        vanhatkirjatImpl.setMuokattu(vanhatkirjat.getMuokattu());

        return vanhatkirjatImpl;
    }

    /**
     * Returns the vanhatkirjat with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the vanhatkirjat
     * @return the vanhatkirjat
     * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat findByPrimaryKey(Serializable primaryKey)
        throws NoSuchVanhatkirjatException, SystemException {
        Vanhatkirjat vanhatkirjat = fetchByPrimaryKey(primaryKey);

        if (vanhatkirjat == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchVanhatkirjatException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return vanhatkirjat;
    }

    /**
     * Returns the vanhatkirjat with the primary key or throws a {@link fi.csc.avaa.khl.db.NoSuchVanhatkirjatException} if it could not be found.
     *
     * @param vkid the primary key of the vanhatkirjat
     * @return the vanhatkirjat
     * @throws fi.csc.avaa.khl.db.NoSuchVanhatkirjatException if a vanhatkirjat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat findByPrimaryKey(int vkid)
        throws NoSuchVanhatkirjatException, SystemException {
        return findByPrimaryKey((Serializable) vkid);
    }

    /**
     * Returns the vanhatkirjat with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the vanhatkirjat
     * @return the vanhatkirjat, or <code>null</code> if a vanhatkirjat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Vanhatkirjat vanhatkirjat = (Vanhatkirjat) EntityCacheUtil.getResult(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
                VanhatkirjatImpl.class, primaryKey);

        if (vanhatkirjat == _nullVanhatkirjat) {
            return null;
        }

        if (vanhatkirjat == null) {
            Session session = null;

            try {
                session = openSession();

                vanhatkirjat = (Vanhatkirjat) session.get(VanhatkirjatImpl.class,
                        primaryKey);

                if (vanhatkirjat != null) {
                    cacheResult(vanhatkirjat);
                } else {
                    EntityCacheUtil.putResult(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
                        VanhatkirjatImpl.class, primaryKey, _nullVanhatkirjat);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(VanhatkirjatModelImpl.ENTITY_CACHE_ENABLED,
                    VanhatkirjatImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return vanhatkirjat;
    }

    /**
     * Returns the vanhatkirjat with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param vkid the primary key of the vanhatkirjat
     * @return the vanhatkirjat, or <code>null</code> if a vanhatkirjat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Vanhatkirjat fetchByPrimaryKey(int vkid) throws SystemException {
        return fetchByPrimaryKey((Serializable) vkid);
    }

    /**
     * Returns all the vanhatkirjats.
     *
     * @return the vanhatkirjats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Vanhatkirjat> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the vanhatkirjats.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of vanhatkirjats
     * @param end the upper bound of the range of vanhatkirjats (not inclusive)
     * @return the range of vanhatkirjats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Vanhatkirjat> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the vanhatkirjats.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of vanhatkirjats
     * @param end the upper bound of the range of vanhatkirjats (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of vanhatkirjats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Vanhatkirjat> findAll(int start, int end,
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

        List<Vanhatkirjat> list = (List<Vanhatkirjat>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_VANHATKIRJAT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_VANHATKIRJAT;

                if (pagination) {
                    sql = sql.concat(VanhatkirjatModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Vanhatkirjat>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Vanhatkirjat>(list);
                } else {
                    list = (List<Vanhatkirjat>) QueryUtil.list(q, getDialect(),
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
     * Removes all the vanhatkirjats from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Vanhatkirjat vanhatkirjat : findAll()) {
            remove(vanhatkirjat);
        }
    }

    /**
     * Returns the number of vanhatkirjats.
     *
     * @return the number of vanhatkirjats
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

                Query q = session.createQuery(_SQL_COUNT_VANHATKIRJAT);

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
     * Initializes the vanhatkirjat persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.csc.avaa.khl.db.model.Vanhatkirjat")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Vanhatkirjat>> listenersList = new ArrayList<ModelListener<Vanhatkirjat>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Vanhatkirjat>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(VanhatkirjatImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
