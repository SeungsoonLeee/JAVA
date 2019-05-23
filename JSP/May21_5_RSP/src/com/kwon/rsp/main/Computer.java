package com.kwon.rsp.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Computer {

	public static void init(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("myHand", "img/start.GIF");
		request.setAttribute("comHand", "img/start.GIF");
	}

	public static void play(HttpServletRequest request, HttpServletResponse response) {
		int myHand = Integer.parseInt(request.getParameter("h"));
		int comHand = new Random().nextInt(3) + 1;
		int t = myHand - comHand;
		if (t == 0) {
			request.setAttribute("result", "¹«½ÂºÎ");
		} else if (t == -1 || t == 2) {
			request.setAttribute("result", "ÆÐ");
		} else {
			request.setAttribute("result", "½Â");
		}
		request.setAttribute("myHand", "img/" + myHand + ".png");
		request.setAttribute("comHand", "img/" + comHand + ".png");
	}

}
