<%@page import="jp.co.aforce.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user-pages.css">

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
UserBean login=(UserBean)session.getAttribute("user");
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




<a class="info-button" href="user-menu.jsp">メニュー画面に戻る</a>


</body>
</html>