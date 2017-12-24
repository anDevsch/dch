<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="webpage/rank/res/css/main.css">
<title>分类</title>
</head>
<body>
<s:include value="../../header.jsp"></s:include>
<div style="clear:both;"></div>
	<div class="classifybox">
		<div class="ttit">
			<ul>
				<li>分类：</li>
				<li><a href="Rank?cify=0"><span>新书榜</span></a></li>
				<li><a href="Rank?cify=0"><span>推荐榜</span></a></li>
			</ul>
		</div>
	</div>
<div class="bodys">
	<div class="fen">当前分类>>${fen}</div>
	<s:if test="books.size()>0">
		<s:iterator value="books" var="b">
			<div class="bookdemo">
				<img class="logo" src="upload/${b.bookpng}">
				<div class="content">
					<ul><li><a class="tit" href="OrderBook?bookid=${b.id}"><span>${b.bookname}</span></a> 
						<s:if test="#b.struts==0"><botton>未借阅</botton></s:if>
						<s:elseif test="#b.struts==1"><botton>已借阅</botton></s:elseif>
						<s:elseif test="#b.struts==-1"><botton>已冻结</botton></s:elseif>&emsp;<img src="webpage/rank/res/png/zan.gif"/>&nbsp;${priace}</li>
						<li><a class="con" href="javascript:;">作者：${b.author}&emsp;出版社：${b.bookname}&emsp;上传时间：${b.updatetime}</a></li>
						<li><p>简介：${b.description}</p></li>
					</ul>
				</div>
			</div>
		</s:iterator>
	</s:if>
	<s:else>
		<a style="font-family:'Bahamas';font-size:85px;color:#B0D8D8;display:block;text-align:center;padding-top:40px;">暂无该类书籍</a>
	</s:else>
</div>
<div class="spite"><ul>
	<li><a href="Classify?cify=${grobe.cify}&page=${grobe.curr-1}"><span>上一页</span></a></li>
	<s:if test="%{grobe.curr+1<=grobe.page}">
		<li><a href="Classify?cify=${grobe.cify}&page=${grobe.curr+1}"><span>下一页</span></a></li>
	</s:if>
	<s:else>
		<li><a><span>下一页</span></a></li>
	</s:else>
	&emsp;共${grobe.page}页/当前第${grobe.curr}页
	</ul></div>
<s:include value="../../footer.jsp"></s:include>
</body>
</html>