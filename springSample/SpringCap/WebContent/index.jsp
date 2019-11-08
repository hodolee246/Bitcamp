<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<img src="<%=request.getContextPath() %>/captcha" id="captchaImg" alt="captcha img">
	<input type="text" placeholder="보안문자를 입력하세요" name="captcha">
	<a onclick="imgRefresh()" id="refreshBtn">새로고침</a>
	
</body>
</html>