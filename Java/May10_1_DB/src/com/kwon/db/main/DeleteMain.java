package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("연결됨");

			System.out.print("지점명 : ");
			String rName = s.next();
			System.out.print("메뉴명 : ");
			String mName = s.next();

			String sql = "delete from may09sell " + 
						"where s_r_name=? and s_m_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rName);
			pstmt.setString(2, mName);

			int row = pstmt.executeUpdate();
			if (row >= 1) {
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
			s.close();
		}
	}
}
