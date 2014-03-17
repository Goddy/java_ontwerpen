function submitSearch(address, displayRegion, type ) {
    var name = document.getElementById("name").value;
    var id = document.getElementById("id").value;
    var data = "";

    if (name != "" && id !="") {
        htmlInsert(displayRegion, "Naam en id mogen niet beiden ingevuld zijn");
    }

    else if (name == "" && id =="") {
        htmlInsert(displayRegion, "Geen waarden ingevuld");
    }
    else if (name != "") {
        address += "&search=" +name +"&type=name";
        //jsonTableRequest(address, data, displayRegion, headings, dataFields, type );
        jsonTableRequest(address, data, displayRegion, type, createClientDataTable)
    }
    else {
        if (!isNaN(id)) {
            address +="&search="+id +"&type=id";
            //jsonTableRequest(address, data, displayRegion, headings, dataFields, type );
            jsonTableRequest(address, data, displayRegion, type, createClientDataTable)
        }
        else {
            htmlInsert(displayRegion, "id is geen getal");
        }
    }

}

function createClientDataTable (data, displayRegion) {
    var headings = new Array("Id", "Naam", "Acties");
    var dataFields = new Array("id", "name", "actions");
    var table = "<table class='table'>\n" +
        getTableHeadings(headings) +
        getClientDataTableBody(data, dataFields) +
        "</table>";
    htmlInsert(displayRegion, table);
}

function getClientDataTableBody(rows, fields)
{
    var body = "";
    for(var i=0; i<rows.length; i++) {
        body += "  <tr>";
        var row = rows[i];
        for(var j=0; j<fields.length; j++) {
            var fieldName=fields[j];

            if (fieldName == 'actions') {
                body += '<td>'
                body +='<a href="/registerServiceCall?clientId='+ row['id'] + '" class="glyphicon glyphicon-phone-alt padding3"/>';
                body +='<a href="/clientOverview?id='+ row['id'] + '" class="glyphicon glyphicon-th-list padding3"/></td>';
            }

            else {
                body += "<td>" + row[fieldName] + "</td>";
            }
        }
        body += "</tr>\n";
    }
    return(body);
}

function selectChanged() {
    var myselect = document.getElementById("operationSelect");
    var selectedValue=(myselect.options[myselect.selectedIndex].value);
    if (selectedValue == 1) {
        document.getElementById("searchForm").style.display = 'block';
    }
    else {
        jsonTableRequest('/getObjects?op=allClients', '', 'result', 'get', createClientDataTable);
        document.getElementById("searchForm").style.display = 'none';
    }

}
