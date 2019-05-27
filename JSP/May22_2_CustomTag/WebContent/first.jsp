<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>first</h1>
	<%
		// 대부분의 업무 : M에서 
		// 값 받기 : EL
		// 페이지 이동
		//		자동 이동 :
		//			redirect, include
		// 반복문, 조건문
		// 출력형식 지정
	%>
	
	<%
		// CustomTag
		//		.jsp에서만 쓸수있는 태그
		//		작업할때는 HTML태그모양 
		//			=> 톰캣이 자바로 바꿔서 실행
		//		<접두어:태그명>형태
		
		//	JSP표준액션태그 : jsp환경에서 기본 사용
		//		접두어 : jsp
		//		include 
		//			=> 그 위치에 include당하는 파일 소스 넣어줌
		
		//	CustomTag : 외부 .jar파일 넣고 사용
	%>
	ㅋㅋㅋ
	<jsp:include page="second.jsp"></jsp:include>
</body>
</html>






