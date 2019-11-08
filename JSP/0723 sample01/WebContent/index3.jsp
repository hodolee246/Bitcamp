<%@page import="sample01.YouClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
YouClass cls = new YouClass(4, "인우");

// request.setAttribute("you", cls);	// 이사갈준비
// pageContext.forward("index4.jsp");	// 이사

// session
request.getSession().setAttribute("you", cls);
// 세션은 서버의 있는 저장영역에 저장한다는 느낌이다.
// 세션은 전송보다는 서버의 저장영역에 저장하는 형식으로 다른 파일에서
// 데이터를 꺼낼때 저장된 값을 꺼내는 것이다 그렇기에 실제 전송에는
// 전송하는 부분이 제한이 되는경우 세션을 이용하여 보내는 경우를 제외하고
// 왠만하면은 전송목적으로 세션은 사용하지 않는다.


// request.getRequestDispatcher("index4.jsp").forward(request, response);
// 이 코드도 이동하는 코드이다 위에 포워드랑 똑같음

// response.sendRedirect("index4.jsp?number=5&name=abc");
%>


</body>
</html>