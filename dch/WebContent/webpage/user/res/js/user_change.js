function hsubmit() {
	try{
	$("#sub").ajaxSubmit({  
        type: "POST",//提交类型  
        url: "UserMod",//请求地址
        timeout: 3000,
        data: { "action": "TemporaryImage" },//请求数据  
        success: function (data) {if(data=="true")window.location.href="myUser";else {alert(data);}},  
        error: function (data) { alert("系统无响应，请稍后再试");},//请求失败的函数  
        async: true  
	}); 
	}
	catch(e){alert("error");}
	return false;
}