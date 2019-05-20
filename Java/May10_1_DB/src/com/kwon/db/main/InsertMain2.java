package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("연결됨");
			
			System.out.print("이름 : ");
			String n = s.next();
			System.out.print("가격 : ");
			int p = s.nextInt();
			System.out.print("제조사 : ");
			String m = s.next();
			System.out.print("유통기한 : ");
			String e = s.next();
			
			String sql = "insert into may08snack "
					+ "values(may08snack_seq.nextval,"
					+ "?, ?, ?, to_date(?,'YYYYMMDD'))";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			pstmt.setInt(2, p);
			pstmt.setString(3, m);
			pstmt.setString(4, e);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e) {}
			try {con.close();} catch (SQLException e) {}
			s.close();
		}
	}
}








