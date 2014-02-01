package controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.easymock.EasyMock.*;

/**
 * User: Tom De Dobbeleer
 * Date: 1/27/14
 * Time: 5:11 PM
 * Remarks: none
 */

@RunWith(JUnit4.class)
public class WelcomeControllerTest {

    WelcomeController welcomeController;
    HttpServletRequest request;
    HttpServletResponse response;
    private static String TESTNAME = "test";

    @Before
    public void setUp() throws Exception {
        welcomeController = new WelcomeController();
        request = createNiceMock(HttpServletRequest.class);
        response = createNiceMock(HttpServletResponse.class);
    }

    @Test
    public void testDoGetNameSet() throws Exception {
        expect(request.getParameter("name")).andReturn(TESTNAME);
        expect(request.getRequestDispatcher(Constants.LANDING_WELCOME)).andReturn(createNiceMock(RequestDispatcher.class));
        replay(request);

        welcomeController.doGet(request, response);
        verify();
    }

    @Test
    public void testDoGetNoNameSet() throws Exception {
        expect(request.getParameter("name")).andReturn("");
        expect(request.getRequestDispatcher(Constants.LANDING_ERROR)).andReturn(createNiceMock(RequestDispatcher.class));
        replay(request);

        welcomeController.doGet(request, response);

        verify(request);
    }
}
