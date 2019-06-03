package com.kwon.what.star;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StarMaker {
	public static void make(HttpServletRequest request, HttpServletResponse response) {
		int floor = Integer.parseInt(request.getParameter("floor"));
		String direction = request.getParameter("direction");
		ArrayList<String> stars = new ArrayList<String>();
		StringBuffer sb = null;
		for (int i = 1; i <= floor; i++) {
			sb = new StringBuffer();
			if (direction.equals("a")) {
				for (int j = 1; j <= i; j++) {
					sb.append(" * ");
				}
			} else {
				for (int j = 1; j <= floor - i + 1; j++) {
					sb.append(" * ");
				}
			}
			stars.add(sb.toString());
		}
		request.setAttribute("stars", stars);
	}
}
