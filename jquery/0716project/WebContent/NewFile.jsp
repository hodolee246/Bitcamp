<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("t1");

String addr1 = request.getParameter("t2");
String addr2 = request.getParameter("t3");

String addr3 = request.getParameter("ta");

String pnum1 = request.getParameter("t4");
String pnum2 = request.getParameter("t5");
String pnum3 = request.getParameter("t6");

String[] time = request.getParameterValues("_select");

String post = request.getParameter("cbox");

String[] magagin = request.getParameterValues("radi");



System.out.println("이름 = " + name);

System.out.println("우편번호 = " + addr1 + "-" + addr2);

System.out.println("주소 = " + addr3);

System.out.println("전화번호 = " + pnum1 + "-" + pnum2 + "-" + pnum3);

System.out.print("배달 선호시간 : ");
for(int i = 0; i < time.length; i++){
	System.out.print(time[i] + "\n");
}


System.out.print("영수증 신청여부 : ");
if(post.equals(true)){
	System.out.println("O");
}else{
	System.out.println("X");
}

System.out.print("메일 매거진 신청여부 : ");
for(int i = 0; i < magagin.length; i++){
	System.out.print(magagin[i]);
}

%>