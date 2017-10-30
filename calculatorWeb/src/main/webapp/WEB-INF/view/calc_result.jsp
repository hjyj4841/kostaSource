<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- View : 사용자에게 응답(JSP) -->
	<%
		String resultMessage = (String)request.getAttribute("resultMessage");
	%>
	계산결과 : <%= resultMessage %>
	<p>
	<a href="/calculatorWeb/calculator_form.jsp">계산 폼</a>
	<a href="../calculator_form.jsp">계산 폼 - 상대 경로</a>
</body>
</html>