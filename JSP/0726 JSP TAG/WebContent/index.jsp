<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h3>Index JSP Start</h3>
<jsp:include page="NewFile.jsp" flush="false"/>	
<!-- start 와 end 사이에 newfile.jsp가 참조되어있디. -->
<h3>index.jsp end</h3>


<!-- forward(전진하다) -->

<%-- <jsp:forward page="NewFile.jsp"/>--%>
<!-- newfile.jsp로 전진한다. newfile.jsp에서 이동명령이 없는 이상 newfile.jsp에 계속 남아 있는다. -->

<%
	MemberDto mem = new MemberDto();
	mem.setMessage("안녕");			/* 이것이 일반적인 자바 사용방식이다. */
	String msg = mem.getMessage();		
	request.setAttribute("mem", mem);
%>

<!-- 계속 말하지만 setAttribete가 안되있으면 안된다, -->
${mem.message }
<br>
<jsp:useBean id="_mem" class="dto.MemberDto"/>
<!-- id는 일단 위에이름과 충돌이 나면 안된다. 이 한줄이 위에 자바 3줄이랑 같은 의미이다.(아예 똑같다고 본다.) -->
<jsp:setProperty property="message" name="_mem" value="반갑습니다" />	<!-- setProperty(setAttribute랑 같은 실행)만 하면JSP 태그로 접근이 가능해진다. -->
<!-- property 가 변수명이 된다  _mem은 인스턴스-->

<jsp:getProperty property="message" name="_mem"/>	<!-- 이것이 겟터이다. -->

${_mem.message }








</body>
</html>