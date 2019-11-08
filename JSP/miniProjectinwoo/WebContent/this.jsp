<%@page import="dto.CustomerDto"%>
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
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


<style type="text/css">

main{
	width: 100%;
	margin: auto;
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

	margin: auto;
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

<jsp:include page="header.jsp" flush="false"/>

<main>





<form action="/miniProject/booking_servlet">
<input type="hidden" name="command" value="firstBook">
<input type="hidden" id="visit_date" name="visit_date">
<input type="hidden" id="leaver_date" name="leaver_date">

<div class="bd">
	<table border="1"; style="text-align: center;">
		<tr>
			<td colspan="6"><h2>롯데 시그니엘 호텔</h></td>
		</tr>
		<tr>
			<td><h4>체크인</h4></td>
			<td colspan="2"><div class="wrapper">
					<input type="text" id="datepicker1" placeholder="날짜를 선택하세요." readonly="true" />
				</div></td>
			<td><h4>체크아웃</h4></td>
			<td colspan="2"><div class="wrapper">
					<input type="text" id="datepicker2" placeholder="날짜를 선택하세요." readonly="true" />
				</div></td>	
		</tr>
		<tr>
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
</div>
</form>
	

	

</main>

<jsp:include page="footer.jsp" flush="false"/>

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

</body>
</html>