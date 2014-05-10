<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2/4/14
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ol class="breadcrumb">
    <li><a href="#">Registreer service oproep</a></li>
</ol>
<c:if test="${not empty result}">
    <div class="${resultDiv}">${result}</div>
</c:if>
<form class="form-horizontal" role="form" id="form-register" action="${buttonAction}" method="post">
    <input type="hidden" name="serviceCallId" value="${serviceCallId}">
    <input type="hidden" name="clientId" value="${clientId}">

    <div class="form-group">
        <label for="description" class="col-sm-2 control-label">Uitgebreide omschrijving</label>

        <div class="col-sm-10">
            <textarea class="form-control" name="description" id="description"
                      placeholder="Omschrijving">${description}</textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="shortDescription" class="col-sm-2 control-label">Korte beschrijving</label>

        <div class="col-sm-10">
            <textarea class="form-control" name="shortDescription" id="shortDescription"
                      placeholder="Omschrijving">${shortDescription}</textarea>
        </div>
    </div>

    <div class="form-group">
        <label for="employeeId" class="col-sm-2 control-label">Naam</label>

        <div class="col-sm-10">
            <select class="form-control" id="employeeId" name="employeeId" placeholder="Verantwoordelijke">
                <c:forEach var="singleEmployee" items="${employees}">
                    <option value="${singleEmployee.id}" ${singleEmployee.id == employee.id ? 'selected' : ''}>${singleEmployee.givenName} ${singleEmployee.lastName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-default" value="Registreer"/>
        </div>
    </div>
</form>

<%@ include file="../jspf/footer.jspf" %>

<script src="../js/jquery.validate.min.js"></script>
<script>
    (function ($) {
        $(document).ready(function () {
            $('#form-register').validate({

                rules: {
                    description: {
                        maxlength: 500,
                        required: true
                    },
                    shortDescription: {
                        required: true,
                        maxlength: 100
                    },
                    employeeId: {
                        required: true
                    }
                },
                messages: {
                    description: {
                        required: "Gelieve een beschrijving in te vullen",
                        maxlength: "Gelieve maximaal {0} karakters te gebruiken"
                    },
                    shortDescription: {
                        required: "Gelieve een korte beschrijving in te vullen",
                        maxlength: "Gelieve maximaal {0} karakters te gebruiken"
                    },
                    employeeId: {
                        required: "Gelieve een telefoonnummer in te vullen",

                    }

                },

                //Todo: fix bug (label not removed)
                highlight: function (element) {
                    $(element).closest('.form-group')
                            .removeClass('has-success has-feedback')
                            .addClass('has-error has-feedback');
                },
                success: function (element) {
                    $(element).closest('.form-group')
                            .removeClass('has-error has-feedback')
                            .closest('.form-group').addClass('has-success has-feedback');
                }
            });

        }); // end document.ready
    })(jQuery);
</script>
