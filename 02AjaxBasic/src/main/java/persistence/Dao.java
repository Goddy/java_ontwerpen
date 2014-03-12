package persistence;

/**
 * User: Tom De Dobbeleer
 * Date: 2/3/14
 * Time: 7:48 PM
 * Remarks: none
 */
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends Object> {
    Session getSession();
    void create(T t);
    T get(Serializable id);
    T load(Serializable id);
    List<T> getAll();
    void update(T t);
    void delete(T t);
    void deleteById(Serializable id);
    void deleteAll();
    long count();
    boolean exists(Serializable id);
}
