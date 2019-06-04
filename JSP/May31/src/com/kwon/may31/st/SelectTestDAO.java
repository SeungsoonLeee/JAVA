package com.kwon.may31.st;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.may31.main.DBManager;

public class SelectTestDAO {
	public static void select(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from may31_product order by p_name";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			// ResultSet -> ArrayList<Product>
			ArrayList<Product> products = new ArrayList<Product>();
			Product p = null;
			while (rs.next()) {
				p = new Product();
				p.setName(rs.getString("p_name"));
				p.setPrice(rs.getInt("p_price"));
				products.add(p);
			}
			request.setAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
}
