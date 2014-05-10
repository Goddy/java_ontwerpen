/**
 * Created by u0090265 on 5/6/14.
 */
var panels = {};
panels.styleButtons = function () {
    $("#button-div .style-test").button();
};
$(function ($) {
    $("#accordion-panel").accordion({ animated: "fadeIn" });
    $("#button-styler-button").click(panels.styleButtons);
    $('#switcher').themeswitcher();
})(jQuery);
