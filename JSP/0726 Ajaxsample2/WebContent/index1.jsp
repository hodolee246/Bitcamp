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

var target = [];
var link = [];
var urlname = [];


$(function () {

	$("button").click(function () {
		
		$.ajax({
			type:"get",
			url:"data.xml",
			datatype:"xml",
			success:function ( data ){
//				alert("success:function");
				var _xml = $(data).find("xmldata"); // root
				var len = _xml.find("news").length;
//				alert(len);
				
				for(i = 0; i<len; i++){
					target[i] = _xml.find("news").eq(i).find("target").text();
					link[i] = _xml.find("news").eq(i).find("link").text();
					urlname[i] = _xml.find("news").eq(i).find("name").text();
					
					$("#demo").append(target[i]).append(link[i]).append(urlname[i] + "<br>");
				}
				
				
			},
			error:function(){
				alert("error:function.");
			}
		});
	});
	
});



</script>

</body>
</html>