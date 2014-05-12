/**
 * Created by u0090265 on 5/5/14.
 */
var slider = {};
slider.showValue = function (event, ui) {
    var resultDiv = $(this).nextAll("div.slider-result:first");
    var total = 0;
    $(resultDiv).html(ui.value);
    var elements = $(".slider-result");

    for (var i = 0; i < elements.length; i++) {
        var number = parseInt(elements.eq(i).text());
        if (!isNaN(number))
            total = total + number;
    }
    $("#slider-progress").progressbar("option", "value", total / 3);
};

$(document).ready(function () {
    $(".slider").slider({ min: 0, max: 100, slide: slider.showValue });
    $("#slider-progress").progressbar();

});

