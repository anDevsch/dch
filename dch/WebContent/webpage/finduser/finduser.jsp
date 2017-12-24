<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*" errorPage=""%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="webpage/finduser/res/css/main.css">
<title>图书馆</title>
</head>
<body>
<s:include value="../../header.jsp"></s:include>
<script src="webpage/finduser/res/js/book.js"></script>
<div class="backgroundimage" style="background-image:url('background/background.jpg');"></div>
<div id="body">
<a class="ttt">${user.nickname}&nbsp;<span style="color:#55799E;font-size:24px;font-weight:100;">的读书屋</span></a>
<div class="infor">
	<div class="headpng" style="background-image:url('headpng/${user.headpng}')"><span>赞<br/>22</span></div>
	<div class="userinfor">
		<a class="tname">${user.nickname}</a>
		<span><a>${user.sex}</a>|<a>${user.age}岁</a>|<a>${user.grade}</a></span>
		<a class="tname">个性签名</a>
		<span><a><s:property value="user.sign" /></a></span>
	</div>
</div>
<div class="message" >
	<a class="tname">Ta的分享</a>
	<hr style="    width: 1050px;">
		<div class="showuser"></div>
		<s:if test="rebooks.size()>0">
			<s:iterator value="rebooks" var="bookas" status="st">
				<s:if test="#st.count<=4">
				<div class="recommend_book" style="background-image:url('upload/${bookas.bookpng}');">
					<input name="bid" value="${bookas.id}" type="hidden" />
					<input name="bookname" value="${bookas.bookname}" type="hidden" />
					<input name="author" value="${bookas.author}" type="hidden" />
					<input name="praise" value="${bookas.priace}" type="hidden" />
					<input name="desc" value="${bookas.description}" type="hidden" />
				</div>
				</s:if>
			</s:iterator>
			</s:if>
<s:else>
<a style="font-family:'Bahamas';font-size:85px;color:#B0D8D8;display:block;text-align:center;">暂无书籍</a>
</s:else>
	<div style="height:100px"></div>
</div>

</div>
<s:include value="../../footer.jsp"></s:include>

</body>
</html>