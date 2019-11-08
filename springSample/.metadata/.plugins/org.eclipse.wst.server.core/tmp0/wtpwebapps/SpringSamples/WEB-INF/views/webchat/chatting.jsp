<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

채팅명:<input type="text" id="nickname">

<input type="button" id="enterBtn" value="입장" onclick="connect()">

<input type="button" id="exitBtn" value="채팅방 나가기" onclick="disconnect()">
<br><br>

<h1>대화 영역</h1>
<div id="chatArea">
	<div id="chatMessageArea">
	
	
	</div>
</div>
<input type="text" id="message">
<input type="button" id="sendBtn" value="전송하기" onclick="send()">

<script>


// 웹 소켓 변수
var wsocket;

// 입장 버튼 클릭시에 호출 함수
function connect() {		// 못찾거나		// 이미 소켓이 생성 된경우
	
	$("#nickname").attr('readonly', 'readonly');
	
	if(wsocket != undefined && wsocket.readyState != WebSocket.CLOSED){
//		alert("못찾거나 이미 생성된경우 ( 이미 채팅방 안에 존자할 경우)");
		return ;
	}
	// Web Socket 생성				// 아이피 주소
	wsocket = new WebSocket("ws://localhost:8091/SpringSamples/echo.do");
//	alert("wsocket:" + wsocket);
	
	$("#exitBtn").removeAttr('readonly');
	
	wsocket.onopen = onOpen;
	wsocket.onmessage = onMessage;
	wsocket.onclose = onClose;
	
}

function disconnect() {
	
	
	$("#chatMessageArea").val("");
	$("#nickname").removeAttr( 'readonly' );
	
	ending();
	
	wsocket.close();
	
}


// onopen(연결시 호출), onmessage(메세지 올경우 호출), onclose(끊어지면 호출)

function onOpen(evt) {
	wsocket.send("msg:" + $("#nickname").val() + "님이 입장 하셨습니다.");
	

}
function ending(){
	wsocket.send("msg:" + $("#nickname").val() + "님이 퇴장 하셨습니다.");
}
// 서버로부터 메세지가 도착했을 때 호출
function onMessage(evt) {
	var data = evt.data;
	if(data.substring(0, 4) == "msg:"){
		appendMessage(data.substring(4));
	}
}
function onClose(evt) {
	
	wsocket.close();
}
function send() {	
	var nickname = $("#nickname").val();
	var msg = $("#message").val();
	// 입장시 등장말
		
	// 실제 전송 부분
	wsocket.send("msg:" + nickname + ":" + msg);
	$("#message").val("");
}
function appendMessage(msg) {	// 메세지를 받으면서 div에 위치시켜준다.
	// 메세지를 축가하고 개행
	$("#chatMessageArea").append(msg + "<br>");
	
	// 현재 있는 메세지 밑으로 미는 작업
	var chatAreaHeight = $("#chatArea").height();
	var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
	$("#chatArea").scrollTop(maxScroll);
}
</script>
