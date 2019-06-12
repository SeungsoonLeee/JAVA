package com.lee.jsp.sns;

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

public class SNSDAO {
	private ArrayList<SNSMsg> snsMsgs;
	private int allMsgCount;
	

	private static final SNSDAO SDAO = new SNSDAO();

	private SNSDAO() {
		// TODO Auto-generated constructor stub
	}

	public static SNSDAO getSdao() {
		return SDAO;
	}

	public int getAllMsgCount() {
		return allMsgCount;
	}

	public void setAllMsgCount(int allMsgCount) {
		this.allMsgCount = allMsgCount;
	}
	
	public void whiteSNS(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			Member m = (Member) request.getSession().getAttribute("m");

			// 현재 요청 시간
			String token = request.getParameter("token");
			// 이전 글쓰기 성공한 요청 시간
			String successToken = (String) request.getSession().getAttribute("successToken");
			String id = m.getId();
			String msg = request.getParameter("msg").replace("\r\n", "<br>");
			// String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

			if (successToken == null || !token.equals(successToken)) {
				String sql = "insert into jun10_sns values(jun10_sns_seq.nextval, ?, ?, sysdate)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, msg);
			}

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "sns 쓰기 성공");
				request.getSession().setAttribute("successToken", token);
				allMsgCount++;
			} else {
				request.setAttribute("result", "sns 쓰기 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public void deleteSNS(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));

			String sql = "delete from jun10_sns where s_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "sns 삭제 성공");
				allMsgCount--;
			} else {
				request.setAttribute("result", "sns 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	//불필요
	public void getAllSNSMsg(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String msg = "";

		try {
			con = DBManager.connect();

			String sql = "select * from jun10_sns, jun05_member where m_id = s_id order by s_date";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			snsMsgs = new ArrayList<SNSMsg>();
			while (rs.next()) {
				msg = rs.getString("s_msg").replaceAll("<br>", "\r\n");
				snsMsgs.add(new SNSMsg(rs.getInt("s_no"), msg, rs.getString("s_date"), rs.getString("m_id"),
						rs.getString("m_name"), rs.getString("m_photo")));
			}
			request.setAttribute("snsMsgs", snsMsgs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void makeToken(HttpServletRequest request, HttpServletResponse response) {
		// 키 값을 만들어 요청이 DB에 들어가지 않도록
		String now = new SimpleDateFormat("HH:mm:ss:SS").format(new Date());

		request.setAttribute("token", now);
	}

	//불필요
	public void paging(int page, HttpServletRequest request, HttpServletResponse response) {
		if (snsMsgs != null && snsMsgs.size() > 0) {
			int count = 5;
			int pageCount = (int) Math.ceil(snsMsgs.size() / (double) count);
			request.setAttribute("pageCount", pageCount);

			int start = snsMsgs.size() - ((page - 1) * count);
			int end = (page == pageCount) ? 1 : start - (count - 1);
			ArrayList<SNSMsg> snsMsgs2 = new ArrayList<SNSMsg>();
			for (int i = start - 1; i >= end - 1; i--) {
				snsMsgs2.add(snsMsgs.get(i));
			}
			request.setAttribute("snsMsgs", snsMsgs2);
			request.setAttribute("curPage", page);
		}
	}

	public void calAllMsgCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			String sql = "select count(*) from jun10_sns, jun05_member where m_id = s_id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allMsgCount = rs.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public int getAllSearchCount(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();
			String sql = "select count(*) " + 
					"from(select rownum as rn, s_no, s_id, s_msg, s_date, m_name, m_photo " + 
					"from(select * from jun10_sns, jun05_member where m_id = s_id))" +
					"where s_id like '%'||?||'%' or s_msg like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return -1;
	}
	
	public void clearSearch(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("search", null);
	}
	
	public void getSNSMsgStartEnd(int start, int end, HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();
			String sql = "select * " + 
					"from(select rownum as rn, s_no, s_id, s_msg, s_date, m_name, m_photo " + 
					"from(select * from jun10_sns, jun05_member where m_id = s_id order by s_Date)) " +
					"where rn >= ? and rn <= ? " + 
					"order by rn desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);
			rs = pstmt.executeQuery();

			ArrayList<SNSMsg> snsMsgs2 = new ArrayList<SNSMsg>();
			SNSMsg m = null;
			String msg = "";
			while(rs.next()) {
				msg = rs.getString("s_msg").replaceAll("\r\n", "<br>");
				m = new SNSMsg(rs.getInt("s_no"), msg, rs.getString("s_date"), rs.getString("s_id"),
						rs.getString("m_name"), rs.getString("m_photo"));
				snsMsgs2.add(m);
			}
			request.setAttribute("snsMsgs", snsMsgs2);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public void getSNSSearchStartEnd(String search, int start, int end, HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();
			String sql = "select * " + 
					"from(select rownum as rn, s_no, s_id, s_msg, s_date, m_name, m_photo " + 
					"from(select * from jun10_sns, jun05_member where m_id = s_id and (s_id like '%'||?||'%' or s_msg like '%'||?||'%') order by s_Date)) " +
					"where rn >= ? and rn <= ? " + 
					"order by rn desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, end);
			pstmt.setInt(4, start);
			rs = pstmt.executeQuery();

			ArrayList<SNSMsg> snsMsgs2 = new ArrayList<SNSMsg>();
			SNSMsg m = null;
			String msg = "";
			while(rs.next()) {
				msg = rs.getString("s_msg").replaceAll("\r\n", "<br>");
				m = new SNSMsg(rs.getInt("s_no"), msg, rs.getString("s_date"), rs.getString("s_id"),
						rs.getString("m_name"), rs.getString("m_photo"));
				snsMsgs2.add(m);
			}
			request.setAttribute("snsMsgs", snsMsgs2);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public void getSNSMsg(int page, HttpServletRequest request, HttpServletResponse response) {
		//검색한 사람(session에 search가 있는)은 검색한 내용에서
		//검색 안한 사람(session에 search가 없는)은 전체 내용에서
		int count = 5;
		String search = (String) request.getSession().getAttribute("search");
		request.setAttribute("curPage", page);
		
		if(search != null) { //검색한 사람
			int allSearchCount = getAllSearchCount(search);
			if(allSearchCount > 0) {
				int pageCount = (int) Math.ceil(allSearchCount / (double) count);
				request.setAttribute("pageCount", pageCount);
				
				int searchStart = allSearchCount- ((page - 1) * count);
				int searchEnd = (page == pageCount) ? 1 : searchStart - (count - 1);

				getSNSSearchStartEnd(search, searchStart, searchEnd, request, response);
			}
		}
		else if(allMsgCount > 0) { //검색 안 했는데 sns가 있으면 꺼내옴
			// 전체 페이지 계산
			int pageCount = (int) Math.ceil(allMsgCount / (double) count);
			request.setAttribute("pageCount", pageCount);
			
			// 페이지에 맞는 게시물 번호 계산
			int start = allMsgCount - ((page - 1) * count);
			int end = (page == pageCount) ? 1 : start - (count - 1);
			
			// start부터 end까지 select
			getSNSMsgStartEnd(start, end, request, response);
			
		}
	}
	
	public void searchSNSMsg(HttpServletRequest request, HttpServletResponse response) {
		//검색은 자신 외에 다른 사람에게 영향이 가면 안됨.
		//검색어를 받아와 세션에 세팅.
		String search = request.getParameter("search");
		request.getSession().setAttribute("search", search);
		
	}
	
	public void getMsg(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));
			String sql = "select * from jun10_sns, jun05_member where m_id=s_id and s_no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			
			String msg = rs.getString("s_msg").replace("\r\n", "<br>");
			SNSMsg s = new SNSMsg(no, msg, rs.getString("s_date"), rs.getString("s_id"), rs.getString("m_name"), rs.getString("m_photo"));
			request.setAttribute("s", s);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public void updateSNSMsg(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();

			int no = Integer.parseInt(request.getParameter("no"));
			String msg = request.getParameter("msg").replace("\r\n", "<br>");
			
			String sql = "update jun10_sns set s_msg=? where s_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, msg);
			pstmt.setInt(2, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "msg 수정 성공");
			} else {
				request.setAttribute("result", "msg 수정 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
}
