package servlets;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.easymock.EasyMock.*;

/**
 * Created by u0090265 on 3/29/14.
 */
public class ChangeServiceCallServletTest {
    static final ChangeServiceCallServlet changeServiceCallServlet = new ChangeServiceCallServlet();
    HttpServletRequest httpServletRequestMock;
    HttpServletResponse httpServletResponseMock;

    @Before
    public void setUp() {
        httpServletRequestMock = createStrictMock(HttpServletRequest.class);
        httpServletResponseMock = createStrictMock(HttpServletResponse.class);
    }

    @Test
    public void testDoGet() throws Exception {
        expect(httpServletRequestMock.getParameter("id")).andReturn("1");
        replay(httpServletRequestMock);
        changeServiceCallServlet.doGet(httpServletRequestMock, httpServletResponseMock);
    }

    @Test
    public void testDoPost() throws Exception {

    }
}
