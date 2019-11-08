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
<form action="pdsUpdate.do" method="post" enctype="multipart/form-data">
	<input type="hidden" value="${i.seq }" id="_seq" name="seq">
	<input type="hidden" name="id" value="${i.id }">
<table class="list_table">
	<tr>
		<th>작성자</th>
		<th>작성일</th>
		<th>다운수</th>
		<th>조회수</th>
	</tr>
	<tr>
		<td>${i.id }</td>
		<td>${i.regdate }</td>
		<td>${i.downcount }</td>
		<td>${i.readcount }</td>
	</tr>	
	<tr>
		<th colspan="1">제목</th>
		<td colspan="3"><input type="text" readonly="readonly" id="title" value="${i.title }" name="title" ></td>
	</tr>
	<tr>
		<td>
			<input type="button" id="down_btn" name="btnDown" value="다운로드" onclick="filedowns('${i.filename}', '${i.seq }')" readonly="readonly">
			<input type="file" name="fileload" id="_file" readonly="readonly">
		</td>
	</tr>
	<tr>
		<th colspan="1">내용</th>
		<td colspan="3"><input type="text" readonly="readonly" id="content" value="${i.content }" name="content"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" id="update" value="수정" disabled="disabled"></td>
		<td colspan="2"><input type="button" id="delete" value="삭제" disabled="disabled"></td>
	</tr>
		
		
</table>
</form>

<!-- 다운로드 버튼클릭시 -->
<form name="file_Down" action="fileDownload.do" method="post">
	<input type="hidden" name="filename">
	<input type="hidden" name="seq">
</form>

<script>


function filedowns(filename, seq){
	var doc = document.file_Down;
	doc.filename.value = filename;
	doc.seq.value = seq;
	doc.submit();
}

	<c:if test="${login.id eq i.id }">
			
			$(document).ready(function () {
				
				$("#update").removeAttr("disabled");
				$("#delete").removeAttr("disabled");
				$("#_id").removeAttr("readonly");
				$("#title").removeAttr("readonly");
				$("#content").removeAttr("readonly")
				$("#_file").removeAttr("readonly")
				
				
				$("#delete").click(function () {
					location.href="pdsDelete.do?seq=" + $("#_seq").val() ;
				});
	
			});
			
	</c:if>
	
		</script>		
	
</body>
</html>