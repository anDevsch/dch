<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*" errorPage=""%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="res/css/main.css">
<s:if test="%{#session.loginUser!=null}">
	<link rel="stylesheet" href="res/css/loginuser.css">
	<script>function chark(){return true;}</script>
</s:if>
<s:else>
	<script>function chark(){alert("请先登录");return false;}</script>
</s:else>
<link rel="stylesheet" href="res/css/superfish.css" media="screen">
		<script src="res/js/jquery.js"></script>
		<script src="res/js/superfish.js"></script>
		<script>
				//下拉菜单
		(function($){ //create closure so we can safely use $ as alias for jQuery

			$(document).ready(function(){

				// initialise plugin
				var example = $('#example').superfish({
					//add options here if required
				});
			});

		})(jQuery);
		function Search(s){
			$.ajax({
				url : 'Search',
				data : {"sear":s.trim()},
				type : 'post',
				success : function(data){
					$("html").html(data);
				},
				error : function(){
					alert('服务器异常');
				}
			});
		}
		</script>
</head>
<body>

<div id="header">
<div class="header">	
<div class="search">
					
                    <form method="post" accept-charset="UTF-8" onsubmit="return false;" id="search_form" name="search_form">
                    <input class="fand" type="text" id="key" name="sear" placeholder="书名/作者名" />
                    <!-- class="big_search"-->
                       <div class="fff" onclick="Search(document.getElementById('key').value);"><input class="submit" type="submit" value="提交"></div>
                    </form>

					
</div>
				<button class="login" onclick="javascript:window.location.href='Tologin'">登录</button><span class="aflogin"><a>${session.loginUser.nickname}</a>&nbsp;|&nbsp;<a href="Exit">注销</a></a></span>
				<a>关于本站</a>
</div>
<div class="mean">
	<div id="menu">
	<div id="sign"></div>
	<div id="men">
		<ul class="sf-menu" id="example">
			<li class="current">
				<a href="Index">&nbsp;首&emsp;页&emsp;</a>
				
			</li>
			<li>
				<a href="Classify">分&emsp;类</a>
				<ul>
					<li><a href="Classify?cify=1">人&emsp;文&emsp;&nbsp;&nbsp;</a></li>
					<li><a href="Classify?cify=2">科&emsp;学</a></li>
					<li><a href="Classify?cify=3">语&emsp;言</a></li>
					<li><a href="Classify?cify=4">杂&emsp;志</a></li>
					<li><a href="Classify?cify=5">其&emsp;他</a></li>
				</ul>
			</li>
			<li>
				<a href="Rank">排行榜</a>
				<ul>
					<li><a href="Rank?cify=0">新书榜&emsp;&nbsp;&nbsp;</a></li>
					<li><a href="Rank?cify=1">推荐榜</a></li>
				</ul>
			</li>
			<li>
				<a href="Dynamic">最新动态</a>
			</li>	
			<li>
				<a href="myUser" onclick="return chark();">我的账户</a>
			</li>
			<li>
				<a href="Toabout">&nbsp;关&emsp;于&emsp;</a>
			</li>
		</ul>
	</div>
</div>
</div>
</div>
</body>
</html>