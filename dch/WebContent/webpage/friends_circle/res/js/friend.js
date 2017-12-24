$(document).ready(function(){
	
	
	$("div.one").mouseenter(function(){
		var x=event.clientX?event.clientX:event.x;var y=event.clientY?event.clientY:event.y;
		var nid=$(this).find('input[name="nid"]').val();
		var headpng=$(this).find('input[name="headpng"]').val();
		var name=$(this).find('input[name="name"]').val();
		var sex=$(this).find('input[name="sex"]').val();
		var grade=$(this).find('input[name="grade"]').val();
		$(".showuser").empty();
		if(nid!=null&&nid!=""){$(".showuser").append("<input name=\"nid\" value=\""+nid+"\" type=\"hidden\" /><input name=\"headpng\" value=\""+headpng+"\" type=\"hidden\" /><input name=\"name\" value=\""+name+"\" type=\"hidden\" /><input name=\"sex\" value=\""+sex+"\" type=\"hidden\" /><input name=\"grade\" value=\""+grade+"\" type=\"hidden\" />");}
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
	
	
	
	$("div.one").click(function(){
		var nid = $(this).find('input[name="nid"]').val();
		var headpng = $(this).find('input[name="headpng"]').val();
		var name = $(this).find('input[name="name"]').val();
		var sex = $(this).find('input[name="sex"]').val();
		var grade = $(this).find('input[name="grade"]').val();
		var nnid = $(this).find('input[name="nid"]').val();
		$(".right").children("div.top").find('div[class="img"]').css("background-image","url(\"headpng/"+headpng+"\")")
		$(".right").children("div.top").find('a[class="focusnickname"]').html(name);
		$(".right").children("div.top").find('a[class="focustruename"]').html(name);
		$(".right").children("div.top").find('a[class="focussex"]').html(sex);
		$(".right").children("div.top").find('a[class="focusgrade"]').html(grade);
		//alert("ff");
		$.ajax({
			type:"POST",url:"getBookByUser",data:{ "nnid": nnid },
			success:function(data){
				$(".fen-book").empty();
				$(".fen-book").html(data);
			},
			error:function(){}
		});
		//if(nid!=null&&nid!="")location.href = "FindUser?nid="+nid;
	});
	$("div.showuser").click(function(){
		var nid = $(this).find('input[name="nid"]').val();
		var headpng = $(this).find('input[name="headpng"]').val();
		var name = $(this).find('input[name="name"]').val();
		var sex = $(this).find('input[name="sex"]').val();
		var grade = $(this).find('input[name="grade"]').val();
		var nnid = $(this).find('input[name="nid"]').val();
		$(".right").children("div.top").find('div[class="img"]').css("background-image","url(\"headpng/"+headpng+"\")")
		$(".right").children("div.top").find('a[class="focusnickname"]').html(name);
		$(".right").children("div.top").find('a[class="focustruename"]').html(name);
		$(".right").children("div.top").find('a[class="focussex"]').html(sex);
		$(".right").children("div.top").find('a[class="focusgrade"]').html(grade);
		$.ajax({
			type:"POST",url:"getBookByUser",data:{ "nnid": nnid },
			success:function(data){
				$(".fen-book").empty();
				$(".fen-book").html(data);
			},
			error:function(){}
		});
	});
	$(".left").children(".leftlist:first").children(".one:first").click();
});