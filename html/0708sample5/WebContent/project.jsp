<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%

String name = request.getParameter("name");
String eng = request.getParameter("eng");
String lang[] = request.getParameterValues("lang");
String engta = request.getParameter("ta1");
String age = request.getParameter("age");

System.out.println("name = " + name);
System.out.println("eng = " + eng);
if(lang != null && lang.length > 0){
for(int i = 0; i < lang.length; i++){
	System.out.println(lang[i]);
}
}
System.out.println("engta = " + engta);
System.out.println("age = " + age);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>