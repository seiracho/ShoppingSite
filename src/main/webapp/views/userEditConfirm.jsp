<%@page import="jp.co.aforce.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    UserBean user =(UserBean)session.getAttribute("user");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
<h2>登録内容は以下でよろしいですか</h2>
<form action="userEditSuccess.jsp">
	名前(姓)：<input type="text" name="last_name" value="${sessionScope.user.last_name }"><br>
	名前(名)：<input type="text" name="first_name" value="${sessionScope.user.first_name }"><br>
	住所：<input type="text" name="address" value="${sessionScope.user.address }"><br>
	メールアドレス：<input type="text" name="mail_address" value="${sessionScope.user.mail_address }"><br>
	パスワード：<input type="password" name="password" value="${sessionScope.user.password }"><br>
	
	<input type="submit" value="確定">
</form>


<form action="userEdit.jsp">
	<input type="submit" value="戻る">
</form>

</body>
</html>