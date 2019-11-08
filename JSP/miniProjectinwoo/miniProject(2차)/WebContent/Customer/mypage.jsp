	<%@page import="dto.PersonQnADto"%>
<%@page import="dto.BookingDto"%>
<%@page import="java.util.List"%>
<%@page import="dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

main{
	width: 70%;
	/* height: 800px; */ /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}
.ta1{
    width: 70%;
}
#in1, #in2, #in3{
	width: 100%;
	margin-top: 30px;
}
input{
	width: 50%;
	height: 50px;
}

</style>

</head>

<body>

<%
CustomerDto user = (CustomerDto)session.getAttribute("login");

if(user == null){
	System.out.println("CustomerDto user == null");
	response.sendRedirect("/miniProject/customer_servlet?command=loginpage");
	//request.getRequestDispatcher("common_servlet?command=loginpage").forward(request, response); // 이렇게 파라메타 붙여주는식으로는 못 쓴다.
}

request.setAttribute("_user", user);

List<BookingDto> bookinglist = (List<BookingDto>)request.getAttribute("bookinglist");

List<PersonQnADto> qnalist = (List<PersonQnADto>)request.getAttribute("qnalist");
%>

<jsp:include page="../header.jsp" flush="false"/>

<main>

	<c:if test="${not empty _user}">
	
	<div align="center">
	  <form action="" id="frm">
	  	<input type="hidden" name="command" value="custupdate">
	  	<input type="hidden" name="id" value="<%=user.getId()%>">
	  	<table class="ta1">
	  		<tr>
	  			<td>
	  				<h1 class="allfont">나의정보</h1>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<button type="button" class="btn btn-default" id="myrecordbtn">나의실적내역</button>
	  			</td>
	  			<td>
	  				<button type="button" class="btn btn-default" id="myquestionbtn">나의문의사항</button>
	  			</td>
	  			<td>
	  				<button type="button" class="btn btn-default" id="myinfobtn">나의정보관리</button>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="3">
	  				<table id="in1">
	  				
	  					<tr>
							<th></th><th>예약일시</th><th>방문일</th><th>퇴실일</th><th>금액</th><th>방정보</th><th>인원</th>
						</tr>
						
						<%
						if(bookinglist == null || bookinglist.size() == 0){
							%>
							<tr>
								<td colspan="7">예약된 내역이 없습니다.</td>
							</tr>
							<%
						}else{
							for(int i=0; i<bookinglist.size(); i++){
								BookingDto booking = bookinglist.get(i);
								
							%>
							<tr>
								<th><%=i+1%></th>
								<td>
									<%=booking.getWdate() %>
								</td>
								<td>
									<%=booking.getVisit_date() %>
								</td>
								<td>
									<%=booking.getLeave_date() %>
								</td>
								<td>
									<%=booking.getTotal_price()%>
								</td>
								<td>
									<%=booking.getRoom_number() %>
								</td>
								<td>
									어른:<%=booking.getAdult_number() %>명
									아이:<%=booking.getChild_number() %>명
								</td>
							</tr>
							<%
							}
						}
						%>
	  				
	  				</table>
	  				
	  				
	  				
	  				<table id="in2">
	  				
	  					<tr>
							<th></th><th>제목</th><th>시간</th><th>답변유무</th>
						</tr>
						
						<%
						if(qnalist == null || qnalist.size() == 0){
							%>
							<tr>
								<td colspan="7">문의내역이 없습니다.</td>
							</tr>
							<%
						}else{
							for(int i=0; i<qnalist.size(); i++){
								PersonQnADto qna = qnalist.get(i);
								
							%>
							<tr>
								<th><%=i+1%></th>
								<td>
									<%=qna.getTitle() %>
								</td>
								<td>
									<%=qna.getWdate() %>
								</td>
								<td>
									<%=qna.getQuestion_type() %>
								</td>
							</tr>
							<%
							}
						}
						%>
	  				
	  				</table>
	  				
	  				
	  				
	  				<table id="in3">
	  					<col width="50"><col width="400">
	  					<tr>
				  			<td colspan="2">
				  				<h2 class="allfont">나의 등급은 <%=user.getGrade() %></h2>
				  			</td>
				  		</tr>
				  		<tr>
				  			<td colspan="2">
				  				<h2 class="allfont">총 방문 횟수는 <%=user.getBooking_count()%></h2>
				  			</td>
				  		</tr>
				  		<tr>
				  			<td colspan="2">
				  				<h2 class="allfont">총 소비금액은 <%=user.getTotal_payment()%></h2>
				  			</td>
				  		</tr>
	  					<tr>
				  			<td colspan="2">
				  				<h4 class="allfont">변경하실 정보의 목록을 변경하고 변경 버튼을 눌러주시면 정보가 변경됩니다.</h4>
				  			</td>
				  		</tr>
		  				<tr>
		  					<td>
				  				비밀번호
				  			</td>
				  			<td>
				  				<input type="password" placeholder="비빌번호 입력" id="pwd" name="pwd" value="<%=user.getPwd()%>">
				  			</td>
				  		</tr>
				  		<tr>
				  			<td colspan="2">
				  				<font class="allfont">8~15자리의 특수,영문+숫자로 등록해주십시오( ~!@\#$%><^&* 만 지원합니다. )</font>
				  			</td>
				  		</tr>
				  		<tr>
				  			<td>
				  				이름
				  			</td>
				  			<td>
				  				<input type="text" placeholder="이름 입력" id="name" name="name" value="<%=user.getName()%>">
				  			</td>
				  		</tr>
				  		<tr>
				  			<td>
				  				주소
				  			</td>
				  			<td>
				  				<input type="text" placeholder="주소입력" id="address" name="address" value="<%=user.getAddress()%>">
				  			</td>
				  		</tr>
				  		<tr>
				  			<td>
				  				생년월일
				  			</td>
				  			<td>
				  				<input type="text" placeholder="생년월일(예 : 19920305)" id="birthday" name="birthday" maxlength="8" 
				  				onkeypress="return fn_press(event,'numbers');" onkeydown="fn_press_han(this);" 
				  				style="ime-mode:disabled;" value="<%=user.getBirthday()%>">
				  			</td>
				  		</tr>
				  		<tr>
				  			<td>
				  				전화번호
				  			</td>
				  			<td>
				  				<input type="text" placeholder="전화번호(예 : 01012345678)" id="phone" name="phone" maxlength="11" 
				  				onkeypress="return fn_press(event,'numbers');" onkeydown="fn_press_han(this);" 
				  				style="ime-mode:disabled;" value="<%=user.getPhone()%>">
				  			</td>
				  		</tr>
				  		<tr>
				  			<td>
				  				이메일
				  			</td>
				  			<td>
				  				<input type="text" placeholder="이메일(예 : abc@naver.com)" id="email" name="email" 
				  				onkeydown="fn_press_han(this);" style="ime-mode:disabled;" value="<%=user.getEmail()%>">
				  			</td>
				  		</tr>
				  		<tr>
				  			<td>
				  				<button type="button" class="btn btn-default" id="updatebtn">변경하기</button>
				  			</td>
				  		</tr>
	  				</table>
	  			</td>
	  		</tr>
	  	</table>
	   </form>
	  </div>
	  
	</c:if>  

</main>

<jsp:include page="../footer.jsp" flush="false"/>

<script type="text/javascript">

var pattern1 = /[0-9]/;

var pattern2 = /[a-zA-Z]/;

var pattern3 = /[~!@\#$%<>^&*]/;     // 원하는 특수문자 추가 제거

/*숫자만 입력하게함*/
function fn_press(event, type) {
	if(type == 'numbers'){
		if((event.keyCode < 48) || (event.keyCode > 57)){
			return false;
		}
	}
}

/* 한글입력방지 */
function fn_press_han(obj) {
	if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 ||
			event.keyCode == 39 || event.keyCode == 46){
		return;
	}
	obj.value = obj.value.replace(/[\ㄱ-ㅎ ㅏ-ㅣ 가-힣]/g, "");
}


$(function () {
	
	$("#in1").show();
	$("#in2").hide();
	$("#in3").hide();
	
	$("#myrecordbtn").click(function() {
		$("#in1").show();
		$("#in2").hide();
		$("#in3").hide();

	});
	$("#myquestionbtn").click(function() {
		$("#in1").hide();
		$("#in2").show();
		$("#in3").hide();

	});
	$("#myinfobtn").click(function() {
		$("#in1").hide();
		$("#in2").hide();
		$("#in3").show();

	});
	
	$("#updatebtn").click(function() {
		
		var pw = $("#pwd").val().trim();
        
		if(!pattern1.test(pw) ||!pattern2.test(pw)||!pattern3.test(pw)||pw.length<8||pw.length>15){

            alert("비밀번호는 영문+숫자+특수기호 8~15자리로 구성하여야 합니다.");
            
        }else if($("#name").val().trim() == ""){
			
			alert("이름을 입력하세요");
			
		}else if($("#address").val().trim() == ""){
			
			alert("주소를 입력하세요");
			
		}else if($("#birthday").val().trim().length != 8){
			
			alert("생일을 입력하세요");
			
		}else if($("#phone").val().trim().length != 11){
			
			alert("전화번호를 입력하세요");
			
		}else if($("#email").val().trim().indexOf("@") == -1){
			
			alert("이메일 형식으로 입력해주세요");
			
		}else{
			
			$("#frm").attr({"action":"/miniProject/customer_servlet", "method":"post"}).submit();
			
		}
	});
	
});

</script>



</body>
</html>