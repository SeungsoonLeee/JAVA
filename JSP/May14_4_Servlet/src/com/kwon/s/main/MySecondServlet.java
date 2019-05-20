package com.kwon.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WAS에서만 실행되는
// 클라이언트의 요청에 대해 응답하는 프로그램

@WebServlet("/MySecondServlet") // 이 파일 톰캣에 등록
public class MySecondServlet extends HttpServlet {
	// 클라이언트로부터 GET방식 요청 받으면 자동 호출
	//		직접 주소 치는거
	//		클릭해서 
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		int a = 10 + 20;
		
		// 통신회선에 달려있는 응답용 빨대
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<marquee>" + a + "</marquee>");
		out.write("</body></html>");
	}
	
	
	
	
	
	// 클라이언트로부터 POST방식 요청 받으면 자동 호출
	//		로그인 같은 특수한 상황일때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
