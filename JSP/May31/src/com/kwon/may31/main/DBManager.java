package com.kwon.may31.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	// Java
	// 연결을 요청하면 그때부터 설정해서 연결맺어줌
	public static Connection connectOld() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
		return DriverManager.getConnection(url, "leee", "leee");
	}
	
	// JSP때부터 사용 가능한 : tomcat
	// ConnectionPool방식
	public static Connection connect() throws Exception{
		// context.xml
		Context ctx = new InitialContext();
		
		// 대여소
		DataSource ds 
			= (DataSource) ctx.lookup("java:comp/env/leePool");
		
		return ds.getConnection();
	}
	

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
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
