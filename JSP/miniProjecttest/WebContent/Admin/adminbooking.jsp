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
	width: 80%;
	height: 1300px; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
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
	padding-top: 60px;
	padding-left: 30px;
	width: 16%;
	height: 1300px;
	float: left;
	background-color: gray;
}
#adminMain{
	width: 84%;
	height: 1300px;
	float: left;
	text-align: center;
	background-color: lightgray;
}
.allMenu{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1.3em;
  	color: red;

}
#getcustomer{
	background-color: red;
	width: 65%;
	height: 1300px;
}
.cus{
	background-color: orange;
}
</style>
</head>



<body>

<jsp:include page="../header.jsp" flush="false"/>
 
<main>

<div>
	<div id="adminMenu">
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

	</div>
	
	<div id="adminMain">
	
	<h1><c:out value="${date }"></c:out></h1>
	
	<form id="frm">
	<input type="hidden" name="command" value="adminBooking">
	<select name="year" id="year">
		<c:forEach begin="2015" end="2019" step="1" varStatus="i">
		<option value="${i.index }">${i.index }</option>
		</c:forEach>
	</select>년
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
	<input type="button" id="btn1" value="검색">
	<input type="button" id="btn2" value="당일로 검색">
	</form>
	<br><br><br><br>
	
	
	<table border="1">
	<tr>
		<th></th>
		<th colspan="5">입실</th>
		<th colspan="5">퇴실</th>
	</tr>
	<tr>
		<th>방 번호</th>
		<th>고객 이름</th>
		<th>고객 아이디</th>
		<th>고객 등급</th>
		<th>어른 인원수</th>
		<th>어린이 인원수</th>
		<th>고객 아이디</th>
		<th>고객 이름</th>
		<th>고객 등급</th>
		<th>어른 인원수</th>
		<th>어린이 인원수</th>
	</tr>
	
	<c:if test="${empty list }">
	<tr>
		<td colspan="11">예약정보가 없습니다</td>
	</tr>
	</c:if>
	
	
	<%
	
	List<AdminTodayBookingDto> list = (List<AdminTodayBookingDto>)request.getAttribute("list");
	
	String date = (String)request.getAttribute("date");
	
	System.out.println("jsp 페이지의 date = " + date);
	
	System.out.println(list.toString());
	
	if (list != null && list.size() != 0 && date != null && date.equals("")){
		
	
		for(int i=0; i<list.size(); i+=2){
		%>
			<%if(list.size() == i){ 
				break;
			} %>
			<tr>
			<th class="cus"><%=list.get(i).getRoom_number() %></th>
			
			<%if(list.get(i).getVisit_date().equals(date) == false){ %>
			<td colspan="5"></td>
			<%} %>
			
			<%if(list.get(i).getVisit_date().equals(date) == true){ %>
			<td class="cus"><%=list.get(i).getName() %></td>
			<td class="cus"><%=list.get(i).getId() %></td>
			<td class="cus"><%=list.get(i).getGrade() %></td>
			<td class="cus"><%=list.get(i).getAdult_number() %></td>
			<td class="cus"><%=list.get(i).getChild_number() %></td>
			<%} %>
			
			<%-- 
			<%if(list.get(i).getLeave_date().equals(date) == false){ %>
			<td colspan="5"></td>
			<%} %>
			
			<%if(list.get(i).getLeave_date().equals(date) == true){ %>
			<td class="cus"><%=list.get(i).getName() %></td>
			<td class="cus"><%=list.get(i).getId() %></td>
			<td class="cus"><%=list.get(i).getGrade() %></td>
			<td class="cus"><%=list.get(i).getAdult_number() %></td>
			<td class="cus"><%=list.get(i).getChild_number() %></td>
			<%} %>
			 --%>
			
			<%if(list.size() == (i+1)){ 
				break;
			} %>
			
			<%-- 
			<%if(list.get(i+1).getVisit_date().equals(date) == false){ %>
			<td colspan="5"></td>
			<%} %>
			
			<%if(list.get(i+1).getVisit_date().equals(date) == true){ %>
			<td class="cus"><%=list.get(i+1).getName() %></td>
			<td class="cus"><%=list.get(i+1).getId() %></td>
			<td class="cus"><%=list.get(i+1).getGrade() %></td>
			<td class="cus"><%=list.get(i+1).getAdult_number() %></td>
			<td class="cus"><%=list.get(i+1).getChild_number() %></td>
			<%} %>
			
			 --%>
			<%if(list.get(i+1).getLeave_date().equals(date) == false){ %>
			<td colspan="5"></td>
			<%} %>
			
			<%if(list.get(i+1).getLeave_date().equals(date) == true){ %>
			<td class="cus"><%=list.get(i+1).getName() %></td>
			<td class="cus"><%=list.get(i+1).getId() %></td>
			<td class="cus"><%=list.get(i+1).getGrade() %></td>
			<td class="cus"><%=list.get(i+1).getAdult_number() %></td>
			<td class="cus"><%=list.get(i+1).getChild_number() %></td>
			<%} %>
		
		</tr>
		<%} 
	}
	%>
	
	</table>
	
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

		location.href="/miniProjecttest/booking_servlet?command=adminBooking&year="+year+"&month="+month+"&day="+day;
	});
	$("#btn2").click(function () {
		location.href="common_servlet?command=adminBooking";
	});
});
</script>

</body>
</html>