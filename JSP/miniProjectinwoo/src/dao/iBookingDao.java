package dao;

import java.util.List;

import dto.BookingDto;

public interface iBookingDao {

	public boolean InsertBook(BookingDto dto);
	
	public List<BookingDto> SelectBook(String id);
	
}

/*
 * private int seq; private String id; private String wdate; private String
 * visit_date; private String leave_date; private String total_price; private
 * int adult_number; private int child_number; private String room_number;
 */