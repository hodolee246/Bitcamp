<%@page import="dto.BookingDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    System.out.println("서드 북 시작");
    BookingDto dto = (BookingDto)request.getAttribute("dto");
    
    /* 로그인 */
/*     Object ologin = session.getAttribute("login");
    CustomerDto CDto = (CustomerDto)ologin; */
    
	/* 여기서 update 실행..혹은 secondBook에서 실행 */
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

.enddiv{
	width: 100%;
	height: 700px;
	margin-top: 50px;
	margin-bottom: 70px;
}
.enddiv2{
	width: 100%;
	height: auto;
	margin-top: 150px;
	margin-bottom: 15px;
	text-align: center;	
}

.endbtn{
	text-align: center;
	width: 100%;
	height: auto;
	
}
table{
	border: 1px solid;
	border-collapse: collapse;
	position: inherit;
	margin: auto;
}

</style>

</head>

<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>
<br><br><br>
<div class="enddiv">
	<table>
		<col width="200px"><col width="330px">
		<tr align="center">
			<td><h4>객실</h4></td>
			<td><h4><%=dto.getRoom_number() %>호 객실</h4></td>		
		</tr>
		<tr align="center">
			<td><h4>인원</h4></td>
			<td><h4>어른:<%=dto.getAdult_number() %>명 아이:<%=dto.getChild_number() %>명</h4></td>		
		</tr>
		<tr align="center">
			<td><h4>기간</h4></td>
			<td><h4><%=dto.getVisit_date() %>~<%=dto.getLeave_date() %></h4></td>		
		</tr>
		<tr align="center">
			<td><h4>총 요금</h4></td>
			<td><h4><%=dto.getTotal_price() %>원</h4></td>		
		</tr>
	</table>
	
	<div class="enddiv2">
			<h1>취소규정사항</h1>
			<br>
			<h4 style="color: red">
			    상기 홈페이지 요금은 정상가에서 할인된 금액으로 중복 할인은 불가능합니다.
				예약 취소 및 변경은 체크인 하루 전 18:00(한국시간)까지 가능합니다. 예약하신	일자에 체크인 되지 않거나
				또는 위의 지정 시간 이후에 예약을 취소했을 경우에는	예약 사항에 대해 노-쇼 (No Show) 처리 되며,
				이에 따른 위약금으로 예약 첫날에 해당하는 1박 객실요금이 청구되오니 유의하시기 바랍니다.</h4>
	</div>
	<div class="endbtn">
		<button id="btnhome" class="btn btn-dark navbar-btn">홈으로</button>
		<button id="btnmypage" class="btn btn-dark navbar-btn">마이페이지</button>
		
	</div>
</div>
</main>

<jsp:include page="../footer.jsp" flush="false"/>

<script type="text/javascript">

$(function () {
	$("#btnhome").click(function() {
		location.href="/miniProject/booking_servlet?command=home";
	});
	$("#btnmypage").click(function() {
		location.href="/miniProject/booking_servlet?command=mypage";
	});
})

</script>

</body>
</html>