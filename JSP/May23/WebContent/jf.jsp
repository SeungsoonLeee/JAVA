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
	<h3>JSTL-formatting</h3>
	<fmt:formatNumber value="${n }" type="number" /><p>
	<fmt:formatNumber value="${money }" type="currency" /><p>
	<fmt:formatNumber value="${rate }" type="percent" /><p>
	<fmt:formatNumber value="${n2 }" pattern="#.00" /><p>
	<fmt:formatNumber value="${n2 }" pattern="#,###.00" />
	<hr>
	<fmt:formatDate value="${now }" type="date" dateStyle="long"/><p>
	<fmt:formatDate value="${now }" type="time" timeStyle="short"/><p>
	<fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="short"/><p>
	<fmt:formatDate value="${now }" pattern="yyyy/MM/hh"/>
	
</body>
</html>





