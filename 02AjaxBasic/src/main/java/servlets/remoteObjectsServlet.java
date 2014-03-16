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
//import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import static utils.Constants.*;

/**
 * User: Tom De Dobbeleer
 * Date: 2/11/14
 * Time: 8:09 PM
 * Remarks: none
 */
@WebServlet("/getObjects")
public class remoteObjectsServlet extends MainServlet {

    ClientService clientService = ServiceFactory.getClientService();
    ServiceCallService serviceCallService =  ServiceFactory.getSerViceCallService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        String result;
        switch (request.getParameter("op")) {
            case "allClients":
                result = returnClients(request);
                break;
            case "serviceCallsForClient":
                result = returnServiceCalls(request);
                break;
            default:
                result= "Wrong request";
        }

        PrintWriter out = response.getWriter();
        out.print(result);
    }

    private String returnClients(HttpServletRequest request) {
        String type = request.getParameter("type");
        String search = request.getParameter("search");
        List<Client> clientList = clientService.searchForClients(search, type);

        if (clientList != null && !clientList.isEmpty()) {
            return toJsonObject(clientList);
        }
        else {
            return RESULT_NO_RESULTS;
        }
    }

    private String returnServiceCalls (HttpServletRequest request) {
        String id = request.getParameter("clientId");
        Client client = clientService.getClientById(id);
        List<ServiceCall> serviceCallList = serviceCallService.getServiceCallForClient(client);
        if (serviceCallList != null && !serviceCallList.isEmpty()) {
            return toXmlObject(serviceCallList);
        }
        else {
            return RESULT_NO_RESULTS;
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

}
