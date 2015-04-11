$(function(){
	var strtBlocks=$("div.strt-block");
	strtBlocks.each(function(n){
		var childs=$(this).children();
		var w=(childs.last().width() - childs.first().width())/4;
		if(w>0){
			$(this).css("margin-left",w)
		}else{
			$(this).css("padding-right",-w*2);
		}
	});
	
	var strtWrap=$("#strtWrap");
	strtWrap.width(strtWrap.children().width());
	strtWrap.draggable({
		cursor:"move",
		opacity:0.5
	});
});