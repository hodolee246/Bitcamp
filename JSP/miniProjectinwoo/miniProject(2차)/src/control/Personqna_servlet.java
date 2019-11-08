package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonQnADao;
import dao.iPersonQnADao;
import dto.PersonQnADto;

@WebServlet("/personqna_servlet")
public class Personqna_servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Personqna_servlet doGet");
		
		String command = req.getParameter("command");
		
		iPersonQnADao qnaDao = PersonQnADao.getInstance();
		
		// 고객의소리 페이지로 이동
		if(command.equals("qnapage")) {
			
			req.getRequestDispatcher("./PersonQnA/writepersonqna.jsp").forward(req, resp);
		}
		
		// 고객의소리 등록
		else if(command.equals("addqna")) {
			
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String choice = req.getParameter("choice");
			
			boolean isS = qnaDao.addQnA(new PersonQnADto(id, title, content, choice, ""));
			
			if(isS == true) {
				System.out.println("고객의소리 등록 성공");
			}
			else {
				System.out.println("고객의소리 등록 실패");
			}
			
			// 보내기
			resp.sendRedirect("customer_servlet?command=mypage");
			
		}
		
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Personqna_servlet doPost");
		
	}
	
	
	
	

}
