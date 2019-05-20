package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("연결됨");

			String sql = "select * "
					+ "from may09restaurant " 
					+ "order by r_name";
			pstmt = con.prepareStatement(sql);
			
			// insert, update, delete : pstmt.executeUpdate()
			// select : pstmt.executeQuery()

			// SQL을 서버로 전송, 보낸 SQL을 실행,
			// 그 결과(select한 결과)를 받아오기
			rs = pstmt.executeQuery();
			
			// rs에 있는거 출력
			
			// rs.next() // 다음 데이터로,
					     //	다음 데이터가 있으면 true, 없으면false
			while (rs.next()) { 
				// rs.getXXX("필드명");
				System.out.println(rs.getString("r_name"));
				System.out.println(rs.getString("r_addr"));
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
