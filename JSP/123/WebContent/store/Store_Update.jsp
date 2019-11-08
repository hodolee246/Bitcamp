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
.filebox label { display: inline-block; padding: .5em .75em; color: #999; font-size: inherit;cursor:pointer; line-height: normal; vertical-align: middle; background-color: #fdfdfd; border: 1px solid #ebebeb; border-bottom-color: #e2e2e2; border-radius: .25em; } 
.filebox input[type="file"] { /* 파일 필드 숨기기 */ position: absolute; width: 1px; height: 1px; padding: 0; margin: -1px; overflow: hidden; clip:rect(0,0,0,0); border: 0; }

</style>
</head>
<body>

<div align="center">
<form action="./storecontrol?command=updateProduct" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
	<table border="1">
	<col width="70"><col width="200"><col width="200">
	<tr>
		<th colspan="3"><p>상품 수정</p></th>
	</tr>
	<!-- 상품명 -->
	<tr> 
		<th>상품명</th>
		<td><input type="text" name="title"  value="<%=dto.getProductName() %>"></td>
	</tr>
	<!-- 가격 -->
	<tr>
		<th>가격</th>
		<td><input type="text" name="price" value="<%=dto.getPrice()%>"></td>
	</tr>
	<!-- 재고수 -->
	<tr>
		<th>재고수</th>
		<td><input type="text" name="pCount" value="<%=dto.getStockCount()%>"></td>
	</tr>
	<!-- 상품분류 -->
	<tr>
		<th>분류</th>
		<td>
			<select name="pCode">
				<option selected="selected">의류</option>
				<option>악세사리</option>
				<option>앨범</option>
				<option>기타</option>
			</select>
		</td>
	</tr>
	<!-- 상품 사이즈 -->
	<tr>
		<th>사이즈</th>
		<td>
			<select name="pSize">
				<option selected="selected">해당없음</option>
				<option>Small</option>
				<option>Medium</option>
				<option>Large</option>
			</select>
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
					<label for="product_img<%=i+1 %>">이미지<%=i+1 %></label>
					<input type="file" id="product_img<%=i+1 %>" name="fileload<%=i+1%>">
					<br>
					<%
					if(pImg.split(",")[i].equals("")||pImg.split(",")[i]==null){
						%>
						<img alt="" src="#" id="img<%=i+1%>">
						<%
					}
					else{
						%>
						<img alt="" src="./store_images/<%=pImg.split(",")[i] %> "id="img<%=i+1%>">
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
					<label for="product_img<%=i+1 %>">이미지<%=i+1 %></label>
					<input type="file" id="product_img<%=i+1 %>" name="fileload<%=i+1%>">
					<br>
					<%
					if(pImg.split(",")[i].equals("")||pImg.split(",")[i]==null){
						%>
						<img alt="" src="#" id="img<%=i+1%>">
						<%
					}
					else{
						%>
						<img alt="" src="./store_images/<%=pImg.split(",")[i] %> "id="img<%=i+1%>">
						<%
					}
					%>	
				</div>
				<%	
			}
			%>
		</th>	
	</tr>
<!-- 사진 미리보기 -->	
<script>
		<%
			for(int i=0; i<4; i++){
				%>
				function fileCheck(obj) {
					pathpoint = obj.value.lastIndexOf('.');
					filepoint = obj.value.substring(pathpoint+1,obj.length);
					filetype = filepoint.toLowerCase();
					if(filetype=='jpg'||filetype=='gif'||filetype=='png'||filetype=='jpeg'||filetype=='bmp'){
						/* 정상파일 */
					}
					else{
						alert("이미지 파일만 선택할 수 있습니다.");
						/* parentObj = obj.parentNode
						node = parentObj.replaceCh */ild(obj.cloneNode(true), obj);
						return;

					}
					if(filetype=='bmp'){
						upload = confirm('BMP 파일은 웹상에서 사용하기엔 적절하지 않습니다. \n 그래도 계속 하시겠습니까?');
						if(!upload) return;
					}
					
					
				}
				
				function readURL<%=i+1%>(input) {
					 if (input.files && input.files[0]) {
					  var reader = new FileReader();
					  
					  reader.onload = function (e) {
					   $('#img<%=i+1%>').attr('src', e.target.result);  
					  }
					  
					  reader.readAsDataURL(input.files[0]);
					  }
					}
					  
					$("#product_img<%=i+1%>").on("change",function(){
						/* alert("들어옵니당."); */
					   fileCheck(this);
					   readURL<%=i+1%>(this);
					});
							
				<%
			}
		%>
</script>

	
	<!-- 상품 상세설명 -->
	<tr>
		<th><br><br>상세설명</th>
	</tr>
	<tr>
		<td colspan="3">
			<textarea rows="10" cols="70" name="content"><%=dto.getProductExplain() %></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<p>
			<input type="submit" value="수정완료" style="float: left;" id="updateBtn">
			<button type="button" style="float: right;">뒤로가기</button>
			</p>	
		</td>
	</tr>
	</table>
</form>
</div>
<script type="text/javascript">
$(document).ready(function() {
	var titleCheck = false;
	var priceCheck = false;
	var pCountCheck = false;
	var textAreaCheck = false;
	/* var imgCheck = false; */
	
	$("input[name=title]").on("change",function(){	//상품명제한
		var pName = $(this).val();
		/* alert("pName:"+pName); */
		if(pName.length>15 || pName.length<1){
			alert("상품명은 1~15자사이로 해주세요!");
			$(this).val("");
			$(this).focus();
			titleCheck = false;
			return;
		}
		titleCheck = true;
		if(titleCheck && priceCheck && pCountCheck && textAreaCheck){
			$(":submit").attr("disabled",false);
		}

	});
	$("input[name=price]").on("change",function(){	//가격제한
		var price = $(this).val();
		/* alert("pName:"+pName); */
		if(price.length>8){
			alert("가격은 100.000.000 아래로 가능합니다.");
			$(this).val("");
			$(this).focus();
			priceCheck = false;
			return;
		}
		
		else if(/[^0123456789]/g.test(price)){
			alert("숫자만 입력 가능합니다.");
			$(this).val("");
			$(this).focus();
			priceCheck =false;
			return;
		}
		priceCheck = true;
		if(titleCheck && priceCheck && pCountCheck && textAreaCheck ){
			$(":submit").attr("disabled",false);
		}

	});
	
	$("input[name=pCount]").on("change",function(){	//재고수
		var pCount = $(this).val();
		/* alert("pName:"+pName); */
		if(pCount.length>5){
			alert("재고수는 0~99999까지 가능합니다.");
			$(this).val("");
			$(this).focus();
			pCountCheck = false;
			return;
		}
		else if(/[^0123456789]/g.test(pCount)){
			alert("숫자만 입력 가능합니다.");
			$(this).val("");
			$(this).focus();
			pCountCheck = false;
			return;
		}
		pCountCheck = true;
		if(titleCheck && priceCheck && pCountCheck && textAreaCheck ){
			$(":submit").attr("disabled",false);
		}

	});
	
	$("textarea").on("change",function(){
		var content = $(this).val();
		if(content.length<1){
			alert("내용은 꼭 기입해주세요!");
			
			$(this).val("");
			$(this).focus();
			textAreaCheck = false;
			return;
			
		}
		textAreaCheck =true;
		if(titleCheck && priceCheck && pCountCheck && textAreaCheck ){
			$(":submit").attr("disabled",false);
		}

	});
	
	

	
});
</script>
</body>
</html>