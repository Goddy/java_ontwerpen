package persistence;

import model.Address;
import model.Client;
import model.Contact;
import model.ContactType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by u0090265 on 3/25/14.
 */

public class JpaClientDaoTest {

    ClientDao clientDao = TestDaoFactory.getClientDao();


    @Test
    public void testRegisterClient() throws Exception {
        Client client = getTestClient();
        clientDao.registerClient(client);

        assertNotNull(client.getId());
        assertTrue(clientDao.exists(client.getId()));

    }

    @Test
    public void testFindContactTypeByName() throws Exception {

    }

    @Test
    public void testFindClientById() throws Exception {

    }

    @Test
    public void testGetClients() throws Exception {

    }

    @Test
    public void testFindClientByName() throws Exception {

    }

    Client getTestClient() {
        Client client = new Client("testName", "testVat", getTestAddress(), getTestAddress(), null);
        client.setContacts(getTestContacts(client));
        return client;
    }

    Address getTestAddress() {
        return new Address(1500, "testStreet", 1, "testCity", "testCountry");
    }

    List<Contact> getTestContacts(Client client) {
        ArrayList<Contact> contacts = new ArrayList<>();
        ContactType contactType = new ContactType("gsm");
        contactType.setId(Long.parseLong("1"));
        contacts.add(new Contact("testContact", contactType, client));
        return contacts;
    }
}
