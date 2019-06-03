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
	<%
		// JSTL(JSP Standard Tag Library)
		//	프로그래밍언어의 기능들을 태그형태로
		//	작업:태그형태 -> 톰캣이 자바로 바꿔서 실행
	%> 
	<h3>JSTL-core</h3>
	${a }
	<hr>
	<c:if test="${a >= 50 }">
		${a }
	</c:if>
	<c:if test="${b == 'ㅋ' }">
		${b }
	</c:if>
	<c:if test="${c == null }">
		null
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${a > 50 }">
			<h1>${a }</h1>
		</c:when>
		<c:when test="${a > 20 }">
			<h3>${a }</h3>
		</c:when>
		<c:otherwise>
			<h5>${a }</h5>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:forEach var="i" begin="0" end="5">
		${i }
	</c:forEach>
	<br>
	<%
		// step에 음수 안됨
	%>
	<c:forEach var="i" begin="1" end="10" step="2">
		${i }
	</c:forEach>
	<br>
	<select>
		<c:forEach var="y" begin="1980" end="2000">
			<option>${y }년</option>
		</c:forEach>
	</select>
	<hr>
	<c:forEach var="s" items="${ar }">
		${s }
	</c:forEach>
	<br>
	<c:forEach var="s" items="${al }">
		${s }
	</c:forEach>
	<br>
	<c:forEach var="h" items="${humans }">
		${h.name } : ${h.age }<br>
	</c:forEach>
	<hr>
</body>
</html>






