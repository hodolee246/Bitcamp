<%@page import="project.dto"%>
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

dto dto = new dto();

dto = (dto)request.getAttribute("dto");

String id = dto.getId();
String pwd = dto.getPwd();
String hobby[] = dto.getHobby();
String age = dto.getAge();
String ahhh = dto.getAhhh();

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