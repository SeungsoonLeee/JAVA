package com.kwon.may31.snack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.may31.main.DateManager;

/**
 * Servlet implementation class SnackRegController
 */
@WebServlet("/SnackRegController")
public class SnackRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnackRegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateManager.getCurrentYear(request, response);
		request.setAttribute("contentPage", "snack/snackReg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SnackDAO.getSdao().reg(request, response);
		SnackDAO.getSdao().getAllSnack(request, response);
		SnackDAO.getSdao().paging(1, request, response);
		request.setAttribute("contentPage", "snack/snack.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}



