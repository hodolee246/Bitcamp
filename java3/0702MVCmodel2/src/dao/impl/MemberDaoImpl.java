package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.MemberDao;
import db.DBClose;
import db.DBConnection;
import model.BbsDto;
import model.MemberDto;

public class MemberDaoImpl implements MemberDao {

	@Override
	public boolean addMember(MemberDto dto) {
		String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) " + " VALUES(?, ?, ?, ?, 3) ";

		Connection conn = null;
		PreparedStatement psmt = null;

		System.out.println("sql:" + sql);

		int count = 0;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}

		return count > 0 ? true : false;
	}

	@Override
	public boolean idCheck(String id) {
		String sql = " SELECT ID " + " FROM MEMBER " + " WHERE ID = '" + id + "' ";

		Connection conn = DBConnection.getConnection(); // 기존의 경로를 설정한 커넥션함수를 불러온다.
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;

		System.out.println("sql:" + sql);

		try {
			stmt = conn.createStatement();

			count = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
		return count != 0 ? true : false;
	}

	@Override
	public MemberDto login(String id, String pw) {
		String sql = " SELECT ID, NAME, EMAIL, AUTH " + " FROM MEMBER " + " WHERE ID=? AND PWD=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		MemberDto mem = null;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pw.trim());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String _id = rs.getString(1); // id
				String _name = rs.getString(2); // name
				String _email = rs.getString(3);// email
				int auth = rs.getInt(4); // auth

				mem = new MemberDto(_id, null, _name, _email, auth);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return mem;
	}
	
	
	
	

}
