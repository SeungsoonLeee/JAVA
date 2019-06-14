package com.lee.jsp.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.jsp.gallery.GalleryDAO;
import com.lee.jsp.home.DBManager;
import com.lee.jsp.sns.SNSDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();

	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getMdao() {
		return MDAO;
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("m", null);

		// autologinID라는 쿠키에 저장된 id값 삭제
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autologinID")) {
					c.setValue(null);
					response.addCookie(c);
					break;
				}
			}
		}
	}

	private void autologinCheck(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autologinID")) {
					if (c.getValue() != null && !c.getValue().equals("")) {
						String id = c.getValue();
						// pw검사 없이 id값만으로 로그인 처리
						Connection con = null;
						PreparedStatement pstmt = null;
						ResultSet rs = null;
						try {
							con = DBManager.connect();

							String sql = "select * from jun05_member where m_id = ?";
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1, id);
							rs = pstmt.executeQuery();

							if (rs.next()) {
								Member m = new Member(rs.getString("m_id"), rs.getString("m_pw"),
										rs.getString("m_name"), rs.getString("m_comment"), rs.getString("m_photo"));
								request.getSession().setAttribute("m", m);
								request.getSession().setMaxInactiveInterval(10 * 60 * 60);
							} else {
								request.setAttribute("result", "미가입ID");
							}
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute("result", "로그인 실패(DB연결실패)");
						} finally {
							DBManager.close(con, pstmt, rs);
						}
						break;
					}
				}
			}
		}
	}

	// 로그인 되어있으면 true, 로그인 풀렸으면 false
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {
		autologinCheck(request, response);

		Member m = (Member) request.getSession().getAttribute("m");
		if (m != null) {
			request.setAttribute("loginPage", "login/loginSuccess.jsp");
			return true;
		} else {
			request.setAttribute("loginPage", "login/login.jsp");
			return false;
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			request.setCharacterEncoding("euc-kr");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			// 그 id에 해당하는 멤버정보 가져오기
			String sql = "select * from jun05_member " + "where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("m_pw").equals(pw)) {
					// request.setAttribute("result", "성공");
					Member m = new Member(rs.getString("m_id"), rs.getString("m_pw"), rs.getString("m_name"),
							rs.getString("m_comment"), rs.getString("m_photo"));
					request.getSession().setAttribute("m", m);
					request.getSession().setMaxInactiveInterval(10 * 60 * 60);

					Cookie c = new Cookie("lastLoginID", id);
					c.setMaxAge(24 * 60 * 60);
					response.addCookie(c);

					// 로그인 상태 유지에 체크 했으면
					if (request.getParameter("autologin") != null) {
						// autologinID라는 쿠키에 id값을 24시간동안 저장
						Cookie c2 = new Cookie("autologinID", id);
						c2.setMaxAge(24 * 60 * 60);
						response.addCookie(c2);
					}
				} else {
					request.setAttribute("result", "PW오류");
				}
			} else {
				request.setAttribute("result", "미가입ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "로그인 실패(DB문제)");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void join(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("img");
//		System.out.println(path);
		MultipartRequest mr = null;
		String photo = null;
		try {
			mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
			photo = mr.getFilesystemName("photo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "가입 실패(파일 업로드 오류)");
			return;
		}
		///////////////////////
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String comment = mr.getParameter("comment").replace("\r\n", "<br>");
			photo = URLEncoder.encode(photo, "euc-kr").replace("+", " ");

			String sql = "insert into jun05_member values(" + "?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, comment);
			pstmt.setString(5, photo);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "가입 성공");
			} else {
				request.setAttribute("result", "가입 실패");
				new File(path + "/" + photo).delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "가입 실패");
			new File(path + "/" + photo).delete();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void getMemberInfo(HttpServletRequest request, HttpServletResponse response) {
		Member m = (Member) request.getSession().getAttribute("m");
		request.setAttribute("cmt", m.getComment().replace("<br>", "\r\n"));
	}

	
	public int getDeleteMsgCount(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "select count(*) from jun10_sns where s_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
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

	private ArrayList<String> getMemberFile(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "select g_file from jun14_gallery where g_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			ArrayList<String> files = new ArrayList<String>();
			
			while(rs.next()) {
				files.add(rs.getString("g_file"));
			}
			
			return files;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return null;
	}
	
	public void secession(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();

			Member m = (Member) request.getSession().getAttribute("m");
			int deleteMsgCount = getDeleteMsgCount(m.getId());

			String sql = "delete from jun05_member where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			
			ArrayList<String> files = getMemberFile(m.getId());
			int deleteFileCount = files.size();
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "탈퇴 성공");
				
				// 사진 삭제 작업
				String m_photo = URLDecoder.decode(m.getPhoto(), "euc-kr");
				String path = request.getSession().getServletContext().getRealPath("img");
				new File(path + "/" + m_photo).delete();
				
				//탈퇴한 사람이 쓴 글의 수를 체크하여 빼주어야 함.
				int allMsgCount = SNSDAO.getSdao().getAllMsgCount();
				if(allMsgCount >= 0) {
					SNSDAO.getSdao().setAllMsgCount(allMsgCount - deleteMsgCount);
				}
				
				//탈퇴한 사람이 쓴 갤러리 파일들 살제
				path = request.getSession().getServletContext().getRealPath("file");
				for( String f : files) {
					new File(path + "/" + f).delete();
				}
				
				//탈퇴한 사람이 쓴 갤러리 수를 체크하여 빼주어야 함.
				int allFileCount = GalleryDAO.getGDAO().getAllFileCount();
				if(allMsgCount >= 0) {
					SNSDAO.getSdao().setAllMsgCount(allFileCount - deleteFileCount);
				}
				
			} else {
				request.setAttribute("result", "탈퇴 실패");
			}
			// 세션과 쿠키 삭제 작업
			logout(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "탈퇴 실패");
			logout(request, response);
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("img");
		MultipartRequest mr = null;

		Member m = (Member) request.getSession().getAttribute("m");
		String exPhoto = m.getPhoto();
		String photo = null;
		try {
			mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
			photo = mr.getFilesystemName("photo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패(파일 업로드 오류)");
			return;
		}
		///////////////////////
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String comment = mr.getParameter("comment").replace("\r\n", "<br>");
			if (photo == null) {
				photo = exPhoto;
			} else {
				photo = URLEncoder.encode(photo, "euc-kr").replace("+", " ");
			}

			String sql = "update jun05_member " + "set m_pw=?, m_name=?, m_comment=?, m_photo=? " + "where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, comment);
			pstmt.setString(4, photo);
			pstmt.setString(5, id);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "수정 성공");
				if (!photo.equals(exPhoto)) {
					exPhoto = URLDecoder.decode(exPhoto, "euc-kr");
					new File(path + "/" + exPhoto).delete();
				}

				Member m2 = new Member(id, pw, name, comment, photo);
				request.getSession().setAttribute("m", m2);
			} else {
				request.setAttribute("result", "수정 실패");
				System.out.println(exPhoto);
				if (!photo.equals(exPhoto)) {
					photo = URLDecoder.decode(photo, "euc-kr");
					new File(path + "/" + photo).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패");
			try {
				if (!photo.equals(exPhoto)) {
					photo = URLDecoder.decode(photo, "euc-kr");
					new File(path + "/" + photo).delete();
				}
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}
