<%@page import="dao.CustuserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String id = request.getParameter("id");
	
	CustuserDao d_dao = CustuserDao.getInstance();
	boolean d_b = d_dao.DeleteData(id);
			
%>	
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">	
	<%
	if(d_b){
	%>
		alert("삭제되었습니다.");
		location.href='custuserlist.jsp';
	<%
	}else{
	%>
		alert("삭제에 실패했습니다.");
		location.href='custuserdetail.jsp'>;
	<%		
	}
	%>
</script>
</body>
</html>