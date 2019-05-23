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
	<h1>third</h1>
	<%
		String x = request.getParameter("x");
		
		Object a = request.getAttribute("a");
		Integer aa = (Integer) a;
		
		String b = (String) request.getAttribute("b");
		Random c = (Random) request.getAttribute("c");
	%>
	<%=x %>
	<%=aa %>
	<%=b %>
	<%=c.nextInt(100) %>
</body>
</html>



