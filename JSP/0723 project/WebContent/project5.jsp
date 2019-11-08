
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!

	class color{
	
	
	public color(){
		
	}
	
}

public String red(){
	return "red";
}
public String blue(){
	return "blue";
}
public String green(){
	return "green";
}

public String setColorHTML(String str, String color){
	return "<font color=\"" + color + "\">" + str + "</font>";
}

%>

<%
String redText = setColorHTML("빨간 텍스트", "#ff0000");
String greenText = setColorHTML("녹색 텍스트", "#00ff00");
String blueText = setColorHTML("파란 텍스트", "#0000ff");

%>

--메소드를 사용하는 예--
<br><br>

<p style="color: <%=red()%>">빨간색 텍스트</p>
<p style="color: <%=blue()%>">파란색 텍스트</p>
<p style="color: <%=green()%>">녹색 텍스트</p>

<br>
<%=redText %><br>
<%=greenText %><br>
<%=blueText %><br>
</body>
</html>