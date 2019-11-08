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
<form action="login.do">
	<table>
		<tr>
			<td colspan="2">
				<input type="text" placeholder="ID" id="idcheck" name="id">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="password" placeholder="PWD" name="pwd">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="로그인">
			</td>
			<td>
				<button type="button" onclick="account()">회원가입</button>
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
function account() {
	location.href = "accountPage.do";
}


</script>

</body>
</html>