package servlets;

//import com.google.gson.reflect.TypeToken;
import model.Client;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import service.ClientService;
import service.ServiceFactory;
import utils.HtmlHelper;
//import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import static utils.Constants.*;

/**
 * User: Tom De Dobbeleer
 * Date: 2/11/14
 * Time: 8:09 PM
 * Remarks: none
 */
@WebServlet("/searchClient")
public class SearchClientServlet extends HttpServlet {

    ClientService clientService = ServiceFactory.getClientService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        String result;
        String type = request.getParameter("type");
        String search = request.getParameter("search");
        List<Client> clientList = clientService.searchForClient(search, type);

        if (clientList != null && !clientList.isEmpty()) {
            result = returnJsonObject(clientList);
        }
        else {
            result = RESULT_NO_RESULTS;
        }

        PrintWriter out = response.getWriter();
        out.print(result);
    }

    private String returnJsonObject (List<Client> clientList) {
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
