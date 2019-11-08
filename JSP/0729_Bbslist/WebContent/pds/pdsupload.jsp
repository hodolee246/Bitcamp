<%@page import="pds.PdsDao"%>
<%@page import="pds.ipdsDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 목적 == 업로드 하기 위해서!
public  String processUploadFile(FileItem fileItem, String dir) throws IOException{
    	
   	String filename = fileItem.getName(); 	// 경로 + 파일명이 들어오게 된다.
   	long sizeInBytes =  fileItem.getSize();
    	
   	if(sizeInBytes > 0){	// 경로 예시 d:\\tmp\\abc.txt  d:/tmp/abc.txt
    		
    	int idx = filename.lastIndexOf("\\");	// 뒤에서부터 \\ 까지 위치를 얻어온다.
    		
    	if(idx == -1){	
    		idx = filename.lastIndexOf("/");	// 형식이 2가지이기에 \\ or / 으로 찾는다.
    	}
   		filename = filename.substring(idx + 1);	// abc.txt
   		
   		File uploadFile = new File(dir, filename);
   		try{
   		fileItem.write(uploadFile);
   		} catch(Exception e){
   			
   		}
   	
   	}
   	
    
    			
   	return filename;	// (확인용)실패할경우 무엇을 가져왔는지 등 확인을 하기위해서 파일명을 리턴한다
}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsupload.jsp</title>
</head>
<body>
<%

// tomcat 서버에 업로드 하는 방법	서버껏다켯다 하면서 자료가 날라갈 가능성이큼
String fupload = application.getRealPath("/upload"); // application 폴더명 ("/upload") 여기에 저장~
// 지정폴더에 업로드하는 방법	서버가 껏다켯다(우리가 맨날 재시작하는거) 할경우 자료가 날라갈 확률이 낮음
// String fupload = "d:\\tmp";

System.out.println("파일 업로드 폴더:" + fupload);

String yourTempDir = fupload;	// 파일 Dir(경로)
int yourMaxRequestSize = 100 * 1024 * 1024 ;	// 1 MByts
int yourMaxMemorySize = 100 * 1024;				// 1 KByte

// form field의 데이터를 저장할 변수

String id = "";
String title = "";
String content = "";

// file name
String filename = "";

boolean isMultipart = ServletFileUpload.isMultipartContent(request);	// multipart 받는 방법

if(isMultipart){
	
	// fileitem 생성
	
	DiskFileItemFactory factory = new DiskFileItemFactory(); 	// 팩토리 생성
	
	factory.setSizeThreshold(yourMaxMemorySize);				// 메모리 사이즈 설정
	factory.setRepository(new File(yourTempDir));				// 경로 설정
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(yourMaxRequestSize);
	
	// list 저장
	List<FileItem> items = upload.parseRequest(request);
	Iterator<FileItem> it = items.iterator();	// Iterator == 반복자
			
	while(it.hasNext()){
		FileItem item = it.next();	// 넘겨받을게 String 인지 file 인지 모르니까 fileitem 으로 받는다
		
		if(item.isFormField()){	// id, title, content
			if(item.getFieldName().equals("id")){
				id = item.getString("utf-8");	// utf-8 형식으로 넘겨라
			}else if(item.getFieldName().equals("title")){
				title = item.getString("utf-8");
			}else if(item.getFieldName().equals("content")){
				content = item.getString("utf-8");
			}
		}else{ // fileload
			if(item.getFieldName().equals("fileload")){
				filename = processUploadFile(item, fupload);
				System.out.println("fupload:" + fupload);
			}
		}
	}
	
	
}else{
	System.out.println("is not multipart");
}

ipdsDao dao = PdsDao.getInstance();

boolean b = dao.insertPds(id, title, content, filename);

if(b){
	%>
	<script type="text/javascript">
	alert("작성완료");
	location.href='pdslist.jsp';
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("작성실패 게시물 입력에 빈칸을 입력하셨는지 확인해주세요.");
	history.go(-1);
	</script>
	<%
}

%>




</body>
</html>



