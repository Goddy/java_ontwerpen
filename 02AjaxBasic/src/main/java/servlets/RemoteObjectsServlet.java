package servlets;

//import com.google.gson.reflect.TypeToken;

import model.Client;
import model.ServiceCall;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import service.ClientService;
import service.ServiceCallService;
import service.ServiceFactory;
import utils.HtmlHelper;
import utils.ServiceCallXmlWrapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static utils.Constants.RESULT_NO_RESULTS;
import static utils.Constants.SC_XML_RESULT;

//import com.google.gson.Gson;

/**
 * User: Tom De Dobbeleer
 * Date: 2/11/14
 * Time: 8:09 PM
 * Remarks: none
 */
@WebServlet("/getObjects.html")
public class RemoteObjectsServlet extends MainServlet {

    private ClientService clientService = ServiceFactory.getClientService();
    private ServiceCallService serviceCallService = ServiceFactory.getSerViceCallService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        switch (request.getParameter("op")) {
            case "searchClients":
                returnClients(request, response);
                break;
            case "allClients":
                returnAllClients(request, response);
                break;
            case "serviceCallsForClient":
                returnServiceCall(request, response);
                break;
            case "serviceCalls":
                returnAllServiceCalls(request, response);
                break;
            default:
                print(response, "Wrong request");
        }
    }

    private void returnAllClients(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Client> clientList = getClientService().getAll();

        if (clientList != null && !clientList.isEmpty()) {
            print(response, toJsonObject(clientList));
        }
        else {
            print(response, RESULT_NO_RESULTS);
        }
    }

    private void returnAllServiceCalls(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ServiceCall> serviceCallList = getServiceCallService().getAllServiceCalls();
        if (serviceCallList != null && !serviceCallList.isEmpty()) {
            //response.setContentType("text/xml");
            request.setAttribute("serviceCalls", serviceCallList);
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher(SC_XML_RESULT);
            dispatcher.include(request, response);
            //print(response, toXmlObject(serviceCallList));
        }
    }

    private void print(HttpServletResponse response, String input) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(input);
    }

    private void returnClients(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String search = request.getParameter("search");
        List<Client> clientList = getClientService().searchForClients(search, type);

        if (clientList != null && !clientList.isEmpty()) {
            print(response, toJsonObject(clientList));
        }
        else {
            print(response, RESULT_NO_RESULTS);
        }
    }

    private void returnServiceCall(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String id = request.getParameter("clientId");
        Client client = getClientService().getClientById(id);
        List<ServiceCall> serviceCallList = getServiceCallService().getServiceCallForClient(client);
        if (serviceCallList != null && !serviceCallList.isEmpty()) {
            response.setContentType("text/xml");
            request.setAttribute("serviceCalls", serviceCallList);
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher(SC_XML_RESULT);
            dispatcher.include(request, response);
        }
    }

    private String toJsonObject(List<Client> clientList) {
        String json = null;
        try {
        org.codehaus.jackson.map.ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        json = ow.writeValueAsString(clientList);

        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return json;
        }



        /**try {
        //Type listType = new TypeToken<List<Client>>() {}.getType();
        Gson gson = new Gson();
        //return gson.toJson(clientList, listType);
        return  gson.toJson(clientList.get(0));
        }
        catch (Exception e) {
            return e.getMessage();
        }
         **/
    }

    private String returnJsp(List<Client> clientList) {
        return HtmlHelper.ClientListToTable(clientList);
    }

    private static String toXmlObject(List<ServiceCall> serviceCalls) {

        try {
            ServiceCallXmlWrapper wrapper = new ServiceCallXmlWrapper(serviceCalls);
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(ServiceCall.class, ServiceCallXmlWrapper.class);
            Marshaller m = context.createMarshaller();

            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Write to File
            m.marshal(wrapper, sw);

            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ServiceCallService getServiceCallService() {
        return serviceCallService;
    }

    public void setServiceCallService(ServiceCallService serviceCallService) {
        this.serviceCallService = serviceCallService;
    }
}
