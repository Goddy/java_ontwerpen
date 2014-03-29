package persistence;

/**
 * User: Tom De Dobbeleer
 * Date: 2/3/14
 * Time: 7:49 PM
 * Remarks: none
 */

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractJpaDao<T>
        implements Dao<T> {

    private EntityManager entityManager;
    private Class<T> domainClass;

    public AbstractJpaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getMultipleResultQuery(String query, Map<String, ? extends Object> parameterMap) {
        Query q = getEntityManager().createNamedQuery(query, getDomainClass());
        setParameters(q, parameterMap);
        return (List<T>)q.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getSingleResultQuery(String query, Map<String, ? extends Object> parameterMap) {
        Query q = getEntityManager().createNamedQuery(query, getDomainClass());
        setParameters(q, parameterMap);
        return (T)q.getSingleResult();
    }

    private void setParameters(Query q, Map<String, ? extends Object> parameterMap) {
        if (parameterMap != null) {
            for (Map.Entry<String, ? extends Object> entry : parameterMap.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType =
                    (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass =
                    (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    private String getDomainClassName() {
        return getDomainClass().getName();
    }

    public void createAll(List<T> tList) {
        for (T t: tList) {
            create(t);
        }
    }
    public void create(T t) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(t);
            getEntityManager().getTransaction().commit();
        }
        catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        return getEntityManager().find(getDomainClass(), id);
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        try {
            getEntityManager().getTransaction().begin();
            List <T> list = getEntityManager()
                    .createQuery("select x from " + getDomainClassName() + " x")
                    .getResultList();
            getEntityManager().getTransaction().commit();
            return list;
        }
        catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            throw e;
        }
    }

    public void delete(T t) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(t);
            getEntityManager().getTransaction().commit();
        }
        catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            throw e;
        }
    }
    public void deleteById(Serializable id) {
        delete(get(id));
    }
    public void deleteAll() {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager()
                    .createQuery("delete from " + getDomainClassName() + " x")
                    .executeUpdate();
            getEntityManager().getTransaction().commit();
        }
        catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            throw e;
        }

    }
    public long count() {
        return (Long) getEntityManager()
                .createQuery("select count(*) from " + getDomainClassName())
                .getSingleResult();
    }
    public boolean exists(Serializable id) { return (get(id) != null); }
    public Map<String, Object> getParameterMap(String key, Object value) {
        Map<String, Object> result = new HashMap<>();
        result.put(key, value);
        return result;
    }
}
