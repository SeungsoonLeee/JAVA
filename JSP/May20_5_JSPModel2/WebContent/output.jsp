<%@page import="com.kwon.jm2.main.Result"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
	<%
		Result r = (Result) request.getAttribute("r");
		String what = request.getParameter("what");
	%>
	<table id="<%=what %>Table">
		<tr>
			<td align="center">결과</td>
		</tr>
		<tr>
			<td align="center"><%=r.getN() %> <%=r.getFrom() %></td>
		</tr>
		<tr>
			<td align="center">↓</td>
		</tr>
		<tr>
			<td align="center"><%=r.getResult() %> <%=r.getTo() %></td>
		</tr>
	</table>
</body>
</html>






