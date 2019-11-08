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
<div>
<form action="accountAf.jsp" method="post">
<input type="hidden" name="ck" value="ac">
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" placeholder="ID" name="id" id="_id"></td>
		<td><button type="button" onclick="func()">Check</button></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" placeholder="PW" name="PW"></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" placeholder="Name" name="name"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" placeholder="Email" name="eamil"></td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="account">
		</td>
	</tr>
</table>
</form>

</div>
<script type="text/javascript">

$(function () {
	$("button").click(function () {
		var id = $("#_id").val()
		
		location.href ='accountidAf.jsp?id=' + id;
		
	});
});


</script>

</body>
</html>