<%@page import="dto.NoticeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
NoticeDto dto = (NoticeDto)request.getAttribute("dto");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지수정</title>

<style type="text/css">
main{
overflow : inherit;
	width: 80%;
	height: auto; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}
ul{
   list-style:none;
   padding-left:0px;
}

.menu > li{
	list-style:none;
	color: #eee;
}
.menu > li > a{

	color: #eee;
}  
.menu > li > a:hover{
	list-style:none;
	color: black;
}
#adminBg {
overflow : inherit;
	width: 100%;
	height: auto;
	background-color: lightgray;
}
#adminMenu{
	width: 16%;
	height: auto;
	float: left;
	padding : 20px;
	background-color: gray;
}
#adminMain{
margin-bottom : 20px;
	width: 84%;
	height: auto;
	float: left;
	text-align: right;
	background-color: lightgray;
	
}
.allMenu{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1.3em;
  	color: red;

} 
table.type1 {
   border-collapse: separate;
   border-spacing: 0;
   text-align: left;
   line-height: 1.0;
   border-top: 1px solid #ccc;
   border-left: 1px solid #ccc;
   margin : 20px 50px;
}
table.type1 th {
   /* width: 150px; */
   padding: 10px;
   font-weight: bold;
   vertical-align: center;
   border-right: 1px solid #ccc;
   border-bottom: 1px solid #ccc;
   border-top: 1px solid #fff;
   border-left: 1px solid #fff;
   background: #eee;
   text-align: center;
}	
table.type1 td {
   /* width: 350px; */    	
   padding: 10px;
   vertical-align: center;
   border-right: 1px solid #ccc;
   border-bottom: 1px solid #ccc;
   background : #ffffff;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp" flush="false"/>

<main>

<div id="adminBg">
		<div id="adminMenu">
		<!-- 
			<ul class="menu">
				<li><a href="/miniProject/admin_servlet?command=adminpage" class="fatag">메인으로</a></li><br>
				<li><a href="admin_servlet?command=" class="fatag">회원 관리</a></li><br>
				<li><a href="admin_servlet?command=roomadmin" class="fatag">객실정보 관리</a>
					<ul class="menu">
						<li><a href="admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 등록</a></li>
						<li><a href="admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 수정</a></li>
						<li><a href="admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 삭제</a></li>
					</ul>
				</li><br>
				<li><a href="admin_servlet?command=" class="fatag">예약 관리</a></li><br>
				<li><a href="admin_servlet?command=qnalist&choice=&str=&pageNum=1" class="fatag">고객의소리 관리</a></li><br>
				<li><a href="/miniProject/notice_servlet?command=notice_adm" class="fatag">뉴스게시판 관리</a></li><br>
			</ul>
	 -->
	 	<jsp:include page="../adminMenu.jsp" flush="false"/>
		</div>
	
		<div id="adminMain">
			<h2 align="center">공지 상세 수정</h2>
			<div align="center">
			
				<form id="frm" action="/miniProject/notice_servlet" method="post" enctype="multipart/form-data"
					onsubmit="return frmsubmit()">
					<input type="hidden" name="id" value="demoID">	<%-- <%=user.getId() %> --%>
					<input type="hidden" name="seq" value="<%=dto.getSeq() %>">		
					
					
					<table class="type1">
					<col width="100"> <col width="600"> <col width="100"> <col width="200">
					<thead>
						<tr>
							<th>title</th>
							<td>
								<input type="text" maxlength="20" size="30" name="title" value="<%=dto.getTitle() %>">
								<script type="text/javascript">
								function sizelimit() {
									if()$("input[name=title]").attr("maxlength", "20")
								}	
								
									
								</script>
							</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td><%=dto.getWdate() %></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td>
								<input type="text" name="oldfile" value="<%=dto.getFilename() %>" readonly="readonly">				
							</td>
						</tr>
						<tr>
							<th>교체파일선택</th>
							<td>
								<input type="file" name="fileload" style="width: 400px">	<!-- 주의! type을 text로 잡는건 무조건 String 으로 받고 file type은 Byte로 받아간다. (request.get..) -->
							</td>
						</tr>
					</thead>
					
					<tr>
						<th></th>
						<td colspan="4">
						<textarea style="width:100%; height: 500px" name="content"><%=dto.getContent() %></textarea>
						</td>
					</tr>
					</table>
					<button type="button" onclick="location.href='./Notice/notice_admin.jsp'">뒤로</button>	
					<input type="submit" value="수정완료">
					<br><br><br>
				</form>
			</div>
		</div>
	</div>
</main>

<jsp:include page="../footer.jsp" flush="false"/>

<script type="text/javascript">
function submitcheck() {
	if(!document.frm.title.value == '' || !document.frm.content.value == ''){
		alert("공란이 존재합니다.");
		return false;
	}
	document.frm.submit();
}

</script>
</body>
</html>