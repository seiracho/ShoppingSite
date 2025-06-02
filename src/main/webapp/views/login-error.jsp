<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>IDもしくはパスワードが違います</p>

	<!--戻るボタンで再度ログイン画面へ遷移-->
	<form action="login-in.jsp" method="post">
		<input type="submit" value="ログイン画面へ戻る">

	</form>
	
</body>
</html>