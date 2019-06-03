<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="w" items="${weathers }">
		<table class="weather">
			<tr>
				<td colspan="2" align="center" class="weatherTime">${w.hour }</td>
			</tr>
			<tr>
				<td rowspan="2" align="center">
					<img src="${w.img }">
				</td>
				<td class="wfKor">${w.wfKor }</td>
			</tr>
			<tr>
				<td>${w.temp }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>