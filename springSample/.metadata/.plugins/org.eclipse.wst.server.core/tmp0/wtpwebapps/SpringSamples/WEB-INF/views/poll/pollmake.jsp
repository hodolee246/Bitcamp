<%@page import="bit.com.a.util.calendar"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Calendar cal = Calendar.getInstance();

int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;	// 0부터 11까지임으로 +1 해준다.
int tday = cal.get(Calendar.DATE);
%>

<form action="pollmakeAf.do" method="post">
	<table class="list_table" style="width: 85%">
		<colgroup>
			<col width="200px"><col width="500px">
		</colgroup>
		<tr>
			<th>아이디</th>
			<td style="text-align: left">
				${login.id }<input type="hidden" name="id" value="${login.id }">
			</td>
		</tr>
		<tr>
			<th>투표기한</th>
			<td style="text-align: left">
				<select name="syear">
					<%
					for(int i = tyear; i < tyear + 6; i++){
						%>
						<option <%=(tyear + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>"><%=i %></option>
						<%
					}
					%>
				</select>년
				
				<select name="smonth">
					<%
					for(int i = 1; i < 13; i++){
						%>
						<option <%=(tmonth + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>"><%=i %></option>
						<%
					}
					%>
				</select>월
				
				<select name="sday">
					<%
						// 매달 몇일 있는지 구분해서 만들어준다
					for(int i = 1; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
						%>
						<option <%=(tday + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>"><%=i %></option>
						<%
					}
					%>
				</select>일
				~
				<select name="eyear">
					<%
					for(int i = tyear; i < tyear + 6; i++){
						%>
						<option <%=(tyear + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>"><%=i %></option>
						<%
					}
					%>
				</select>년
				
				<select name="emonth">
					<%
					for(int i = 1; i < 13; i++){
						%>
						<option <%=(tmonth + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>"><%=i %></option>
						<%
					}
					%>
				</select>월
				<select name="eday">
					<%
						// 매달 몇일 있는지 구분해서 만들어준다
					for(int i = 1; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
						%>
						<option <%=(tday + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>"><%=i %></option>
						<%
					}
					%>
				</select>일
			</td>
		</tr>
		<tr>
			<th>투표내용</th>
			<td style="text-align: left">
				<textarea rows="10" cols="50" name="question"></textarea>
			</td>
		</tr>
		<tr>
			<th>투표문항수</th>
			<td style="text-align: left">
				<select name="itemcount" onchange="pollchange(this)">
					<%
					for(int i = 2; i < 11; i++){
						%>
						<option <%=(4+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
						<%
					}
					%>
				</select>개
			</td>
		</tr>
		<tr>
			<th>투표 상세 문항</th>
			<td style="text-align: left">
				<%
				for(int i = 1; i < 11; i++){
					%>
					<div id="poll<%=i%>">
						<%=(i+"") %>번:<input type="text" name="poll<%=i%>" size="60"><br>
						
					</div>
					<%
				}
				%>
			</td>
		</tr>	
		<tr>
			<td colspan="2">
				<input type="submit" value="투표만들기">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">
$(document).ready(function () {
	for(i = 5; i < 11; i++){
		$("#poll" + i).hide();
	}
});

function pollchange( my ) { // 보기 갯수 갱신
	
	var num = my.options[my.selectedIndex].value;
//	alert("num:" + num);
	
	for(i = 1; i < 11; i++){	// 초기화식
		$("#poll" + i).val("");
		$("#poll" + i).hide();
	}
		// num이 정확히 int 가아니라 num +1 할경우 오류난다.
	for(i = 1; i <= num; i++){	// 보기 갯수에 맞춰서 다시 보이게
		$("#poll" + i).show();
	}
	
}
</script>
