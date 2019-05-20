package com.kwon.io.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class O2
 */
@WebServlet("/O2")
public class O2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public O2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		String what = request.getParameter("what");

		int result = x / y;
		if (what.equals("+")) {
			result = x + y;
		} else if (what.equals("-")) {
			result = x - y;
		} else if (what.equals("*")) {
			result = x * y;
		}

		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset='euc-kr'></head><body>");
		out.print("<h1>°á°ú</h1>");
		out.printf("%d %s %d = %d", x, what, y, result);
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
