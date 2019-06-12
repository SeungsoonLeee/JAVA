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
	<form action="SearchController" name="snsSearchForm" onsubmit="return snsSearchCheck();">
		<table id="snsWriteTable">
			<tr>
				<td align="right"><input name="search" maxlength="150"
					placeholder="검색"></td>
				<td><button>검색</button></td>
			</tr>
		</table>
	</form>
	<table id="snsLoadTable">
		<tr>
			<td align="center"><c:forEach var="s" items="${snsMsgs }">
					<table id="snsMsgTable">
						<tr>
							<td rowspan="2" align="center" width="100px"><img src="img/${s.photo }"></td>
							<td>${s.id }(${s.name })</td>
						</tr>
						<tr>
							<td>작성일 : ${s.date }</td>
						</tr>
						<tr>
							<td colspan="2" class="snsMsg">${s.msg }</td>
						</tr>
						<c:if test="${s.id == sessionScope.m.id }">
							<tr>
								<td colspan="2" align="right">
									<button onclick="updateMsgJS(${s.no }, '${s.msg }', ${curPage });">JS로 수정</button>
									<button onclick="goModifyMsg(${s.no });">수정</button>
									<button onclick="deleteMsg(${s.no });">삭제</button>
								</td>
							</tr>
						</c:if>
					</table>
				</c:forEach></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<c:if test="${curPage != 1 and curPage != null }"><a href="SNSPageController?p=${curPage - 1 }"> ＜ </a></c:if>
				<c:forEach var="p" begin="1" end="${pageCount }">&nbsp;<a href="SNSPageController?p=${p }" class="snsPage">${p }</a>&nbsp;</c:forEach>
				<c:if test="${curPage != pageCount and pageCount != null}"><a href="SNSPageController?p=${curPage + 1 }"> ＞ </a></c:if>
			</td>
		</tr>
	</table>
</body>
</html>