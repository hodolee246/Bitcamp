<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 로그인 된경우 -->
<c:if test="${not empty login }">
${login.id }님 환영합니다.
<table border="1" style="background-color: gray">
<col width="200">
	<tr>
		<td>
			<a href="bbslist.do">글 목록</a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="writeBbsPage.do">글 작성</a>
		</td>
	</tr>
</table>
</c:if>
<!-- 로그인 안된경우(세션만료) -->
<c:if test="${empty login }">
	<form action="login.do" method=get>
		<table border="1">
		<col width="200">
			<tr>
				<td>
					아이디
				</td>
				<td>
					<input type="text" name="id" size="20">
				</td>
			</tr>
			<tr>
				<td>
					비밀번호
				</td>
				<td>
					<input type="password" name="pwd" size="20">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="log-in">
				</td>
			</tr>
		</table>
		<a href="accountPage.do">회원가입</a>
	</form>
</c:if>