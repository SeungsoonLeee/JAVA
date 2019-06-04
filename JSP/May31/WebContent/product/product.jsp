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
				${result } <button onclick="goProductReg();" id="goToSnackRegBtn">등록</button>
			</td>
		</tr>
		<tr>
			<td align="center">
				<c:forEach var="p" items="${products }">
					<table class="product">
						<tr onclick="goProductDetail(${p.no});">
							<td rowspan="2" align="center" class="td1"><img src="photo/${p.photo }"></td>
							<td class="td2">${p.name }</td>
						</tr>
						<tr>
							<td align="right"><fmt:formatNumber value="${p.price }" type="currency"/>&nbsp;</td>
						</Tr>
					</table>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center">
				<c:forEach var="p" begin="1" end="${pageCount }">
					&nbsp;<a href="ProductPageController?p=${p }" class="productPage">${p }</a>&nbsp;
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center">
				<form action="ProductController" method="post" name="productSearchForm" onsubmit="return productSearchCheck();">
					<input name="search" id="snackSearchInput" maxlength="10" autocomplete="off">
					<button id="snackSearchBtn">검색</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>




