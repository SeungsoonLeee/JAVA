package com.kwon.may31.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.may31.main.DBManager;

public class SnackDAO {
	private ArrayList<Snack> snacks;

	private static final SnackDAO SDAO = new SnackDAO();

	private SnackDAO() {
	}

	public static SnackDAO getSdao() {
		return SDAO;
	}

	public void paging(int pageNo, HttpServletRequest request, HttpServletResponse response) {
		if (snacks != null && snacks.size() > 0) {
			int count = 5; // 한 페이지당 몇 개
			//////////////////////////////////
			// 전체 페이지수 계산
			int pageCount = (int) Math.ceil(snacks.size() / (double) count);
			request.setAttribute("pageCount", pageCount);
			//////////////////////////////////
			// 해당 페이지 번호에 맞는 게시물 추출
			int start = snacks.size() - ((pageNo - 1) * count);
			int end = (pageNo == pageCount) ? 1 : start - (count - 1);
			ArrayList<Snack> snacks2 = new ArrayList<Snack>();
			for (int i = start - 1; i >= end - 1; i--) {
				snacks2.add(snacks.get(i));
			}
			request.setAttribute("snacks", snacks2);
		}
	}

	public void getSnackDetail(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));

			String sql = "select * from may31_snack " + "where s_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Snack s = new Snack(rs.getInt("s_no"), rs.getString("s_name"), rs.getInt("s_price"),
						rs.getDate("s_exp"), rs.getString("s_desc"));
				request.setAttribute("s", s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void search(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			request.setCharacterEncoding("euc-kr");
			String search = request.getParameter("search");

			String sql = "select * from may31_snack " + "where s_name like '%'||?||'%' " + "order by s_name desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			snacks = new ArrayList<Snack>();
			while (rs.next()) {
				snacks.add(new Snack(rs.getInt("s_no"), rs.getString("s_name"), rs.getInt("s_price"), null, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getAllSnack(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();
			String sql = "select * from may31_snack order by s_name desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			snacks = new ArrayList<Snack>();
			while (rs.next()) {
				snacks.add(new Snack(rs.getInt("s_no"), rs.getString("s_name"), rs.getInt("s_price"), null, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void reg(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			request.setCharacterEncoding("euc-kr");
			String s_name = request.getParameter("s_name");
			int s_price = Integer.parseInt(request.getParameter("s_price"));
			String s_exp_y = request.getParameter("s_exp_y");
			int sem2 = Integer.parseInt(request.getParameter("s_exp_m"));
			int sed2 = Integer.parseInt(request.getParameter("s_exp_d"));
			String s_exp = String.format("%s%02d%02d", s_exp_y, sem2, sed2);
			String s_desc = request.getParameter("s_desc").replace("\r\n", "<br>");

			String sql = "insert into may31_snack " + "values(may31_snack_seq.nextval, "
					+ "?, ?, to_date(?, 'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s_name);
			pstmt.setInt(2, s_price);
			pstmt.setString(3, s_exp);
			pstmt.setString(4, s_desc);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "등록 성공");
			} else {
				request.setAttribute("result", "등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "등록 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void update(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));
			int price = Integer.parseInt(request.getParameter("price"));
			String sql = "update may31_snack "
						+ "set s_price = ? "
						+ "where s_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "수정 성공");
			} else {
				request.setAttribute("result", "수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));

			String sql = "delete from may31_snack where s_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "삭제 성공");
			} else {
				request.setAttribute("result", "삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}
}
