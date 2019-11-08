<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 고객정보 입력</h1>
<form action="addcheck.jsp">
<table>
	<tr>
		<td>ID :</td>
		<td colspan="2"><input type="text" size="15" name="id"></td>
	</tr>
	<tr>
		<td>이름 :</td>
		<td colspan="2"><input type="text" size="15" name="name"></td>
	</tr>
	<tr>
		<td>주소 :</td>
		<td colspan="2"><input type="text" size="15" name="addr"></td>
	</tr>
	<tr height="25">
	</tr>
	<tr>
		<td></td>
		<td>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</td>
		<td><input type="submit" value="추가"></td>
	</tr>
</form>
	
</table>
</body>
</html>