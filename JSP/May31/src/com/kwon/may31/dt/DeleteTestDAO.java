package com.kwon.may31.dt;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.may31.main.DBManager;

public class DeleteTestDAO {
	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			
			request.setCharacterEncoding("euc-kr");
			String p_name = request.getParameter("p_name");
			
			String sql = "delete from may31_product "
					+ "where p_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_name);
			
			if (pstmt.executeUpdate() >= 1) {
				request.setAttribute("result", "DELETE성공");
			} else {
				request.setAttribute("result", "DELETE실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "DELETE실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}






