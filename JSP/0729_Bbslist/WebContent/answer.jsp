<%@page import="dto.MemberDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
   String s_seq = request.getParameter("seq");
    
    int seq = Integer.parseInt(s_seq);
    
    BbsDao dao = BbsDao.getInstance();
    
    BbsDto dto = dao.CheckListAll(seq);
    
    Object ologin = session.getAttribute("login");
    MemberDto mem = (MemberDto)ologin;
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
</table>

<br>
<form action="answerAf.jsp">
<input type="hidden" name="seq" value="<%=s_seq%>">
<table>
	<tr>
		<td>ID</td>
		<td colspan="2"><input type="text" name="id" value="<%=mem.getId()%>"></td>
	</tr>
	<tr>
		<td>Title</td>
		<td colspan="2"><input type="text"  name="title" ></td>
	</tr>
	<tr>
		<td>Content</td>
		<td><textarea cols="28" rows="5" name="content"></textarea></td>
	</tr>
	<tr>
		<td><button type="submit">왜위에?</button></td>
	</tr>
</table>
</form>

</body>
</html>