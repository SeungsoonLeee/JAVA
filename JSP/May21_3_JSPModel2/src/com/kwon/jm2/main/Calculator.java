package com.kwon.jm2.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator {
	public static void calculate(HttpServletRequest request, HttpServletResponse response) {
		String[] t = request.getParameter("t").split("\r\n");
		String[] what = request.getParameterValues("what");

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int n = 0;
		for (int i = 0; i < t.length; i++) {
			try {
				n = Integer.parseInt(t[i]);
				numbers.add(n);
			} catch (Exception e) {
				System.out.println(t[i] + " : 숫자 아님");
			}
		}

		int max = numbers.get(0);
		int min = numbers.get(0);
		int sum = 0;
		for (Integer i : numbers) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
			sum += i;
		}
		double avg = sum / numbers.size();
		ArrayList<String> result = new ArrayList<String>();
		if (what != null) {
			for (String w : what) {
				if (w.equals("max")) {
					result.add("최대값 : " + max);
				} else if (w.equals("min")) {
					result.add("최소값 : " + min);
				} else if (w.equals("sum")) {
					result.add("합계 : " + sum);
				} else if (w.equals("avg")) {
					result.add("평균 : " + avg);
				}
			}
		}
		request.setAttribute("r", result);
	}
}



