<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="res/css/loading.css">
<title>test</title>
</head>
<body>
<s:include value="header.jsp"></s:include>
<from method="post" action="Test.action">
<input type="submit"/>
</from>
<div id="shclDefault">
    <div id="loading-center">
      <div id="loading-center-absolute">
        <div class="loading">@图书馆</div>
        <div class="object" id="object_one"></div>
        <div class="object" id="object_two"></div>
        <div class="object" id="object_three"></div>
        <div class="object" id="object_four"></div>
        <div class="object" id="object_five"></div>
        <div class="object" id="object_six"></div>
        <div class="object" id="object_seven"></div>
        <div class="object" id="object_eight"></div>
      </div>
    </div>
  </div>
<script src="res/js/jquery.shCircleLoader.js" type="text/javascript"></script>




<img src="http://${request.src}" /><br>
书名：${request.title}<br>
作者：${request.author}<br>

<s:include value="footer.jsp"></s:include>
</body>
</html>