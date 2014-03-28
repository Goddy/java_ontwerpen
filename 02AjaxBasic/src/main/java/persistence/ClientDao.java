package persistence;

import model.Client;

import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:58 PM
 * Remarks: none
 */
public interface ClientDao extends Dao<Client> {
    List<Client> findClientByName(String name);
}
