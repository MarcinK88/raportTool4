$(document).ready(function() {

    var el = document.getElementById("clearDate");
    var dateToClear = document.getElementById("closeDate");

    el.onchange = function (ev) {
        if(el.checked) {
            dateToClear.disabled = true;
        } else {
            dateToClear.disabled = false;
        }

    }

});

