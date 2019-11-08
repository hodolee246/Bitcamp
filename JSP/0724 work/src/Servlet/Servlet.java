package Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDto;

public class Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 정보를 받는다.(입력하고 보낸정보)
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String age = req.getParameter("age");
		String hobby[] = req.getParameterValues("hobby");
		String story = req.getParameter("story");
		
		MemberDto dto = new MemberDto(id, pwd, hobby, age, story);
		
		
		System.out.println("id=" + id);
		System.out.println("pwd=" + pwd);
		System.out.println("age=" + age);
		System.out.println("story=" + story);
		if(hobby != null && hobby.length > 0) {
			for (int i = 0; i < hobby.length; i++) {
				System.out.println("hobby[" + i + "]"+hobby[i]);
			}
		}
		// 짐싸
		req.setAttribute("dto", dto);
		// 잘가
		req.getRequestDispatcher("insertAf.jsp").forward(req, resp);
		

	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
}
