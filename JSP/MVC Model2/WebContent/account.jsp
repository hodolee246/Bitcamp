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
<form action="member" method="post">
<input type="hidden" name="type" value="account">
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="id" placeholder="ID" id="check"></td>
		<td><button type="button">Check</button></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" name="pw" placeholder="PW"></td>
		<td></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name="name" placeholder="NAME"></td>
		<td></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email" placeholder="EMAIL"></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="Account"></td>
	</tr>
</table>
</form>
<script type="text/javascript">


$(function () {
	$("button").click(function () {
		var id = $("#check").val()
		
		location.href ='member?type=check&id=' + id;
		
		<%
    	boolean b = (boolean)request.getAttribute("result");
    %>
		<%
		if(b){
			
	%>		

		alert("중복된 아이디 입니다.");
	<%
		
		}else{
	%>
		alert("사용해도 좋습니다.");
	<%
		}
	%>
	});
});

</script>
</body>
</html>