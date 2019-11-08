<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.iBbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 댓글용 함수
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";	// 여백
	
	String ts = "";
	for(int i = 0;i < depth; i++){
		ts += nbsp;
	}
	return depth==0?"":ts + rs;	// 여백 + 이미지		
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.del{
	color: red;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<%

Object ologin = session.getAttribute("login");
MemberDto mem = null;
if(ologin == null){
	%>
	<script type="text/javascript" >
	alert("로그인해 주십시오");
	location.href="login.jsp";
	</script>
	<%
}
mem = (MemberDto)ologin;
%>

<%

String select = request.getParameter("sel");

String text = request.getParameter("sear");

BbsDao dao = BbsDao.getInstance();

List<BbsDto> list = dao.getBbsListPaging(1, 10);

List<BbsDto> allList = dao.GetSearch(select, text);
System.out.println(allList.size());


%>

<a href="./calendar.jsp">일정관리</a>
<div align="left">
<ul>
	<li><a href="calendat.jsp">일정관리</a></li>
	<li></li>
	<li></li>
</ul>
</div>
<h4 align="left" style=" background-color: #f0f0f0">
<%=mem.getId() %> 님 환영합니다.
</h4>

<div align="center">
<table border="1">
<col width="70"><col width="600"><col width="150">
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th>
	</tr>
	
	<%
		if(allList == null || allList.size() == 0){
	%>
		<tr>
			<td colspan="3">작성된 글이 없습니다.</td>
		</tr>
	<%		
		}else{
			
			for(int i = 0; i < allList.size(); i++){
				BbsDto bbs = allList.get(i);
			%>
		<tr>
			<th><%=i + 1 %></th>
			<%
			if(bbs.getDel()==1){
			%>
			<td class="del">
				이 글은 작성자에 의하여 삭제되었습니다.
			</td>
			
			<td align="center">
				<%=bbs.getId() %>
			</td>		
		</tr>
			<%
			}else{
			%>
			
			<td class="seqclick" seq=<%=bbs.getSeq() %>>
				<%=arrow(bbs.getDepth()) %>
				<%=bbs.getTitle() %>
			</td>
			
			<td align="center">
				<%=bbs.getId() %>
			</td>		
		</tr>	
			<%	
			}
			%>
		
			<%
			}
		}
	%>
</table>
<%
	int count = 1;
	for(int k=0;k<allList.size();k=k+10){
	%>
	<a href="paging.jsp?count=<%=count%>">[<%=count %>]</a>
	<%
	count ++;
	}
%>
<br>
<a href = "bbswrite.jsp">글쓰기</a>
</div>
<div align="left" style="margin: 40px 20px 20px 20px">
<form action="searchbbslist.jsp" method="post">
<table>
	<tr>
		<td>
			<select name="sel">
				<option value="ID">id</option>
				<option value="Title">title</option>
				<option value="Content">Content</option>
		</td>
		<td>
			<input type="text" name="sear">
		</td>
		<td>
			<button type="submit" >search</button>
		</td>
	</tr>	
</table>
</form>

</div>


<script type="text/javascript">
$(function () {
	$(".seqclick").click(function () {
		var seq = $(this).attr("seq");
		
		location.href='bbslistdetail.jsp?seq=' + seq;
				
	});
	

</script>


</body>
</html>

