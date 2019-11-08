<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

<form action="" name="frmForm1" id="_frmFormSearch" method="post">

<table style="margin-left: auto; margin-right: auto; margin-top: 3px; margin-bottom: 3px">
<tr>
	<td>검색:</td>
	<td style="padding-left: 5px">
		<select id="_s_category" name="s_category">
			<option value="" selected="selected">선택</option>
			<option value="title">제목</option>
			<option value="contents">내용</option>
			<option value="writer">작성자</option>
		</select>
	</td>
	<td style="padding-left: 5px">
		<input type="text" id="_s_keyword" name="s_keyword" value="${(empty s_keyword)?'':s_keyword}">
	</td>
	<td style="padding-left: 5px">
		<span class="button blue">
			<button type="button" id="_btnSearch">검색</button>
		</span>
	</td>
</tr>
</table>

<input type="hidden" name="pageNumber" id="_pageNumber" value="${(empty pageNumber)?0:pageNumber }">

<input type="hidden" name="recordCountPerPage" id="_recordCountPerPage" value="${(empty recordCountPerPage)?0:recordCountPerPage }">

</form>

</div>

<table class="list_table" style="width: 85%">
<colgroup>
<col width="50"><col width="100"><col width="285"><col width="65">
<col width="50"><col width="50"><col width="100"><col width="50">
</colgroup>

	<thead>
		<tr>
			<th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th>
			<th>조회수</th><th>다운수</th><th>작성일</th><th>삭제</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="pds" items="${pdslist }" varStatus="vs">
			<tr class="_hover tr">
				<td>${vs.count }</td>
				<td>${pds.id }</td>
				<td style="text-align: left">
					<a href="pdsdetail.do?seq=${pds.seq }">${pds.title }</a>
				</td>
				<td>
					<input type="button" id="down_btn" name="btnDown" value="다운로드" onclick="filedowns('${pds.filename}', '${pds.seq }')">
				</td>			
				<td>${pds.readcount }</td>
				<td>${pds.downcount }</td>
				<td>
					<font size="1">${pds.regdate }</font>
				</td>
				<td>
					<img src="image/del.png" data_file_seq="${pds.seq }" class="btn_fileDelete">
				</td>
			</tr>	
		</c:forEach>
	</tbody>
</table>

<!-- 추가버튼 -->
<div id="button.wrap">
	<span class="button blue">
		<button type="button"id="_btnAdd">자료추가</button>
	</span>
</div>

<!-- 다운로드 버튼클릭시 -->
<form name="file_Down" action="fileDownload.do" method="post">
	<input type="hidden" name="filename">
	<input type="hidden" name="seq">
</form>

<!-- 페이징 -->
<div id="paging_wrap">
	<jsp:include page="/WEB-INF/views/common/paging.jsp" flush="false">
		<jsp:param name="pageNumber" value="${pageNumber }" />
		<jsp:param name="totalRecordCount" value="${totalRecordCount }" />
		<jsp:param name="pageCountPerScreen" value="${pageCountPerScreen }" />
		<jsp:param name="recordCountPerPage" value="${recordCountPerPage }" />	
	</jsp:include>
</div>


<script type="text/javascript">

var category = "${s_category}";

function goPage( pageNumber ) {
	
	$("#_pageNumber").val(pageNumber);
	$("#_frmFormSearch").attr("action", "pdslist.do").submit();	
}

$("#_btnSearch").click(function () {
	//alert("_btnSearch click");s
	$("#_pageNumber").val(0);
	$("#_frmFormSearch").attr("action", "pdslist.do").submit();	
});

$("#_s_category").val(category).prop("selected", true);

function filedowns(filename, seq){
	var doc = document.file_Down;
	doc.filename.value = filename;
	doc.seq.value = seq;
	doc.submit();
}

$("#_btnAdd").click(function () {
//	alert("btnAdd 클릭")
	location.href="pdswrite.do"
});

</script>
