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
boolean isS = (boolean)request.getAttribute("isS");


if(isS){
	%>
	<script type="text/javascript">
		alert("공지 업로드 완료");
		location.href = "./Notice/notice_admin.jsp";
	</script>
	<%
}else{
%>	<script type="text/javascript">
		alert("공지 업로드 실패");
		location.href = "./Notice/notice_admin.jsp";
	</script>
<%
}
%>
</body>
</html>