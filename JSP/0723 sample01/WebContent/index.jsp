<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%
String str = "hello JSP";
%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>

	<h1>hello JSP</h1>
	
	<!--HTML 주석문-->
<%--JSP 주석문--%>
<%-- 
JSP: Java Server Pages
웹서버 (톰캣)
server(web)를 통해서 client form을 만들어내는 코드 
server에서 전송을  해줄 수 있는 문서를 만드는 역할
(우리가 이전까지 배운 부분은 client쪽이었기때문에 서버없이도 가능했다)

웹브라우저를 갈때는 언제나 서버를 건너서 가야하는 존재
서버한테 요청하는 url
http://localhost:8090/0723_sample01/index.jsp
http://192.168.0.64:8090/0723_sample01/index.jsp
      IP주소   PORT넘버    프로젝트 명     jsp

우리가 접근을 할때는 url을 사용한다는 것이 중요 포인트

서버에서는 코드를 해석해서 그 것을 response로 던져주는 것
그 건져주는 코드로 클라이언트의 웹브라우저랑 만나는 순간 client코드로 바뀌게 되는 것이다.


192.168.0.64

 --%>

<h1>HELLO JSP</h1>
<!-- <img alt="" src="e:\\tmp\\img.png">
로컬드라이브의 경우 서버가 아니기 때문에 이건 나오지 않음
웹에 올라와 있는 이미지에 있는건지, 서브코드안에 리소스로서 들어와있는지에 의해 불러올 수 있다
이런 경우 어떻게 들고오는게 좋을까요
자바는 이경우가 가능하기 때문에 자바를 이용해서 가져오도록 해야함
자바가 거의 서버코드로서 보는게 맞다
서버하고 연관이 있구나 이렇게 생각할 것
우리는 web container라는 창고에서 일하는 직원이다
-->

<%
//java의 영역
//script + applet :scriptlet
System.out.println("console출력");

/*
 servlet = java(html)
 JSP = html(java) html바탕에 자바를 품고 있는 느낌
 
 내장객체 - 객체에는 여러 종류가 있는데 내장 객체의 경우 간단히 얘기하면 new를 하지 않고 바로 사용할 수 있는 object
생성하지않고 바로 접근해서 사용할 수 있는 것

*/
out.println("내장 객체 out을 통해서 출력");
//웹에 내보내는 것 : html에다가 그냥 적는거랑 동일함
out.println("<h2>내장 객체 out을 통해서 출력</h2>");
//out은 객체, 클래스인데 따로 생성안하고 바로 할 수 있는 것 리퀘스트와 리스폰스도 이 내장객체에 소속되어 있다.
%>
	System.out.println("console 출력");
	
	out.println("내장 객체 out을통해서 출력 ");
		// 콘솔에 출력되는게 아니라 out이라는 내장객체를 통해서
		// <body> 안에 입력한 것이랑 똑같은 결과값을 보여준다.
	
	out.println("<h1>내장 객체 out을통해서 출력 </h1>");
		// 내장객체에서도 태그를 넣어서 사용이 가능하다.
	%>
	
	<%
	out.println("<h3> str = " + str + "</h3>");
		// 위에서 선언한 str를 h3태그안에 넣어준다.
	%>
	
	<h3>str = <%=str %></h3>
 	<!-- h3태그안에 자바영역을 불러서 str을 호출한다. -->
 	
 	<input type="text" size="15" value="<%=str %>">
 	<%
 	for(int i = 0; i < 5; i++){
 	%>
 	<p>hello ptag <%=i %></p>
 	<%
 	}
 	%>
 	
 	<%
 	for(int i = 0; i < 5; i++){
 		out.println("<p>hello p tag" + i + "</p>");
 	}
 	%>
 	
 	<p id="demo">p demo</p>
 	
 	<script type="text/javascript">
 	
 	document.getElementById("demo").innerHTML = "change p tag";
 	/* javascript 사용하는 방법은 동일하다 */
 	
 	</script>
 	</body>
</html>