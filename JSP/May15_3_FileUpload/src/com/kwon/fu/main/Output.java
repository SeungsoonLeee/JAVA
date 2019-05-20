package com.kwon.fu.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



// 1. 파일 전송기능 없음 => 직접 만들어야
// 2. 남이 구현해놓은 파일 전송기능을 활용(cos.jar)
// 3. cos.jar에서 시키는대로 작업
// 		3.1 파일이 업로드될 폴더 확보
//		3.2 파일을 주소에 쓸 수는 없으니 POST방식요청
//		3.3 form의 데이터 인코딩 방식을 cos.jar의 방식으로
//			enctype="multipart/form-data"


@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Output() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		String n = request.getParameter("n");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset='euc-kr'></head><body>");
		out.printf("<h1>이름 : %s</h1>", n);
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		// 파일이 업로드 될 서버 상의 폴더 경로(전체)
		String path 
			= request.getSession()
			.getServletContext().getRealPath("file");
		System.out.println(path);
		// cos.jar방식으로 보내진 요청(파일 업로드 완료)
		MultipartRequest mr 
			= new MultipartRequest(
				request,
				path,
				10 * 1024 * 1024,// 업로드 될 파일의 허용 최대 크기
				"euc-kr", // 요청 파라메터 한글 처리
				new DefaultFileRenamePolicy()// 중복파일명 처리
		);
		
		String n = mr.getParameter("n");
		// 업로드한 파일명
		String p = mr.getFilesystemName("photo"); // ㅋ ㅋ.png
		// 톰캣은 utf-8이외의 한글파일명 인식x
		// URL인코딩으로 바꿔서 사용해야
		p = URLEncoder.encode(p, "euc-kr"); 	// %2A+%2A.png
		// 띄어쓰기는 +로 바꾸지 말고 띄어쓰기 상태로 있어야
		p = p.replace("+", " ");				// %2A %2A.png
		
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset='euc-kr'></head><body>");
		out.printf("<h1>이름 : %s</h1>", n);
		out.printf("<img src='file/%s'>", p);
		out.print("</body></html>");
	}

}

