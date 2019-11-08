package sample03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println( createHTML("GET", req, resp));
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println( createHTML("POST", req, resp));
		
		pw.close();
	}

	public String createHTML(String methodType, HttpServletRequest req, HttpServletResponse resp) {
		
		String name = req.getParameter("name");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");
		
		sb.append("<head>");
		
		sb.append("<title>제목</title>");
		
		sb.append("</head>");
		
		sb.append("<body>");
		
		sb.append("<h3>Hello Servlet</h3>");
		sb.append("<p>Hello Servlet</p>");
		sb.append("<p>" + name + "</p>");
		
		sb.append("</body>");
		
		sb.append("</html>");
		
		return (new String(sb));
		
	}
}	
	

