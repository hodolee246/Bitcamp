package up;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;

public class UpdateTest {

	public boolean update(String id, int age) {
		
		String sql = " UPDATE USERDTO "
					+ " SET AGE = " + age + " "
					+ " WHERE ID = '" + id + "'";	// update 쿼리문
	Connection conn = DBConnection.getConnection();	// 기존의 경로를 설정한 커넥션함수를 불러온다.
	Statement stmt = null;
	
	int count = 0;
	
	System.out.println("sql:" + sql);
	
		try {
			stmt = conn.createStatement();	
			
			count = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			DBClose.close(stmt, conn, null);
		}
		return count>0?true:false;		// 0보다 크면 트루 그렇지 않을경우 펄스
	}
}
