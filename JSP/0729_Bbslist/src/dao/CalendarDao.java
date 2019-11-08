package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.CalendarDto;

public class CalendarDao implements iCalendar {

	private static CalendarDao dao = new CalendarDao();
	
	private CalendarDao() {
	}
	
	public static CalendarDao getInstance() {
		return dao;
		
	}
	
	
	@Override
	public List<CalendarDto> getCalendarList(String id,  String yyyyMM){
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE " +
					" FROM (SELECT ROW_NUMBER() OVER(PARTITION BY SUBSTR(RDATE, 1, 8) ORDER BY RDATE ASC) RNUM, " +
					" 		SEQ, ID, TITLE, CONTENT, RDATE, WDATE " +
					" 		FROM CALENDAR " +
					" 		WHERE ID = ? AND SUBSTR(RDATE, 1, 6)=? ) " +
					" WHERE RNUM BETWEEN 1 AND 5 ";
		
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getCalendarList suc");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyyMM.trim());
			System.out.println("2/6 getCalendarList suc");
			rs = psmt.executeQuery();
			System.out.println("3/6 getCalendarList suc");
			
			while(rs.next()) {
				int i = 1;
				CalendarDto dto = new CalendarDto(rs.getInt(i++),
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++));
											
				list.add(dto);
			}
			System.out.println("4/6 getCalendarList suc");
			
		} catch (Exception e) {
			System.out.println("getCal fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
		
	}
	
	public List<CalendarDto> getCalList(String id,  String yyyymmdd){
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE " +
				" FROM (SELECT ROW_NUMBER() OVER(PARTITION BY SUBSTR(RDATE, 1, 8) ORDER BY RDATE ASC) RNUM, " +
				" 		SEQ, ID, TITLE, CONTENT, RDATE, WDATE " +
				" 		FROM CALENDAR " +
				" 		WHERE ID = ? AND SUBSTR(RDATE, 1, 8)=? ) " +
				" WHERE RNUM BETWEEN 1 AND 5  " +
				" ORDER BY RDATE ASC";
		
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getCalendarList suc");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyymmdd.trim());
			System.out.println("2/6 getCalendarList suc");
			rs = psmt.executeQuery();
			System.out.println("3/6 getCalendarList suc");
			
			while(rs.next()) {
				int i = 1;
				CalendarDto dto = new CalendarDto(rs.getInt(i++),
												rs.getString(i++),
												rs.getString(i++),
												rs.getString(i++),
												rs.getString(i++),
												rs.getString(i++));
											
				list.add(dto);
			}
			System.out.println("4/6 getCalendarList suc");
			
		} catch (Exception e) {
			System.out.println("getCal fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
		
	}
	
	@Override
	public boolean addCalendarList(String id, String title, String content, String rdate) {
		
		String sql = " INSERT INTO CALENDAR (SEQ, ID, TITLE, CONTENT, RDATE, WDATE) " +
				" VALUES(SEQ_CAL.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		System.out.println("sql:"+sql);
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, title);
			psmt.setString(3, content);
			psmt.setString(4, rdate);
			
			count = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count>0?true:false;
	}
	
	public CalendarDto CalendarDetail(int seq, String id) {
		
		String sql = " SELECT ID, TITLE, CONTENT, RDATE " +
					" FROM CALENDAR " +
					" WHERE SEQ =? AND ID = ? " ;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		CalendarDto dto = null;
		System.out.println("sql:"+sql);
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			psmt.setString(2, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new CalendarDto(rs.getString(1), 
										rs.getString(2), 
										rs.getString(3), 
										rs.getString(4));
 			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return dto;
	}
	
}
