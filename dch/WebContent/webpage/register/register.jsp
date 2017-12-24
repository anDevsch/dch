<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="webpage/register/rsc/css/reg.css">
<script type="text/javascript" src="webpage/register/rsc/js/jquery.js"></script>
<script type="text/javascript" src="webpage/register/rsc/js/jquery.form.js"></script>
<script type="text/javascript" src="webpage/register/rsc/js/register.js"></script>
<title>注册</title>
<script type="text/javascript">
	function changeValidateCode(obj) {   
		var timenow = new Date().getTime();  
		obj.src="random?d="+timenow;
	}
	</script>
</head>
<body>
<div class="bod">
	<div class="reg_h">
	<div class="reg_head"><a class="reg_lo">用户注册</a><a class="reg_re" href="Tologin">用户登录</a></div>
		<form id="sub" onsubmit="return hsubmit()" >
			<div class="reg_l">
				<span>
					<a>手机号</a>
					<input type="text" name="vbreg.phonenumber" placeholder="手机号"/>
				</span>
				<span>
					<a>密码</a>
					<input type="password" name="vbreg.password" placeholder="密码"/>
				</span>
				<span>
					<a>确认密码</a>
					<input type="password" name="vbreg.password_a" placeholder="确认密码"/>
				</span>
				<span>
					<a><img src="random" class="nnn" onclick="changeValidateCode(this)" title="点击图片刷新验证码"></a>
					<input type="text" name="vbreg.yan" placeholder="验证码"/>
				</span>
			</div>
			<div class="reg_r">
				<span>
					<a>姓名</a>
					<input type="text" name="vbreg.nickname" placeholder="姓名"/>
				</span>
				<span>
					<a>班级</a>
					<input type="text" name="vbreg.grade" placeholder="班级"/>
				</span>
				<span>
					<a>性别</a>
					<label><input name="vbreg.sex" type="radio" value="男" style="display:inline-block;height:17px;width:35px;"/>男</label> 
					<label><input name="vbreg.sex" type="radio" value="女" style="display:inline-block;height:17px;width:35px;"/>女</label>
				</span>
				<span>
					<a class="text_error" style="color:red;"></a>
					<button  class="button1">注册</button>
				</span>
			</div>
		</form>
	</div>
	<div class="clear"></div>
</div>
</body>
</html>