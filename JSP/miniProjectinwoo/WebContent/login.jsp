<%@page import="dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="./js/jquery.min.js"></script>
 
<link rel="stylesheet" href="css/bootstrap.css">

<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean" rel="stylesheet">

<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

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
main{
	width: 70%;
	/* height: 800px; */ /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}
footer{
	width: 100%;
	height: 420px;
	margin: auto;
	background-color: #0a1a2a;
}
#fbox1{
	width: 50%;
	height: 100%;
	float: left;
}
#fbox2{
	width: 50%;
	height: 100%;
	float: left;
	text-align: right;
	padding-right: 10%;
}
#box3{
	width: 50%;
	height: 50%;
	float: left;
	padding-top: 50px;
	padding-left: 25%;
	
}
#box4{
	width: 50%;
	height: 50%;
	float: left;
	padding-top: 50px;
	
}
#box5{
	width: 100%;
	height: 50%;
	float: left;
	padding-top: 50px;
	padding-left: 25%;
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
ul{
   list-style:none;
   padding-left:0px;
}
.fatag{
	color: #A4A4A4;
}
.fatag:HOVER {
	color: #A4A4A4;
	text-decoration: none;
}
table{
    width: 70%;
    /* height: 200px; */
    /* border: 1px solid; */
}
tr, td, th{
	/* border: 1px solid; */
}
#id, #pwd, #loginbtn, #pwdfindbtn{
	width: 100%;
	height: 50px;
}
#accountbtn{
	width: 100%;
	height: 230px;
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
			<a href="#"><img alt="" src="./image/logo.png"></a>
		</div>
		
		<div id="box2">
	 		<c:if test="${empty _user}">	 			
			 		<a href="common_servlet?command=account" style="color: #BDBDBD" class="allfont">회원가입</a>
					<a href="common_servlet?command=loginpage" style="color: #BDBDBD" class="allfont">로그인</a>
					<a href="#" style="color: #BDBDBD" class="allfont">예약조회</a>				
			</c:if>
			
			<c:if test="${not empty _user}">
		 		<a href="common_servlet?command=logout" style="color: #BDBDBD" class="allfont">로그아웃</a>
				<a href="common_servlet?command=mypage" style="color: #BDBDBD" class="allfont">마이페이지</a>
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





<main>

<div align="center">
  <form action="" id="frm">
  	<input type="hidden" name="command" value="login">
  	<table>
  		<tr>
  			<td colspan="2">
  				<h1 class="allfont">로그인</h1>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="id 입력" id="id" name="id">
  			</td>
  			<td rowspan="5">
  				<a href="common_servlet?command=account"><button type="button" class="btn btn-default" id="accountbtn">회원가입</button></a>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="password" placeholder="비빌번호 입력" id="pwd" name="pwd">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="checkbox" name="idcheck" id="chk_save_id">id 저장
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="button" value="로그인" class="btn btn-default" id="loginbtn">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<a href="common_servlet?command=pwdfind"><input type="button" value="비밀번호 찾기" class="btn btn-default" id="pwdfindbtn"></a>
  			</td>
  		</tr>
  	</table>
   </form>
  </div>
	
</main>










<footer>
	<div id="fbox1">
		<div id="box3">
			<h4 class="allfont" style="color: #ffffff;">소개</h4><br>
				<ul class="allfont">
					<li><a href="#" class="fatag">호텔 소개</a></li><br>
					<li><a href="#" class="fatag">객실 소개</a></li><br>
					<li><a href="#" class="fatag">관광지 소개</a></li>
				</ul>
		</div>
		<div id="box4">
			<h4 class="allfont" style="color: #ffffff">게시판</h4><br>
				<ul class="allfont">
					<li><a href="#" class="fatag">공지사항</a></li><br>
					<li><a href="#" class="fatag">Q&A</a></li><br>
					<li><a href="#" class="fatag">고객의 소리</a></li>
				</ul>
		</div>
		<div id="box5">
			<p class="allfont">(주)호텔롯데<br>
						서울특별시 송파구 올림픽로 300<br>
						롯데월드타워 76-101층</p>
						
			<p class="allfont">Copyright ©2019 All rights reserved | This template is made by 3조</p>
		</div>
	</div>
	
	<div id="fbox2">
		<img alt="" src="./image/botLogo.jpg">
	</div>
</footer>

<script type="text/javascript">


$(function () {
	$(document).scroll(function() {
		var st = $(this).scrollTop();
		$("#bt04").text(st);
		
		var he = st - 89;
		
		if(st <= 89){
			he = 0;
		}
		
		$("#bt05").text(he);
		
		$("#navbar").css("margin-top", he);
	});
	$("#loginbtn").click(function() { // 로그인 버튼 누를때
		 
		if( $("#id").val().trim() == "" ){
			alert("id를 입력해주십시오");
			$("#id").focus();
		}
		else if( $("#pwd").val().trim() == "" ){
			alert("password를 입력해주십시오");
			$("#pwd").focus();
		}
		else{
			$("#frm").attr({"action":"common_servlet", "method":"post"}).submit();
		}
		
	});
	
	var user_id = $.cookie("user_id");
	
	if( user_id != null){ // 지정한 쿠키가 있을때
		//alert("쿠키 있음");	
		$("#id").val( user_id );
		$("#chk_save_id").attr("checked", "checked");
	}

	$("#chk_save_id").click(function() {
		if( $("#chk_save_id").is(":checked") ){ // 체크되었을떄
			//alert("체크됌");
			if($("#id").val().trim() == ""){
				alert("id를 입력해주십시오");
				$("#chk_save_id").prop("checked", false);
			}else{ //정상기입 한경우
				$.cookie("user_id", $("#id").val().trim(), {expires:7, path:'/'}); // 쿠키를 사용하고 7일간 저장 (expires:저장기간 path:모든경로 ?)
			}
		}else{ // 체크 해제되었을때
			//alert("체크 없어짐");
			$.removeCookie("user_id", {path:'/'}); // 기한을 없애면서 삭제가 된다.
		}
		
	});
});

</script>

<!-- <script type="text/javascript" src="js/bootstrap.js"></script> -->
</body>
</html>