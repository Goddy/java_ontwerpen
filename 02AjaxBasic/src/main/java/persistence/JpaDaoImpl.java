package persistence;


import javax.persistence.EntityManager;

/**
 * Created by u0090265 on 3/13/14.
 */
public class JpaDaoImpl extends AbstractJpaDao<Entity> implements Dao<Entity> {
    public JpaDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
