<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="productDetailTable">
		<form action="ProductUpdateController" name="productUpdateForm"
			enctype="multipart/form-data" method="post"
			onsubmit="return productUpdateCheck();">
			<input name="no" value="${p.no }" type="hidden">
		<tr>
			<td class="td1">품명</td>
			<td><input name="name" value="${p.name }" autocomplete="off"></td>
		</tr>
		<tr>
			<td class="td1">가격</td>
			<td><input name="price" value="${p.price }" maxlength="5"
				autocomplete="off">원</td>
		</tr>
		<tr>
			<td class="td1">사진</td>
			<td><img src="photo/${p.photo }"><br> <input
				name="photo" type="file"></td>
		</tr>
		<tr>
			<td class="td1">설명</td>
			<td><textarea name="desc" cols="40" rows="5">${p.desc }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button>수정</button>
				</form>
				<button onclick="deleteProduct(${p.no});">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>


