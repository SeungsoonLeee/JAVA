package com.lee.jsp.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( MemberDAO.getMdao().loginCheck(request, response)) {
			MemberDAO.getMdao().getMemberInfo(request, response);
			request.setAttribute("contentPage", "member/info.jsp");
		}
		else {
			request.setAttribute("contentPage", "home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( MemberDAO.getMdao().loginCheck(request, response)) {
			MemberDAO.getMdao().update(request, response);
			MemberDAO.getMdao().getMemberInfo(request, response);
		}
		request.setAttribute("contentPage", "member/info.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
