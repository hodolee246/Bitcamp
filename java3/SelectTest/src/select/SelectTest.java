package select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.UserDto;

public class SelectTest {

	// 하나의 데이터 -> dto
	
	public UserDto Search(String id) {
		
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
					+ " FROM USERDTO "
					+ " WHERE ID = '" + id + "' ";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		ResultSet rs = null;
		
		UserDto dto = null;
		
		System.out.println("sql:" + sql);		// 확인은 늘 하자!
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) { 	// Query를 통해서산출된 데이터

				String _id = rs.getString("id");
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");	// 컬럼의 순서는 맞아야 작동한다.
				
				dto = new UserDto(_id, _name, _age, _joindate);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
				DBClose.close(stmt, conn, rs);;
		}
		return dto;
	}
	
	public UserDto search2(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO "
				+ " WHERE ID = ? "; // 이것만 있으면 따로 안적어 줘도 된다. PreparedStatement ??
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement psmt = null;
		ResultSet rs = null;
		UserDto dto = null;
		
		System.out.println("sql: " + sql);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);		// id 값이 첫번째 ? 에 대입된다.  id -> ? 대입!
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {	//Query를 통해서 산출된 데이터. 만약 조건이 안맞으면 안들어 온다. 	// if문은 하나의 데이터를 줄때
				
				String _id = rs.getString("id");
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");	// 컬럼의 순서가 맞아야 한다. 위에 sql = 
				
				dto = new UserDto(_id, _name, _age, _joindate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
	}
	
	// 다수의 데이터 -> list<dto>
	public List<UserDto> getUserList(){
		
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO ";
		
		Connection conn = null;	// db연결		// 이 3개가 있어야 DB를 꺼낼수 있다.
		PreparedStatement psmt = null;	// 커리문 실행용도
		ResultSet rs = null;		// 커리문 실행시 데이터 받는용도
		
		List<UserDto> list = new ArrayList<UserDto>();
		
		System.out.println("sql:" + sql);
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {	// 하나의 데이터는 rs.next(if문으로 돌리고) 여러개의 데이터는 rs.next(while문으로돌린다.)
				UserDto dto = new UserDto();
				
				dto.setId( rs.getString("id") );
				dto.setName( rs.getString("name") );
				dto.setAge( rs.getInt("age") );
				dto.setJoindate( rs.getString("joindate") );
				
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
	
	
	
}
