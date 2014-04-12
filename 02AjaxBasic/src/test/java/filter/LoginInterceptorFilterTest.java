package filter;

import factory.TestObjectFactory;
import general.AbstractTest;
import model.Employee;
import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpSession;

import static org.easymock.EasyMock.*;
import static utils.Constants.*;

/**
 * Created by u0090265 on 4/11/14.
 */
public class LoginInterceptorFilterTest extends AbstractTest {
    HttpSession sessionMock;
    FilterChain chainMock;

    @Test
    public void testDoFilterAdminPageAsAdmin() throws Exception {
        setUpTest("/admin.html", ROLETYPE_ADMIN, true, true);
        chainMock.doFilter(httpServletRequestMock, httpServletResponseMock);
        expectLastCall();
        replayAll();
        doFilter();
        verifyAll();
    }

    @Test
    public void testDoFilterAdminPageAsNormal() throws Exception {
        setUpTest("/admin.html", ROLETYPE_NORMAL, true, true);
        httpServletResponseMock.sendRedirect(LANDING_HTML_NOT_AUTHORIZED);
        replayAll();
        doFilter();
        verifyAll();


    }

    @Test
    public void testDoFilterAdminPageWithNoSession() throws Exception {
        setUpTest("/admin.html", null, false, true);
        httpServletResponseMock.sendRedirect(LANDING_HTML_LOGIN);
        replayAll();
        doFilter();
        verifyAll();
    }

    @Test
    public void testDoFilterNormalPageWithNoSession() throws Exception {
        setUpTest("/normal.html", null, false, true);
        httpServletResponseMock.sendRedirect(LANDING_HTML_LOGIN);
        replayAll();
        doFilter();
        verifyAll();
    }

    @Test
    public void testDoFilterNormalPageWithNoEmployee() throws Exception {
        setUpTest("/normal.html", null, true, false);
        httpServletResponseMock.sendRedirect(LANDING_HTML_LOGIN);
        replayAll();
        doFilter();
        verifyAll();
    }

    @Test
    public void testDoFilterAdminPageWithNoEmployee() throws Exception {
        setUpTest("/admin.html", null, true, false);
        httpServletResponseMock.sendRedirect(LANDING_HTML_LOGIN);
        replayAll();
        doFilter();
        verifyAll();
    }


    private void setUpTest(String uri, String employeeRole, boolean setSession, boolean employeeSet) {
        Employee employee = TestObjectFactory.getTestEmployee(employeeRole);
        sessionMock = createNiceMock(HttpSession.class);
        chainMock = createNiceMock(FilterChain.class);
        expect(super.httpServletRequestMock.getRequestURI()).andReturn(uri);
        if (setSession) {
            expect(super.httpServletRequestMock.getSession(false)).andReturn(sessionMock);
            expect(sessionMock.getAttribute("employee")).andReturn(employeeSet ? employee : null);
        } else {
            expect(super.httpServletRequestMock.getSession(false)).andReturn(null);
        }

    }

    private void doFilter() throws Exception {
        LoginInterceptorFilter filter = new LoginInterceptorFilter();
        filter.setRoleMappingDao(roleMappingDao);
        filter.setRoleDao(roleDao);
        filter.doFilter(httpServletRequestMock, httpServletResponseMock, chainMock);
    }

    private void replayAll() {
        replay(sessionMock, chainMock, httpServletRequestMock, httpServletResponseMock);
    }

    private void verifyAll() {
        verify(sessionMock, chainMock, httpServletRequestMock, httpServletResponseMock);
    }
}
