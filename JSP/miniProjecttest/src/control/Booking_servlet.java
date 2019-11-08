package control;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDao;
import dto.AdminTodayBookingDto;


@WebServlet("/booking_servlet")
public class Booking_servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		BookingDao dao = BookingDao.getInstance();
		
		String command = req.getParameter("command");
		
		if(command.equals("adminBooking")) {
			// 예약조회관리 페이지로 이동
			System.out.println("command : adminBooking");
			
			String year = req.getParameter("year");
			String month = req.getParameter("month");
			String day = req.getParameter("day");
			String date = "";
			
			if(year == null && day == null && month == null) {
				// 첫 이동할 때 null값이 들어온다
				date = "";
			}else {
				// 검색할 때 해당 년월일이 들어온다
				date = year+month+day;
			}
			
			// 첫 이동할 때 현재 날짜를 넣는다
			if(date.equals("")) {
				Calendar cal = Calendar.getInstance();
				int todayYear = cal.get(Calendar.YEAR);
				
				String todayMonth = ""+(cal.get(Calendar.MONTH)+1);
				if(todayMonth.length() < 2) {
					todayMonth = "0"+todayMonth;
				}
				
				String todayDay = ""+cal.get(Calendar.DATE);
				if(todayDay.length() < 2) {
					todayDay = "0"+todayDay;
				}
				
				date = ""+todayYear+todayMonth+todayDay;
			}
			System.out.println("date : " + date);
			
			List<AdminTodayBookingDto> list = dao.getTodayBooking(date);
			//List<TodayBookingDto> list = dao.getTodayBooking();
			
			req.setAttribute("list", list);
			req.setAttribute("date", date);
			req.getRequestDispatcher("./Admin/adminbooking.jsp").forward(req, resp);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
