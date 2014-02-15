package persistence;

import model.Address;
import model.AddressType;
import model.Client;
import model.ContactType;

import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:58 PM
 * Remarks: none
 */
public interface ClientDao {
    void registerClient(Client client, Address address);
    AddressType findAddressTypeById(Long id);
    List<Client> findClientByName(String name);
    List<Client> findClientById(Long id);
    ContactType findContactTypeByName(String type);

}
