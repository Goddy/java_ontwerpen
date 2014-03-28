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

import static org.easymock.EasyMock.createNiceMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by u0090265 on 3/28/14.
 */
public class ClientServiceImplTest extends AbstractTest {
    ClientServiceImpl clientService;

    @Before
    public void setUp() {

    }

    @Test
    public void testRegisterClient() throws Exception {
        final Client testClient = TestObjectFactory.getTestClient();
        final Address testAddress = TestObjectFactory.getTestAddress();
        final List<Contact> testContacts = TestObjectFactory.getTestContacts(testClient, 2);
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
        HttpServletRequest request = createNiceMock(HttpServletRequest.class);
        clientService.setContactTypeDao(contactTypeDao);
        clientService.setClientDao(clientDao);

        clientService.registerClient(request);

        Client resultClient = clientDao.get(testClient.getId());
        assertNotNull(resultClient);
        assertEquals(testClient, resultClient);
    }

    @Test
    public void testSearchForClients() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {

    }

    @Test
    public void testGetClientFromRequest() throws Exception {

    }

    @Test
    public void testGetContactListFromRequest() throws Exception {

    }

    @Test
    public void testGetContactFromRequest() throws Exception {

    }

    @Test
    public void testGetAddressFromRequest() throws Exception {

    }
}
