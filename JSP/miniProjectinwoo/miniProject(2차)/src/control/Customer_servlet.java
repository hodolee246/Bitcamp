package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookingDao;
import dao.CustomerDao;
import dao.PersonQnADao;
import dao.iBookingDao;
import dao.iCustomerDao;
import dao.iPersonQnADao;
import dto.BookingDto;
import dto.CustomerDto;
import dto.PersonQnADto;

@WebServlet("/customer_servlet")
public class Customer_servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		iCustomerDao dao = CustomerDao.getInstance();
		iPersonQnADao qnadao = PersonQnADao.getInstance();
		iBookingDao boodao = BookingDao.getInstance();
		
		String command = req.getParameter("command");
		
		System.out.println("do get command : " + command);
		
		
		if(command.equals("mainpage")) {
			
			req.getRequestDispatcher("./Main.jsp").forward(req, resp);
			
		}
		else if(command.equals("account")) {
			
			req.getRequestDispatcher("./Customer/account.jsp").forward(req, resp);
			
		}else if(command.equals("logout")) {
			
			HttpSession session = req.getSession();
			  
		    session.invalidate();
		    
		    if(req.getSession(false) == null) {
		    	System.out.println("로그아웃이 완료되었습니다");
		    }
		    
		    req.getRequestDispatcher("./Main.jsp").forward(req, resp);

		}else if(command.equals("loginpage")) {
			
		    req.getRequestDispatcher("./Customer/login.jsp").forward(req, resp);

		}else if(command.equals("idcheck")) {
			
		    System.out.println("id 체크입니다.");
		    
		    String id = req.getParameter("id");

		    boolean check = dao.getidcheck(id);

		    System.out.println("in_id = " + id);

		    String str = "";

		    if(check == false){
		    	str = "사용불가";
		    }else{
		    	str = "사용가능";
		    }
		 
		    resp.getWriter().print(check);
		    
		}else if(command.equals("mypage")) {

			HttpSession session = req.getSession();
			CustomerDto user = (CustomerDto)session.getAttribute("login");
			
			// 예약dao.get예약내역
			List<BookingDto> bookinglist = boodao.SelectBook(user.getId());
			req.setAttribute("bookinglist", bookinglist); //짐싸 예약내역 다오
			
			// 문의dao.get문의내역
			List<PersonQnADto> qnalist = qnadao.getMyList(user.getId());
			req.setAttribute("qnalist", qnalist); //짐싸 문의내역 다오
			
		    req.getRequestDispatcher("./Customer/mypage.jsp").forward(req, resp);

		}else if(command.equals("adminCustomer")) {
			// 회원관리 페이지로 이동
			System.out.println("command : adminCustomer");

			String search = req.getParameter("search");
			String text = req.getParameter("text");
			String page = req.getParameter("page");
			
			if(search == null && text == null && page == null) {
				// 처음 이동할 때는 null값이다
				search = "";
				text = "";
				page = "1";
			}			
			
			List<CustomerDto> list = dao.getCustomerList(search, text, page);
			List<CustomerDto> list2 = dao.getCustomerList();
			
			int pagetotalCount = list.size();
			int listCount = list2.size();
			
			System.out.println("1 : " + pagetotalCount + ", 2 : " + listCount);
					
			req.setAttribute("list", list);
			req.setAttribute("listCount", listCount);
			
			req.getRequestDispatcher("./Admin/admincustomer.jsp").forward(req, resp);
			
		}else if(command.equals("hotel_intro")) {
			// 시그니엘 소개 페이지로 이동
			req.getRequestDispatcher("./Customer/hotel_intro.jsp").forward(req, resp);
			
		}else if(command.equals("room_intro")) {
			// 객실 소개 페이지로 이동
			req.getRequestDispatcher("./Customer/room_intro.jsp").forward(req, resp);
			
		}else if(command.equals("travel_intro")) {
			// 주변 관광지 소개 페이지로 이동
			req.getRequestDispatcher("./Customer/travel_intro.jsp").forward(req, resp);
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // dopost 에서는 엔코딩을 해줘야 한글이 깨지지 않는다 !!
		
		iCustomerDao dao = CustomerDao.getInstance();
		
		String command = req.getParameter("command");
		
		System.out.println("do Post command : " + command);
		
		if(command.equals("login")) {
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			System.out.println("id : " + id);
			System.out.println("pwd : " + pwd);
			
			
			CustomerDto user = dao.loginCustomer(req.getParameter("id"), req.getParameter("pwd"));
	
			if(user == null){
			
				System.out.println("ID나 PW가 일치하지 않습니다.");
				req.getRequestDispatcher("./Customer/login.jsp").forward(req, resp);
				
			}else{
				HttpSession session = req.getSession();

				session.setAttribute("login", user);
				session.setMaxInactiveInterval(30*60*60);
				
				if(user.getAuth() == 3) { // 일반 유저
					req.getRequestDispatcher("./Main.jsp").forward(req, resp);
				}else { // 관리자 페이지
					req.getRequestDispatcher("admin_servlet?command=adminChart").forward(req, resp);
				}
				
				
			}
		
		}else if(command.equals("custaccount")) {
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			String birthday = req.getParameter("birthday");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			/*
			System.out.println(id);
			System.out.println(pwd);
			System.out.println(name);
			System.out.println(address);
			System.out.println(birthday);
			System.out.println(phone);
			System.out.println(email);
			*/
			CustomerDto dto = new CustomerDto(id, pwd, name, address, birthday, phone, email);
			
			dao.addCustomer(dto);
			
			req.getRequestDispatcher("./Customer/login.jsp").forward(req, resp);

		}else if(command.equals("custupdate")) {
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			String birthday = req.getParameter("birthday");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			CustomerDto dto = new CustomerDto(id, pwd, name, address, birthday, phone, email);
			
			dao.infoChangeCustomer(dto);
			
			req.getRequestDispatcher("./Customer/mypage.jsp").forward(req, resp);
			
		}
		
	}

}
