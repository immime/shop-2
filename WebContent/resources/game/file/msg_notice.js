var TFromMid = '';
var msgArray;
var frommid = '';
var frommname = '';
var addmid = Array();
function closemsg() {
    if ($("#msg_box").css("display") == "block") {
        $("#msg_box").stop().animate({ bottom: "-290px" }, 300);
        setTimeout(function () { $("#msg_box").css("display", "none") }, 300);
        RemoveTaskBox(frommid);
        DeleteByFrommid(frommid);
    }
}
function openmsg() {
    if ($("#msg_box").css("display") == "none") {
        $("#msg_box").css("display", "block");
        $("#msg_box").stop().animate({ bottom: "10px" }, 300);
        if (frommid == '') {
            OpenTask('admin');
            $('#sendmsg').val('');
        }
    }
}
function sendmsg() {
    var sendmsg = getsendmsg();
    if (frommid == '') {
        v5.alert('请选择要对话的会员...', '1', 'true');
    } else if (sendmsg == '') {
        v5.alert('写点东西再发送吧...', '1', 'true');
    } else {
        var ajaxmsg = RunAjaxGetKey('SendMessage', sendmsg);
        if (ajaxmsg == '操作成功') {
            $("#" + frommid + "_msgcontent").val($("#" + frommid + "_msgcontent").val() + "我 [" + GetNowDate() + "]\n ->" + $('#sendmsg').val().Trim() + '\n');
            $('#sendmsg').val('');

            var e = document.getElementById(frommid + "_msgcontent");
            e.scrollTop = e.scrollHeight; //让滚动条自动滚动顶部
        } else {
            v5.alert('发送失败...', '1', 'true');
        }
    }
}
function closenotice() {
    if ($("#notice_box").css("display") == "block") {
        $("#notice_box").stop().animate({ bottom: "-290px" }, 300);
        setTimeout(function () { $("#notice_box").css("display", "none") }, 300);
    }
}
function opennotice() {
    if ($("#notice_box").css("display") == "none") {
        $("#notice_box").css("display", "block");
        $("#notice_box").stop().animate({ bottom: "10px" }, 300);
    }
}
function initmsg_notice() {
    if ($("#uesrmsg").length <= 0) {
        $("body").append("<div id='uesrmsg'><a href='javascript:void(0);' onclick='openmsg()'><em></em><div id='msgtitle'>在线客服</div></a></div>");
    }
    if ($("#msg_box").length <= 0) {
        $("body").append("<div id='msg_box'></div>");
        $("#msg_box").append("<div class='title'><span stly='float:left'>在线客服</span><ul id='now_mem'></ul></div>");
        $("#msg_box").append("<div id='addmem' onclick='selectmid();' title='点我选择会员'>+</div>");
        $("#msg_box").append("<div id='contentBox' style='height: 125px; padding-top: 1px;'><textarea class='msg_info' type='text' id='msgcontent' readonly>暂无您的短消息</textarea></div>");
        $("#msg_box").append("<div><textarea class='msg_input' maxlength='500' id='sendmsg' onfocus=\"if(value=='回复内容'){value=''}\" onblur=\"if (value ==''){value='回复内容'}\" type='text'>回复内容</textarea></div>");
        $("#msg_box").append("<input type='submit' class='msg_sub' onclick='sendmsg()' value='发 送'>");
        $("#msg_box").append("<input type='submit' class='msg_sub' onclick='closemsg()' style='float: left' value='关闭会话'>");
    }
    if ($("#uesrnotice").length <= 0) {
        $("body").append("<div id='uesrnotice'><a href='javascript:void(0);' onclick='opennotice()'>平台公告</a></div>");
    }
    if ($("#notice_box").length <= 0) {
        $("body").append("<div id='notice_box'></div>");
        $("#notice_box").append("<div class='title'>平台公告</div>");
        $("#notice_box").append("<textarea class='msg_info' type='text' id='nccontent' maxID='0' readonly></textarea>");
        $("#notice_box").append("<input type='submit' class='msg_sub' onclick='closenotice()' value='关闭会话' style='float: left'>");
    }
}
//显示对话
function showMsg() {
    if (msgArray && msgArray.length > 0) {
        for (var i = 0; i < msgArray.length; i++) {
            if (i == 0 && frommid == '') {
                frommid = msgArray[i].TFromMID;
            }
            CreateTaskBox(msgArray[i].TFromMID, msgArray[i].TFromMName);
            if (parseInt($("#" + msgArray[i].TFromMID + "").attr('maxID')) < msgArray[i].ID) {
                if (frommid == msgArray[i].TFromMID) {
                    frommname = msgArray[i].TFromMName;
                    $("#" + frommid + "_msgcontent").val($("#" + frommid + "_msgcontent").val() + getmsginfo(msgArray[i]) + '\n');
                    $("#" + frommid + "").attr('maxID', msgArray[i].ID)

                    var e = document.getElementById(frommid + "_msgcontent");
                    e.scrollTop = e.scrollHeight; //让滚动条自动滚动顶部
                }
                if (parseFloat($("#" + msgArray[i].TFromMID + "").attr('maxID')) == parseInt($("#" + msgArray[i].TFromMID + "").attr('maxID'))) {
                    $('embed').remove();
                    $('body').append('<embed src="/SourceFiles/AcmeBlue/sound/sword.mp3" autostart="true" hidden="true" loop="false">');
                    $("#" + msgArray[i].TFromMID + "").attr('maxID', parseInt($("#" + msgArray[i].TFromMID + "").attr('maxID')) + 0.5);
                }
            }
        }
    } else {
        $("#msgcontent").css("display", "block");
    }
    activateBox();
}
//创建对话窗口
function CreateTaskBox(mid, mname) {
    if ($("#" + mid + "").length <= 0) {
        $("#now_mem").append("<li id='" + mid + "' title='" + mid + "' maxID='0'>" +
                "<a href=\"javascript:void(0);\" onclick=\"SearchByFrommid('" + mid + "','" + mname + "');\">" + mname + "</a>" +
                "</li>");
    }
    if ($("#" + mid + "_msgcontent").length <= 0) {
        $("#contentBox").append("<textarea class='msg_info' type='text' id='" + mid + "_msgcontent' readonly>正在与ID：" + mid + "会话中...\n</textarea>");
    }
}
//移除对话窗口
function RemoveTaskBox(mid) {
    if ($("#" + mid + "").length > 0) {
        $("#" + mid).remove();
    }
    if ($("#" + mid + "_msgcontent").length > 0) {
        $("#" + mid + "_msgcontent").remove();
    }
}
//激活对话窗
function activateBox() {
    $("#now_mem li").removeClass("a_on");
    $("#now_mem li").addClass("a_off");
    if (frommid != '') {
        $("#contentBox textarea").css("display", "none");
        $("#" + frommid + "").addClass("a_on");
        $("#" + frommid + "_msgcontent").css("display", "block");
    }
}
//生成对话内容
function getmsginfo(task) {
    return task.TFromMID + " [" + task.TDataStr + "]\n ->" + task.TContent;
}
//查找某个对话
function SearchByFrommid(mid, mname) {
    frommid = mid;
    frommname = mname;
    showMsg();
}
//删除某个对话
function CloseByFrommid(mid) {
    v5.confirm("确定删除与" + mid + "的对话吗", function () { DeleteByFrommid(mid); RemoveTaskBox(mid); }, "true");
}
//删除对话
function DeleteByFrommid(mid) {
    $("#" + mid).remove();
    for (var i = 0; msgArray && i < msgArray.length; i++) {
        if (msgArray[i].TFromMID == mid) {
            msgArray.splice(i, 1);
            i = -1;
        }
    }
    for (var i = 0; i < addmid.length; i++) {
        if (mid == addmid[i]) {
            addmid.splice(i, 1);
            break;
        }
    }
    RunAjaxGetKey('EndTask', mid);
    v5.clearprompt();
    v5.clearshow();
    if ((!msgArray || msgArray.length <= 0) && addmid.length > 0) {
        frommid = addmid[0];
    } else {
        frommid = '';
    }
    showMsg();
}
//获取回复内容
function getsendmsg() {
    if ($('#sendmsg').val().Trim() != '回复内容') {
        return "&TToMID=" + escape(frommid) + "&TToMName=" + escape(frommname) + "&TContent=" + escape($('#sendmsg').val().Trim());
    } else {
        return '';
    }
}
//查找会员
function selectmid() {
    v5.prompt('请输入会员账号',
    function (str) {
        var mname = GetAjaxString('getMName', str).Trim();
        if (mname != "") {
            frommid = str;
            frommname = mname;
            addmid[addmid.length] = frommid;
            CreateTaskBox(frommid, frommname);
            activateBox();
        } else {
            v5.error('不存在该会员', '1', 'true');
        }
    }
    , 'text'
    , 'true');
}

//获取短消息
function AjaxMessage() {
    var ajaxmsg = RunAjaxGetKey('GetMessage', TFromMid);
    if (ajaxmsg != '') {
        ajaxmsg = ajaxmsg.replace(/@/g, '');
        msgArray = eval("(" + ajaxmsg + ")");
        if (msgArray) {
            $('#msgtitle').html("在线客服");
            showMsg();
            openmsg();
        }
    } else {
        $('#msgtitle').html("在线客服");
    }
}

function AjaxNotice() {
    var ajaxnotice = RunAjaxGetKey('GetNotice', '');
    if (ajaxnotice != '') {
        ncArray = eval("(" + ajaxnotice + ")");
        if (parseInt($('#nccontent').attr('maxID')) < ncArray.ID) {
            $('#nccontent').val(ncArray.Content);
            $('#nccontent').attr('maxID', ncArray.ID);
            opennotice();
        }
    }
}

function OpenTask(mid) {
    frommid = mid;
    frommname = GetAjaxString('getMName', mid).Trim();
    addmid[addmid.length] = frommid;
    CreateTaskBox(frommid, frommname);
    activateBox();
    openmsg();
}
function SendTask(str) {
    for (var i = 0; i < cidList.length; i++) {
        OpenTask($("#" + cidList[i] + "_span").text());
        $('#sendmsg').val(str);
    }
}
//setInterval(AjaxMessage, 10000);
//setInterval(AjaxNotice, 60000);
//setTimeout(AjaxMessage, 2000);
//setTimeout(AjaxMessage, 4000);