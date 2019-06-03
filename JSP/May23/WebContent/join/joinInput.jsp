<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="JoinController" 
	name="joinForm" 
	onsubmit="return joinCheck();"
	method="post" enctype="multipart/form-data">
		이름 :
		<input name="n" 
			maxlength="10"
			autofocus="autofocus"
			autocomplete="off">
		<hr>
		생년월일 :
		<select name="y">
			<c:forEach var="y" begin="1980" end="2010">
				<option>${y }</option>
			</c:forEach>
		</select>년
		<select name="m">
			<c:forEach var="m" begin="1" end="12">
				<option>${m }</option>
			</c:forEach>
		</select>월
		<select name="d">
			<c:forEach var="d" begin="1" end="31">
				<option>${d }</option>
			</c:forEach>
		</select>일
		<hr>
		성별 : 
		<input type="radio" name="g" value="남자" checked="checked">남자
		<input type="radio" name="g" value="여자">여자
		<hr>
		교통수단 : 
		<input type="checkbox" name="v" value="버스">버스
		<input type="checkbox" name="v" value="지하철">지하철
		<input type="checkbox" name="v" value="기타">기타
		<hr>
		자기소개 : <br>
		<textarea name="i" maxlength="150"></textarea>
		<hr>
		키 : <input name="h">
		<hr>
		몸무게 : <input name="w">
		<hr>
		사진 : <input name="p" type="file">
		<hr>
		<button>가입</button>	
	</form>
</body>
</html>




