<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// String t = request.getParameter("t");
		String t = (String) request.getAttribute("t");
		String p = (String) request.getAttribute("p");
	%>
	<%=t %>
	<img src="img/<%=p %>">
</body>
</html>



