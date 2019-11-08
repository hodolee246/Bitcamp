package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustuserDao;
import dto.CustuserDto;

public class CustUserControl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		System.out.println(command);
		CustuserDao dao = CustuserDao.getInstance();
		if(command.equals("list")) {
			
			List<CustuserDto> list = dao.getCustuserList();
			
			// 짐싸
			req.setAttribute("custlist", list);
			// 잘가
			req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			
			
		
		}else if(command.equals("del")) {
			String id = req.getParameter("id");
			
			boolean b;
			
			b = dao.DeleteData(id);
			if(b) {
//				CustuserDto dto = new CustuserDto(id, name, addr);
				List<CustuserDto> list = dao.getCustuserList();
				
				// 짐싸
				req.setAttribute("custlist", list);
				// 잘가
				req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			}else {
				System.out.println("삭제실패");
				List<CustuserDto> list = dao.getCustuserList();
				
				// 짐싸
				req.setAttribute("custlist", list);
				// 잘가
				req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			}
		}else if(command.equals("select")) {
			String id = req.getParameter("id");
			
			List<CustuserDto> list = dao.SelectList(id);
			req.setAttribute("custlist", list);
			
			req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		System.out.println(command);
		CustuserDao dao = CustuserDao.getInstance();
		
		if(command.equals("add")) {
			// add
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String addr = req.getParameter("addr");
			
			boolean b;
			
			b = dao.addData(id, name, addr);
			if(b) {

				List<CustuserDto> list = dao.getCustuserList();
				
				
				req.setAttribute("custlist", list);
				
				req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			}else {
				System.out.println("추가실패");
				List<CustuserDto> list = dao.getCustuserList();
				req.setAttribute("custlist", list);
				// 잘가
				req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			}
			
		}else if(command.equals("muldel")) {
			System.out.println(command);
			String id[] = req.getParameterValues("delck");
			boolean b;
			b = dao.deletedatas(id);
			if(b) {

				List<CustuserDto> list = dao.getCustuserList();
				
				// 짐싸
				req.setAttribute("custlist", list);
				// 잘가
				req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			}else {
				System.out.println("전체삭제실패");
				List<CustuserDto> list = dao.getCustuserList();
				
				// 짐싸
				req.setAttribute("custlist", list);
				// 잘가
				req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			}
		}else if(command.equals("update")) {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String addr = req.getParameter("addr");
			
			boolean b;
			
			b = dao.UpdateData(id, name, addr);
			if(b) {
	//			CustuserDto dto = new CustuserDto(id, name, addr);
				List<CustuserDto> list = dao.getCustuserList();
				
				// 짐싸
				req.setAttribute("custlist", list);
				// 잘가
				req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			}else {
				System.out.println("수정실패");
				List<CustuserDto> list = dao.getCustuserList();
				
				// 짐싸
				req.setAttribute("custlist", list);
				// 잘가
				req.getRequestDispatcher("custuserlist.jsp").forward(req, resp);
			}
		}

		
}
	
	
	
}
