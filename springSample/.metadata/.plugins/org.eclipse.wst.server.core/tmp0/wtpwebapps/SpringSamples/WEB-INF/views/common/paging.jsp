<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int totalRecordCount;	// 전체 글수 
	int pageNumber;			// 현재 페이지
	int pageCountPerScreen;	// 스크린당 페이지 수
	int recordCountPerPage;	// 페이지 당 글 몇개로 할건지
	
	String st1 = request.getParameter("totalRecordCount");
	
	if(st1 == null){
		totalRecordCount = 0;
	}else{
		totalRecordCount = Integer.parseInt(st1);
	}
	
	String st2 = request.getParameter("pageNumber");
	
	if(st2 == null){
		pageNumber = 0;
	}else{
		pageNumber = Integer.parseInt(st2);
	}
	
	String st3 = request.getParameter("pageCountPerScreen");
	
	if(st3 == null){
		pageCountPerScreen = 0;
	}else{
		pageCountPerScreen = Integer.parseInt(st3);
	}
	
	String st4 = request.getParameter("recordCountPerPage");
	
	if(st4 == null){
		recordCountPerPage = 0;
	}else{
		recordCountPerPage = Integer.parseInt(st4);
	}
	
	// 총 페이지 수
	int totalPageCount = totalRecordCount / recordCountPerPage;
	//	2					23					10
	if((totalRecordCount % recordCountPerPage)!= 0){
		totalPageCount ++ ;	//->3
	}
	
	// 시작페이지 [1]	[11] 	[21] <<[1][2][3]...[10]>>	
	int screenStartPageIndex = ((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen;
							//				4			10		00	
	// 끝페이지
	int screenEndPageIndex = (((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen) + pageCountPerScreen;
								//	4							10				0				10
	// 끝페이지는 다시 계산
	
	if(screenEndPageIndex > totalPageCount){
		screenEndPageIndex = totalPageCount;
	}
	if((pageNumber + 1) % pageCountPerScreen == 0){
		screenStartPageIndex = ((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen;
		screenEndPageIndex = pageNumber + 1 ; // 0 -> 1  9 -> 10
	}
	
	
%>    


<div style="float: left; width: 96%; text-align: center;">
	<!-- << -->
	<a href="#none" title="처음페이지" onclick="goPage(0)">
		<img src="image/arrow_first.gif" style="width: 9px; height: 9px;">
	</a>
	
	<!-- < -->
	<%
	if(screenStartPageIndex > 1){
	%>
		<a href="#none" onclick="goPage('<%=screenStartPageIndex -1%>')">
			<img src="image/arrow_back.gif" style="width: 9px; height: 9px;">
		</a>
	<%
	}
	%>
	
	<!-- [1][2][3] -->
	<%
	for(int i = screenStartPageIndex; i < screenEndPageIndex; i++){
		if(i == pageNumber){	// 현재 페이지		
		%>
		<span style="font-size: 9pt; color: black; font-weight: bold;">
			<%=i+1 %>
		</span>	
		<%
		}else{	// 그 외의 페이지
		%>
			<a href="#none" title="<%=i+1%>페이지" onclick="goPage(<%=i%>)"
				style="font-size: 7.5pt; color: #000000; font-weight: normal;">
				[<%=i+1 %>]
			</a>
		<%
		}
	}
	%>
	
	<!-- > -->
	<%
	if(screenEndPageIndex < totalPageCount){	// [11][12][13]
		%>
		<a href="#none" title="다음페이지" onclick="goPage(<%=screenEndPageIndex %>)">
			<img src="image/arrow_next.gif" style="width: 9px;" height="9px">
		</a>
		<%
	}
	
	
	int end_page = 0;
	if(totalPageCount > 0){
		end_page = totalPageCount - 1;
	}
	
	// 	[1][2][3]
	//	[11][12][13]
	//	총 페이지 -> 120개가 넘어가야 13페이지 까지 표시가 된다		
	%>
	
	<!-- >> -->
	<a href="#none" title="마지막 페이지" onclick="goPage(<%=end_page %>)">
		<img src="image/arrow_end.gif" style="width: 9px;" height="9px">
	</a>

</div>





    