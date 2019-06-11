package com.lee.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class thirdM{
	public static void test(HttpServletRequest request, HttpServletResponse response) {
		//secondV에서 새로운 요청을 하기 때문에 a, b을 third까지 가져올 수 없음.
		//session과 cookie를 이용하여 값을 전달해야 한다.
		
		//session 읽기
		int read_c = (Integer)request.getSession().getAttribute("c");
		System.out.println("세션값 : " + read_c);
		
		//cookie 일기
		//현재 만들어져 있는 쿠키들 중에 내가 만든 쿠키를 읽어와야 함.
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("d")){
				System.out.println("쿠키값 : " + cookie.getValue());
			}
		}
	}
}
