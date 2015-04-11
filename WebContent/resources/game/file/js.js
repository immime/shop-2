function tab() {
    var oDiv = $("#tab").find("div");
    var oLi = $(oDiv[0]).find("ul>li");
    var aCon = $(oDiv[1]).children("div .cur");
    var timer = null;
    for (var i = 0; i < oLi.length; i++) {
        oLi[i].index = i;
        oLi[i].onclick = function () {
            show(this.index);
        }
    }
    function show(a) {
        for (var j = 0; j < aCon.length; j++) {
            aCon[j].style.display = "none";
        }
        aCon[a].style.display = "block";
        for (var k = 0; k < oLi.length; k++) {
            $(oLi[k]).css("color", "");
        }
        $(oLi[a]).css("color", "#3352CC");
    }
}