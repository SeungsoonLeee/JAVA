package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("¿¬°áµÊ");
			
			System.out.print("°¡°Ý : ");
			int p = s.nextInt();
			
			String sql = "select s_m_name, s_price, s_r_name, r_addr " + 
					"from may09sell, may09restaurant " + 
					"where s_r_name = r_name and s_price <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p);

			rs = pstmt.executeQuery();
			
			while (rs.next()) { 
				System.out.println(rs.getString("s_m_name"));
				System.out.println(rs.getInt("s_price"));
				System.out.println(rs.getString("s_r_name"));
				System.out.println(rs.getString("r_addr"));
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (SQLException e) {}
			try {pstmt.close();} catch (SQLException e) {}
			try {con.close();} catch (SQLException e) {}
			s.close();
		}
	}
}
