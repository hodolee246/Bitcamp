<%@page import="dao.CalendarDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!public String two(String msg){
    	return msg.trim().length() < 2?"0"+ msg.trim():msg.trim();
    } %>
<%
CalendarDao dao = CalendarDao.getInstance();
	
String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

String hour = request.getParameter("hour");
String minute = request.getParameter("minute");

String str = year + two(month) +two(day) + two(hour) + two(minute);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%


boolean b = dao.addCalendarList(id, title, content, str);

if(b){
	%>
	<script type="text/javascript">
	var year = <%=year%>
	var month = <%=month%>
	alert("추가완료");
	location.href="calendar.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("추가실패");
	history.go(-1);
	</script>
	<%
}

%>
</body>
</html>