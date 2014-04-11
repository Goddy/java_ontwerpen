package factory;

import model.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by u0090265 on 3/28/14.
 */
public class TestObjectFactory {

    public static Client getTestClient() {
        Client client = new Client(randomString(), randomNumeric(10), getTestAddress(), getTestAddress(), null);
        client.setContacts(getTestContacts(client, 2));
        return client;
    }

    public static ServiceCall createServiceCall(Client client, Employee employee) {
        return new ServiceCall(randomString(), randomString(), employee, client);
    }

    public static Address getTestAddress() {
        return new Address(randomInt(4), randomString(), randomInt(2), randomString(), randomString());
    }

    public static List<Contact> getTestContacts(Client client, int count) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new Contact(randomString(), TestDaoFactory.getContactTypeDao().get(oneOrTwo()), client));
        }
        return contacts;
    }

    private static int randomInt(int count) {
        return Integer.parseInt(randomNumeric(count));
    }

    private static String randomString() {
        return randomAlphabetic(6);
    }

    private static long oneOrTwo() {
        return (long)(Math.random() * 2) + 1;
    }

    public static Employee getTestEmployee() {
        return new Employee(randomString(), randomString(), randomString(), randomString(), new Role(RoleEnum.ADMIN));
    }

}
