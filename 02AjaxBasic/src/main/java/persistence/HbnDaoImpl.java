package persistence;

import org.hibernate.SessionFactory;

/**
 * Created by u0090265 on 3/13/14.
 */
public class HbnDaoImpl extends AbstractHbnDao<Entity> implements Dao<Entity> {
    public HbnDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
