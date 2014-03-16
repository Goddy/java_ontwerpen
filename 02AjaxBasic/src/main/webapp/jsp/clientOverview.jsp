
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../jspf/header.jspf" %>
<table class="table">
    <tr>
        <td>Id</td>
        <td>${client.id}</td>
    </tr>
    <tr>
        <td>Naam</td>
        <td>${client.name}</td>
    </tr>
    <tr>
        <td>vat</td>
        <td>${client.vat}</td>
    </tr>
    <tr>
        <td>Facturatieadres</td>
        <td>
            Straat: ${client.invoiceAddress.street}<br>
            Nummer: ${client.invoiceAddress.number}<br>
            Postcode: ${client.invoiceAddress.postalCode}<br>
            Stad: ${client.invoiceAddress.city}<br>
            Land: ${client.invoiceAddress.country}<br>
        </td>
    </tr>
    <tr>
        <td>Leveringsadres</td>
        <td>
            Straat: ${client.deliveryAddress.street}<br>
            Nummer: ${client.deliveryAddress.number}<br>
            Postcode: ${client.deliveryAddress.postalCode}<br>
            Stad: ${client.deliveryAddress.city}<br>
            Land: ${client.deliveryAddress.country}<br>
        </td>
    </tr>
    <tr>
        <td>Contactgegevens</td>
        <td>
            <c:forEach var="contact" items="${client.contacts}">
                ${contact.contactData} (${contact.contactType.type})<br>
            </c:forEach>
        </td>
    </tr>
</table>
<button type="button" class="btn button-primary"  onclick="xmlRequest('/getObjects?op=serviceCallsForClient&clientId=${client.id}', 'sc-xml', 'serviceCall', 'get')">Service Oproepen</button></br>
<div id="sc-xml"></div>
<script src="../js/ajaxUtils.js" type="text/javascript"></script>
<%@ include file="../jspf/footer.jspf" %>
