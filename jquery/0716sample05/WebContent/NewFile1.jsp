<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String name = request.getParameter("name");
String address = request.getParameter("address");
int age = Integer.parseInt( request.getParameter("age"));
System.out.println(name);
System.out.println(age);
System.out.println(address);

%>