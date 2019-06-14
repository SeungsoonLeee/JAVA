<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Gallery Detail</title>
</head>
<body>
	<table id="galleryDetailTable">
		<tr>
			<td align="center" class="td1">작성자</td>
			<td class="td2">${g.id }</td>
		</tr>
		<tr>
			<td align="center" class="td1">제목</td>
			<td class="td2">${g.title }</td>
		</tr>
		<tr>
			<td align="center" class="td1">작성일</td>
			<td class="td2">${g.date }</td>
		</tr>
		<tr>
			<td colspan="2" style="background-color: white; padding: 10px;">
				<p align="center">
					<img src="file/${g.file }">
				</p>
			</td>
		</tr>
		<c:if test="${g.id == sessionScope.m.id }">
			<tr>
				<td colspan="2" align="center">
					<button id="galleryDeleteButton" onclick="fileDelete(${g.no} ,'${g.file}', ${p });">삭제</button>
				</td>
			</tr>
		</c:if>
	</table>
</body>
</html>