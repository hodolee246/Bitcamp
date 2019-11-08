<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String hobby[] = request.getParameterValues("hobby");
String age = request.getParameter("age");
String ahhh = request.getParameter("ahhh");
%>

아이디:<%=id %>
<br>
패스워드:<%=pwd %>
<br>
취미:
<% 
for(int i=0; i<hobby.length;i++){
%>
<%=hobby[i] %>
<%
}
%>	
<br>
나이:<%=age %>
<br>
상세내역:<%=ahhh %>



</body>
</html>