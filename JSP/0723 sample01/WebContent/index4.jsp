<%@page import="sample01.YouClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
// YouClass cls = (YouClass)request.getAttribute("you");	// 이사짐 풀러

YouClass cls = (YouClass)request.getSession().getAttribute("you");
%>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

ycls:<%=cls.toString()%>

</body>
</html>