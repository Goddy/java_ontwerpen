package persistence;

/**
 * User: Tom De Dobbeleer
 * Date: 2/3/14
 * Time: 7:49 PM
 * Remarks: none
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractHbnDao<T extends Object>
        implements Dao<T> {


    private SessionFactory sessionFactory;
    private Class<T> domainClass;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
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
    public void create(T t) {
         getSession().save(t);
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        return (T) getSession().get(getDomainClass(), id);
    }
    @SuppressWarnings("unchecked")
    public T load(Serializable id) {
        return (T) getSession().load(getDomainClass(), id);
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return getSession()
                .createQuery("from " + getDomainClassName())
                .list();
    }

    public void update(T t) { getSession().update(t); }
    public void delete(T t) { getSession().delete(t); }
    public void deleteById(Serializable id) { delete(load(id)); }
    public void deleteAll() {
        getSession()
                .createQuery("delete " + getDomainClassName())
                .executeUpdate();
    }
    public long count() {
        return (Long) getSession()
                .createQuery("select count(*) from " + getDomainClassName())
                .uniqueResult();
    }
    public boolean exists(Serializable id) { return (get(id) != null); }
}
