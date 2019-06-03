<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table {
	float: left;	
}
</style>
</head>
<body>
	<c:forEach var="dan" begin="2" end="9">
		<table border="1">
			<c:forEach var="i" begin="1" end="9">
				<tr>
					<td>${dan } x ${i } = ${dan*i }</td>
				</tr>
			</c:forEach>
		</table>
	</c:forEach>
</body>
</html>






