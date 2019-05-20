package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class SelectMain5 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("¿¬°áµÊ");
			
			String sql = "select s_name, s_price, s_maker, s_exp "
					+ "from may08snack order by s_name";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
			while (rs.next()) { 
				System.out.println(rs.getString("s_name"));
				System.out.println(rs.getInt("s_price"));
				System.out.println(rs.getString("s_maker"));
				System.out.println(sdf.format(rs.getDate("s_exp")));
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
