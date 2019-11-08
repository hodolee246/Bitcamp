<%@page import="java.util.List"%>
<%@page import="dto.BookingDto"%>
<%@page import="dto.RoomDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%

/* 로그인 */
/* Object ologin = session.getAttribute("login");
CustomerDto CDto = (CustomerDto)ologin; */


BookingDto BDto = (BookingDto)request.getAttribute("dto");
List<RoomDto> list = (List<RoomDto>)request.getAttribute("All");
System.out.println(list.size());


%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

main{
	width: 70%;
	height: 4000px; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
	align-content: center;
}
div{
	width: 80%;
}

tr{

	height: 75px;
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
<br><br><br>

<div align="center">

<table class="bookingtable">
	<col width="150px;"><col width="250px"><col width="150"><col width="150">
	<tr>
		<td colspan="3" style="text-align: center" align="center">
			선택한 일정<br>
			<%=BDto.getVisit_date()%> ~ <%=BDto.getLeave_date() %>
		</td>
	</tr>
	<%
	if(list == null || list.size()==0){	// 리스트가 없는경우
	%>	
		<tr>
			<td>이용 가능한 객실이 없습니다.</td>
		</tr>
	<%	
	}else{	// 리스트가 있는경우
	
		for(int i=0; i<list.size();i++){
			RoomDto RDto = list.get(i);
			System.out.println(RDto.toString());
			 
		%>
			<form action="/miniProject/booking_servlet" class="a<%=i%>">
				<input type="hidden" name="command" value="secondBook">
				<%-- <input type="hidden" name="id" value="<%=CDto.getId()%>"> --%>
				<input type="hidden" value="<%=BDto.getVisit_date() %>" name="visit_date">
				<input type="hidden" value="<%=BDto.getLeave_date() %>" name="leave_date">
				<input type="hidden" value="<%=BDto.getAdult_number() %>" name="adult_number">
				<input type="hidden" value="<%=BDto.getChild_number() %>" name="child_number">
				<input type="hidden" value="<%=RDto.getRoom_number()%>" name="room_number">
				<input type="hidden" value="<%=RDto.getPrice()%>" name="price"> 
				<!-- ID -->
				<tr>
					<td class="bookingtabletd">
						<img src="./image/roomimg<%=i+1%>.jpg"> <br>
					<%=RDto.getRoom_number() %>호</td>
					<td class="bookingtabletd">요금:<%=RDto.getPrice() %></td>
					<td class="bookingtabletd">등급:<%=RDto.getGrade() %></td>
					<td class="bookingtabletd"><input type="submit" value="예약하기"></td>
				</tr>
			</form>
			
		<%
		}
	}
	 %>
</table>


<!-- 로그인 정보(회원정보) 합치면 해제 -->
<%-- <table>
	<tr>
		<td colspan="2" align="center">회원정보</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=//CDto.getId() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=//CDto.getName() %></td>
	</tr>
	<tr>
		<td>휴대전화</td>
		<td><%=CDto.getPhone() %></td>
	</tr>
</table>
 --%>
 
 </div>
 
</main>

<jsp:include page="footer.jsp" flush="false"/>



</body>
</html>