package com.kwon.jm2.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 객체가 필요없나
public class Calculator {
	public static void calc(
		HttpServletRequest request, 
		HttpServletResponse response) {
		
		String n = request.getParameter("n");
		String b = request.getParameter("b");
		String y = b.substring(0, 2);
		String m = b.substring(2, 4);
		String d = b.substring(4, 6);
		int yy = Integer.parseInt(y) + 1900;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(new Date());
		int curYear2 = Integer.parseInt(curYear);
		int age = curYear2 - yy + 1;
		
		Human h = new Human(n, y, m, d, age);
		request.setAttribute("h", h);
	}
	
}




