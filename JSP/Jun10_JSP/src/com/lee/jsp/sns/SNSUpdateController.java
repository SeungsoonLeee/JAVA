package com.lee.jsp.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.jsp.member.MemberDAO;

/**
 * Servlet implementation class SNSUpdateController
 */
@WebServlet("/SNSUpdateController")
public class SNSUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SNSUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMdao().loginCheck(request, response)) {
			SNSDAO.getSdao().updateSNSMsg(request, response);
			SNSDAO.getSdao().getMsg(request, response);
		}
		SNSDAO.getSdao().makeToken(request, response);
		SNSDAO.getSdao().clearSearch(request, response);
		request.setAttribute("contentPage", "sns/msg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
