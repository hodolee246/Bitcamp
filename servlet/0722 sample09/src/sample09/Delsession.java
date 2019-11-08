package sample09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delsession")
public class Delsession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();		
				
		pw.println("<html>");		
		
		pw.println("<head>");
		pw.println("<title>제목</title>");	
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h3>Delsession doGet</h3>");
		HttpSession session = req.getSession();
		
		session.removeAttribute("age");
		
		pw.println("<p>현재 등록 되어 있는 세션을 표시한다.</p>");
		
		Enumeration<String> enum_session = session.getAttributeNames();
		
		while(enum_session.hasMoreElements()) {
			String key = enum_session.nextElement();
			String val = (String)session.getAttribute(key);
			
			pw.println("<p>" + key + ":" + val + "</p>");
		}
		
		pw.println("</body>");
		
		pw.println("</html>");		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
