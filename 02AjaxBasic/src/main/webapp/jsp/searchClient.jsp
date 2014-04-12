<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>
<ol class="breadcrumb">
    <li><a href="#">Zoek klant</a></li>
</ol>
<select class="form-control" id="operationSelect" onChange="selectChanged()">
    <option value="1">Zoek klant</option>
    <option value="2">Alle klanten</option>
</select><br>
<form role="form" id="searchForm" style="display:none;">
    <div class="form-group">
        <label for="id">Zoek op id</label>
        <input class="form-control" id="id" name="id" placeholder="id">
    </div>
    <div class="form-group">
        <label for="name">Zoek op naam</label>
        <input class="form-control" id="name" name="name" placeholder="naam">
    </div>
    <button id="submit" type="button" class="btn btn-default">Zoeken</button>
    <img id="loader" src="../images/loading.gif" height="20" width="20" style="display: none;">
</form>
<div id="result">
<%@ include file="../jspf/footer.jspf" %>
<script src="../js/searchClient.js"></script>
<script src="../js/ajaxUtils.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            selectChanged();

            $('#submit').click(function () {
                submitSearch("/getObjects.html?op=searchClients", "result");
            })
        });
    </script>
