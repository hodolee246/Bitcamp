<%@page import="dao.loginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String id = request.getParameter("id");
    
    loginDao dao = loginDao.getInstance();
    
    boolean b;
    
    b = dao.idcheck(id);
    		
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(b){
%>
<script type="text/javascript">
	alert("cannot use id");
	location.href="account.jsp";
</script>
<%	
}else{
%>
<script type="text/javascript">
	alert("can use id");
	location.href="account.jsp";
</script>
<%
}
%>
</body>
</html>