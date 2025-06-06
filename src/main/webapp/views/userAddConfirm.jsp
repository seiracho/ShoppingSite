<%@page import="jp.co.aforce.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>登録内容は以下でよろしいですか</h2>
<form action="userAddSuccess.jsp" method="post">
	ユーザーID：<input type="text" name="member_id" value="${newUserBean.member_id }"><br>
	名前(姓)：<input type="text" name="last_name" value="${newUserBean.last_name }"><br>
	名前(名)：<input type="text" name="first_name" value="${newUserBean.first_name }"><br>
	住所：<input type="text" name="address" value="${newUserBean.address }"><br>
	メールアドレス：<input type="text" name="mail_address" value="${newUserBean.mail_address }"><br>
	パスワード：<input type="password" name="password" value="${newUserBean.password }"><br>

	<input type="submit" value="確定">

</form>


</body>
</html>