<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
</head>
<body>
	<h1>新規会員登録</h1>
	<div class="typein">
<!--	受け取ってくれuseraddservlet..  -->
	<form action="useraddservlet" method="post">
	ユーザーID：<input type="text" name="member_id" required><br>
	パスワード<input type="password" name="password" required><br>
	名前(姓)：<input type="text" name="last_name" required><br>
	名前(名)：<input type="text" name="first_name" required><br>
	住所：<input type="text" name="address" required><br>
	メールアドレス：<input type="text" name="mail_address" required><br>
	<input type="submit" value="確認">
	</form>
	<a href="login-in.jsp">ログイン画面に戻る</a>
	
	</div>


</body>
</html>