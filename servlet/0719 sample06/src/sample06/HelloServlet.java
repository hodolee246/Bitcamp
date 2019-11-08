package sample06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
		
		/*
		 	html : a, form
		 	
		 	javascript : location.href
		 	
		 	Jquery : submit();
		  
		  	java : response.sendRedirect
		  	response.sendRedirect("sampleServlet?name=" + name);
		 			forward : 전진 -> servlet, *.jsp
		 			include:불러오기
		 			
		 */
		PrintWriter pw = resp.getWriter();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		pw.append("<html>");
		
		pw.append("<head>");
		
		pw.append("<title>제목</title>");
		
		pw.append("</head>");
		
		pw.append("<body>");
		
		pw.println("<p>here hello servlet start ..</p>");
		
		/*	include
		 * RequestDispatcher dispatch = req.getRequestDispatcher("include");
		 * dispatch.include(req, resp);
		 */
		
		// forward
		RequestDispatcher dispatch = req.getRequestDispatcher("include");
		dispatch.forward(req, resp);
		
		pw.println("<p>here hello servlet end ..</p>");
		pw.append("</body>");
		pw.append("</html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
