<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="member" method="post">
<input type="hidden" name="type" value="login">
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="id" placeholder="ID"></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" name="pw" placeholder="PW"></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"></td>
		<td><button type="button" onclick="location.href='account.jsp'">Account</button></td>
	</tr>
</table>
</form>
</body>
</html>