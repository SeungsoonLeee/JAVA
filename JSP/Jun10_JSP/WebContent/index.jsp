<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<link rel="stylesheet" href="css/sns.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript" src="js/go.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td align="center" id="siteMenuArea">
				<table id="siteMenuArea2">
					<tr>
						<td align="center"><a href="SNSController">SNS</a></td>
						<td align="center"><a href="">?</a></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center" id="siteTitleArea2">
				<a href="HomeController">JSP Home</a>
			</td>
		</tr>
	</table>
	<table id="siteLoginArea">
		<tr>
			<td><jsp:include page="${loginPage }"/></td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td><jsp:include page="${contentPage }"/></td>
		</tr>
	</table>
</body>
</html>
