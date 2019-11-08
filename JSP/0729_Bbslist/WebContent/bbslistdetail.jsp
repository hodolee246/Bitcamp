<%@page import="dto.BbsDto"%>
<%@page import="dto.MemberDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    BbsDao dao = BbsDao.getInstance();
    
    MemberDto mem = (MemberDto)session.getAttribute("login");
    
    
    String s_seq = request.getParameter("seq");
    int seq = Integer.parseInt(s_seq);
    
    dao.ReadCount(seq);
    
    BbsDto dto = dao.CheckListAll(seq);
    
    String abc = dto.getContent();
    System.out.println(abc);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<div align="center">
<form action="bbslistU.jsp">
<table>
	<tr>
		<td>ID</td>
		<td colspan="2"><input type="text" readonly="readonly" value="<%=dto.getId()%>" name="id"></td>
	</tr>
	<tr>
		<td>Title</td>
		<td colspan="2"><input type="text" readonly="readonly" id="title" value="<%=dto.getTitle()%>" name="title" ></td>
	</tr>
	<tr>
		<td>ReadCount</td>
		<td colspan="2"><input type="text" readonly="readonly" value="<%=dto.getReadcount()%>"></td>
	</tr>
	<tr>
		<td>Sysdate</td>
		<td colspan="2"><input type="text" readonly="readonly" value="<%=dto.getWdate()%>"></td>
	</tr>
	<tr>
		<td colspan="3">Content</td>
	</tr>
	<tr>
		<td colspan="3"><textarea cols="28" rows="5" id="content" readonly="readonly" name="content"><%=dto.getContent()%></textarea></td>
	</tr>
	<tr>
		<td><input type="submit" id="update" value="수정" style=""></td>
		<td><input type="button" id="delete" value="삭제"></td>
		<td><input type="button" onclick="history.go(-1)" value="뒤로가기">
		<td><input type="button" onclick="location.href='answer.jsp?seq=<%=s_seq%>'" value="답글작성"> </td>
		
	</tr>
</table>
</form>
</div>
<%
	if(dto.getId().equals(mem.getId())){
		%>
		<script type="text/javascript">
		$("#update").show();
		$("#delete").show();
		$("#title").removeAttr("readonly");
		$("#content").removeAttr("readonly");
		
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
		$("#delete").hide();
		$("#update").hide();
		</script>
		<%}
%>
<script type="text/javascript">
	$(function () {
		$("#delete").click(function() {
			location.href="bbslistdetailD.jsp?seq=" + <%=seq%>
		});
	
	});
	
	
</script>
</body>
</html>