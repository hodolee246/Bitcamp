<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	
    	MemberDto dto = (MemberDto)request.getAttribute("dto");
    	System.out.println(dto.toString());
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertAf</title>
</head>
<body>
아이디:<%=dto.getId() %>
<br>
패스워드:<%=dto.getPwd() %>
<br>
취미:
<% 
for(int i=0; i<dto.getHobby().length;i++){
%>
<%=dto.getHobby()[i] %>
<%
}
%>	
<br>
나이:<%=dto.getAge() %>
<br>
상세내역:<%=dto.getStory() %>
</body>
</html>