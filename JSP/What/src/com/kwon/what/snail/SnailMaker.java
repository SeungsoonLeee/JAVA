package com.kwon.what.snail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SnailMaker {
	public static void make(HttpServletRequest request, HttpServletResponse response) {
		int size = Integer.parseInt(request.getParameter("size"));
		int[][] result = new int[size][size];
		int num = 0;
		int t = 1;
		int y = 0;
		int x = -1;
		while (true) {
			for (int i = 0; i < size; i++) {
				x += t;
				num++;
				result[y][x] = num;
			}
			size--;
			if (size == 0) {
				break;
			}
			for (int i = 0; i < size; i++) {
				y += t;
				num++;
				result[y][x] = num;
			}
			t *= -1;
		}
		request.setAttribute("result", result);
	}
}
