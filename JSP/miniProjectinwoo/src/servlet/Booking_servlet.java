package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDao;
import dao.RoomDao;
import dao.iBookingDao;
import dao.iRoomDao;
import dto.BookingDto;
import dto.RoomDto;

@WebServlet("/booking_servlet")
public class Booking_servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dogetIn");
		String command = "";	// 페이지 히든
		
		String visit_date = "";	// 입실
		String leave_date = ""; // 퇴실
		int adult_number = 1;	// 인원(어른)
		int child_number = 0;	// 인원(어린이)
		String Sprice = "";
		int price = 0;
		String grade = "";
		String room_number = "";
		String id = "asd";	// id 합칠경우 값 "" 으로 초기화
		
		command = req.getParameter("command");
		
		iRoomDao RDao = RoomDao.getInstance();
		iBookingDao BDao = BookingDao.getInstance();
		
		BookingDto BDto = new BookingDto();
		
		if(command.equals("firstBook")) {
	//		System.out.println("FBIN"); 확인용
			visit_date = req.getParameter("visit_date");
			leave_date = req.getParameter("leaver_date");
			adult_number = Integer.parseInt(req.getParameter("adult_number"));
			child_number = Integer.parseInt(req.getParameter("child_number"));
			
			String visitday = visit_date.replace("-", "");	// 자른 문자열
			String leaveday = leave_date.replace("-", "");	// 자른 문자열
			
			
			System.out.println("visit_date:" + visit_date);
			System.out.println("leaver_date:" + leave_date);
			System.out.println("adult_number:" + adult_number);
			System.out.println("child_number:" + child_number);
			
			
			System.out.println("visitday == " + visitday);
			List<RoomDto> AllList = RDao.getAllList(visitday);	// 사용가능한 방 리스트
			
			System.out.println(AllList.toString());

			BDto = new BookingDto(visit_date, leave_date, adult_number, child_number);
			
			System.out.println(BDto.toString());
			
			req.setAttribute("dto", BDto);
			
			System.out.println("Bdto 저장함");
			
			req.setAttribute("All", AllList);
			
			System.out.println("AllList 저장함");
			
			req.getRequestDispatcher("./Booking/secondBook.jsp").forward(req, resp);
			
		}else if(command.equals("secondBook")) {
			
//			System.out.println("세컨드북 들어옴");	확인용
			
//			id = req.getParameter("id");	합칠경우 주석 해제
			
			visit_date = req.getParameter("visit_date");
			leave_date = req.getParameter("leave_date");
			
			String visitday = visit_date.replace("-", "");	// - 자른 문자열
			String leaveday = leave_date.replace("-", "");	//	- 자른 문자열
			
			System.out.println("leave_date"+leave_date);
			
			adult_number = Integer.parseInt(req.getParameter("adult_number"));
			child_number = Integer.parseInt(req.getParameter("child_number"));
			room_number = req.getParameter("room_number");
			
			Sprice = req.getParameter("price");
			
			Sprice = Sprice.replace(",", "");	// 가격도 Int값으로 사용을 위해 , 잘라서 사용
			
			price = Integer.parseInt(Sprice);
			
			int result = 0;
			
			// 날짜 차이 구하는 코드
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			
			try {
				Date visitD = format.parse(visit_date);
				Date LeaveD = format.parse(leave_date);
				System.out.println("트라이");
				
				long calDate = LeaveD.getTime() - visitD.getTime();
				
				long calD = calDate / (24*60*60*1000);
				
				calD = Math.abs(calD);
				System.out.println("결과" + calD);
				result = (int)calD;
			} catch (ParseException e) {

				e.printStackTrace();
			}
			
			result = result * price;	// 날짜 차이를 구한후 금액과 * 
			
			BDto = new BookingDto(id, visitday, leaveday, result, adult_number, child_number, room_number);
			
			
			
			boolean b = BDao.InsertBook(BDto);	
			
			if(b) {	// 입력 성공 여부 확인
				System.out.println("db데이터 입력성공");	
			}else {
				System.out.println("db데이터 입력 실패");
			}
			
			BDto = new BookingDto(id, visit_date, leave_date, result, adult_number, child_number, room_number);
			
			
			
			req.setAttribute("dto", BDto);
			
			System.out.println("thirdBook.jsp 로 이동");
			req.getRequestDispatcher("./Booking/thirdBook.jsp").forward(req, resp);
			
			
		}else if(command.equals("first")) {
			req.getRequestDispatcher("./Booking/firstBook.jsp").forward(req, resp);
		}else if(command.equals("mypage")) {
			req.getRequestDispatcher("./Custumor/abc.jsp").forward(req, resp);
		}else if(command.equals("home")) {
			req.getRequestDispatcher("./Introduction/abc.jsp").forward(req, resp);
		}else if(command.equals("Main")) {
			req.getRequestDispatcher("./Booking/Main.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
}
