
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


</style>

</head>

<body>


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
		<img alt="" src="/miniProject/image/botLogo.jpg">
	</div>
</footer>

</body>
</html>