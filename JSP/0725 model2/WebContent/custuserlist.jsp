<%@page import="dto.CustuserDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustuserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
    <%

	
	List<CustuserDto> list = (List<CustuserDto>)request.getAttribute("custlist");
    
    
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
	<%
	
	if(list.size() == 0){
		%>
		<tr bgcolor="#f6f6f6">
			<td colspan="3" align="center">고객 리스트가 존자해지 않습니다.
			</td>
		</tr>
		<tr>
				<td height="2" bgcolor="0000ff" colspan="3"></td>
		</tr>
		<%
	}else{
//		for(int i = 0; i < list.size(); i++){
//			CustuserDto cust = list.get(i);
		for(CustuserDto cust : list){
			%>
			<tr bgcolor="f6f6f6">
				<td align="center" bgcolor="yellow">
					<input type="checkbox" name="delck" value="<%=cust.getId() %>">
					
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
			<%
	}
		}
//	}
	
	%>
	
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
			<input type="text" placeholder="ID를 입력해주세요" id="idtf">
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
	var tfid = document.getElementById(idtf);
	
	location.href='CustUserControl?command=select&id='+tfid;
	
}

</script>
</body>
</html>