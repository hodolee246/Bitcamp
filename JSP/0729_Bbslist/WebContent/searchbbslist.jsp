<%@page import="java.util.List"%>
<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String select = request.getParameter("sel");
    String text = request.getParameter("sear");
    
    
    
    BbsDao dao = BbsDao.getInstance();
    
    List<BbsDto> list = dao.GetSearch(select, text);
    
    System.out.println("listsize" + list.size());
    
    request.setAttribute("dto", list);
    
    request.getRequestDispatcher("bbslist.jsp").forward(request, response);
    
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