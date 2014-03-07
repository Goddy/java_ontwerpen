<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>

<form role="form" id="searchForm">
    <div class="form-group">
        <label for="id">Zoek op id</label>
        <input class="form-control" id="id" name="id" placeholder="id">
    </div>
    <div class="form-group">
        <label for="name">Zoek op naam</label>
        <input class="form-control" id="name" name="name" placeholder="naam">
    </div>
    <button type="button" class="btn btn-default" onclick='submitSearch("/searchClient",this.form, "result", "GET")'>Zoeken</button>
    <img id="loader" src="../images/loading.gif" height="20" width="20" style="display: none;">
</form>
<div id="result">
<%@ include file="../jspf/footer.jspf" %>
<script src="../js/searchClient.js"></script>

