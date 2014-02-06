package persistence;

import model.Client;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:58 PM
 * Remarks: none
 */
public interface ClientDao {
    void registerClient(Client client);
}
