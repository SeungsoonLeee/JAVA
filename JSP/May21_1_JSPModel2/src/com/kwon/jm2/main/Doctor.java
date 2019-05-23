package com.kwon.jm2.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Doctor {
	public static void calculate(HttpServletRequest request, HttpServletResponse response) {
		try {
			MultipartRequest mr = new MultipartRequest(request,
					request.getSession().getServletContext().getRealPath("photo"), 30 * 1024 * 1024, "euc-kr",
					new DefaultFileRenamePolicy());
			String n = mr.getParameter("n");
			double h = Double.parseDouble(mr.getParameter("h"));
			double w = Double.parseDouble(mr.getParameter("w"));
			String p = mr.getFilesystemName("p");
			p = URLEncoder.encode(p, "euc-kr");
			p = p.replace("+", " ");
			double stdWeight = (h - 100) * 0.9;
			double bimando = (w / stdWeight) * 100;
			String result = "저체중";
			if (bimando > 120) {
				result = "비만";
			} else if (bimando > 80) {
				result = "정상";
			}
			
			Human hh 
				= new Human(n, h, w, stdWeight, bimando, p, result);
			request.setAttribute("hh", hh);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





