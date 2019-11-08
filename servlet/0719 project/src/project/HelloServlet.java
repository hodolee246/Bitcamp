package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println(anything("GET", req, resp));
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println(anything("POST", req, resp));
		
		pw.close();
	}

	
	public String anything(String met, HttpServletRequest req, HttpServletResponse resp ) {
		
		String _text = req.getParameter("_text");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");
		
		sb.append("<head>");
		
		sb.append("<title>제목</title>");
		
		sb.append("</head>");
		
		sb.append("<body>");
		
		sb.append("<h3>Hello Servlet</h3>");
		
		sb.append("<a href='Get.html'>Get</a>");
		sb.append("<br>");
		sb.append("<a href='Post.html'>Post</a>");
		sb.append("<br>");
		sb.append("<a href='Servlet.html'>Servlet</a>");
		sb.append("<br>");
		sb.append("<input type='text' value ='" + _text + "' name ='_text'>");
		
		sb.append("</body>");
		
		sb.append("</html>");
		
		
		return (new String (sb));
		
	}
	
	
}
