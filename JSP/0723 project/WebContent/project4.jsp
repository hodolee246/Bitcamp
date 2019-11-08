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

-- 입력 페이지 --
<form id="frm" >
<br><br>
&ensp;&ensp;&ensp;&ensp;이름:<input type="text" name="name" size="15">
<br>
생년월일:<input type="text" name="bday" size="15">
<br>
<button type="button"  id="btn">전송</button>
</form>
<script type="text/javascript">

$(function name() {
	$("#btn").click(function(){
		$("#frm").attr("action", "NewFile.jsp").submit();
	});
});
</script>
</body>
</html>