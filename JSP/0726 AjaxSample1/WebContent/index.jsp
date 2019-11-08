<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<%--
	Ajax : Asynchronous Javascript And Xml
			비동기화(영어교육 앞에 a를 빼면 동기화가 된다)
	Ajax == 비동기 통신이라고 불린다.
	* 비동기통신 현재 페이지를 유지하면서 다른 페이지 데이터를 끄집어낸다.	
	JQuery 소속이다.
synchronous:  form.jsp -> xxxaf(경로, DB) -> list.jsp (이게 동기통신)
Ajax		  form.jsp <- DB, Data	
 --%>

<p id="demo"></p>
<br>
<button type="button">click</button>
<script type="text/javascript">
$(function () {
	$("button").click(function () {
//	$("button").on("click", function () {
		
//		$("#demo").load("data.html");
// demo 라는 p태그에 data.html 을 올려라!

//		$("#demo").load("data.html #data2");
// demo라는 p 태그에 data.html 의 id 값이 data2인 데이터를 가져와라 (태그)
	
	
//		$("#demo").load("data.jsp", "t1=abc&t2=가나다");
// demo안에 jsp파일의 t1, t2의 데이터를 주고나서 그걸 다시 받아온다.
	

//		$("#demo").load("data.jsp", {t1:"bcd", t2:"나다라"});
// demo안에 jsp 파일의 t1, t2의 데이터를 주고나서 그걸 다시 받아온다.(Json 방식)
// 이것이 Json 방식이다.

		$("#demo").load("data.jsp", function (data, status, xhr) {
			$("#demo").append("data = " + data + "<br>");	// data를 전부다 가지고온다.
			$("#demo").append("status = " + status + "<br>");	// 통신이 성공여부가 뜬다.
			$("#demo").append("xhr = " + xhr + "<br>");	/
		});

	});
});
</script>






































</body>
</html>





















