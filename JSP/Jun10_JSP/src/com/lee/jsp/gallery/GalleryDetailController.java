package com.lee.jsp.gallery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.jsp.member.MemberDAO;

/**
 * Servlet implementation class GalleryDetailController
 */
@WebServlet("/GalleryDetailController")
public class GalleryDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("p", request.getParameter("p"));
		if(MemberDAO.getMdao().loginCheck(request, response)) {
		}
		GalleryDAO.getGDAO().detail(request, response);
		GalleryDAO.getGDAO().makeToken(request, response);
		request.setAttribute("contentPage", "gallery/detail.jsp");
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
