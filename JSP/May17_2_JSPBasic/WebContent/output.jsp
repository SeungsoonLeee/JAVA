<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	table {
		color:green;
	}
</style>
</head>
<body>
	<%
		 int x = Integer.parseInt(request.getParameter("x"));
		 int y = Integer.parseInt(request.getParameter("y"));
	%>
	<table>
		<tr>
			<td><%=x %> + <%=y %> = <%=x + y %></td>
		</tr>
		<tr>
			<td><%=x %> - <%=y %> = <%=x - y %></td>
		</tr>
		<tr>
			<td><%=x %> * <%=y %> = <%=x * y %></td>
		</tr>
		<tr>
			<td><%=x %> / <%=y %> = <%=x / y %></td>
		</tr>
	</table>
</body>
</html>



