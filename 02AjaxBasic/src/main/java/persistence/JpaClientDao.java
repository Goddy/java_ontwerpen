package persistence;

import model.Client;
import model.ContactType;

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
    public void registerClient(Client client) {
        super.create(client);
    }

    @Override
    public ContactType findContactTypeByName(String type) {
        return null;
        //return (ContactType)getSingleResultQuery("findContactTypeByType", getParameterMap("type", type));
    }

    @Override
    public Client findClientById(Long id) {
        return getSingleResultQuery("findClientById", getParameterMap("id", id));
    }

    @Override
    public List<Client> getClients() {
        return getMultipleResultQuery("getClients", null);
    }

    @Override
    public List<Client> findClientByName(String name) {
        return getMultipleResultQuery("findClientByName", getParameterMap("name", "%" + name + "%"));
    }
}
