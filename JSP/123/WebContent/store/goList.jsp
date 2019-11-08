<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button type="button" onclick="goList()">가자</button>
<script type="text/javascript">
function goList() {
	location.href = "../storecontrol?command=list&page=0";
}
</script>
</body>
</html>