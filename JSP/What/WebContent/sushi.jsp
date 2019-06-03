<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="rail">
		<tr>
			<td>
				<c:forEach var="d" items="${dishes }">
					<button class="${d.color }" onclick="eat('${d.color}');">${d.name }</button>
				</c:forEach>
			</td>
		</tr>
	</table>
	<p align="center" id="money"><fmt:formatNumber value="${money }" type="currency"/></p>
</body>
</html>