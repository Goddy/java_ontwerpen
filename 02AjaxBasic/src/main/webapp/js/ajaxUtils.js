// Get the browser-specific request object, either for
// Firefox, Safari, Opera, Mozilla, Netscape, IE 8, or IE 7 (top entry);
// or for Internet Explorer 5 and 6 (bottom entry).

//****************Request functions**************************************************************************************************************
function getRequestObject() {
    if (window.XMLHttpRequest) {
        return(new XMLHttpRequest());
    } else if (window.ActiveXObject) {
        return(new ActiveXObject("Microsoft.XMLHTTP"));
    } else {
        // Don't throw Error: this part is for very old browsers,
        // and Error was implemented starting in JavaScript 1.5.
        return(null);
    }
}

function ajaxPost(address, data, type, responseHandler)
{
    var request = getRequestObject();
    request.onreadystatechange = function() { responseHandler(request); };
    request.open(type, address, true);
    request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    request.send(data);
}

// Make an HTTP request to the given address.
// Display result in the HTML element that has given ID.

function ajaxResult(address, resultRegion) {
    var request = getRequestObject();
    request.onreadystatechange =
        function() { showResponseText(request,
            resultRegion); };
    request.open("GET", address, true);
    request.send(null);
}
//****************HTML functions**************************************************************************************************************
// Put response text in the HTML element that has given ID.

function showResponseText(request, resultRegion) {
    if ((request.readyState == 4) &&
        (request.status == 200)) {
        htmlInsert(resultRegion, request.responseText);
    }
}

//Insert the html data into the element that has the specified id.

function htmlInsert(id, htmlData) {
    document.getElementById(id).innerHTML = htmlData;
}

//****************JSON functions**************************************************************************************************************
function jsonTableRequest(address, data, resultRegion, headings, fields, type)
{
    address += "&format=json";
    ajaxPost(address, data, type, function(request) {
        showJsonTable(request, resultRegion, headings, fields);
    });
}

function jsonTableRequest_test(address, data, resultRegion, type, tableFunction)
{
    address += "&format=json";
    ajaxPost(address, data, type, function(request) {
        showJsonTable_test(request, resultRegion, tableFunction);
    });
}

function showJsonTable_test(request, resultRegion, tableFunction)
{
    if ((request.readyState == 4) &&
        (request.status == 200)) {
        var rawData = request.responseText;
        var data = eval("(" + rawData + ")");
        //use [ ] in order to be able to provide a dynamic key value
        tableFunction(data, resultRegion);
    }
}

function showJsonTable(request, resultRegion, headings, fields)
{
    if ((request.readyState == 4) &&
        (request.status == 200)) {
        var rawData = request.responseText;
        var data = eval("(" + rawData + ")");
        //use [ ] in order to be able to provide a dynamic key value
        createTable(headings, fields, data, resultRegion);
    }
}

//****************Table functions***************************************************************************************************************

function getTable(headings, fields, rows)
{
    var table = "<table class='table'>\n" +
        getTableHeadings(headings) +
        getTableBody(rows, fields) +
        "</table>";
    return(table);
}
function getTableHeadings(headings)
{
    var firstRow = "  <tr>";
    for(var i=0; i<headings.length; i++) {
        firstRow += "<th>" + headings[i] + "</th>";
    }
    firstRow += "</tr>\n";
    return(firstRow);
}
function getTableBody(rows, fields)
{
    var body = "";
    for(var i=0; i<rows.length; i++) {
        body += "  <tr>";
        var row = rows[i];
        for(var j=0; j<fields.length; j++) {
            var fieldName=fields[j];
            body += "<td>" + row[fieldName] + "</td>";
        }
        body += "</tr>\n";
    }
    return(body);
}
function createTable(headings, fields, rows, displayRegion)
{
    var table = getTable(headings, fields, rows);
    htmlInsert(displayRegion, table);
}

//****************Parsing functions**************************************************************************************************************
// Read form parameters and prepare for submit to server
function parseInput(form)
{
    var parameters = "";
    for(var i=0; i<form.elements.length; i++){
        if(form.elements[i].type == "button")
            continue;
        if(i > 0)
            parameters += "&";
        parameters += form.elements[i].name + "=";
        switch (form.elements[i].type){
            case "text":
                parameters += encodeURIComponent(form.elements[i].value);
                break;
            case "select-one":
                parameters += form.elements[i].options[form.elements[i].selectedIndex].value;
                break;
            case "radio":
                //radio buttons are grouped with 1 name where the user should select one value only
                var radioel = form.elements[form.elements[i].name];
                for(var j=0; j<radioel.length; j++){
                    i+=j;
                    if(radioel[j].checked)
                        parameters += radioel[j].value;
                }
                break;
            case "checkbox":
                parameters += encodeURIComponent(form.elements[i].checked);
                break;
        }
    }
    return parameters;
}

try { console.log("Loading script");
} catch(e) { console = { log: function() {} }; }
