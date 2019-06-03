<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="StarController" method="post" name="starInputForm" onsubmit="return starInputCheck();">
		<table id="starInputTable">
			<tr>
				<td align="center" id="starInputTitle">어떻게</td>
			</tr>
			<tr>
				<td align="center">
				<input name="floor" placeholder="층 수" id="starInput" autofocus="autofocus" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input type="radio" name="direction"
					value="a" class="starRadio" checked="checked">정방향&nbsp;&nbsp;&nbsp;<input type="radio" name="direction"
					value="b">역방향</td>
			</tr>
			<tr>
				<td align="center">
					<button id="starButton">출력</button>
				</td>
			</tr>
		</table>


	</form>
</body>
</html>