<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../jspf/header.jspf" %>
<ol class="breadcrumb">
    <li><a href="#">Registreer medewerker</a></li>
</ol>
<c:if test="${not empty result}">
    <div class="${resultDiv}">${result}</div>
</c:if>
<form class="form-horizontal" role="form" id="form-register" action="/registerEmployee.html" method="post">
    <div class="form-group">
        <label for="lastName" class="col-sm-2 control-label">Naam</label>
        <div class="col-sm-10">
            <input class="form-control" id="lastName" name="lastName" placeholder="Naam">
        </div>
    </div>
    <div class="form-group">
        <label for="firstName" class="col-sm-2 control-label">Voornaam</label>
        <div class="col-sm-10">
            <input class="form-control" name="firstName" id="firstName" placeholder="Voornaam">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">email adres</label>
        <div class="col-sm-10">
            <input class="form-control" name="email" id="email" placeholder="Email">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Wachtwoord</label>
        <div class="col-sm-10">
        <input type="password" class="form-control" id="password" name="password">
        </div>
    </div>
    <div class="form-group">
        <label for="passwordRep" class="col-sm-2 control-label">Herhaal wachtwoord</label>
        <div class="col-sm-10">
        <input type="password" class="form-control" id="passwordRep" name="passwordRep">
        </div>
    </div>
    <div class="form-group">
        <label for="role" class="col-sm-2 control-label">Rol</label>
        <div class="col-sm-10">
            <select class="form-control" id="role" name="role" placeholder="Rol">
                <c:forEach var="role" items="${roles}">
                    <option value="${role}">${role}</option>
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
<script src="../js/registerEmployee.js" type="text/javascript"></script>

<%@ include file="../jspf/footer.jspf" %>
