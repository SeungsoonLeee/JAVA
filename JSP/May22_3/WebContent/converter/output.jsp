<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
	<table id="${param.what }Table">
		<tr>
			<td align="center">결과</td>
		</tr>
		<tr>
			<td align="center">${r.n } ${r.from }</td>
		</tr>
		<tr>
			<td align="center">↓</td>
		</tr>
		<tr>
			<td align="center">${r.result } ${r.to }</td>
		</tr>
	</table>
</body>
</html>






