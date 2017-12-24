<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="webpage/dynamic/res/css/dy.css">
<title>最新动态</title>
</head>
<body>
<s:include value="../../header.jsp"></s:include>
	<script src="webpage/dynamic/res/js/dy.js"></script>


<div class="body">
<div class="tita"><a>最新动态</a></div>
<div class="dy_left">

	<s:iterator value="dynas" var="dy">
		<div class="dy_nemo">
			<div class="nemo_left">
				<img src="upload/${dy.headpng}"/></div>
			<div class="nemo_right">
				<h3><a href="OrderBook?bookid=${dy.book_id}">${dy.title}</a></h3>
				<p>${dy.context}</p>
				<span>${dy.crdatetime}</span>
			</div>
		</div>
	</s:iterator>



	<!-- 
	<div class="dy_nemo">
		<div class="nemo_left">
			<img src="upload/1505548911273.png"/></div>
		<div class="nemo_right">
			<h3>【WeChat】微信页面弹出键盘后iframe内容变空白</h3>
			<p>BUG 还原 当键盘弹出后，页脚也被顶起来；而当搜索完（要刷新整体页面），键盘缩回后，iframe里 键盘当住的地方变成白色。 前言： 因为iframe要适配，so，高度要计算出来 //...</p>
			<span>时间：昨天&nbsp;17:58</span>
		</div>
	</div>
	 -->
</div>
<div class="showuser"></div>
<div class="dy_right">
	<div class="dy_ret">
		<div class="list">
			<h3>推荐用户</h3>
			<s:iterator value="users" var="u">
				<div class="one" style="background-image:url('headpng/${u.headpng}')">
					<input name="nid" value="${u.id}" type="hidden"/>
					<input name="name" value="${u.nickname}" type="hidden"/>
					<input name="sex" value="${u.sex}" type="hidden"/>
					<input name="grade" value="${u.grade}" type="hidden"/>
				</div>
			</s:iterator>
		</div>
	</div>
</div>
</div>

<div class="spite"><ul>
	<li><a href="Dynamic?page=${grobe.curr-1}"><span>上一页</span></a></li>
	<s:if test="%{grobe.curr+1<=grobe.page}">
		<li><a href="Dynamic?page=${grobe.curr+1}"><span>下一页</span></a></li>
	</s:if>
	<s:else>
		<li><a><span>下一页</span></a></li>
	</s:else>
	&emsp;共${grobe.page}页/当前第${grobe.curr}页
	</ul></div>


<s:include value="../../footer.jsp"></s:include>
</body>
</html>