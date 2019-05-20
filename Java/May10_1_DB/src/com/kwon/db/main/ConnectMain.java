package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMain {
	public static void main(String[] args) {
		// OracleDriver 쓸 수 있게 : ojdbc8.jar
		Connection con = null;
		try {
			// DB서버주소(형식이 DB메이커마다 다름)
			String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";

			// 연결할 때 사용할 클래스명 지정
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB서버와 연결을 시키면
			// Class.forName에 지정한 드라이버를 자바가 찾아서 사용
			// 요즘은 자동으로 찾음
			// 연결
			con = DriverManager.getConnection(url, "kwon", "kwon");
			System.out.println("연결됨");
			// SQL전송
			// 실행
			// 결과 받아오기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {con.close();} catch (SQLException e) {}
		}
	}
}








