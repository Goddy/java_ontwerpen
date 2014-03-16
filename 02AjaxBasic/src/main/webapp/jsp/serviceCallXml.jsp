<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<serviceCalls>
    <headings>
        <heading>Id</heading>
        <heading>Korte omschrijving</heading>
        <heading>Omschrijving</heading>
        <heading>Open datum</heading>
        <heading>Afgesloten datum</heading>
        <heading>Acties</heading>
    </headings>
    <c:forEach var="sc" items="${serviceCalls}">
    <serviceCall>
        <id>${sc.id}</id>
        <shortDescription>${sc.shortDescription}</shortDescription>
        <description>${sc.description}</description>
        <opened>${sc.opened}</opened>
        <closed>
            <c:if test="${empty sc.closed}">
                Geen einddatum
            </c:if>
        </closed>
        <actions>&lt;a class="glyphicon glyphicon-list" href="/changeServiceCall?id=${sc.id}"&gt;&lt;/a&gt;</actions>
    </serviceCall>
    </c:forEach>
</serviceCalls>

