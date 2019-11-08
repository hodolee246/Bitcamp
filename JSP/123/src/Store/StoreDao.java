package Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;

public class StoreDao implements iStoreDao {
	
	private static StoreDao storeDao = new StoreDao();
	
	private StoreDao() {
		DBConnection.initConnect();
	}
	
	public static StoreDao getInstance() {	//Singleton鈺곌퀗援붻눧占� 占쎄문占쎌셽揶쏉옙占쎈뮟 
		return storeDao;	
	}

	@Override
	public boolean addProduct(StoreDto dto) {
		
		String sql = " INSERT INTO SHOP "
				   + " (PRODUCT_SEQ,CODE_NUMBER,PRODUCT_NAME,STOCK_COUNT, "
				   + " PRICE,PRODUCT_EXPLAIN,PRODUCT_IMAGE,PRODUCT_SIZE) "
				   + " VALUES(PRODUCT_SEQ.NEXTVAL,?,?,?,?,?,?,?) ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("addProduct 1/6 suc");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCode());
			psmt.setString(2, dto.getProductName());
			psmt.setInt(3, dto.getStockCount());
			psmt.setInt(4, dto.getPrice());
			psmt.setString(5, dto.getProductExplain());
			psmt.setString(6, dto.getProductImage());
			psmt.setString(7, dto.getProductSize());
			System.out.println("addProduct 2/6 suc");
			
			count = psmt.executeUpdate();
			System.out.println("addProduct 3/6 suc");
			
			
		} catch (Exception e) {
			System.out.println("addProduct fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count>0?true:false;
	}

	@Override
	public List<StoreDto> getProduct(int pCount) {
		
		String sql = " SELECT PRODUCT_SEQ,CODE_NUMBER,PRODUCT_NAME,STOCK_COUNT,PRICE, "
				   + " PRODUCT_EXPLAIN,PRODUCT_IMAGE,PRODUCT_SIZE "
				   + " FROM "
				   + " (SELECT ROW_NUMBER()OVER(ORDER BY PRODUCT_SEQ DESC) AS RNUM, " 
				   + " PRODUCT_SEQ, CODE_NUMBER, PRODUCT_NAME, STOCK_COUNT, PRICE, " 
				   + " PRODUCT_EXPLAIN, PRODUCT_IMAGE, PRODUCT_SIZE "
				   + " FROM SHOP "
				   + " ORDER BY PRODUCT_SEQ DESC) "
				   + " WHERE RNUM >= ? AND RNUM <= ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<StoreDto> list = new ArrayList<StoreDto>();
		int start, end;
		start = 1 + 10 * pCount;
		end = 10 + 10 * pCount;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getProduct suc");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, start);
			psmt.setInt(2, end);
			System.out.println("2/6 getProduct suc");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getProduct suc");
			
			while(rs.next()) {
				int i = 1;
				StoreDto dto = new StoreDto(rs.getInt(i++),
										   rs.getString(i++),
										   rs.getString(i++),
										   rs.getInt(i++),
										   rs.getInt(i++),
										   rs.getString(i++),
										   rs.getString(i++),
										   rs.getString(i));
				list.add(dto);
			}	
			System.out.println("4/6 getProduct suc");
			
		} catch (Exception e) {
			System.out.println("getProduct fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);			
		}
		
		return list;
	}

	@Override
	public StoreDto detailProduct(int seq) {
		String sql = " SELECT PRODUCT_SEQ,CODE_NUMBER,PRODUCT_NAME,STOCK_COUNT,PRICE, "
				   + " PRODUCT_EXPLAIN,PRODUCT_IMAGE,PRODUCT_SIZE "
				   + " FROM SHOP "
				   + " WHERE PRODUCT_SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		StoreDto dto = null;
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 detailProduct suc");
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 detailProduct suc");
			rs = psmt.executeQuery();
			System.out.println("3/6 detailProduct suc");
			while(rs.next()) {
				int i = 1;
				dto = new StoreDto(rs.getInt(i++),
								   rs.getString(i++),
								   rs.getString(i++),
								   rs.getInt(i++),
								   rs.getInt(i++),
								   rs.getString(i++),
								   rs.getString(i++),
								   rs.getString(i));
			}
			System.out.println("4/6 detailProduct suc");
		} catch (Exception e) {
			System.out.println("detailProduct fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
	
		
		
		return dto;
	}

	@Override
	public boolean updateProduct(StoreDto dto) {
		String sql = " UPDATE SHOP "
				   + " SET CODE_NUMBER=?,PRODUCT_NAME=?,STOCK_COUNT=?, "
				   + " PRICE=?,PRODUCT_EXPLAIN=?,PRODUCT_IMAGE=?,PRODUCT_SIZE=? "
				   + " WHERE PRODUCT_SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 updateProduct suc");
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getCode());
			psmt.setString(2, dto.getProductName());
			psmt.setInt(3, dto.getStockCount());
			psmt.setInt(4, dto.getPrice());
			psmt.setString(5, dto.getProductExplain());
			psmt.setString(6, dto.getProductImage());
			psmt.setString(7, dto.getProductSize());
			psmt.setInt(8, dto.getSeq());
			System.out.println("2/6 updateProduct suc");
			count = psmt.executeUpdate();
			System.out.println("3/6 updateProduct suc");
		} catch (Exception e) {
			System.out.println("updateProduct fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count>0?true:false;
	}

	@Override
	public boolean deleteProduct(int seq) {
		
		String sql = " DELETE FROM SHOP "
				   + " WHERE PRODUCT_SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;

		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 deleteProduct suc");
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1,seq);
			System.out.println("2/6 deleteProduct suc");
			count = psmt.executeUpdate();
			System.out.println("3/6 deleteProduct suc");
		} catch (Exception e) {
			System.out.println("deleteProduct fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count>0?true:false;
	}

	@Override
	public String findImg(int seq) {
		String sql = " SELECT PRODUCT_IMAGE "
				   + " FROM SHOP "
				   + " WHERE PRODUCT_SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String str = "";
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 findImg suc");
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 findImg suc");
			rs = psmt.executeQuery();
			System.out.println("3/6 findImg suc");
			while(rs.next()) {
				str = rs.getString(1);
			}
			System.out.println("4/6 findImg suc");
		} catch (Exception e) {
			System.out.println("findImg fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return str;
	}

	@Override
	public int countProduct() {
		String sql = " SELECT COUNT(*) " + 
					 " FROM SHOP ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int productCount = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 countProduct suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 countProduct suc");
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				productCount = rs.getInt(1);
			}
			System.out.println("3/6 countProduct suc");
			} catch (Exception e) {
				System.out.println("countProduct fail");
				e.printStackTrace();
			} finally {
				DBClose.close(conn, psmt, rs);			
			}		
		return productCount;
	}

	@Override
	public List<StoreDto> findProduct(String sel, String fText, int pCount) {
		String sql = " SELECT PRODUCT_SEQ,CODE_NUMBER,PRODUCT_NAME,STOCK_COUNT,PRICE, "
				   + " PRODUCT_EXPLAIN,PRODUCT_IMAGE,PRODUCT_SIZE "
				   + " FROM "
				   + " (SELECT ROW_NUMBER()OVER(ORDER BY PRODUCT_SEQ DESC) AS RNUM, " 
				   + " PRODUCT_SEQ, CODE_NUMBER, PRODUCT_NAME, STOCK_COUNT, PRICE, " 
				   + " PRODUCT_EXPLAIN, PRODUCT_IMAGE, PRODUCT_SIZE "
				   + " FROM SHOP ";
	
		
		if(sel.trim().equals("상품명")) {
			sql += " WHERE PRODUCT_NAME LIKE '%'||?||'%' "
				 + " ORDER BY PRODUCT_SEQ DESC) ";
		}
		else if(sel.trim().equals("분류")) {
			sql += " WHERE CODE_NUMBER=? "
			     + " ORDER BY PRODUCT_SEQ DESC) ";
		}
		else if(sel.trim().equals("가격")) {
			sql += " WHERE PRICE=? "
				 + " ORDER BY PRODUCT_SEQ DESC) ";
		}
		
		sql += " WHERE RNUM >= ? AND RNUM <= ? ";
		
		int start, end;
		start = 1 + 10 * pCount;
		end = 10 + 10 * pCount;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<StoreDto> list = new ArrayList<StoreDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 findProduct suc");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 findProduct suc");
			if(sel.trim().equals("가격")) {
				psmt.setInt(1, Integer.parseInt(fText));
				psmt.setInt(2, start);
				psmt.setInt(3, end);
				
			}
			else {
				psmt.setString(1, fText);
				psmt.setInt(2, start);
				psmt.setInt(3, end);
				
			}
			rs = psmt.executeQuery();
			System.out.println("3/6 findProduct suc");
			while(rs.next()) {
				StoreDto dto = new StoreDto(rs.getInt(1),
										   rs.getString(2),
										   rs.getString(3),
										   rs.getInt(4),
										   rs.getInt(5),
										   rs.getString(6),
										   rs.getString(7),
										   rs.getString(8));
				list.add(dto);
			}
			System.out.println("4/6 findProduct suc");
		} catch (Exception e) {
			System.out.println("findProduct fail");
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		
	
		
		return list;
	}
	
	
	
	
	
	
	

}
