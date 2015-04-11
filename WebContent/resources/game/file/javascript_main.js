/*开始2013/1/30日TNS_Pop添加及修改开始*/
var loadPanelWest = function () {
    $.ajax
    ({
        type: 'post',
        url: 'json/TreeJson.aspx?Param=0',
        dataType: 'Json',
        success: function (data) {
            try {
                var panWestMenu = $("#sider").find('ul');
                var menusArray = data;
                for (var j = 0; j < menusArray.length; j++) {
                    var mp = CreateMenuPanel(menusArray[j].CID, menusArray[j].CTitle, menusArray[j].CImage, j);
                    panWestMenu.append(mp);
                    menuGetLeft(menusArray[j].CID, j, menusArray.length - 1);
                }
            }
            catch (e) {
                alert(e.Message);
            }
        }
    });
};

var menuGetLeft = function (cid, index, maxindex) {
    $.ajax
    ({
        type: 'post',
        url: 'json/TreeJson.aspx?Param=1',
        dataType: 'Json',
        success: function (data) {
            try {
                var panWestMenu = $("#menu_m" + index);
                var menusArray = data;
                for (var j = 0; j < menusArray.length; j++) {
                    var mp = CreateMenu(menusArray[j].CAddress, menusArray[j].CTitle, menusArray[j].IFVerify);
                    panWestMenu.append(mp);
                }
                if (index == maxindex) {
                    bindClick();
                    v5.clearshade();
                }
            }
            catch (e) {
                alert(e.Message);
            }
        },
        data: { node: cid }
    });
}
function CreateMenuPanel(fcid, title, image, index) {
    var retstr = "<li><div class='title'><span></span><a href='javascript:void(0);' id='m" + index + "' >" + title + "</a></div><p id='menu_m" + index + "'></p></li>";
    return retstr;
}

/*创建次导航区*/
function CreateMenu(url, title) {
    var retstr = "<a href='javascript:void(0)' onclick=\"callhtml('" + url + "')\" class='sider_off' >" + title + "</a>";
    if (url == "Member/View.aspx") {
        $('#memberCenter').html(retstr);
        $('#memberCenter a').html("个人中心");
    }
    return retstr;
}
var bindClick = function () {
    $("#sider .title a").click(function () {
        var id = $(this).attr("id");
        var disid = "#menu_" + id;
        $("#sider li p").stop().hide(300);
        $(disid).stop().show(300);
    })
    $("#sider li p a").click(function () {
        $("#sider li p a").removeClass("sider_on");
        $("#sider li p a").addClass("sider_off");
        $(this).removeClass("sider_off");
        $(this).addClass("sider_on");
    })
}

/*结束2013/1/30日TNS_Pop添加及修改结束*/


function changetabcolor() {
    return;
    var trnum = $(".tabcolor tr").length;
    if (trnum > 0) {
        for (i = 0; i < trnum; i++) {
            if (i % 2 == 0) {
                $(".tabcolor tr").eq(i).css("background", "#f9f9f9");
            }
        }
    }
}
function changecor() {
    return;
    $(".tabcolor tr").mouseover(function () {
        $(this).css("background", "#e7eff6");
        $(this).css("color", "#191919");
    })
    $(".tabcolor tr").mouseout(function () {
        $(this).css("background", "");
        $(this).css("color", "#686868");
        changetabcolor();
    })
}
$(document).ready(function () {
    //    loadPanelWest();
    //    changetabcolor();
    //    changecor();
})

function callhtml(url) {
    if (url.indexOf("?") > -1)
        url += "&r=" + Math.random();
    else
        url += "?r=" + Math.random();
    if (RunAjaxGetKey('VerifyUrl', url) == 'TRUE') {
        verifypsd(function () {
            if ($("#loading").length <= 0) {
                $("#container").append("<div id='loading'></div>");
            }
            setTimeout(function () { $("#container").load(url, function () { changetabcolor(); changecor(); }); }, 10);
        });
    }
    else {
        if ($("#loading").length <= 0) {
            $("#container").append("<div id='loading'></div>");
        }
        setTimeout(function () { $("#container").load(url, function () { changetabcolor(); changecor(); }); }, 10);
    }
}

function Pay(parm) {
    setTimeout(function () { $("#container").load("/Payment/Ecpss/Payment.aspx?" + parm, function () { changetabcolor(); changecor(); }); }, 10);
}

function callDefault() {
    v5.shadeshow("正在努力为您加载");
    setTimeout(function () { $("#container").load('Container.aspx', function () { changetabcolor(); changecor(); }); }, 10);
}

function outSys() {
    v5.confirm('您确定要退出系統吗？',
    function () {
        setTimeout(function () { $("#container").load('/SysManage/Out.aspx', function () { changetabcolor(); changecor(); }); }, 700)
    }
    , 'true')
}

function fullscreen() {
    if ($("#fulls").length <= 0) {
        var html = $("#container").html();
        $("#container").remove();
        $("body").css("overflow", "auto");
        $("body").append("<div id='fulls'>" + html + "</div>");
    }
    else {
        var html = $("#fulls").html();
        $("#fulls").remove();
        $("body").css("overflow", "hidden");
        $("body").append("<div id='container'>" + html + "</div>")
    }
}
