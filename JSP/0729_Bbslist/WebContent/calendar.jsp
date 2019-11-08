<%@page import="dao.CalendarDao"%>
<%@page import="dto.MemberDto"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="dto.CalendarDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
    
// nvl 함수
public boolean nvl(String msg){
    	return msg == null || msg.trim().equals("")?true:false;
}
    
// 날짜를 클릭하면, 그날의 일정이 모두 보여지도록 callist.jsp로 이동하는 함수
public String callist(int year, int month, int day){
	String str = "";
	
	str += String.format("<a href='%s?year=%d&month=%d&day=%d'>",
							"callist.jsp", year, month, day);
	str += String.format("%2d", day);
	str += "</a>";
	return str;
}

// 일정을 기입하기 위해서 pen 이미지를 클릭하면, calwrite.jsp 이동시키는 함수
public String showPen(int year, int month, int day){
	String str = "";
	
	String image = "<img src='image/pen.gif'>";
	
	str = String.format("<a href='%s?year=%d&month=%d&day=%d'>%s</a>",
								"calwrite.jsp", year, month, day, image);
	
	return str;
	
}

// 1 -> 01 날짜를 사용할때 자주사용함
public String two(String msg){
	return msg.trim().length() < 2?"0"+ msg.trim():msg.trim();
}

// 각 날짜별로 테이블을 생성하는 함수
public String makeTable(int year, int month, int day, List<CalendarDto> list){
	String str = "";
	
	String dates = (year + "") + two(month + "") + (day + "");
	
	str += "<table>";
	str += "<col width='98'>";
	
	for(CalendarDto dto : list){
		if(dto.getRdate().substring(0, 8).equals(dates)){
			str += "<tr bgcolor='#00ffff'> ";
			str += "<td>";
			str += "<a href='caldetail.jsp?seq=" + dto.getSeq() + "'>";
			str += "<font style='font-size:8; color:red'>";
			str += dot3(dto.getTitle());
			str += "</font>";
			str += "</a>";
			str +="</td>";
			str += "</tr>";
			
			
		}
	}
	
	str += "</table>";
	return str;
}

// 제목이 너무 길면 제목 + ...으로 처리하는 함수
public String dot3(String msg){
	String str = "";
	if(msg.trim().length() >= 5){
		str = msg.substring(0, 5);
		str += "...";
	}else{
		str = msg.trim();
	}
	return str;
}



%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calendar.jsp</title>
</head>
<body>
<h2>달력</h2>

<%
Calendar cal = Calendar.getInstance();
cal.set(Calendar.DATE, 1);

String syear = request.getParameter("year");
String smonth = request.getParameter("month");


int year = cal.get(Calendar.YEAR);

if(nvl(syear) == false ){	// 파라미터가 넘어왔을경우
	year = Integer.parseInt(syear);
}

int month = cal.get(Calendar.MONTH) + 1;
if(nvl(smonth) == false ){	// 파라미터가 넘어왔을경우
	month = Integer.parseInt(smonth);
}

if(month < 1){
	month = 12;
	year--;
}
if(month > 12){
	month = 1;
	year ++;
}

cal.set(year, month-1, 1);	// 연 월 일 셋터

// 요일
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

// << year--
String pp = String.format("<a href='%s?year=%d&month=%d'>" 
						+ "<img src='image/left.gif'></a>",
						"calendar.jsp", year-1, month);
// < month--
String p = String.format("<a href='%s?year=%d&month=%d'>" 
						+ "<img src='image/prec.gif'></a>",
						"calendar.jsp", year, month-1);
// > month++
String n = String.format("<a href='%s?year=%d&month=%d'>" 
						+ "<img src='image/next.gif'></a>",
						"calendar.jsp", year, month+1);
// >> year++
String nn = String.format("<a href='%s?year=%d&month=%d'>" 
						+ "<img src='image/last.gif'></a>",
						"calendar.jsp", year+1, month);

MemberDto user = (MemberDto)session.getAttribute("login");

CalendarDao dao = CalendarDao.getInstance();
List<CalendarDto> list = dao.getCalendarList(user.getId(), (year + "") + two(month + ""));

%>

<div align="center">

<table border="1">
<col width="100"><col width="100"><col width="100"><col width="100">
<col width="100"><col width="100"><col width="100">
	<tr height="100">
		<td colspan="7" align="center">
			<%=pp %>&nbsp;<%=p %>
			<font color="black" style="font-size: 35px">
				<%=String.format("%d년&nbsp;%d월", year, month) %>
			</font>
			<%=n %>&nbsp;<%=nn %>
		</td>
	</tr>
	<tr height="90">
		<td align="center">일</td>
		<td align="center">월</td>
		<td align="center">화</td>
		<td align="center">수</td>
		<td align="center">목</td>
		<td align="center">금</td>
		<td align="center">토</td>
	</tr>
	<tr height="100" align="left" valign="top">
		<%
		// 위쪽 빈칸
		for(int i=1; i<dayOfWeek; i++){
			%>
			<td>&nbsp;</td>
			<%
		}
		%>
		<%
		//날짜
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1; i<=lastDay; i++){
			%>
			<td>
				
				<%=callist(year, month, i) %>&nbsp;
				<%=showPen(year, month, i) %>
				<%=makeTable(year, month, i, list) %>
				<!--    -->
				
			</td>
			<%
			if((i + dayOfWeek -1) % 7 == 0 && i != lastDay){
				%>
				</tr><tr height="100" align="left" valign="top">
				<%
			}
		}
		%>
		
		<%
		//밑칸
		for(int i = 0; i < (7 - (dayOfWeek + lastDay -1) %7)%7; i++){
			%>
			<td>&nbsp;</td>
			<%
		}
		%>
	</tr>
</table>
</div>




</body>
</html>













