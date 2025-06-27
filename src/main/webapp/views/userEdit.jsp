<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報編集</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user-pages.css">
</head>
<body>
<h1>会員情報編集</h1>
	<div class="typein">
	<form action="usereditservlet" method="post">
<!--	非表示フィールドで送信  -->
	<input type="hidden" name="member_id" value="${user.member_id }" required>
<!--	入力項目  -->
	名前(姓)：<input type="text" name="last_name" value="${user.last_name }" required><br>	
	名前(名)：<input type="text" name="first_name" value="${user.first_name }" required><br>
	住所：<input type="text" name="address" value="${user.address }" required><br>
	メールアドレス：<input type="email" name="mail_address" value="${user.mail_address }" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"><br>
	パスワード：<input type="password" name="password" value="${user.password }" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"
       title="8文字以上で英字と数字を含めてください" required><br>
	<input type="submit" value="確認"><br>
	</form>
	<a class="info-button" href="user-menu.jsp">メニュー画面に戻る</a>
	
	</div>


</body>
</html>