package persistence;

import model.ContactType;

import javax.persistence.EntityManager;

/**
 * Created by u0090265 on 3/26/14.
 */
public class JpaContactTypeDao extends AbstractJpaDao<ContactType> implements ContactTypeDao {
    public JpaContactTypeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ContactType findContactTypeByType(String type) {
        return getSingleResultQuery("findContactTypeByType", getParameterMap("type", type));
    }
}
