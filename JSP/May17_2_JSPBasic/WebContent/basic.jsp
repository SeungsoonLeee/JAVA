<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%!
	// 메소드 만들 때 사용 : 보통 head에 배치
	public int add(int x, int y) {
		return x + y;
	}
%>
</head>
<body>
	<%
		int x = 10;
		int y = 20;
		int z = add(10, 20);
	%>
	<h1>ㅋㅋㅋ</h1>
	<h2>ㅎㅎㅎ</h2>
	<%
		int a = 30;
		int b = add(a, x);
		if (a > 10){
	%>
			<h3>ㅡㅡ</h3>
	<%
		}
	%>
	<marquee><%=a %></marquee>
	<marquee><%=b %></marquee>
	<marquee><%=x %></marquee>
	<marquee><%=add(100, 200) %></marquee>

	<table border="1">
	<%
		for (int i = 1; i <= 9; i++) {
	%>
			<tr>
				<td>2 x <%=i %> = <%=2*i %></td>
			</tr>	
	<%
		}
	%>
	</table>	
	<table border="1">
	<%
		for (int dan = 2; dan <= 9; dan++){
			for (int i = 1; i <= 9; i++) {
	%>
				<tr>
					<td><%=dan %> x <%=i %> = <%=dan * i %></td>
				</tr>	
	<%
			}
		}
	%>
	</table>
	<table border="1">
	<%
		for (int i = 1; i <= 9; i++) {
	%>		
			<tr>
	<%
			for (int dan = 2; dan <= 9; dan++){
	%>
				<td><%=dan %> x <%=i %> = <%=dan * i %></td>
	<%
			}
	%>
			</tr>	
	<%
		}
	%>
	</table>
</body>
</html>







