<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ログイン画面</h1>
	<div class="login-typein">
		<!-- form送信→LoginServletが呼ばれる -->
		<form action="loginservlet" method="post">
			会員番号:<input type="text" name="member_id" required><br>
			パスワード:<input type="password" name="password" required>

			<div class="login-submit">
				<input type="submit" value="ログイン">
			</div>
			<a href="userAdd.jsp">新規会員登録</a>

		</form>

	</div>



</body>
</html>