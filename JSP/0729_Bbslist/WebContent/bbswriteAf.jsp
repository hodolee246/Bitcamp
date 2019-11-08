<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@page import="sun.security.jca.GetInstance"%>
<%@page import="dao.MemberDao"%>
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
String title = request.getParameter("title");
String content = request.getParameter("content");

BbsDto dto = new BbsDto(id, title, content);

BbsDao dao = BbsDao.getInstance();

boolean b = dao.AddBbsList(dto);


if(b){

%>	
	<script type="text/javascript">
	alert("게시물 추가");
	location.href='bbslist.jsp';
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("게시물 추가 실패");
	history.go(-1);
	</script>
<%
}
%>
</body>
</html>