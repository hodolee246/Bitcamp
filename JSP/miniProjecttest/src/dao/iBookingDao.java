package dao;

import java.util.List;

import dto.AdminChartDto;
import dto.AdminTodayBookingDto;
import dto.BookingDto;

public interface iBookingDao {

	public boolean InsertBook(BookingDto dto);
	
	public List<BookingDto> SelectBook(String id);
	
	// 관리자 페이지에서 예약조회관리
	public List<AdminTodayBookingDto> getTodayBooking(String date);
	
	// 관리자 페이지에서 일별통계
	public List<AdminChartDto> chartDaily(String month);
}
