<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*" errorPage=""%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="webpage/login/res/css/main.css" >
<script type="text/javascript" src="webpage/login/res/js/jquery.js"></script>
<script type="text/javascript" src="webpage/login/res/js/jquery.form.js"></script>
<script type="text/javascript" src="webpage/login/res/js/login.js"></script>
<title>图书馆</title>
<script type="text/javascript">
	function changeValidateCode(obj) {   
		var timenow = new Date().getTime();  
		obj.src="random?d="+timenow;
	}
	</script>
</head>
<body>
<div class="alert"><a id="text">异常错误</a></div>
<div id="body">
<div class="sign"></div>
<div id="fang">
<div class="title">低碳图书馆</div>
<hr class="hr">
<div class="fang1">
<form id="sub" onsubmit="return hsubmit()">
<input class="input" type="text" name="username" id="ma" placeholder="用户名">
<div id="show" class="show"></div>
<input class="input" type="password" name="password" id="ma" placeholder="密码">
<div id="error" class="show"></div>
<a><img src="random" class="nnn" onclick="changeValidateCode(this)" title="点击图片刷新验证码"></a><input  type="text" class="inputyanzheng" id="qu" name="random" placeholder="验证码" >
<button  class="button1">登录</button>
</form>

<span><a href="Toregister">注册</a>|<a href="#">忘记密码</a></span>
<div class="footer"><a>Copyright&nbsp;©&nbsp;YSJ团队</a></div>
</div>
</div>
</div>
</body>
</html>