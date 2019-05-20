package com.kwon.sd.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kwon.sd.main.DBManager;

// M
public class StudentDAO {
	private static final StudentDAO SDAO = new StudentDAO();

	public static StudentDAO getSdao() {
		return SDAO;
	}

	private StudentDAO() {
	}

	public String del(Student s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String sql = "delete from may10_student " + "where s_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s.getS_no());

			if (pstmt.executeUpdate() == 1) {
				return "성공";
			}
			return "실패";
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public ArrayList<Student> getAllStudent() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from may10_student order by s_name";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Student> students = new ArrayList<Student>();
			Student s = null;
			while (rs.next()) {
				s = new Student();
				s.setS_no(rs.getInt("s_no"));
				s.setS_name(rs.getString("s_name"));
				s.setS_age(rs.getInt("s_age"));
				s.setS_gender(rs.getString("s_gender"));
				s.setS_address(rs.getString("s_address"));
				s.setS_l_name(rs.getString("s_l_name"));
				students.add(s);
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public String reg(Student s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String sql = "insert into may10_student " + "values(may10_student_seq.nextval," + "?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getS_name());
			pstmt.setInt(2, s.getS_age());
			pstmt.setString(3, s.getS_gender());
			pstmt.setString(4, s.getS_address());
			pstmt.setString(5, s.getS_l_name());

			if (pstmt.executeUpdate() == 1) {
				return "성공";
			}
			return "실패";
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public ArrayList<Student> search(Student stu) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from may10_student " 
					+ "where s_name like '%'||?||'%' " 
					+ "order by s_name";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu.getS_name());
			rs = pstmt.executeQuery();

			ArrayList<Student> students = new ArrayList<Student>();
			Student s = null;
			while (rs.next()) {
				s = new Student();
				s.setS_no(rs.getInt("s_no"));
				s.setS_name(rs.getString("s_name"));
				s.setS_age(rs.getInt("s_age"));
				s.setS_gender(rs.getString("s_gender"));
				s.setS_address(rs.getString("s_address"));
				s.setS_l_name(rs.getString("s_l_name"));
				students.add(s);
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public String update(Student s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String sql = "update may10_student " + "set s_age=? " + "where s_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s.getS_age());
			pstmt.setInt(2, s.getS_no());

			if (pstmt.executeUpdate() == 1) {
				return "성공";
			}
			return "실패";
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}
