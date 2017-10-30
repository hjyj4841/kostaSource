<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{margin : 0 auto;}
	form{
		margin-left: 10px;
		margin-top: 30px;
	}
	select{
		height: 23px;
	}
</style>
</head>
<body>
	<form action="/calculatorWeb/form/calculate" method="post">
		<h1>계산 폼</h1><br>
		<p>
		<% if(request.getAttribute("error_message") != null) { %>
			<%= request.getAttribute("error_message") %>
		<% } %>
		</p>
		<input type="text" name="num1"> 
		<select name="operator"> <!-- 선택할 Item들을 묶어주는 역할. -->
			<option>더하기</option>
			<option>빼기</option>
			<option>곱하기</option>
			<option>나누기</option>
		</select>
		<input type="text" name="num2"><br><br>
		<input type="submit" value="계산">
	</form>
</body>
</html>