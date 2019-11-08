<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">

main{
	width: 70%;
	 height: 500px;/* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}
.allfont{
  	font-family: 'Noto Sans KR', sans-serif;
  	color: gray;
}
table{
    width: 70%;
    /* height: 200px; */
    /* border: 1px solid; */
}
tr, td, th{
	/* border: 1px solid; */
}
#id, #pwd, #loginbtn, #pwdfindbtn{
	width: 100%;
	height: 50px;
}
#accountbtn{
	width: 100%;
	height: 230px;
}

</style>

</head>

<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>

	<div align="center">
	  <form action="" id="frm">
	  	<input type="hidden" name="command" value="login">
	  	<table>
	  		<tr>
	  			<td colspan="2">
	  				<h1 class="allfont">로그인</h1>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<input type="text" placeholder="id 입력" id="id" name="id">
	  			</td>
	  			<td rowspan="5">
	  				<a href="/miniProject/customer_servlet?command=account"><button type="button" class="btn btn-default" id="accountbtn">회원가입</button></a>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<input type="password" placeholder="비빌번호 입력" id="pwd" name="pwd">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<input type="checkbox" name="idcheck" id="chk_save_id">id 저장
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<input type="button" value="로그인" class="btn btn-default" id="loginbtn">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<a href="/miniProject/customer_servlet?command=pwdfind"><input type="button" value="비밀번호 찾기" class="btn btn-default" id="pwdfindbtn"></a>
	  			</td>
	  		</tr>
	  	</table>
	   </form>
	  </div>

</main>
 
<jsp:include page="../footer.jsp" flush="false"/>


<script type="text/javascript">


$(document).ready(function() {

	
	$("#loginbtn").click(function() { // 로그인 버튼 누를때
		 
		if( $("#id").val().trim() == "" ){
			alert("id를 입력해주십시오");
			$("#id").focus();
		}
		else if( $("#pwd").val().trim() == "" ){
			alert("password를 입력해주십시오");
			$("#pwd").focus();
		}
		else{
			$("#frm").attr({"action":"/miniProject/customer_servlet", "method":"post"}).submit();
		}
		
	});
	 
	var user_id = $.cookie("user_id");
	
	if( user_id != null){ // 지정한 쿠키가 있을때
		//alert("쿠키 있음");	
		$("#id").val( user_id );
		$("#chk_save_id").attr("checked", "checked");
	}

	$("#chk_save_id").click(function() {
		if( $("#chk_save_id").is(":checked") ){ // 체크되었을떄
			//alert("체크됌");
			if($("#id").val().trim() == ""){
				alert("id를 입력해주십시오");
				$("#chk_save_id").prop("checked", false);
			}else{ //정상기입 한경우
				$.cookie("user_id", $("#id").val().trim(), {expires:7, path:'/'}); // 쿠키를 사용하고 7일간 저장 (expires:저장기간 path:모든경로 ?)
			}
		}else{ // 체크 해제되었을때
			//alert("체크 없어짐");
			$.removeCookie("user_id", {path:'/'}); // 기한을 없애면서 삭제가 된다.
		}
		
	}); 
});

</script>



</body>
</html>