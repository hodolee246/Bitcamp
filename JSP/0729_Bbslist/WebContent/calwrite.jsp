<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    MemberDto mem = (MemberDto)session.getAttribute("login");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<form action="calwriteAf.jsp" method="post">
<div align="center" style="margin-top: 25px">
<table>
	<tr>
		<td>ID</td>
		<td colspan="5"><input type="text" readonly="readonly" name="id" size="28" value="<%=mem.getId()%>"></td>
	</tr>
	<tr>
		<td>Title</td>
		<td colspan="5"><input type="text" name="title" size="28"></td>
	</tr>
	<tr>
		<td>Date</td>
		<td>	<select name="year">
				<%
				for(int i=0;i<10;i++){
					%>
					<option><%=2015+i %></option>
					<%
				}
				%>
				</select>년
		</td>
		<td><select name="month">
			<%
			for(int i=1;i<13;i++){
			%>
				<option><%=i %></option>
				<%
			}
			%>
			</select> 월
		</td>
		<td><select name="day">
			<%
			for(int i=1;i<32;i++){
			%>
				<option><%=i %></option>
				<%
			}
			%>
			</select> 일
		</td>
		<td><select name="hour">
			<%
			for(int i=0;i<24;i++){
			%>
				<option><%=i %></option>
				<%
			}
			%>
			</select> 시
		</td>
		<td><select name="minute">
			<%
			for(int i=0;i<60;i++){
			%>
				<option><%=i %></option>
				<%
			}
			%>
			</select> 분
		</td>
	</tr>
	<tr>
		<td>Content</td>
	</tr>
	<tr>
		<td colspan="8"><textarea rows="15" cols="38" name="content"></textarea></td>
	</tr>
	<tr align="right">
		<td colspan="8"><button type="submit">write</button></td>
	</tr>
</table>


</div>

</form>

<script type="text/javascript">

$(document).ready(function() {
//	setDay();
	$("select[name='month']").change(setDay);
});

function setDay() {
	// 년도, 월을 통해서 마지막 날짜를 구할 수 있다.
	
	var year = $("select[name='year']").val() + "";
	var month = $("select[name='month']").val() + "";
	
	var lastday = ( new Date( year, month, 0 ) ).getDate();
	
//	alert(lastday);
	
	var str = "";
	for(i = 1; i<=lastday; i++){
		str += "<option value='" + i + "'>" + i + "</option>";
	}
	$("select[name='day']").html( str );
}

</script>
</body>
</html>