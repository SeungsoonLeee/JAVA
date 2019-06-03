<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${member.name }<hr>
	${member.age }<hr>
	${member.gender }<hr>
	${member.introduce }<hr>
	${member.weight }<hr>
	
	<img src="photo/${member.photo }"><hr>
	<fmt:formatDate value="${member.birthday }" 
			type="date" dateStyle="long"/><hr>
			 
	<c:forEach var="v" items="${member.vehicle }">
		${v }
	</c:forEach><hr>
	
	<fmt:formatNumber value="${member.height }" 
		pattern="#.0"/><hr> 
		
	<fmt:formatNumber value="${member.bimando }"
		type="percent"/><hr> 
</body>
</html>