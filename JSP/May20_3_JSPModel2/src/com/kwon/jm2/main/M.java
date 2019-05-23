package com.kwon.jm2.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Model : 실제 계산, ...
//		일반 자바클래스
//		계산결과는 attribute로
public class M {
	public void calculate(
		HttpServletRequest request, 
		HttpServletResponse response) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int a = x + y;
		int b = x - y;
		int c = x * y;
		int d = x / y;
		request.setAttribute("aa", a);
		request.setAttribute("bb", b);
		request.setAttribute("cc", c);
		request.setAttribute("dd", d);
	}
}



