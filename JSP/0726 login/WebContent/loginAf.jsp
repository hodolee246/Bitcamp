<%@page import="dao.loginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    loginDao dao = loginDao.getInstance();
    
    boolean b;
    
    b = dao.login(id, pw);
    
    
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
	alert("login");
	location.href="login.jsp";
</script>
<%	
}else{
%>
<script type="text/javascript">
	alert("id or pw is wrong");
	location.href="login.jsp";
</script>
<%
}
%>



</body>
</html>