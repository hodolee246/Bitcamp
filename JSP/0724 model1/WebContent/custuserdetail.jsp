<%@page import="dto.CustuserDto"%>
<%@page import="dao.CustuserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    String id = request.getParameter("id");
    
    CustuserDao dao = CustuserDao.getInstance();
    
    CustuserDto s_dto = dao.SearchData(id);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserdetail</title>
</head>
<body>
<form action="update.jsp">
<table>
	<tr>
		<td>ID :</td>
		<td colspan="2"><input type="text" size="15" value="<%=s_dto.getId() %>" name="id" readonly="readonly" id="id"></td>
	</tr>
	<tr>
		<td>이름 :</td>
		<td colspan="2"><input type="text" size="15" value="<%=s_dto.getName() %>" name="name"></td>
	</tr>
	<tr>
		<td>주소 :</td>
		<td colspan="2"><input type="text" size="15" value="<%=s_dto.getAddress() %>" name="addr"></td>
	</tr>
	<tr height="25">
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="수정"></td>
</form>

		<%-- <td><a href="delete.jsp?id=<%=id%>">삭제</a></td> --%>
		<td><button type="button" onclick="location.href='delete.jsp?id=<%=id%>'">삭제</button></td>
	</tr>
</table>
<script type="text/javascript">


</script>

</body>
</html>