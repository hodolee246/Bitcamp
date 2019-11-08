package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BookingDto;

public class BookingDao implements iBookingDao{
	
	private static BookingDao bookingdao = new BookingDao();
	
	private BookingDao() {
		DBConnection.initConnect();
	}
	
	public static BookingDao getInstance() {
		return bookingdao;
	}

	@Override
	public boolean InsertBook(BookingDto dto) {


		String sql = " INSERT INTO BOOKING(SEQ, ID, WDATE, VISIT_DATE, LEAVE_DATE, "
				+ " TOTAL_PRICE, ADULT_NUMBER, CHILD_NUMBER, ROOM_NUMBER) "
				+ " VALUES(SEQ_BOOKING.NEXTVAL, ?, SYSDATE, ?, ?, ?, ?, ?, ?) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		System.out.println("sql:" + sql);
		int count = 0;
		
		try {
			conn = db.DBConnection.getConnection();
			System.out.println("1/6 booking suc");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 booking suc");
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getVisit_date());
			psmt.setString(3, dto.getLeave_date());
			psmt.setInt(4, dto.getTotal_price());
			psmt.setInt(5, dto.getAdult_number());
			psmt.setInt(6, dto.getChild_number());
			psmt.setString(7, dto.getRoom_number());
			System.out.println("3/6 booking suc");
			count = psmt.executeUpdate();
			System.out.println("4/6 booking suc");
			
		} catch (Exception e) {
			System.out.println("booking fail" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		
		return count > 0 ? true : false;
	}

	@Override
	public List<BookingDto> SelectBook(String id) {

		String sql = " SELECT * "
				+ " FROM BOOKING "
				+ " WHERE ID = ? " ;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println("sql:" + sql);
		List<BookingDto> list = new ArrayList<BookingDto>();
		
		try {
			conn = db.DBConnection.getConnection();
			System.out.println("1/6 SelectBook suc");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 SelectBook suc");
			psmt.setString(1, id);	
			
			rs = psmt.executeQuery();
			
			System.out.println("3/6 SelectBook suc");
			
			while(rs.next()) {
				BookingDto dto = new BookingDto(rs.getInt(1),
												rs.getString(2),
												rs.getDate(3),
												rs.getString(4),
												rs.getString(5),
												rs.getInt(6),
												rs.getInt(7),
												rs.getInt(8),
												rs.getString(9));
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println("SelectBook fail" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		
		return list;
	}

	
	
	
	
}
