<%@page import="dto.CustuserDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustuserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
    <%

	
	List<CustuserDto> list = (List<CustuserDto>)request.getAttribute("custlist");
    request.setAttribute("list", list);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserlist.jsp</title>
</head>
<body>

<div align="center">

<form action="CustUserControl" method="post" id="frm">
	<input type="hidden" name="command" value="muldel">

<table style="width: 700">
<col width="100"><col width="300"><col width="300">

	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	<tr  bgcolor="yellow">
		<th>
			<input type="checkbox" name="alldel" onclick="deletechecks(this.checked)">
		</th>
		<th>ID</th>
		<th>Name</th>
	</tr>
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	<%-- <%
	
	if(list.size() == 0){
		%> --%>
	<c:if test="${empty list }">	
		<tr bgcolor="#f6f6f6">
			<td colspan="3" align="center">고객 리스트가 존자해지 않습니다.
			</td>
		</tr>
		<tr>
				<td height="2" bgcolor="0000ff" colspan="3"></td>
		</tr>
	</c:if>
//		for(int i = 0; i < list.size(); i++){
//			CustuserDto cust = list.get(i);
		<!-- for(CustuserDto cust : list){
			%> -->
	<c:if test="${not empty list}">		
		<c:forEach var="get" items="${list }">
			<tr bgcolor="f6f6f6">
				<td align="center" bgcolor="yellow">
					<input type="checkbox" name="delck" value=<c:out${get.id }>
					
				</td>
				<td><%=cust.getId() %></td>
				<td>
					<a href="custuserdetail.jsp?id=<%=cust.getId() %>">
						<%=cust.getName() %>
					</a>
				</td>
			
			</tr>
			
			
			<tr>
				<td height="2" bgcolor="0000ff" colspan="3"></td>
			</tr>
		</c:forEach>	
	</c:if>
		
//	}
	
	
	
	<tr>
		<td align="center" headers="1" bgcolor="#c0c0c0" colspan="3">
			<input type="submit" value="고객정보 삭제">
		</td>
	</tr>
	<tr>
		<td height="2" bgcolor="0000ff" colspan="3"></td>
	</tr>
	<tr bgcolor="f6f6f6">
		<td>
			<a href="custadd.jsp">고객정보추가</a>
		</td>
		<td>
			<select id="_sel">
				<option value="ID">ID</option>
				<option value="NAME">Name</option>
			</select>
		</td>
		<td>
			<input type="text" placeholder="Insert" id="idtf">
		</td>
		<td>
			<button type="button" onclick="selectfunc()">서치</button>
		</td>
	</tr>
	<tr>
		<td height="2" bgcolor="0000ff" colspan="3"></td>
	</tr>
</table>


</form>

</div>
<script type="text/javascript">

function deletechecks( e ) {
	var arr = document.getElementsByName("delck");
	
	for (var i = 0; i < arr.length; i++) {
		arr[i].checked = e;
	}
}

function selectfunc() {
	

	var tfid = document.getElementById("idtf").value;
	var sel = document.getElementById("_sel").value;
	location.href='CustUserControl?command=select&id='+tfid+'&sel='+sel;
	
}

</script>
</body>
</html>