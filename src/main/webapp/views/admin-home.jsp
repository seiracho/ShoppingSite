<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用ホームページ</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin-page.css">
</head>
<body>
<!--ログアウト-->
<form action="<%=request.getContextPath()%>/views/logoutservlet" method="post">
<input type="submit" name="action" value="ログアウト">
</form>

<form action="<%= request.getContextPath() %>/adminitemlistservlet" method="post">
<input type="submit" value="商品情報管理">
</form>

<form action="<%= request.getContextPath() %>/adminuserservlet" method="post">
<input type="submit" value="会員情報管理">
</form>
<form action="<%= request.getContextPath() %>/adminorderservlet" method="post">
<input type="submit" value="商品購入履歴閲覧">
</form>



</body>
</html>