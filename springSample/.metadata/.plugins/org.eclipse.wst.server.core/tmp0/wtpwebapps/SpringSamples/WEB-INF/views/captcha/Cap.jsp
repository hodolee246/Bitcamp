<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://www.google.com/recaptcha/api.js" async="true"></script>
</head>
<body>

<form action="#" method="POST" onsubmit="return validate();">
   		<div class="g-recaptcha" data-sitekey="6Le--bgUAAAAAIFyv08T4wB-LR58tiPScezTeyD2"></div>
   		
   		<input type="submit" value="Submit" />
</form>

<script type="text/javascript">
function validate() {
   if (grecaptcha.getResponse() == "") {
      alert('reCAPTCHA 인증 후 진행해주세요.');
      return false;
   }
   
   return true;
}
</script>


</body>
</html>