function submitSearch(address, form, resultRegion, type ) {
    var name = document.getElementById("name").value;
    var id = document.getElementById("id").value;
    var headings = new Array("Id", "Naam");
    var dataFields = new Array("id", "name");
    var data = "";

    if (name != "" && id !="") {
        htmlInsert(resultRegion, "Naam en id mogen niet beiden ingevuld zijn");
    }

    else if (name == "" && id =="") {
        htmlInsert(resultRegion, "Geen waarden ingevuld");
    }
    else if (name != "") {
        address += "?search=" +name +"&type=name";
        jsonTableRequest(address, data, resultRegion, headings, dataFields, type );
    }
    else {
        if (!isNaN(id)) {
            address +="?search="+id +"&type=id";
            jsonTableRequest(address, data, resultRegion, headings, dataFields, type );
        }
        else {
            htmlInsert(resultRegion, "id is geen getal");
        }
    }

}
