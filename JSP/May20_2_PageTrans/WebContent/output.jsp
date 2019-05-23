<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>output</h1>
	<%
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		
		// 자동이동
		// 		이벤트 없이 바로 third쪽으로 이동
		
		// redirect : 공사중
		//response.sendRedirect("third.jsp");
		
		// forward
		// input -> output으로 올 때 행했던 요청정보를 
		// third까지 전달해줌
		RequestDispatcher rd
			= request.getRequestDispatcher("third.jsp");
		
		request.setAttribute("a", z);
		request.setAttribute("b", "ㅋㅋㅋ");
		request.setAttribute("c", new Random());
		
		rd.forward(request, response);
		
		// include(위치조절불가 : 최상단에만)
		// output.jsp속에 third.jsp를 포함
		// rd.include(request, response);
		
		////////////////////////////////////
		// 값
		// parameter
		//		(GET방식요청일때)주소에
		//		(POST방식요청일때)내부적으로
		//		<input>에 사용자가 입력한 값
		//		요청에 적재됨
		//		String or String[]
		// attribute
		//		java로 만든 값
		//		요청에 적재됨
		//		Object면 아무거나 다 가능
		// session
		// cookie
	%>
	<%=x %> + <%=y %> = <%=z %>
</body>
</html>




