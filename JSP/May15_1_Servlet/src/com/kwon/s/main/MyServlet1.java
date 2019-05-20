package com.kwon.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	// http://localhost/May15_1_Servlet/MyServlet1?money=100000&say=test
	// 통신방식://주소:포트번호/폴더명/폴더명/.../파일명?변수명=값&변수명=값&변수명=값...
	// 포트번호80은 생략가능
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 요청할때 보낸 값:요청파라메터(String)
		String mHaha = request.getParameter("money");
		String sss = request.getParameter("say");
		
		// 응답할때 인코딩방식을 euc-kr로
		response.setCharacterEncoding("euc-kr");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.printf("<h1>%s</h1>", mHaha);
		out.printf("<h1>%s</h1>", sss);
		out.print("</body></html>");
	}

	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
