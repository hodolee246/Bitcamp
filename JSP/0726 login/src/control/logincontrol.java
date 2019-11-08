package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.loginDao;

public class logincontrol extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ck = req.getParameter("ck");
		loginDao dao = loginDao.getInstance();
		
		if(ck.equals("lo")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			boolean b = dao.login(id, pw);
			
			if(b) {
				String check = "succes";
				req.setAttribute("check", check);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else {
				String check = "fail";
				req.setAttribute("check", check);
			}
			
		}else if(ck.equals("ac")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String email = req.getParameter("eamil");
			
			boolean b = dao.account(id, pw, name, email);
			
			if(b) {
				String check = "succes";
				req.setAttribute("check", check);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else {
				String check = "fail";
				req.setAttribute("check", check);
			}
			
		}else if(ck.equals("id")) {
			String id = req.getParameter("id");
			
			boolean b = dao.idcheck(id);
			
			if(b && id != "") {
				String idcheck = "cannot";
				req.setAttribute("cannot", idcheck);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else {
				String idcheck = "can";
				req.setAttribute("check", idcheck);
			}
		}
	}
	
}
