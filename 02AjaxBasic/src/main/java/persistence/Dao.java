package persistence;

/**
 * User: Tom De Dobbeleer
 * Date: 2/3/14
 * Time: 7:48 PM
 * Remarks: none
 */

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Dao<T extends Object> {
    EntityManager getEntityManager();
    void createAll(List <T> tList);
    void create(T t);
    T get(Serializable id);
    List<T> getAll();
    void delete(T t);
    void deleteById(Serializable id);
    void deleteAll();
    long count();
    List<T> getMultipleResultQuery(String query, Map<String, ? extends Object> parameterMap);
    T getSingleResultQuery(String query, Map<String, ? extends Object> parameterMap);
    boolean exists(Serializable id);
}
