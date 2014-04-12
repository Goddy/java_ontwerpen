package persistence;

import factory.TestObjectFactory;
import general.AbstractTest;
import model.Client;
import model.Employee;
import model.ServiceCall;
import org.junit.Test;
import utils.Constants;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by u0090265 on 3/28/14.
 */
public class JpaServiceCallDaoTest extends AbstractTest {

    @Test
    public void testGetServiceCallsForClient() throws Exception {
        Client client = TestObjectFactory.getTestClient();
        Employee employee = TestObjectFactory.getTestEmployee(Constants.ROLETYPE_NORMAL);
        ServiceCall serviceCall1 = TestObjectFactory.createServiceCall(client, employee);
        ServiceCall serviceCall2 = TestObjectFactory.createServiceCall(client, employee);
        serviceCallDao.create(serviceCall1);
        serviceCallDao.create(serviceCall2);

        List<ServiceCall> serviceCallForClient = serviceCallDao.getServiceCallsForClient(client);
        assertTrue(serviceCallForClient.contains(serviceCall1));
        assertTrue(serviceCallForClient.contains(serviceCall2));
        for (ServiceCall sc : serviceCallForClient) {
            assertEquals(sc.getClient(), client);
        }

    }
}
