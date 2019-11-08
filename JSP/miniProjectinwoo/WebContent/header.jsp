<%@page import="dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/miniProject/js/jquery.min.js"></script>
 
<link rel="stylesheet" href="/miniProject/css/bootstrap.css">

<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean" rel="stylesheet">

<style type="text/css">

header{
	width: 80%;
	height: 150px;
	margin: auto;
}
#hbox1{
	width: 100%;
	height: 40%;
	float: left;
}
#hbox2{
	width: 100%;
	height: 60%;
	float: left;
}
#box1{
	width: 50%;
	height: 100%;
	float: left;
}
#box2{
	width: 50%;
	height: 100%;
	float: left;
	text-align: right;
	padding-top: 30px;
}
.allfont{
  	font-family: 'Noto Sans KR', sans-serif;
  	color: gray;
}
a{
	text-decoration: none;
	margin-right: 30px;
}  
.navbar-default {
    background-color: #ffffff;
    border-color: #e7e7e7;
}
.navbar {
    position: relative;
    min-height: 50px;
    margin-bottom: 20px;
    border: 0px;
    margin-top: 30px;
    spadding-left:30%;  
    
    /* border: 1px solid transparent; */
}
#navbar{
	margin-top: 0px; 
    background-color: #f1f1f1;
    width: 100%;
    height: auto;
    padding-left: 30%;
}
.btn-dark{
	background-color: #111111;
	color: #ffffff;
}
.btn-dark:hover{
	background-color: #2A7BD6;
	color: #ffffff;
}
ul{
   list-style:none;
   padding-left:0px;
}

</style>

</head>

<body>

<%
CustomerDto user = (CustomerDto)session.getAttribute("login");
request.setAttribute("_user", user);

%>

<header>

	<div id="hbox1">
		<div id="box1">
			<a href="#"><img alt="" src="/miniProject/image/logo.png"></a>
		</div>
		
		<div id="box2">
	 		<c:if test="${empty _user}">	 	
	 		<!-- /miniProject/customer_servlet?command=logout	 -->	
			 		<a href="/miniProject/customer_servlet?command=account" style="color: #BDBDBD" class="allfont" >회원가입</a>
					<a href="/miniProject/customer_servlet?command=loginpage" style="color: #BDBDBD" class="allfont">로그인</a>
					<a href="#" style="color: #BDBDBD" class="allfont">예약조회</a>				
			</c:if>
			
			<c:if test="${not empty _user}">
		 		<a href="/miniProject/customer_servlet?command=logout" style="color: #BDBDBD" class="allfont">로그아웃</a>
				<a href="/miniProject/customer_servlet?command=mypage" style="color: #BDBDBD" class="allfont">마이페이지</a>
				<a href="#" style="color: #BDBDBD" class="allfont">예약조회</a>
			</c:if>
		</div>
		
	</div>
	<div id="hbox2">
	
		<nav class="navbar navbar-default" >
		  <div>
		    
		    <div class="navbar-collapse" id="navbar">
		      
		      <ul class="nav navbar-nav">
	              <li><a class="allfont" href="#">홈</a></li>
	              <li><a class="allfont" href="#">시그니엘 소개</a></li>
	              <li><a class="allfont" href="#">객실 소개</a></li>
	        	  <li><a class="allfont" href="#">관광지 소개</a></li>
	              <li><button id="btn" class="btn btn-dark navbar-btn">예약하기</button></li>
	            </ul>
		
		    </div>
		    
		  </div>
		</nav>
	
	</div>
	
</header>





<script type="text/javascript">


/* 
var didScroll;

// 스크롤시에 사용자가 스크롤했다는 것을 알림
$(document).scroll(function(event){ 
	didScroll = true; 
}); 

// hasScrolled()를 실행하고 didScroll 상태를 재설정 

setInterval(function() { 
	if (didScroll) { 
		hasScrolled(); 
		didScroll = false;
		} 
	}, 100); 

function hasScrolled() { // 동작을 구현
	
	var st = $(this).scrollTop();
	
	var he = st - 89;
	
	if(st <= 89){
		he = 0;
	}
	
	$("#navbar").css("margin-top", he);
	
	$(this).scroll = st;
	
}

 */


$(function () {
	$(document).scroll(function() {
		var st = $(this).scrollTop();
		//$("#bt04").text(st);
		
		var he = st - 89;
		
		if(st <= 89){
			he = 0;
		}
		
		$("#bt05").text(he);
		
		$("#navbar").css("margin-top", he);
		
		$(this).scroll = st;
	});
});
 
</script>

<!-- <script type="text/javascript" src="js/bootstrap.js"></script> -->
</body>
</html>