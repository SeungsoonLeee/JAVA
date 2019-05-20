package com.kwon.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MS2
 */
@WebServlet("/MS2")
public class MS2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MS2() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// 요청파라메터들이 주소에
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		String xx = request.getParameter("x");
		int x = Integer.parseInt(xx);
		int y = Integer.parseInt(request.getParameter("y"));

		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset='euc-kr'></head><body>");
		out.printf("%d + %d = %d<br>", x, y, x + y);
		out.printf("%d - %d = %d<br>", x, y, x - y);
		out.printf("%d * %d = %d<br>", x, y, x * y);
		out.printf("%d / %d = %d<br>", x, y, x / y);
		out.print("</body></html>");
	}

	// 요청파라메터들이 주소에x
	// 내부적으로 전달
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		String xx = request.getParameter("x");
		int x = Integer.parseInt(xx);
		int y = Integer.parseInt(request.getParameter("y"));

		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset='euc-kr'></head><body>");
		out.print("<h1>POST</h1>");
		out.printf("%d + %d = %d<br>", x, y, x + y);
		out.printf("%d - %d = %d<br>", x, y, x - y);
		out.printf("%d * %d = %d<br>", x, y, x * y);
		out.printf("%d / %d = %d<br>", x, y, x / y);
		out.print("</body></html>");
	}

}
