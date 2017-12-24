function hsubmit() {
	$("#sub").ajaxSubmit({  
        type: "POST",//提交类型  
        url: "Register",//请求地址
        timeout: 3000,
        data: { "action": "TemporaryImage" },//请求数据  
        success: function (data) {if(data=="true")window.location.href="Tologin";else {$(".text_error").html(data);}},  
        error: function (data) { $(".text_error").html("系统无响应，请稍后再试");},//请求失败的函数  
        async: true  
	}); 
	return false;
}