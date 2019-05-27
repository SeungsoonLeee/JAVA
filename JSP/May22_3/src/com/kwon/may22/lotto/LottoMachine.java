package com.kwon.may22.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LottoMachine {
	private static final Random R = new Random();

	public static void pick(HttpServletRequest request, HttpServletResponse response) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		while (true) {
			numbers.add(R.nextInt(45) + 1);
			if (numbers.size() == 6) {
				break;
			}
		}
		ArrayList<Integer> numbers2 = new ArrayList<Integer>(numbers);
		
		numbers2.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		request.setAttribute("numbers", numbers2);
	}
}
