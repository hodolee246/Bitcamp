<%@page import="java.util.ArrayList"%>
<%@page import="Store.StoreDto"%>
<%@page import="java.util.List"%>
<%@page import="Store.StoreDao"%>
<%@page import="Store.iStoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	List<StoreDto> list = new ArrayList<StoreDto>();
	list = (List<StoreDto>)request.getAttribute("list");
	int pCount = (int)request.getAttribute("pCount");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store Admin</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
th,td{
	border: 1px solid black;
}
a {
	color: black;
	text-decoration: none;	
}

</style>
</head>
<body>
<div align="center">
<table border="1" style="vertical-align: middle;">
<col width="10"><col width="50"><col width="250">
<col width="150"><col width="150"><col width="100">
<tr>
	<th><input type="checkbox" id="_chk"></th>
	<th>SEQ</th>
	<th>상품명</th>
	<th>분류</th>
	<th>가격</th>
	<th>재고수</th>
</tr>
<%
 if(list==null || list.size()==0){
	 %>
	 <tr>
	 	<th colspan="6">등록된 상품이 없습니다.</th>
	 </tr>
	 <%
 }
 else{
	 for(StoreDto dto : list){
		 %>
		 <tr>
		 	<th><input type="checkbox" value="<%=dto.getSeq()%>" class="check"></th>
		 	<th><%=dto.getSeq() %></th>
		 	<td><a href="../storecontrol?command=detail&seq=<%=dto.getSeq()%>"><%=dto.getProductName() %></a></td>
		 	<td><%=dto.getCode() %></td>
		 	<td><%=dto.getPrice() %></td>
		 	<td><%=dto.getStockCount() %></td>
		 </tr>
		 <%
	 }
 }
%>
<!-- 검색바 -->
<tr>
	<th colspan="6" style="border: none;">
		<select id="_findSel">
			<option selected="selected" value="상품명">상품명</option>
			<option value="분류">분류</option>
			<option value="가격">가격</option>
		</select>
		<input type="text" placeholder="검색어를 입력해주세요."style="width: 300px" id="_findText">
		<button type="button" onclick="findFunc()">검색</button>
	</th>
</tr>
<tr>
<!-- footer -->
<tr>
	<th colspan="6" style="border: none">
		<%
		int pageNum = (pCount / 11)+1;
		for(int i=1; i<pageNum+1; i++){
			%>
			<a href="./storecontrol?command=list&page=<%=i-1%>"><%=i %></a>
			<%
		}
		%>
	</th>
</tr>
<tr>
	<td colspan="6" style="border: none;">
	<button id="_add" style="float: left;" type="button">등록하기</button>
	<button id="_del" type="button" style="float: right;">삭제하기</button>
	</td>
</tr>
</table>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$("#_add").on("click",function(){ //상품등록할때
		//alert("클릭");
		location.href = "./storecontrol?command=add";
	});
	
	$("#_del").on("click",function(){
		var a = $(":checkbox:checked").length;
		var b = "";
		/* alert("a:"+a); */
		if(a == 0){
			alert("항목을 체크해주세요!")
			return;
		}
		else{
			$(".check").each(function(){
				if($(this).is(":checked")){
					 b += ($(this).val())+",";
				}
			});
			
			/* alert("b:"+b); */
			location.href = "./storecontrol?command=delete&seq="+b;
		}
	});
	
	$("#_chk").on("change",function(){
		if($(this).is(":checked")){
			/* alert("체크됨"); */
			$(".check").prop('checked',true);
		}
		else{
			$(".check").prop('checked',false);
		}
	});
});

function findFunc() {
	var sel = $("#_findSel").val();
	var fText = $("#_findText").val();
	/* alert("sel:"+sel+", fText:"+fText); */
	location.href = "./storecontrol?command=finding&select="+sel+"&fText="+fText;
}
</script>
</body>
</html>