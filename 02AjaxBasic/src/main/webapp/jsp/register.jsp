<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2/4/14
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>
<script src="../js/ajaxUtils.js" type="text/javascript"></script>

<form class="form-horizontal" role="form" action="/registerClient" method="POST">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Naam</label>
        <div class="col-sm-10">
            <input class="form-control" id="name" placeholder="Naam">
        </div>
    </div>
    <div class="form-group">
        <label for="vat" class="col-sm-2 control-label">Btw-nr</label>
        <div class="col-sm-10">
            <input class="form-control" id="vat" placeholder="BTW-nr">
        </div>
    </div>
    <div class="form-group">
        <label for="street" class="col-sm-2 control-label">Straat</label>
        <div class="col-sm-10">
            <input class="form-control" id="street" placeholder="Straat">
        </div>
    </div>
    <div class="form-group">
        <label for="postalCode" class="col-sm-2 control-label">Postcode</label>
        <div class="col-sm-10">
            <input class="form-control" id="postalCode" placeholder="Postcode">
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="col-sm-2 control-label">Woonplaats</label>
        <div class="col-sm-10">
            <input class="form-control" id="city" placeholder="Woonplaats">
        </div>
    </div>
    <div class="form-group">
        <label for="country" class="col-sm-2 control-label">Land</label>
        <div class="col-sm-10">
            <input class="form-control" id="country" placeholder="Land">
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">TelefoonNr</label>
        <div class="col-sm-10">
            <input class="form-control" id="phone" placeholder="TelefoonNr">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
            <input class="form-control" id="email" placeholder="Email">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit"  class="btn btn-default" value="Registreer" onclick="ajaxResult('/registerClient', 'result' )"/>
        </div>
    </div>
</form>
<div id="result">${result}</div>

<%@ include file="../jspf/footer.jspf" %>
