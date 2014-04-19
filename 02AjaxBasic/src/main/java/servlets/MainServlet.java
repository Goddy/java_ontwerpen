package servlets;

import model.ServiceCall;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import static utils.Constants.LANDING_GENERAL_ERROR_PAGE;

/**
 * Created by u0090265 on 3/16/14.
 */
public abstract class MainServlet extends HttpServlet {

    protected void errorPage(HttpServletRequest request, HttpServletResponse response, String message) throws IOException, ServletException {
        request.setAttribute("title", "Error");
        request.setAttribute("reason", message);
        getPage(request, response, LANDING_GENERAL_ERROR_PAGE);
    }
    protected void getPage(HttpServletRequest request, HttpServletResponse response, String landing) throws IOException, ServletException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(landing);
        dispatcher.forward(request, response);
    }

    protected void setErrorMsg(HttpServletRequest request, String msg) {
        request.setAttribute("resultDiv", "alert alert-danger");
        request.setAttribute("result", msg);
    }

    protected void setSuccessMsg (HttpServletRequest request, String msg) {
        request.setAttribute("resultDiv", "alert alert-success");
        request.setAttribute("result", msg);
    }

    protected void setWarningMsg(HttpServletRequest request, String msg) {
        request.setAttribute("resultDiv", "alert alert-warning");
        request.setAttribute("result", msg);
    }

    protected static String toXmlObject(List<ServiceCall> serviceCalls) {

        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(ServiceCall.class);
            Marshaller m = context.createMarshaller();

            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Write to File
            for (ServiceCall serviceCall: serviceCalls) {
                m.marshal(serviceCall, sw);
            }

            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
