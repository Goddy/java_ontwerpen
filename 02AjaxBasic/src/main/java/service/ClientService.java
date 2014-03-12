package service;

import model.Client;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:52 PM
 * Remarks: none
 */
public interface ClientService {
    void registerClient(HttpServletRequest request);
    List<Client> searchForClient(String searchTerm, String type);
    List<Client> getAll();
    Client getClientById(String id);
}
