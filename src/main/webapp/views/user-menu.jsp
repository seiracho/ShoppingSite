<%@page import="jp.co.aforce.beans.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<!--Sessionに保存したユーザー情報の取り出し-->
<% Login login=(Login)session.getAttribute("last_name"); %>
<h1>ホーム</h1>
<p>ようこそ、<%=login.getLast_name() %>さん！</p>

<form action="" method="post">
<input type="submit" name="action" value="修正">
<input type="submit"  name="action" value="削除">
</form>

<form action="logoutservlet" method="post">
<input type="submit" name="action" value="ログアウト">
</form>

<a href="member-information.jsp">会員情報</a>


</body>
</html>