package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.RoomDto;

public class RoomDao implements iRoomDao {
	
	public static RoomDao roomdao = new RoomDao();
	
	public RoomDao() {
		DBConnection.initConnect();
	}
	
	public static RoomDao getInstance() {
		return roomdao;
	}
	
	

	@Override
	public List<RoomDto> getAllList(String visit_date) {
		
		System.out.println("visit_date:" + visit_date);
		
		String sql = " SELECT ROOM_NUMBER, PRICE, GRADE"
				+ " FROM ROOM "
				+ " WHERE ROOM_NUMBER NOT IN "
				+ " (SELECT ROOM_NUMBER FROM BOOKING WHERE "
				+ " TO_DATE(LEAVE_DATE, 'YYYYMMDD') - TO_DATE( " + visit_date + ", 'YYYYMMDD') > -1) "
				+ " ORDER BY ROOM_NUMBER DESC ";
		
		System.out.println("sql:" + sql);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<RoomDto> list = new ArrayList<RoomDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getRoomList suc");

			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getRoomList suc");

			rs = psmt.executeQuery();
			System.out.println("3/6 getRoomList suc");

			while (rs.next()) {
				RoomDto dto = new RoomDto(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(dto);
			}
			System.out.println("4/6 getRoomList suc");

		} catch (Exception e) {
			System.out.println("getRoomList fail " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}

		return list;

	}

	@Override	// 페이징 용이라 삭제해도 상관없음
	public List<RoomDto> getList(int num1, int num2, String visit_date) {
		String sql = " SELECT ROOM_NUMBER, PRICE, GRADE " +
		" FROM " +
			"(SELECT ROW_NUMBER()OVER(ORDER BY ROOM_NUMBER DESC) AS RNUM, ROOM_NUMBER, " + 
			" PRICE, GRADE " +
			" FROM ROOM " +
			" ORDER BY GRADE, ROOM_NUMBER ) " +
		" WHERE RNUM >= ? AND RNUM <= ? AND ROOM_NUMBER NOT IN " + 
		 								" (SELECT ROOM_NUMBER FROM BOOKING WHERE " + 
		 								" TO_DATE(LEAVE_DATE, 'YYYYMMDD') - TO_DATE( " + visit_date + ", 'YYYYMMDD') > -1) " +
		" ORDER BY GRADE, ROOM_NUMBER DESC ";
		
		
	
		System.out.println("sql " + sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<RoomDto> list = new ArrayList<RoomDto>();
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getRoomList suc");

			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getRoomList suc");
			psmt.setInt(1, num1);
			psmt.setInt(2, num2);
			
			rs = psmt.executeQuery();
			
			
			System.out.println("3/6 getRoomList suc");

			while (rs.next()) {
				RoomDto dto = new RoomDto(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(dto);
			}
			System.out.println("4/6 getRoomList suc");

		} catch (Exception e) {
			System.out.println("getRoomList fail " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}

		return list;
	}

	

}
