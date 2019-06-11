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
	private static final SNSDAO SDAO = new SNSDAO();

	private SNSDAO() {
		// TODO Auto-generated constructor stub
	}

	public static SNSDAO getSdao() {
		return SDAO;
	}

	public void whiteSNS(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			Member m = (Member) request.getSession().getAttribute("m");
			
			//현재 요청 시간
			String token = request.getParameter("token");
			//이전 글쓰기 성공한 요청 시간
			String successToken = (String)request.getSession().getAttribute("successToken");
			String id = m.getId();
			String msg = request.getParameter("msg").replace("\r\n", "<br>");
			//String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			
			if(successToken == null || !token.equals(successToken)) {
				String sql = "insert into jun10_sns values(jun10_sns_seq.nextval, ?, ?, sysdate)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, msg);
			}
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "sns 쓰기 성공");
				request.getSession().setAttribute("successToken", token);
			}
			else {
				request.setAttribute("result", "sns 쓰기 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public void loadSNSMsg(HttpServletRequest request, HttpServletResponse response) {
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
				snsMsgs.add(new SNSMsg(rs.getInt("s_no"), msg,
						rs.getString("s_date"), rs.getString("m_id"),
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
		//키 값을 만들어 요청이 DB에 들어가지 않도록
		String now = new SimpleDateFormat("HH:mm:ss:SS").format(new Date());
		
		request.setAttribute("token", now);
	}
	
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
}
