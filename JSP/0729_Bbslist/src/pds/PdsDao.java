package pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import pds.PdsDto;

public class PdsDao implements ipdsDao{

	private static PdsDao dao = new PdsDao();
	
	public PdsDao() {
	}
	
	public static PdsDao getInstance() {
		return dao;
	}

	@Override
	public List<PdsDto> getPdsList() {
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, FILENAME, "
				+ " READCOUNT, DOWNCOUNT, REGDATE "
				+ " FROM PDS  "
				+ " ORDER BY SEQ DESC ";
		
		System.out.println("sql:" + sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PdsDto> list = new ArrayList<PdsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getPdsList suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getPdsList suc");
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("3/6 getPdsList suc");
				
				int i = 1;
				
				PdsDto dto = new PdsDto(rs.getInt(i++),
										rs.getString(i++),
										rs.getString(i++),
										rs.getString(i++),
										rs.getString(i++),
										rs.getInt(i++),
										rs.getInt(i++),
										rs.getString(i++));
				
				list.add(dto);
				System.out.println("4/6 getPdsList suc");
				
			}
		} catch (Exception e) {
			System.out.println("getPdsList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return list;
	}

	@Override
	public boolean insertPds(String id, String title, String content, String filename) {
		String sql = " INSERT INTO PDS(SEQ, ID, TITLE, CONTENT, FILENAME, READCOUNT, DOWNCOUNT, REGDATE) "
				+ " VALUES(SEQ_PDS.NEXTVAL, ?, ?, ?, ?, 0, 0, SYSDATE) ";
		
		System.out.println("sql:"+sql);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, title);
			psmt.setString(3, content);
			psmt.setString(4, filename);
			
			count = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0?true:false;
		
		
	}
		
	public void pdsReadCount(int seq) {
		String sql = " UPDATE PDS "
				+ " SET READCOUNT = (SELECT READCOUNT FROM PDS WHERE SEQ=?) + 1 "
				+ " WHERE SEQ=? ";
		System.out.println("sql:" + sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(seq, 1);
			psmt.setInt(seq, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public PdsDto getPds(int seq) {
		String sql = " SELECT ID, TITLE, CONTENT, FILENAME  "
				+ " FROM PDS  "
				+ " WHERE SEQ = ? ";
		System.out.println("sql:" + sql);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		PdsDto dto = null;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(seq, 1);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int i = 1;
				dto = new PdsDto(rs.getString(i++),
									rs.getString(i++),
									rs.getString(i++),
									rs.getString(i++));
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public void pdsDownCount(int seq) {
		String sql = " UPDATE PDS "
				+ " SET READCOUNT = (SELECT READCOUNT FROM PDS WHERE SEQ=?) + 1 "
				+ " WHERE SEQ=? ";
		System.out.println("sql:" + sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(seq, 1);
			psmt.setInt(seq, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean updatePds(String title, String filename, String content, int seq) {
		
		String sql = " UPDATE PDS "
				+ " SET TITLE=?, FILENAME=?, CONTENT=? "
				+ " WHERE SEQ=? ";
		
		System.out.println("sql:" + sql);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, filename);
			psmt.setString(3, content);
			psmt.setInt(4, seq);
			count = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return count>0?true:false;
	}

	@Override
	public boolean deletePds(int seq) {
		String sql = " DELETE "
				+ " FROM PDS "
				+ " WHERE SEQ=? ";
		
		System.out.println("sql:" + sql);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			count = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return count>0?true:false;
	}
	
}
