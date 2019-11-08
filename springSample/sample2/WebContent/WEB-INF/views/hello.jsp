<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- hello는 서블릿에서 데이터 넘기고 받기 -->
<%
	String name = (String)request.getAttribute("name");
	out.println("name:" + name);
%>
<br>

<h3>${name }</h3>

</body>
</html>