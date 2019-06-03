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
	<h3 id="photoUploadTitle">사진 업로드</h3>
	<form action="GalleryController" 
		name="photoUploadForm" 
		onsubmit="return photoUploadCheck();"
		method="post"
		enctype="multipart/form-data">
		<input name="photo" type="file">
		<button id="photoUploadBtn">업로드</button>
	</form>
	<p align="right" id="photoUploadResult">${r }</p>
	<hr> 
	
	<c:forEach var="f" items="${files }">
		<img src="photo/${f }">
	</c:forEach>
	
</body>
</html>



