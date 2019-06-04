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
	<form action="DTController" method="post">
		품명 : <input name="p_name"><p>
		<button>삭제</button>
	</form>
</body>
</html>

