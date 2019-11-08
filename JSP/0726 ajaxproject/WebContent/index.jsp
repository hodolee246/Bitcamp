<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>


ID:<input type="text" size="15" id="tf">
<br>
<button type="button">click</button>
<br>
<br>
<br>
<p id="demo"></p>

<script type="text/javascript">

$(function () {
	$("button").click(function () {
		
		$.ajax({
			type:"get",
			url:"idcheck.jsp",
			data:"id=" + $("#tf").val(),
			success:function(str){
				alert("s");
				alert(str);
				
				$("#demo").text(str.trim());
			},
			error:function(){
				alert("e");
			}
			
		});
		
		
	});
});

</script>

</body>
</html>