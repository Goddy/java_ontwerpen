package service;

import model.Address;
import model.AddressType;
import model.Client;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:52 PM
 * Remarks: none
 */
public interface RegisterClientService {
    void registerClient(Client client, Address address);
    AddressType getAddressType(long id);
}
