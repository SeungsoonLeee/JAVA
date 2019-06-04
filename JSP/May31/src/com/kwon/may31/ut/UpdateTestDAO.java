package com.kwon.may31.ut;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.may31.main.DBManager;

public class UpdateTestDAO {
	public static void update(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			request.setCharacterEncoding("euc-kr");
			String p_name = request.getParameter("p_name");
			int p_price = Integer.parseInt(request.getParameter("p_price"));
			
			String sql = "update may31_product "
					+ "set p_price = p_price + ? "
					+ "where p_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_price);
			pstmt.setString(2, p_name);
			
			if (pstmt.executeUpdate() >= 1) {
				request.setAttribute("result", "UPDATE성공");
			} else {
				request.setAttribute("result", "UPDATE실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "UPDATE실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}






