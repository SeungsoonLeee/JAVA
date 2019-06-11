<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table id="loginTable">
	<form action="LoginController" method="post" name="loginForm" onsubmit="return loginCheck();">
			<tr>
				<td align="center">
					<input value="${cookie.lastLoginID.value }" name="id" placeholder="ID" class="loginInput" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" placeholder="PW" type="password" maxlength="10" autocomplete="off" class="loginInput">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="autologin" type="checkbox">로그인 상태 유지
				</td>
			</tr>
			<tr>
				<td align="center">
					<button class="loginBtn">로그인</button>
	</form> 
					<button class="loginBtn" onclick="goJoin();">회원가입</button>
				</td>
			</tr>
			<tr>
				<td align="right" style="color:red;">${result }</td>
			</tr>
		</table>
</body>
</html>


