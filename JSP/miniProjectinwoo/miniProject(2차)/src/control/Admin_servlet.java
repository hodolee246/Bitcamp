package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.PersonQnADao;
import dao.RoomDao;
import dao.iAdminDao;
import dao.iPersonQnADao;
import dao.iRoomDao;
import dto.AdminChartDto;
import dto.PersonQnADto;
import dto.RoomDto;

@WebServlet("/admin_servlet")
public class Admin_servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Admin_servlet doGet");
		
		String command = req.getParameter("command");
		
		iPersonQnADao qnaDao = PersonQnADao.getInstance();
		iRoomDao roomDao = RoomDao.getInstance();
		iAdminDao adminDao = AdminDao.getInstance();
		
		
		if(command.equals("adminpage")) {
			req.getRequestDispatcher("./Admin/adminmainpage.jsp").forward(req, resp);
		}
		// 고객의 소리 List로 보내주기
		else if(command.equals("qnalist")) {
			String choiceStr = req.getParameter("choice");
			String str = req.getParameter("str");
			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			
			System.out.println("servlet choiceStr : " + choiceStr + " str : " + str);
			
			List<PersonQnADto> list = qnaDao.getPersonQnAList(choiceStr, str, pageNum);
			int count = qnaDao.getCount(choiceStr, str);
			
			// 짐 싸기
			req.setAttribute("choice", choiceStr);
			req.setAttribute("str", str);
			req.setAttribute("pageNum", pageNum);
			
			req.setAttribute("count", count);
			req.setAttribute("list", list);
			
			// 보내기
			req.getRequestDispatcher("./PersonQnA/personqna.jsp").forward(req, resp);
		
		}
		
		// 입력한 comments를 받아서 DB를 Update
		else if(command.equals("qnaupdate")) {
			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			
			String comments = req.getParameter("comments");
			int seq = Integer.parseInt(req.getParameter("seq"));
			System.out.println("comments : " + comments + " seq : " + seq);
		
			boolean isS = qnaDao.updateQnA(comments, seq);
		
			if(isS == true) {
				System.out.println("답변 등록 성공");
			}
			else {
				System.out.println("답변 등록 실패");
			}
		
			resp.sendRedirect("admin_servlet?command=qnalist&choice=&str=&pageNum=" + pageNum);
		}
		
		// 객실정보 관리 페이지로 보내주기
		else if(command.equals("roomadmin")) {
			
			List<RoomDto> list = roomDao.getRoomList();
			
			// 짐 싸기
			req.setAttribute("roomlist", list);
			
			// 보내기
			req.getRequestDispatcher("./Room/roomadmin.jsp").forward(req, resp);
		}
		
		// 객실 등록
		else if(command.equals("addroom")) {
			String roomNum = req.getParameter("roomNum");
			String roomPrice = req.getParameter("roomPrice");
			String roomGrade = req.getParameter("roomGrade");
			
			RoomDto dto = new RoomDto(roomNum, roomPrice, roomGrade);
			
			boolean isS = roomDao.addRoom(dto);
			
			if(isS == true) {
				System.out.println("객실 등록 성공");
			}
			else {
				System.out.println("객실 등록 실패");
			}
			
			// 보내기
			resp.sendRedirect("admin_servlet?command=roomadmin");
		}
		
		// 객실 수정
		else if(command.equals("updateroom")) {
			String roomNum = req.getParameter("roomNum");
			String roomPrice = req.getParameter("roomPrice");
			String roomGrade = req.getParameter("roomGrade");
			
			RoomDto dto = new RoomDto(roomNum, roomPrice, roomGrade);
			
			boolean isS = roomDao.updateRoom(dto);
			
			if(isS == true) {
				System.out.println("객실 수정 성공");
			}
			else {
				System.out.println("객실 수정 실패");
			}
			
			// 보내기
			resp.sendRedirect("admin_servlet?command=roomadmin");
		}
		
		// 객실 삭제
		else if(command.equals("deleteroom")) {
			String roomNum = req.getParameter("roomNum");
			
			boolean isS = roomDao.deleteRoom(roomNum);
			
			if(isS == true) {
				System.out.println("객실 삭제 성공");
			}
			else {
				System.out.println("객실 삭제 실패");
			}
			
			// 보내기
			resp.sendRedirect("admin_servlet?command=roomadmin");
			
		}else if(command.equals("adminChart")) {
			// 통계 페이지로 이동
			String month = req.getParameter("month");
			
			if(month == null) {
				Calendar cal = Calendar.getInstance();
				month = ""+(cal.get(Calendar.MONTH)+1);
				if(month.length() < 2) {
					month = "0"+month;
				}
			}
			System.out.println("month : " + month);
			

			List<AdminChartDto> priceList = new ArrayList<AdminChartDto>();
			List<AdminChartDto> addressList = new ArrayList<AdminChartDto>();
			List<AdminChartDto> ageList = new ArrayList<AdminChartDto>();
			
			priceList = adminDao.chartDaily(month);
			addressList = adminDao.chartArea();
			ageList = adminDao.chartAge();
			
			req.setAttribute("month", month);
			req.setAttribute("priceList", priceList);
			req.setAttribute("addressList", addressList);
			req.setAttribute("ageList", ageList);
			req.getRequestDispatcher("./Admin/adminchart.jsp").forward(req, resp);
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Admin_servlet doPost");
		
		String command = req.getParameter("command");
		
		iPersonQnADao qnaDao = PersonQnADao.getInstance();
		iRoomDao roomDao = RoomDao.getInstance();
		iAdminDao adminDao = AdminDao.getInstance();
		
		
		if(command.equals("adminChart")) {
			// 통계 페이지로 이동
			String month = req.getParameter("month");
			
			if(month == null) {
				Calendar cal = Calendar.getInstance();
				month = ""+(cal.get(Calendar.MONTH)+1);
				if(month.length() < 2) {
					month = "0"+month;
				}
			}
			System.out.println("month : " + month);
			

			List<AdminChartDto> priceList = new ArrayList<AdminChartDto>();
			List<AdminChartDto> addressList = new ArrayList<AdminChartDto>();
			List<AdminChartDto> ageList = new ArrayList<AdminChartDto>();
			
			priceList = adminDao.chartDaily(month);
			addressList = adminDao.chartArea();
			ageList = adminDao.chartAge();
			
			req.setAttribute("month", month);
			req.setAttribute("priceList", priceList);
			req.setAttribute("addressList", addressList);
			req.setAttribute("ageList", ageList);
			req.getRequestDispatcher("./Admin/adminchart.jsp").forward(req, resp);
			
		}
		
	}
	

}
