<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

BbsDao dao = BbsDao.getInstance();

MemberDto mem = (MemberDto)session.getAttribute("login");
   

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<body>

<div align="center">
<form action="bbswriteAf.jsp">
<table>
	<tr>
		<td>ID</td>
		<td colspan="2"><input type="text" readonly="readonly" value="<%=mem.getId()%>" name="id"></td>
	</tr>
	<tr>
		<td>Title</td>
		<td colspan="2"><input type="text" name="title"></td>
	</tr>
	<tr>
		<td colspan="3">Content</td>
	</tr>
	<tr>
		<td colspan="3"><textarea cols="28" rows="5" name="content"></textarea></td>
	</tr>
	<tr>
		<td><button type="submit">추가</button></td>
	</tr>
</table>
</form>
</div>



</body>
</html>








