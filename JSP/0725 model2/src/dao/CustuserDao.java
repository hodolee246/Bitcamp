package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CustuserDto;

public class CustuserDao {

	
	private static CustuserDao dao = null;
	
	private CustuserDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static CustuserDao getInstance() {
		if(dao == null) {
			dao = new CustuserDao();
		}
		return dao;
	}
	
	public List<CustuserDto> getCustuserList(){
		String sql = " SELECT ID, NAME, ADDRESS"
				+ " FROM CUSTUSER "
				+ " ORDER BY ID DESC ";
		
		System.out.println("sql:"+sql);
		Connection conn = null;	// DB 연결후 데이터 취득
		PreparedStatement psmt = null;	// SQL 문 실행
		ResultSet rs = null;	// 결과값 리턴
		
		List<CustuserDto> list = new ArrayList<CustuserDto>();
		
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				
				CustuserDto c = new CustuserDto(id, name, address);
				
				list.add(c);
					
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
				this.close(conn, psmt, rs);
		}
		return list;
		
	}
	
	public boolean addData(String id, String name, String address) {
		String sql = " INSERT INTO CUSTUSER "
				+ " VALUES(?, ?, ?)" ;
		
		System.out.println("sql:"+sql);
		boolean b = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		CustuserDto dto = null;
		
		try {
			conn = getConnection();		// 미리 만들어둔 연결함수로 DB 연결
			psmt = conn.prepareStatement(sql);	// sql 실행
			psmt.setString(1, id.trim());		// 실행시 처음 ? 에 공백없앤 id
			psmt.setString(2, name.trim());		// 실행시 두번째 ? 에 공백업앤 name
			psmt.setString(3, address.trim());	//		세번째 ? 공백없앤 address
			
			rs = psmt.executeQuery();		// rs에 실행값 저장
			
			if(rs.next()) {	// 이 조건이 쿼리문이 정상적으로 실행되서 값이 있는경우
				b = true;	// false 를 true 로 변경하여 실행됬는지 여부를 알려준다.
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, rs); // 다 썻으면 닫아준다. 만약 안닫을경우 일단은
			// 가비지 컬렉터가 닫아주긴한다 (그래도 쓰면 닫아주고)
		}
		
		
		return b;	// if문을 통하여 만약 DB에 INSERT문이 작동되면 TRUE 를 반환하고
					// 그렇지 않으면 FLASE 를 반환할 것 이다.
	}

	public CustuserDto SearchData(String id) {
		String sql = " SELECT ID, NAME, ADDRESS "
				+ "	FROM CUSTUSER  "
				+ " WHERE ID=? ";
		
		System.out.println("sql:"+sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		CustuserDto dto = null;
		CustuserDto s_dto = null;
		
		try {
			conn = getConnection();		// 미리 만들어둔 연결함수로 DB 연결
			psmt = conn.prepareStatement(sql);	// sql 실행
			psmt.setString(1, id.trim());		// 실행시 처음 ? 에 공백없앤 id
			
			rs = psmt.executeQuery();		// rs에 실행값 저장
			
			if(rs.next()) {	// 이 조건이 쿼리문이 정상적으로 실행되서 값이 있는경우
				String s_id = rs.getString(1); //id 저장
				String s_name = rs.getString(2);	// name 저장
				String s_address = rs.getString(3);	// address 저장
				
				s_dto = new CustuserDto(s_id, s_name, s_address);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, rs); // 다 썻으면 닫아준다. 만약 안닫을경우 일단은
			// 가비지 컬렉터가 닫아주긴한다 (그래도 쓰면 닫아주고)
		}
		
		return s_dto;	// dto 반환
	}
			
		public boolean UpdateData(String id, String name, String address) {
			String sql = " UPDATE CUSTUSER "
					+ "	SET NAME=?, ADDRESS=? "
					+ " WHERE ID=? ";
			
			System.out.println("sql:"+sql);
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			boolean u_b = false;
			
			try {
				conn = getConnection();		// 미리 만들어둔 연결함수로 DB 연결
				psmt = conn.prepareStatement(sql);	// sql 실행
				
				psmt.setString(1, name.trim());		
				psmt.setString(2, address.trim());		
				psmt.setString(3, id.trim());
				
				rs = psmt.executeQuery();		// rs에 실행값 저장
				
				if(rs.next()) {	// 이 조건이 쿼리문이 정상적으로 실행되서 값이 있는경우
					u_b = true;
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(conn, psmt, rs); // 다 썻으면 닫아준다. 만약 안닫을경우 일단은
				// 가비지 컬렉터가 닫아주긴한다 (그래도 쓰면 닫아주고)
			}
			
			return u_b;
	
	}
	
		public boolean DeleteData(String id) {
			String sql = " DELETE "
					+ "	FROM CUSTUSER "
					+ " WHERE ID=? ";
			
			System.out.println("sql:"+sql);
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			boolean d_b = false;
			
			try {
				conn = getConnection();		// 미리 만들어둔 연결함수로 DB 연결
				psmt = conn.prepareStatement(sql);	// sql 실행
				psmt.setString(1, id.trim());		// 실행시 처음 ? 에 공백없앤 id

				rs = psmt.executeQuery();		// rs에 실행값 저장
				
				if(rs.next()) {	// 이 조건이 쿼리문이 정상적으로 실행되서 값이 있는경우
					d_b = true;
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(conn, psmt, rs); // 다 썻으면 닫아준다. 만약 안닫을경우 일단은
				// 가비지 컬렉터가 닫아주긴한다 (그래도 쓰면 닫아주고)
			}
			
			return d_b;
	
	}
		
	public boolean deletedatas(String ids[]) {	// db데이터를 한번에 다중삭제
		String sql = " DELETE "
				+ "	FROM CUSTUSER "
				+ " WHERE ID=? ";
		
		System.out.println("sql:"+sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count[] = new int[ids.length];
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);	// 커밋 == 적용 적용을 전부다 끈다.
			
			psmt = conn.prepareStatement(sql);
			
			for (int i = 0; i < ids.length; i++) {
				psmt.setString(1, ids[i]);
				psmt.addBatch();	// 계속 쿼리문을 돌리면서 새로운 값을 집어넣어라
			}
			count = psmt.executeBatch();	// 한꺼번에 처리해라
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();	// Exception 발생시 다시 되돌려준다.
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(conn, psmt, null);
		}
		
		boolean isS = true;	// 성공여부 확인용 불린 변수
		
		for (int i = 0; i < count.length; i++) {
			if(count[i] != -2) {	// -2 == 정상종료
				isS = false;
				break;
			}
		}
		return isS;
	}
	
	public List<CustuserDto> SelectList(String sid){
		String sql = " SELECT ID, NAME, ADDRESS"
				+ " FROM CUSTUSER "
				+ " WHERE ID=%?% "
				+ " ORDER BY ID DESC ";
		
		System.out.println("sql:"+sql);
		Connection conn = null;	// DB 연결후 데이터 취득
		PreparedStatement psmt = null;	// SQL 문 실행
		ResultSet rs = null;	// 결과값 리턴
		
		List<CustuserDto> list = new ArrayList<CustuserDto>();
		
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			String s_id = sid.trim() + "";
			psmt.setString(1, s_id.trim());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				
				CustuserDto c = new CustuserDto(id, name, address);
				
				list.add(c);
					
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
				this.close(conn, psmt, rs);
		}
		return list;
		
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

}
