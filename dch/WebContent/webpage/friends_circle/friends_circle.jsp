<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="webpage/friends_circle/res/css/friend.css">
<title>书友圈</title>
</head>
<body>
<s:include value="../../header.jsp"></s:include>
<script src="webpage/friends_circle/res/js/friend.js"></script>
<div id="body">
<a class="ttt">书友圈</a>
<div class="bookcircle">
<div class="showuser"></div>
<div class="focuscircle">
	<div class="concent">
		<div class="left">
			<div class="leftlist">
				<span>Ta的关注</span>
				<s:iterator value="foxusers" var="fuser">
					<div class="one" style="background-image:url('headpng/${fuser.headpng}')">
						<input name="headpng" value="${fuser.headpng}" type="hidden"/>
						<input name="nid" value="${fuser.id}" type="hidden"/>
						<input name="name" value="${fuser.nickname}" type="hidden"/>
						<input name="sex" value="${fuser.sex}" type="hidden"/>
						<input name="grade" value="${fuser.grade}" type="hidden"/>
					</div>
				</s:iterator>
			</div>
			
			
			<div class="leftlist">
				<span>Ta的同学</span>
				<s:iterator value="foxusers" var="fuser">
					<div class="one" style="background-image:url('headpng/${fuser.headpng}')">
						<input name="headpng" value="${fuser.headpng}" type="hidden"/>
						<input name="nid" value="${fuser.id}" type="hidden"/>
						<input name="name" value="${fuser.nickname}" type="hidden"/>
						<input name="sex" value="${fuser.sex}" type="hidden"/>
						<input name="grade" value="${fuser.grade}" type="hidden"/>
					</div>
				</s:iterator>
			</div>
		</div>
		<div class="right">
			<div class="top">
				<div class="headpng">
					<div class="img" ></div>
					<div class="guanzhu"><span><a class="focusfoxsize">2</a><a>关注</a></span><span><a class="focussize">5</a><a>粉丝</a></span></div>
				</div>
				<div class="message">
					<span><a class="focusnickname">qq_4521526</a></span>
					<span><a class="focustruename">姓名</a>|<a class="focussex">性别</a>|<a class="focusgrade">班级</a>|<a class="focussign">签名</a></span>
				</div>
			</div>
			<div class="bottom">
				<div class="focus-menu">
					<span><a>Ta的分享</a><!-- <a>Ta的阅读</a> --></span>
				</div>
				<div class="fen-book">
					<!-- 
					<div class="thebook" style="background-image:url('webpage/friends_circle/res/png/020.jpg')"></div>
					<div class="thebook" style="background-image:url('webpage/friends_circle/res/png/90.jpg')"></div>
					<div class="thebook" style="background-image:url('webpage/friends_circle/res/png/90.jpg')"></div>
					<div class="thebook" style="background-image:url('webpage/friends_circle/res/png/90.jpg')"></div>
					<div class="thebook" style="background-image:url('webpage/friends_circle/res/png/90.jpg')"></div>
					<div class="thebook" style="background-image:url('webpage/friends_circle/res/png/90.jpg')"></div>
					 -->
				</div>
			</div>
			
		</div>
	</div>
</div>



<div class="blank"></div>
<!-- 
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



</div>
<s:include value="../../footer.jsp"></s:include>
</body>
</html>