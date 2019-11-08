<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="project9insertAf.jsp">
아이디&ensp;&ensp;<input type="text" size="20" name="id">
<br>
패스워드<input type="password" size="20" name="pwd">
<br>
<br>
취미
<br>
<input type="checkbox" name="hobby" value="sleep">잠자기
<input type="checkbox" name="hobby" value="sing">노래하기
<input type="checkbox" name="hobby" value="game">게임하기
<br>
<br>
연령대
<input type="radio" name="age" value="10">10대
<input type="radio" name="age" value="20">20대
<input type="radio" name="age" value="30">30대
<input type="radio" name="age" value="40">40대
<input type="radio" name="age" value="50">50대
<input type="radio" name="age" value="60">60대이상
<br>
<br>
기타하고싶은말
<br>
<textarea rows="10" cols="50" name="ahhh"></textarea>
<br>
<input type="submit">
</form>
</body>
</html>