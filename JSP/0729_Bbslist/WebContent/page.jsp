<%@page import="java.util.List"%>
<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<br>

<div>



</div>


<%
    
    int count = 1;
    BbsDao dao = BbsDao.getInstance();
    
    List<BbsDto> list = dao.getBbsList();
    
    
    for(int i=0; i<list.size();i=i+5){
    	%>
    		<script type="text/javascript">
    		$(function () {
				$("div").append(content)	
			});
    		</script>
    	<%
    	}
    %>
</body>
</html>