$(document).ready(function(){
	$("div.one").mouseenter(function(){
		var x=event.clientX?event.clientX:event.x;var y=event.clientY?event.clientY:event.y;
		var nid="FindUser?nid="+$(this).find('input[name="nid"]').val();
		var name=$(this).find('input[name="name"]').val();
		var sex=$(this).find('input[name="sex"]').val();
		var grade=$(this).find('input[name="grade"]').val();
		$(".showuser").empty();
		if(nid!=null&&nid!=""){$(".showuser").append("<input name=\"id\" value=\""+nid+"\" type=\"hidden\" />");}
		if(name!=null&&name!=""){$(".showuser").append("<span>昵称：<a>"+name+"</a></span>");}
		if(sex!=null&&sex!=""){$(".showuser").append("<span>性别：<a>"+sex+"</a></span>");}
		if(grade!=null&&grade!=""){$(".showuser").append("<span>班级：<a>"+grade+"</a></span>");}
		
		$(".showuser").css({"display":"block","top":y,"left":x});
	});
	$("div.one").mouseleave(function(){
		$('div.showuser').trigger('mouseenter', true);
	});
	$("div.showuser").mouseenter(function(event,was){
		if(was) $(this).css({"display":"none"});
		else $(this).css({"display":"block"});
	});
	$("div.showuser").mouseleave(function(){
		$(this).css({"display":"none"});
	});
	//click事件
	$("div.one").click(function(){
		var nid = $(this).find('input[name="nid"]').val();
		if(nid!=null&&nid!="")location.href = "FindUser?nid="+nid;
	});
	$("div.showuser").click(function(){
		var id = $(this).find('input[name="id"]').val();
		if(id!=null&&id!="")location.href = id;
});
});