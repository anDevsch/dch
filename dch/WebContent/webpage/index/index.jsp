<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*" errorPage=""%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="webpage/index/res/css/main.css">
<link rel="stylesheet" href="webpage/index/res/css/login.css" >
<s:if test="%{#session.loginUser!=null}">
	<link rel="stylesheet" href="webpage/index/res/css/loginuser.css">
		<script>function chark(){return true;}</script>
</s:if>
<s:else>
	<script>function chark(){alert("请先登录");return false;}</script>
</s:else>
<title>图书馆</title>

<!--superfish-->
		<link rel="stylesheet" href="webpage/index/res/css/superfish.css" media="screen">
		<script src="webpage/index/res/js/jquery.js"></script>
		<script src="webpage/index/res/js/jquery.form.js"></script>
		<script src="webpage/index/res/js/login.js"></script>
		<script src="webpage/index/res/js/superfish.js"></script>
		<script type="text/javascript" src="webpage/index/res/js/jquery-QuinnSlideshow-1.0.js"></script>
		<script type="text/javascript" src="webpage/index/res/js/main.js"></script>
		
	<script type="text/javascript">
		//slide
        $(function () {
            $("#QuinnSlideshow").QuinnSlideshow({});	
        });
		recommend();
		function changeValidateCode(obj) {   
			var timenow = new Date().getTime();  
			obj.src="random?d="+timenow;
		}
    </script>
		
		
		
		<script>
				//下拉菜单
		(function($){ //create closure so we can safely use $ as alias for jQuery

			$(document).ready(function(){

				// initialise plugin
				var example = $('#example').superfish({
					//add options here if required
				});

				// buttons to demonstrate Superfish's public methods
				/*
				$('.destroy').on('click', function(){
					example.superfish('destroy');
				});

				$('.init').on('click', function(){
					example.superfish();
				});

				$('.open').on('click', function(){
					example.children('li:first').superfish('show');
				});

				$('.close').on('click', function(){
					example.children('li:first').superfish('hide');
				});
				*/

	
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

<!--superfish-->
</head>
<body>
<div class="alert"><a id="text">异常错误</a></div>
<div class="other"><img src="webpage/index/res/png/topleft.jpg" class="topleft"></div>
<div id="fang">
<div class="title">登录</div><div class="loginreturn"><button class="logret">return</button></div>
<hr class="hr">
<div class="fang1">
<form  onsubmit="return hsubmit()" id="sub">
<input class="input" type="text" name="username" id="ma" placeholder="用户名">
<div id="show" class="show"></div>
<input class="input" type="password" name="password" id="ma" placeholder="密码">
<div id="error" class="show"></div>
<a><img src="random" class="nnn" onclick="changeValidateCode(this)" title="点击图片刷新验证码"></a><input  type="text" class="inputyanzheng" id="qu" name="random" placeholder="验证码" >
<button  class="button1">登录</button>
</form>

<span class="zhuce"><a class="zhuce" href="Toregister">注册  </a>|<a class="zhuce" href="#"> 忘记密码</a></span>
</div>
</div>

<div id="header">
<div class="header">	
<div class="search">
					
                    <form method="get" accept-charset="GBK" onsubmit="return false;" id="search_form" name="search_form">
                    <input class="fand" type="text" id="key" name="sear" placeholder="书名/作者名" />
                    <!-- class="big_search"-->
                       <div class="fff" onclick="Search(document.getElementById('key').value);"><input class="submit" type="submit" value="提交"></div>
                    </form>

					
</div>
				<button class="login">登录</button><span class="aflogin"><a>${session.loginUser.nickname}</a>&nbsp;|&nbsp;<a href="Exit">注销</a></span>
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
					<li>
						<a href="Rank?cify=0">新书榜&emsp;&nbsp;&nbsp;</a>
					</li>
					<li>
						<a href="Rank?cify=1">推荐榜</a>
					</li>
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


<div class="indexpng">
<div class="indexpngnext">
	<div class ="Z-main">
		<div class="Z-left">
			<div class="Z-top">
				<a title="&emsp;&emsp;&emsp;&nbsp;学习、阅读"><img src="webpage/index/res/png/reference.png"></a>
			</div>
			<div class="Z-buttom">
				<ul>
					<li style="background-color:#4DC2EF"><a href="Toshare">分享上传</a></li>
					<li style="background-color:#EC89D2"><a href="Rank?cify=0">分享榜单</a></li>
				</ul>
			</div>
		</div>
		<div class="Z-right">
			<div class="Z-top">
				<a title="&emsp;&emsp;扫描二维码下载APP"><img src="webpage/index/res/png/code.png" title="扫描二维码下载APP"></a>
			</div>
			<div class="Z-buttom">
				<ul>
					<li style="background-color:#4760DE"><a href="Rank?cify=1">专家推荐</a></li>
					<li style="background-color:#7AA749"><a href="Friend_cir">书友圈</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
</div>
<div id="body">



<div class="tit">
		<a>精品推荐</a>
	</div>
<div class="recommend">
	<div class="showuser"></div>
		<div class="lef">
		<!-- 
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
			 -->
			
			<div class="pingright">
				<div class="title" style="padding:20px 0px 5px 0px;border-bottom:1px solid #ddd;"><span style="margin:0px 20px;font-size:24px;color:#555;font-weight:600;">最新书籍</span></div>
				<div class="reee">
				<div class="showuser"></div>
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
				</div>
			</div>
		</div>
		<div class="cen">
		<div style="border-bottom:1px solid #ddd;"><h3 style="color:#555;margin-bottom:5px;">&emsp;书籍推荐</h3></div>
			<div id="slide">

			  <div id="QuinnSlideshow">
				   <ul>
				   	<s:iterator value="rebooks" var="bookas" status="st">
				   	<s:if test="#st.count<=5">
					   <li><div><div class="ppp" onclick="javascript:window.location.href='OrderBook?bookid=${bookas.id}'" style="background-image:url('upload/${bookas.bookpng}');">
					   		<span>
					   			<a class="ti"><b>&lt;&lt;${bookas.bookname}&gt;&gt;</b></a>
					   			<a class="co"><b>作者：</b>${bookas.author}</a>
					   			<a class="co"><b>简介：</b>${bookas.description}</a>
							</span>
					   	</div></div></li>
					  </s:if>
					  </s:iterator>
					   <!-- <li><img src="webpage/index/res/png/5.jpg" alt="5"/></li>  -->
				
				   </ul>
				</div>
			</div>
		</div>
		<div class="rig">
			<div class="padding">
				<div class="hotsign"></div><h2>排行榜</h2>
				<ul id="list">
					<s:iterator value="#request.books" id="book" status="st">
					<li onclick="javascript:location.href = 'OrderBook?bookid=${book.id}';">
						<div class="bookpngshow" style="background-image:url('upload/${book.bookpng }')"></div>
						<span>
							<a class="bookname">${book.bookname }</a>
							<a class="bookauthor">作者：${book.author }</a>
							<a class="view">${book.priace}</a>
						</span>
					</li>
					</s:iterator>
					<!-- 
					<li>
					<div class="bookpngshow" style="background-image:url('webpage/index/res/png/tuili.jpg')"></div>
					<span><a class="bookname">三生三世十里桃花</a><a class="bookauthor">作者：李冰</a><a class="view">11100</a></span>
					</li>
					<li>
					<div class="bookpngshow" style="background-image:url('webpage/index/res/png/tuili.jpg')"></div>
					<span><a class="bookname">三生三世十里桃花</a><a class="bookauthor">作者：李冰</a><a class="view">11100</a></span>
					</li>
					<li>
					<div class="bookpngshow" style="background-image:url('webpage/index/res/png/tuili.jpg')"></div>
					<span><a class="bookname">三生三世十里桃花</a><a class="bookauthor">作者：李冰</a><a class="view">11100</a></span>
					</li>
					 -->
				</ul>
			</div>
			<a class="more">更多</a>
		</div>

</div>
<div class="tit">
	<a>&nbsp;</a>
</div>
<!-- 
<div class="tit">
	<a>校园圈子</a>
</div>
<div class="circle">
	<div class="lef">
		<div class="blank">
			<a><img src="webpage/index/res/png/wenxue.jpg"></a>
		</div>
		<a>文学</a>
		<span>以文交友，以精得粉</span>
		<span>1000W</span>
		
	</div>
	<div class="cen">
		<div class="blank">
			<a><img src="webpage/index/res/png/tuili.jpg"></a>
		</div>
		<a>推理</a>
		<span>科学推理：让你用科学的方法解开迷惑。</span>
		<span>1000W</span>
		
	</div>
	<div class="rig">
		<div class="blank">
			<a><img src="webpage/index/res/png/xiaoyuan.jpg"></a>
		</div>
		<a>校园</a>
		<span>青嶂青溪直复斜，春雪空濛帘外寒；校量功力相千万，园林月白秋霖散。</span>
		<span>1000W</span>
		
	</div>
</div>
<div class="circle-other">
	<div class="circle-other-buttom">
		<a><img src="webpage/index/res/png/kehuan.jpg"></a>
		<a><span>科幻</span><span>9948部作品</span></a>
	</div>
	<div class="circle-other-buttom">
		<a><img src="webpage/index/res/png/xiaoyuan.jpg"></a>
		<a><span>校园</span><span>9948部作品</span></a>
	</div>
	<div class="circle-other-buttom">
		<a><img src="webpage/index/res/png/qanqing.jpg"></a>
		<a><span>感情</span><span>9948部作品</span></a>
	</div>
	<div class="circle-other-buttom">
		<a><img src="webpage/index/res/png/xiaoyuan.jpg"></a>
		<a><span>校园</span><span>9948部作品</span></a>
	</div>
	<div class="circle-other-buttom">
		<a><img src="webpage/index/res/png/xiaoyuan.jpg"></a>
		<a><span>校园</span><span>9948部作品</span></a>
	</div>
	
</div>
 -->
</div>
<s:include value="../../footer.jsp"></s:include>

</body>
</html>