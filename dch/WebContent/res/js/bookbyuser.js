
//books推荐
$(document).ready(function(){
	//$("div.hf").click(function(){$('input[name="status"]').val(2);var id = $(this).children('input[name="id"]').val();$('input[name="book_id"]').val(id);});
	$("div.recommend_book").mouseenter(function(){
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
	$("div.recommend_book").mouseleave(function(){
		$('div.showuser').trigger('mouseenter', true);
	});
	$("div.showuser").mouseenter(function(event,was){
		if(was) $(this).css({"display":"none"});
		else $(this).css({"display":"block"});
	});
	$("div.showuser").mouseleave(function(){
		$(this).css({"display":"none"});
	});
	$("div.recommend_book").click(function(){
		var bid = $(this).find('input[name="bid"]').val();
		if(bid!=null&&bid!="")location.href = "OrderBook?bookid="+bid;
	});
	$("div.showuser").click(function(){
		var id = $(this).find('input[name="id"]').val();
		if(id!=null&&id!="")location.href = id;
	});
	
});