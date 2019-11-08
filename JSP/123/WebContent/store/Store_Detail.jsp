<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="Store.StoreDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	StoreDto dto = (StoreDto)request.getAttribute("StoreDto");
	String pImg = dto.getProductImage();
	System.out.println("img:"+pImg);
	int count = StringUtils.countMatches(pImg, ",");
	System.out.println("count:"+count);

	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
th,td{
	border: none;
}
input :text{
	width: 99%;
	height: auto;
	
}

img{
	width: 150px;
	height: 150px;
}
.filebox label { display: inline-block; padding: .5em .75em; color: #999; font-size: inherit; line-height: normal; vertical-align: middle; background-color: #fdfdfd; border: 1px solid #ebebeb; border-bottom-color: #e2e2e2; border-radius: .25em; } 
.filebox input[type="file"] { /* 파일 필드 숨기기 */ position: absolute; width: 1px; height: 1px; padding: 0; margin: -1px; overflow: hidden; clip:rect(0,0,0,0); border: 0; }

</style>
</head>
<body>
<div align="center">
<form action="./storecontrol">
	<input type="hidden" name="command" value="update">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
	<table border="1">
	<col width="70"><col width="200"><col width="200">
	<tr>
		<th colspan="3"><p>상품 Detail</p></th>
	</tr>
	<!-- 상품명 -->
	<tr> 
		<th>상품명</th>
		<td><%-- <input type="text" name="title" readonly="readonly" value="<%=dto.getProductName() %>"> --%><%=dto.getProductName() %></td>
	</tr>
	<!-- 가격 -->
	<tr>
		<th>가격</th>
		<td><%-- <input type="text" name="price" readonly="readonly" value="<%=dto.getPrice()%>"> --%><%=dto.getPrice()%></td>
	</tr>
	<!-- 재고수 -->
	<tr>
		<th>재고수</th>
		<td><%-- <input type="text" name="pCount" readonly="readonly" value="<%=dto.getStockCount()%>"> --%><%=dto.getStockCount()%></td>
	</tr>
	<!-- 상품분류 -->
	<tr>
		<th>분류</th>
		<td>
			<%=dto.getCode() %>
		</td>
	</tr>
	<!-- 상품 사이즈 -->
	<tr>
		<th>사이즈</th>
		<td>
			<%=dto.getProductSize() %>
		</td>
	</tr>
	<!-- 상품이미지 -->
	<tr>
		<th colspan="3">
			<br>
			<%
			for(int i = 0; i < 2; i++){
				%>
				<div class="filebox" style="width: 50%; height: auto; float: left;" >
					<label>이미지<%=i+1 %></label>
					<br>
					<%
					if(pImg.split(",")[i].equals("")||pImg.split(",")[i]==null){
						%>
						<img alt="" src="#">
						<%
					}
					else{
						%>
						<img alt="" src="./store_images/<%=pImg.split(",")[i] %> ">
						<%
					}
					%>	
				</div>
				<%	
			}
			%>
		</th>	
	</tr>
		<tr>
		<th colspan="3">
			<br>
			<%
			for(int i = 2; i < 4; i++){
				%>
				<div class="filebox" style="width: 50%; height: auto; float: left;" >
					<label>이미지<%=i+1 %></label>
					<br>
					<%
					if(pImg.split(",")[i].equals("")||pImg.split(",")[i]==null){
						%>
						<img alt="" src="#">
						<%
					}
					else{
						%>
						<img alt="" src="./store_images/<%=pImg.split(",")[i] %> ">
						<%
					}
					%>	
				</div>
				<%	
			}
			%>
		</th>	
	</tr>
	<!-- 상품 상세설명 -->
	<tr>
		<th><br><br>상세설명</th>
	</tr>
	<tr>
		<td colspan="3">
			<%-- <textarea rows="10" cols="70" name="content" readonly="readonly"><%=dto.getProductExplain() %></textarea> --%>
			<%=dto.getProductExplain() %>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<p>
			<input type="submit" value="수정하기" style="float: left;" id="updateBtn">
			<button type="button" style="float: right;" onclick="javascript:history.back();">뒤로가기</button>
			</p>	
		</td>
	</tr>
	</table>
</form>
</div>

</body>
</html>