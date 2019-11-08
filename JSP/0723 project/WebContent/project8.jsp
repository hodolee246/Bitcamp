<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%!
	int count = 0;
%>

<%
 count++;
Cookie c = new Cookie("v", count +"");
c.setMaxAge(60*60);
response.addCookie(c); 
%>
<%
Cookie cok[] = request.getCookies();

if(cok != null){
	for(int i=0; i < cok.length; i++){
		c = cok[i];
%>	count = <%=c.getValue() %>
<%
	}
}
%> --%>
<%!
	int count = 0;
%>
<%
count ++;
request.getSession().setAttribute("v", count);
%>
<%
count = (int)request.getSession().getAttribute("v");
%>
<h1>JSP 실습</h1>
<br><br>

count = <%=count %>



<br><br>
<%
int i;
if(session.getAttribute("count") != null){
	i = (int)session.getAttribute("count");
}else{
	i = 0;
}
i++;

%>
방문횟수:<input type="text" value="<%=i %>" size="5">

<%
session.setAttribute("count", new Integer(i));

session.invalidate();
%>

</body>
</html>















