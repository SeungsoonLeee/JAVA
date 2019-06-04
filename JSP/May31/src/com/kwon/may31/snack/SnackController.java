package com.kwon.may31.snack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SnackController
 */
@WebServlet("/SnackController")
public class SnackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SnackController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SnackDAO.getSdao().getAllSnack(request, response);
		SnackDAO.getSdao().paging(1, request, response);
		request.setAttribute("contentPage", "snack/snack.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SnackDAO.getSdao().search(request, response);
		SnackDAO.getSdao().paging(1, request, response);
		request.setAttribute("contentPage", "snack/snack.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}



