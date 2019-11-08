<%@page import="dto.RoomDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.RoomDao"%>
<%@page import="dao.iRoomDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
iRoomDao dao = RoomDao.getInstance();

List<RoomDto> list = (List<RoomDto>)request.getAttribute("roomlist");
RoomDto dto = null;

int count;
String[] rNum;
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="./js/jquery.min.js"></script>
 
<link rel="stylesheet" href="./css/bootstrap.css">

<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean" rel="stylesheet">


<style type="text/css">

main{
	overflow: inherit;
	width: 80%;
	height: auto; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
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
	font-family: 'Noto Sans KR', sans-serif;
	
	/* background-color: yellow; */
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

#roomInfo{
	width:60%;
	height: auto;
	float: left;
	/* background-color: pink; */
}

#roomAdmin{
	width:40%;
	height: auto;
	float: left;
	/* background-color: green; */
}	

.tb{
	/* margin-top: 20px; */
	/* margin-left: 130px; */
	margin-bottom: 110px;
	
    border-collapse: collapse;
    font-family: 'Noto Sans KR', sans-serif;
}

.tb th{
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 40px;
	padding-right: 40px;
	background: #D6B78D;
	text-align: center;
	color: white;
	
}
.tb th, .tb td{
	border-bottom: 1px solid #D6B78D;
}

.tb2{
	margin-top: 143px;
	margin-bottom: 110px;
	margin-left: 10px;
    border-collapse: collapse;
    font-family: 'Noto Sans KR', sans-serif;
}

.tb2 th{
	padding-top: 15px;
	padding-bottom: 15px;
	background: #D6B78D;
	text-align: center;
	color: white;
}
.tb2 td{
	border-top: 1px solid #D6B78D;
	padding: 10px;
	text-align: left;
}

.td1{
	padding-top: 20px;
	padding-bottom: 20px;
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
  	color: red;
}

#addBtn, #updateBtn, #delBtn{
	width: 149px;
	height: 40px;
	border-color: black;
	border-radius: inherit;
	background-color: black;
}

#addRoomBtn, #updateRoomBtn, #delRoomBtn{
	width: 130px;
	height: 35px;
	border-color: black;
	border-radius: inherit;
	background-color: black;
}

#addBtn:hover, #updateBtn:hover, #delBtn:hover, #addRoomBtn:hover, #updateRoomBtn:hover, #delRoomBtn:hover{
	border-color: #5E2C00;
    background-color: #5E2C00;
    color: #ffffff;
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
	
		<div id="roomInfo" align="center">
			<h2 align="center">객실 List</h2>
			
			<form id="frm">
			<table class="tb">
			<col width="70"><col width="100"><col width="100">
			
			<tr>
				<td colspan="4" align="center" class="td1">
					<button type="button" id="addBtn" class="btn btn-success" onclick="showAddForm()">객실정보 등록</button>
					<button type="button" id="updateBtn" class="btn btn-success">객실정보 수정</button>
					<button type="button" id="delBtn" class="btn btn-success">객실정보 삭제</button>
				</td>
			</tr>
			
			<tr>
				<th></th><th>ROOM</th><th>PRICE</th><th>GRADE</th>
			</tr>
			
			<%
			if(list == null || list.size() == 0){	// 글이 없을 때
				%>
				<tr>
					<td colspan="4">객실 정보가 존재하지 않습니다.</td>
				</tr>
				<%
			}
			else{
				for(int i = 0; i < list.size(); i++){
					 dto = list.get(i);
				%>
				<tr class="tr<%=i %>" onmouseover="bgchange(<%=i %>)" onmouseout="bgout(<%=i %>)">
					<td align="center"><input type="radio" id="rooms" name="radio" value="<%=dto.getRoom_number() %>"></td>
					<td align="center"><%=dto.getRoom_number() %></td>
					<td align="center"><%=dto.getPrice() %></td>
					<td align="center"><%=dto.getGrade() %></td>
				</tr>
				<%	
				}
			}
			%>
			</table>
			</form>
		</div>
		
		<div id="roomAdmin">
			<form>
			<table class="tb2">
						
			<%-- 객실정보 등록 --%>
			<tr class="addcls" style="display: none">
				<th colspan="4" id="texts">객실정보 등록</th>
			</tr>
			<tr class="addcls" style="display: none">
				<td>객실번호</td>
				<td>
					<input type="text" id="roomNum">
				</td>
			</tr>
			<tr class="addcls" style="display: none">
				<td>가격</td>
				<td>
					<select id="roomPrice">
						<option value="none">객실가격 선택</option>
						<option value="450,000">450,000</option>
						<option value="720,000">720,000</option>
						<option value="1,200,000">1,200,000</option>
					</select>
				</td>
			</tr>
			<tr class="addcls" style="display: none">
				<td>객실등급</td>
				<td>
					<select id="roomGrade">
						<option value="none">객실등급 선택</option>
						<option value="디럭스">디럭스</option>
						<option value="프리미어">프리미어</option>
						<option value="스위트">스위트</option>
					</select>		
				</td>
			</tr>
			<tr class="addcls" style="display: none">
				<td colspan="4">
					<button type="button" id="addRoomBtn" class="btn btn-success">객실 등록</button>
				</td>
			</tr>
			
			<%-- 객실정보 수정 --%>
			<tr class="updatecls" style="display: none">
				<th colspan="4" id="texts">객실정보 수정</th>
			</tr>
			<tr class="updatecls" style="display: none">
				<td>객실번호</td>
				<td>
					<input type="text" id="uproomNum" readonly="readonly">
				</td>
			</tr>
			<tr class="updatecls" style="display: none">
				<td>가격</td>
				<td>
					<select id="uproomPrice">
						<option value="none">객실가격 선택</option>
						<option value="450,000">450,000</option>
						<option value="720,000">720,000</option>
						<option value="1,200,000">1,200,000</option>
					</select>
				</td>
			</tr>
			<tr class="updatecls" style="display: none">
				<td>객실등급</td>
				<td>
					<select id="uproomGrade">
						<option value="none">객실등급 선택</option>
						<option value="디럭스">디럭스</option>
						<option value="프리미어">프리미어</option>
						<option value="스위트">스위트</option>
					</select>		
				</td>
			</tr>
			<tr class="updatecls" style="display: none">
				<td colspan="4">
				
					<button type="button" id="updateRoomBtn" class="btn btn-success">객실 수정</button>
				</td>
			</tr>
			
			<%-- 객실정보 삭제 --%>
			<tr class="delcls" style="display: none">
				<th colspan="4">객실정보 삭제</th>
			</tr>
			<tr class="delcls" style="display: none">
				<td>객실번호</td>
				<td>
					<input type="text" id="delRoomNum" readonly="readonly">
				</td>
			</tr>
			<tr class="delcls" style="display: none">
				<td colspan="4">
					<button type="button" id="delRoomBtn" class="btn btn-success">객실 삭제</button>
				</td>
			</tr>
			</table>
			</form>
			
		</div>
	
		<script type="text/javascript">
		var radioRoomNum;
		
		$(document).ready(function() {
			// radio 선택한 Room Number를 받아오기
			$("input[name='radio']").click(function() {
				radioRoomNum = $("input[name='radio']:checked").val();
				$("#uproomNum").val(radioRoomNum);
				$("#delRoomNum").val(radioRoomNum);
			});
			
			// 객실정보 등록 창 show / 다른 창  hide
			$("#addBtn").click(function() {
				$(".updatecls").css("display", "none");
				$(".delcls").css("display", "none");
				
				if($(".addcls").is(":visible") == false){
					$(".addcls").css("display", "");
				}
				else{
					$(".addcls").css("display", "none");
				}
				
			});
			
			// 객실정보 수정 창 show / 다른 창  hide
			$("#updateBtn").click(function() {
				$(".addcls").css("display", "none");
				$(".delcls").css("display", "none");
				
				if($(".updatecls").is(":visible") == false){
					$(".updatecls").css("display", "");
				}
				else{
					$(".updatecls").css("display", "none");
				}
				
			});
			
			// 객실정보 삭제 창 show / 다른 창  hide
			$("#delBtn").click(function() {
				$(".addcls").css("display", "none");
				$(".updatecls").css("display", "none");
				
				if($(".delcls").is(":visible") == false){
					$(".delcls").css("display", "");
				}
				else{
					$(".delcls").css("display", "none");
				}
		 		
			});
			
			// 객실 등록
			$("#addRoomBtn").click(function() {
				var roomNum = $("#roomNum").val();
				var roomPrice = $("#roomPrice").val();
				var roomGrade = $("#roomGrade").val();
				
				if(roomNum == "" || roomPrice == "none" || roomGrade == "none"){
					alert("모두 입력해 주십시오");
					return;
				}
			
			//  숫자만 입력 가능하도록	
		 	//	ASCII CODE - 숫자 : 48 ~ 57
			 	var rNumArr = new Array(roomNum.length);
				for (i = 0; i < roomNum.length; i++) {
					rNumArr[i] = roomNum.charAt(i);
				}
				
		 		for (i = 0; i < rNumArr.length; i++) {
					if ( rNumArr[i].charCodeAt() < 48 || rNumArr[i].charCodeAt() > 58 ) {
						alert("숫자만 입력 가능합니다.");
						return;
					}
				} 
				
				<%
				for(int i = 0; i < list.size(); i++){
				%>	
					if(roomNum == <%=list.get(i).getRoom_number() %>){
						alert("동일한 Room Number가 존재합니다.");
						return;
					}
				<%	
				}
				%>			 
				location.href = "admin_servlet?command=addroom&roomNum=" + roomNum + "&roomPrice=" + roomPrice + "&roomGrade=" + roomGrade;
			
			});
			
			// 객실 수정
			$("#updateRoomBtn").click(function() {
				var uproomPrice = $("#uproomPrice").val();
				var uproomGrade = $("#uproomGrade").val();
				
				if($("#uproomNum").val() == "" || uproomPrice == "none" || uproomGrade == "none"){
					alert("모두 선택해 주십시오");
					return;
				}
				location.href = "admin_servlet?command=updateroom&roomNum=" + radioRoomNum + "&roomPrice=" + uproomPrice + "&roomGrade=" + uproomGrade;
				
			});
			
			// 객실 삭제
			$("#delRoomBtn").click(function() {
				if($("#delRoomNum").val() == ""){
					alert("삭제하실 Room을 선택해 주십시오");
					return;
				}
				var b = confirm("객실번호 : " + radioRoomNum + "\n삭제하시겠습니까?");
				
				if(b){
					location.href = "admin_servlet?command=deleteroom&roomNum=" + radioRoomNum;
				}
				else{
					return;
				}
				
			});
			
		});
		
		
		// 마우스 올리면 배경색 변경
		function bgchange(i) {
			$(".tr" + i).css("background-color", "#EFE1BA");
		}
		
		function bgout(i) {
			$(".tr" + i).css("background-color", "");
		}
			
		</script>	
	
	</div>

</div>

</main>




<jsp:include page="../footer.jsp" flush="false"/>





</body>
</html>