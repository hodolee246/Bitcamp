package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.accountDao;
import db.DBClose;
import db.DBConnection;
import model.AccountDto;

public class accountDaoImpl implements accountDao {

	@Override
	public boolean addAccount(String id, String pwd, String name, int age) {
		String sql = " INSERT INTO ACCOUNT(ID, PWD, NAME, AGE) " 
					+ " VALUES(?, ?, ?, ?) ";

		Connection conn = null;
		PreparedStatement psmt = null;

		System.out.println("sql:" + sql);

		int count = 0;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pwd.trim());
			psmt.setString(3, name.trim());
			psmt.setInt(4, age);

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
		String sql = " SELECT ID " + " FROM ACCOUNT " + " WHERE ID = '" + id + "' ";

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
	public AccountDto login(String id, String pw) {
		String sql = " SELECT ID, PWD, NAME, AGE " + " FROM ACCOUNT " + " WHERE ID=? AND PWD=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		AccountDto mem = null;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pw.trim());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String _id = rs.getString(1);
				String _pwd = rs.getString(2); 
				String _name = rs.getString(3);
				int _age = rs.getInt(4); 

				mem = new AccountDto(_id, _pwd, _name, _age);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return mem;
	}

	
	
}
