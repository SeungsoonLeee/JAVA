package com.kwon.may22.calculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator {
	public static void calc(HttpServletRequest request, HttpServletResponse response) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		request.setAttribute("hab", x+y);
	}
}





