package persistence;

import model.*;

import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:58 PM
 * Remarks: none
 */
public interface ClientDao {
    void registerClient(Client client, Address address, List<Contact> contacts);
    List<Client> findClientByName(String name);
    List<Client> findClientById(Long id);
    ContactType findContactTypeByName(String type);

}
