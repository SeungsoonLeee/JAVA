<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${contentPage == 'jc.jsp' }">
	<c:redirect url="warning.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>May23</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/gallery.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/check.js"></script>
</head>
<body>
	<table id="siteMenuArea">
		<tr>
			<td align="center">
				<table id="siteMenu">
					<tr>
						<td>
							<a href="GalleryController">갤러리</a>
							<a href="JCController">JSTL-core</a>
							<a href="JFController">JSTL-formatting</a>
							<a href="JoinController">회원가입</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	<table id="site">
		<tr>
			<td id="siteTitle">
				<a href="HomeController">May23</a>
			</td>
		</tr>
		<tr>
			<td id="siteContent">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>


