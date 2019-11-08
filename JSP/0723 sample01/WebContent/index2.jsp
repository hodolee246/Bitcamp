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
	// 내장객체 : 동적할당을 하지 않고 사용할 수 있는 class
	// Servlet 에서는 request를 == HttpServletRequest 이렇게 사용한다.
	// Scriptlet 에서는 request라고 그냥 사용한다.
	
	
	String name = request.getParameter("name");
	
	out.println("name =" + name + "<br>");
	
	String age = request.getParameter("age");
	
	out.println("age = " + age + "<br>");
	// 위에 name age 모두 값이 없기에 null 값이 나온기에
	// url 에서 파라메터에 값을 넣어준다.
	// checkbox, select(multiful)
	
	String hobby[] = request.getParameterValues("hobby");
	if(hobby != null && hobby.length > 0){	
		for(int i = 0; i < hobby.length; i++){	
			// if문이 없으면 값이 없어서 for문에서 500에러가 난다.
			out.println("hobby[" + i + "] =" + hobby[i] +"<br>");
		}
	}	
%>


</body>
</html>