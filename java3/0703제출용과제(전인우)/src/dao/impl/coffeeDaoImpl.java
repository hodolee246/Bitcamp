package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.coffeeDao;
import db.DBClose;
import db.DBConnection;

import model.coffeeDto;

public class coffeeDaoImpl implements coffeeDao {

	public boolean addCoffee(String name, String cupsize, String syrup, String addshot, String addcream, int cup,
			int money) {
		String sql = " INSERT INTO COFFEE(NAME, CUPSIZE, SYRUP, ADDSHOT, ADDCREAM, CUP, MONEY) "
				+ " VALUES(?, ?, ?, ?, ?, ?, ?) ";

		Connection conn = null;
		PreparedStatement psmt = null;

		System.out.println("sql:" + sql);

		int count = 0;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name.trim());
			psmt.setString(2, cupsize.trim());
			psmt.setString(3, syrup.trim());
			psmt.setString(4, addshot.trim());
			psmt.setString(5, addcream.trim());
			psmt.setInt(6, cup);
			psmt.setInt(7, money);

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}

		return count > 0 ? true : false;
	}

	public List<coffeeDto> getCoffeeList() {
		String sql = " SELECT NAME, CUPSIZE, SYRUP, ADDSHOT, " + " ADDCREAM, CUP, MONEY " + " FROM COFFEE ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<coffeeDto> list = new ArrayList<coffeeDto>();

		try {

			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				coffeeDto dto = new coffeeDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7));

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

	public int howMuch(String name, String v_size, int v_cups) {
		String sql = null;
		if (v_size.equals("short")) {
			sql = " SELECT SHORT " + " FROM COFFEEMONEY " + " WHERE ESPRESSOBEVERAGES = ? ";
		} else if (v_size.equals("Tall")) {
			sql = " SELECT TALL " + " FROM COFFEEMONEY " + " WHERE ESPRESSOBEVERAGES = ? ";
		} else if (v_size.equals("Grande")) {
			sql = " SELECT GRANDE " + " FROM COFFEEMONEY " + " WHERE ESPRESSOBEVERAGES = ? ";
		}

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println("sql:" + sql);

		int Money = 0;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name.trim());
			rs = psmt.executeQuery();

			while(rs.next()) {
				Money = rs.getInt(1);
			}
			System.out.println(Money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return Money * v_cups;
	}

}
