package dao;

import java.util.List;

import dto.AdminChartDto;
import dto.AdminTodayBookingDto;
import dto.BookingDto;

public interface iBookingDao {

	//예약내역 데이터베이스에 넣기
	public boolean InsertBook(BookingDto dto);
	
	//마이페이지 내가 예약한 list
	public List<BookingDto> SelectBook(String id);
	
	// 관리자 페이지에서 입실조회관리
	public List<AdminTodayBookingDto> getTodayVisit(String date);
	
	// 관리자 페이지에서 퇴실조회관리  LEAVE_DATE
	public List<AdminTodayBookingDto> getTodayLeave(String date);
	
	// 관리자 페이지에서 일별통계
	public List<AdminChartDto> chartDaily(String month);
	
	
		
	
}
