<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2/4/14
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty result}">
    <div class="${resultDiv}">${result}</div>
</c:if>
<form class="form-horizontal" role="form" id="form-register" action="/registerServiceCall" method="post">
    <input type="hidden" name="clientId" value="${clientId}">
    <div class="form-group">
        <label for="description" class="col-sm-2 control-label">Uitgebreide omschrijving</label>
        <div class="col-sm-10">
            <textarea class="form-control" name="description" id="description" placeholder="Omschrijving"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="shortDescription" class="col-sm-2 control-label">Korte beschrijving</label>
        <div class="col-sm-10">
            <textarea class="form-control" name="shortDescription" id="shortDescription" placeholder="Omschrijving"></textarea>
        </div>
    </div>

    <div class="form-group">
        <label for="employeeId" class="col-sm-2 control-label">Naam</label>
        <div class="col-sm-10">
            <select class="form-control" id="employeeId" name="employeeId" placeholder="Verantwoordelijke">
                <c:forEach var="employee" items="${employees}">
                    <option value="${employee.id}">${employee.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit"  class="btn btn-default" value="Registreer"/>
        </div>
    </div>
</form>

<script src="../js/jquery.validate.min.js"></script>
<script src="../js/registerClient.js"></script>

<%@ include file="../jspf/footer.jspf" %>
