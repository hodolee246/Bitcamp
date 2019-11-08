<%@page import="java.util.Date"%>
<%@page import="dto.BookingDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.ParseException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    System.out.println("서드 북 시작");
    BookingDto dto = (BookingDto)request.getAttribute("dto");
    
    /* 로그인 */
/*     Object ologin = session.getAttribute("login");
    CustomerDto CDto = (CustomerDto)ologin; */
    
	/* 여기서 update 실행..혹은 secondBook에서 실행 */
	

	int stayday = 0;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	try {
		Date visitD = format.parse(dto.getVisit_date());
		Date LeaveD = format.parse(dto.getLeave_date());
		System.out.println("트라이");
		
		long calDate = LeaveD.getTime() - visitD.getTime();
		
		long calD = calDate / (24*60*60*1000);
		
		calD = Math.abs(calD);
		System.out.println("결과" + calD);
		stayday = (int)calD;
	} catch (ParseException e) {

		e.printStackTrace();
	}
	
	
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

main{
	width: 70%;
	height: 800px; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}

div{
	margin-top: 20px;
	width: 80%;
}
.bookingtable{
	border: 1px solid;
	border-collapse: collapse;
}
.bookingtabletd{
	border: 1px solid;
	border-collapse: collapse;
}
</style>

</head>

<body>

<jsp:include page="header.jsp" flush="false"/>

<main>
<br><br><br><br><br>

<div align="center">
	<h2>예약정보</h2>
	<table class="bookingtable">
		<col width="400px"><col width="200px"><col width="400px">
		<tr align="center">
			<td class="bookingtabletd"><h4 align="center">객실</h4></td>
			<td class="bookingtabletd"><h4 align="center">인원/요금</h4></td>
			<td class="bookingtabletd"><h4 align="center">기간</h4></td>
			
		</tr>
		<tr height="200px;" align="center">
			<td class="bookingtabletd"><img src="logo.png"></td>
			<td class="bookingtabletd">성인<%=dto.getAdult_number() %>명, 아이<%=dto.getChild_number() %>명<br><br>총요금 : <%=dto.getTotal_price() %></td>
			<td class="bookingtabletd"><%=dto.getVisit_date() %> ~ <%=dto.getLeave_date() %> <br><br>
			(총 <%=stayday %>일)</td>
		</tr>
	
	</table>
	<br><br><br>
	
	
	<button type="button" id="home" class="btn btn-warning">홈</button>		&ensp;&ensp;&ensp;&ensp;
	<button type="button" id="mypage" class="btn btn-warning">마이페이지</button>	&ensp;&ensp;&ensp;&ensp;
	<button type="button" id="nearby" class="btn btn-warning">주변관광지</button>	&ensp;&ensp;&ensp;&ensp;



<%-- <table>
	<tr>
		<td colspan="2" align="center">회원정보</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=CDto.getId() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=CDto.getName() %></td>
	</tr>
	<tr>
		<td>휴대전화</td>
		<td><%=CDto.getPhone() %></td>
	</tr>
</table> --%>

</div>
</main>

<jsp:include page="footer.jsp" flush="false"/>

<script type="text/javascript">

$(function () {
	$("#mypage").click(function() {
		location.href="/miniProject/booking_servlet?command=mypage";
	});
	$("#home").click(function() {
		location.href="/miniProject/booking_servlet?command=home";
	});
	$("#nearby").click(function() {
		location.href="/miniProject/booking_servlet?command=nearby";
		
	});
});

</script>

</body>
</html>