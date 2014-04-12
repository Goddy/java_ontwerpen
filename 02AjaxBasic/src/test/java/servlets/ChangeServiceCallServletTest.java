package servlets;

import general.AbstractTest;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

/**
 * Created by u0090265 on 3/29/14.
 */
public class ChangeServiceCallServletTest extends AbstractTest {
    static final ChangeServiceCallServlet changeServiceCallServlet = new ChangeServiceCallServlet();


    public void testDoGet() throws Exception {
        expect(httpServletRequestMock.getParameter("id")).andReturn("1");
        httpServletRequestMock.setAttribute("serviceCallId", "1");
        replay(httpServletRequestMock);
        changeServiceCallServlet.doGet(httpServletRequestMock, httpServletResponseMock);
    }

    @Test
    public void testDoPost() throws Exception {

    }
}
