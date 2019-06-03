package com.kwon.what.word;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Referee {
	private String preSay;
	private static final Referee REFEREE = new Referee();
	private Referee() {
		// TODO Auto-generated constructor stub
	}
	public static Referee getReferee() {
		return REFEREE;
	}
	public void start(HttpServletRequest request, HttpServletResponse response) {
		preSay = "시작";
		request.setAttribute("preSay", preSay);
	}

	public void play(HttpServletRequest request, HttpServletResponse response) {
		String say = request.getParameter("say");
		if (say.equals("gameover")) {
			request.setAttribute("contentPage", "word/gameover.jsp");
		} else {
			if (preSay.equals("시작")) {
				request.setAttribute("contentPage", "word/word.jsp");
				preSay = say;
			} else {
				if (say.startsWith(preSay.charAt(preSay.length() - 1) + "")) {
					request.setAttribute("contentPage", "word/word.jsp");
					preSay = say;
				} else {
					request.setAttribute("contentPage", "word/gameover.jsp");
				}
			}
			request.setAttribute("preSay", preSay);
		}
	}
}
