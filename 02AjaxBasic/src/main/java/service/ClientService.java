package service;

import model.Address;
import model.Client;
import model.Contact;
import persistence.ClientDao;
import persistence.ContactTypeDao;

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
    List<Client> searchForClients(String searchTerm, String type);
    List<Client> getAll();
    Client getClientById(String id);
    void setContactTypeDao(ContactTypeDao contactTypeDao);

    Client getClientFromRequest(HttpServletRequest request);

    List<Contact> getContactListFromRequest(HttpServletRequest request);

    Contact getContactFromRequest(HttpServletRequest request, String type);

    Address getAddressFromRequest(HttpServletRequest request);

    void setClientDao(ClientDao clientDao);
}
