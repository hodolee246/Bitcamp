<%@page import="dto.NoticeDto"%>
<%@page import="dao.NoticeDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스</title>

<style type="text/css">
main{
	width: 70%;
	/* height: 800px;  *//* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
	min-height: 400px;
}
.allfont{
	font-family: 'Noto Sans KR', sans-serif;
	color: gray;
}
/* 
#btn{
	margin-top: 15px;
}
 */
.div_list{
	margin-top: 50px;
}
table.type02 {
	/* 
	border-collapse: separate;
	border-spacing: 0;
	text-align: left;
	line-height: 1.0;
	border-top: 1px solid #ccc;
	border-left: 1px solid #ccc;
	 */
	margin-top: 20px;
    border-collapse: collapse;
    font-family: 'Noto Sans KR', sans-serif;
}
table.type02 th {

	/* 
	width: 150px; 
	padding: 10px;
	font-weight: bold;
	vertical-align: middle;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #fff;
	border-left: 1px solid #fff;
	background: #eee;
	text-align: center;
	*/
	padding: 20px;
	background: #D6B78D;
	text-align: center;
	color: white;
	font-size: large;
	border-bottom: 1px solid #D6B78D;
}	
table.type02 td {
	/* width: 350px; 	
	padding: 10px;
	vertical-align: middle;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	*/    
	padding: 15px;
	text-align: center;
	border-bottom: 1px solid #D6B78D;
}

#frm h2{
	padding : 20px;
	font-family: sans-serif;
}
 
</style>
</head>
<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>
<%
// 검색
String searchWord = request.getParameter("searchWord");
String choice = request.getParameter("choice");

System.out.println("검색항목:" + choice);
System.out.println("검색어:" + searchWord);

if(choice == null || choice.equals("")) {
	choice = "sel";
}

if(choice.equals("sel")){
	searchWord = "";
}
if(searchWord == null) {
	searchWord = "";
	choice = "sel";
}
%>

<%
// 페이징
String spageNumber = request.getParameter("pageNumber");
int pageNumber = 0;
if(spageNumber != null && !spageNumber.equals("") ){
	pageNumber = Integer.parseInt(spageNumber);
}
NoticeDao dao = NoticeDao.getInstance();
List<NoticeDto> list = dao.getPagingList(choice, searchWord, pageNumber);

int len = dao.getAllnotice();
int listpage = len / 10;
if(len % 10 > 0){
	listpage = listpage + 1;
}
System.out.println("총페이지수 : "+listpage);

%>
	
<div align="center" class="div_list">

	<form name="frm" id="frm">
		<input type="hidden" name="command" value="noticeDetail">
		<p style="font-family: 'Noto Sans KR', sans-serif; font-size: 50px">뉴스</p>
		<table class="type02">
		<col width="200"> <col width="500"> <col width="200">  <col width="200">
		
		<tr>
			<th>공지번호</th> <th>title</th> <th>첨부파일</th> <th>작성일</th>
		</tr>
		
		<%
		if(list == null || list.size() == 0){	//글 0개인 경우
			%>
			<tr>
				<td colspan="4" align="center">등록된 공지가 없습니다.</td>				
			</tr>
			<%
		}else {
			for(int i = 0 ; i < list.size() ; i++ ){
				NoticeDto dto = list.get(i);
				int seq = dto.getSeq();
			%>
			<tr>
				<td><%=i+1 %></td>	<!-- 페이지에 보이는 글번호-->
				
				<%
				if(dto.getDel() == 0){	// 삭제된 공지 제외하고 보여준다
				%>
					<td class="title_td" onclick="location.href='/miniProject/notice_servlet?seq=<%=dto.getSeq() %>&command=noticeDetail'">
						<%=dto.getTitle() %>			

				<%
				}else {
					%>
					<td class="title_td"><font color="#ff0000">삭제된 공지입니다.</font>
					<%
				}				
				%>			
				</td>
				<%
				if(!dto.getFilename().equals("-")){	// 첨부파일이 있으면,
					%>
					<td align="center">
						<image alt="" src="../image/file_icon.png" width="20px" height="20px">
					</td>
					<%
				}else {	//첨부파일이 없을 시
					%>
					<td align="center">-</td>
					<%
				}
				%>				
				<td align="center"><%=(dto.getWdate()).substring(0, 11) %></td>
			</tr>
			

			<%
			}
		}		
		%>
		</table>
		
		
	</form>
</div>
 <div class="text-center">
 <ul class="pagination">
 <%
for(int i = 0;i < listpage; i++){
	if(pageNumber == i){
%>
	<li><a href="#none" title="<%=i+1 %>페이지" class="pagination">[<%=i+1 %>]</a></li>
<%	}else{%>
		<li><a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)" 
		class="pagination">[<%=i+1 %>]</a></li>
<%
	}
}
%>
 
</ul>
</div>


<%-- 
<div align="center">
<%
for(int i = 0; i < listpage ; i++) {
	if(pageNumber == i) {
%>	&nbsp;
	<span style="font-size: 15pt; color: #333;">
		<%=i+1 %>
	</span>
	&nbsp;
<%}else{%>
	&nbsp;
	<span>
		<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
		style="font-size: 15pt; color: #666; margin: 0;">
		<%=i+1 %></a>
	</span>
	&nbsp;
<%
	}
}
%>
</div>

 --%>
 <div align="center" style="margin: 100px">
	<div style="height: 40px">
		<select id="choice" style="width: 100px; height: 30px">
			<option value="sel">선택</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" size="50" id="search" value="">
		<button type="button" onclick="serchNotice()">검색</button>
	</div>
</div>
</main>	

<jsp:include page="../footer.jsp" flush="false"/>

<script type="text/javascript">
function serchNotice(){
	var choice = document.getElementById("choice").value;
	var word = $("#search").val();
	
	if(word == ""){
		document.getElementById("choice").value = 'sel';
	}
	location.href = "noticeList.jsp?searchWord=" + word + "&choice=" + choice;
}

function goPage( pageNum ) {
	location.href = "noticeList.jsp?pageNumber=" + pageNum;
}

$(function () {	
	$(".title_td").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".title_td").mouseout(function() {
		$(this).css("background", "#ffffff");
	});	
});

</script>
</body>
</html>