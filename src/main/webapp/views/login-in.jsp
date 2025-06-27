<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user-pages.css">

</head>
<body>
	<h1>ログイン画面</h1>
	<p>商品購入には会員登録/ログインが必要です</p>
	<div class="login-typein">
		<!-- form送信→LoginServletが呼ばれる -->
		<form action="<%=request.getContextPath()%>/views/loginservlet" method="post">
			会員番号:<input type="text" name="member_id" required><br>
			パスワード:<input type="password" name="password" required>

			<div class="login-submit">
				<input type="submit" value="ログイン">
			</div>
			<a href="<%=request.getContextPath()%>/views/userAdd.jsp">新規会員登録</a>
		</form>
	</div>
<a class="info-button" href="<%=request.getContextPath()%>/homepageshowservlet">ホームページへ戻る</a>


</body>
</html>