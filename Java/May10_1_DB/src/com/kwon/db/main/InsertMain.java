package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("연결됨");
			
			System.out.print("식당명 : ");
			String n = s.next();
			
			System.out.print("위치 : ");
			String a = s.next();
			
			// String sql = String.format(format, args);
			// 수행하고자하는 SQL(;빼고, 자바변수 값들어갈자리에 ?로)
			// ?은 값에만
			String sql = "insert into MAY09RESTAURANT values(?, ?)";
			
			// SQL을 서버로 전송, 보낸 SQL을 실행, 
			// 그 결과를 받아오기를 해주는 객체
			pstmt = con.prepareStatement(sql);
			
			// ?에 값 채우기 : pstmt.setXXX(물음표번호, 값);
			pstmt.setString(2, a);
			pstmt.setString(1, n);
			
			// SQL을 서버로 전송, 보낸 SQL을 실행,
			// 그 결과(테이블상에 몇줄이 영향받았는지)를 받아오기
			int row = pstmt.executeUpdate();
			if (row == 1) {
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








