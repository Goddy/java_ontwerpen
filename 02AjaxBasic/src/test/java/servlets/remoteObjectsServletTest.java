package servlets;

import factory.TestObjectFactory;
import general.AbstractTest;
import model.ServiceCall;
import org.junit.Before;
import org.junit.Test;
import service.ServiceCallService;

import java.util.List;

import static org.easymock.EasyMock.*;

/**
 * Created by u0090265 on 4/25/14.
 */
public class remoteObjectsServletTest extends AbstractTest {
    ServiceCallService serviceCallServiceMock;
    RemoteObjectsServlet remoteObjectsServlet;

    @Before
    public void setUp() {
        serviceCallServiceMock = createStrictMock(ServiceCallService.class);
        remoteObjectsServlet = new RemoteObjectsServlet();
        remoteObjectsServlet.setServiceCallService(serviceCallServiceMock);
    }

    @Test
    public void testDoGetXmlObj() throws Exception {
        List<ServiceCall> serviceCalls = TestObjectFactory.createServiceCallList(3);
        expect(httpServletRequestMock.getParameter("op")).andReturn("serviceCalls");
        expect(serviceCallServiceMock.getAllServiceCalls()).andReturn(serviceCalls);
        replay(httpServletRequestMock, serviceCallServiceMock);
    }
}
