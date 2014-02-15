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
<script src="../js/registerClient.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<c:if test="${not empty result}">
<div class="${resultDiv}">${result}</div>
</c:if>
<form class="form-horizontal" role="form" id="form-register" action="/registerClient" method="post">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Naam</label>
        <div class="col-sm-10">
            <input class="form-control" id="name" name="name" placeholder="Naam">
        </div>
    </div>
    <div class="form-group">
        <label for="vat" class="col-sm-2 control-label">Btw-nr</label>
        <div class="col-sm-10">
            <input class="form-control" name="vat" id="vat" placeholder="BTW-nr">
        </div>
    </div>
    <div class="form-group">
        <label for="street" class="col-sm-2 control-label">Straat</label>
        <div class="col-sm-10">
            <input class="form-control" name="street" id="street" placeholder="Straat">
        </div>
    </div>
    <div class="form-group">
        <label for="number" class="col-sm-2 control-label">Nummer</label>
        <div class="col-sm-10">
            <input class="form-control" name="number" id="number" placeholder="Nummer">
        </div>
    </div>
    <div class="form-group">
        <label for="postalCode" class="col-sm-2 control-label">Postcode</label>
        <div class="col-sm-10">
            <input class="form-control" name="postalCode" id="postalCode" placeholder="Postcode">
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="col-sm-2 control-label">Woonplaats</label>
        <div class="col-sm-10">
            <input class="form-control" id="city" name="city" placeholder="Woonplaats">
        </div>
    </div>
    <div class="form-group">
        <label for="country" class="col-sm-2 control-label">Land</label>
        <div class="col-sm-10">
            <input class="form-control" id="country" name="country" placeholder="Land">
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">TelefoonNr</label>
        <div class="col-sm-10">
            <input class="form-control" id="phone" name="phone" placeholder="TelefoonNr">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
            <input class="form-control" id="email" name="email" placeholder="Email">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit"  class="btn btn-default" value="Registreer"/>
        </div>
    </div>
</form>

<%@ include file="../jspf/footer.jspf" %>
