package sample06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		pw.append("<html>");
		
		pw.append("<head>");
		
		pw.append("<title>제목</title>");
		
		pw.append("</head>");
		
		pw.append("<body>");
		
		pw.println("<h2>here includeServlet  im.</h3>");
		
		pw.append("</body>");
		pw.append("</html>");
	//	pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
