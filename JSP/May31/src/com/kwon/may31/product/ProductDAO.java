package com.kwon.may31.product;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.may31.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductDAO {
	private ArrayList<Product> products;
	private static final ProductDAO PDAO = new ProductDAO();

	private ProductDAO() {

	}

	public static ProductDAO getPdao() {
		return PDAO;
	}

	public void paging(int pageNo, HttpServletRequest request, HttpServletResponse response) {
		if (products != null && products.size() > 0) {
			int count = 6; // 한 페이지당 몇 개
			//////////////////////////////////
			// 전체 페이지수 계산
			int pageCount = (int) Math.ceil(products.size() / (double) count);
			request.setAttribute("pageCount", pageCount);
			//////////////////////////////////
			// 해당 페이지 번호에 맞는 게시물 추출
			int start = products.size() - ((pageNo - 1) * count);
			int end = (pageNo == pageCount) ? 1 : start - (count - 1);
			ArrayList<Product> products2 = new ArrayList<Product>();
			for (int i = start - 1; i >= end - 1; i--) {
				products2.add(products.get(i));
			}
			request.setAttribute("products", products2);
		}
	}

	public void getProductDetail(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));

			String sql = "select * from jun03_product " + "where p_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String content = rs.getString("p_desc").replace("<br>", "\r\n");
				Product p = new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"), content,
						rs.getString("p_photo"));
				request.setAttribute("p", p);
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

			String sql = "select * from jun03_product " + "where p_name like '%'||?||'%' " + "order by p_name desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			products = new ArrayList<Product>();
			while (rs.next()) {
				products.add(new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"), null,
						rs.getString("p_photo")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getAllProduct(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();
			String sql = "select * from jun03_product order by p_name desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			products = new ArrayList<Product>();
			while (rs.next()) {
				products.add(new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"), null,
						rs.getString("p_photo")));
			}
			request.setAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void reg(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("photo");
		MultipartRequest mr = null;
		// 서버 업로드
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			request.setAttribute("result", "파일 업로드 실패");
			return;
		}
		////////////////////////////////
		// DB 업로드
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String name = mr.getParameter("name");
			int price = Integer.parseInt(mr.getParameter("price"));
			String desc = mr.getParameter("desc").replace("\r\n", "<br>");
			String photo = mr.getFilesystemName("photo");
			photo = URLEncoder.encode(photo, "euc-kr");
			photo = photo.replace("+", " ");

			String sql = "insert into jun03_product " + "values(jun03_product_seq.nextval, " + "?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, desc);
			pstmt.setString(4, photo);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "등록 성공");
			} else {
				request.setAttribute("result", "등록 실패");
			}
		} catch (Exception e) {
			request.setAttribute("result", "DB문제로 실패");
			// 아까 업로드했던 파일 삭제
			File f = new File(path + "/" + mr.getFilesystemName("photo"));
			f.delete();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void updateOld(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));
			int price = Integer.parseInt(request.getParameter("price"));
			String sql = "update jun03_product " + "set p_price = ? " + "where p_no = ?";
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

	public void update(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("photo");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패(파일 용량문제)");
			return;
		}
		////////////////////////////////
		// 파일 업로드는 성공(성공 or 파일을 바꾸지 않음)
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String photo = null; // 새로 올릴 사진
		String exPhoto = null; // 기존에 올라와 있던 사진
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(mr.getParameter("no"));
			String name = mr.getParameter("name");
			int price = Integer.parseInt(mr.getParameter("price"));
			String desc = mr.getParameter("desc").replace("\r\n", "<br>");
			photo = mr.getFilesystemName("photo");

			// 원래 파일명 구하기/////////////////////////
			String sql = "select * from jun03_product where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				exPhoto = rs.getString("p_photo");
			}
			pstmt.close();
			// 사진 수정 해 or 안해/////////////////////
			if (photo == null) { // 사진 수정 안하면
				photo = exPhoto; // 파일명 = 원래파일명
			} else { // 사진도 수정하면
				photo = URLEncoder.encode(photo, "euc-kr"); // 업로드 되는 파일명 한글 처리
				photo = photo.replace("+", " ");
			}
			// DB 업데이트 수행////////////////////////
			sql = "update jun03_product " + "set p_name=?, p_price=?, p_desc=?, p_photo=? " + "where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, desc);
			pstmt.setString(4, photo);
			pstmt.setInt(5, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "수정 성공");
				if (!photo.equals(exPhoto)) {
					exPhoto = URLDecoder.decode(exPhoto, "euc-kr");
					File f = new File(path + "/" + exPhoto);
					f.delete(); // 원래파일 지우기
				}
			} else {
				request.setAttribute("result", "수정 실패");
				System.out.println(exPhoto);
				if (!photo.equals(exPhoto)) {
					photo = URLDecoder.decode(photo, "euc-kr");
					File f = new File(path + "/" + photo);
					f.delete(); // 새 파일 지우기
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패");
			try {
				if (!photo.equals(exPhoto)) {
					photo = URLDecoder.decode(photo, "euc-kr");
					File f = new File(path + "/" + photo);
					f.delete();
				}
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));

			String exPhoto = null;
			String sql = "select * from jun03_product where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				exPhoto = rs.getString("p_photo");
			}
			pstmt.close();

			sql = "delete from jun03_product where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "삭제 성공");
				String path = request.getSession().getServletContext().getRealPath("photo");
				new File(path + "/" + exPhoto).delete();
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
