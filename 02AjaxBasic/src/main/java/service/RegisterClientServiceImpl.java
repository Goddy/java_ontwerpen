package service;

import model.Client;
import persistence.ClientDao;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:53 PM
 * Remarks: none
 */
public class RegisterClientServiceImpl implements RegisterClientService {

    private ClientDao clientDao;

    public RegisterClientServiceImpl ( ClientDao dao) {
        this.clientDao = dao;

    }

    @Override
    public void registerClient(Client client) {
        clientDao.registerClient(client);
    }
}
