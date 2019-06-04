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
	<table id="snackArea">
		<tr>
			<td align="right">
				${result } <button onclick="goSnackReg();" id="goToSnackRegBtn">등록</button>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="snackTable">
					<tr>
						<th>이름</th>
						<th>가격</th>
					</tr>
					<c:forEach var="s" items="${snacks }">
						<tr class="snack" onclick="goSnackDetail(${s.no});">
							<td>&nbsp;${s.name }</td>
							<td align="right">
								<fmt:formatNumber value="${s.price }" type="currency"/>&nbsp;
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<c:forEach var="p" begin="1" end="${pageCount }">
					&nbsp;<a href="SnackPageController?p=${p }" class="snackPage">${p }</a>&nbsp;
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center">
				<form action="SnackController" method="post" name="snackSearchForm" onsubmit="return snackSearchCheck();">
					<input name="search" id="snackSearchInput" maxlength="10" autocomplete="off">
					<button id="snackSearchBtn">검색</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>




