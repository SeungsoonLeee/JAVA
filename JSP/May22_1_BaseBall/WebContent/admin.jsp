<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/check.js"></script>
</head>
<body>
	<h1>ADMIN</h1>
	<form action="AdminController" name="f" onsubmit="return check();">
		<input name="n" maxlength="3" autocomplete="off" autofocus="autofocus"><p>
		<button>답 세팅</button>
	</form>
	답 : ${ans }
</body>
</html>