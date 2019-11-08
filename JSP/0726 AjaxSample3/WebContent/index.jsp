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

<p id="demo"></p>
<br>
<button type="button">click</button>

<script type="text/javascript">

$(function () {

	$("button").click(function () {
		
		$.ajax({
			type:"get",
			url:"data.jsp",
			datatype:"json",
			success:function( obj ){
//				alert("s");	
//				alert(obj);
				var _data = JSON.parse(obj); //String -> json
				alert(_data.num);
				
//				var str = JSON.stringify(_data); //json -> String
//				alert(str.num);
				
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




