<%@page import="pds.PdsDao"%>
<%@page import="pds.ipdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String _seq = request.getParameter("seq");
    
    int seq = Integer.parseInt(_seq);
    
    ipdsDao dao = PdsDao.getInstance();
    
   boolean b = dao.deletePds(seq);
    
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
	alert("삭제됬습니다.");
	location.href='pdslist.jsp';
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("삭제에 실패했습니다.");
	location.href='pdslist.jsp';
	</script>
<%
}
%>
</body>
</html>