<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="../js/jquery.min.js"></script> 
<link rel="stylesheet" href="../css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean" rel="stylesheet">

<style type="text/css">
main{
	width: 80%;
	height: 1800px; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	/* background-color: blue; */
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
.allMenu{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1.3em;
  	color: red;
}

/* main안에 있는 태그이다 */
.intro{
	background-color: #fafafa;
	margin-top: 50px;
	margin-bottom: 100px;
	height: 200px;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 20px;
}
.backLocation {
	width: 100%;
	height: 1500px;
	/* background-color: red; */
}
.maparea{
	width: 100%;
	height: 800px;
	margin-top: 100px;
	/* background-color: orange; */
}


.box1 {
	width: 100%;
	height: 400px;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 20px;
	/* background-color: blue; */
	margin-bottom: 100px;
	float: left;
}
.box11 {
	float: left;
	margin-right: 30px;
}
.box2 {
	width: 100%;
	height: 400px;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 20px;
	/* background-color: yellow; */
	margin-bottom: 100px;
	float: left;
}
.box21 {
	float: left;
	margin-right: 30px;
}
.box3 {
	width: 100%;
	height: 400px;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 20px;
	/* background-color: green; */
	margin-bottom: 100px;
	float: left;
}
.box31 {
	float: left;
	margin-right: 30px;
}

	
	
</style>

</head>

<body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=663d31a73a34a918bb28760edb2b72f7"></script>

<jsp:include page="../header.jsp" flush="false"/>
 
<main>


<div class="intro" align="center">
<p style="font-family: 'Noto Sans KR', sans-serif; font-size: 50px">객실</p>
<p>
잠실에서 바라보는 서울 시내의 환상적인 전망이 어루어진 시그니엘서울의 최고급 호텔 사우나, 헬스장, 실내 수영장은 새로운 힐링과 활력의 시간을 제안합니다.<br>
또한 한국 최초의 에비앙 스파는 프리미엄 수분공급을 통해 심신을 치유하는 에비앙 스파만의 특별한 트리트먼트를 제공합니다.<br>
투숙객 전용 라운지에서는 한강 전망을 바라보며 티 타임을 즐기실 수 있습니다.
</p>
</div>



<div class="backLocation">

<div class="box1" align="left">
	<div class="box11">
	<img alt="" src="/miniProject/image/sweet1.png" style="width: 700px; height: 400px">
	</div>
	
	<p style="font-size: 30px;">스위트</p><br>
	시그니엘서울의 디럭스 스위트 룸은 일반 객실보다 더욱 넓고 쾌적한 공간을 제공하는 객실입니다. 
	시그니엘서울 디럭스 스위트 룸은 침실과 응접실이 공간이 분리되어 있어 편안함과 안정된 휴식을 누리실 수 있는 객실입니다.<br><br>
	
	<a href="#">객실 상세정보 보기</a>
</div>


<div class="box2">
	<div class="box21">
	<img alt="" src="/miniProject/image/pri1.png" style="width: 700px; height: 400px">
	</div>
	
	<p style="font-size: 30px;">프리미어</p><br>
	시그니엘서울의 시그니엘 프리미어 룸은 침실과 함께 여유로운 업무 공간이 구비되어 성공적인 비즈니스와 여유로운 휴식을 함께 즐길 수 있는 고급 비즈니스 객실입니다. 
	시그니엘 프리미어룸의 60인치 TV에 장착된 프리미엄 사운드 바는 새로운 경험을 제공해 드립니다.<br><br>
	
	<a href="#">객실 상세정보 보기</a>
</div>


<div class="box3">
	<div class="box31" style="font-family: 'Noto Sans KR', sans-serif; font-size: 40px">
	<img alt="" src="/miniProject/image/deluxe1.png" style="width: 700px; height: 400px">
	</div>
	
	<p style="font-size: 30px;">디럭스</p><br>
	우아한 인테리어와 현대적 세련미가 조화롭게 어우러진 시그니엘서울의 그랜드 디럭스 룸은 서울 시내 동급 호텔 대비 넓은 40~50㎡의 여유로운 공간을 제공합니다. 
	87층부터 101층까지 위치한 초고층 객실에서 바라보는 서울 도심의 파노라믹뷰는 최상의 휴식을 제공합니다.
	모든 호텔 투숙객들이 자유롭게 이용할 수 있는 살롱 드 시그니엘은 시그니엘서울의 또 하나의 즐길 거리입니다.<br><br>
	
	<a href="#">객실 상세정보 보기</a>
</div>


</div>





</main>




<jsp:include page="../footer.jsp" flush="false"/>

</body>
</html>