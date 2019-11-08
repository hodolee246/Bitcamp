<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<meta charset="UTF-8">
<title>layouts-tiles</title>
<style type="text/css">
table{
	border: 1px solid gray;
	width: 100%;
	height: 100%;
}


</style>
</head>
<body>
<!-- 화면 배치용 jsp -->

<table border="1" style="border-color: gray;">
	<tr align="center">		<!-- header -->
		<td height="10%" colspan="2">
			<tiles:insertAttribute name="header" />
		</td>
	</tr>
	<tr>
		<td align="left" valign="top" width="30%">   <!-- menu -->
			<tiles:insertAttribute name="menu"/>
		</td>
		<td>	<!-- main -->
			<tiles:insertAttribute name="content"/>
		</td>
	</tr>
	<tr>	<!-- footer -->
		<td height="10%" colspan="2">
			<tiles:insertAttribute name="footer"/>
		</td>
	</tr>
</table>



</body>
</html>