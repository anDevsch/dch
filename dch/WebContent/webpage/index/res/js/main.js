function recommend()
{
	;(function ($) {
			$(document).ready(function(){
			
			$("#list li:first").children(".bookpngshow").css("display","inline-block");
			$("#list li:first").css("height","110px");
			$("#list li:first").children("span").children("a").css({"display":"block","margin":"0px 0px 25px 0px","max-width":"150px"});
			$("#list li:first").children("span").children("a.view").css({"display":"none"});
			$("#list li:first").children("span").css({"width":"auto"});



			$("#list li").mouseover(function(){
				$("#list li").children(".bookpngshow").css("display","none");
				$("#list li").css("height","35px");
				$("#list li").children("span").children("a").css({"display":"inline-block","margin":"0px","max-width":"200px"});
				$("#list li").children("span").children("a.bookauthor").css({"display":"none"});
				$("#list li").children("span").css({"width":"255px"});

				$(this).children(".bookpngshow").css("display","inline-block");
				$(this).css("height","110px");
				$(this).children("span").children("a").css({"display":"block","margin":"0px 0px 25px 0px","max-width":"150px"});
				$(this).children("span").children("a.view").css({"display":"none"});
				$(this).children("span").css({"width":"auto"});
		  });
		  //$("p").mouseout(function(){
		   // $("p").css("background-color","#E9E9E4");
		  //});
		});
	})(jQuery);
}
function hsubmit() {
	$("#sub").ajaxSubmit({  
        type: "POST",//提交类型  
        url: "Login",//请求地址
        timeout: 3000,
        data: { "action": "TemporaryImage" },//请求数据  
        success: function (data) {if(data=="true")window.location.href="Index";else {$("#text").html(data);$(".alert").css("display","block");fade(0);}},  
        error: function (data) { $("#text").html("系统无响应，请稍后再试");$(".alert").css("display","block");fade(0);  },//请求失败的函数  
        async: true  
	}); 
	return false;
}

function fade(i){
	if(i<5){
		change(i);
		setTimeout(function(){fade(++i);},100);
	}
	else if(i==5){setTimeout(function(){fade(++i);},1500);}
	else if(i>5&&i<=10){
		change(10-i);
		setTimeout(function(){fade(++i);},100);
	}
	else {$(".alert").css("-webkit-filter","opacity(0)");$(".alert").css("display","none");}
}
function change(i){
	switch(i)
	{
	case 0:
		$(".alert").css("-webkit-filter","opacity(0.2)");break;
	case 1:
		$(".alert").css("-webkit-filter","opacity(0.4)");break;
	case 2:
		$(".alert").css("-webkit-filter","opacity(0.6)");break;
	case 3:
		$(".alert").css("-webkit-filter","opacity(0.8)");break;
	case 4:
		$(".alert").css("-webkit-filter","opacity(0.9)");break;
	}
}
/*suser*/
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
/*books推荐*/
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