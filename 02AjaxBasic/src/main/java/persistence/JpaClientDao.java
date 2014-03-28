package persistence;

import model.Client;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:54 PM
 * Remarks: none
 */

public class JpaClientDao extends AbstractJpaDao<Client> implements ClientDao {

    public JpaClientDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Client> findClientByName(String name) {
        return getMultipleResultQuery("findClientByName", getParameterMap("name", "%" + name + "%"));
    }
}
