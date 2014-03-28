package persistence;

import model.Client;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by u0090265 on 3/25/14.
 */

public class JpaClientDaoTest {

    ClientDao clientDao = TestDaoFactory.getClientDao();

    @Test
    public void testFindClientByName() {
        Client client = TestObjectFactory.getTestClient();
        clientDao.create(client);
        assertNotNull(clientDao.findClientByName(client.getName()));
    }
}
