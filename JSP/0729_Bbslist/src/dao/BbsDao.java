package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.util.Strftime;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao implements iBbsDao {

	private static BbsDao bbsdao = new BbsDao();

	private BbsDao() {
	}

	public static BbsDao getInstance() {
		return bbsdao;
	}

	@Override
	public List<BbsDto> getBbsList() {

		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, " + " TITLE, CONTENT, WDATE, PARENT, " + " DEL, READCOUNT "
				+ " FROM BBS " + " ORDER BY REF DESC, STEP ASC ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<BbsDto> list = new ArrayList<BbsDto>();

		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList suc");

			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList suc");

			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList suc");

			while (rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
				list.add(dto);
			}
			System.out.println("4/6 getBbsList suc");

		} catch (Exception e) {
			System.out.println("getBbsList fail " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}

		return list;
	}
	@Override
	public boolean AddBbsList(BbsDto bbs) {
		String sql = " INSERT INTO BBS "
				+ " (SEQ, ID, "
				+ " REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, "
				+ " DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
				+ " (SELECT NVL(MAX(REF), 0)+1 FROM BBS), "	// 1 2 3		// ref
				+ " 0, 0, "							// step, depth
				+ " ?, ?, SYSDATE, 0, "
				+ " 0, 0) ";

		Connection conn = null;
		PreparedStatement psmt = null;
		System.out.println(sql);
		int count = 0;
		try {
			conn = db.DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bbs.getId());
			psmt.setString(2, bbs.getTitle());
			psmt.setString(3, bbs.getContent());
			count = psmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		return count > 0 ? true : false;
	}
	@Override
	public BbsDto CheckList(int seq) {

		String sql = " SELECT ID, TITLE, CONTENT " + " FROM BBS " + " WHERE SEQ=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println(sql);
		BbsDto dto = null;
		try {
			conn = db.DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);

			rs = psmt.executeQuery();

			while (rs.next()) {
				dto = new BbsDto(rs.getString(1), rs.getString(2), rs.getString(3));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		return dto;
	}
	@Override
	public BbsDto CheckListAll(int seq) {

		String sql = " SELECT * " + " FROM BBS " + " WHERE SEQ=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println(sql);
		BbsDto dto = null;
		try {
			conn = db.DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);

			rs = psmt.executeQuery();

			while (rs.next()) {
				dto = new BbsDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
					
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		return dto;
	}
	@Override
	public List<BbsDto> GetSearch(String select, String text) {

		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, " 
				+ " TITLE, CONTENT, WDATE, PARENT, " 
				+ " DEL, READCOUNT "
				+ " FROM BBS ";

		String sel = "'%" + text.trim() + "%'";
		if (select.equals("ID")) {
			sql = sql + " WHERE ID LIKE ";			
		} else if (select.equals("Title")) {
			sql = sql + " WHERE TITLE LIKE ";
		} else if (select.equals("Content")) {
			sql = sql + " WHERE CONTENT LIKE ";
		}
		sql = sql + sel;

		sql = sql + " ORDER BY REF DESC, STEP ASC ";
		
		System.out.println("sql :" + sql + text);
		List<BbsDto> list = new ArrayList<BbsDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		 
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);

			// psmt.setString(1, "'%" + text + "%'");
			System.out.println("query set ok");
			
			rs = psmt.executeQuery();

			while (rs.next()) {

				System.out.println("while in");
				
				/*BbsDto dto = new BbsDto(
							rs.getString("ID"),
							rs.getString("TITLE"),
							rs.getString("CONTENT"),
							rs.getString("WDATE").toString(),
							rs.getInt("READCOUNT")
						);*/
				
				BbsDto dto = new BbsDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
				
				list.add(dto);
				System.out.println("lst add ok, size:" + list.size());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return list;
	}
	@Override
	public boolean DeleteList(int seq) {

		String sql = " UPDATE BBS "
				+ " SET DEL = 1 "
				+ " WHERE SEQ=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		System.out.println(sql);
		int count = 0;
		try {
			conn = db.DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			count = psmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		return count>0?true:false;
	}
	@Override
	public boolean UpdateList(String title, String content) {

		String sql = " UPDATE BBS "
				+ " SET TITLE = ?, CONTENT = ? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		System.out.println(sql);
		int count = 0;
		try {
			conn = db.DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			count = psmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		return count>0?true:false;
	}
	@Override
	public boolean ReadCount(int seq) {

		String sql = " UPDATE BBS "
				+ " SET READCOUNT = (SELECT READCOUNT FROM BBS WHERE SEQ=?) + 1 "
				+ " WHERE SEQ=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		System.out.println(sql);
		int count = 0;
		try {
			conn = db.DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			count = psmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		return count>0?true:false;
	}

	@Override
	public boolean answer(int seq, BbsDto bbs) {
		// update
		String sql1 = " UPDATE BBS "
					+ "	SET STEP=STEP+1 "
					+ " WHERE REF=(SELECT REF FROM BBS WHERE SEQ=?) "
					+ "		AND STEP>(SELECT STEP FROM BBS WHERE SEQ=?) ";
		/*
		  	2-0-0
			3-0-0	
				3-1-1	-> SEQ
					(3-2-2)	--> 기준점
		step	3-3-1	-> depth
					3-4-2
					3-5-2
			4-0-0
		*/
		
		// insert
		String sql2 = " INSERT INTO BBS "
				+ " (SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
				+ "		(SELECT REF FROM BBS WHERE SEQ=?), "	// REF
				+ "	    (SELECT STEP FROM BBS WHERE SEQ=?) + 1, " //STEP
				+ "		(SELECT DEPTH FROM BBS WHERE SEQ=?) + 1, " // DEPTH
				+ " ?, ?, SYSDATE, ?, 0, 0) "; 	
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			System.out.println("1/6 answer success");
			
			// update
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 answer success");
			
			// psmt 초기화
			psmt.clearParameters();
			
			// insert
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, bbs.getId());
			psmt.setInt(2, seq);	// ref
			psmt.setInt(3, seq);	// step
			psmt.setInt(4, seq);	// depth
			psmt.setString(5, bbs.getTitle());
			psmt.setString(6, bbs.getContent());
			psmt.setInt(7, seq);	// parent
			System.out.println("4/6 answer success");
			
			count = psmt.executeUpdate();
			conn.commit();
			System.out.println("5/6 answer success");
			
		} catch (Exception e) {
			System.out.println("answer fail");			
			try {
				conn.rollback();
			} catch (SQLException e1) {}				
			e.printStackTrace();
		} finally {			
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			DBClose.close(conn, psmt, null);
			System.out.println("6/6 answer success");
		}	
		
		return count>0?true:false;
	}	
	@Override
	public List<BbsDto> getBbsListPaging(int num1, int num2) {

		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "+
				" TITLE, CONTENT, WDATE, PARENT, " +
				" DEL, READCOUNT " +
		" FROM " +
			"(SELECT ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM, " +
				" SEQ, ID, REF, STEP, DEPTH, " +
				" TITLE, CONTENT, WDATE, PARENT, " +
				" DEL, READCOUNT " +
			" FROM BBS " +
			" ORDER BY REF DESC, STEP ASC) " +
		" WHERE RNUM >= ? AND RNUM <= ? ";
		System.out.println("sql " + sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<BbsDto> list = new ArrayList<BbsDto>();

		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList suc");

			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList suc");
			psmt.setInt(1, num1);
			psmt.setInt(2, num2);
			
			rs = psmt.executeQuery();
			
			
			System.out.println("3/6 getBbsList suc");

			while (rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
				list.add(dto);
			}
			System.out.println("4/6 getBbsList suc");

		} catch (Exception e) {
			System.out.println("getBbsList fail " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}

		return list;
	}
	
	
}




