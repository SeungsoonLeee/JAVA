<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>May22</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/converter.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/check.js"></script>
</head>
<body>
	<table id="site">
		<tr>
			<td id="siteTitle">May22</td>
		</tr>
		<tr>
			<td id="siteMenu">
				<a href="HomeController">홈</a> 
				<a href="AController">A</a> 
				<a href="CalculatorController">사칙연산</a>
				<a href="AdminController">숫자야구(관리자)</a>				
				<a href="PlayerController">숫자야구(플레이어)</a>
				<a href="ConverterController">단위변환</a>				
				<a href="LottoController">로또</a>				
			</td>
		</tr>
		<tr>
			<td id="siteContent" valign="top">
				<jsp:include page="${contentPageHaha }"></jsp:include>
			</td>
		</tr>
	</table>

</body>
</html>





