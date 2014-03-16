<%@tag description="Tag for forms" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="type" required="true" type="java.lang.String"%>
<%@attribute name="label" required="true" type="java.lang.String"%>
<%@attribute name="value" required="true" type="java.lang.String"%>

<div class="form-group">
    <label for="${name}" class="col-sm-2 control-label">${label}</label>
    <div class="col-sm-10">
        <c:choose>
            <c:when test="${type=='label'}">
                <label class="form-control" name="${name}" id="${name}" placeholder="${label}">"${value}"</label>
            </c:when>
            <c:otherwise>
                ${name}
            </c:otherwise>
        </c:choose>
    </div>
</div>