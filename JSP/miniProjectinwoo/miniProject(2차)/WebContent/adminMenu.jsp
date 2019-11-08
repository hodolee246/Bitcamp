<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<ul class="menu">
			<li><a href="/miniProject/admin_servlet?command=adminChart" class="fatag">메인으로</a></li><br>
			<li><a href="/miniProject/customer_servlet?command=adminCustomer" class="fatag">회원 관리</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=roomadmin" class="fatag">객실정보 관리</a>
				<!-- 
				↓ 객실정보 등록/수정/삭제 메뉴바에서 삭제 고려중입니다
				<ul class="menu"><br>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 등록</a></li>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 수정</a></li>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 삭제</a></li><br>
				</ul>
				
				 -->
			</li><br>
			<li><a href="/miniProject/booking_servlet?command=adminBooking" class="fatag">예약 관리</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=qnalist&choice=&str=&pageNum=1" class="fatag">고객의소리 관리</a></li><br>
			<li><a href="/miniProject/notice_servlet?command=notice_adm" class="fatag">뉴스게시판 관리</a></li><br><br>
		</ul>

</body>
</html>