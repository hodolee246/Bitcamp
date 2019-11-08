<%@page import="dto.CustomerDto"%>
<%@page import="dto.NoticeDto"%>
<%@page import="dao.NoticeDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지게시판 관리</title>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->

<style type="text/css">
main{
overflow : inherit;
	width: 80%;
	height: auto; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
	min-height: 400px;
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
#totalpage{
	overflow: inherit;
	width: 100%;
	height: auto;
}

#adminMenu{
	padding-top: 60px;
	padding-left: 30px;
	width: 16%;
	height: auto;
	float: left;
	background-color: gray;
}

#adminMain {
	width: 84%;
	height: auto;
	float: left;
	text-align: right;
	/* background-color: lightgray; */
}
#adminNoticeadd {
	width: 84%;
	height: auto;
	float: left;
	text-align: right;
}

.allMenu{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1.3em;
  	color: red;

}
.hide1 { 
	display: none;
} 
table.type1 {
  /*  border-collapse: separate;
   border-spacing: 0;
   text-align: left;
   line-height: 1.0;
   border-top: 1px solid #ccc;
   border-left: 1px solid #ccc;
   margin : 20px 50px; */
   margin-top: 20px;
    margin-left: 145px;
    border-collapse: collapse;
    font-family: 'Noto Sans KR', sans-serif;
}
.type1{
	margin-top: 20px;
	margin-left: 145px;
    border-collapse: collapse;
    font-family: 'Noto Sans KR', sans-serif;
}
.type1 th{
	padding: 20px;
	background: #D6B78D;
	text-align: center;
	color: white;
}
.type1 th, .type1 td{
	border-bottom: 1px solid #D6B78D;
}
.type1 td{
	padding: 5px 5px;
}

table.type1 th {
   /*
   padding: 10px;
   font-weight: bold;
   vertical-align: center;
   border-right: 1px solid #ccc;
   border-bottom: 1px solid #ccc;
   border-top: 1px solid #fff;
   border-left: 1px solid #fff;
   background: #eee;
   text-align: center;
    */
}	
table.type1 td {
/* 
  
   padding: 10px;
   vertical-align: center;
   border-right: 1px solid #ccc;
   border-bottom: 1px solid #ccc;
   background : #ffffff;
    */
}



</style>
</head>
<body>
<jsp:include page="../header.jsp" flush="false"/>
<main>

<div id="totalpage">
	<div id="adminMenu">
<!-- 		<ul class="menu">
			<li><a href="AdminMainPage.jsp" class="fatag">메인으로</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=" class="fatag">회원 관리</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=roomadmin" class="fatag">객실정보 관리</a>
				↓ 객실정보 등록/수정/삭제 메뉴바에서 삭제 고려중입니다
				<ul class="menu"><br>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 등록</a></li>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 수정</a></li>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 삭제</a></li><br>
				</ul>
			</li>
			<li><a href="/miniProject/admin_servlet?command=" class="fatag">예약 관리</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=qnalist&choice=&str=&pageNum=1" class="fatag">고객의소리 관리</a></li>
		</ul>
-->
		<jsp:include page="../adminMenu.jsp" flush="false"/>
	</div>

	</div>
	
	<div id="adminMain">
		<%
		// 검색
		String searchWord = request.getParameter("searchWord");
		String choice = request.getParameter("choice");
		
		//System.out.println("검색항목:" + choice);
		//System.out.println("검색어:" + searchWord);
		
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
		//System.out.println("총페이지수 : "+listpage);
		
		%>
		
		<!-- 공지리스트 form -->
		<h2 align="center" style="font-family: 'Noto Sans KR', sans-serif; margin-left: 145px;">공지내역</h2>
		<div align="center">
			<form name="listfrm" action="/miniProject/notice_servlet" onsubmit="return delsubmit()">
				<input type="hidden" name="command" value="delNotice">
		
				<table class="type1">		
				<col width="100" class="hide1">
				<col width="80"> <col width="600"> <col width="200">  <col width="120">
				<thead>
					<tr>
						<td align="left" colspan="5" style="background : #ffffff;">
							<button type="button" id="delBtn">공지삭제</button>
							<input class="hide1" type="submit" value="선택한 공지 삭제">
						</td>
					</tr>
				
				<tr>
					<th class="hide1">
						<div class="allCheck">	
							<label for="allCheck">선택</label>						
							<input type="checkbox" name="allCheck" id="allCheck">
							<script> 	// 전체선택-전체해제
							$("#allCheck").click(function(){
								 var chk = $("#allCheck").prop("checked");
								 
								 if(chk) {
								  $(".chBox").prop("checked", true);
								 } else {
								  $(".chBox").prop("checked", false);
								 }
							});
							</script>
							
							</div>		
						</th>
						<th>NO</th> <th>TITLE</th> <th>FILE</th> <th>DATE</th>
					</tr>
					
				<%
				if(list == null || list.size() == 0){	// 공지글 0개인 경우
					%>
					<tr>
						<td colspan="4">등록된 공지가 없습니다.</td>	
					</tr>
					<%
				}else { // 공지글 1개 이상			
					for(int i = 0 ; i < list.size() ; i++ ){
						NoticeDto dto = list.get(i);
					%>
					<tr>
						<th class="hide1">
							<input type="checkbox" name="chBox" class="chBox" value="<%=dto.getSeq() %>">
						</th>
						<td align="center"><%=i+1 %></td>
						
						<%
						if(dto.getDel() == 0){	// 삭제되지 않은 공지 표기
						%>
							<td class="title_td" onclick="showContent(<%=i %>)">
								<input type="hidden" name="seq" class="seq<%=i %>" value="<%=dto.getSeq() %>">
								<%=dto.getTitle() %>
						<%
						}else {	// 삭제된 공지 표기
							%>
							<td><font color="#ff0000">[삭제된 공지]&nbsp;<%=dto.getTitle() %></font>
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
						<td align="center"><%=dto.getWdate().substring(0, 16) %></td>
					</tr>		
				
					<!-- 타이틀 클릭시 나타나는 내용창 -->
					<tr class="cls<%=i %>" style="display: none;">
						<td colspan="5" align="center">
							<%=dto.getContent() %>
							
							<%-- <textarea style="width:100%;" name="content" class="getcls<%=i %>" readonly="readonly"></textarea> --%>
							<a href="/miniProject/notice_servlet?seq=<%=dto.getSeq() %>&command=noticeDetail_amd"><b>공지수정</b></a>
						</td>
					</tr>

					<%
					} //for문 끝
					%>
					<tr align="center">
					<td colspan="5">					
					<%
					for(int i = 0; i < listpage ; i++) {
						if(pageNumber == i) {
					%>	
						
							<a style="color: #333; margin: 0; margin-left: 10px; margin-right: 10px;"><%=i+1 %></a>
						
						
					<%}else{%>
						
						
							<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
							style="color: #666; margin: 0; margin-left: 10px;margin-right: 10px;">
							<%=i+1 %></a>
						
						
					<%
						}
					}
					%>
					</td>
					</tr>
					<tr align="center" style="padding: 10px;">
						<td colspan="5">
							<select id="choice" style="width: 100px; height: 30px">
								<option value="sel">선택</option>
								<option value="title">제목</option>
								<option value="content">내용</option>
							</select>
							<input type="text" size="50" id="search" value="">
							<button type="button" onclick="serchNotice()">검색</button>
							<button type="button" onclick="changeDisplay()">공지추가</button>			
						</td>
					</tr>				
					<%
				}		
				%>

				</table>
			</form>
		</div>
		
		<div id="add_div" align="center" style="display: none; margin-bottom: 30px">			
			
			<h2 style="font-family: 'Noto Sans KR', sans-serif; margin-left: 145px;">공지 추가</h2>	
			
			<form action="/miniProject/notice_servlet" method="post" enctype="multipart/form-data"
					onsubmit="return submitcheck()">
				
				<table class="type1">
				<col width="100"><col width="400">
					
				<tr>
					<th>작성자</th>
					<td><%CustomerDto user = (CustomerDto)session.getAttribute("login");%>
						<input type="text" name="id" value="<%=user.getId() %>" readonly="readonly" size="50">
						 <!-- <input type="hidden" name="id" value="demoID"> user.getId() -->
					</td>
				</tr>
				
				<tr>
					<th>TITLE</th>
					<td>
						<input type="text" name="title" placeholder="Title" size="50" value="">
					</td>
				</tr>
				
				<tr>
					<th>파일등록</th>
					<td>
						<input type="file" name="fileload" style="width: 400px">	<!-- 주의! type을 text로 잡는건 무조건 String 으로 받고 file type은 Byte로 받아간다. (request.get..) -->
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="20" cols="70" name="content" id="content" value="" style="resize: none;"></textarea>
					</td>
				</tr>
						
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="작성완료" id="btn">
					</td>
				</tr>		
				</table>
			
			</form>	
		</div>		
	</div>
		
		<!-- 검색
		<div align="center" style="padding: 20px 20px; margin-left: 145px;">					
			<div style="height: 40px">
				<select id="choice" style="width: 100px; height: 30px">
					<option value="sel">선택</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select>
				<input type="text" size="50" id="search" value="">
				<button type="button" onclick="serchNotice()">검색</button>
				<button type="button" onclick="changeDisplay()">공지추가</button>		
			</div>
		</div>		
		 -->
		
		
		<!-- 추가 form -->
	<div id="adminNoticeadd">
		
		
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
	location.href = "notice_admin.jsp?searchWord=" + word + "&choice=" + choice;
}

function goPage( pageNum ) {
	location.href = "notice_admin.jsp?pageNumber=" + pageNum;
}

function changeDisplay() {
	if($("#add_div").is(":visible") == false){
		$("#add_div").css("display","");
	}else{
		$("#add_div").css("display","none");
	}
}

function showContent(i) {
	if($(".cls" + i).is(":visible") == false){
		$(".cls" + i).css("display","");
	}
	else {
		$(".cls" + i).css("display","none");
	}
}
$(".chBox").click(function (){	
  	$("#allCheck").prop("checked", false);  		
});

  
$(function () {		
	
	
	$(".title_td").mouseover(function() {		
		$(this).css("background", "#EFE1BA");
	});
	$(".title_td").mouseout(function() {
		$(this).css("background", "");
	});
	
	
	$("#delBtn").on("click",function(){		
		if( $(".hide1").is(":visible") == false ){
	    	$(".hide1").show();
			
	    }else {
	    	$(".hide1").hide();
	    }
	});
});

// 공지추가 submit 조건
function submitcheck() {
	if(document.frm.title.value != '' || document.frm.title.value != null
			|| document.frm.content.value != '' || document.frm.content.value != null){
		alert("공란이 존재합니다.");
		return false;
	}
	document.frm.submit();
}

// 공지삭제 submit 조건
function delsubmit() {
	var values = document.getElementsByName("chBox");
	var len = values.length;
	//alert("values(총체크박스 수 )" + len );
	
	var count = 0;
	for(var i=0; i < len ; i++){
		if(values[i].checked){
			count++;
		}
	}
	//alert("count(체크된 박스수)" + count);
	
	if(count<1) {
		alert("삭제할 데이터를 선택하세요");
		return false;
	}
	else {
		if(confirm("선택한 공지를 삭제하시겠습니까?")){
			document.frm.submit();
		}else {
			return false;
		}
	}
	
}



</script>	

</body>
</html>