package com.kwon.j.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Output
 */
@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Output() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int add(int x, int y) {
		return x+y;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset='euc-kr'></head><body>");
		out.printf("%d + %d = %d<p>", x, y, x + y);
		out.printf("%d - %d = %d<p>", x, y, x - y);
		out.printf("%d * %d = %d<p>", x, y, x * y);
		out.printf("%d / %d = %d<p>", x, y, x / y);
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}




