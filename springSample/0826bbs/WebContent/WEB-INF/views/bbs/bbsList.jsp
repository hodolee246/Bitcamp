<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<a href="calendar.jsp">일정관리</a>
<a href="./pds/pdslist.jsp">자료실</a>

<h4 align="right" style=" background-color: #f0f0f0">
${login.id } 님 환영합니다.
</h4>

<div align="center">
<table border="1">
<col width="45"><col width="450"><col width="130">
<tr>
   <th>번호</th><th>제목</th><th>작성자</th>
</tr>
 <c:if test="${empty list }">
    <tr>
      <td colspan="3">작성된 글이 없습니다.</td>
   </tr>
</c:if>

<c:if test="${not empty list }">

   <c:forEach var="m" items="${list }" varStatus="i">
   
      <c:if test="${m.del == 1}">
      
         <span style="color: red"><c:set target="${m}" property="title" value="이 글은 작성자에 의하여 삭제되었습니다." /></span>
         
        <%--  <c:set targer="${m}" property="id" value="삭제" /> --%>
      </c:if>
      <tr>
         <th>${i.index + 1 }</th>
         
         <td class="seqclick" seq=${m.seq } del=${m.del } %>
         
            <c:if test="${m.depth > 0}">
               
               
            </c:if>
            
            ${m.title }
         </td>
         <td>
            ${m.id }
         </td>
      </tr>
      
   </c:forEach>
</c:if>

</table>

</div>

<div align="center">
		<c:set var="i" value="1"/>
	<c:forEach var ="k" begin ="1" end="${fn:length(allList) }" step="10">
		<a href="bbsPaging.do?num=${i }&s_category=${param.s_category}&keyword=${param.keyword}" >${i }</a>
		<c:set var="i" value="${i+1 }"/>
	</c:forEach>
</div>

${fn:length(allList) }

<div align="center">
<form action="searchBbs.do">
<table>
	<tr>
		<td>
			<select name="s_category">
				<option value="id" selected="${s_category eq id?selected:'' }">id</option>
				<option value="title" selected="${s_category eq title?selected:"" }">title</option>
				<option value="content" selected="${s_category eq content?selected:"" }">Content</option>
		</td>
		<td>
			<input type="text" name="keyword" value="${not empty keyword?keyword:"" }">
		</td>
		<td>
			<button type="submit" >search</button>
			<button type="button" id="writeBbs">글 작성</button>
		</td>
	</tr>	
</table>
</form>
</div>



<script type="text/javascript">
$(function () {
	$(".seqclick").click(function () {
		var seq = $(this).attr("seq");
		
		location.href='bbsDetail.do?seq=' + seq ;
				
	});
	
	$("#writeBbs").click(function () {
		location.href="writeBbsPage.do";
	});
});

</script>


</body>
</html>
