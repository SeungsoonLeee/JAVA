<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="loginSuccessTbl">
		<tr>
			<td rowspan="2" id="loginSuccessTd1" align="center">
				<img src="img/${sessionScope.m.photo }">
			</td>
			<td id="loginSuccessId">&nbsp;${sessionScope.m.id }</td>
		</tr>
		<tr>
			<td align="right">${sessionScope.m.name }&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="loginSuccessBtn" onclick="goMemberInfo();">정보확인</button>
				<button class="loginSuccessBtn" onclick="logout();">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>


