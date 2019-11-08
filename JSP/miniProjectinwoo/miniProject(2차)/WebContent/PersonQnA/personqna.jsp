<%@page import="dao.PersonQnADao"%>
<%@page import="dao.iPersonQnADao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.PersonQnADto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- page 부트스트랩 -->
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- JQuery 실행할 때 필요한 작업 - 방법 3: jquery 회사 홈페이지에서 복사하는 방법 -->


<script type="text/javascript" src="./js/jquery.min.js"></script>
 
<link rel="stylesheet" href="./css/bootstrap.css">

<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean" rel="stylesheet">
<!-- 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> page 부트스트랩
 -->
<style type="text/css">

main{
	overflow: inherit;
	width: 80%;
	height: auto;
	margin: auto;
	margin-bottom: 30px;
}

ul{
   list-style:none;
   padding-left:0px;
}

#totalpage{
	overflow: inherit;
	width: 100%;
	height: auto;
	background-color: yellow;
}

#adminMenu{
	padding-top: 60px;
	padding-left: 30px;
	width: 16%;
	height: auto;
	float: left;
	background-color: gray;
}

#adminMain{
	width: 84%;
	height: auto;
	float: left;
	text-align: right;
	/* background-color: lightgray; */
}

.tb{
	margin-top: 20px;
	margin-left: 145px;
    border-collapse: collapse;
    font-family: 'Noto Sans KR', sans-serif;
}

.tb th{
	padding: 20px;
	background: #D6B78D;
	text-align: center;
	color: white;
}
.tb th, .tb td{
	border-bottom: 1px solid #D6B78D;
}

textarea{
	border-color: #D6B78D;
} 

#comm, #str{
	margin-top: 7px;
	margin-bottom: 7px;
	border-color: #D6B78D;
}

#comm{
	padding-left: 5px;
	text-align: left;
	padding-top: 7px;
}

#comments{
	margin-top: 7px;
}

#titles{
	padding-left: 8px;
	padding-right: 8px;
}

#contents{
	background: #F2EBD7;
}

#searchBtn {
	margin-bottom: 4.5px;
	padding-left: 12px;
	padding-right: 12px;
	padding-top: 0px;
	padding-bottom: 2px;
	height: 26px;
}

.trfoot{
	padding-top: 20px;
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

.allMenu{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1.3em;
}

.my.pagination > .active > a, 
.my.pagination > .active > span, 
.my.pagination > .active > a:hover, 
.my.pagination > .active > span:hover, 
.my.pagination > .active > a:focus, 
.my.pagination > .active > span:focus {
  background: #D6B78D;
  border-color: #D6B78D;
}
	
</style>

</head>

<body>

<jsp:include page="../header.jsp" flush="false"/>


<main>
<div id="totalpage">
	<div id="adminMenu">
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
		</ul> -->
		<jsp:include page="../adminMenu.jsp" flush="false"/>
	</div>

	</div>
	
	<div id="adminMain">
		<h2 align="center" style="font-family: 'Noto Sans KR', sans-serif">고객의소리 List</h2>
	
		<c:if test="${empty choice }">
			<c:set var="choice" value=""/>
			<c:set var="str" value=""/>
		</c:if>
		
		<%
		int count = (Integer)request.getAttribute("count");
		
		System.out.println("글의 총 갯수 : " + count);
		
		int pageCount = 0; 	// 페이지 수
		int pageSize = 5;	// 한 페이지당 글의 갯수
		
		int pageNum = 1;	// 선택한 페이지 번호. 초기값 1
		%>
		
		<c:if test="${not empty pageNum }">
			<c:set var="pageNum" value="${pageNum }" />
		</c:if>
		
		<%
		// 페이지 수 = 글의 총 갯수 / 한 페이지당 글의 갯수
		pageCount = count / pageSize;
		// 나머지가 있으면 +1
		if(count % pageSize > 0){
			pageCount++;
		}
		System.out.println("페이지 수 : " + pageCount);
		%>
		
		<form id="frm">
		<table class="tb">
		<col width="80"><col width="110"><col width="120"><col width="400"><col width="120"><col width="150">
		<tr>
			<th>NO</th><th>CATEGORY</th><th>ID</th><th>TITLE</th><th>DATE</th><th>COMMENT</th>
		</tr>
		
		<c:if test="${empty list }">
			<tr>
				<td colspan="6" align="center">작성된 글이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:if test="${not empty list }">
			<c:forEach var="m" items="${list }" varStatus="i">
				<tr>
					<td align="center">${i.index + 1}</td>
					<td align="center">${m.question_type }</td>
					<td align="center">${m.id }</td>
					<td align="left" id="titles" class="title${i.index + 1}" 
									 onmouseover="bgchange(${i.index + 1})" onmouseout="bgout(${i.index + 1})" onclick="showForm(${i.index + 1})">
						<input type="hidden" name="seq" class="seq${i.index + 1}" value="${m.seq }">
							${m.title }
					</td>
					<td align="center">${fn:substring(m.wdate, 0, 19)}</td>
					<td align="center">
						<c:if test="${m.answer_check eq 0 }">
							답변대기중
						</c:if>
					
						<c:if test="${m.answer_check ne 0 }">
							답변완료
						</c:if>
					</td>
				</tr>
			
				<tr id="contents" class="cls${i.index + 1}" style="display: none">
					<td colspan="6" align="center" width="200px" height="100px" style="padding-left: 30px; padding-right: 30px;">
						${m.content }
					</td>
					
				</tr>
					
				<tr class="cls${i.index + 1}" style="display: none">
					<td></td><td></td>
					<td style="text-align: right; padding-bottom: 62px">COMMENTS</td>
					<td id="comm" colspan="3">
						<textarea rows="4" cols="65" id="comments" name="comments" class="getcls${i.index + 1}" style="text-align: left;">${m.comments }</textarea>
						<input type="button" value="등록" id="commentsBtn${i.index + 1}" class="btn btn-warning" style="margin-bottom: 24px;" onclick="writeComments(${i.index + 1})">
					</td>
				</tr>
				
			</c:forEach>
		
		</c:if>
		
			<tr align="center" class="trfoot">
				<td colspan="6">
				<c:forEach begin="1" end="<%=pageCount %>" step="1" varStatus="i">
					<c:if test="${pageNum eq i.index }">
						<ul class="pagination pagination-sm justify-content-center pagination my">
							<li class="page-item active color:red"><a class="page-link">${i.index }</a></li>
						</ul>
					</c:if>
					
					<c:if test="${pageNum ne i.index }">
						<ul class="pagination pagination-sm justify-content-center">
							<li class="page-item"><a class="page-link" href="admin_servlet?command=qnalist&choice=${choice}&str=${str}&pageNum=${i.index}">${i.index}</a></li>
						</ul>
					</c:if>
				
				</c:forEach>
				
				</td>
			</tr>
			<tr align="center" class="trfoot">
				<td colspan="6">
					<select id="choice" name="choice">
						<option value="ID" selected="selected">ID</option>
						<option value="문의 유형">문의 유형</option>
					</select>
					
					<input type="text" id="str" name="str" placeholder="검색" value="${str }">
					<input type="button" value="검색" id="searchBtn" class="btn btn-warning" onclick="searchList()">
				</td>
			</tr>
		
		</table>
		
		</form>
		<br><br>
		
		<script type="text/javascript">
		// 선택한 title에 답변을 달아주는 폼 보여주기
		function showForm( i ) {
			if($(".cls" + i).is(":visible") == false){
				$(".cls" + i).css("display", "");
			}
			else{
				$(".cls" + i).css("display", "none");
			}
			 
		}
		
		// 답변을 단 게시글의 seq와 작성한 comments를 넘겨주기
		function writeComments( i ) {
			var seq = $(".seq" + i).val();
			var comments = $(".getcls"+i).val();
		
			if(comments == ""){
				alert("답변을 작성해주십시오.");
				$(".getcls"+i).focus();
				return;
			}
			else{
				location.href = "admin_servlet?command=qnaupdate&comments=" + comments + "&seq=" + seq + "&pageNum=${pageNum}";
			}
		}
		
		function searchList() {
			var choice = $("#choice").val();
			var search = $("#str").val();
			
			if(search == ""){
				choice = "";
				search = "";
			}
			location.href = "admin_servlet?command=qnalist&choice=" + choice + "&str=" + search + "&pageNum=1";
			
		}
		
		function bgchange(i) {
			$(".title" + i).css("background-color", "#EFE1BA");
		}
		
		function bgout(i) {
			$(".title" + i).css("background-color", "");
		}
		
		</script>	
		
	
	</div>

</div>
<!-- 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script> page 부트스트랩
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> page 부트스트랩
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> page 부트스트랩
 -->
</main>


<jsp:include page="../footer.jsp" flush="false"/>





</body>
</html>