package com.lee.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class secondM{
	public static void test(HttpServletRequest request, HttpServletResponse response) {
		String a = request.getParameter("a");
		System.out.println(a);
		
		int b = 100;
		request.setAttribute("b", b);
		
		//attribute를 자바로 읽어올 때 
		int read_b = (Integer)request.getAttribute("b");
		System.out.println(read_b);
		
		//session을 이용한 값 넘김
		int c = 1000;
		request.getSession().setAttribute("c", c);
		request.getSession().setMaxInactiveInterval(5); //session 최대 유지시간 설정, 시간 내 작업하지 않으면 세션이 끊긴다.
		
		//cookie를 이용한 값 넘김
		String d = "2000";
		Cookie cookie = new Cookie("d", d);
		cookie.setMaxAge(5); //쿠키 유지시간 설정
		response.addCookie(cookie);
	}
}
