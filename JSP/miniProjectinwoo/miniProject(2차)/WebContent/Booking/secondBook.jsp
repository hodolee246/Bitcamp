<%@page import="dto.CustomerDto"%>
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


CustomerDto user = (CustomerDto)session.getAttribute("login");

if(user == null){
	System.out.println("CustomerDto user == null");
	response.sendRedirect("/miniProject/customer_servlet?command=loginpage");
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
	height: auto; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}
.tablelistdiv{
	width: 100%;
	height: auto;
	margin-top: 50px;
	margin-bottom: 70px;
}
.listtable{
	margin: auto;
	position: inherit;
	
}
tr{

	height: 75px;
}
</style>

</head>

<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>


<div class="tablelistdiv">

<table class="listtable">
	<col width="150px;"><col width="250px"><col width="150px"><col width="75px">
	<tr>
		<td colspan="4" style="text-align: center" align="center">
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
				<input type="hidden" name="id" value="<%=user.getId()%>">
				<input type="hidden" value="<%=BDto.getVisit_date() %>" name="visit_date">
				<input type="hidden" value="<%=BDto.getLeave_date() %>" name="leave_date">
				<input type="hidden" value="<%=BDto.getAdult_number() %>" name="adult_number">
				<input type="hidden" value="<%=BDto.getChild_number() %>" name="child_number">
				<input type="hidden" value="<%=RDto.getRoom_number()%>" name="room_number">
				<input type="hidden" value="<%=RDto.getPrice()%>" name="price"> 
				<!-- ID -->
				<tr>
					<td>
						<img src="/miniProject/image/<%=RDto.getRoom_number() %>.jpg" width="250px" height="180px"> <br>
					<%=RDto.getRoom_number() %>호</td>
					<td align="center"><h4>요금:<%=RDto.getPrice() %></h4></td>
					<td align="left"><h4>등급:<%=RDto.getGrade() %></h4></td>
					<td><input type="submit" value="예약하기" class="btn btn-primary"></td>
				</tr>
			</form>
			
		<%
		}
	}
	 %>
</table>

 
 </div>
 
</main>

<jsp:include page="../footer.jsp" flush="false"/>



</body>
</html>