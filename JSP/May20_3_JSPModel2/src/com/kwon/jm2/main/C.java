package com.kwon.jm2.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller : Model/View가 필요한 순간에 부르는 역할
//				이 사이트의 진입점
// Servlet : 요청에 대한 응답
@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // 어떤 사이트의 첫 진입은 GET방식 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd
			= request.getRequestDispatcher("V.html");
		rd.forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M m = new M();
		m.calculate(request, response);
		
		request.getRequestDispatcher("V2.jsp").forward(request, response);
	}

}


