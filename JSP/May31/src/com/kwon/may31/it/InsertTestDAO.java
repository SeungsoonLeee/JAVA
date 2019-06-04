package com.kwon.may31.it;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.may31.main.DBManager;

public class InsertTestDAO {
	public static void insert(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null; // select때만
		try {
			// 연결
			con = DBManager.connect();
			
			// (post때만) 요청 파라메터 한글처리
			request.setCharacterEncoding("euc-kr");
			
			// 값 받기
			String p_name = request.getParameter("p_name");
			int p_price = Integer.parseInt(request.getParameter("p_price"));
			// int p_price = Integer.parseInt("p_price");
			
			// sql문
			String sql = "insert into may31_product values(?, ?)";
			
			// 수행/결과 처리 할 객체
			pstmt = con.prepareStatement(sql);
			
			// sql문 완성(? 채우기)
			pstmt.setInt(2, p_price);
			pstmt.setString(1, p_name);
			
			// 수행/결과처리
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "INSERT성공");
			} else {
				request.setAttribute("result", "INSERT실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "INSERT실패");
		} finally {
			// 닫기
			DBManager.close(con, pstmt, null);
		}
	}
}






