<%@page import="dto.AdminTodayBookingDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jar 파일 두개 추가, 링크 추가 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="list" value="${list}"></c:set>
<c:set var="date" value="${date }"></c:set>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript" src="../js/jquery.min.js"></script> 
<link rel="stylesheet" href="../css/bootstrap.css">

<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean" rel="stylesheet">

<style type="text/css">
main{
	overflow: inherit;
	width: 80%;
	height: auto; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}
ul{
   list-style:none;
   padding-left:0px;
}
.menu > li{
	list-style:none;
	color: #eee;
}
.menu > li > a{

	color: #eee;
}  
.menu > li > a:hover{
	list-style:none;
	color: black;
}
#adminMenu{
	overflow: inherit;
	padding-top: 60px;
	padding-left: 30px;
	width: 16%;
	height: auto;
	float: left;
	background-color: gray;
}
#adminMain{
	overflow: inherit;
	width: 84%;
	height: auto;
	float: left;
	text-align: center;
	padding-left: 10px;
	/* background-color: lightgray; */
	padding-bottom: 150px;
}
.allMenu{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1.3em;
  	color: red;

}
#getcustomer{
	overflow: inherit;
	background-color: red;
	width: 65%;
	height: auto;
}
.cus{
	/* background-color: orange; */
}

.tableWrapper{
	background-color: red;
}
.tablechild1{
	/* background-color: orange; */
	float: left;
}
.tablechild2{
	/* background-color: blue; */
	float: right;
}

.tbEnter, .tbLeave{
	font-family: 'Noto Sans KR', sans-serif;"
}
.tbEnter th, .tbLeave th{
	background: #D6B78D;
	text-align: center;
	color: white;
	padding: 20px;
}
.tbEnter td, .tbLeave td{
	padding: 10px;
}
.tbEnter th, .tbEnter td, .tbLeave th, .tbLeave td{
	font-size: 14px;
	border-bottom: 1px solid #D6B78D;
}
</style>
</head>



<body>

<jsp:include page="../header.jsp" flush="false"/>
 
<main>

<div>
	<div id="adminMenu">
	<!-- 
		<ul class="menu">
			<li><a href="/miniProject/admin_servlet?command=adminChart" class="fatag">메인으로</a></li><br>
			<li><a href="/miniProject/customer_servlet?command=adminCustomer" class="fatag">회원 관리</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=roomadmin" class="fatag">객실정보 관리</a><br>
				<ul class="menu"><br>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 등록</a></li><br>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 수정</a></li><br>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 삭제</a></li><br>
				</ul>
			</li>
			<li><a href="/miniProject/booking_servlet?command=adminBooking" class="fatag">예약 관리</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=qnalist&choice=&str=&pageNum=1" class="fatag">고객의소리 관리</a></li><br>
		</ul>
 -->
 	<jsp:include page="../adminMenu.jsp" flush="false"/>
	</div>
	
	<div id="adminMain">
	
	<b style="font-family: 'Noto Sans KR', sans-serif; font-size: 70px">예약관리</b>
	<h1>2019<c:out value="${date }"></c:out>&nbsp;&nbsp;검색 결과</h1>
	
	<form id="frm">
	<input type="hidden" name="command" value="adminBooking">
	2019년
	<select name="month" id="month">
		<c:forEach begin="1" end="12" step="1" varStatus="i">
		<option value="${i.index }">${i.index }</option>
		</c:forEach>
	</select>월
	<select name="day" id="day">
		<c:forEach begin="1" end="31" step="1" varStatus="i">
		<option value="${i.index }">${i.index }</option>
		</c:forEach>
	</select>일
	
	<input type="hidden" name="command" value="adminCustomer">
	<input type="button" id="btn1" value="검색">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" id="btn2" value="당일로 검색">
	</form>
	<br><br><br><br>
	
	
	
	
	
	<div class="tableWrapper">
	<div class="tablechild1">
	
		<table class="tbEnter">
			<tr>
				<th colspan="6" style="font-size: 40px">입실</th>
			</tr>
			<tr>
				<th>방 번호</th>
				<th>고객 이름</th>
				<th>고객 아이디</th>
				<th>고객 등급</th>
				<th>어른 인원수</th>
				<th>어린이 인원수</th>
			</tr>
			<%
			
			List<AdminTodayBookingDto> visitlist = (List<AdminTodayBookingDto>)request.getAttribute("visitlist");
			
			String date = (String)request.getAttribute("date");
			
			System.out.println("jsp 페이지의 Enterdate = " + date);
			
			//System.out.println(list.toString());
			if (visitlist == null || visitlist.size() == 0){
			%>
			<td colspan="6">입실이 없습니다</td>
			<%
			}
			
			if (visitlist != null && visitlist.size() != 0){
				System.out.println("jsp 페이지의 조건문 통과 ");
			
				for(int i=0; i<visitlist.size(); i++){
					boolean b = true;
				%>
					<tr>
					<th class="cus"><%=visitlist.get(i).getRoom_number() %></th>
					
					<td class="cus"><%=visitlist.get(i).getName() %></td>
					<td class="cus"><%=visitlist.get(i).getId() %></td>
					<td class="cus"><%=visitlist.get(i).getGrade() %></td>
					<td class="cus"><%=visitlist.get(i).getAdult_number() %></td>
					<td class="cus"><%=visitlist.get(i).getChild_number() %></td>
					
				</tr>
				<%} 
			}
			%>
		</table>
	
	</div>
	<div class="tablechild2">
		<table class="tbLeave">
			<tr>
				<th colspan="6" style="font-size: 40px">퇴실</th>
			</tr>
			<tr>
				<th>방 번호</th>
				<th>고객 이름</th>
				<th>고객 아이디</th>
				<th>고객 등급</th>
				<th>어른 인원수</th>
				<th>어린이 인원수</th>
			</tr>
			
			
			<%			
			List<AdminTodayBookingDto> leavelist = (List<AdminTodayBookingDto>)request.getAttribute("leavelist");
			
			System.out.println("jsp 페이지의 Leavedate = " + date);
			System.out.println("list size" + leavelist.size());
			
			//System.out.println(list.toString());
			if (leavelist == null || leavelist.size() == 0){
			%>
			<td colspan="6">퇴실이 없습니다</td>
			<%
			}
			
			if (leavelist != null && leavelist.size() != 0){
				System.out.println("jsp 페이지의 조건문 통과 ");
			
				for(int i=0; i<leavelist.size(); i++){
					boolean b = true;
				%>
					<tr>
					<th class="cus"><%=leavelist.get(i).getRoom_number() %></th>
					
					<td class="cus"><%=leavelist.get(i).getName() %></td>
					<td class="cus"><%=leavelist.get(i).getId() %></td>
					<td class="cus"><%=leavelist.get(i).getGrade() %></td>
					<td class="cus"><%=leavelist.get(i).getAdult_number() %></td>
					<td class="cus"><%=leavelist.get(i).getChild_number() %></td>
					
				</tr>
				<%} 
			}
			%>
		</table>
	</div>
	
	
	
	
	
	<!-- 두개의 테이블의 감싸는 .tableWrapper div 태그를 닫는다 -->
	</div>
		
	
	
	
	
	<!-- adminMain 끝나는 태그 -->
	</div>


</div>

</main>








<jsp:include page="../footer.jsp" flush="false"/>

<script type="text/javascript">
$(document).ready(function () {
	$("#btn1").click(function () {
		year = $("#year").val();
		
		if($("#month").val().length < 2){
			month = "0"+$("#month").val();
		}
		if($("#day").val().length < 2){
			day = "0"+$("#day").val();
		}

		location.href="/miniProject/booking_servlet?command=adminBooking&month="+month+"&day="+day;
	});
	$("#btn2").click(function () {
		location.href="booking_servlet?command=adminBooking";
	});
});
</script>

</body>
</html>