<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*" errorPage=""%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="webpage/user/res/css/main.css">
<title>图书馆</title>
</head>
<body>
<s:include value="../../header.jsp"></s:include>
		<script src="webpage/user/res/js/mune.js"></script>
		<script type="text/javascript" src="res/js/jquery.js"></script>
		<script type="text/javascript" src="res/js/jquery.form.js"></script>
		<script type="text/javascript" src="webpage/user/res/js/user_change.js"></script>
<div id="body">
<a class="ttt">我的账户</a>

<div class="infor">
	<div class="headpng" style="background-image:url('headpng/${user.headpng}')"></div>
	<div class="userinfor">
		<a class="tname">个人信息</a>
		<span><a title="姓名">${user.nickname}</a>|<a title="班级">${user.grade}</a>|<a title="性别">${user.sex}</a>|<a title="年龄">${user.age}</a></span>
		<a class="tname">个性签名</a>
		<span><a><s:property value="user.sign" /></a></span>
	</div>
</div>
<div class="dy">
<div class="showuser"></div>
	<div class="dyleft">
		<div class="dytitle">
			<span>
				<a id="mymessage" href="javascript:onclick('mymessage');">我的信息</a>
				<a id="myshare" href="javascript:onclick('myshare');">我的分享</a>
				<a id="myborrow" href="javascript:onclick('myborrow');">我的借阅</a>
				<a id="mydynamic" href="javascript:onclick('mydynamic');">我的动态</a>
			</span>
		</div>
		<div class="dyzoom">
			<div class="mymessage">
				<form id="sub" enctype="multipart/form-data" onsubmit="return hsubmit()" >
				<input name="userMod.userflag" type="hidden" value="${user.id}"/>
				<div class="span">
					<h3>个人信息</h3>
					<p>头像：<br><a><img name="headpng" src="headpng/${user.headpng}" /></a><b class="file">更换头像<input name="headpng" type="file" /></b>
						<button>确认信息</button><p>
					<p>姓名：<br><input name="userMod.nickname" disabled="disabled" type="text" value="${user.nickname}" placeholder="姓名"/><p>
					<p>班级：<br><input name="userMod.grade" disabled="disabled" type="text" value="${user.grade}" placeholder="班级"/><p>
					<p>性别：<br><input name="userMod.sex" disabled="disabled" type="text" value="${user.sex}" placeholder="性别"/><p>
					<p>手机：<br><input name="userMod.phonenumber" disabled="disabled" type="text" value="${user.phonenumber}" placeholder="手机"/><p>
					<p>年龄：<br><input name="userMod.age" type="text" value="${user.age}" placeholder="年龄"/><p>
					<p>邮箱：<br><input name="userMod.email" type="text" value="${user.email}" placeholder="邮箱"/><p>
					<p>QQ号：<br><input name="userMod.classnumber" type="text" value="${user.classnumber}" placeholder="QQ号"/><p>
				</div>
				<div class="span">
					<h3>个性签名</h3>
					<p><textarea name="userMod.sign">${user.sign}</textarea></p>
				</div>
				<div class="span">
					<h3>我的标签</h3>
					<span>学霸</span>
					<span>宅男</span>
					<span>游戏</span>
					<span>读书</span>
					<span>听音乐</span>
					<span>55</span>
				</div>
				</form>
			</div>
			<div class="myshare">
				<div class="span">
					<h3>我的分享</h3>
					<s:if test="sharebooks.size()>0">
						<s:iterator value="sharebooks" var="sharebook">
							<div class="bookdemo" style="background-image:url('upload/${sharebook.bookpng}')">
								<input name="bid" value="${sharebook.id}" type="hidden" />
								<input name="bookname" value="${sharebook.bookname}" type="hidden" />
								<input name="author" value="${sharebook.author}" type="hidden" />
								<input name="praise" value="${sharebook.priace}" type="hidden" />
								<input name="desc" value="${sharebook.description}" type="hidden" />
							</div>
						</s:iterator>
					</s:if>
					<s:else>
						<a style="font-family:'Bahamas';font-size:85px;color:#B0D8D8;display:block;text-align:center;">暂无分享</a>
					</s:else>
				</div>
			</div>
			<div class="myborrow">
				<div class="span">
					<h3>我的借阅</h3>
					<s:if test="borrbooks.size()>0">
						<s:iterator value="borrbooks" var="borrbook">
							<div class="bookdemo" style="background-image:url('upload/${borrbook.bookpng}')">
								<input name="bid" value="${borrbook.id}" type="hidden" />
								<input name="bookname" value="${borrbook.bookname}" type="hidden" />
								<input name="author" value="${borrbook.author}" type="hidden" />
								<input name="praise" value="${borrbook.priace}" type="hidden" />
								<input name="desc" value="${borrbook.description}" type="hidden" />
							</div>
						</s:iterator>
					</s:if>
					<s:else>
						<a style="font-family:'Bahamas';font-size:85px;color:#B0D8D8;display:block;text-align:center;">暂无借阅</a>
					</s:else>
				</div>
			</div>
			<div class="mydynamic">
				<div class="span">
					<h3>我的动态</h3>
						<s:if test="dynas.size()>0">
							<s:iterator value="dynas" var="dy">
								<div class="dy_nemo" click="javascript:window.location.href='OrderBook?id=${dy.id}';">
									<div class="nemo_left">
										<img src="upload/${dy.headpng}"/></div>
									<div class="nemo_right">
										<h3>${dy.title}</h3>
										<p>${dy.context}</p>
										<span>${dy.crdatetime}</span>
									</div>
								</div>
							</s:iterator>
						</s:if>
					<s:else>
						<a style="font-family:'Bahamas';font-size:85px;color:#B0D8D8;display:block;text-align:center;">暂无动态</a>
					</s:else>
				</div>
				<div class="spite"><ul>
	<li><a href="myUser?page=${grobe.curr-1}"><span>上一页</span></a></li>
	<s:if test="%{grobe.curr+1<=grobe.page}">
		<li><a href="myUser?page=${grobe.curr+1}"><span>下一页</span></a></li>
	</s:if>
	<s:else>
		<li><a><span>下一页</span></a></li>
	</s:else>
	&emsp;共${grobe.page}页/当前第${grobe.curr}页
	</ul></div>
			</div>
		</div>
	</div>
	<div class="dyright">
		<div class="list">
			
			<h3>我的关注</h3>
			<s:iterator value="foxusers" var="fuser">
				<div class="one" style="background-image:url('headpng/${fuser.headpng}')">
					<input name="nid" value="${fuser.id}" type="hidden"/>
					<input name="name" value="${fuser.nickname}" type="hidden"/>
					<input name="sex" value="${fuser.sex}" type="hidden"/>
					<input name="grade" value="${fuser.grade}" type="hidden"/>
				</div>
			</s:iterator>
		</div>
		<div class="list">
			<h3>关注我的</h3>
			<s:iterator value="foxusers" var="fuser">
				<div class="one" style="background-image:url('headpng/${fuser.headpng}')">
					<input name="nid" value="${fuser.id}" type="hidden"/>
					<input name="name" value="${fuser.nickname}" type="hidden"/>
					<input name="sex" value="${fuser.sex}" type="hidden"/>
					<input name="grade" value="${fuser.grade}" type="hidden"/>
				</div>
			</s:iterator>
		</div>
	</div>
</div>

</div>
<s:include value="../../footer.jsp"></s:include>

</body>
</html>