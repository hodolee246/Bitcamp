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

<form action="accountAf.do" method="post">
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" placeholder="ID" name="id" id="_id"></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" placeholder="PWD" name="pwd"></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" placeholder="Name" name="name"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" placeholder="Email" name="email"></td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="account">
		</td>
	</tr>
</table>
</form>

</body>
</html>