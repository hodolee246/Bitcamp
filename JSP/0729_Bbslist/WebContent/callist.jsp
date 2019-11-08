<%@page import="dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.CalendarDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!public String two(String msg){
	return msg.trim().length() < 2?"0"+ msg.trim():msg.trim();
} %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%

CalendarDao dao = CalendarDao.getInstance();
MemberDto mem = (MemberDto)session.getAttribute("login");

String year = request.getParameter("year");
String _month = request.getParameter("month");
String _day = request.getParameter("day");



String month = two(_month);
String day = two(_day);



List<CalendarDto> list = dao.getCalList(mem.getId(), year + month + day);

%>
<h1><%=year %>년<%=month %>월<%=day %>일 일정</h1>
<br>
	<%
	for(CalendarDto dto : list){
	%>
		<a href = "caldetail.jsp?seq=<%=dto.getSeq()%>"><h3><%=dto.getTitle() %></h3></a><br>
	<%
	}
	%>



</div>
</body>
</html>