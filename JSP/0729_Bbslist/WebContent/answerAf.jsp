<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String id = request.getParameter("id");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String s_seq = request.getParameter("seq");
    
    int seq = Integer.parseInt(s_seq);
    
    BbsDao dao = BbsDao.getInstance();
    		
    BbsDto dto = new BbsDto(id, title, content);

    boolean b = dao.answer(seq, dto);
    
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
	alert("답글 입력완료");
	location.href='bbslist.jsp';
	</script>
	<%
	
}else{
	%>	
	<script type="text/javascript">
	alert("답글 입력실패");
	location.href='bbslist.jsp';
	</script>
	<%
	
}
%>
</body>
</html>