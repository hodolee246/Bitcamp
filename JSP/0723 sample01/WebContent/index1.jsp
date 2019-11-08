<%@page import="sample01.UtilClass"%>
<%@page import="sample01.YouClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	Java -- 제어문, 컬렉션(list 및 map), DB접근	-> EL tag, Core Tag
	
	Java 영역 -> scriptlet
	
	JSP 목적 -> client code를 만들어 내는 것 
 				결과를 DB와 통신으로 작성한다.
 				
 	scriptlet 
 	1)선언부	선언을한다 
 	2)코드부	
 	3)value부
 				
 --%>
 
 <%!
 // 자바 영역의 선언부 전역변수, class, function선언
 	int glvar = 0;
 %>
 
 <%
 // 코드부
 glvar ++;
 out.println("glvar:" + glvar + "\n");
 // 새로고침시 코드부가 실행되어 값이 증가한다.
 // 단! static 변수가 아니기에 해당 페이지를 벗어나고 다시 실행시
 // 변수는 다시 생성된다.(값이 증가 안한다는뜻)

 int var = 0;	// 지역변수 전역변수와 다르게 해당페이지 새로고침시
 				// 새로 초기화가 된다.
 var ++;
 out.println("var =" + var);
 %>
 <br>
 <%-- value부 --%>
 glvar:<%=glvar %>
 var:<%=var %>
 
 <%!
 	class Myclass{
	 private int number;
	 private String name;
	 
	 public Myclass(int number, String name) {
		 this.number = number;
		 this.name = name;
	 }
	 public String toString(){
		 return "number:" + number +", " + "name:" + name;
	 }
 }
 
 public String func(){
	 return "func()호출";
 }
 
 %>
 <%
 
 Myclass mcls = new Myclass(1, "hgd");
 out.println("<br>");
 out.println(mcls.toString());
 out.println("<br>");
 YouClass ycls = new YouClass(2, "jin");
 out.println(ycls.toString());
 out.println("<br>");
 out.println( func() );
 
 out.println( UtilClass.func());	// java 파일에서 static function을 생성후
 									// index1에서 호출하는 것 이다.
 
 %>
</body>
</html>