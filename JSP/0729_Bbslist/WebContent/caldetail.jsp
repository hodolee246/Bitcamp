<%@page import="dao.CalendarDao"%>
<%@page import="dto.CalendarDto"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<%

String _seq = request.getParameter("seq");

int seq = Integer.parseInt(_seq);

MemberDto mem = (MemberDto)session.getAttribute("login");

CalendarDao dao = CalendarDao.getInstance();

CalendarDto dto = dao.CalendarDetail(seq, mem.getId());
String rdate = dto.getRdate();

String ysel = rdate.substring(0, 3);
String msel = rdate.substring(4, 5);
String dsel = rdate.substring(6, 7);
String hsel = rdate.substring(8, 9);
String minutesel = rdate.substring(10, 11);

%>
<div align="center" style="margin-top: 25px">
<form action="">
<table>
	<tr>
		<td>ID</td>
		<td colspan="5"><input type="text" readonly="readonly" name="id" size="28" value="<%=dto.getId()%>"></td>
	</tr>
	<tr>
		<td>Title</td>
		<td colspan="5"><input type="text" name="title" size="28" value="<%=dto.getTitle()%>"></td>
	</tr>
	<tr>
		<td>Date</td>
		<td>년<select name="year" id="year"> 
				
				<%
				for(int i=0;i<10;i++){
					%>
					<option><%=2015+i %></option>
					<%
				}
				%>
				</select>		
		</td>
		<td>월<select name="month" id="month"> 
			
			<%
			for(int i=1;i<13;i++){
			%>
				<option><%=i %></option>
				<%
			}
			%>
			</select>
		</td>
		<td>일<select name="day" id="day">
			
			<%
			for(int i=1;i<32;i++){
			%>
				<option><%=i %></option>
				<%
			}
			%>
			</select>
		</td>
		<td>시<select name="hour" id="hour"> 
			
			<%
			for(int i=0;i<24;i++){
			%>
				<option><%=i %></option>
				<%
			}
			%>
			</select>
		</td>
		<td>분<select name="minute" id="minute">
			
			<%
			for(int i=0;i<60;i++){
			%>
				<option><%=i %></option>
				<%
			}
			%>
			</select>
		</td>
	</tr>
	<tr>
		<td>Content</td>
	</tr>
	<tr>
		<td colspan="8"><textarea rows="15" cols="38" name="content"><%=dto.getContent() %></textarea></td>
	</tr>
	<tr align="right">
		<td colspan="8"><button type="submit">write</button></td>
	</tr>
</table>
</form>
</div>

<script type="text/javascript">

$(document).ready(function() {
//	setDay();
	$("select[name='month']").change(setDay);
	
	var sely = <%=ysel%>;
	var selm = <%=msel%>;
	var seld = <%=dsel%>;
	var selh = <%=hsel%>;
	var selmi = <%=minutesel%>;
	
	$("#select")
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