<%@page import="jp.co.aforce.beans.UserBean"%>
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
<%
UserBean user=(UserBean)session.getAttribute("user");
if(user !=null){
	%>
<h1>ホーム</h1>
<p>ようこそ、<%=user.getLast_name()+user.getFirst_name() %>さん！</p>

<!--修正-->
<form action="userEdit.jsp" method="post">
<input type="submit" name="action" value="修正">
</form>
<!--削除-->
<form action="userDelete.jsp">
<input type="submit"  name="action" value="削除">
</form>
<!--ログアウト-->
<form action="logoutservlet" method="post">
<input type="submit" name="action" value="ログアウト">
</form>
<!--会員情報確認-->
<a href="member-information.jsp">会員情報</a>

<%
}else{
	%>
	
	<p>ログイン情報が見つかりません。ログインし直してください。</p>
	<a href="login-in.jsp">ログイン画面に戻る</a>
<%
}
%>


</body>
</html>