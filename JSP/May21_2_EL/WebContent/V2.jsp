<%@page import="java.util.ArrayList"%>
<%@page import="com.kwon.el.main.Human"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>V2</h1>
	<%
		String pt = request.getParameter("plainText");
	
		String n = request.getParameter("number");
		Integer n2 = Integer.parseInt(n);
		int n3 = n2.intValue();
		
		String[] cb = request.getParameterValues("cb");
	
		Object pt2 = request.getAttribute("pt2");
		String pt22 = (String) pt2;
		
		Object hh = request.getAttribute("hh");
		Human hh2 = (Human) hh;
		
		Object ar = request.getAttribute("ar");
		String[] ar2 = (String[]) ar;
		
		Object al = request.getAttribute("al");
		ArrayList<String> al2 = (ArrayList<String>) al;
		
		Object humans = request.getAttribute("humans");
		ArrayList<Human> humans2 
			= (ArrayList<Human>) humans;
	%>
	<%=humans2.get(0).getName() %>
	
	<%=al2.get(0) %> <%=al2.get(1) %><br>
	<%=ar2[0] %> <%=ar2[1] %><br>
	hh name : <%=hh2.getName() %><br>
	hh age : <%=hh2.getAge() %><br>
	pt2 : <%=pt22 %><br>
	plainText : <%=pt %><br> 
	number : <%=n3 + 100 %><br> 
	cb :
	<%
		if (cb != null) {
			for (String s : cb) {
	%>
				<%=s %>
	<%
			}
		}
	%>
	<hr>
	<%
		// 한글처리(x) : M쪽에서
		// 계산, ...(x) : M쪽에서

		// 조건문, 반복문 : 커스텀태그
		// 값 받기 : EL 
		// EL(Expression Language)
		//		${??? } => 톰캣이 자바코드로 바꿔서 실행
		//		형변환 자동
		//		연산자 사용 가능
		//		null값처리 알아서
		//		import필요없음
		
		// 	parameter : ${param.파라메터명}
		//	parameter(checkbox) 
		//		: ${paramValues.파라메터명[인덱스]}
		
		//  attribute : ${어트리뷰트명}
		//	attribute(객체) : ${어트리뷰트명.멤버변수명} -> getter호출
		//	attribute([]) or attribute(List)
		//		: ${어트리뷰트명[인덱스] }
		// 	attribute(List<객체>)
		//		: ${어트리뷰트명[인덱스].멤버변수명}
		
		// session : ${sessionScope.어트리뷰트명}
		
		// cookie : ${cookie.이름.value}
	%>
	${sessionScope.str}<br>
	${cookie.c.value}<br>
	${humans[0].name}<br>
	${al[0] } ${al[1] }<br>
	${ar[0] } ${ar[1] }<br>
	plainText : ${param.plainText }<br> 
	number : ${param.number + 100 }<br>
	cb : ${paramValues.cb[0] } ${paramValues.cb[1] }<br>
	pt2 : ${pt2 }<br>
	n2 : ${n2Haha * 2 }<br>
	hh name : ${hh.name }<br>
	hh age : ${hh.age }<br>
</body>
</html>





