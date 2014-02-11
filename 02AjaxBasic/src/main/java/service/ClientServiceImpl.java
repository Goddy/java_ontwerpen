package service;

import model.Address;
import model.AddressType;
import model.Client;
import persistence.ClientDao;
import persistence.DaoFactory;

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


    public AddressType getAddressType(long id) {
        return clientDao.findAddressTypeById(id);
    }

    @Override
    public List<Client> searchForClient(String searchTerm) {
        return null;
    }

    public Client getClientFromRequest(HttpServletRequest request) {
        Client client = new Client();
        client.setName(request.getParameter("name"));
        client.setPrimaryEmail(request.getParameter("email"));
        client.setPrimaryPhone(request.getParameter("telNr"));
        client.setVat(request.getParameter("vat"));

        return client;
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
        return address;
    }
}
