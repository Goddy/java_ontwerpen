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

function jsonTableRequest(address, data, resultRegion, type, tableFunction)
{
    address += "&format=json";
    ajaxPost(address, data, type, function(request) {
        showJsonTable(request, resultRegion, tableFunction);
    });
}

function showJsonTable(request, resultRegion, tableFunction)
{
    if ((request.readyState == 4) &&
        (request.status == 200)) {
        var rawData = request.responseText;
        var data = eval("(" + rawData + ")");
        //use [ ] in order to be able to provide a dynamic key value
        tableFunction(data, resultRegion);
    }
}

//****************XML functions***************************************************************************************************************
function showXmlTable(request, resultRegion, content)
{
    if ((request.readyState == 4) &&
        (request.status == 200)) {
        var xmlDocument = request.responseXML;
        var headings = getXmlValues(xmlDocument, "heading");
        var rows = getXmlValues2(xmlDocument, content);
        createXmlTable(headings, rows, resultRegion);
    }
}

function xmlRequest(address, resultRegion, content, type)
{
    var data = "";
    ajaxPost(address, data, type, function(request) {
        showXmlTable(request, resultRegion, content);
    });
}

function getBodyContent(element)
{
    element.normalize();
    return(element.firstChild.nodeValue);
}
//Returns a list values found with the provided elementNames
//E.g., for <foo><a>one</a><c>two</c><b>three</b><d>four</d></foo>,
//if the element points at foo,
//getElementValues(element, ["a", "b", "c"]) would return ["one", "three", "two"]
function getElementValues(element, subElementNames)
{
    var values = new Array(subElementNames.length);
    for(var i=0; i<subElementNames.length; i++) {
        var name = subElementNames[i];
        var subElement = element.getElementsByTagName(name)[0];
        values[i] = getBodyContent(subElement);
    }
    return(values);
}
//returns all values of the xmlElementName found in the provided document
//E.g., for <foo><a>one</a><c>two</c><b>three</b><d>four</d><a>five</a></foo>,
//if the element points at foo,
//getElementValues(element, "a") would return ["one", "five"]
function getXmlValues(xmlDocument, xmlElementName)
{
    var elementArray =
        xmlDocument.getElementsByTagName(xmlElementName);
    var valueArray = new Array();
    for(var i=0; i<elementArray.length; i++) {
        valueArray[i] = getBodyContent(elementArray[i]);
    }
    return(valueArray);
}
//returns the values of the childNodes of the xmlElementName
//E.g., for <foo><a>one</a><b>two</b></foo><foo><a>three</a><c>four</c></foo>,
//if the element points at foo,
//getElementValues(element, "foo") would return [["one","two"], ["three", "four"]]
function getXmlValues2(xmlDocument, xmlElementName)
{
    //get all the data nodes
    var datalist = xmlDocument.getElementsByTagName(xmlElementName);
    //loop through all the data nodes
    var rows = new Array(datalist.length);
    for(datanode = 0; datanode < datalist.length; datanode++)
    {
        var row = [];
        for(subnode = 0; subnode < datalist[datanode].childNodes.length ; subnode++){
            //only read element nodes - skip others like empty text nodes
            if(datalist[datanode].childNodes[subnode].nodeType == 1){
                //text of element from text node - first child
                //use push to avoid empty elements in array
                row.push( datalist[datanode].childNodes[subnode].childNodes[0].nodeValue);
            }
        }
        rows[datanode]=row;
    }
    return rows;
}

//****************Table functions***************************************************************************************************************
function getXmlTable(headings, rows)
{
    var table = "<table class='table'>\n" +
        getXmlTableHeadings(headings) +
        getXmlTableBody(rows) +
        "</table>";
    return(table);
}
function getXmlTableHeadings(headings)
{
    var firstRow = "  <tr>";
    for(var i=0; i<headings.length; i++) {
        firstRow += "<th>" + headings[i] + "</th>";
    }
    firstRow += "</tr>\n";
    return(firstRow);
}
function getXmlTableBody(rows)
{
    var body = "";
    for(var i=0; i<rows.length; i++) {
        body += "  <tr>";
        var row = rows[i];
        for(var j=0; j<row.length; j++) {
            body += "<td>" + row[j] + "</td>";
        }
        body += "</tr>\n";
    }
    return(body);
}

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

function createXmlTable(headings, rows, displayRegion)
{
    var table = getXmlTable(headings, rows);
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
