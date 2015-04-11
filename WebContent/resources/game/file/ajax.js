// Ajax通用请求与返回值方法集 2011-02(zh)
Function.prototype.bind = function (obj) {
    var method = this;
    temp = function () {
        return method.apply(obj, arguments);
    }
    return temp;
}

function Ajax(Method, CallMethod) {
    this.SendData = SendDatas;
    var asynch = false;
    if (CallMethod != null)
        asynch = true;
    function SendDatas(url, data) {
        try {

            this.XMLHttpObject.open(Method, url, asynch);
            if (asynch) {
                this.XMLHttpObject.onreadystatechange = CallMethod.bind(this, 1);
            }

            if (data != null) {
                this.XMLHttpObject.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                this.XMLHttpObject.send(data);
            }
            else
                this.XMLHttpObject.send();

            if (!asynch)
                if (this.XMLHttpObject.readyState == 4 || this.XMLHttpObject.readyState == "complete") {
                	var returnjs = this.XMLHttpObject.responseText;
                    return returnjs;
                }

        }
        catch (e) { }
    }
}

function ReturnXMLHttp()//	返回对象
{

    if (window.XMLHttpRequest) {
        XMLHttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        try {
            XMLHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                XMLHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            catch (e) { }
        }
    }
    return XMLHttp;
}
Ajax.prototype.XMLHttpObject = ReturnXMLHttp();


function GetAjaxString(type, pramname) {
    var link = "/Ajax/ajax.aspx?type=" + type + "&pram=" + pramname ;     //Ajax调用的页面URL
    var ax = new Ajax("Post");                                            //Ajax传参
    return ax.SendData(link);
}
