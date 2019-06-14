package com.lee.jsp.gallery;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.jsp.home.DBManager;
import com.lee.jsp.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class GalleryDAO {
	private int allFileCount;
	private static final GalleryDAO GDAO = new GalleryDAO();
	
	private GalleryDAO() { }
	
	public static GalleryDAO getGDAO() {
		return GDAO;
	}
	
	public void makeToken(HttpServletRequest request, HttpServletResponse response) {
		// 키 값을 만들어 요청이 DB에 들어가지 않도록
		String now = new SimpleDateFormat("HH:mm:ss:SS").format(new Date());

		request.setAttribute("token", now);
	}
	
	public int getAllFileCount() {
		return allFileCount;
	}
	
	public void calAllFileCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			String sql = "select count(*) from jun14_gallery, jun05_member where m_id = g_id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allFileCount = rs.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
		
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("file");
		MultipartRequest mr = null;
		String file = null;
		try {
			mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
			file = mr.getFilesystemName("file");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "업로드 실패(파일 업로드 오류)");
			return;
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			Member m = (Member) request.getSession().getAttribute("m");
			
			// 현재 요청 시간
			String token = mr.getParameter("token");
			// 이전 글쓰기 성공한 요청 시간
			String successToken = (String) request.getSession().getAttribute("successToken");
			
			String title = mr.getParameter("title");
			String id = m.getId();

			if (successToken == null || !token.equals(successToken)) {
				String sql = "insert into jun14_gallery values(jun10_sns_seq.nextval, ?, ?, ?, sysdate)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, id);
				pstmt.setString(3, file);
				
				if (pstmt.executeUpdate() == 1) {
					request.setAttribute("result", "갤러리 쓰기 성공");
					request.getSession().setAttribute("successToken", token);
					allFileCount++;
				} else {
					request.setAttribute("result", "갤러리 쓰기 실패");
					new File(path + "/" + file).delete();
				}
			}
			else {
				new File(path + "/" + file).delete();
			}
			
		} catch (Exception e) {
			request.setAttribute("result", "가입 실패");
			new File(path + "/" + file).delete();
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public void getGalleryStartEnd(int start, int end, HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();
			String sql = "select * " + 
					"from(select rownum as rn, g_no, g_title, g_id, g_date, g_file " + 
					"from(select * from jun14_gallery order by g_date)) " +
					"where rn >= ? and rn <= ? " + 
					"order by rn desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);
			rs = pstmt.executeQuery();

			ArrayList<Gallery> gallery2 = new ArrayList<Gallery>();
			Gallery g = null;
			while(rs.next()) {
				g = new Gallery(rs.getInt("g_no"), rs.getString("g_title"), rs.getString("g_id"), rs.getString("g_file"), rs.getString("g_date"));
				gallery2.add(g);
			}
			request.setAttribute("galleries", gallery2);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getGallery(int page, HttpServletRequest request, HttpServletResponse response) {
		//검색한 사람(session에 search가 있는)은 검색한 내용에서
		//검색 안한 사람(session에 search가 없는)은 전체 내용에서
		int count = 6;
		String search = (String) request.getSession().getAttribute("search");
		request.setAttribute("curPage", page);
		
		if(search != null) { //검색한 사람
//			int allSearchCount = getAllSearchCount(search);
//			if(allSearchCount > 0) {
//				int pageCount = (int) Math.ceil(allSearchCount / (double) count);
//				request.setAttribute("pageCount", pageCount);
//				
//				int searchStart = allSearchCount- ((page - 1) * count);
//				int searchEnd = (page == pageCount) ? 1 : searchStart - (count - 1);
//
//				getSNSSearchStartEnd(search, searchStart, searchEnd, request, response);
//			}
		}
		else if(allFileCount > 0) { //검색 안 했는데 gallery가 있으면 꺼내옴
			// 전체 페이지 계산
			int pageCount = (int) Math.ceil(allFileCount / (double) count);
			request.setAttribute("pageCount", pageCount);
			
			// 페이지에 맞는 게시물 번호 계산
			int start = allFileCount - ((page - 1) * count);
			int end = (page == pageCount) ? 1 : start - (count - 1);
			
			// start부터 end까지 select
			getGalleryStartEnd(start, end, request, response);
			
		}
	}
	
	public void udpate(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			String sql = "delete from jun14_gallery where g_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "갤러리 삭제 성공");

				//서버에 있는 파일 삭제
				String file = request.getParameter("file");
				String path = request.getSession().getServletContext().getRealPath("file");
				new File(path + "/" + file).delete();
				
				allFileCount--;
			} else {
				request.setAttribute("result", "갤러리 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			int no = Integer.parseInt(request.getParameter("no"));
			String sql = "select * from jun14_gallery where g_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();

			Gallery g =  new Gallery(rs.getInt("g_no"), rs.getString("g_title"), rs.getString("g_id"), rs.getString("g_file"), rs.getString("g_date"));
			request.setAttribute("g", g);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

}
