<%@page import="dao.loginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    
    loginDao dao = loginDao.getInstance();
    
    boolean b;
    
    b = dao.account(id, pw, name, email);
    
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
	alert("Account Success");
	location.href="login.jsp";
</script>
<%	
}else{
%>
<script type="text/javascript">
	alert("Account Fail");
	location.href="account.jsp";
</script>
<%
}
%>
</body>
</html>