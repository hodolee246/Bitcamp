<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
	EL : 표현식(값), 비교(true/false)
	
	CORE : 제어문(for, if) -> 단독으로 사용불가 EL 태그와 같이 사용한다.
 --%>
<%
request.setAttribute("_data", "JSPL입니다.");
%>

${_data }	<!-- EL태그 JSPL이 출력된다. -->
<br>
<c:set var="_cdata" value="core JSTL입니다."></c:set>
<!-- 이것이 setAttribute 기능이다. -->
<%-- <c:set/> 이런식으로 중간에 넣을 값이 없으면 식 단축이 가능하다. --%>
${_cdata }
<br><br>

<!-- out == 내장객체 -->
<c:out value="${_cdata }"></c:out>
<!-- 실행시 출력된다. -->
<br><br>

<!-- session -->
<%
session.setAttribute("sessionData", "저장된 데이터");
%>
<c:set var="sdata" value="${sessionData }"/>
<!-- sessionData불러서 sdata 안에 저장한다. -->
<c:out value="${sdata }"/>
<!-- 저장한 sdata를 부른다 -->


<!-- if문 -->
<%
request.setAttribute("count", "10");
%>
<%
String sCount = (String)request.getAttribute("count");
int count = Integer.parseInt(sCount);
if(count >= 10){
	%>
	count:<%=count %>
	<%
}
%>
<!-- core tag if문 (else가없다)-->
<c:if test="${count >= 10 }">	<!-- 변환을 안해도 상관없다  자동으로 바꿔서 연산해준다. -->
	count:<c:out value="${count }"></c:out>		
	<!-- 출력을 할때에도 자동적으로 바꿔준다. -->
</c:if>

<br><br>

<%
request.setAttribute("name", "홍길동");
%>

<c:if test="${name eq '홍길동' }">
	이름은 홍길동 맞습니다.	<!-- true 이기에 이 문구가 출력된다. -->
</c:if>

<%
request.setAttribute("name", "일지매");
%>
<c:if test="${name == '일지매' }" var="flg"></c:if>
<!-- true false 결과 값이 flg 안으로 들어간다 -->
<br>
<c:if test="${flg }">	
	제 이름은 일지메 입니다.	<!-- true 이기에 이 문구가 출력된다. -->
</c:if>
<br><br>

<!-- for문 -->
<%
	for(int i=0; i<10; i++){
		%>
		<%=i %>
		<%
	}
%>
<br><br>
<c:forEach begin="0" end="9" step="1" varStatus="i"> 
<!-- 0부터 9까지 i를 1씩 더한다. -->
	<c:out value="${i.index }"></c:out>
		<!-- index를 안붙이면 주소값이 출력된다. -->
</c:forEach>
<br><br>
<%
List<MemberDto> list = new ArrayList<>();	/* 배열과 똑같이 사용할 수 있다. */

MemberDto mem = new MemberDto();
mem.setMessage("hi");
list.add(mem);

mem = new MemberDto();
mem.setMessage("안녕");
list.add(mem);

mem = new MemberDto();
mem.setMessage("잘가");
list.add(mem);

request.setAttribute("_list", list);
%>

<%
for(int i=0; i<list.size(); i++){
	MemberDto m = list.get(i);
}
for(MemberDto dto : list){	
}
%>

<c:forEach var="m" items="${_list }" varStatus="i">		<!-- 리스트는 아이템에 넣어준다. -->
index:<c:out value="${i.index }"/>	
<!-- 0 1 2 index number가 나온다. -->
data<c:out value="${m.message }"/><br>	
<!-- 0 1 2 의 관하여 메세지가 나온다. -->
</c:forEach>

<!-- Map -->

<%
Map<String, String> map = new HashMap<>();

map.put("apple", "사과");
map.put("pear", "배");
map.put("banana", "바나나");

request.setAttribute("_map", map);
%>


<c:forEach var="obj" items="${_map }">	<!-- obj로 넘어온다. -->
key:<c:out value="${obj.key }"/>
value:<c:out value="${obj.value }"/>
<br>
</c:forEach>

<br>









</body>
</html>













