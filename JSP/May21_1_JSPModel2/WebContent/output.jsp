<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<table>
		<tr>
			<td align="center">결과</td>
		</tr>
		<tr>
			<td align="center"><img src="photo/${hh.fileName }"></td>
		</tr>
		<tr>
			<td align="center">이름 : ${hh.name }</td>
		</tr>
		<tr>
			<td align="center">키 : ${hh.height }</td>
		</tr>
		<tr>
			<td align="center">몸무게 : ${hh.weight }</td>
		</tr>
		<tr>
			<td align="center">표준체중 : ${hh.stdWeight }</td>
		</tr>
		<tr>
			<td align="center">비만도: ${hh.bimando }</td>
		</tr>
		<tr>
			<td align="center">${hh.result }</td>
		</tr>
	</table>
</body>
</html>





