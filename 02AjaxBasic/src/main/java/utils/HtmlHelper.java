package utils;

import model.Client;

import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/15/14
 * Time: 9:15 AM
 * Remarks: none
 */
public class HtmlHelper {
    public static String ClientListToTable(List<Client> clientList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table class=table>")
                .append("<thead><tr><th>Id</th><th>Naam</th></tr></thead><tbody>");

        for (Client client:clientList) {
            stringBuilder.append("<tr><td>")
                    .append(client.getId())
                    .append("</td><td>")
                    .append(client.getName())
                    .append("</td></tr>");
        }

        stringBuilder.append("</tbody></table>");

        return stringBuilder.toString();
    }
}
