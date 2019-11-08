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

@WebServlet("/invalSession")
public class InvalSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();		
				
		pw.println("<html>");		
		
		pw.println("<head>");
		pw.println("<title>제목</title>");	
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h3>InvalSession doGet</h3>");
		
		HttpSession session = req.getSession();
		
		session.invalidate();		// 새션을 파기한다. logout시 세션을 삭제해줘야한다.
		
		if(req.getSession(false) == null) {
			pw.println("<p>세션이 비어 있습니다.</p>");
		}
		pw.println("<br>");
		
		pw.println("<a href=\"invalSession\">Session 삭제</a>");	
		/*	java		java, html
			servlet -> servlet
			
			sendRedirect : parameter sample?id='abc'&...
			
			MemberDto	mem
			
			
			setAttribute("dto", mem); ->	request.getAttrivute("dto")		
			
		request.forward(dicpather servlet 부분의 forward를 사용해야 오브젝트를 옮긴다.)
		forward 한번날리면 데이터가 안남는다.( 이부분은 포워드 외에는 동작을 하지 않는다.)
		
		session.setAttribute("dto", mem); ->	session.getAttrivute("dto")		
		forward, sendRedirect 세션은 서버공간(독립객체) 세션에서 set get 으로 넣고 꺼낼때에는 정한 기한동안 계속 유지된다.	
			
			
			html -> java getparameter values 사용
			
			
		
		*/
		pw.println("</body>");
		
		pw.println("</html>");		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
