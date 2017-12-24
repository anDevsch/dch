<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="webpage/orderbook/res/css/book.css">
<title>书友圈</title>
</head>
<body>

<div id="remark">
	<div class="remark">
	<h2>评论</h2>
		<span><a>书名：${book.bookname}</a><a>添加评论</a></span>
		<form onsubmit="remarksubmit();return false;">
			<input name="status" value="1" type="hidden" />
			<input name="book_id" value="${book.id}" type="hidden" />
			<input name="remark_id" value="" type="hidden" />
			<textarea name="remark" class="textarea"></textarea>
			<button onclick="return retremark()">返回</button><button class="submit">提交</button>
		</form>
	</div>
</div>
<s:include value="../../header.jsp"></s:include>
<script src="webpage/orderbook/res/js/book.js"></script>


<div id="body">
	<div class="bookdiv">
		<div class="praise"><img src="webpage/orderbook/res/png/zan.gif" /><a>${book.priace}</a></div>
		<div class="bookpng" style="background-image:url('upload/${book.bookpng}');">
			
		</div>
		<div class="bookmessage">
			<div class="messtop">
				<span>${book.bookname}</span>
				<span>作者：<a>${book.author}</a>出版日期：<a>${book.publicdatetime}</a></span>
			</div>
			<div class="borrow">
				<s:if test="%{book.struts==0}">
					<span>借阅状态：<a>未借阅</a></span>
					<div class="order_action">
						<form onsubmit="return false;">
							<input name="bookborrid" value="${book.id}" type="hidden" />
							<button class="jieyue" id="borrow">借阅</button>
						</form>
					</div>
				</s:if>
				<s:elseif test="%{book.struts==1}">
					<span>借阅状态：<a>已借阅&emsp;</a>
						<s:if test="%{uuser.struts>=0}">
							<a style="color:#f95252;">${uuser.sign}:${uuser.nickname}&nbsp;电话:${uuser.phonenumber}&nbsp;班级:${uuser.grade}</a>
						</s:if>
					</span>
					<div class="order_action">
						<button class="jieyue">借阅时间${brrot}</button><button class="yuding">预归时间${retut}</button>
						<s:if test="%{uuser.struts==0}">
							<s:if test="%{order.struts==0}">
								<button class="yuding" style="background-color:#444;">待对方确认拿到书</button>
							</s:if>
							<s:elseif test="%{order.struts==2}">
								<button class="yuding" onclick="Order(2,'${order.id}')" style="background-color:#444;">对方已还书？确认</button>
							</s:elseif>
						</s:if>
						<s:elseif test="%{uuser.struts==1}">
							<s:if test="%{order.struts==0}">
								<button class="yuding" onclick="Order(0,'${order.id}');" style="background-color:#444;">已拿到书？确认</button>
							</s:if>
							<s:elseif test="%{order.struts==1}">
								<button class="yuding" onclick="Order(1,'${order.id}')" style="background-color:#444;">申请还书</button>
							</s:elseif>
							<s:elseif test="%{order.struts==2}">
								<button class="yuding" style="background-color:#444;">待对方确认还书</button>
							</s:elseif>
						</s:elseif>
					</div>
				</s:elseif>
				<s:elseif test="%{book.struts==-1}">
					<span>借阅状态：<a>已冻结</a></span>
					<div class="order_action">
						<button class="jieyue">无法借阅</button>
					</div>
				</s:elseif>
				
			</div>
			<div class="jianjie"><span>${book.description}</span></div>
		</div>
	</div>
<div class="blank"></div>
	<div class="pinglun">
		<div class="pingleft">
			<div class="title"><span>小圆桌<div onclick="javascript:Praise('${book.id}');" class="zan"></div><div class="hff" onclick="javascript:remark();"></div></span></div>
			
			<s:if test="remarks.size()>0">
				<s:iterator value="%{remarks}" status="count" var="book_remark">
					<s:if test="#count.Count<=5">
						<div class="pingsmarty">
							<div class="smartypng"><a href="FindUser?nid=${book_remark.user_id.id}"><img src="headpng/${book_remark.user_id.headpng}"></a></div>
							<div class="smartyother">
								<span><a>${book_remark.user_id.nickname}</a><a>
									<s:action name="TogetTime" namespace="/" executeResult="false" ignoreContextParams="true">
										<s:param name="time">${book_remark.remarkdatetime}</s:param>
									</s:action></a></span>
								<span><a>${book_remark.context}</a></span>
								<div class="fonction"><div class="zan"></div><div class="hf"><input name="id" value="${book_remark.id}" type="hidden" /></div></div>
							</div>
						</div>
					</s:if>
				</s:iterator>
			</s:if>
			<s:else>
				<a style="font-family:'Bahamas';font-size:40px;font-weight:1500;color:#aaa;display:block;margin:85px auto;text-align:center;">暂无评论</a>
			</s:else>
			
			
			
			
		</div>
		<div class="pingright">
			<div class="title"><span>阅读推荐</span></div>
			<div class="recommend">
			<div class="showuser"></div>
				<s:iterator value="books" var="bookas" status="st">
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
				<!-- 
				<div class="recommend_book" style="background-image:url('webpage/orderbook/res/png/020.jpg');"></div>
				<div class="recommend_book" style="background-image:url('webpage/orderbook/res/png/020.jpg');"></div>
				<div class="recommend_book" style="background-image:url('webpage/orderbook/res/png/020.jpg');"></div>
				 -->
			</div>
		</div>
	</div>
</div>




<s:include value="../../footer.jsp"></s:include>
</body>
</html>