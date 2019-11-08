package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/woman")
public class woman extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ummDto dto = (ummDto)req.getAttribute("dto");
		/*
		 * 이름 텍스트 나이 셀렉트 성별 라디오 취미 체크 생년 제이커리 연봉 셀렉트
		 */
		
		String name = dto.getName();
		String age = dto.getAge();
		String mw = dto.getMw();
		String hb[] = dto.getHb();
		String birthday = dto.getBirthday();
		String sal = dto.getSal();
		
		
		resp.setContentType("text/html; charset=utf-8");

		PrintWriter pw = resp.getWriter();

		pw.println("<html>");

		pw.println("<head>");
		pw.println("<title>제목</title>");

		pw.println("</head>");

		pw.println("<body>");

		pw.println("<h3>Hello woman Servlet</h3>");
		pw.println("<br>");
		
		
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
		
		
		pw.println("</body>");

		pw.println("</html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
