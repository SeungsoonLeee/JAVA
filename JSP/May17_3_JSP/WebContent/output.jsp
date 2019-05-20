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
		HashMap<String, String[]> hm 
			= new HashMap<String, String[]>();
		hm.put("a", new String[]{"cm", "inch"});
		hm.put("b", new String[]{"㎡", "평"});
		hm.put("c", new String[]{"℃", "℉"});
		hm.put("d", new String[]{"km/h", "mi/h"});
		
		int n = Integer.parseInt(request.getParameter("n"));
		String what = request.getParameter("what");
		double result = n / 2.54; // cm -> inch
		if (what.equals("b")) {
			result = n * 0.3025; // ㎡ → 평
		} else if (what.equals("c")) {
			result = (n * (9 / 5.0)) + 32; // ℃ → ℉
		} else if (what.equals("d")) {
			result = n / 1.609; // km/h → mi/h
		}
		String result2 = String.format("%.1f", result);
	%>
	<table id="<%=what %>Table">
		<tr>
			<td align="center">결과</td>
		</tr>
		<tr>
			<td align="center"><%=n %> <%=hm.get(what)[0] %></td>
		</tr>
		<tr>
			<td align="center">↓</td>
		</tr>
		<tr>
			<td align="center"><%=result2 %> <%=hm.get(what)[1] %></td>
		</tr>
	</table>
</body>
</html>






