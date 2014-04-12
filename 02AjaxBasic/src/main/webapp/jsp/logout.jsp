<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>
<ol class="breadcrumb">
    <li><a href="#">Uitloggen</a></li>
</ol>
<p>U bent succesvol uitgelogd.</p>

<p>U wordt binnen <span id="spnSeconds">10</span> seconden naar de login pagina gestuurd.</p>
<%@ include file="../jspf/footer.jspf" %>

<script type="text/javascript">
    $(document).ready(function () {
        window.setInterval(function () {
            var iTimeRemaining = $("#spnSeconds").html();
            iTimeRemaining = eval(iTimeRemaining);
            if (iTimeRemaining == 0) {
                window.location.href = "/login.html";
            }
            else {
                $("#spnSeconds").html(iTimeRemaining - 1);
            }
        }, 1000);
    });
</script>
