package com.kwon.io.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class O3
 */
@WebServlet("/O3")
public class O3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public O3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		String t = request.getParameter("t");
		String[] what = request.getParameterValues("what");

		String[] t2 = t.split("\r\n");

		int[] numbers = new int[t2.length];
		for (int i = 0; i < t2.length; i++) {
			numbers[i] = Integer.parseInt(t2[i]);
		}

		ArrayList<Integer> numbers2 = new ArrayList<Integer>();
		for (String s : t2) {
			numbers2.add(Integer.parseInt(s));
		}

		int max = numbers2.get(0);
		int min = numbers2.get(0);
		int sum = 0;
		for (int i : numbers2) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
			sum += i;
		}
		double avg = sum / (double) numbers2.size();

		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset='euc-kr'></head><body>");

		if (what != null) {
			for (String s : what) {
				if (s.equals("max")) {
					out.printf("최대값 : %d<br>", max);
				} else if (s.equals("min")) {
					out.printf("최소값 : %d<br>", min);
				} else if (s.equals("sum")) {
					out.printf("합계 : %d<br>", sum);
				} else {
					out.printf("평균 : %f<br>", avg);
				}
			}
		}

		out.print("</body></html>");
	}

}
