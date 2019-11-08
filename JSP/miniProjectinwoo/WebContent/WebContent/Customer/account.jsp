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
	background-image: url("/miniProject/image/accountback.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	text-align: -webkit-center;
	width: 100%;
	height: -webkit-fill-available;
	position:relative;
}
#divid{
	width: 50%;
	height: 70%;
    position:absolute;
    margin: auto;
    left: 25%;
    top: 10%;
    background-color: rgba(255,255,255, 0.5);
}
.allfont{
  	font-family: 'Noto Sans KR', sans-serif;
  	color: gray;
}
*{
	font-family: 'Noto Sans KR', sans-serif;
}
table{
    width: 500px;
    height: 80%;
    margin: auto;
}

#pwd, #name, #address, #birthday, #phone, #email,#accountbtn{
	width: 480px;
	height: 50px;
	border: 0px;
}
#id{
	width: 415px;
	height: 50px;
	border: 0px;
}
#idcheckbtn{
	height: 50px;
	background-color: #585858;
	color: #ffffff;
}
#idcheckbtn:hover{
	background-color: #424242;
	color: #ffffff;
}
#accountbtn{
	background-color: #AD9E87;
	color: #ffffff;
}
#accountbtn:hover{
	background-color: #685F51;
	color: #ffffff;
}

</style>

</head>

<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>

<div id="divid">
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
  				<button type="button" class="btn btn-default" id="idcheckbtn">id체크</button>
  				<input type="hidden" id="idsave" value="">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<font color="red" id="idfont">7 ~ 20글자의 영문+숫자로 등록해주십시오</font>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="password" placeholder="비밀번호 입력" id="pwd" name="pwd">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<font color="red" id="pwdfont">8~15자리의 특수,영문+숫자로 등록해주십시오( ~!@\#$%&lt;&gt;^&amp;* 만 지원합니다. )</font>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="이름 입력" id="name" name="name">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<span style="opacity: 0">공간지정</span>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="주소입력" id="address" name="address" maxlength="20">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<span style="opacity: 0">공간지정</span>
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
  				<span style="opacity: 0">공간지정</span>
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
  				<span style="opacity: 0">공간지정</span>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="text" placeholder="이메일(예 : abc@naver.com)" id="email" name="email" onkeydown="fn_press_han(this);" style="ime-mode:disabled;">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<span style="opacity: 0">공간지정</span>
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

var check = false;	// 아이디체크용

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
	
	$("#id").on("propertychange change keyup paste input", function() {
				
		var id = $("#id").val().trim();
		
		if( id.length >= 7 && id.length <= 20 && pattern1.test( id ) && pattern2.test( id ) && !pattern3.test( id ) ){
			$("#idfont").css("color", "rgba(255,255,255, 0)" );
		}else {
			$("#idfont").css("color", "rgba(255,0,0, 1)" );
		}
				
	});
	
	$("#pwd").on("propertychange change keyup paste input", function() {
		
		var pwd = $("#pwd").val().trim();
		
		if( pwd.length >= 8 && pwd.length <= 15 && pattern1.test( pwd ) && pattern2.test( pwd ) && pattern3.test( pwd ) ){
			$("#pwdfont").css("color", "rgba(255,255,255, 0)" );
		}else {
			$("#pwdfont").css("color", "rgba(255,0,0, 1)" );
		}
				
	});
	
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
			
			if(confirm("입력하신 id = " + $("#idsave").val() + "로 가입하게 됩니다 가입하시겠습니까?") == true){
				
				$("#id").val( $("#idsave").val() )
				
				$("#frm").attr({"action":"customer_servlet", "method":"post"}).submit();
		    }
		    else{
		        return ;
		    }
			
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
						
						$("#idsave").val( $("#id").val().trim() );
						
						alert( $("#idsave").val() );
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