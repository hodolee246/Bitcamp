package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.coffeDto;

public class coffeDao {
	
private static coffeDao dao = null;
	
	private coffeDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static coffeDao getInstance() {
		if(dao == null) {
			dao = new coffeDao();
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
	
	public List<coffeDto> getmenu(){
		String sql = " SELECT ESPRESSOBEVERAGES, SHORT, TALL, GRANDE "
				+ " FROM COFFEEMONEY"
				+ " ORDER BY SHORT DESC ";
		
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<coffeDto> list = new ArrayList<coffeDto>();
		
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String coffee = rs.getString("ESPRESSOBEVERAGES");
				String size_short = rs.getString("SHORT");
				String size_tall = rs.getString("TALL");
				String size_grande = rs.getString("GRANDE");
				
				coffeDto cd = new coffeDto(coffee, size_short, size_tall, size_grande);
				
				list.add(cd);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close(conn, psmt, rs);
		}
		return list;
		
	}
}
