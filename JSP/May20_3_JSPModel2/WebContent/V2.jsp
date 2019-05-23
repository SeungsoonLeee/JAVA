<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>V2</h1>
	<%
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int a = (Integer) request.getAttribute("aa");
		int b = (Integer) request.getAttribute("bb");
		int c = (Integer) request.getAttribute("cc");
		int d = (Integer) request.getAttribute("dd");
	%>
	<%=x %> + <%=y %> = <%=a %><p>
	<%=x %> - <%=y %> = <%=b %><p>
	<%=x %> * <%=y %> = <%=c %><p>
	<%=x %> / <%=y %> = <%=d %><p>
</body>
</html>




