<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*" errorPage=""%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="webpage/share/res/css/main.css">
<link rel="stylesheet" href="res/css/loading.css">
<title>图书馆</title>

</head>
<body>
<s:include value="../../header.jsp"></s:include>
		<script src="webpage/share/res/js/getbook.js"></script>
		<script src="webpage/share/res/js/jquery.form.js"></script>
<div id="shclDefault">
    <div id="loading-center">
      <div id="loading-center-absolute">
        <div class="loading">低碳图书馆</div>
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
<div id="body">
<a class="upfile_a">分享上传</a>
<div class="upfile">
<div class="upfile2">
	<div class="upcontent">

		<div class="center">
			<form id="getbook" enctype="multipart/form-data">
				<div class="inputdiv"><input class="inputpng" type="file" name="file" id="uploadFile" onchange="change()"></div>
			</form>
			
			<ul class="bookinformation">
				<li>书名：<a  class="lititle"></a></li>
				<li>作者：<a  class="liauthor"></a></li>
				<li>价格：<a  class="lipriace"></a></li>
				<li>出版社：<a  class="lipublicc"></a></li>
				<form id="upbook" enctype="multipart/form-data">
				<li>书籍类型：<select name="type" id="type">
								    <option value="人文">人文</option>
									<option value="科学">科学</option>
									<option value="语言">语言</option>
									<option value="杂志">杂志</option>
									<option value="其他">其他</option>
								</select></li>
				<li>我的感受：<textarea name="description" id="description" placeholder="简洁明了"></textarea></li>
				</form>
			</ul>
		</div>	
	</div>
	<button class="get" onclick="getbook()">获取书籍信息</button>
	<button class="get" onclick="upbook()">确认上传</button>
</div>
</div>





<div class="tit">
	<a> </a>
</div>
</div>
<s:include value="../../footer.jsp"></s:include>

</body>
</html>