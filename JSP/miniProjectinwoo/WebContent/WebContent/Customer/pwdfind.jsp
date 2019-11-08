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

#id, #phone, #pwdbtn{
	width: 100%;
	height: 50px;
	margin-bottom: 30px;
}
#pwd{
	width: 100%;
	height: 50px;
}
#cernum{
	width: 100%;
	height: 50px;
}
#cernumbtn{
	width: 30%;
	height: 30px;
	margin-bottom: 30px;
}

</style>

</head>

<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>

	<div align="center">
	  <form action="" id="frm">
	  	<input type="hidden" name="command" value="pwdchange">
	  	<table>
	  		<tr>
	  			<td>
	  				<h1 class="allfont">비밀번호찾기</h1>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<input type="text" placeholder="id 입력" id="id" name="id">
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
	  				<input type="text" placeholder="인증번호" id="cernum" name="cernum">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<input type="button" value="인증번호 받기" class="btn btn-default" id="cernumbtn">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<input type="password" placeholder="바꾸실비밀번호" id="pwd" name="pwd">
	  			</td>
  			</tr>
  			<tr>
	  			<td>
	  				<font color="red">8~15자리의 특수,영문+숫자로 등록해주십시오( ~!@\#$%><^&* 만 지원합니다. )</font>
	  			</td>
  			</tr>
	  		<tr>
	  			<td>
	  				<input type="button" value="비밀번호 바꾸기" class="btn btn-default" id="pwdbtn">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<h4 id="number"></h4>
	  			</td>
	  		</tr>
	  	</table>
	   </form>
	  </div>

</main>
 
<jsp:include page="../footer.jsp" flush="false"/>


<script type="text/javascript">

var cer = false; // 인증을 했는지 안했는지 변수

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

function randomRange() { // 인증번호 생성
	  return Math.floor( (Math.random() * (9999 - 1000 + 1)) + 1000 );
}

var number = randomRange()+"";

$(document).ready(function() {
	
	
	
	$("#cernumbtn").click(function() {
		
		if($("#id").val().trim() == ""){
			
			alert("ID를 입력하세요");
			
		}else if($("#phone").val().trim().length != 11){
			
			alert("전화번호를 입력하세요");
			
		}else{
			
			$.ajax({
				//이동할때 필요한것
				url: "customer_servlet",		//가야할곳
				type: "get",			//get/post
				data: "command=idandphone&id=" + $("#id").val().trim() + "&phone=" + $("#phone").val().trim(),//Parameter(넘겨주는 값)
				////////////////////////////////////////////////////
				
				//통신후 결과
				success:function(data, status, xhr){
					//alert(data);
					//$("#idcheckout").text(data.trim());
					
					if(data == "true"){
						cer = true;
						
						$("#number").text(number);
						
					}else{
						check = false;
						alert("아이디와 폰번호가 일치하는 아이디가 없습니다.");
					}
					 
				},
				error:function(xhr, status, error){
					alert("통신실패");
				}
			});
			
		}
		
	});
	
	$("#pwdbtn").click(function() {
		
		var cernum = $("#cernum").val().trim();
		
		var pw = $("#pwd").val().trim();
		
		if(cer == false){
			alert("인증을 먼저 받아주세요");
		}
		else if(number.trim() != cernum){
			alert("인증번호를 정확히 입력하여 주세요");
		}		 
		else if(!pattern1.test(pw) ||!pattern2.test(pw)||!pattern3.test(pw)||pw.length<8||pw.length>15){

            alert("비밀번호는 영문+숫자+특수기호 8~15자리로 구성하여야 합니다.");
            
        }
		else{
			
			$("#frm").attr({"action":"customer_servlet", "method":"post"}).submit();
			
		}
		
	});
	 
	
});

</script>



</body>
</html>