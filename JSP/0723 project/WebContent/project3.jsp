<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    
    	Calendar cal = Calendar.getInstance();
    	int time = cal.get(Calendar.HOUR_OF_DAY);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재는<b><%=time %>시</b> 입니다.
<br>
<%
	
if(time > 8 && time < 12){
	out.println("<b>안녕히 주무셨어요</b>");
}else if(time > 11 && time < 24){
	out.println("<b>안녕하세요</b>");
}else if(time > 23 && time < 9){
	out.println("<b>안녕히 주무세요</b>");
}


%>
</body>
</html>