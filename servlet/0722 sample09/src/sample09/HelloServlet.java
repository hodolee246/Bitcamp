package sample09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();		
				
		pw.println("<html>");		
		
		pw.println("<head>");
		pw.println("<title>제목</title>");	
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h3>Hello Servlet</h3>");
		
		/*
		  Cookie : id 저장 용도로 많이 사용되고 String 형태로 이루어져있다.
		  
		  Session : user의 정보를 저장하거나, 방문회수를 저장한다. Object 형태로 이루어져있다.
		 */
		
		HttpSession session = req.getSession(false);
		/*
			getSession(false)
			session object가 존재하면 현재 HttpSession을 반환한다.
			존재하지 않으면, 그냥 null을 반환한다.
			
			getSession(true)
			session object가 존재하면, 현재 HttpSession을 반환한다.
			존재하지 않으면, 새로 session을 생성한다.
			
		*/
		if(session == null) {
			pw.println("<p>세션이 존재하지 않습니다. 세션을 생성합니다.</p>");
			
			session = req.getSession(true);
			session.setMaxInactiveInterval( 30 );
			session.setAttribute("visited", "1");
		}
		
		else {
			String visited = (String)session.getAttribute("visited");
			int count = Integer.parseInt(visited);
			
					count ++;
					
			pw.println("<p>방문회수는" + count + "회 입니다.</p>");
			
			session.setAttribute("visited", count + "");
			
		}
		
		pw.println("<a href=\"hello\">다시표시</a>");
		pw.println("</body>");
		
		pw.println("</html>");		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
