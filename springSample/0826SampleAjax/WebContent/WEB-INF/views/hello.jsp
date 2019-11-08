<%@page import="bit.com.a.model.myClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<h2>hello.jsp</h2>

<%-- 방법1 스크립트릿 --%>
<%
myClass cls = (myClass)request.getAttribute("cls");
%>
<br>
number:<%=cls.getNumber() %>
<br>
name:<%=cls.getName() %>
<br><br>

<!-- 방법1-2 EL tag 사용 -->
number:${cls.number }
<br>
name:${cls.name }
<br><br>

<!-- 방법2 -->
<form action="inputData.do">
번호:<input type="text" name="number">
<br>
이름:<input type="text" name="name">
<br>
<button type="submit">전송</button>
</form>

<br><br>
<!-- 방법3 -->
<form action="move.do">
<button type="submit">move</button>
</form>
<br><br>

<!-- 방법4 ajax -->
<form method="get">
<input type="text" id="checkid" placeholder="ID">
<button type="button" id="_check" onclick="idcheck()">체크</button>
</form>

<script type="text/javascript">
function idcheck() {
//	alert("idcheck");
	$.ajax({
		url:"idcheck.do",					// 넘기는 단어
		type:"get",							// 방식
		data:"id=" + $("#checkid").val(),	// 넘길 데이터
		success:function(data){
		//	alert("success");
			alert(data);
		},
		error:function(req, status, error){
			alert("error");
		}
	});
}
</script>
<br><br>

<!-- 방법5 ajax -->

<form method="post">
<input type="text" placeholder="name" id="_name"><br>
<input type="text" placeholder="phone" id="_phone"><br>
<input type="text" placeholder="email" id="_email"><br>
<input type="text" placeholder="birthday" id="_birth"><br>
<button type="button" id="account">가입</button>
</form>

<script type="text/javascript">
$(document).ready(function () {
	
	$("#account").click(function() {
//		alert("account btn click");

		var mydata = {
				name:$("#_name").val(),
				phone:$("#_phone").val(),
				email:$("#_email").val(),
				birthday:$("#_birth").val()
				
		}
		
		$.ajax({
			url:"account.do",
			data:mydata,
			type:'post',
			datatype:'json',				// 보내는 데이터 
			async:true,
			success:function(resp){
//				alert("account success");	// 받는 데이터(Map)
				alert(resp.msg);			// 넘어오는 값.key
				alert(resp.data);
			},
			error:function(){
				alert("account error");
			}
		});
		
	});
	
});
</script>
<br><br>

<!-- 6번째 예제... -->

<input type="text" placeholder="name" id="_name1"><br>
<input type="text" placeholder="phone" id="_phone1"><br>
<input type="text" placeholder="email" id="_email1"><br>
<input type="text" placeholder="birthday" id="_birth1"><br>
<button type="button" id="account1">가입</button>

<script type="text/javascript">
$(document).ready(function () {
	
	$("#account1").on("click", function () {
//		alert("account1 btn click");
		
		var data = {};	// json 배열 초기화
		
		data["name"] = $("#_name1").val();
		data["phone"] = $("#_phone1").val();
		data["email"] = $("#_email1").val();
		
		var birth = $("#_birth1").val();
		data["birth"] = birth.replace(/-/g, "");	// 2019-08-26 -> 20190826

		alert(data["birth"]);
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'updateUser.do',
			type:'post',
			data:JSON.stringify(data),	// 보내는 부분 -> Map
			success:function(resp){		// 받는 부분 -> json
				alert("success");
			},
			error:function(){
				alert("error");
			}
			
		});
		
	});
	
});
</script>

</body>
</html>