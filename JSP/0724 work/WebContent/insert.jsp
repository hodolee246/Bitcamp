<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>
</head>
<body>
<!-- jsp 에서 dto 생성후 넘길때 pageContext.forward("주소"); 로 넘긴다 -->
<form action="location">

아이디:&ensp;&ensp;<input type="text" name="id" size="10">
<br>
비밀번호:<input type="password" size="10" name="pwd">
<br><br>
취미
<br>
<input type="checkbox" name="hobby" value="sleep" checked="checked">잠자기
<input type="checkbox" name="hobby" value="sing">노래하기
<input type="checkbox" name="hobby" value="game">게임하기
<br><br>
연령대
<br>
<input type="radio" name="age" value="10대" checked="checked">10대
<input type="radio" name="age" value="20대">20대
<input type="radio" name="age" value="30대">30대
<br>
기타<br>
<textarea rows="5" cols="30" name="story"></textarea>
<br>
<input type="submit" value="전송"> 
<input type="reset" value="취소">

</form>

	

</body>
</html>