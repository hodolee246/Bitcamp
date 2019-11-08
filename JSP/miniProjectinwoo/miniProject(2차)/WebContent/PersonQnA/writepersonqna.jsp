<%@page import="dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="./js/jquery.min.js"></script>
 
<link rel="stylesheet" href="./css/bootstrap.css">

<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean" rel="stylesheet">


<style type="text/css">

main{
	width: 70%;
	height: 800px; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}

#totalpage{
	font-family: 'Noto Sans KR', sans-serif;

}

.tb{
	margin-top: 20px;
	margin-bottom: 110px;
	
    border-collapse: collapse;
    font-family: 'Noto Sans KR', sans-serif;
}

input, textarea, select{
	border: none;
	padding-left: 15px;
	padding-right: 15px;
	background-color: #f1f1f1;
}

textarea{
	padding-top: 15px;
	padding-bottom: 15px;
}

.td1, #choice{
	width: 252px;
	height: 35px;
}

.td2{
	width: 504px;
	height: 35px;
}


.td1, .td2, .td3{
	margin-bottom: 10px;
}

.td4{
	text-align: center;
}

#addBtn, #cancelBtn{
	margin: 10px;
	width: 160px;
	height: 40px;
	border-color: black;
	border-radius: inherit;
	background-color: black;
}

#addBtn:hover, #cancelBtn:hover{
	border-color: #5E2C00;
    background-color: #5E2C00;
    color: #ffffff;
}



</style>

</head>

<body>

<%
CustomerDto user = (CustomerDto)session.getAttribute("login");

if(user == null){
	System.out.println("CustomerDto user == null");
	response.sendRedirect("/miniProject/customer_servlet?command=loginpage");
	return;
	//request.getRequestDispatcher("common_servlet?command=loginpage").forward(request, response); // 이렇게 파라메타 붙여주는식으로는 못 쓴다.
}

request.setAttribute("_user", user);
%>

<jsp:include page="../header.jsp" flush="false"/>

<main>
<div id="totalpage" align="center">

<h1>고객의 소리</h1><br>
<h4>호텔 이용과 관련된 궁금한 사항이 있으시면 문의를 남겨주세요.</h4>
<h4>가능한 빨리 답변을 드리겠습니다.</h4><br>
<h3>상담내용</h3>


<form id="frm">
<table class="tb">
<tr>
	<th><h4>ID</h4></th>
</tr>
<tr>
	<td><input type="text" class="td1" value="<%=user.getId()%>" readonly="readonly"></td>
<tr>

<tr>
	<th><h4>CATEGORY</h4></th>
</tr>
<tr>	
	<td>
		<select id="choice" class="td3">
			<option value="질문" selected="selected">질문</option>
			<option value="제안">제안</option>
			<option value="칭찬">칭찬</option>
			<option value="불만">불만</option>
			<option value="기타">기타</option>
		</select>
	</td>
</tr>

<tr>
	<th><h4>TITLE</h4></th>
</tr>
<tr>
	<td><input type="text" id="title" class="td2"></td>
</tr>

<tr>
	<th class="th1"><h4>CONTENT</h4></th>
</tr>

<tr>
	<td><textarea rows="10" cols="65" id="content" class="td3"></textarea></td>
</tr>

<tr>
	<td class="td4">
		<button type="button" id="addBtn" class="btn btn-success">등록</button>
		<button type="button" id="cancelBtn" class="btn btn-success">취소</button>
	</td>
</tr>

</table>
</form>

</div>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#addBtn").click(function() {
		var id = "<%=user.getId()%>";
		var choice = $("#choice").val();
		var title = $("#title").val();
		var content = $("#content").val();
		
	//	alert("id:" + id + " choice:" + choice + " title:" + title + " content:" + content);
		
		if(title == "" || content == ""){
			alert("모두 입력해주십시오.");
			return;
		}
		
		location.href = "personqna_servlet?command=addqna&id=" + id + "&choice=" + choice + "&title=" + title + "&content=" + content;
		
	});
	
	$("#cancelBtn").click(function() {
		
		location.href = "customer_servlet?command=mainpage";
		
	});
	
});





</script>







</main>

<jsp:include page="../footer.jsp" flush="false"/>



</body>
</html>