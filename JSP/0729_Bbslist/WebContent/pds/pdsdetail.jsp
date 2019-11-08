<%@page import="pds.PdsDto"%>
<%@page import="pds.PdsDao"%>
<%@page import="pds.ipdsDao"%>
<%@page import="dto.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   
    ipdsDao dao = PdsDao.getInstance();

    MemberDto mem = (MemberDto)session.getAttribute("login");
    
    String _seq = request.getParameter("seq");
  	if(_seq.equals("")|| _seq==null){
  		System.out.println("비어있음");
  	}else{
  		System.out.println("seq:" + _seq);
  	}
    int seq = 0 ;
    
    seq = Integer.parseInt(_seq);
    
    PdsDto dto = dao.getPds(seq);
    
   
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.thid{
	text-align: left;
	padding-left: 15px
}
th{
	text-align: left;
	padding-left: 25px;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


</head>
<body>

<%
dao.pdsReadCount(seq);

%>
<form action="pdsupdateAf.jsp" method="post" enctype="multipart/form-data">
<table border="1">
<col width="80"><col width="350">
	<tr>
		<th class="thid">아이디</th>
		<td><%=dto.getId() %><input type="hidden" name="id" value="<%=_seq%>"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td>
		<input type="text" class="read" name="title" value="<%=dto.getTitle()%>" readonly="readonly">
		</td>
	</tr>
	<tr>
		<th>파일</th>
		<td>
			<input type="button"  value="파일"
			onclick="location.href='../filedown?filename=<%=dto.getFilename()%>&seq=<%=_seq %>" id="down">
			<input type="file" id="upfile" class="read" readonly="readonly" name="fileload">
		</td>
	</tr>
	<tr>
		<th>파일</th>
		<td><input type="file" class="read" readonly="readonly"></td>
	</tr>
	<tr>
		<th colspan="2">내용</th>
	</tr>
	<tr>
		<td colspan="2"><textarea cols="60" rows="15" class="read" readonly="readonly" name="content"><%=dto.getContent() %></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<button type="button" id="downdate">수정</button>
		<button type="submit" id="update">수정완료</button>
		<button type="button" onclick="location.href='pdsdeleteAf.jsp?seq=<%=_seq%>'">삭제</button>
		</td>
	</tr>
</table>
</form>

<script type="text/javascript">

$(function() {
	$("#update").hide();
	$("#upfile").hide();
	
	$("#downdate").click(function() {

	<%
		if(dto.getId().equals(mem.getId())){
	%>
			$(".read").removeAttr("readonly");
			$("#downdate").hide();
			$("#update").show();
			
			$("#down").hide();
			$("#upfile").show();
	<%
		}
	%>
	});
   $("#down").click(function () {
	
	   <%
	   dao.pdsDownCount(seq);
	   %>
	});
  
});

</script>

</body>
</html>