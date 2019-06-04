package com.kwon.may31.ct;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.may31.main.DBManager;

// DAO : M중에 DB관련작업 할 클래스
public class ConnectTestDAO {
	public static void connectTest(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		try {
			con = DBManager.connect();
			request.setAttribute("result", "연결성공");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "연결실패");
		} finally {
			DBManager.close(con, null, null);
		}
	}
}




