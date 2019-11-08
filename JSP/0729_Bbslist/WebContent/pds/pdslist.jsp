<%@page import="pds.PdsDao"%>
<%@page import="pds.ipdsDao"%>
<%@page import="pds.PdsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    ipdsDao dao = PdsDao.getInstance();
    
    List<PdsDto> list = dao.getPdsList();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsList.jsp</title>
</head>
<body>

<div align="center">

<table border="1">
<col width="50"><col width="100"><col width="400"><col width="60">
<col width="50"><col width="80"><col width="100">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>다운로드</th>
		<th>조회수</th>
		<th>다운로드수</th>
		<th>작성일</th>
	</tr>
	<%
		for(int i=0; i<list.size();i++){
			PdsDto pds = list.get(i);
			%>
			<tr align="center" height="5">
				<td><%=i+1 %></td>
				<td><%=pds.getId() %></td>
				<td align="left">
				<a href="pdsdetail.jsp?seq=<%=pds.getSeq()%>"><%=pds.getTitle()%></a>
				</td>
				<td>
				<input type="button" name="btnDown" value="파일"
				onclick="location.href='../filedown?filename=<%=pds.getFilename()%>&seq=<%=pds.getSeq()%>'">
				</td>
				<td><%=pds.getReadcount() %></td>
				<td><%=pds.getDowncount() %></td>
				<td><%=pds.getregdate() %></td>
			</tr>
			
			
			<%
		}
	%>
</table>
<br>
<a href="pdswrite.jsp">자료올리기</a>



</div>

</body>
</html>