<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2/4/14
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/registerClient" method="POST">
    <table>
        <tr><td>Naam:</td><td><input type="text" name="name"></td></tr>
        <tr><td>BTW-nr:</td><td><input type="text" name="btwnr"></td></tr>
        <tr><td>Straat</td><td><input type="text" name="street"></td></tr>
        <tr><td>Nummer:</td><td><input type="text" name="nummer"></td></tr>
        <tr><td>Postcode:</td><td><input type="text" name="postalCode"></td></tr>
        <tr><td>Woonplaats:</td><td><input type="text" name="city"></td></tr>
        <tr><td>Land:</td><td><input type="text" name="country"></td></tr>
        <tr><td>TelefoonNr:</td><td><input type="text" name="telNr"></td></tr>
        <tr><td>Email:</td><td><input type="text" name="email"></td></tr>
        <tr><td><input type="submit" value="Submit" /></td></tr>
    </table>
</form>
</body>
</html>
