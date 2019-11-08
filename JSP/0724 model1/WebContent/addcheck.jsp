<%@page import="dao.CustuserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addcheck</title>
</head>
<body>
<h1>데이터 추가확인</h1>
<br><br>
<%


CustuserDao dao = CustuserDao.getInstance();


String id = request.getParameter("id");
String name = request.getParameter("name");
String address = request.getParameter("addr");

	boolean b = dao.addData(id, name, address);
	%>
	
	
<script type="text/javascript">	
	<%
	if(b){
	%>
		alert("추가되었습니다.");
		location.href='custuserlist.jsp';
	<%
	}else{
	%>
		alert("추가에 실패했습니다.");
		location.href='custuserlist.jsp';
	<%		
	}
	%>
</script>
</body>
</html>