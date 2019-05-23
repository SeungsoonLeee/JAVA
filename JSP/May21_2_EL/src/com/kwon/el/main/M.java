package com.kwon.el.main;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class M {
	public static void test(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("euc-kr");
			String pt = request.getParameter("plainText");
			System.out.println(pt);
			
			String pt2 = "¤¾¤¾¤¾";
			request.setAttribute("pt2", pt2);
			
			int n2 = 123;
			request.setAttribute("n2Haha", n2);
			
			Human h = new Human("È«±æµ¿", 30);
			request.setAttribute("hh", h);
			
			String[] ar = {"¤»", "¤¾"};
			request.setAttribute("ar", ar);
			
			ArrayList<String> al = new ArrayList<String>();
			al.add("¤·");
			al.add("¤Ð");
			request.setAttribute("al", al);
			
			ArrayList<Human> humans = new ArrayList<Human>();
			humans.add(new Human("È«±æµ¿", 10));
			humans.add(new Human("±è±æµ¿", 20));
			request.setAttribute("humans", humans);
			
			String str = "abcd";
			request.getSession().setAttribute("str", str);
			
			Cookie c = new Cookie("c", str);
			response.addCookie(c);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}





