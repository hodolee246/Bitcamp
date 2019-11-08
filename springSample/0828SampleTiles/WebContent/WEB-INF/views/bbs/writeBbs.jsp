<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="writeBbs.do">
	<table>
		<tr>
			<td>ID</td>
			<td colspan="2"><input type="text" readonly="readonly" value="${login.id }" name="id"></td>
		</tr>
		<tr>
			<td>Title</td>
			<td colspan="2"><input type="text" name="title"></td>
		</tr>
		<tr>
			<td colspan="3">Content</td>
		</tr>
		<tr>
			<td colspan="3"><textarea cols="28" rows="5" name="content"></textarea></td>
		</tr>
		<tr>
			<td><button type="submit">추가</button></td>
		</tr>
	</table>
</form>
