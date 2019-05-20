package com.kwon.ddp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO(Data Access Object)
//		DB관련 작업 전담할 객체
//		여러개 필요하지 않음 -> singleton
public class DAO {
	private static final DAO DAO = new DAO();

	private DAO() {
		// TODO Auto-generated constructor stub
	}

	public static DAO getDao() {
		return DAO;
	}

	public void regRestaurant(Restaurant r) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("연결됨");
			String sql = "insert into MAY09RESTAURANT values(?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(2, r.getrAddr());
			pstmt.setString(1, r.getrName());

			int row = pstmt.executeUpdate();
			if (row == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

	public void showRestaurant() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("연결됨");

			String sql = "select * " + "from may09restaurant " + "order by r_name";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("r_name"));
				System.out.println(rs.getString("r_addr"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
