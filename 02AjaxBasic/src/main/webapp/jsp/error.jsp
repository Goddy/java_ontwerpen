<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>
<div id="error">
    <ol class="breadcrumb">
        <li><a href="#">${title}</a></li>
    </ol>
    <h2>${title}</h2>
    ${reason}
</div>
<%@ include file="../jspf/footer.jspf" %>