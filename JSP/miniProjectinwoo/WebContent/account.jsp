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
}

#id, #pwd, #name, #address, #birthday, #phone, #email,#accountbtn{
	width: 100%;
	height: 50px;
}
#idcheckbtn{
	height: 50px;
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
  	<input type="hidden" name="command" value="custaccount">
  	<table>
  		<tr>
  			<td colspan="2">
  				<h1 class="allfont">회원가입</h1>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="id 입력" id="id" name="id" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  			<td>
  				<button type="button" class="btn btn-default" id="idcheckbtn">id체크</button>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<font color="red">7자 이상의 영문+숫자로 등록해주십시오</font>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="password" placeholder="비빌번호 입력" id="pwd" name="pwd">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<font color="red">8~15자리의 특수,영문+숫자로 등록해주십시오( ~!@\#$%><^&* 만 지원합니다. )</font>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="이름 입력" id="name" name="name">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="주소입력" id="address" name="address">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="생년월일(예 : 19920305)" id="birthday" name="birthday" maxlength="8" onkeypress="return fn_press(event,'numbers');" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="전화번호(예 : 01012345678)" id="phone" name="phone" maxlength="11" onkeypress="return fn_press(event,'numbers');" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="이메일(예 : abc@naver.com)" id="email" name="email" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="button" value="회원가입하기" class="btn btn-default" id="accountbtn">
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
var check = true;

var pattern1 = /[0-9]/;

var pattern2 = /[a-zA-Z]/;

var pattern3 = /[~!@\#$%<>^&*]/;     // 원하는 특수문자 추가 제거

/*숫자만 입력하게함*/
function fn_press(event, type) {
	if(type == 'numbers'){
		if(event.keyCode < 48 || event.keyCode > 57){
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
	
	$("#accountbtn").click(function () {
		
        var pw = $("#pwd").val().trim();
        
		if(check == false){
			
			alert("id 체크를 하세요");
			
		}else if(!pattern1.test(pw) ||!pattern2.test(pw)||!pattern3.test(pw)||pw.length<8||pw.length>15){

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
			
			$("#frm").attr({"action":"common_servlet", "method":"post"}).submit();
			
		}
	});
	
	
	$("#idcheckbtn").click(function () {
		//alert($("#id").val().trim().length);
		
		 if($("#id").val().trim().length < 7 || !pattern1.test($("#id").val().trim())){
			
			alert("id의 길이와 형식을 맞춰서 입력해주세요");
			
		}else{  
			$.ajax({
				//이동할때 필요한것
				url: "common_servlet",		//가야할곳
				type: "get",			//get/post
				data: "command=idcheck&id=" + $("#id").val().trim(),//Parameter(넘겨주는 값)
				////////////////////////////////////////////////////
				
				//통신후 결과
				success:function(data, status, xhr){
					//alert(data);
					//$("#idcheckout").text(data.trim());
					
					if(data == "true"){
						check = true;
						alert("이 아이디는 사용가능합니다");
					}else{
						check = false;
						alert("다른아이디를 사용하여 주십시오");
					}
					 
				},
				error:function(xhr, status, error){
					alert("통신실패");
				}
			});
		} 
		
	});
	
	
	
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
});

</script>

<!-- <script type="text/javascript" src="js/bootstrap.js"></script> -->
</body>
</html>