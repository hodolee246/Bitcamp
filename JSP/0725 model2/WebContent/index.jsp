<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>


<!-- <a href="custuserlist.jsp">고객목록</a>
 -->
 
 <%
 	response.sendRedirect("CustUserControl?command=list");
 %>
</body>
</html>