package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;
import dto.Member;

public class MemberDao {

	private static MemberDao mem = null;
	
	private static String loginId;
	
	
	private MemberDao() {
	}
	
	public static MemberDao getInstance() {
		if(mem == null) {
			mem = new MemberDao();
		}
		return mem;
	}
	
	
		// INSERT	
		// db에 insert(저장) 하는 메소드!
		public boolean addMember(String id, String pw, String name, String email, int auto) {
			
			String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) " 
			+ " VALUES('" + id + "', '" + pw + "', '" + name + "', '" + email + "', " + auto + ") " ;
				
		Connection conn = DBConnection.getConnection();	// 기존의 경로를 설정한 커넥션함수를 불러온다.
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
			}	finally {
				DBClose.close(stmt, conn, rs);
			}
			return count>0?true:false;		// 0보다 크면 트루 그렇지 않을경우 펄스
		}
	
		public boolean CheckId(String id) {
			
			String sql = " SELECT ID "
					+ " FROM MEMBER "
					+ " WHERE ID = '" + id + "' " ; 
						
				Connection conn = DBConnection.getConnection();	// 기존의 경로를 설정한 커넥션함수를 불러온다.
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
					}	finally {
						DBClose.close(stmt, conn, rs);
					}
					return count!=0?true:false;
		}
		
		public boolean Login(String id, String pw) {
			String sql = " SELECT ID "
					+ " FROM MEMBER "
					+ " WHERE ID = '" + id + "' AND PWD = '" + pw + "' " ; 
						
				Connection conn = DBConnection.getConnection();	// 기존의 경로를 설정한 커넥션함수를 불러온다.
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
					}	finally {
						DBClose.close(stmt, conn, rs);
					}
					return count!=0?true:false;
		}
		
		public Member login(String id, String pwd) {
			
			String sql = " SELECT ID, NAME, EMAIL, AUTH "
					+ "	FROM MEMBER "
					+ " WHERE ID = ? AND PWD = ? ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			Member mem = null;
			
			
			try {
				
				conn = DBConnection.getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id.trim());
				psmt.setString(2, pwd.trim());
				
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					String v_id = rs.getString(1);
					String v_name = rs.getString(2);
					String v_email = rs.getString(3);
					int auth = rs.getInt(4);
					
					mem = new Member(v_id, null, v_name, v_email, auth);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBClose.close(psmt, conn, rs);
				
			}
			return mem;
			
		}

		
		
		
		public static String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
	}
	
	

