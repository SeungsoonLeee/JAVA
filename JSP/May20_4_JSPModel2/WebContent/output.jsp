<%@page import="com.kwon.jm2.main.Human"%>
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
		Human h = (Human) request.getAttribute("h");
	%>
	<%=h.getName() %><p>
	<%=h.getbYear() %><p>
	<%=h.getbMonth() %><p>
	<%=h.getbDay() %><p>
	<%=h.getAge() %><p>
</body>
</html>




