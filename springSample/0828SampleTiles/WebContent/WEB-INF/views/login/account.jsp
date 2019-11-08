<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<form action="account.do" method="post">
	<table>
		<tr>
			<td>
				<input type="text" placeholder="ID" id="_id" name="id">
				<input type="button" id="checking" value="ID check">
			</td>
		</tr>
		<tr>
			<td>
				<input type="password" placeholder="PWD" name="pwd" id="_pwd">
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" placeholder="name" name="name" id="_name"> 
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" placeholder="email" name="email" id="_email">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="회원가입" id="account" >
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">

$(document).ready(function () {
	$("#checking").click(function () {

		$.ajax({
			url:"idcheck.do",					// 넘기는 단어
			type:"get",							// 방식
			data:"id=" + $("#_id").val(),	// 넘길 데이터
			success:function(data){
			//	alert("success");
				alert(data);
				if(data)
				$("#account").removeAttr("disabled");
			},
			error:function(req, status, error){
				alert("error");
			}
		});
		
		
	}); 
});



</script>
