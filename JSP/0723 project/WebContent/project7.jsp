<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
int x = 0;

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" style="border-collapse: collapse;">
<%



for(int i=0; i<x; i++){
	
	out.println("<tr>");
	
	for(int y=0; y<x; y++){
		out.println("<td>"+i + "*" + y + "=" + i*y +"</td>");
		
	}
	
	out.println("</tr>");
	
}

x++;

%>

</table>

</body>
</html>

