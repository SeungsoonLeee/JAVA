package com.kwon.io.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		String path = request.getSession().getServletContext().getRealPath("f");
		
		MultipartRequest mr 
			= new MultipartRequest(request, path, 30 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		
		String t = mr.getParameter("t");
		String d = mr.getParameter("d").replace("\r\n", "<br>");
		String f = mr.getFilesystemName("f");
		f = URLEncoder.encode(f, "euc-kr");
		f = f.replace("+", " ");
				
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset='euc-kr'></head><body>");
		out.printf("<h1>%s</h1>", t);
		out.printf("%s<p>", d);
		out.printf("<a href='f/%s'>다운받기</a>", f);
		out.print("</body></html>");
	}

}
