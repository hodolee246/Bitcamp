package sample02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		
		
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html; charset = utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		
		pw.println("<title>제목</title>");
		
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h3>Hello Servlet</h3>");
		pw.println("<p>Hello Servlet</p>");
		pw.println("<p>" + name + "</p>");
		
		pw.println("</body>");
		
		pw.println("</html>");
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost");
	}

}
