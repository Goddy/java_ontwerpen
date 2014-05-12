/**
 * Created by u0090265 on 5/5/14.
 */
var general = {};

general.login = (function (dialog, username, password, date, resultDiv) {
    //Really safe p/w checking function for modal
    var cPassword = 'test';
    var cUserName = 'test';
    var dateToday = $.datepicker.formatDate('dd/mm/yy', new Date());
    var selectedDate = date.datepicker().val();

    if (cPassword === password.val() && cUserName === username.val() && dateToday === selectedDate) {
        //close the dialog
        dialog.dialog("close");
    }
    else {
        resultDiv.html('Verkeerd wachtwoord en/of datum');

    }
});

$(document).ready(function () {
    $("#login-dialog").dialog({
        height: 340,
        modal: true,
        open: function (event, ui) {
            $(this).closest('.ui-dialog').find('.ui-dialog-titlebar-close').hide();
        },
        buttons: {
            Login: function () {
                general.login($(this), $('#username'), $('#password'), $('#date'), $('#resultDiv'));
            }
        }
    });

    //Add datepicker to every element with the class datepicker
    $(".datepicker").datepicker({dateFormat: 'dd/mm/yy'});

    //create tabbed menu
    $('#menu').tabs();
});
