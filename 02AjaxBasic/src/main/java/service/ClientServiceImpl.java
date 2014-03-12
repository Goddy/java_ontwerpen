package service;

import model.*;
import org.hibernate.Query;
import org.hibernate.Transaction;
import persistence.ClientDao;
import persistence.DaoFactory;
import static utils.Constants.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:53 PM
 * Remarks: none
 */
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    public ClientServiceImpl() {
        this.clientDao = DaoFactory.getClientDao();

    }

    @Override
    public void registerClient(HttpServletRequest request) {
        //Get data
        Client client = getClientFromRequest(request);
        Address address = getAddressFromRequest(request);
        List<Contact> contacts = getContactListFromRequest(request);

        //Add referenced data
        client.setDeliveryAddress(address);
        client.setInvoiceAddress(address);
        client.getContacts().addAll(contacts);
        addClientToContacts(client, contacts);

        //register all
        clientDao.registerClient(client, address, contacts);
    }

    private void addClientToContacts(Client client, List<Contact> contacts) {
        for (Contact contact : contacts) {
            contact.setClient(client);
        }
    }

    @Override
    public List<Client> searchForClient(String searchTerm, String type) {
        switch (type) {
            case SEARCH_TYPE_ID:
                List<Client> clients = new ArrayList<>();
                clients.add(clientDao.findClientById(searchTerm));
                return clients;
            case SEARCH_TYPE_NAME:
                return clientDao.findClientByName(searchTerm);
            default:
                return null;
        }
    }

    @Override
    public List<Client> getAll() {
        return clientDao.getClients();
    }

    @Override
    public Client getClientById(String id) {
        Transaction tx = null;
        try {
            tx = clientDao.getSession().beginTransaction();
            Client client = clientDao.findClientById(id);
            tx.commit();
            return client;
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e; // or display error message
        }
        finally {
            clientDao.getSession().close();
        }
    }

    public Client getClientFromRequest(HttpServletRequest request) {
        Client client = new Client();
        client.setName(request.getParameter("name"));
        client.setVat(request.getParameter("vat"));

        return client;
    }

    public List<Contact> getContactListFromRequest (HttpServletRequest request) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(getContactFromRequest(request, CONTACTTYPE_EMAIL));
        contacts.add(getContactFromRequest(request, CONTACTTYPE_PHONE));
        return contacts;
    }

    public Contact getContactFromRequest(HttpServletRequest request, String type) {
        Contact contact = new Contact();
        contact.setContactType(clientDao.findContactTypeByName(type));
        contact.setContactData(request.getParameter(type));
        return contact;
    }

    public Address getAddressFromRequest(HttpServletRequest request) {
        Address address = new Address();
        address.setCity(request.getParameter("city"));
        address.setNumber(Integer.parseInt(request.getParameter("number")));
        address.setStreet(request.getParameter("street"));
        address.setCountry(request.getParameter("country"));
        address.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));
        address.setActive(true);

        return address;
    }
}
