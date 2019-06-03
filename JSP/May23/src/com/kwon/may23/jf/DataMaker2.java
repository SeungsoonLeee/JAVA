package com.kwon.may23.jf;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataMaker2 {
	public static void make(HttpServletRequest request, HttpServletResponse response) {
		int n = 123456789;
		request.setAttribute("n", n);
		
		int money = 123456789;
		request.setAttribute("money", money);
		
		double rate = 0.76;
		request.setAttribute("rate", rate);
		
		double n2 = 123456789.123456789;
		request.setAttribute("n2", n2);
		
		Date now = new Date();
		request.setAttribute("now", now);
	}
}



