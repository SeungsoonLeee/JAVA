<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR"> 
<title>Insert title here</title>
</head>
<body>
	<table id="snackDetailTable">
		<form action="SnackUpdateController" name="snackUpdateForm"	onsubmit="return snackUpdateCheck();">
			<input name="no" value="${s.no }" type="hidden">
		<tr>
			<td class="td1">품명</td>
			<td>${s.name }</td>
		</tr>
		<tr>
			<td class="td1">가격</td>
			<td><input name="price" value="${s.price }" maxlength="5"
				autocomplete="off">원</td>
		</tr>
		<tr>
			<td class="td1">유통기한</td>
			<td><fmt:formatDate value="${s.exp }" type="date"
					dateStyle="long" />
		</tr>
		<tr>
			<td class="td1">설명</td>
			<td>${s.desc }</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button>수정</button>
				</form>
				<button onclick="deleteSnack(${s.no});">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>


