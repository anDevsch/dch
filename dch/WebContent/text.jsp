<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<style>
span{font-family:"Bahamas";font-size:17px;color:#789;font-weight:900;position:absolute;top:-50px;left:-20px;}
.block{display:block;height:200px;width:470px;background-color:#ddd;position:absolute;top:25%;left:50%;margin-left:-235px;}
a{font-family:"Bahamas";font-size:17px;color:#456;text-align:center;display:block;margin:35px 0px;}
button{margin:15px auto;display:block;width:80px;height:30px;font-family:"Bahamas";font-size:14px;color:#555;}
</style>
</head>
<body>
<div class="block">
<span>温馨提示：</span>
<a><s:property value="#request.text"/></a>
<button onclick="javascript:<s:property value="#request.return"/>;">确定</button>
</div>
</body>
</html>