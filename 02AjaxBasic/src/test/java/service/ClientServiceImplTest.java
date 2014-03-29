package service;

import factory.TestObjectFactory;
import general.AbstractTest;
import model.Address;
import model.Client;
import model.Contact;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import static utils.Constants.*;

/**
 * Created by u0090265 on 3/28/14.
 */
public class ClientServiceImplTest extends AbstractTest {
    ClientService clientService;
    final Client testClient = TestObjectFactory.getTestClient();
    final Address testAddress = TestObjectFactory.getTestAddress();
    final List<Contact> testContacts = TestObjectFactory.getTestContacts(testClient, 2);
    HttpServletRequest request;

    @Before
    public void setUp() {
        request = createNiceMock(HttpServletRequest.class);
    }

    @Test
    public void testRegisterClient() throws Exception {
        clientService = new ClientServiceImpl() {
            @Override
            public Client getClientFromRequest(HttpServletRequest request) {
                return testClient;
            }
            @Override
            public List<Contact> getContactListFromRequest (HttpServletRequest request) {
                return testContacts;
            }
            @Override
            public Address getAddressFromRequest(HttpServletRequest request) {
                return testAddress;
            }
        };

        setDaos();

        clientService.registerClient(request);

        Client resultClient = clientDao.get(testClient.getId());
        assertNotNull(resultClient);
        assertEquals(testClient, resultClient);
    }

    @Test
    public void testSearchForClientsById() throws Exception {
        clientDao.create(testClient);
        clientService = new ClientServiceImpl();
        setDaos();
        List<Client> clients = clientService.searchForClients(String.valueOf(testClient.getId()), SEARCH_TYPE_ID);
        assertTrue(clients.contains(testClient));
    }

    @Test
    public void testSearchForClientsByName() throws Exception {
        clientDao.create(testClient);
        clientService = new ClientServiceImpl();
        setDaos();
        List<Client> clients = clientService.searchForClients(testClient.getName(), SEARCH_TYPE_NAME);
        assertTrue(clients.contains(testClient));
    }


    @Test
    public void testGetClientFromRequest() throws Exception {
        expect(request.getParameter("name")).andReturn(testClient.getName());
        expect(request.getParameter("vat")).andReturn(testClient.getVat());
        replay(request);
        clientService = new ClientServiceImpl();
        setDaos();

        Client client = clientService.getClientFromRequest(request);
        assertEquals(client.getName(), testClient.getName());
        assertEquals(client.getVat(), testClient.getVat());

        verify(request);
    }

    @Test
    public void testGetContactListFromRequest() throws Exception {
        clientService = new ClientServiceImpl() {
            @Override
            public Contact getContactFromRequest(HttpServletRequest request, String type) {
                return testContacts.get(0);
            }
        };

        List<Contact> contactList = clientService.getContactListFromRequest(request);
        assertNotNull(contactList);
        for (Contact c : contactList) {
            assertEquals(c, testContacts.get(0));
        }
    }

    @Test
    public void testGetContactFromRequest() throws Exception {
        String data = testContacts.get(1).getContactData();
        expect(request.getParameter(CONTACTTYPE_PHONE)).andReturn(data);
        replay(request);
        clientService = new ClientServiceImpl();
        setDaos();

        Contact contact = clientService.getContactFromRequest(request, CONTACTTYPE_PHONE);

        assertEquals(contact.getContactType().getType(), CONTACTTYPE_PHONE);
        assertEquals(contact.getContactData(), data);

        verify(request);
    }

    @Test
    public void testGetAddressFromRequest() throws Exception {
        expect(request.getParameter("city")).andReturn(testAddress.getCity());
        expect(request.getParameter("number")).andReturn(String.valueOf(testAddress.getNumber()));
        expect(request.getParameter("street")).andReturn(testAddress.getStreet());
        expect(request.getParameter("country")).andReturn(testAddress.getCountry());
        expect(request.getParameter("postalCode")).andReturn(String.valueOf(testAddress.getPostalCode()));
        replay(request);

        clientService = new ClientServiceImpl();
        setDaos();

        Address address = clientService.getAddressFromRequest(request);

        assertEquals(address.getCity(), testAddress.getCity());
        assertEquals(address.getCountry(), testAddress.getCountry());
        assertEquals(address.getNumber(), testAddress.getNumber());
        assertEquals(address.getPostalCode(), testAddress.getPostalCode());
        assertEquals(address.getStreet(), testAddress.getStreet());
        assertTrue(address.isActive());

        verify(request);
    }

    private void setDaos() {
        clientService.setClientDao(clientDao);
        clientService.setContactTypeDao(contactTypeDao);
    }
}
