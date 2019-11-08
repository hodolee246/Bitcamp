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
    String abc = request.getParameter("seq");
   System.out.println("abc : " + abc);
    int seq = Integer.parseInt(abc);
    System.out.println("seq" + seq);
    BbsDao dao = BbsDao.getInstance();
    
   
    
    boolean b = dao.DeleteList(seq);
    		
    
    %>
   
   	<%
		if(b){
	%>
		<script type="text/javascript">
		alert("삭제되었습니다.");
		location.href="bbslist.jsp";
		</script>
	<%		
		}else{
	%>		
		<script type="text/javascript">
		alert("삭제에 실패했습니다.");
		history.go(-2);
		</script>
	<%		
		}
	%> 
    
</body>
</html>