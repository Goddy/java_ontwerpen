package service;

import model.*;
import persistence.ClientDao;
import persistence.DaoFactory;
import static utils.Constants.*;

import javax.servlet.http.HttpServletRequest;
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
        clientDao.registerClient(getClientFromRequest(request), getAddressFromRequest(request));
    }

    @Override
    public AddressType getAddressType(long id) {
        return clientDao.findAddressTypeById(id);
    }

    @Override
    public List<Client> searchForClient(String searchTerm, String type) {
        switch (type) {
            case SEARCH_TYPE_ID:
                return clientDao.findClientById(Long.parseLong(searchTerm));
            case SEARCH_TYPE_NAME:
                return clientDao.findClientByName(searchTerm);
            default:
                return null;
        }
    }

    public Client getClientFromRequest(HttpServletRequest request) {
        Client client = new Client();
        client.setName(request.getParameter("name"));
        client.setPrimaryEmail(getContactFromRequest(request, CONTACTTYPE_EMAIL));
        client.setPrimaryPhone(getContactFromRequest(request, CONTACTTYPE_PHONE));
        client.setVat(request.getParameter("vat"));

        return client;
    }

    public Contact getContactFromRequest(HttpServletRequest request, String type) {
        Contact contact = new Contact();
        contact.setContactType(clientDao.findContactTypeByName(type));
        contact.setContactData(request.getParameter(type));
        return contact;
    }

    public Address getAddressFromRequest(HttpServletRequest request) {
        Address address = new Address();
        AddressType addressType = getAddressType(Long.parseLong("1"));
        address.setType(addressType);
        address.setCity(request.getParameter("city"));
        address.setNumber(Integer.parseInt(request.getParameter("number")));
        address.setStreet(request.getParameter("street"));
        address.setCountry(request.getParameter("country"));
        address.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));
        address.setActive(true);

        return address;
    }
}
