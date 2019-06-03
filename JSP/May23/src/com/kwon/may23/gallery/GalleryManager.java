package com.kwon.may23.gallery;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class GalleryManager {
	public static void getFiles(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("photo");
			File folder = new File(path);
			String[] files = folder.list();
			
			ArrayList<String> files2 = new ArrayList<String>();
			for (String s : files) {
				s = URLEncoder.encode(s, "euc-kr");
				s = s.replace("+", " ");
				files2.add(s);
			}
			request.setAttribute("files", files2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void upload(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("photo");
			System.out.println(path);

			new MultipartRequest(request, path, 31457280, "euc-kr",
					new DefaultFileRenamePolicy());
			request.setAttribute("r", "업로드 성공");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "업로드 실패");
		}
	}
}
