<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2/11/14
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<form class="form-inline" role="form">
    <div class="form-group">
        <label class="sr-only" for="searchId">Id zoeken</label>
        <input type="id" class="form-control" id="searchId" placeholder="Id zoeken">
    </div>
    <div class="form-group">
        <label class="sr-only" for="searchName">Naam zoeken</label>
        <input type="name" class="form-control" id="searchName" placeholder="Naam Zoeken">
    </div>
    <button type="submit" class="btn btn-default">Zoeken</button>
</form>

</body>
</html>
