<%@page import="dao.CustuserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	CustuserDao dao = CustuserDao.getInstance();
    
	String delid[] = request.getParameterValues("delck");
	boolean b;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>muldel.jsp</title>
</head>
<body>
    <%
     

    	
    	b = dao.deletedatas(delid);
    	if(b){
    	%>
    	<script type="text/javascript">
    		alert("정상적으로 삭제 되었습니다.");
    		location.href='custuserlist.jsp';
    	</script>	
    	<%
    	}else{
    	%>
    	 <script type="text/javascript">
    	alert("삭제에 실패했습니다.");
    	location.href='custuserlist.jsp';
    	</script>	
    	<%	
    	}
    %>
</body>
</html>