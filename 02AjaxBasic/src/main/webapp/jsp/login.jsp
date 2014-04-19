<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../jspf/header.jspf" %>
<ol class="breadcrumb">
    <li><a href="#">Inloggen</a></li>
</ol>
<c:if test="${not empty result}">
    <div class="${resultDiv}">${result}</div>
</c:if>
<form role="form" id="form-login" action="/login.html" method="post">
    <div class="form-group">
        <label for="username">Username</label>
        <input class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="password">Wachtwoord</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>

    <button type="submit" class="btn btn-default">Inloggen</button>
</form>

<%@ include file="../jspf/footer.jspf" %>
<script src="../js/jquery.validate.min.js"></script>
<script src="../js/login.js"></script>
