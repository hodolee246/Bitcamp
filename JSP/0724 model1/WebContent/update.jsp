<%@page import="dao.CustuserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String address = request.getParameter("addr");
    
    CustuserDao u_dao = CustuserDao.getInstance();
    boolean b = u_dao.UpdateData(id, name, address);
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">	
	<%
	if(b){
	%>
		alert("수정되었습니다.");
		location.href='custuserlist.jsp';
	<%
	}else{
	%>
		alert("수정에 실패했습니다.");
		location.href='custuserdetail.jsp?id=<%=id%>';
	<%		
	}
	%>
</script>

</body>
</html>