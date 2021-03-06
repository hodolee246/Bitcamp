/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-09-17 09:37:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class paging_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

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
	
	

      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"float: left; width: 96%; text-align: center;\">\r\n");
      out.write("\t<!-- << -->\r\n");
      out.write("\t<a href=\"#none\" title=\"처음페이지\" onclick=\"goPage(0)\">\r\n");
      out.write("\t\t<img src=\"image/arrow_first.gif\" style=\"width: 9px; height: 9px;\">\r\n");
      out.write("\t</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- < -->\r\n");
      out.write("\t");

	if(screenStartPageIndex > 1){
	
      out.write("\r\n");
      out.write("\t\t<a href=\"#none\" onclick=\"goPage('");
      out.print(screenStartPageIndex -1);
      out.write("')\">\r\n");
      out.write("\t\t\t<img src=\"image/arrow_back.gif\" style=\"width: 9px; height: 9px;\">\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t");

	}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- [1][2][3] -->\r\n");
      out.write("\t");

	for(int i = screenStartPageIndex; i < screenEndPageIndex; i++){
		if(i == pageNumber){	// 현재 페이지		
		
      out.write("\r\n");
      out.write("\t\t<span style=\"font-size: 9pt; color: black; font-weight: bold;\">\r\n");
      out.write("\t\t\t");
      out.print(i+1 );
      out.write("\r\n");
      out.write("\t\t</span>\t\r\n");
      out.write("\t\t");

		}else{	// 그 외의 페이지
		
      out.write("\r\n");
      out.write("\t\t\t<a href=\"#none\" title=\"");
      out.print(i+1);
      out.write("페이지\" onclick=\"goPage(");
      out.print(i);
      out.write(")\"\r\n");
      out.write("\t\t\t\tstyle=\"font-size: 7.5pt; color: #000000; font-weight: normal;\">\r\n");
      out.write("\t\t\t\t[");
      out.print(i+1 );
      out.write("]\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t");

		}
	}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- > -->\r\n");
      out.write("\t");

	if(screenEndPageIndex < totalPageCount){	// [11][12][13]
		
      out.write("\r\n");
      out.write("\t\t<a href=\"#none\" title=\"다음페이지\" onclick=\"goPage(");
      out.print(screenEndPageIndex );
      out.write(")\">\r\n");
      out.write("\t\t\t<img src=\"image/arrow_next.gif\" style=\"width: 9px;\" height=\"9px\">\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t");

	}
	
	
	int end_page = 0;
	if(totalPageCount > 0){
		end_page = totalPageCount - 1;
	}
	
	// 	[1][2][3]
	//	[11][12][13]
	//	총 페이지 -> 120개가 넘어가야 13페이지 까지 표시가 된다		
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- >> -->\r\n");
      out.write("\t<a href=\"#none\" title=\"마지막 페이지\" onclick=\"goPage(");
      out.print(end_page );
      out.write(")\">\r\n");
      out.write("\t\t<img src=\"image/arrow_end.gif\" style=\"width: 9px;\" height=\"9px\">\r\n");
      out.write("\t</a>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
