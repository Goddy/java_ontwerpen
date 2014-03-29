package service;

import model.Address;
import model.Client;
import model.Contact;
import persistence.ClientDao;
import persistence.ContactTypeDao;
import persistence.DaoFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.*;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:53 PM
 * Remarks: none
 */
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;
    private ContactTypeDao contactTypeDao;

    public ClientServiceImpl() {
        this.setClientDao(DaoFactory.getClientDao());
        this.setContactTypeDao(DaoFactory.getContactTypeDao());
    }

    public ClientServiceImpl(ClientDao clientDao, ContactTypeDao contactTypeDao) {
        this.setClientDao(clientDao);
        this.setContactTypeDao(contactTypeDao);

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
        getClientDao().create(client);
    }

    private void addClientToContacts(Client client, List<Contact> contacts) {
        for (Contact contact : contacts) {
            contact.setClient(client);
        }
    }

    @Override
    public List<Client> searchForClients(String searchTerm, String type) {
        switch (type) {
            case SEARCH_TYPE_ID:
                List<Client> clients = new ArrayList<>();
                clients.add(getClientDao().get(Long.parseLong(searchTerm)));
                return clients;
            case SEARCH_TYPE_NAME:
                return getClientDao().findClientByName(searchTerm);
            default:
                return null;
        }
    }

    @Override
    public List<Client> getAll() {
        return getClientDao().getAll();
    }

    @Override
    public Client getClientById(String id) {
        return getClientDao().get(Long.parseLong(id));
    }

    @Override
    public Client getClientFromRequest(HttpServletRequest request) {
        Client client = new Client();
        client.setName(request.getParameter("name"));
        client.setVat(request.getParameter("vat"));

        return client;
    }

    @Override
    public List<Contact> getContactListFromRequest (HttpServletRequest request) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(getContactFromRequest(request, CONTACTTYPE_EMAIL));
        contacts.add(getContactFromRequest(request, CONTACTTYPE_PHONE));
        return contacts;
    }

    @Override
    public Contact getContactFromRequest(HttpServletRequest request, String type) {
        Contact contact = new Contact();
        contact.setContactType(getContactTypeDao().findContactTypeByType(type));
        contact.setContactData(request.getParameter(type));
        return contact;
    }

    @Override
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

    public ClientDao getClientDao() {
        return clientDao;
    }

    @Override
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ContactTypeDao getContactTypeDao() {
        return contactTypeDao;
    }

    @Override
    public void setContactTypeDao(ContactTypeDao contactTypeDao) {
        this.contactTypeDao = contactTypeDao;
    }
}
