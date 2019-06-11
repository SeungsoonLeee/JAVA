<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	function goSecond(){
		location.href = "secondC?a=20";
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>firstV</h1>
	get방식 요청의 방법<hr>
	1. a태그<br>
	<a href="secondC?a=10">Second로</a>
	<hr>
	2. 자바스크립트<br>
	<button onclick="goSecond()">Second로</button>
	<hr>
	3. form 태그<br>
	<form action="secondC">
		<input name="a">
		<button>Second로</button>
	</form>
</body>
</html>