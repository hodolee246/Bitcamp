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
<form action="loginAf.jsp" method="post">
<input type="hidden" name="ck" value="lo">
<h2>Login</h2>
<table>

	<tr>
		<td>ID</td>
		<td colspan="3"><input type="text" placeholder="ID" name="id"></td>
	</tr>
	<tr>
		<td>PW</td>
		<td colspan="3"><input type="text" placeholder="PW" name="pw"></td>
	</tr>	
	<tr>
		<td colspan="2"><input type="submit" value="login"></td>
		<td colspan="2"><button type="button" onclick="location.href='account.jsp'">Account</button></td>

	</tr>

</table>
</form>
</div>





</body>
</html>