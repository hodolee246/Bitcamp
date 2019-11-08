package sample08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitedCookie")
public class VisitedCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();		
				
		pw.println("<html>");		
		
		pw.println("<head>");
		pw.println("<title>제목</title>");	
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h3>VisitedCookie doGet</h3>");
		
		Cookie cookies[] = req.getCookies();
		
		Cookie visitCookie = null;
		
		if(cookies != null) {
			// 쿠키가 있음
			
			//	쿠키 검색 
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("visited")){
					visitCookie = cookies[i];
					break;	// 찾으면 멈춘다
				}
			}
			// 찾음
			if(visitCookie != null) {
				System.out.println("visitCookie.getValue():" + visitCookie.getValue()); 
				int count = Integer.parseInt(visitCookie.getValue()) + 1;
				pw.println("<p>" + count + "번째 방문입니다.</p>");
				
				// 쿠키의 값을 갱신한다.
				visitCookie.setValue(count + "");
				visitCookie.setMaxAge( 10 );	// 365 * 24 * 60 * 60 -> 1년
				resp.addCookie(visitCookie);
			}
			// 못찾음	 쿠키가 있는데 원하는 쿠키를 찾지 못했을경우
			else {
				// 쿠키가 없음 -> 생성
				pw.println("<p>첫번째 방문입니다.</p>");
				Cookie newCookie = new Cookie("visited", "1");
				resp.addCookie(newCookie);
			}
			
			
		}else {
			// 쿠키가 없음 -> 생성
			pw.println("<p>첫번째 방문입니다.</p>");
			Cookie newCookie = new Cookie("visited", "1");
			resp.addCookie(newCookie);
			
		}
		
		pw.println("</body>");
		
		pw.println("</html>");		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
