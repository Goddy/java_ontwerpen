package persistence;

import model.*;

import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:58 PM
 * Remarks: none
 */
public interface ClientDao extends Dao<Object> {
    void registerClient(Client client, Address address, List<Contact> contacts);
    List<Client> findClientByName(String name);
    Client findClientById(Long id);
    List<Client> getClients();
    ContactType findContactTypeByName(String type);
}
