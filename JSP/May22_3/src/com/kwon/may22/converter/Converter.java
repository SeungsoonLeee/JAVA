package com.kwon.may22.converter;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 하나 => singleton
public class Converter {
	private static final Converter C = new Converter();
	private HashMap<String, String[]> hm;
	private Converter() {
		hm = new HashMap<String, String[]>();
		hm.put("a", new String[] { "cm", "inch" });
		hm.put("b", new String[] { "㎡", "평" });
		hm.put("c", new String[] { "℃", "℉" });
		hm.put("d", new String[] { "km/h", "mi/h" });
	}
	public static Converter getC() {
		return C;
	}
	
	public void convert(HttpServletRequest request, HttpServletResponse response) {
		int n = Integer.parseInt(request.getParameter("n"));
		String what = request.getParameter("what");
		double result = n / 2.54; // cm -> inch
		if (what.equals("b")) {
			result = n * 0.3025; // ㎡ → 평
		} else if (what.equals("c")) {
			result = (n * (9 / 5.0)) + 32; // ℃ → ℉
		} else if (what.equals("d")) {
			result = n / 1.609; // km/h → mi/h
		}
		String result2 = String.format("%.1f", result);
	
		Result r 
			= new Result(n, result2, 
				hm.get(what)[0], hm.get(what)[1]);
		request.setAttribute("r", r);
	}

}



