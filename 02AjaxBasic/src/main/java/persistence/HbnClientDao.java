package persistence;

import model.Client;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:54 PM
 * Remarks: none
 */
public class HbnClientDao extends AbstractHbnDao implements ClientDao {
    @Override
    public void registerClient(Client client) {
        super.create(client);
    }
}
