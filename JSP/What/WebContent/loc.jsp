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
	<form action="LocController" method="post" name="locSearchForm" onsubmit="return locSearchCheck();">
		<table id="locSearchTable">
			<tr>
				<td><input name="search" id="locSearchInput" autocomplete="off" autofocus="autofocus"></td>
				<td><button id="locSearchBtn">검색</button></td>
			</tr>
		</table>
	</form>
	<hr>
	<c:forEach var="l" items="${locations }">
		<table class="loc">
			<tr>
				<td class="locName">${l.name }(${l.distance }m)</td>
			</tr>
			<tr>
				<td>${l.address }</td>
			</tr>
			<tr>
				<td align="right">&nbsp;${l.phone }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>