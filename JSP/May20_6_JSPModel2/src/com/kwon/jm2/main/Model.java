package com.kwon.jm2.main;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Model {
	public static void test(HttpServletRequest request, HttpServletResponse response) {
		String path 
			= request.getSession()
			.getServletContext().getRealPath("img");
		
		try {
			MultipartRequest mr = 
				new MultipartRequest(request,
						path, 30*1024*1024, "euc-kr", 
						new DefaultFileRenamePolicy());
			// 읽을때만 mr
			String t = mr.getParameter("t");
			String p = mr.getFilesystemName("p");
			p = URLEncoder.encode(p, "euc-kr");
			p = p.replace("+", " ");
			System.out.println(t);
			System.out.println(p);
			
			// 결과처리는 기존대로
			request.setAttribute("t", t);
			request.setAttribute("p", p);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public static void test(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			// 요청 파라메터 한글처리는 
//			// 최초로 값 읽기 전에 => 다음부터 안해도 됨
//			request.setCharacterEncoding("euc-kr");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		String t = request.getParameter("t");
//		System.out.println(t);
//	}
	
}




