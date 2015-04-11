var v5 = {};
var callbackFun;
var maskCount = 0;
v5.show = function (content, htmltitle, type, sw, sh) {
    maskCount++;
    if ($("#v5_show").length <= 0 && type == "id") {
        var width = $("#" + content + "").width();
        var height = $("#" + content + "").height();
        var htmlcontent = $("#" + content + "").html();
        $("body").append("<div id='v5_show'><div class='title'>" + htmltitle + "</div><div class='close' onclick='v5.clearshow();'></div>" + htmlcontent + "</div>");
        $("body").append("<div id='shade'></div>");
        $("#v5_show").css("width", (width + 20) + "px");
        $("#v5_show").css("height", (height + 40) + "px");
        $("#v5_show").css("marginLeft", -(width + 20) / 2 + "px");
        $("#v5_show").css("marginTop", -(height + 40) / 2 + "px");
        $("#v5_show").stop().fadeIn(300);
        $("#shade").stop().fadeIn(300);
    }
    else if ($("#v5_show").length <= 0 && type == "url") {
        $("body").append("<div id='shade'></div>");
        $.get(content, function (data) {
            $("body").append("<div id='v5_show'><div class='title'>" + htmltitle + "</div><div class='close' onclick='v5.clearshow();'></div>" + data + "</div>");
            $("#v5_show").css("width", (sw + 20) + "px");
            $("#v5_show").css("height", (sh + 40) + "px");
            $("#v5_show").css("marginLeft", -(sw + 20) / 2 + "px");
            $("#v5_show").css("marginTop", -(sh + 40) / 2 + "px");
            $("#v5_show").stop().fadeIn(300);
            $("#shade").stop().fadeIn(300);
        }
		);
    }
}
v5.alert = function (content, time, mask) {
    if (mask == "true") {
        $("body").append("<div id='shade'></div>");
        maskCount++;
    }
    $("body").append("<div id='v5_prompt'><div class='alert_ico'></div><div class='content'>" + content + "</div></div>");
    $("#v5_prompt").css("color", "#b06500")
    $("#v5_prompt").css("marginLeft", -($("#v5_prompt").width() + 20) / 2 + "px");
    $("#v5_prompt").css("marginTop", -($("#v5_prompt").height() + 20) / 2 + "px");
    $("#v5_prompt").stop().fadeIn(300);
    $("#shade").stop().fadeIn(300);
    setTimeout(function () { v5.clearprompt(); }, time * 1000);
}
v5.error = function (content, time, mask) {
    if (mask == "true") {
        $("body").append("<div id='shade'></div>");
        maskCount++;
    }
    $("body").append("<div id='v5_prompt'><div class='error_ico'></div><div class='content'>" + content + "</div></div>");
    $("#v5_prompt").css("color", "#e20000")
    $("#v5_prompt").css("marginLeft", -($("#v5_prompt").width() + 20) / 2 + "px");
    $("#v5_prompt").css("marginTop", -($("#v5_prompt").height() + 20) / 2 + "px");
    $("#v5_prompt").stop().fadeIn(300);
    $("#shade").stop().fadeIn(300);
    setTimeout(function () { v5.clearprompt(); }, time * 1000)
}
v5.shadeshow = function (content) {
    $("body").append("<div id='shade'></div>");
    $("body").append("<div id='v5_prompt'><div></div><div class='content'>" + content + "</div></div>");
    $("#v5_prompt").css("color", "#b06500")
    $("#v5_prompt").css("marginLeft", -($("#v5_prompt").width() + 20) / 2 + "px");
    $("#v5_prompt").css("marginTop", -($("#v5_prompt").height() + 20) / 2 + "px");
    $("#v5_prompt").stop().fadeIn(300);
    $("#shade").stop().fadeIn(300);
    maskCount++;
}
v5.clearshade = function () {
    v5.clearprompt();
}
v5.success = function (content, time, mask) {
    if (mask == "true") {
        $("body").append("<div id='shade'></div>");
        maskCount++;
    }
    $("body").append("<div id='v5_prompt'><div class='success_ico'></div><div class='content'>" + content + "</div></div>");
    $("#v5_prompt").css("color", "#2b8c00")
    $("#v5_prompt").css("marginLeft", -($("#v5_prompt").width() + 20) / 2 + "px");
    $("#v5_prompt").css("marginTop", -($("#v5_prompt").height() + 20) / 2 + "px");
    $("#v5_prompt").stop().fadeIn(300);
    $("#shade").stop().fadeIn(300);
    setTimeout(function () { v5.clearprompt(); }, time * 1000)
}
v5.confirm = function (content, callfuc, mask) {
    callbackFun = callfuc;
    if (mask == "true") {
        $("body").append("<div id='shade'></div>");
        maskCount++;
    }
    $("body").append("<div id='v5_prompt' style='width:220px'><div><div class='confirm_ico'></div><div class='content'>" + content + "</div></div><div class='yesno_btn'><input type='submit' class='btnok' onclick=\"confirmcall();v5.clearprompt();\" value='确定' style='float:left'><input type='submit'class='btn' onclick='v5.clearprompt()' value='取消'></div></div>");
    $("#v5_prompt").css("color", "#b06500")
    $("#v5_prompt").css("marginLeft", -($("#v5_prompt").width() + 20) / 2 + "px");
    $("#v5_prompt").css("marginTop", -($("#v5_prompt").height() + 20) / 2 + "px");
    $("#v5_prompt").stop().fadeIn(300);
    $("#shade").stop().fadeIn(300);
}
function confirmcall() {
    callbackFun();
}

v5.prompt = function (content, callfuc, inputtype, mask) {
    callbackFun = callfuc;
    if (mask == "true") {
        $("body").append("<div id='shade'></div>");
        maskCount++;
    }
    $("body").append("<div id='v5_prompt' style='width:220px'><div class='cleardiv'><div class='prompt_ico'></div><div class='content'>" + content + "</div></div><input type='" + inputtype + "' id='inputid' class='normal_input callinput'><div class='prompt_btn'><input  type='submit' class='btnok' onclick=\"promptcall();\" value='确定' style='float:left'><input type='submit'class='btn' onclick='v5.clearprompt()' value='取消'></div></div>");
    $("#v5_prompt").css("color", "#135aa4")
    $("#v5_prompt").css("marginLeft", -($("#v5_prompt").width() + 20) / 2 + "px");
    $("#v5_prompt").css("marginTop", -($("#v5_prompt").height() + 20) / 2 + "px");
    $("#v5_prompt").stop().fadeIn(300);
    $("#shade").stop().fadeIn(300);
    $("#inputid").focus();
}
function promptcall() {
    var str = $("#inputid").val();
    v5.clearprompt();
    callbackFun(str);
}

v5.clearshow = function () {
    maskCount--;
    $("#v5_show").remove();
    if (maskCount <= 0) {
        $("#shade").remove();
        maskCount = 0;
    }
}
v5.clearprompt = function () {
    maskCount--;
    $("#v5_prompt").remove();
    if (maskCount <= 0) {
        $("#shade").remove();
        maskCount = 0;
    }
}
v5.clearall = function () {
    maskCount = 1;
    v5.clearshow();
    maskCount = 1;
    v5.clearprompt();
    if (tUrl != '') {
        PageLoad();
    }
}