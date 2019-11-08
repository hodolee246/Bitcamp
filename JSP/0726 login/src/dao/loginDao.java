package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sun.text.normalizer.CharTrie.FriendAgent;

public class loginDao {
	private static loginDao dao = null;
	
	private loginDao() {
		try {
			Class.forName("oracle.jdbc.driver.Oracle.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static loginDao getInstance() {
		if(dao == null) {
			dao = new loginDao();
		}
		return dao;
	}
	public void close(Connection conn, PreparedStatement psmt, ResultSet rs) {
		try {
			if(rs != null) {
			rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
}
	
	public Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@192.168.0.47:1521:xe";
		String user = "hr";
		String pass = "hr";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		return conn;
	}
	
	public boolean account(String id, String pw, String name, String email) {
		
		String sql = " INSERT INTO LOGIN "
					+ " VALUES(?, ?, ?, ?)" ;
		System.out.println("sql:" + sql);
		boolean b = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  id.trim());
			psmt.setString(2,  pw.trim());
			psmt.setString(3,  name.trim());
			psmt.setString(4,  email.trim());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				b = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, rs);
		}
		
		return b;
	}
	
public boolean login(String id, String pw) {
		
		String sql = " SELECT * "
				+ "	FROM LOGIN "
				+ " WHERE ID=? AND PW=? " ;
		System.out.println("sql:" + sql);
		boolean b = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  id.trim());
			psmt.setString(2,  pw.trim());

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				b = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, rs);
		}
		
		return b;
	}
	
public boolean idcheck(String id) {
	
	String sql = " SELECT ID "
			+ "	FROM LOGIN "
			+ " WHERE ID =? " ;
	System.out.println("sql:" + sql);
	boolean b = false;
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	try {
		conn = this.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1,  id.trim());

		
		rs = psmt.executeQuery();
		
		if(rs.next()) {
			b = true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(conn, psmt, rs);
	}
	
	return b;
}






}
