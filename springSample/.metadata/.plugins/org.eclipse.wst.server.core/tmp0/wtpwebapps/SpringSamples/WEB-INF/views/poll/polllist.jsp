<%@page import="bit.com.a.util.DateUtil"%>
<%@page import="bit.com.a.model.PollDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
List<PollDto> plists = (List<PollDto>)request.getAttribute("plists");
%>

<!-- 관리자 -->
<c:if test="${login.auth eq '1'}">

	<table class="list_table" style="width: 95%">
		<col width="50"><col width="50"><col width="300"><col width="100">
		<col width="100"><col width="50"><col width="50"><col width="100">
	
		<tr>
			<th>번호</th><th>아이디</th><th>질문</th><th>시작일</th>
			<th>종료일</th><th>보기수</th><th>투표수</th><th>등록일</th>
		</tr>
		<%
			for(int i = 0; i < plists.size(); i++){
				PollDto poll = plists.get(i);
				%>
				<tr bgcolor="#aabbcc">
					<td><%=i+1 %></td>
					<td><%=poll.getId() %></td>
					<td><%=poll.getQuestion() %></td>
					<td><%=poll.getSdate() %></td>
					<td><%=poll.getEdate() %></td>
					<td><%=poll.getItemcount() %></td>
					<td><%=poll.getPolltotal() %></td>
					<td><%=poll.getRegdate() %></td>
				</tr>	
				<%
			}
		
		%>
	</table>

</c:if>

<!-- 사용자 -->
<c:if test="${login.auth eq '3'}">
	<table class="list_table" style="width: 95%">
		<col width="50"><col width="50"><col width="200"><col width="50"><col width="100">
		<col width="100"><col width="50"><col width="50"><col width="100">
	
		<tr>
			<th>번호</th><th>아이디</th><th>질문</th><th>결과</th><th>시작일</th>
			<th>종료일</th><th>보기수</th><th>투표수</th><th>등록일</th>
		</tr>
		
		<%
			for(int i = 0; i < plists.size(); i++){
				PollDto poll = plists.get(i);
			%>
			<tr bgcolor="#aabbcc">
				<td><%=i+1 %></td>
				<td><%=poll.getId() %></td>
				<%
					boolean isS = poll.isVote();
					// 투표를 못하기 위해
					if(isS || DateUtil.isEnd(poll.getEdate())){
					// 투표함 || 투표 참여기한 종료
						%>
						<td>[마감]<%=poll.getQuestion() %></td>
						<%
					}else{	// 투표를 아직 안한경우 이동할 있게끔 해준다. getpollid 는 seq 값이다
						%>
						<td>
							<a href="polldetail.do?pollid=<%=poll.getPollid()%>"><%=poll.getQuestion() %></a>
						</td>	
						<%
					}
				%>
				<td>
				<%
				if(isS || DateUtil.isEnd(poll.getEdate())){	// 투표한 경우 결과를 알려준다.
					%>
					<a href="pollresult.do?pollid=<%=poll.getPollid()%>">결과</a>
					<%
				}else{ // 그렇지 않으면 결과도 막아둔다.
					%>
					<img alt="" src="image/pen.gif">
					<%
				}
				%>
				</td>
				<td><%=poll.getSdate() %></td>
				<td><%=poll.getEdate() %></td>
				<td><%=poll.getItemcount() %></td>
				<td><%=poll.getPolltotal() %></td>
				<td><%=poll.getRegdate() %></td>
			</tr>			
			<%	
			}
		%>	
	</table>		
</c:if>

<c:if test="${login.auth eq '1' }">
	<a href="pollmake.do">투표 만들기</a>
</c:if>




