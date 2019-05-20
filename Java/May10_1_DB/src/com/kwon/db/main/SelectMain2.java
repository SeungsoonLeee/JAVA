package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("¿¬°áµÊ");

			String sql = "select s_m_name, s_price, s_r_name, m_ingredient, i_from " + 
					"from may09sell, may09menu, may09ingredient " + 
					"where s_m_name=m_name and m_ingredient=i_name " + 
					"order by s_r_name, s_m_name";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) { 
				System.out.println(rs.getString("s_m_name"));
				System.out.println(rs.getString("s_price"));
				System.out.println(rs.getString("s_r_name"));
				System.out.println(rs.getString("m_ingredient"));
				System.out.println(rs.getString("i_from"));
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (SQLException e) {}
			try {pstmt.close();} catch (SQLException e) {}
			try {con.close();} catch (SQLException e) {}
		}
	}
}
