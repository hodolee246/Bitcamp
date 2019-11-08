<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%--
	<%! function, variable(전역) %>
	
	<% 소스코드 %> 이 2개의 영역이 script + applet 해서 scriptlet(java영역)
	이라고 불린다.
	jsp(html + java)
	<%=value %> 이런식으로 value 변수 문자열 등 다 집어넣을 수 있지만
	이걸 조금더 보기 쉽게 하려고 한 것이 EL 태그이다. 하지만
	100% 보완된 것이 아니기에 사용하고 싶은걸 사용하면 된다.
	
	EL(값) + Core(제어문) => Java
	
	EL = Expression Language = EL
		  표현(식)	    언어
	
	EL 종류는 여러개가 있다. 그러한 EL 태그를 알아야 Core Tag, JSP tag를
	같이 사용할 수 있다.
	
	JSRL(Java server page Standard Tag Language)
		  
 --%>
 
 	<%
 		String str = "hello";
 		request.setAttribute("_str", str);
 	%>
 	
 	<%
 		String s = (String)request.getAttribute("_str");	
 	%>
 	<%
 		out.println("s = " + s);
 	%>
	<br><br>
	<!-- jsp -->
	s= <%=s %>
	<br><br>
	
	<!-- EL -->

s = ${ _str }

<%='값' %>
<br>
${'값' }	<!-- 문자열 값이 출력된다. -->
<br>
<!-- 연산식도 가능하다. -->
<%=2+3 %>	
<br>
${2+3}	<!-- 연산식 이기에 5가 출력된다. -->
<br>
<!-- 3항 연산자도 가능하다 3항연산자 value > value?true:false-->
${3>2?100:200}
<br>
<%
request.setAttribute("data", "안녕");
%>
<!-- EL태그 사용규칙 setAttribute를 사용해야한다. -->
${data }

<br>
변수(Object)의 data가 있는지?(null?)
<br>
<!-- data(setattr로 설정한 data임)가 null 일경우 ->true 값이 뜬다. -->
data = ${empty data }
<br>
data = ${not empty data} <!-- null 이 아닐때 --> 
<br>
1 < 9 : ${1<9 } <!-- 논리 연산을 할경우 이것도 true or false 값이 뜬다. -->
<br>
2 + 3 : ${2 + 3 }	<!-- 이것은 계산식으로 인식으로 해서 5(value) 가 출력된다. -->

<%/* setAttribute 에는 Integer 는 들어가지 못한다. */
Integer a, b; 	
a = 10;
b = 3;
request.setAttribute("_a", a);
request.setAttribute("_b", b);

boolean c;
c = false;
request.setAttribute("_c", c);

%>
<pre>

a:${_a }	<!-- a의 -->
b:${_b }	<!-- b의 -->
c:${_c }	<!-- c의 값이 나온다 -->

a+b:${_a+_b }	<!-- 이렇게 하면 연산식이 나온다. -->

eq:${_a eq _b }	<!-- 이것도 논리식으로 나온다. -->
==:${_a == _b }	


ne:${_a ne _b }	<!--a != b-->
ne:${_a != _b }

gt:${_a gt _b }	<!--a > b-->
gt:${_a > _b }

lt:${_a lt _b }	<!--a < b-->
lt:${_a < _b }

le:${_a le _b }	<!--a <= b-->
ge:${_a ge _b }	<!--a >= b-->

div:${_a div _b } <!-- _a / b -->

mod:${_a mod _b }<!-- a % _b -->

c:${!_c }	<!-- _c == false 이기에 부정을 붙이면 true 가 나온다. -->

${_a == 10 && !_c }	<!-- true && ture 이기에 true 가 나온다. -->

</pre>
<br>

<%
MemberDto mem = new MemberDto();
mem.setMessage("Hello EL");

request.setAttribute("_mem", mem);
%>

<%=mem.getMessage()%>
<br><br>
${_mem.message }
<br><br>

<%
String array[] = {"Hello", "World"};

request.setAttribute("_array", array);
%>

<%=array[0] %>
<br>
<br>
${_array[1] }
<br>
<br>
<%
List<String> list = new ArrayList<>();
list.add("world");
list.add("EL");

request.setAttribute("_list", list);

%>
<%=list.get(0) %>	 <!-- wolrd가 나온다 -->
<br>
${_list[1]}		<!-- EL이 나온다 -->		
<br><br>
<%
List<MemberDto> memlist = new ArrayList<>();
MemberDto m = new MemberDto();
m.setMessage("메세지 one");
memlist.add(m);
%>
<br>
<%
m = new MemberDto();
m.setMessage("메세지 two");
memlist.add(m);
%>
<br>
<%
request.setAttribute("_memlist", memlist);
%>
<br>
<%=memlist.get(0).getMessage() %>
<br>
${_memlist[0].message }

<%
HashMap<String, String> map = new HashMap();

map.put("apple", "사과");
map.put("grape", "포도");

request.setAttribute("_map", map);
%>
${_map.apple }	<!-- 사과가 나온다 -->
<br>
${_map.grape }	<!-- 포도가 나온다. -->
<br>
${_map["apple"] }	<!-- 사과가 나온다 index 대신 문자열이 들어간거다 -->
</body>
</html>