<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>
<div id="sc-xml"></div>
<script src="../js/ajaxUtils.js" type="text/javascript"></script>
<body onload="xmlRequest('/getObjects?op=serviceCalls', 'sc-xml', 'serviceCall', 'get');">
<%@ include file="../jspf/footer.jspf" %>



