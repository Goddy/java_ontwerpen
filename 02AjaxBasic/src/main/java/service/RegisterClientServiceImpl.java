package service;

import model.Address;
import model.AddressType;
import model.Client;
import persistence.ClientDao;
import persistence.DaoFactory;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:53 PM
 * Remarks: none
 */
public class RegisterClientServiceImpl implements RegisterClientService {

    private ClientDao clientDao;

    public RegisterClientServiceImpl () {
        this.clientDao = DaoFactory.getHbnClientDao();

    }

    @Override
    public void registerClient(Client client, Address address) {
        clientDao.registerClient(client, address);
    }


    public AddressType getAddressType(long id) {
        return clientDao.findAddressTypeById(id);
    }
}
