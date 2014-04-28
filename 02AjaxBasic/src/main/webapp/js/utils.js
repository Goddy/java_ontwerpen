// Get the browser-specific request object, either for
// Firefox, Safari, Opera, Mozilla, Netscape, IE 8, or IE 7 (top entry);
// or for Internet Explorer 5 and 6 (bottom entry).
function getTableJquery(url, tablefunction, resultRegion) {
    $.ajax({
        url: url,
        dataType: 'json',
        cache: false,
        success: function (json) {
            tablefunction(json, resultRegion);
        }
    });
}

//****************HTML functions**************************************************************************************************************
//Insert the html data into the element that has the specified id.

function htmlInsert(id, htmlData) {
    $('#' + id).html(htmlData);
}

//****************XML functions***************************************************************************************************************
function showXmlTableJquery(url, resultRegion, content) {
    $.ajax({
        url: url,
        dataType: 'xml',
        cache: false,
        success: function (xml) {
            var xmlDocument = xml;
            var headings = getXmlValues(xmlDocument, "heading");
            var rows = getXmlValues2(xmlDocument, content);
            createXmlTable(headings, rows, resultRegion);
        }
    });
}

function getBodyContent(element) {
    element.normalize();
    return(element.firstChild.nodeValue);
}

//returns all values of the xmlElementName found in the provided document
//E.g., for <foo><a>one</a><c>two</c><b>three</b><d>four</d><a>five</a></foo>,
//if the element points at foo,
//getElementValues(element, "a") would return ["one", "five"]
function getXmlValues(xmlDocument, xmlElementName) {
    var elementArray =
        xmlDocument.getElementsByTagName(xmlElementName);
    var valueArray = new Array();
    for (var i = 0; i < elementArray.length; i++) {
        valueArray[i] = getBodyContent(elementArray[i]);
    }
    return(valueArray);
}
//returns the values of the childNodes of the xmlElementName
//E.g., for <foo><a>one</a><b>two</b></foo><foo><a>three</a><c>four</c></foo>,
//if the element points at foo,
//getElementValues(element, "foo") would return [["one","two"], ["three", "four"]]
function getXmlValues2(xmlDocument, xmlElementName) {
    //get all the data nodes
    var datalist = xmlDocument.getElementsByTagName(xmlElementName);
    //loop through all the data nodes
    var rows = new Array(datalist.length);
    for (datanode = 0; datanode < datalist.length; datanode++) {
        var row = [];
        for (subnode = 0; subnode < datalist[datanode].childNodes.length; subnode++) {
            //only read element nodes - skip others like empty text nodes
            if (datalist[datanode].childNodes[subnode].nodeType == 1) {
                //text of element from text node - first child
                //use push to avoid empty elements in array
                row.push(datalist[datanode].childNodes[subnode].childNodes[0].nodeValue);
            }
        }
        rows[datanode] = row;
    }
    return rows;
}

//****************Table functions***************************************************************************************************************
function getXmlTable(headings, rows) {
    var table = "<table class='table'>\n" +
        getXmlTableHeadings(headings) +
        getXmlTableBody(rows) +
        "</table>";
    return(table);
}
function getXmlTableHeadings(headings) {
    var firstRow = "  <tr>";
    for (var i = 0; i < headings.length; i++) {
        firstRow += "<th>" + headings[i] + "</th>";
    }
    firstRow += "</tr>\n";
    return(firstRow);
}
function getXmlTableBody(rows) {
    var body = "";
    for (var i = 0; i < rows.length; i++) {
        body += "  <tr>";
        var row = rows[i];
        for (var j = 0; j < row.length; j++) {
            body += "<td>" + row[j] + "</td>";
        }
        body += "</tr>\n";
    }
    return(body);
}

function getTableHeadings(headings) {
    var firstRow = "  <tr>";
    for (var i = 0; i < headings.length; i++) {
        firstRow += "<th>" + headings[i] + "</th>";
    }
    firstRow += "</tr>\n";
    return(firstRow);
}

function createXmlTable(headings, rows, displayRegion) {
    var table = getXmlTable(headings, rows);
    htmlInsert(displayRegion, table);
}

try {
    console.log("Loading script");
} catch (e) {
    console = { log: function () {
    } };
}
