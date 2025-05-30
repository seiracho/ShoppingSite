<%@page import="jp.co.aforce.beans.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報</title>
</head>
<body>

<%
if (session == null){
	response.sendRedirect("login-in.jsp");
	return;
}
%>

<!--session.getAttribute("last_name") で、ログイン済みの情報を取得-->
<!--JSPではsessionを暗黙で持ってるからrequest.getSession(false)は不要 -->
<!--null なら未ログインと判断してログイン画面にリダイレクト-->
<%
Login login=(Login)session.getAttribute("last_name");
if(login == null){
	response.sendRedirect("login-in.jsp");
	return;
}
%>

<ul class="member-information">
<li>
<p>
会員番号<%=login.getMember_id() %><br>
名前<%=login.getLast_name() %><%=login.getFirst_name() %><br>
住所<%=login.getAddress() %><br>
メールアドレス<%=login.getMail_address() %>
</p>
</ul>

<a href="user-menu.jsp">ホームへ戻る</a>


</body>
</html>