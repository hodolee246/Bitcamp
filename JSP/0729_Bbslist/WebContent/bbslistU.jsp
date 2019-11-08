<%@page import="dao.BbsDao"%>
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
    
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    BbsDao dao = BbsDao.getInstance();
    boolean b = dao.UpdateList(title, content);
    
    if(b){
    	%>
    	<script type="text/javascript">
    	alert("수정했습니다.");
    	location.href="bbslist.jsp";
    	</script>
    	<%
    }else{
    %><script type="text/javascript">
    	alert("수정에 실패했습니다.");
    	history.go(-1);
      </script>
    <%
    }
    %>
</body>
</html>