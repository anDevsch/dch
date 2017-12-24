function hsubmit() {
	$("#sub").ajaxSubmit({  
        type: "POST",//提交类型  
        url: "Login",//请求地址
        timeout: 3000,
        data: { "action": "TemporaryImage" },//请求数据  
        success: function (data) {if(data=="true")window.location.href="Index";else {$("#text").html(data);$(".alert").css("display","block");fade(0);}},  
        error: function (data) { $("#text").html("系统无响应，请稍后再试");$(".alert").css("display","block");fade(0); },//请求失败的函数  
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