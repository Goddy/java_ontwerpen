function submitSearch(address, resultRegion) {
    var loader = $('#loader');
    loader.show();

    var name = document.getElementById("name").value;
    var id = document.getElementById("id").value;

    if (name != "" && id !="") {
        htmlInsert(resultRegion, "Naam en id mogen niet beiden ingevuld zijn");
    }

    else if (name == "" && id =="") {
        htmlInsert(resultRegion, "Geen waarden ingevuld");
    }
    else if (name != "") {
        var transformedAddress = address + "?search=" +name +"&type=name";
        ajaxResult(transformedAddress, resultRegion)
    }
    else {
        if (!isNaN(id)) {
            var transformedAddress = address + "?search="+id +"&type=id";
            ajaxResult(transformedAddress, resultRegion)
        }
        else {
            htmlInsert(resultRegion, "id is geen getal");
        }
    }

    loader.hide();

}
