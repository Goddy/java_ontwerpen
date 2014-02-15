<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>
<script src="../js/searchClient.js"></script>

<form role="form">
    <div class="form-group">
        <label for="id">Zoek op id</label>
        <input class="form-control" id="id" placeholder="id">
    </div>
    <div class="form-group">
        <label for="name">Zoek op naam</label>
        <input class="form-control" id="name" placeholder="naam">
    </div>
    <button type="button" class="btn btn-default" onclick="submitSearch('/searchClient', 'result')">Zoeken</button>
    <img id="loader" src="../images/loading.gif" height="20" width="20" style="display: none;">
</form>
<div id="result"></div>
<%@ include file="../jspf/footer.jspf" %>
