<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>SNS</title>
</head>
<body>
<font color="red">${result }</font>
	<c:if test="${sessionScope.m != null }">
		<form action="WriteController" name="snsWriteForm" onsubmit="return snsWriteCheck();">
			<input name="token" value="${token }" type="hidden">
			<table id="snsWriteTable">
				<tr>
					<td><textarea name="msg" maxlength="150" placeholder="입력"></textarea></td>
					<td><button>쓰기</button></td>
				</tr>
			</table>
		</form>
	</c:if>
	<table id="snsLoadTable">
		<tr>
			<td align="center">
				<c:forEach var="s" items="${snsMsgs }">
					<table class="snsMsg">
						<tr>
							<td rowspan="2"><img src="img/${s.photo }" width="70"></td>
							<td>ID : ${s.id } (${s.name })</td>
						</tr>
						<tr>
							<td>작성일 : ${s.date }</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp; ${s.msg }</td>
						</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<c:if test="${curPage != 1 }"><a href="SNSPageController?p=${curPage - 1 }"> ＜ </a></c:if>
				<c:forEach var="p" begin="1" end="${pageCount }">
					&nbsp;<a href="SNSPageController?p=${p }" class="snsPage">${p }</a>&nbsp;
				</c:forEach>
				<c:if test="${curPage != pageCount }"><a href="SNSPageController?p=${curPage + 1 }"> ＞ </a></c:if>
			</td>
		</tr>
	</table>
</body>
</html>