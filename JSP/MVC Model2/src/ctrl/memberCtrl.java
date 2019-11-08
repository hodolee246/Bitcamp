package ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.memberDao;

@WebServlet("/member")
public class memberCtrl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		memberDao dao = memberDao.getInstance();
		PrintWriter pw = resp.getWriter();
		
		String type = req.getParameter("type");
		
		if(type.equals("check")) {
			
			String id = req.getParameter("id");
			
			boolean b = dao.IDcheck(id);
			
			if(b) {
				
				req.setAttribute("result", b);
				req.getRequestDispatcher("account.jsp").forward(req, resp);
				
			}
			else {
				
				req.setAttribute("result", b);
				req.getRequestDispatcher("account.jsp").forward(req, resp);
			}
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		memberDao dao = memberDao.getInstance();
		PrintWriter pw = resp.getWriter();
		
		String type = req.getParameter("type");
		
		if(type.equals("login")) {
			
			System.out.println(type);
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pw");
			
			boolean b = dao.login(id, pwd);
			if(b) {
				pw.append("<html>");
				
				pw.append("<head>");
				
				pw.append("<title>제목</title>");
				
				pw.append("</head>");
				
				pw.append("<body>");
				pw.append("<script>");
				pw.append("alert('Login');");
				pw.append("location.href='order.jsp';");
				pw.append("</script>");
				pw.append("</body>");
					
				pw.append("</html>");
				
				
				
				pw.close();
				
				
			}
			else {
				pw.append("<html>");
				
				pw.append("<head>");
				
				pw.append("<title>제목</title>");
				
				pw.append("</head>");
				
				pw.append("<body>");
				pw.append("<script>");
				pw.append("alert('ID or PW is wrong plz check you ID or PW');");
				pw.append("location.href='login.jsp';");
				pw.append("</script>");

				pw.append("</body>");
					
				pw.append("</html>");
				  
				pw.close();
				
			
			}
		}
		else if(type.equals("account")) {
			
			System.out.println(type);
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pw");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			
			boolean b = dao.account(id, pwd, name, email);
			
			if(b) {
				
				pw.append("<html>");
				
				pw.append("<head>");
				
				pw.append("<title>제목</title>");
				
				pw.append("</head>");
				
				pw.append("<body>");
				pw.append("<script>");
				pw.append("alert('Account');");
				pw.append("location.href='login.jsp';");
				pw.append("</script>");
				pw.append("</body>");
					
				pw.append("</html>");
				
				
				
				pw.close();
				  
			}
			else {
				pw.append("<html>");
				
				pw.append("<head>");
				
				pw.append("<title>제목</title>");
				
				pw.append("</head>");
				
				pw.append("<body>");
				pw.append("<script>");
				pw.append("alert('plz check the blank');");
				pw.append("location.href='account.jsp';");
				pw.append("</script>");
				pw.append("</body>");
					
				pw.append("</html>");
				
				
				
				pw.close();
			}
			
		}

		
		
	}
	
}
