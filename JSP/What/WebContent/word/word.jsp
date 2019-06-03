<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	setTimeout(function(){
		gameover();
	}, 3000);
</script>
</head>
<body>
	<table id="wordInputTable">
		<tr>
			<td align="center" id="preSay">
				${preSay }
			</td>
		</tr>
		<tr>
			<td align="center">
				<form action="WordController" name="wordInputForm" onsubmit="return wordInputCheck();">
					<input id="wordInput" name="say" autofocus="autofocus" autocomplete="off">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>