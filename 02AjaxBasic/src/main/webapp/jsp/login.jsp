<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../jspf/header.jspf" %>

<form role="form">
    <div class="form-group">
        <label for="username">Email address</label>
        <input type="email" class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>

    <button type="submit" class="btn btn-default">Submit</button>
</form>

<%@ include file="../jspf/footer.jspf" %>
