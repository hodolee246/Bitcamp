<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<c:set var ="i" value="${dto }"/>
<form action="updateBbs.do">
	<input type="hidden" value="${i.seq }" id="_seq" name="seq">
<table class="list_table">
	<tr>
		<td>ID</td>
		<td colspan="2"><input type="text" readonly="readonly" value="${i.id }" name="id"></td>
	</tr>
	<tr>
		<td>Title</td>
		<td colspan="2"><input type="text" readonly="readonly" id="title" value="${i.title }" name="title" ></td>
	</tr>
	<tr>
		<td>ReadCount</td>
		<td colspan="2"><input type="text" readonly="readonly" value="${i.readcount }"></td>
	</tr>
	<tr>
		<td>Sysdate</td>
		<td colspan="2"><input type="text" readonly="readonly" value="${i.wdate }"></td>
	</tr>
	<tr>
		<td colspan="3">Content</td>
	</tr>
	<tr>
		<td colspan="3"><textarea cols="28" rows="5" id="content" readonly="readonly" name="content">${i.content }</textarea></td>
	</tr>
	<tr>
		<td><input type="submit" id="update" value="수정" disabled="disabled"></td>
		<td><input type="button" id="delete" value="삭제" disabled="disabled"></td>
		<td><input type="button" id ="back" value="뒤로가기">
		<input type="button" onclick="location.href='answerBbs1.do?seq=${i.seq}'" value="답글작성">
	</tr>
	
	<c:if test="${login.id eq i.id }">
		<script>
			
			$(document).ready(function () {
				
				$("#update").removeAttr("disabled");
				$("#delete").removeAttr("disabled");
				$("#id").removeAttr("readonly");
				$("#title").removeAttr("readonly");
				
				$("#delete").click(function () {
					location.href="deleteBbs.do?seq=" + $("#_seq").val() ;
				});
				
				$("#back").click(function () {
					history.back();
				});
				
				
			});
			
		</script>		
	</c:if>
	
</table>
</form>

</body>
</html>