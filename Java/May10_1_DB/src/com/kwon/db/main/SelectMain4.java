package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("연결됨");
			
			System.out.print("메뉴명 : ");
			String n = s.next();
			// java
			// String : %d, %f, %s
			String sql = "select s_m_name, s_price, s_r_name, r_addr " + 
					"from may09sell, may09restaurant " + 
					"where s_r_name = r_name "
					+ "and s_m_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);

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
