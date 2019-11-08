package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	
	
	public static void initConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		String url = "jdbc:oracle:thin:@192.168.0.10:1521:xe";
		String user = "hr";
		String pw = "hr";

		// Database 연결
		Connection conn = DriverManager.getConnection(url, user, pw);
		
		return conn;
	}
	
}
