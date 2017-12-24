function remark(){
	$("#remark").css({"display":"block"});
	
}
function retremark(){
	$("#remark").css({"display":"none"});
	return false;
}


function remarksubmit(){
	var remark = $('textarea[name="remark"]').val();
	if(remark==null||remark.trim()==""){alert('评论不能为空');return;}
	var status,book_id,remark_id;
	if((status=$('input[name="status"]').val())=="1"){book_id = $('input[name="book_id"]').val();}
	else if((status=$('input[name="status"]').val())=="2"){remark_id = $('input[name="remark_id"]').val();}
	else {alert('error');return ;}
	$.ajax({
		url : 'Addremark',
		data : {"status": status, "to_id": book_id ,"context" : remark},
		type : 'post',
		success : function(data){
			var obj = eval ("(" + data + ")");
        	if(obj.state=="error")alert(obj.reason);
        	else{
        		alert(obj.data);
        		history.go(0);
        	}
        	retremark();
		},
		error : function(){
			alert('提交失败');
		}
	});
	
}
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
	
	
	//借阅
	$("#borrow").click(function(){
		if(chark()){
			if(confirm("确定借阅该书籍？"))
			{
				var bookborrid = $('input[name="bookborrid"]').val();
				if(bookborrid==""||bookborrid==null){alert("异常错误");return;}
				$.ajax({
					url : 'Borrow',
					data : {"bookborrid": bookborrid},
					type : 'post',
					success : function(data){
						var obj = eval ("(" + data + ")");
			        	if(obj.state=="error")alert(obj.reason);
			        	else{
			        		alert(obj.data);
			        		history.go(0);
			        	}
					},
					error : function(){
						alert('服务器异常');
					}
				});
			}
		}
	});
	
});

//Order Operate
function Order(i,oid){
		if(chark()){
			switch (i){
			case 0:
				if(confirm("确定已拿到书？"))
				{$.ajax({
					url : 'OrderOperate',
					data : {"struts": i+1,"oid":oid},
					type : 'post',
					success : function(data){
						var obj = eval ("(" + data + ")");
			        	if(obj.state=="error")alert(obj.reason);
			        	else{alert(obj.data);history.go(0);}
					},
					error : function(){
						alert('服务器异常');
					}
				});}
				break;
			case 1:
				if(confirm("确定申请还书？"))
				{$.ajax({
					url : 'OrderOperate',
					data : {"struts": i+1,"oid":oid},
					type : 'post',
					success : function(data){
						var obj = eval ("(" + data + ")");
			        	if(obj.state=="error")alert(obj.reason);
			        	else{alert(obj.data);history.go(0);}
					},
					error : function(){
						alert('服务器异常');
					}
				});}
				break;
			case 2:
				if(confirm("确定还书成功？"))
				{$.ajax({
					url : 'OrderOperate',
					data : {"struts": i+1,"oid":oid},
					type : 'post',
					success : function(data){
						var obj = eval ("(" + data + ")");
			        	if(obj.state=="error")alert(obj.reason);
			        	else{alert(obj.data);history.go(0);}
					},
					error : function(){
						alert('服务器异常');
					}
				});}
				break;
			default:
				alert("异常错误");return;
			}
		}
		return false;
	}
function Praise(bid){
	$.ajax({
		url : 'Praise',
		data : {"bid":bid},
		type : 'post',
		success : function(data){
			var obj = eval ("(" + data + ")");
        	if(obj.state=="error")alert(obj.reason);
        	else{history.go(0);}
		},
		error : function(){
			alert('服务器异常');
		}
	});
}
