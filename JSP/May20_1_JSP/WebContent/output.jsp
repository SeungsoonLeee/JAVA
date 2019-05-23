<%@page import="java.sql.Connection"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	%>
	<table>
		<tr>
			<td align="center">결과</td>
		</tr>
		<tr>
			<td align="center"><img src="photo/<%=p%>"></td>
		</tr>
		<tr>
			<td align="center">이름 : <%=n%></td>
		</tr>
		<tr>
			<td align="center">키 : <%=h%></td>
		</tr>
		<tr>
			<td align="center">몸무게 : <%=w%></td>
		</tr>
		<tr>
			<td align="center">표준체중 : <%=stdWeight%></td>
		</tr>
		<tr>
			<td align="center">비만도: <%=bimando%></td>
		</tr>
		<tr>
			<td align="center"><%=result%></td>
		</tr>
	</table>
</body>
</html>





