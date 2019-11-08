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

<p id="demo">변하는지 확인용</p>
<br>
<button type="button">click</button>

<script type="text/javascript">
$(function () {
	// 이동할때 필요한 settiong 이동~
	$("button").click(function () {
		$.ajax({
			url:"data.jsp",				// 이동해야 할 장소 (페이지 이동이아니라 데이터 or 정보를 가지고 올 장소)
			type: "get",				// get/post 방식 결정
//			data: "t1=ABc&t2=가나다", 	// 넘겨주는 값(Parameter)
			data: {t1:"bcd", t2:"나다라"}, // json 방식으로 넘겨는값 설정
			// 갔다가 다시 성공적으로 올경우 성공으로 이동한다.
			// ~이동
			
			// 결과~
			success:function(data, status, xhr){
			//	alert("통신성공");	// 정상적으로 돌아올경우 뜬다.
			//	alert(data);		// 모든 데이터가 다뜬다 <html> 부터 </html> 까지
				$("#demo").html(data);
			},
			error: function(xhr, status, error){
				alert("통신실패");
				
			},
			complete:function(xhr, status){
				alert("통신종료");
			}
			
			
			
			
			
			
			
			
		});
	});
});
</script>






</body>
</html>










