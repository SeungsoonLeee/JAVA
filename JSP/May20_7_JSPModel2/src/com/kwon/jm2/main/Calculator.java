package com.kwon.jm2.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator {
	public static void calculate(HttpServletRequest request, HttpServletResponse response) {
		int wheel = Integer.parseInt(request.getParameter("wheel"));
		int front = Integer.parseInt(request.getParameter("front"));
		int back = Integer.parseInt(request.getParameter("back"));
		int count = Integer.parseInt(request.getParameter("count"));

		double distance = wheel * ((double)front / back) * count;
		request.setAttribute("d", distance);
	}
}
