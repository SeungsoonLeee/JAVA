package com.kwon.sd.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
		return DriverManager.getConnection(url, "kwon", "kwon");
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		// insert : rs가 없을것 => NullPointerException발생
		// 그거 무시하려고
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}



