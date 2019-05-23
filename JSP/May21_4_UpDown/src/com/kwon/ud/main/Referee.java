package com.kwon.ud.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// java : static -> 프로그램 실행시
// jsp : static -> 처음 그 객체 쓸 때
public class Referee {
	private int ans;
	//private int turn; // session, cookie(클라이언트 개인의 공간)
	private static final Referee REFEREE = new Referee();

	public void pickNewAns() {
		ans = new Random().nextInt(1001);
		System.out.println(ans);
	}
	
	private Referee() {
		ans = new Random().nextInt(1001);
		System.out.println(ans);
	}

	public static Referee getReferee() {
		return REFEREE;
	}

	public void judge(HttpServletRequest request, HttpServletResponse response) {
		int n = Integer.parseInt(request.getParameter("n"));
		//turn++;
		//System.out.println(turn);
		if (ans < n) {
			request.setAttribute("result", "답이 더 작음");
		} else if (ans > n) {
			request.setAttribute("result", "답이 더 큼");
		} else {
			request.setAttribute("result", "정답");
		}
	}

}
