function onclick(object){
	//alert(object);
	$(".mymessage").css("display","none");
	$(".myshare").css("display","none");
	$(".myborrow").css("display","none");
	$(".mydynamic").css("display","none");
	$("."+object).css("display","block");
	$(".dytitle span a").css("background-color","#ddd");
	$("#"+object).css({"background-color":"#fff","":""});
}
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
	
	
	
	
	
	$("div.bookdemo").mouseenter(function(){
		var x=event.clientX?event.clientX:event.x;var y=event.clientY?event.clientY:event.y;
		var bid="OrderBook?bookid="+$(this).find('input[name="bid"]').val();
		var bookname=$(this).find('input[name="bookname"]').val();
		var author=$(this).find('input[name="author"]').val();
		var desc=$(this).find('input[name="desc"]').val();
		var praise=$(this).find('input[name="praise"]').val();
		$(".showuser").empty();
		if(bid!=null&&bid!=""){$(".showuser").append("<input name=\"id\" value=\""+bid+"\" type=\"hidden\" />");}
		if(bookname!=null&&bookname!=""){$(".showuser").append("<span>书名：<a>"+bookname+"</a></span>");}
		if(author!=null&&author!=""){$(".showuser").append("<span>作者：<a>"+author+"</a></span>");}
		if(praise!=null&&praise!=""){$(".showuser").append("<span>赞：<a>"+praise+"</a></span>");}
		if(desc!=null&&desc!=""){$(".showuser").append("<span>简介：<a>"+desc+"</a></span>");}
		$(".showuser").css({"display":"block","top":y,"left":x});
		//alert("x"+event.x+"-"+"y"+event.y+"-"+"clientx"+event.clientX+"-"+"clienty"+event.clientY+"-");
	});
	$("div.bookdemo").mouseleave(function(){
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
	$("div.bookdemo").click(function(){
				var bid = $(this).find('input[name="bid"]').val();
				if(bid!=null&&bid!="")location.href = "OrderBook?bookid="+bid;
	});
	$("div.showuser").click(function(){
		var id = $(this).find('input[name="id"]').val();
		if(id!=null&&id!="")location.href = id;
});
});