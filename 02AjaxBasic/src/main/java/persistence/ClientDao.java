package persistence;

import model.Client;
import model.ContactType;

import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:58 PM
 * Remarks: none
 */
public interface ClientDao extends Dao<Client> {
    void registerClient(Client client);
    List<Client> findClientByName(String name);
    Client findClientById(Long id);
    List<Client> getClients();
    ContactType findContactTypeByName(String type);
}
