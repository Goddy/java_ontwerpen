<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jspf/header.jspf" %>

<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" onclick="showDialog(13)">
    Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="testModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modal-title"></h4>
            </div>
            <div class="modal-body" id="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" id="modal-btn-close" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" id="modal-btn-save" class="btn btn-primary"></button>
            </div>
        </div>
    </div>
</div>

<script>
function showDeleteDialog(id, type) {
    switch(type)
    {
        case "delete":
            $(".modal-title").text("Delete application " +id) + "?";  // Or use a progress bar...
            $(".modal-body").text("Are you sure you want to delete application " +id) + "?";
            $("#modal-btn-save").click(function(){
                window.location.href = "deleteApplication.html?id=5dfd8c1b-45ab-4bc5-b0bc-36c3f3214e75";
            });
            break;
        default:
            alert("No dialog found");
    }
    $("#modal-btn-save").text('Confirm');
    $("#testModel").modal("show");
}
</script>
<%@ include file="../jspf/footer.jspf" %>
