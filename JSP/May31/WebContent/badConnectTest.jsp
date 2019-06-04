<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.46:1521:xe";
		try {
			Connection con 
				= DriverManager.getConnection(url, "kwon", "kwon");
	%>
			<h1>연결됨</h1>
	<%
		} catch (Exception e) {
	%>
			<h1>연결실패</h1>
	<%
		}
	%>
</body>
</html>







