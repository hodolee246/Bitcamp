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

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />

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
	height: 750px; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
	text-align: center;
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

* {
      box-sizing: border-box;
      font-family: 'NanumGothic, sans-serif';
    }
    /* placeholder color */
    input:-ms-input-placeholder {
      color: #000;
    }
    input::-webkit-input-placeholder {
      color: #000;
    }
    input::-moz-placeholder {
      color: #000;
    }
    input::-moz-placeholder {
      color: #000;
    }
    .wrapper {
      position: static;
      width: 155px;
      height: 35px;
      margin: 10px;
    }
    .ion-calendar {
      position: absolute;
      right: 20px;
      top: 14px;
    }
    /* input */
    #datepicker1 {
      border: 1px solid #c6e2f7;
      border-radius: 5px;
      width: 100%;
      height: 100%;
      font-size: 16px;
      text-align: center;
      cursor: pointer;
    }
    #datepicker2 {
      border: 1px solid #c6e2f7;
      border-radius: 5px;
      width: 100%;
      height: 100%;
      font-size: 16px;
      text-align: center;
      cursor: pointer;
    }
    #datepicker1:hover {
      background-color: #eaf7ff;
    }
    #datepicker2:hover {
      background-color: #eaf7ff;
    }
    #datepicker1:focus {
      outline: none;
    }
    #datepicker2:focus {
      outline: none;
    }
    /* calendar table */
    .ui-datepicker {
      display: none;
      background-color: #fff;
      border-radius: 5px;
 /*      margin-top: 10px;
      margin-left: 42.5px;
      margin-right: 42.5px;
      padding: 20px; */
      width: 250px;
    }
    #datepicker:focus>.ui-datepicker {
      display: block;
    }
    .ui-datepicker-prev,
    .ui-datepicker-next {
      cursor: pointer;
    }
    .ui-datepicker-next {
      float: right;
    }
    .ui-state-disabled {
      cursor: auto;
      color: hsla(0, 0%, 80%, 1);
    }
    .ui-datepicker-title {
      text-align: center;
      padding: 10px;
      font-weight: 100;
      font-size: 20px;
    }
    .ui-datepicker-calendar {
      width: 100%;
    }
    /* day of week cell */
    .ui-datepicker-calendar>thead>tr>th {
      padding: 5px;
      font-size: 20px;
      font-weight: 400;
    }
    /* day cell */
    .ui-datepicker-calendar>tbody>tr>td {
      border-radius: 100%;
      width: 22px;
      height: 22x;
      cursor: pointer;
      padding: 3px;
      font-weight: 70;
      text-align: center;
    }
    .ui-datepicker-calendar>tbody>tr>td:hover {
      background-color: #c6e2f7;
    }
    .ui-datepicker-calendar>tbody>tr>td>a {
      color: #000;
      font-size: 18px;
      font-weight: 400;
      text-decoration: none;
    }
    /* past days */
    .ui-datepicker-calendar>tbody>tr>.ui-state-disabled:hover {
      cursor: auto;
      background-color: #fff;
    }
    /* media */
    @media(max-width: 445px) {
      .wrapper {
        width: calc(100vw - 20px);
      }
      .ui-datepicker {
        margin-right: 0;
        margin-left: 0;
        padding: 10px;
        width: calc(100vw - 20px);
        margin: 10px auto;
      }
      .ui-datepicker-calendar>tbody>tr>td {
        width: 30px;
        height: 30px;
      }
    }

.bookbtn{
	cursor: pointer;
}
.bd{
	width: 100%;
	height: 500px;
	margin-top: 50px;
	text-align: center;
	padding-top: 30px;
	padding-bottom: 30px;
	padding-left: 30px;
	padding-right: 30px;
	
	

}
.bt{
	margin: auto;
	position: inherit;
	background-color: #fafafa;
	border-collapse: collapse;
	border: 1px solid #00ffff;
}
.datatable{
	margin: auto;
	position: inherit;
}


</style>

</head>

<body>
<%

CustomerDto user = (CustomerDto)session.getAttribute("login");
request.setAttribute("_user", user); 

if(user == null){
	System.out.println("CustomerDto user == null");
	response.sendRedirect("/miniProject/customer_servlet?command=loginpage");
}

%>


<header>


	<div id="hbox1">
		
		
		<div id="box1">
			<a href="/miniProject/customer_servlet?command=mainpage"><img alt="" src="./image/logo.png"></a>
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
	              <li><a class="allfont" href="/miniProject/customer_servlet?command=mainpage">홈</a></li>
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




<form action="/miniProject/booking_servlet">
<input type="hidden" name="command" value="firstBook">
<input type="hidden" id="visit_date" name="visit_date">
<input type="hidden" id="leaver_date" name="leaver_date">

<div class="bd">
	<h1>예약하기</h1>
	<br><br><br>
	<table class="bt">
		<tr height="90px;">
			<td colspan="6"><h2>롯데 시그니엘 호텔</h></td>
		</tr>
		<tr height="50px;">
			<td><h4>체크인</h4></td>
			<td colspan="2"><div class="wrapper">
					<input type="text" id="datepicker1" placeholder="날짜를 선택하세요." readonly="true" />
				</div></td>
			<td><h4>체크아웃</h4></td>
			<td colspan="2"><div class="wrapper">
					<input type="text" id="datepicker2" placeholder="날짜를 선택하세요." readonly="true" />
				</div></td>	
		</tr>
		<tr height="50px;">
			<td>인원</td>
			<td><select name="adult_number">
					<option selected="selected" value="1">성인1</option>
					<option value="2">성인2</option>
				</select></td>
			<td><select name="child_number">
					<option selected="selected" value="0">어린이0</option>
					<option value="1">어린이1</option>
				</select></td>	
			<td colspan="3"><button type="submit" class="bookbtn" disabled="disabled">예약하기</button></td>	
		</tr>
	</table>
	<div >
	<br><br>
	<table class="datatable">
		<tr>
			<td><h2 id="checkintitle" style="display: none;">체크인</h2></td>
			<td><h2 id="checkouttitle" style="display: none;">체크아웃</h2></td>
		</tr>
		<tr>
			<td><h2 id="checkin" style="display: none;"></h2></td>
			<td><h2 id="checkout" style="display: none;"></h2></td>
		</tr>
	</table>
	</div>
</div>

</form>
	

	
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
	
	$('#btn').click(function () {
		location.href="/miniProject/booking_servlet?command=first";
	});
	
});

$(function () {
	  var day1, day2, day3;
	 
  $.datepicker.setDefaults({
    closeText: "닫기",
    prevText: "이전달",
    nextText: "다음달",
    currentText: "오늘",
    monthNames: ["1월", "2월", "3월", "4월", "5월", "6월",
      "7월", "8월", "9월", "10월", "11월", "12월"
    ],
    monthNamesShort: ["1월", "2월", "3월", "4월", "5월", "6월",
      "7월", "8월", "9월", "10월", "11월", "12월"
    ],
    dayNames: ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"],
    dayNamesShort: ["일", "월", "화", "수", "목", "금", "토"],
    dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
    weekHeader: "주",
    dateFormat: "yy-mm-dd",
    firstDay: 0,
    isRTL: false,
    showMonthAfterYear: true,
    yearSuffix: "년"
  })
  $("#datepicker1").datepicker({
    minDate: 0,
    /* to use in wix */

    onSelect: function (selected, event) {
      console.log(selected);
      /* 
       * wix-send-messages from html component
       * https://support.wix.com/en/article/working-with-the-html-component-in-wix-code
       */
      window.parent.postMessage(selected, "*");
      day1 = $("#datepicker1").datepicker({
			dateFormat: "yy/mm/dd"
		}).val();
		$("#day1").text(day1);
		$("#visit_date").val(day1);
		$("#checkintitle").show();
		$("#checkin").show();
		$("#checkin").text(day1 + "~");
		
    }
  })
  
  $("#datepicker2").datepicker({
    minDate: 0,
    /* to use in wix */
    onSelect: function (selected, event) {
      console.log(selected);
      
      /* 
       * wix-send-messages from html component
       * https://support.wix.com/en/article/working-with-the-html-component-in-wix-code
       */
      window.parent.postMessage(selected, "*");
      day2 = $("#datepicker2").datepicker({
			dateFormat: "yy/mm/dd"
		}).val();
		$("#day2").text(day2);
		$("#leaver_date").val(day2);
		$("#checkouttitle").show();
		$("#checkout").show()
		$("#checkout").text(day2);
		day3= day2 > day1;
		
		if(!day3){
			alert("퇴실일을 확인해주세요");
			$("button").attr("disabled", "disabled")
		}else{
			$("button").removeAttr("disabled");
		}	
    }
  })

	})



</script>

<!-- <script type="text/javascript" src="js/bootstrap.js"></script> -->
</body>
</html>