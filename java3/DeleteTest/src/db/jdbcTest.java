package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTest {

	public jdbcTest() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver Loading Success");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.47:1521:xe", "hr", "hr");		// 커넥션 주소 및 연결할 아이디 패스워드
		
			System.out.println("DB Connection Success");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public int Delete(String NAME) {
		String sql = " DELETE "
				+ " FROM USERDTO "
				+ " WHERE NAME = '" + NAME + "'";
		// 항상 쿼리문을 작성할때에는 앞 뒤로 한칸씩 띄어놔야 오류가 안난다 붙여서 쓸경우 오류가 나올경우가 있다(많다)
		Connection conn = getConnection();		// 위에서 만든 getconnection == 오라클 주소 및 아이디 패스워드를 넣어져있는 값을 새로운 conn 에 그대로 가져온다.
		Statement stmt = null;
		
		int count = 0;
		
		System.out.println("sql :" + sql); // sql 문장은 , ' " 하나로 오류가 발생하기 때문에 왠만하면 sql을 무조건 확인해봐야 한다.
		
		try {
			stmt = conn.createStatement();		// 연결한 db의 상태로 statment 를 만들어낸다.
			
		count =	stmt.executeUpdate(sql);	// sql 문장을 적은 String 변수를 execute에 넣는다 *execute = 실행하다.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {			// 무조건 실행시키게 해서 전부다 사용후 커넥션 스테이터스 를 닫아줘야한다.
			try {		// 이런식으로 if 문 밖으로 try catch 문을 밖으로 뺄경우 하나의 try / catch 문으로 여러개를 실행할수있다.
			if(stmt != null) {	
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			} catch (SQLException e) { 		// // 이런식으로 if 문 밖으로 try catch 문을 밖으로 뺄경우 하나의 try / catch 문으로 여러개를 실행할수있다.
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	
	
	
}





