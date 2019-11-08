<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
// DB 에서 데이터를 가져온경우
String userName = "홍길동";
int userNumber = 1001;

String json = "{\"num\":" + userNumber + ", " 
			+ "\"name\":\"" + userName + "\"}" ;


//System.out.println(json);
	
//out.println(json);
%>


<%-- <%=json %> --%>