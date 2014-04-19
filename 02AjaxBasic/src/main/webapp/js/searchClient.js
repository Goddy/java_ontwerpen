var search = window.search || {};

search.searchClient = (function ($) {
    function createClientDataTable(data, displayRegion) {
        var headings = ["Id", "Naam", "Acties"];
        var dataFields = ["id", "name", "actions"];
        var table = "<table class='table'>\n" +
            getTableHeadings(headings) +
            getClientDataTableBody(data, dataFields) +
            "</table>";
        htmlInsert(displayRegion, table);
    }

    function getClientDataTableBody(rows, fields) {
        var body = "";
        for (var i = 0; i < rows.length; i++) {
            body += "  <tr>";
            var row = rows[i];
            for (var j = 0; j < fields.length; j++) {
                var fieldName = fields[j];

                if (fieldName == 'actions') {
                    body += '<td>'
                    body += '<a href="/registerServiceCall.html?clientId=' + row['id'] + '" class="glyphicon glyphicon-phone-alt padding3"/>';
                    body += '<a href="/clientOverview.html?id=' + row['id'] + '" class="glyphicon glyphicon-th-list padding3"/></td>';
                }

                else {
                    body += "<td>" + row[fieldName] + "</td>";
                }
            }
            body += "</tr>\n";
        }
        return(body);
    }

    return {
        selectChanged: function () {
            var mySelect = $("#operationSelect");
            var selectedValue = mySelect.val();
            $('#result').empty();
            if (selectedValue == 1) {
                $("#searchForm").css("display", 'block');
            }
            else {
                getTableJquery('/getObjects.html?op=allClients', createClientDataTable, 'result');
                $("#searchForm").css("display", 'none');
            }

        },

        submitSearch: function (address, displayRegion, type) {
            var name = $("#name").val();
            var id = $("#id").val();
            var data = "";

            if (!name && !id) {
                htmlInsert(displayRegion, "Naam en id mogen niet beiden ingevuld zijn");
            }

            else if (name == "" && id == "") {
                htmlInsert(displayRegion, "Geen waarden ingevuld");
            }
            else if (name != "") {
                address += "&search=" + name + "&type=name";
                getTableJquery(address, createClientDataTable, displayRegion);
            }
            else {
                if (!isNaN(id)) {
                    address += "&search=" + id + "&type=id";
                    getTableJquery(address, createClientDataTable, displayRegion);
                }
                else {
                    htmlInsert(displayRegion, "id is geen getal");
                }
            }

        }
    }

})(jQuery);
