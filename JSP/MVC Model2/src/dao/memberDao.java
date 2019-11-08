package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.memberDto;

public class memberDao {
	private static memberDao dao = null;
	
	private memberDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static memberDao getInstance() {
		if(dao == null) {
			dao = new memberDao();
		}
		return dao;
	}
	
	public Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@192.168.0.47:1521:xe";
		String user = "hr";
		String pass = "hr";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		return conn;
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
	
	public boolean account(String id, String pw, String name, String email) {
		String sql = " INSERT INTO COFFEEMEMBER  "
					+ "	VALUES(?, ?, ?, ?) ";
		
		System.out.println(sql);
		
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		
		memberDto dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pw.trim());
			psmt.setString(3, name.trim());
			psmt.setString(4, email.trim());
			
			count = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, null);
		}
		
		return count > 0?true:false;
	}
	
	public boolean IDcheck(String id) {
		String sql = " SELECT ID "
				+ " FROM COFFEEMEMBER"
				+ " WHERE ID=? ";
		
		System.out.println(sql);
		
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		
		memberDto dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());

			
			count = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, null);
		}
		
		return count > 0?true:false;
	}
	
	public boolean login(String id, String pw) {
		String sql = " SELECT ID, PW"
				+ " FROM COFFEEMEMBER"
				+ " WHERE ID=? AND PW=? ";
		
		System.out.println(sql);
		
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		
		memberDto dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pw.trim());
			
			count = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, null);
		}
		
		return count > 0?true:false;
	}
	
}
