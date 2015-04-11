// JavaScript Document
$(document).ready(function(){
	var url = location.href;
	var arr = new Array();
	var nav = new Array();
	$("div .content_r_list ul li a").each(function(i,u){
		arr[i] = u;
		if(arr[i] == url)
		{
			$(this).css({"color":"#09F"});
		}
	});
});