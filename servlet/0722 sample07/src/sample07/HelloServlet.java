package sample07;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import dto.Member;

public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post방식 입니다.");
		
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html; charset=utf-8");
		
		
		/*
		 * String id = req.getParameter("id"); String pwd = req.getParameter("pwd");
		 * String mydata = req.getParameter("mydata");
		 * 
		 * System.out.println(id); System.out.println(pwd); System.out.println(mydata);
		 */
		
		String id = (String)req.getAttribute("id");
		String pwd = (String)req.getAttribute("pwd");
		
	//	resp.sendRedirect("sample?id=" + id + "&pwd=" + pwd);
		
		req.setAttribute("mem", new Member(id, pwd));	
		
		req.getRequestDispatcher("sample").forward(req, resp);
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		
		pw.println("<title>제목</title>");
		
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<p>id:" + id + "</p>");
		
//		pw.println("<a href='sample?id=" + id + "&pwd=" + pwd + "'>");
	
		// form
		
		
		pw.println("</body>");
		
		pw.println("</html>");
		
		// servlet(hello) - > servlet(sample)
		
		pw.close();
	}

}
