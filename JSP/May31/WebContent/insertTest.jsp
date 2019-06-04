<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${result }
	<form action="ITController" method="post">
		품명 : <input name="p_name"><p>
		가격 : <input name="p_price"><p>
		<button>등록</button>
	</form>
</body>
</html>

