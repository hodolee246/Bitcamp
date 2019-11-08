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
<button type="button"> click</button>

<script type="text/javascript">
$(function () {

	$("button").click(function () {
		
		$.ajax({
			type: "get",
			url: "./data.json",
			datatype:'json',
			success:function(json){
				alert("성공");
//				alert(json[0].name + " " + json[0].age);

				/* for(i=0; i< json.length,i++){
					$("#demo").append(json[i].name + " ");
					$("#demo").append(json[i].age + " ");
					$("#demo").append(json[i].address + phone + " ");
					$("#demo").append(json[i].name + "<br>");
					
				} */
				$.each(json, function (index, item) {
					$("#demo").append(index + "<br> ");	// indexnumber
					$("#demo").append(item.name + "<br> ");	// name
					$("#demo").append(item.age + "<br> ");	// age
					$("#demo").append(item.address + "<br> ");	// addr
					$("#demo").append(item.phone + "<br> ");	// selfphone
				});


			},
			error:function(){
				alert("에러");
			}
			
		});
		
	});
	
	
});



</script>









</body>
</html>