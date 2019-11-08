package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/man")
public class man extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");

		PrintWriter pw = resp.getWriter();
		
		

		pw.println("<html>");

		pw.println("<head>");
		pw.println("<title>제목</title>");

		pw.println("</head>");

		pw.println("<body>");

		pw.println("<h3>Hello man Servlet</h3>");
		pw.println("<br>");
		
		HttpSession session = req.getSession();
		
		Enumeration<String> enum_session = session.getAttributeNames();
		ummDto dto = new ummDto();
		
		while(enum_session.hasMoreElements()) {
			String _dto = enum_session.nextElement();
			dto = (ummDto)session.getAttribute(_dto);
			
			String name = dto.getName();
			String age = dto.getAge();
			String mw = dto.getMw();
			String hb[] = dto.getHb();
			String birthday = dto.getBirthday();
			String sal = dto.getSal();
			
			System.out.println(name + age + mw + birthday + sal);
			pw.println("<input type='text'value='" + name + "'>");
			pw.println("<br>");
			pw.println("<input type='text'value='" + age + "'>");
			pw.println("<br>");
			pw.println("<input type='text'value='" + mw + "'>");
			pw.println("<br>");
			for (int i = 0; i < hb.length; i++) {
				pw.println("<input type='text'value='" + hb[i] + "'>");
			}
			pw.println("<br>");
			pw.println("<input type='text'value='" + birthday + "'>");
			pw.println("<br>");
			pw.println("<input type='text'value='" + sal + "'>");
		}
		

		pw.println("</body>");

		pw.println("</html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
