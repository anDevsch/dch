<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="res/js/bookbyuser.js"></script>
<s:if test="ubooks.size()>0">
<s:iterator value="ubooks" var="book">
	<div class="recommend_book" style="background-image:url('upload/${book.bookpng}');">
							<input name="bid" value="${book.id}" type="hidden" />
							<input name="bookname" value="${book.bookname}" type="hidden" />
							<input name="author" value="${book.author}" type="hidden" />
							<input name="praise" value="${book.priace}" type="hidden" />
							<input name="desc" value="${book.description}" type="hidden" />
						</div>
</s:iterator>
</s:if>
<s:else>
<a style="font-family:'Bahamas';font-size:85px;color:#B0D8D8;display:block;text-align:center;">暂无书籍</a>
</s:else>
</body>
</html>