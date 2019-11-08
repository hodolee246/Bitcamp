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
	/* height: 800px;  *//* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}
.allfont{
  	font-family: 'Noto Sans KR', sans-serif;
  	color: gray;
}
table{
    width: 70%;
}

#id, #pwd, #name, #address, #birthday, #phone, #email,#accountbtn{
	width: 100%;
	height: 50px;
}
#idcheckbtn{
	height: 50px;
}

</style>

</head>

<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>

<div align="center">
  <form action="" id="frm">
  	<input type="hidden" name="command" value="custaccount">
  	<table>
  		<tr>
  			<td colspan="2">
  				<h1 class="allfont">회원가입</h1>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="id 입력" id="id" name="id" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  			<td>
  				<button type="button" class="btn btn-default" id="idcheckbtn">id체크</button>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<font color="red">7자 이상의 영문+숫자로 등록해주십시오</font>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="password" placeholder="비빌번호 입력" id="pwd" name="pwd">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<font color="red">8~15자리의 특수,영문+숫자로 등록해주십시오( ~!@\#$%><^&* 만 지원합니다. )</font>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="이름 입력" id="name" name="name">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="주소입력" id="address" name="address">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="생년월일(예 : 19920305)" id="birthday" name="birthday" maxlength="8"
  				 onkeypress="return fn_press(event,'numbers');" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="전화번호(예 : 01012345678)" id="phone" name="phone" maxlength="11"
  				 onkeypress="return fn_press(event,'numbers');" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="이메일(예 : abc@naver.com)" id="email" name="email" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="button" value="회원가입하기" class="btn btn-default" id="accountbtn">
  			</td>
  		</tr>
  	</table>
   </form>
  </div>

</main>

<jsp:include page="../footer.jsp" flush="false"/>

<script type="text/javascript">
var check = true;	// 아이디체크용

var pattern1 = /[0-9]/;	//숫자패턴용

var pattern2 = /[a-zA-Z]/; // 영어패턴용

var pattern3 = /[~!@\#$%<>^&*]/;     // 원하는 특수문자 추가 제거

/*숫자만 입력하게함*/
function fn_press(event, type) {
	if(type == 'numbers'){
		if((event.keyCode < 48) || (event.keyCode > 57)){
			return false;
		}
	}
}

/* 한글입력방지 */
function fn_press_han(obj) {
	if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 ||
			event.keyCode == 39 || event.keyCode == 46){
		return;
	}
	obj.value = obj.value.replace(/[\ㄱ-ㅎ ㅏ-ㅣ 가-힣]/g, "");
}

$(function () {
	
	$("#accountbtn").click(function () {
		
        var pw = $("#pwd").val().trim();
        
		if(check == false){
			
			alert("id 체크를 하세요");
			
		}else if(!pattern1.test(pw) ||!pattern2.test(pw)||!pattern3.test(pw)||pw.length<8||pw.length>15){

            alert("비밀번호는 영문+숫자+특수기호 8~15자리로 구성하여야 합니다.");
            
        }else if($("#name").val().trim() == ""){
			
			alert("이름을 입력하세요");
			
		}else if($("#address").val().trim() == ""){
			
			alert("주소를 입력하세요");
			
		}else if($("#birthday").val().trim().length != 8){
			
			alert("생일을 입력하세요");
			
		}else if($("#phone").val().trim().length != 11){
			
			alert("전화번호를 입력하세요");
			
		}else if($("#email").val().trim().indexOf("@") == -1){
			
			alert("이메일 형식으로 입력해주세요");
			
		}else{
			
			$("#frm").attr({"action":"customer_servlet", "method":"post"}).submit();
			
		}
	});
	
	
	$("#idcheckbtn").click(function () {
		//alert($("#id").val().trim().length);
		
		 if($("#id").val().trim().length < 7 || !pattern1.test($("#id").val().trim())){
			
			alert("id의 길이와 형식을 맞춰서 입력해주세요");
			
		}else{  
			$.ajax({
				//이동할때 필요한것
				url: "customer_servlet",		//가야할곳
				type: "get",			//get/post
				data: "command=idcheck&id=" + $("#id").val().trim(),//Parameter(넘겨주는 값)
				////////////////////////////////////////////////////
				
				//통신후 결과
				success:function(data, status, xhr){
					//alert(data);
					//$("#idcheckout").text(data.trim());
					
					if(data == "true"){
						check = true;
						alert("이 아이디는 사용가능합니다");
					}else{
						check = false;
						alert("다른아이디를 사용하여 주십시오");
					}
					 
				},
				error:function(xhr, status, error){
					alert("통신실패");
				}
			});
		} 
		
	});
	
});

</script>



</body>
</html>