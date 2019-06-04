<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="ProductRegController" 
		method="post" enctype="multipart/form-data"
		name="productRegForm" onsubmit="return productRegCheck();">
		<table id="snackRegTbl">
			<tr>
				<td align="right">품명</td>
				<td align="center">
					<input name="name" maxlength="10" autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="right">가격</td>
				<td align="center">
					<input name="price" maxlength="6" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="right">설명</td>
				<td align="center">
					<textarea name="desc" maxlength="90" autocomplete="off"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">사진</td>
				<td align="center">
					<input name="photo" type="file" style="font-size:12pt;">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>




