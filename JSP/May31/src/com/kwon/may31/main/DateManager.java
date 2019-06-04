package com.kwon.may31.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateManager {
	public static void getCurrentYear(HttpServletRequest request, HttpServletResponse response) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(now);
		request.setAttribute("curYear", year);
	}
}






