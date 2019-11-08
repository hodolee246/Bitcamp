<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="<%=request.getContextPath() %>/captcha" id="captchaimg" alt="captcha img">


<script>
    var $captchaLoader = $("#writeForm .box.captcha .loading");
    var $captchaImg = $("#writeForm .box.captcha img");
 
    // captcha 새로고침
    $captchaImg.click(function() {
        $captchaLoader.show();
        $(this).attr("src", "/captcha?ran=" + Math.random());
        $captchaLoader.fadeOut(500);
    });
</script>

</body>
</html>