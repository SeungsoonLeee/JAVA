package com.kwon.io.main;

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
	// 톰캣이 자동으로 바꿀때 우리가 원하는 인코딩 방식을 쓰도록
	
	// 주소에 한글x
	//		ㅋ -> %2A : 톰캣이 자동으로
	//		%2A -> ㅋ : 톰캣이 자동으로
	// 파라메터가 주소에
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		String n = request.getParameter("n");
		String p = request.getParameter("p");
		String g = request.getParameter("g");
		String g2 = request.getParameter("g2");

		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset='euc-kr'></head><body>");
		out.print("<h1>Output</h1>");
		out.printf("이름 : %s<p>", n);
		out.printf("비번 : %s<p>", p);
		out.printf("성별 : %s<p>", g);
		out.printf("성별 : %s<p>", g2);
		out.print("</body></html>");
	}

	// 파라메터가 내부적으로 전달
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		String n = request.getParameter("n");
		
		// checkbox or select(multiple)
		String[] i = request.getParameterValues("i");
		String[] i2 = request.getParameterValues("i2");
		
		// textarea에서 엔터친거 : \n
		// html에서 줄바꿈 : <br>
		String s = request.getParameter("s");
		s = s.replace("\n", "<br>"); // ?
		System.out.println(s);
		
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset='euc-kr'></head><body>");
		out.print("<h1>Output</h1>");
		out.printf("이름 : %s<p>", n);
		out.printf("할 말 : %s<p>", s);
		out.print("관심사 : ");
		for (String string : i) {
			out.print(string + " ");
		} 
		out.print("<p>");
		out.print("관심사2 : ");
		for (String string : i2) {
			out.print(string + " ");
		} 
		out.print("<p>");
		out.print("<p>");
		out.print("</body></html>");
	}

}
