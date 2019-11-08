package insert;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBConnection;
/*
  CREATE TABLE LOGINDTO(
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(20),
	AGE NUMBER(10)
);
 */
public class Insert {
public int Insert(String id, String pw, String name, int age) {
		
		String sql = " INSERT INTO USERDTO(ID, NAME, AGE, JOINDATE) "
				+ " VALUES('" + id + "', '" + pw + "', '" +  name + "', " + age + ", SYSDATE) ";
		
		
		DBConnection dc = new DBConnection();	// db conn 주소값 입력
		
		Connection conn = dc.getConnection();
		Statement stmt = null;
		
		int count = 0;
		
		System.out.println("sql :" + sql); 
		
		try {
			stmt = conn.createStatement();		
			
		count =	stmt.executeUpdate(sql);	
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {			
			try {		
			if(stmt != null) {	
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			} catch (SQLException e) { 		
				
				e.printStackTrace();
			}
		}
		return count;
	}
}
