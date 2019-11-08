<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String id = "abc";

String ck = request.getParameter("id");
System.out.println(ck);
String tt ="";
if(ck.equals(id)){
	tt = "사용불가능";
}else{
	tt ="사용가능";
}
	out.println(tt);
%>