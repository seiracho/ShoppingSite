<%@page import="jp.co.aforce.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/check-session.jsp" %>
<%@ include file="/views/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user-pages.css">

</head>
<body>
<%
if(user !=null){
	%>
<h1>ホーム</h1>
<p>ようこそ、<%=user.getLast_name()+user.getFirst_name() %>さん！</p>

<a class="info-button" href="<%=request.getContextPath()%>/homepageshowservlet">ホームページへ戻る</a>

<!--会員情報確認-->
<form action="<%=request.getContextPath()%>/views/member-information.jsp" method="post">
  <input class="info-button" type="submit" value="会員情報">
</form>

<!--修正-->
<form action="<%=request.getContextPath()%>/views/userEdit.jsp" method="post">
<input type="submit" name="action" value="会員情報修正">
</form>
<!--削除-->
<form action="<%=request.getContextPath()%>/views/userDelete.jsp">
<input type="submit"  name="action" value="会員情報削除">
</form>
<!--ログアウト-->
<form action="<%=request.getContextPath()%>/views/logoutservlet" method="post">
<input type="submit" name="action" value="ログアウト">
</form>

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