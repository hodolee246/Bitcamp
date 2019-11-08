package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BbsDao;
import db.DBClose;
import db.DBConnection;
import model.BbsDto;

public class BbsDaoImpl implements BbsDao {

	@Override
	public List<BbsDto> getBbsList() {
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, " + " WDATE, DEL, READCOUNT " + " FROM BBS "
				+ " ORDER BY WDATE DESC ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<BbsDto> list = new ArrayList<BbsDto>();

		try {

			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7));

				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	
	public boolean addContent(String id, String title, String content, int del, int readcount) {
		String sql = " INSERT INTO BBS(SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				+ "	VALUES(SEQ_BBS.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		BbsDto bbs = null;
		boolean b = false;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, title.trim());
			psmt.setString(3, content.trim());
			psmt.setInt(4, del);
			psmt.setInt(5, readcount);

			rs = psmt.executeQuery();
			if (rs.next()) {
				b = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return b;
	}

	@Override
	public BbsDto selectView(int seq) {

		String sql = " SELECT SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT " + " FROM BBS " + " WHERE SEQ = ? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		BbsDto bbsdto = null;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);

			rs = psmt.executeQuery();

			if (rs.next()) {
				int v_seq = rs.getInt(1);
				String v_id = rs.getString(2);
				String v_title = rs.getString(3);
				String v_content = rs.getString(4);
				String v_wdate = rs.getString(5);
				int v_del = rs.getInt(6);
				int v_readcount = rs.getInt(7);

				bbsdto = new BbsDto(v_seq, v_id, v_title, v_content, v_wdate, v_del, v_readcount);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return bbsdto;
	}
	
}
