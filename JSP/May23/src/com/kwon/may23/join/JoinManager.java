package com.kwon.may23.join;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JoinManager {
	public static void join(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("photo");
			MultipartRequest mr = new MultipartRequest(request, path, 31457280, "euc-kr",
					new DefaultFileRenamePolicy());
			String n = mr.getParameter("n");

			String y = mr.getParameter("y");
			int y2 = Integer.parseInt(y);
			String m = mr.getParameter("m");
			int m2 = Integer.parseInt(m);
			String d = mr.getParameter("d");
			int d2 = Integer.parseInt(d);

			String bd = String.format("%s%02d%02d", y, m2, d2);
			Date bd2 = new SimpleDateFormat("yyyyMMdd").parse(bd);

			String nowYear = new SimpleDateFormat("yyyy").format(new Date());
			int nowYear2 = Integer.parseInt(nowYear);
			int age = nowYear2 - y2 + 1;

			String g = mr.getParameter("g");
			String[] v = mr.getParameterValues("v");
			String i = mr.getParameter("i").replace("\r\n", "<br>");
			double h = Double.parseDouble(mr.getParameter("h"));
			double w = Double.parseDouble(mr.getParameter("w"));
			double stdWeight = (h - 100) * 0.9;
			double bimando = w / stdWeight;
			String p = mr.getFilesystemName("p");
			p = URLEncoder.encode(p, "euc-kr");
			p = p.replace("+", " ");

			Member member = new Member(n, bd2, age, g, v, i, h, w, bimando, p);
			request.setAttribute("member", member);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
