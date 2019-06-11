<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>thirdV</h1>
	parameter 읽기<br>
	a : ${param.a }<p>
	
	attribute 읾기<br>
	b : ${b }<p>
	<br>
	<hr>
	second의 parameter와 attribute는 thirdV까지 넘어오지 못함<br>
	따라서 session과 cookie를 이용해야 함.<br><br>
	session 읽기<br>
	c : ${sessionScope.c }<p>
	
	cookie 읽기<br>
	d : ${cookie.d.value }<p>
</body>
</html>