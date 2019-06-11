<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Info</title>
</head>
<body>
	<table id="joinTable">
		<form action="UpdateController" method="post"
			enctype="multipart/form-data" name="memberUpdateForm"
			onsubmit="return memberUpdateCheck();">
			<tr>
				<td align="center"><input name="id"
					value="${sessionScope.m.id }" placeholder="ID" class="joinInput"
					maxlength="10" autocomplete="off" autofocus="autofocus"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td align="center"><input name="pw"
					value="${sessionScope.m.pw }" placeholder="PW" class="joinInput"
					type="password" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input name="pwChk"
					value="${sessionScope.m.pw }" placeholder="PW확인" class="joinInput"
					type="password" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input name="name"
					value="${sessionScope.m.name }" placeholder="이름" class="joinInput"
					maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><textarea name="comment" placeholder="인사말"
						class="joinTA" maxlength="100" autocomplete="off">${cmt }</textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<div class="memberUpdateFileInputDiv">
						<img id="memberUpdateImg" src="img/${sessionScope.m.photo }">
						<input name="photo" class="joinFileInput" type="file" autocomplete="off">
					</div>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button class="memberUpdateBtn" >수정</button>
		</form>
					<button class="memberUpdateBtn" onclick="secession();">탈퇴</button>
				</td>
			</tr>
			<tr>
				<td align="left" style="color:red;">${result }</td>
			</tr>
	</table>
</body>
</html>