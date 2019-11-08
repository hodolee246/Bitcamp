<%@page import="dto.NoticeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스상세보기</title>

<style type="text/css">
main{
	width: 70%;
	height: 800px; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}
.allfont{
	font-family: 'Noto Sans KR', sans-serif;
	color: gray;
}
#btn{
	margin-top: 15px;
}
table.type02 {
	border-collapse: separate;
	border-spacing: 0;
	text-align: left;
	line-height: 1.0;
	border-top: 1px solid #ccc;
	border-left: 1px solid #ccc;
}
table.type02 th {
	/* width: 150px; */
	padding: 10px;
	font-weight: bold;
	vertical-align: middle;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #fff;
	border-left: 1px solid #fff;
	background: #eee;
	text-align: center;
}	
table.type02 td {
	/* width: 350px; */    	
	padding: 10px;
	vertical-align: middle;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

#frm h2{
	padding : 20px;
	font-family: sans-serif;
} 
</style>
</head>
<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>

<%
NoticeDto dto = (NoticeDto)request.getAttribute("dto");	
%>

<div align="center">

	<form name="frm" id="frm">
		<h2>뉴스 상세보기</h2>
		<table class="type02">
		<col width="100"> <col width="600"> <col width="100"> <col width="200">
		
		<tr>
			<th>title</th>
			<td><%=dto.getTitle() %></td>
			<th>작성일</th>
			<td><%=dto.getWdate() %></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<a href="/miniProject/notice_servlet?command=filedown&filename=<%=dto.getFilename() %>&seq=<%=dto.getSeq() %>"><%=dto.getFilename() %></a>				
			</td>
			<th>다운로드수</th>
			<td>
				<%=dto.getDowncount() %>
			</td>
		</tr>
		<tr>
			<th></th>
			<td colspan="4">
			<textarea rows="40" cols="100" readonly="readonly"><%=dto.getContent() %></textarea>
			</td>
		</tr>
		</table>
		
		<br>
		
		<button type="button" onclick="location.href='./Notice/noticeList.jsp'">목록으로</button>
		
	</form>
</div>

</main>	

<jsp:include page="../footer.jsp" flush="false"/>	

</body>
</html>