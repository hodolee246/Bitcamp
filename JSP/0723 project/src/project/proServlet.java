package project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/loc")
public class proServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String hobby[] = req.getParameterValues("hobby");
		String age = req.getParameter("age");
		String ahhh = req.getParameter("ahhh");
		
		dto dto = new dto(id, pwd, hobby, age, ahhh);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher rd = req.getRequestDispatcher("project9insertAf2.jsp");
		rd.forward(req, resp);
		
	}

}
